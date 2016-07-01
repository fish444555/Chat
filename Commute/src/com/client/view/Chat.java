package com.client.view;

import javax.swing.*;

import com.client.model.ClientUser;
import com.client.model.ManageChatDiag;
import com.client.model.ManageClientConServerThread;
import com.common.Messages;
import com.common.User;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Chat extends JFrame implements ActionListener, WindowListener{

	public JTextArea jTextArea;
	JTextField jTextField;
	JButton jButton;
	JPanel jPanel;
	private String UserName;
	private String friendName;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chat chat = new Chat("adfs","fdas");
		
	}

	public Chat(String UserName, String friendName) {
//		this.UserName = UserName;
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e){
//				JOptionPane.showMessageDialog(null, "asfddddddddddddddddd");
//				ManageClientConServerThread.hashMap.get(this.UserName);
//				System.exit(0);
//			}
//		});

		this.UserName = UserName;
		this.friendName = friendName;
		JScrollPane jsp;
		jTextArea = new JTextArea();
		jTextField = new JTextField(15);
		jButton = new JButton("send");
//		jPanel.add(jTextArea);
		jButton.addActionListener(this);
		jPanel = new JPanel();
		jPanel.add(jTextField);
		jPanel.add(jButton);
		jsp = new JScrollPane(jTextArea);
		this.add(jsp,"Center");
		this.add(jPanel,"South");
		this.setTitle(this.UserName+" chat with "+this.friendName);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		addWindowListener(this);
	}
	
	protected void finalize() {
		try {
			super.finalize();
			System.out.println("asfdfadsfds");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showContent(Messages messages) {
		String infoString = messages.getSender() +" say to " + messages.getReceiver() + " : \r\n";
		infoString += messages.getContent()+" \r\n";
		this.jTextArea.append(infoString);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButton) {
			Messages messages = new Messages();
			messages.setSender(this.UserName);
			messages.setReceiver(this.friendName);
			messages.setContent(jTextField.getText());
			messages.setTime(new Date().toString());
			try {
				ObjectOutputStream oosObjectOutputStream = new ObjectOutputStream
				(ManageClientConServerThread.getClientConServerThread(this.UserName).getSocket().getOutputStream());
				oosObjectOutputStream.writeObject(messages);
				String infoString = messages.getSender() +" say to " + messages.getReceiver() + " : \r\n";
				infoString += messages.getContent()+" \r\n";
				this.jTextArea.append(infoString);
				this.jTextField.setText("");
				
				oosObjectOutputStream = new ObjectOutputStream
				(ManageClientConServerThread.getClientConServerThread(this.UserName).getSocket().getOutputStream());
				messages = new Messages();
				messages.setClosedBoolean(true);
				oosObjectOutputStream.writeObject(messages);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.print("close......................");
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while (true) {
//			try {
//				ObjectInputStream ois = new ObjectInputStream(ManageClientConServerThread
//						.getClientConServerThread(this.UserName).getSocket().getInputStream());
//				Messages messages = (Messages)ois.readObject();
//				System.out.print("chat get message");
//				String infoString = messages.getSender() +" say to " + messages.getReceiver() + " : \r\n";
//				infoString += messages.getContent()+" \r\n";
//				this.jTextArea.append(infoString);
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}
