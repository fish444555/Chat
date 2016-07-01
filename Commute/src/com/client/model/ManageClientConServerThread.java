/*
 * manage the threads between client & server
 */


package com.client.model;

import java.util.*;

public class ManageClientConServerThread {

	static public HashMap hashMap = new HashMap<String, ClientConServerThread>();
	static public void addClientConServerThread(String Id, ClientConServerThread clientConServerThread) {
		System.out.print("Id = "+ Id);
		System.out.print("clientConServerThread = "+ clientConServerThread.getSocket().toString());
		hashMap.put(Id, clientConServerThread);
	}
	
	static public ClientConServerThread getClientConServerThread(String idString) {
		return (ClientConServerThread)hashMap.get(idString);
	}
}
