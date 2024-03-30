package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;

@Service
public class ElectionChoiceService{

    @Autowired
    ElectionChoiceRepository electionChoiceRepository;

    @Autowired
    ElectionRepository electionRepository;

    public ElectionChoice addElectionChoice(ElectionChoice electionChoice){
        return electionChoiceRepository.save(electionChoice);
    }

    public List<ElectionChoice> getAllElectionChoices(){
        return electionChoiceRepository.findAll();
    }

    // public List<ElectionChoice> getElectionChoicesByElection(Election election){
    //     return electionChoiceRepository.findByElection(election);
    // } 
    public long getElectionChoicesByElection(Election election){
        return electionChoiceRepository.findByElection(election).size();
    }
}

