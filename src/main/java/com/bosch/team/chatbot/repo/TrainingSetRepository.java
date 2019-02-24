package com.bosch.team.chatbot.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bosch.team.chatbot.model.TrainingSet;


@Transactional
public interface TrainingSetRepository extends MongoRepository<TrainingSet, String>
{
	
	List<TrainingSet> findDistinctByTeamsIn(List<String> teams);

}
