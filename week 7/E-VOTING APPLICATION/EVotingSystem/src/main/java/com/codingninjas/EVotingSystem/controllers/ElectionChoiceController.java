package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.services.ElectionChoiceService;
import com.codingninjas.EVotingSystem.services.ElectionService;

import jakarta.persistence.EntityNotFoundException;

@RestController
// @RequestMapping("/electionChoice")
public class ElectionChoiceController {
    @Autowired
    private ElectionChoiceService electionChoiceService;

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private ElectionService electionService;

    @GetMapping("/get/electionChoices")
    public List<ElectionChoice> getAllElectionChoices() {
        return electionChoiceService.getAllElectionChoices();
    }

    @PostMapping("/add/electionChoice")
    public ElectionChoice addElectionChoice(@RequestBody ElectionChoice electionChoice) {
        //return electionChoiceService.addElectionChoice(electionChoice);
        // Retrieve the Election from the database
        Election election = electionRepository.findById(electionChoice.getElection().getId()).orElse(null);

        // Check if the Election exists
        if (election == null) {
            // Handle the case where the Election is not found
            throw new EntityNotFoundException("Election not found with ID: " + electionChoice.getElection().getId());
        }

        // Set the managed Election in the ElectionChoice entity
        electionChoice.setElection(election);

        // Save the ElectionChoice
        return electionChoiceService.addElectionChoice(electionChoice);
    }

    // @PostMapping("/count/election/choices")
    // public List<ElectionChoice> getElectionChoicesByElection(@RequestBody Election election) {
    //     return electionChoiceService.getElectionChoicesByElection(election);
    // }

    @PostMapping("/count/election/choices")
    public long getElectionChoicesByElection(@RequestBody Election election) {
        return electionChoiceService.getElectionChoicesByElection(election);
    }
}
