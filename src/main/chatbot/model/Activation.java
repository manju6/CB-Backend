package com.bosch.team.chatbot.model;

public class Activation {

	private String url;
	private String botName;
	
	
	
	public Activation(String url, String botName) {
		super();
		this.url = url;
		this.botName = botName;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBotName() {
		return botName;
	}
	public void setBotName(String botName) {
		this.botName = botName;
	}
	
	
}
