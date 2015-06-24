import java.util.ArrayList;

public class Puzzle {
	private String word;
	private ArrayList<Boolean> viewable;

	public Puzzle() {
		// TODO Auto-generated constructor stub
	}

	public Puzzle(String word) {
		this.word = word;
		viewable = new ArrayList<Boolean>();
		for (int i=0; i<word.length();i++) {
			viewable.add(new Boolean(false));
		}
	}
	
	public boolean guess(char c) {
		boolean correctGuess = false;
		for (int i=0; i< this.word.length();i++) {
			if (String.valueOf(c).equals(this.word.substring(i,i+1))) {
				System.out.println("Yay");
				this.viewable.set(i, new Boolean(true));
				correctGuess = true;
			}
		}
		return correctGuess;
	}
	
	public String getPuzzleDisplay() {
		String puzzleDisplay = "";
		
		for (int i=0; i<this.word.length(); i++) {
			if (this.viewable.get(i).booleanValue()) {
				puzzleDisplay = puzzleDisplay + " " + this.word.substring(i,i+1);
			} else {
				puzzleDisplay = puzzleDisplay + " _";
			}
		}
		return puzzleDisplay;
	}
	
	public boolean isComplete() {
		for (Boolean view : this.viewable) {
			if (!view) {
				return false;
			}
		}
		return true;
	}

}
