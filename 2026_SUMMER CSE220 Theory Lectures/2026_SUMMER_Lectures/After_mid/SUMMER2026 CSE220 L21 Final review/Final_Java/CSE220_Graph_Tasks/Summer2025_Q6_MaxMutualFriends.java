public class Summer2025_Q6_MaxMutualFriends {
    public static void maxMutual(int[][] graph, String[] mapper) {
        int numPeople = graph.length;   // total number of vertices (people)
        int maxMutualCount = 0;         // highest number of mutual friends found
        int person1Index = -1;          // store index of first person in best pair
        int person2Index = -1;          // store index of second person in best pair

        // Iterate through all unique pairs of people (i < j to avoid duplicates)
        for (int personA = 0; personA < numPeople; personA++) {
            for (int personB = personA + 1; personB < numPeople; personB++) {
                int mutualCount = 0;  // reset counter for this pair

                // Check every other person to see if they are a mutual friend
                for (int friend = 0; friend < numPeople; friend++) {
                    // Conditions:
                    // 1. friend should not be the same as personA or personB
                    // 2. friend must be directly connected to both personA and personB
                    if (friend != personA && friend != personB
                            && graph[personA][friend] == 1
                            && graph[personB][friend] == 1) {
                        mutualCount++;
                    }
                }

                // Update best pair if this pair has more mutual friends
                if (mutualCount > maxMutualCount) {
                    maxMutualCount = mutualCount;
                    person1Index = personA;
                    person2Index = personB;
                }
            }
        }

        // Final output based on whether a valid pair was found
        if (person1Index == -1 || maxMutualCount == 0) {
            System.out.println("There are no mutual friends between any vertices.");
        } else {
            System.out.println(mapper[person1Index] + " and " + mapper[person2Index]
                    + " have " + maxMutualCount + " mutual friend(s).");
        }
    }

    // --------------- Driver part ---------------------
    public static void main(String[] args) {
        String[] mapper = {"Alice", "Harry", "Nimo", "Nimas", "Bob", "Moana"};

        int[][] g = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}
        };

        maxMutual(g, mapper);
    }
}
