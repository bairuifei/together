package com.together.websocket;

import com.together.model.po.Location;
import com.together.service.LocationService;
import com.together.util.SessionUtils;
import com.together.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by BRF on 2017-04-06.
 */
@ServerEndpoint("/locationWebSocket/{myId}")
@Component
public class LocationWebSocket {
    Logger logger = LoggerFactory.getLogger(LocationWebSocket.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("myId") int myId){
        SessionUtils.put(myId,session);
        logger.info("有新加入连接！当前在线人数为："+SessionUtils.clients.size());
    }

    @OnClose
    public void onClose(@PathParam("myId") int myId){
        SessionUtils.remove(myId);
        logger.info("有连接关闭！当前在线人数为："+SessionUtils.clients.size());
    }

    @OnMessage
    public void onMessage(String msg,@PathParam("myId") int myId){
        // TODO: 2017-04-11 客户端上传位置消息内容格式要求：0:1 （lat:lng）
        logger.info("来自客户端消息："+msg);
//        保存位置信息
        String[] dus = msg.split(":");
        Location location = new Location();
        location.setMyId(myId);
        location.setLat(dus[0]);
        location.setLng(dus[1]);
        SpringUtil.getBean(LocationService.class).saveLocation(location);
    }

    @OnError
    public void onError(Session session, Throwable error,@PathParam("myId") int myId){
        SessionUtils.remove(myId);
        logger.info("发生错误");
        error.printStackTrace();
    }

    public void sendMessage(String message,Session session) {
//        同步消息发送（可能会阻塞）
//        session.getBasicRemote().sendText(message);
//        异步消息发送（推荐）
        session.getAsyncRemote().sendText(message);
    }
}
