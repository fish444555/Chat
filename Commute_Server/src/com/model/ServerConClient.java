/*
 * Server connect to one client
 */

package com.model;

import java.net.*;
import java.io.*;

import com.common.Messages;

public class ServerConClient extends Thread{

	Socket socket;
	
	public ServerConClient(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	public void run() {
		while (true) {
			try {
				if (socket.getInputStream() != null ) {
					
//					System.out.println("socket.getInputStream() : "+socket.getInputStream());
//					System.out.println("..............");
//					System.out.println("socket is isInputShutdown = "+ socket.isInputShutdown());
//					System.out.println("socket is isOutputShutdown = "+ socket.isOutputShutdown());
//					System.out.println("socket is isclose = "+ socket.isClosed());
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					Messages messages = (Messages)ois.readObject();
					
					System.out.print("sender : "+messages.getSender());
					System.out.print("   content : "+messages.getContent());
					System.out.println("   receiver : "+messages.getReceiver());
					ServerConClient mct = ManageClientThread.getClientThread(messages.getReceiver());
					if(mct == null) {
						System.out.println("not present");
					}
					else {
						ObjectOutputStream oos = new ObjectOutputStream(mct.socket.getOutputStream());
						oos.writeObject(messages);
					}
					
				}	
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
