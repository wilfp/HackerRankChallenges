import java.util.*;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

/**
* Based on the challenge "Sorting: Comparator" on HackerRank
*/
class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
  
        if(a.score != b.score){ // If the scores are different
            return Integer.compare(a.score, b.score) > 0? -1 : 1; // Compare the integers in descending order
        }
        
        // If the scores are the same

        return a.name.compareTo(b.name); // Compare the names in ascending order
    }
}

