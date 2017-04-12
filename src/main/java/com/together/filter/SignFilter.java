package com.together.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.together.model.ResultInfo;
import com.together.model.enumes.ServerMsgEnum;
import com.together.util.RSA_Encrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by BRF on 2017-04-12.
 * 拦截所有请求
 */
@WebFilter(filterName = "signFilter",urlPatterns = {"/invite/*","/local/*","/person/*"},asyncSupported = true)
//@WebFilter(filterName = "signFilter",urlPatterns = {"/*"},asyncSupported = true)
public class SignFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(SignFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("signFilter初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("执行过滤");
        String sign = servletRequest.getParameter("sign");
        String data = reformat(servletRequest);
        boolean isOk = false;
        try {
            isOk = RSA_Encrypt.verify(data.getBytes(),RSA_Encrypt.getpublickey(),sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isOk){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.FILTER_ERROR.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.FILTER_ERROR.getServerMsg());
            servletResponse.setContentType("text/json;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            Gson gson = new Gson();
            out.write(gson.toJson(resultInfo));
            out.flush();
            out.close();
        }
    }

    private void oldMind() {
    /* TODO: 2017-04-12 此后请求参数只有两个1、info：密文 2、key：客户端随机生成的DES秘钥（经过RSA公钥加密）
    // TODO: 2017-04-12 客户端获得随机DES秘钥并按照要求加密内容通过info传递，同时将随机DES秘钥通过RSA公钥加密通过key传递
    // TODO: 2017-04-12 客户端按照要求将请求内容格式化并加密发送（key1:val1,key2:val2,key3:val3）
    // TODO: 2017-04-12 服务端拿到key进行RSA私钥解密获得随机DES秘钥，并使用DES秘钥对密文进行解密并按照格式拆分重新恢复请求内容
    String key = servletRequest.getParameter("key");
    try {
        key = RSA_Encrypt.decrypt(key);
    } catch (Exception e) {
        e.printStackTrace();
    }
    String info = servletRequest.getParameter("info");
    try {
        info = DES_Encrypt.decrypt(info,key);
    } catch (Exception e) {
        e.printStackTrace();
    }
    //重新解析参数列表
    Map map = reformat(info);
    Map oldMap = servletRequest.getParameterMap();
    try {
        Field locked = oldMap.getClass().getDeclaredField("locked");
        locked.setAccessible(true);//打开访问权限
        locked.setBoolean(oldMap,false);//将lock参数设置为false了，就是可以修改了
        oldMap.putAll(map);
        locked.setBoolean(oldMap,true);
    } catch (NoSuchFieldException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }*/
    }

    @Override
    public void destroy() {
        logger.info("signFilter销毁...");
    }

    public String reformat(ServletRequest servletRequest){
        StringBuffer sb = new StringBuffer("");
        Map map = servletRequest.getParameterMap();
        Enumeration<String> enumeration = servletRequest.getParameterNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            if(!name.equals("sign")){
                String[] str = (String[]) map.get(name);
                sb.append(name).append(":").append(str[0]).append(",");
            }
        }
        return sb.substring(0,sb.toString().length()-1);
    }
}
