package Voting;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/voting")
public class VotingSystemController {
    private final VotingSystem votingSystem;

    public VotingSystemController() {
        this.votingSystem = new VotingSystem();
        // Initialize candidates and voters
        // Add candidates
        votingSystem.addCandidate("Candidate A");
        votingSystem.addCandidate("Candidate B");
        votingSystem.addCandidate("Candidate C");
    }

    @PostMapping("/register")
    public String registerVoter(@RequestParam String name) {
        votingSystem.registerVoter(name);
        return "Voter registered successfully!";
    }

    @PostMapping("/vote")
    public String castVote(@RequestParam String voterName, @RequestParam String candidateName) {
        votingSystem.castVote(voterName, candidateName);
        return "Vote cast successfully!";
    }

    @GetMapping("/tally")
    public Map<String, Integer> tallyVotes() {
        return votingSystem.tallyVotes();
    }
}

