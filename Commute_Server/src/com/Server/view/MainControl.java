package com.Server.view;

import javax.swing.*;

import com.model.MyServer;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class MainControl extends JFrame implements ActionListener{

	JButton jb1, jb2;
	JPanel jp1;
	private MyServer myServer ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainControl mControl = new MainControl();
	}
	
	public MainControl() {
		jp1 = new JPanel();
		jb1 = new JButton("Start Server");
		jb1.addActionListener(this);
		jb2 = new JButton("Stop Server");
		jb2.addActionListener(this);
		jp1.add(jb1);
//		jp1.add(jb2);
		
		this.add(jp1,"Center");
//		this.add(jPanel,"South");
//		this.setTitle("Chat with "+friendName);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1) {
			myServer = new MyServer();
			System.out.print("Main Control");
		} else if (arg0.getSource()==jb2){
			myServer.close();
		}
		
	}

}
