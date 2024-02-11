let candidates = [];

function registerVoter() {
    const voterName = document.getElementById('voterName').value;
    if (voterName.trim() === '') {
        alert('Please enter your name.');
        return;
    }
    // Send a request to backend to register the voter
    alert('Voter registered successfully!');
}

function castVote() {
    const candidate = document.getElementById('candidate').value;
    const voterName = document.getElementById('voterName').value;
    // Send a request to backend to cast the vote
    alert(`${voterName} voted for ${candidate}.`);
}

function tallyVotes() {
    // Send a request to backend to get vote tally
    // Update the UI with the tally
    const voteTally = document.getElementById('voteTally');
    voteTally.innerText = "Vote Tally:\n";
    candidates.forEach(candidate => {
        voteTally.innerText += `${candidate}: ${candidate.votes}\n`;
    });
}

// Populate candidate dropdown dynamically
function populateCandidates() {
    const candidateDropdown = document.getElementById('candidate');
    candidateDropdown.innerHTML = '';
    candidates.forEach(candidate => {
        const option = document.createElement('option');
        option.text = candidate.name;
        option.value = candidate.name;
        candidateDropdown.appendChild(option);
    });
}

// Add candidates (in real application, this should come from backend)
candidates.push({ name: 'Candidate A', votes: 0 });
candidates.push({ name: 'Candidate B', votes: 0 });
candidates.push({ name: 'Candidate C', votes: 0 });

populateCandidates();
