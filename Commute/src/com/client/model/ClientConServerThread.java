/*
 * server & client communication thread 
 */

package com.client.model;

import java.net.Socket;
import java.io.*;
import java.net.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.client.view.Friends;
import com.common.Messages;

public class ClientConServerThread extends Thread{

	
	private Socket socket;
	
	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}


	public ClientConServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	

	public void run() {
		while (true) {
			try {
				if(this.socket.isClosed() == false) {
					ObjectInputStream oisInputStream = new ObjectInputStream(this.socket.getInputStream());
					Messages messages = (Messages)oisInputStream.readObject();
					System.out.println("get new info from server");
					System.out.println("get new info from server");
					if(messages.getMessType() != null && messages.getMessType().equals("1") && messages.getOnlineFriends() != null) {
						System.out.println("enter ");
						for (int i = 0; i < Friends.jlbs.length; i++) {
							int pos = messages.getOnlineFriends().indexOf(
									i + 1 + "");
							if (pos != -1) {
								Friends.jlbs[i].setEnabled(true);
							}
							else {
								Friends.jlbs[i].setEnabled(false);
							}
						}					
					}
					else {
						ManageChatDiag.getManageChatDiag(messages.getSender()).showContent(messages);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}


	
	
}
