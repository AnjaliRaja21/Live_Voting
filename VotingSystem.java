package Voting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VotingSystem {
    private Map<String, Candidate> candidates;
    private List<Voter> voters;

    public VotingSystem() {
        candidates = new HashMap<>();
        voters = new LinkedList<>();
    }

    public void addCandidate(String name) {
        candidates.put(name, new Candidate(name));
    }

    public void registerVoter(String name) {
        voters.add(new Voter(name));
    }

    public void castVote(String voterName, String candidateName) {
        if (!hasVoted(voterName)) {
            if (candidates.containsKey(candidateName)) {
                Candidate candidate = candidates.get(candidateName);
                candidate.incrementVotes();
                getVoter(voterName).markVoted();
                System.out.println(voterName + " voted for " + candidateName);
            } else {
                System.out.println("Candidate not found.");
            }
        } else {
            System.out.println("You have already voted.");
        }
    }

    public Map<String, Integer> tallyVotes() {
        Map<String, Integer> voteTally = new HashMap<>();
        for (Candidate candidate : candidates.values()) {
            voteTally.put(candidate.getName(), candidate.getVotes());
        }
        return voteTally;
    }

    private boolean hasVoted(String name) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name) && voter.hasVoted()) {
                return true;
            }
        }
        return false;
    }

    private Voter getVoter(String name) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name)) {
                return voter;
            }
        }
        return null;
    }
}
