package com.client.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import com.common.*;

import javax.xml.ws.handler.MessageContext;

import com.common.*;

public class ClientUser {

	public Socket socket;
	static public Vector<String> onlineFriendStrings;
	//send first request
	public boolean sendLoginInfoToServer(Object o) {
		boolean b = false;
		try {
			System.out.print("ClientUser");
			 socket = new Socket("127.0.0.1", 5555);
			 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			 oos.writeObject(o);
			 
			 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			 Messages messages = (Messages)ois.readObject();
			 System.out.println("mesType = "+messages.getMessType());
			 if(messages.getMessType().equals("1")) {
				 //create socket
				 this.onlineFriendStrings = messages.getOnlineFriends();
				 ClientConServerThread clientConServerThread = new ClientConServerThread(socket);
				 ManageClientConServerThread.addClientConServerThread(((User)o).getUserName(), clientConServerThread);
//				 System
				 clientConServerThread.start();
				 b = true;
			 }
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			 
		}
		return b;
	}
	
	public void sendInfoToServer(Object o) {
		boolean b = false;
		try {
			 Socket socket = new Socket("127.0.0.1", 5555);
			 
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			 
		}
	}
}
