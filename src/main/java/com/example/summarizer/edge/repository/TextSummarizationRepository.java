package com.example.summarizer.edge.repository;

import com.example.summarizer.edge.model.TextSummarizationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TextSummarizationRepository extends MongoRepository<TextSummarizationEntity, String> {

}
