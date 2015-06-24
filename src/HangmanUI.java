import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Stack;

public class HangmanUI implements KeyListener {

    private  JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JLabel guessCountLbl;
    private Puzzle currentPuzzle;
    private String puzzleDisplay;
    private Stack<String> puzzles;
    private int guessCount;
    private int maxCount = 9;

	public HangmanUI() {
		label = new JLabel();
		guessCountLbl = new JLabel();
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed:" + String.valueOf(e.getKeyChar()));
		 if(!this.currentPuzzle.guess(e.getKeyChar())) {
			this.guessCount++; 
		 }
		System.out.println("puzzleDisplay:" + this.currentPuzzle.getPuzzleDisplay());

		label.setText(this.currentPuzzle.getPuzzleDisplay());
		guessCountLbl.setText(String.valueOf(this.guessCount));
		
		if (this.guessCount > this.maxCount) {
			JOptionPane.showMessageDialog(null,"I'm sorry you've run out of guess :(");
			newPuzzle();
		} else {
			if (this.currentPuzzle.isComplete()) {
				JOptionPane.showMessageDialog(null,"Congratulations");
				if (this.puzzles.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Congratulations...all puzzles completed");
				} else {
					newPuzzle();
				}
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setPuzzles(Stack<String> puzzles) {
		this.puzzles = puzzles;
	}
	
	public void newPuzzle() {
		this.guessCount = 0;
		this.currentPuzzle = new Puzzle(puzzles.pop());
		this.guessCountLbl.setText(String.valueOf(this.guessCount));
		this.label.setText(this.currentPuzzle.getPuzzleDisplay());

	}
	public void init() {
		newPuzzle();
        frame = new JFrame();
        frame.setTitle("Michael's Hangman");
        panel = new JPanel();

  //      p.setLayout(new FlowLayout());
        panel.add(this.label);
        panel.add(this.guessCountLbl);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.addKeyListener(this);

	}
	private String puzzleToDash(String puzzle) {
		String dashes = new String();
		for (int i=0; i < puzzle.length(); i++) {
			dashes = dashes + " _";
		}
		return dashes;
	}
}
