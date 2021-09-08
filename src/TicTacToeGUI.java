import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToeGUI implements ActionListener {
	JFrame frame = new JFrame("Tic-Tac-Toe");
	JPanel btPanel = new JPanel();
	JButton[] buttons = new JButton[9];
	JPanel lbPanel = new JPanel();
	JLabel label = new JLabel();
	int totalMoves = 0;
	boolean p1chance = false;

	public TicTacToeGUI() throws InterruptedException {
		totalMoves = 0;
		frame.setSize(400, 450);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);

		btPanel.setLayout(new GridLayout(3, 3));

		Font font = new Font("Arial", Font.BOLD, 40);
		label.setFont(font);
		label.setText("Tic-Tac-Toe");
		label.setHorizontalAlignment(JLabel.CENTER);

		lbPanel.setLayout(new BorderLayout());
		lbPanel.add(label);
		lbPanel.setBounds(0, 0, 300, 100);

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttons[i].setText("");
			buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
			buttons[i].addActionListener(this);
			btPanel.add(buttons[i]);
		}

		frame.add(btPanel);
		frame.add(lbPanel, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		start();

	}

	public void start() throws InterruptedException {
		int i = 0;
		while (i < 100) {
			label.setText("Loading..." + i + "%");
			Thread.sleep(10);
			i++;
		}

		int chance = new Random().nextInt(100);
		if (chance % 2 == 0) {
			p1chance = true;
			label.setText("X's turn");
		} else {
			p1chance = false;
			label.setText("O's turn");
		}
	}

	public void checkWin() {
		if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xwins(0, 1, 2);

		} else if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
			xwins(3, 4, 5);
		} else if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
			xwins(6, 7, 8);
		} else if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
			xwins(0, 3, 6);
		} else if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
			xwins(1, 4, 7);
		} else if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
			xwins(2, 5, 8);
		} else if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
			xwins(0, 4, 8);
		} else if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
			xwins(2, 4, 6);
		}

		else if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			owins(0, 1, 2);

		} else if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
			owins(3, 4, 5);
		} else if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
			owins(6, 7, 8);
		} else if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
			owins(0, 3, 6);
		} else if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
			owins(1, 4, 7);
		} else if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
			owins(2, 5, 8);
		} else if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
			owins(0, 4, 8);
		} else if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
			owins(2, 4, 6);
		} else if (totalMoves == 9) {
			gameoverTie();
		}
	}

	public void xwins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		label.setText("X wins");
		gameover();
	}

	public void owins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		label.setText("O wins");
		gameover();
	}

	public void gameoverTie() {
		label.setText("Its a tie");
		String[] options = { "Restart", "Exit" };
		int n = JOptionPane.showOptionDialog(frame, "Game Over Tie\n", "Game Over", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n == 0) {
			frame.dispose();
			try {
				new TicTacToeGUI();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			frame.dispose();
		}

	}

	public void gameover() {
		String[] options = { "Restart", "Exit" };
		int n = JOptionPane.showOptionDialog(frame, "Game Over\n", "Game Over", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n == 0) {
			frame.dispose();
			try {
				new TicTacToeGUI();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			frame.dispose();
		}

	}

	public static void main(String[] args) throws InterruptedException {

		new TicTacToeGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (p1chance == true && buttons[i].getText() == "") {
					buttons[i].setText("X");
					p1chance = false;
					label.setText("O's turn");
					totalMoves++;
					checkWin();
				} else if (p1chance == false && buttons[i].getText() == "") {
					buttons[i].setText("O");
					p1chance = true;
					label.setText("X's turn");
					totalMoves++;
					checkWin();
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid Input !", "Error !", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
