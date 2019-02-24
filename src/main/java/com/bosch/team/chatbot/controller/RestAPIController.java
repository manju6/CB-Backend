package com.bosch.team.chatbot.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.team.chatbot.model.Activation;
import com.bosch.team.chatbot.model.PositionalData;
import com.bosch.team.chatbot.model.ResponseJSON;
import com.bosch.team.chatbot.model.TrainingSet;
import com.bosch.team.chatbot.repo.TrainingSetRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestAPIController {
	
	@Autowired
	TrainingSetRepository repo;
	
	//Save Training Set in DB
	@PostMapping("/trainingSet")
	public int trainingSet(@RequestBody List<TrainingSet> data) {

		System.out.println(data);
		repo.saveAll(data);
		return 1;
	}
	
	//Select teams TS to train CiTi 
	@GetMapping("/teams")
	public Set<String> findTeams()  
	{
			List<TrainingSet> teamDetails  = new ArrayList<>();
		    repo.findAll().forEach(teamDetails::add);
		    
		    Set<String> teams = new HashSet<>();
		    
		    for(TrainingSet name : teamDetails)
		    {
		    	teams.add(name.getTeam());
		    }
		    return  teams ;
	}
	
	//Form Training JSON & Response JSON file based on the TS set selection 
	@GetMapping("/formJSON")
	public int formJSON() throws JsonGenerationException, JsonMappingException, IOException  
	{
			List<TrainingSet> teamDetails  = new ArrayList<>();
		    repo.findAll().forEach(teamDetails::add);
		    
		    Map<String, Set<ResponseJSON>> map = new HashMap<>();
		    Set<ResponseJSON> responseJSON = new HashSet<>();
		    
		    for(TrainingSet data : teamDetails)
		    {
		    	List<String> parts = new ArrayList<>();
		    	ResponseJSON obj = new ResponseJSON();
		    	
		    	for(PositionalData ententy : data.getEntities())
		    	{
		    		parts.add(ententy.getEntities());
		    	}
		    	
		    	if(parts!=null)
		    	{	
		    		java.util.Collections.sort(parts);
		    		StringBuilder sb = new StringBuilder();  
		    		for(String s:parts)
		    		{  
		    			sb.append(s);  
		    			sb.append("_");  
		    		}  
		    		String sorted = sb.toString().trim().substring(0, sb.length() - 1).toLowerCase();
		    		obj.setEntenty(sorted);
		    	}
		    	
		    	obj.setResponse(data.getResponse());
		    	responseJSON.add(obj);
		    	map.put(data.getIntent(), responseJSON);

		    }
	    	

	    	ObjectMapper objectMapper = new ObjectMapper();
	    	objectMapper.writeValue(new File("map.json"), map); 
		    
		    return 1;
	}
	
	//Activate Bot with TS.JSON & Response.JSON
	@GetMapping("/activateBot")
	public Activation activateBot()  
	{
		Activation obj = new Activation("http://localhost:4200/api/formJSON","CiTi"); 
		return obj;
	}
	
	
	
	
//**************TEST******************//
	
	//Select all TrainingSet 
	@GetMapping("/all")
	public List<TrainingSet> findAll()  
	{
			List<TrainingSet> teamDetails  = new ArrayList<>();
		    repo.findAll().forEach(teamDetails::add);
		    return  teamDetails ;
	}
		
	@PostMapping("/prepareBot")
	public List<TrainingSet> team()  
	{
			//@RequestBody List<String> teams		
			List<String> teams = new ArrayList<>();
			teams.add("Sample");
			teams.add("Devops");				
			List<TrainingSet> teamDetails  = new ArrayList<>();			
		    repo.findDistinctByTeamsIn(teams).forEach(teamDetails::add);
		    return  teamDetails ;
	}

	

	
	
	

}
	


	





