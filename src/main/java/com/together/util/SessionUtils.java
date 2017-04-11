package com.together.util;

/**
 * Created by BRF on 2016-11-11.
 */
import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能说明：用来存储业务定义的sessionId和连接的对应关系
 * 利用业务逻辑中组装的sessionId获取有效连接后进行后续操作
 */
public class SessionUtils {

    public static Map<Object, Session> clients = new ConcurrentHashMap<>();

    public static void put(Object ID, Session session){
        clients.put(ID, session);
    }

    public static Session get(Object ID){
        return clients.get(ID);
    }

    public static void remove(Object ID){
        clients.remove(ID);
    }

    /**
     * 判断是否有连接
     * @param ID
     * @return
     */
    public static boolean hasConnection(Object ID) {
        return clients.containsKey(ID);
    }
}
