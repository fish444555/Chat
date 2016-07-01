/*
 * connect server
 */

package com.client.model;

import javax.swing.*;

import com.common.User;

import java.awt.*;
import java.net.*;
import java.io.*;

public class ClientCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean CheckUser(User u) {
		// TODO Auto-generated constructor stub
		System.out.println("ClientCon");
		return new ClientUser().sendLoginInfoToServer(u);
	}

}
