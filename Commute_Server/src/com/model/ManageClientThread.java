package com.model;

import java.util.HashMap;

public class ManageClientThread {
	
	
	public static HashMap hMap = new HashMap<String, ServerConClient>();
	
	static public void addClientThread(String user, ServerConClient sClient) {
		hMap.put(user, sClient);
	}
	
	static public ServerConClient getClientThread(String user) {
		return (ServerConClient) hMap.get(user);
	}
}
