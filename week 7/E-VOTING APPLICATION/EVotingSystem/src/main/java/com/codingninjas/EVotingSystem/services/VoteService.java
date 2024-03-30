package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class VoteService{

    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote addVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public long getTotalVotes() {
        return voteRepository.count();
    }

    public long getTotalVotesByElection(Election election) {
        return voteRepository.countByElection(election);
    } 
}
