import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {

    // Database simulation
    static Map<String, String> users = new HashMap<>(); // Stores username and password
    static Map<String, Integer> candidates = new HashMap<>(); // Stores candidates and votes

    public static void main(String[] args) {
        // Initialize system with some users and candidates
        users.put("user1", "password1");
        users.put("user2", "password2");

        candidates.put("Candidate A", 0);
        candidates.put("Candidate B", 0);

        try (Scanner scanner = new Scanner(System.in)) {  // try-with-resources ensures Scanner is closed
            // User authentication
            System.out.print("Enter username: ");
            String username = scanner.nextLine().trim();
            System.out.print("Enter password: ");
            String password = scanner.nextLine().trim();

            if (authenticate(username, password)) {
                System.out.println("Authentication successful!");

                // Vote casting
                System.out.println("Choose a candidate to vote for: ");
                for (String candidate : candidates.keySet()) {
                    System.out.println(candidate);
                }

                String vote = scanner.nextLine().trim();
                if (candidates.containsKey(vote)) {
                    castVote(vote);
                    System.out.println("Vote successfully cast for " + vote + "!");
                } else {
                    System.out.println("Invalid candidate!");
                }

                // Result tallying
                System.out.println("\nVote tally:");
                tallyVotes();

            } else {
                System.out.println("Authentication failed. Access denied.");
            }
        }
    }

    // Method to authenticate user
    private static boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Method to cast a vote
    private static void castVote(String candidate) {
        candidates.put(candidate, candidates.get(candidate) + 1);
    }

    // Method to display vote tally
    private static void tallyVotes() {
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}
