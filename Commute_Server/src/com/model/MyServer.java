package com.model;


import java.net.*;
import java.io.*;
import java.util.*;

import com.common.Messages;
import com.common.User;

public class MyServer {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MyServer myServer = new MyServer();
//	}
	public Socket socket;
	public MyServer() {
		
		try {
			System.out.println("server ready");
			ServerSocket ss = new ServerSocket(5555);
			
			while (true) {
				socket = ss.accept();
				if(socket.getInputStream() != null) {
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					User user = (User)ois.readObject();
					Messages mes = new Messages();
					
					System.out.println("Server get id is : "+user.getUserName()+"   pw : "+user.getPasswd());
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					if(user.getPasswd().equals("123")) {
						mes.setMessType("1");				
						 					
						//create thread to connect with client
						ServerConClient scc = new ServerConClient(socket);
						ManageClientThread.addClientThread(user.getUserName(), scc);
						scc.start();
						Map<String, ServerConClient> map = ManageClientThread.hMap;
	//					System.out.println("On online people");
						Vector<String> onlineFriendsStrings = new Vector<String>();
						for (String key : map.keySet()) {
							onlineFriendsStrings.add(key);
						}
						mes.setOnlineFriends(onlineFriendsStrings);
						oos.writeObject(mes);
						
						for (String key : map.keySet()) {
							if(!(socket.toString().equals(ManageClientThread.getClientThread(key).socket.toString()))) {
								oos = new ObjectOutputStream(ManageClientThread.getClientThread(key).socket.getOutputStream());
								oos.writeObject(mes);
								System.out.println("send to user "+key);
							}
						}
	 				}
					else {
						mes.setMessType("2");
						oos.writeObject(mes);
						socket.close();
					}
				}
				
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			this.socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
