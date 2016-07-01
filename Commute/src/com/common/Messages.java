/*
 * Type=1 success
 * Type=2 fail
 * Type=3 chat information
 */

package com.common;


import java.util.HashMap;
import java.util.Vector;

import javax.tools.JavaCompiler;

public class Messages implements java.io.Serializable{
	
	private String messType;
	private Vector<String> onlineFriends;	

	public Vector<String> getOnlineFriends() {
		return onlineFriends;
	}

	public void setOnlineFriends(Vector<String> onlineFriends) {
		this.onlineFriends = onlineFriends;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private String sender;
	private String receiver;
	private String content;
	private	String time;
	private Boolean closedBoolean;

	public Boolean getClosedBoolean() {
		return closedBoolean;
	}

	public void setClosedBoolean(Boolean closedBoolean) {
		this.closedBoolean = closedBoolean;
	}

	public String getMessType() {
		return messType;
	}

	public void setMessType(String messType) {
		this.messType = messType;
	}
	
	
}
