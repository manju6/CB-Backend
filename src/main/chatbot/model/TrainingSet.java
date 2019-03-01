package com.bosch.team.chatbot.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="TrainingSet")
public class TrainingSet {
	
//	@Id
//    private ObjectId _id;
	
	@Field(value = "teams")
	private String  teams;

	@Field(value = "text")
	private String  text;
	
	@Field(value = "response")
	private String  response;
	
	@Field(value = "entities")
	private ArrayList<PositionalData>  entities;
	
	@Field(value = "intent")
	private String  intent;	
	
	
	

//	public ObjectId get_id() {
//		return _id;
//	}
//
//	public void set_id(ObjectId _id) {
//		this._id = _id;
//	}



	public String getText() {
		return text;
	}

	public String getTeams() {
		return teams;
	}

	public void setTeams(String teams) {
		this.teams = teams;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}



	public ArrayList<PositionalData> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<PositionalData> entities) {
		this.entities = entities;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}	

}
