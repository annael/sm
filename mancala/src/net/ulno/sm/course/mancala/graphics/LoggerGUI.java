package net.ulno.sm.course.mancala.graphics;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

public class LoggerGUI extends JFrame {

	private JPanel titlePanel;
	private JLabel winerLabel;
	private JLabel score1Label;
	private JLabel score2Label;

	public LoggerGUI() {
		this.setTitle("Statistics");
		this.setSize(200, 300);
		initComponents();

	}

	private void initComponents() {
		// add(getTitlePanel(), BorderLayout.NORTH);
		add(getTitlePanel());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private JPanel getTitlePanel() {
		if (titlePanel == null) {
			titlePanel = new JPanel();
			titlePanel.setBackground(Color.GREEN);
			titlePanel.setLayout(new GroupLayout());
			titlePanel.add(getWinerLabel(), new Constraints(new Leading(200,
					10, 10), new Leading(10, 10, 10)));
		}
		return titlePanel;
	}

	private JLabel getWinerLabel() {
		if (winerLabel == null) {
			winerLabel = new JLabel();
			winerLabel.setText("Winer");
		}
		return winerLabel;
	}

	private JLabel getScore1Label() {
		if (score1Label == null) {
			score1Label = new JLabel();
			score1Label.setText("Player 1");
		}
		return score1Label;
	}

	private JLabel getScore2Label() {
		if (score2Label == null) {
			score2Label = new JLabel();
			score2Label.setText("Player 2");
		}
		return score2Label;
	}
}
