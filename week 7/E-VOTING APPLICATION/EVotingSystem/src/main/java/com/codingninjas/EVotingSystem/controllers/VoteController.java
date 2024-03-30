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
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;
import com.codingninjas.EVotingSystem.services.VoteService;

import jakarta.persistence.EntityNotFoundException;

@RestController
// @RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private ElectionChoiceRepository electionChoiceRepository;

    @Autowired
    private VoteService voteService;

    @GetMapping("/get/votes")
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    @PostMapping("/add/vote")
    public Vote addVote(@RequestBody Vote vote) {
        // Retrieve the associated entities from the database
        User user = userRepository.findById(vote.getUser().getId()).orElse(null);
        Election election = electionRepository.findById(vote.getElection().getId()).orElse(null);
        ElectionChoice electionChoice = electionChoiceRepository.findById(vote.getElectionChoice().getId()).orElse(null);

        // Check if the entities exist
        if (user == null || election == null || electionChoice == null) {
            // Handle the case where any of the entities is not found
            throw new EntityNotFoundException("User, Election, or ElectionChoice not found");
        }

        // Set the managed entities in the Vote entity
        vote.setUser(user);
        vote.setElection(election);
        vote.setElectionChoice(electionChoice);

        // Save the Vote
        return voteService.addVote(vote);
    }

    @GetMapping("/count/votes")
    public long getTotalVotes() {
        return voteService.getTotalVotes();
    }

    @PostMapping("/count/election/votes")
    public long getTotalVotesByElection(@RequestBody Election election) {
        return voteService.getTotalVotesByElection(election);
    }

    @PostMapping("/winner/election")
    public ElectionChoice getWinnerForElection(@RequestBody Election election) {
        // Retrieve the associated ElectionChoices for the given election
        List<ElectionChoice> electionChoices = electionChoiceRepository.findByElection(election);

        // Calculate the winner based on the number of votes each ElectionChoice received
        ElectionChoice winner = calculateWinner(electionChoices);

        return winner;
    }

    private ElectionChoice calculateWinner(List<ElectionChoice> electionChoices) {
        // Implement your logic to calculate the winner based on votes
        // For example, you might iterate through the list and find the one with the highest vote count.

        // Placeholder implementation (replace with your actual logic)
        ElectionChoice winner = null;
        int maxVotes = 0;

        for (ElectionChoice choice : electionChoices) {
            int votesForChoice = (int) voteRepository.countByElectionChoice(choice);
            if (votesForChoice > maxVotes) {
                maxVotes = votesForChoice;
                winner = choice;
            }
        }

        return winner;
    }
}
