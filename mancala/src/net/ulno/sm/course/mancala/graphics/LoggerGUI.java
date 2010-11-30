package net.ulno.sm.course.mancala.graphics;

import java.awt.Color;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import net.ulno.sm.course.mancala.model.Logger;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

public class LoggerGUI extends JFrame {

	private JPanel titlePanel;
	private JLabel winerLabel;
	private JLabel score1Label;
	private JLabel score2Label;
	private JTextArea results;

	public LoggerGUI() {
		this.setTitle("Statistics");
		this.setSize(220, 300);
		initComponents();
	}

	private void initComponents() {
		add(getTitlePanel());
	}

	private JPanel getTitlePanel() {
		if (titlePanel == null) {
			titlePanel = new JPanel();
			titlePanel.setBackground(Color.GREEN);
			titlePanel.setLayout(new GroupLayout());
			titlePanel.add(getWinerLabel(), new Constraints(new Leading(15,
					10, 10), new Leading(10, 10, 10)));
			titlePanel.add(getScore1Label(), new Constraints(new Leading(95,
					10, 10), new Leading(10, 10, 10)));
			titlePanel.add(getScore2Label(), new Constraints(new Leading(182,
					10, 10), new Leading(10, 10, 10)));
			
			titlePanel.add(getResults(), new Constraints(new Leading(10, 200, 10,
					10), new Leading(30, 230, 12, 12)));
		}
		return titlePanel;
	}

	private JTextArea getResults() {
		if (results == null) {
			results = new JTextArea(Integer.MAX_VALUE, 1);
			results.setBounds(0, 0, 120, 100);
			results.setAutoscrolls(true);
			results.setEditable(false);
			results.setVisible(true);
			results.setText(getLoggerText());
		}
		return results;
	}
	
	private JLabel getWinerLabel() {
		if (winerLabel == null) {
			winerLabel = new JLabel();
			winerLabel.setText("Winer");
		}
		return winerLabel;
	}
	
	private String getLoggerText() {
		Logger l = MancalaGUI.log;
		String text = "";
		for (int i =0; i<l.getWinner().size();i++){
			text += l.getWinner().get(i)+"	"+l.getP1().get(i)+"	"+l.getP2().get(i)+"\n"; 
		}
		return text;
	}

	private JLabel getScore1Label() {
		if (score1Label == null) {
			score1Label = new JLabel();
			score1Label.setText("P1");
		}
		return score1Label;
	}

	private JLabel getScore2Label() {
		if (score2Label == null) {
			score2Label = new JLabel();
			score2Label.setText("P2");
		}
		return score2Label;
	}
	
}
