

package com.client.model;

import java.util.HashMap;

import com.client.view.Chat;

public class ManageChatDiag {

	static private HashMap<String, Chat> hashMap = new HashMap<String, Chat>();
	
	static public void addManageChatDiag(String FID, Chat chat) {
		hashMap.put(FID, chat);
	}
	
	static public Chat getManageChatDiag (String FID) {
		return hashMap.get(FID);
	}
}
