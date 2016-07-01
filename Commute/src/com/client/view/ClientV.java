/*
 * Login
 */

package com.client.view;

import javax.imageio.ImageReader;

import javax.swing.*;
import java.io.*;  
import java.net.URL;

import org.omg.CORBA.portable.InputStream;

import com.client.model.ClientCon;
import com.common.User;

import java.awt.*;
import java.awt.event.*;

public class ClientV extends JFrame implements ActionListener{
	JLabel jl1;
	JPanel jp1;
	JPanel jp2;
	JLabel jp2_jl1, jp2_jl2, jp2_jl3, jp2_jl4;  
	JButton jp1_jb1, jp1_jb2, jp1_jb3;
	JTextField jp2_jt1;
	JPasswordField jp2_jpw;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientV clv = new ClientV();
	}
	
	public ClientV() {
		
		ClassLoader cl = this.getClass().getClassLoader();   
//		java.net.URL iconURL = cl.getResource("images/logo.png");	// Jar requires   
//		jl1 = new JLabel(new ImageIcon(iconURL));					// Jar requires
		jl1 = new JLabel(new ImageIcon("accpeud/logo.png"));
		this.add(jl1,"North");
		
		jp2 = new JPanel(new GridLayout(2, 2));
		jp2_jl1 = new JLabel("Account :");
		jp2_jl2 = new JLabel("Password :");
		jp2_jt1 = new JTextField();
		jp2_jpw = new JPasswordField();
		jp2.add(jp2_jl1);
		jp2.add(jp2_jt1);
		jp2.add(jp2_jl2);
		jp2.add(jp2_jpw);
		this.add(jp2, "Center");
		
		jp1 = new JPanel();
		jp1_jb1=new JButton("Login");
		jp1_jb1.addActionListener(this);
		jp1_jb2=new JButton("Cancle");
		jp1_jb2.addActionListener(this);
//		jp1_jb1=new JButton("login");
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		this.add(jp1, "South");
		
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jp1_jb1) {
			 ClientCon myClientCon = new ClientCon();
			 User user = new User();
			 user.setUserName(jp2_jt1.getText().trim());
			 user.setPasswd(new String(jp2_jpw.getPassword()));
			 if(myClientCon.CheckUser(user)) {
				 new Friends(jp2_jt1.getText().trim());			 
				 this.dispose();
			 } else {
				 Object[] options = { "OK" };
				JOptionPane.showOptionDialog(this, "account or password error", "Warning",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options,"OOK");
			}
		}
		else if(e.getSource()==jp1_jb2) {
			System.exit(0);
		}
	}
	

}
