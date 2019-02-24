package com.bosch.team.chatbot.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bosch.team.chatbot.model.TrainingSet;


@Transactional
public interface ProcessTrainingSetRepository extends MongoRepository<TrainingSet, String>
{
	
	
}
