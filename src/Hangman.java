import java.util.Stack;

public class Hangman {
	public Hangman() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Stack<String> puzzles = loadPuzzles();
		showPuzzles(puzzles);
	}

	public static Stack<String> loadPuzzles() {
		Stack<String> puzzles = new Stack<String>();
		puzzles.push("Dogfood");
		puzzles.push("Milk");
		puzzles.push("Cheese");
		puzzles.push("ham");
		return puzzles;
	}
	
	public static void showPuzzles(Stack puzzles) {
		HangmanUI uiHandle = new HangmanUI();
		uiHandle.setPuzzles(puzzles);
		uiHandle.init();
	}
}
