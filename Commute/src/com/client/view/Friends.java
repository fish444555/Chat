package com.client.view;

import javax.swing.*;

import com.client.model.ClientUser;
import com.client.model.ManageChatDiag;
import com.common.User;

import java.awt.*;
import java.awt.event.*;

public class Friends extends JFrame implements MouseListener{

	JPanel jp1;
//	JLabel jl1;
	JScrollPane jsp;
	private String UserName;
	static public JLabel[] jlbs = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Friends fs = new Friends();
		
	}
	
	public Friends(String UserName) {
		this.UserName = UserName;
		int friend_num = 10;
		jp1 = new JPanel(new GridLayout(friend_num, 1, 7, 7));
//		JLabel[] jlbs = new JLabel[friend_num];
		jlbs = new JLabel[friend_num];
		for (int i = 0; i < jlbs.length; i++) {
			int pos = ClientUser.onlineFriendStrings.indexOf(i+1+"");
//			jl1 = new JLabel(new ImageIcon("accpeud/sakura_col.png"));
//			ClassLoader cl = this.getClass().getClassLoader();					// Jar require   
//			java.net.URL iconURL = cl.getResource("images/sakura_col.png");		// Jar require 
			jlbs[i] = new JLabel(i+1+"", new ImageIcon("accpeud/sakura_col.png"), JLabel.LEFT);
			if(pos != -1) {
				jlbs[i].setEnabled(true);
			}
			else {
				jlbs[i].setEnabled(false);
			}
			
			jlbs[i].addMouseListener(this);
			jp1.add(jlbs[i]);
		}
//		jp1 = new JPanel(new GridLayout(10, 1, 4, 4));	
		jsp = new JScrollPane(jp1);
		
		this.add(jsp,"Center");
		this.setSize(200, 500);
		this.setTitle(this.UserName);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount() == 2) {
			String fdIdx = ((JLabel)e.getSource()).getText();
			System.out.println("char with "+ fdIdx);
			System.out.println("UserName = "+ this.UserName);
			if(ManageChatDiag.getManageChatDiag(fdIdx) == null && !(fdIdx.equals(this.UserName))) {
				Chat chat = new Chat(this.UserName, fdIdx);
				ManageChatDiag.addManageChatDiag(fdIdx, chat);
				System.out.println("ManageChatDiag Hash" + ManageChatDiag.getManageChatDiag(fdIdx));
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jLabel = (JLabel)e.getSource();
		jLabel.setForeground(Color.green);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jLabel = (JLabel)e.getSource();
		jLabel.setForeground(Color.black);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
