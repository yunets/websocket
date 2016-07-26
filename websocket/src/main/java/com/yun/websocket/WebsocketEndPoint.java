/**
 *Project Name: websocket
 *File Name:    WebsocketEndPoint.java
 *Package Name: com.yun.websocket
 *Date:         2016年7月26日 上午10:56:02
 *Copyright (c) 2016,578888218@qq.com All Rights Reserved.
*/

package com.yun.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *Title:      WebsocketEndPoint<br/>
 *Description:
 *@Company:   青岛励图高科<br/>
 *@author:    刘云生
 *@version:   v1.0
 *@since:     JDK 1.7.0_80
 *@Date:      2016年7月26日 上午10:56:02 <br/>
*/
@ServerEndpoint("/websocket.ws/{relationId}/{userCode}")
public class WebsocketEndPoint {
	private Session Serversession;


	@OnOpen
	 public void onOpen(@PathParam("relationId") String relationId, 
			 @PathParam("userCode") int userCode,
			 Session session){
		Serversession = session;
	}
	
	@OnMessage
	 public String onMessage(String message) {
		System.out.println("接收到客户端请求：("+ message +").Thanks !");
		for(int i = 0;i<100;i++){
			try {
				Serversession.getBasicRemote().sendText(i+"");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				System.out.println("客户端关闭**********");
				e.printStackTrace();
			}
		}
//		try {
//			Serversession.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "服务端已经接收到你的请求： ("+ message +").Thanks !";
	}
	
	@OnError
	 public void onError(Throwable throwable,Session session) {
	 
	}

	
	@OnClose
	 public void onClose(Session session) {
		System.out.println("关闭");
	}
}

