package ink.carnation.imtalk.websocket;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
@ServerEndpoint("/webSocket/{userId}")
@Component
public class WebSocketServer {

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * concurrent包的线程安全Map，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static Map<String,Session> webSocketMap = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session,@PathParam   ("userId") String userId) {

        if(!webSocketMap.containsKey(userId)){
            webSocketMap.put(userId,session);
            onlineCount.getAndIncrement();

        }
        log.info("用户连接:"+userId+",当前在线人数为:" + onlineCount.get());

        try {
            sendMessage("连接成功",session);
        } catch (IOException e) {
            log.error("用户:"+userId+",网络异常!!!!!!");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam(value = "userId") String userId,Session session) throws IOException {
        webSocketMap.remove(userId);
        onlineCount.decrementAndGet();
        session.close();
        log.info("用户退出:"+userId+",当前在线人数为:" + onlineCount.get());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message,Session thisSession) {
        //WebSocketMessage object = JSONObject.parseObject(message, WebSocketMessage.class);
        //if(object.getToUserId() !=null){

        //}
        //else
        for(Session session : webSocketMap.values()){
            log.info("sessionId:" +session.getId());
            try {
                sendMessage(message,session);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }

    }
    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {

        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message,Session session) throws IOException {
        session.getBasicRemote().sendText(message);
    }



}