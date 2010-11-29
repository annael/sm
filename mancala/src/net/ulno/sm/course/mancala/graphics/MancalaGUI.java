package net.ulno.sm.course.mancala.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import net.ulno.sm.course.mancala.model.Cell;
import net.ulno.sm.course.mancala.model.Logger;
import net.ulno.sm.course.mancala.model.Player;
import net.ulno.sm.course.mancala.play.Mancala;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

public class MancalaGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String filename = "/home/anna/logM.txt";
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JPanel boardPanel;
	private static JButton u1h1;
	private static JButton u1h2;
	private static JButton u1h3;
	private static JButton u1h4;
	private static JButton u1h5;
	private static JButton u1h6;
	private static JButton u2h1;
	private static JButton u2h2;
	private static JButton u2h3;
	private static JButton u2h4;
	private static JButton u2h5;
	private static JButton u2h6;
	private JButton endTurn;
	private JButton showLog;
	private JButton newGame;
	private static JLabel u1total;
	private static JLabel u2total;
	private static JLabel workMsg;
	private Logger log;

	public MancalaGUI() {
		this.setTitle("Mancala");
		this.setSize(500, 300);
		initComponents();

	}

	private void initComponents() {
		add(getTitlePanel(), BorderLayout.NORTH);
		add(getBoardPanel(), BorderLayout.CENTER);
		disableButtons();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		try {			
			log = new Logger(filename);
		} catch (Exception e) {
			e.printStackTrace();
			log = new Logger();
		}

	}

	private static JLabel getUser2Total() {
		if (u2total == null) {
			u2total = new JLabel();
			u2total.setText("0");
		}
		return u2total;
	}

	private static JLabel getUser1Total() {
		if (u1total == null) {
			u1total = new JLabel();
			u1total.setText("0");
		}
		return u1total;
	}

	public static JLabel getMessage() {
		if (workMsg == null) {
			workMsg = new JLabel();
			workMsg.setText("It's now player "
					+ Mancala.getTurn().getActivePlayer().getName() + " turn!");
		}
		return workMsg;
	}

	private JPanel getBoardPanel() {
		if (boardPanel == null) {
			boardPanel = new JPanel();
			boardPanel.setBackground(Color.GREEN);
			boardPanel.setLayout(new GroupLayout());

			// first row pits

			boardPanel.add(getU1H1(), new Constraints(new Leading(100, 50, 10,
					10), new Leading(60, 50, 12, 12)));
			boardPanel.add(getU1H2(), new Constraints(new Leading(155, 50, 10,
					10), new Leading(60, 50, 12, 12)));
			boardPanel.add(getU1H3(), new Constraints(new Leading(210, 50, 10,
					10), new Leading(60, 50, 12, 12)));
			boardPanel.add(getU1H4(), new Constraints(new Leading(265, 50, 10,
					10), new Leading(60, 50, 12, 12)));
			boardPanel.add(getU1H5(), new Constraints(new Leading(320, 50, 10,
					10), new Leading(60, 50, 12, 12)));
			boardPanel.add(getU1H6(), new Constraints(new Leading(375, 50, 10,
					10), new Leading(60, 50, 12, 12)));

			// second row

			boardPanel.add(getU2H6(), new Constraints(new Leading(100, 50, 10,
					10), new Leading(120, 50, 12, 12)));
			boardPanel.add(getU2H5(), new Constraints(new Leading(155, 50, 10,
					10), new Leading(120, 50, 12, 12)));
			boardPanel.add(getU2H4(), new Constraints(new Leading(210, 50, 10,
					10), new Leading(120, 50, 12, 12)));
			boardPanel.add(getU2H3(), new Constraints(new Leading(265, 50, 10,
					10), new Leading(120, 50, 12, 12)));
			boardPanel.add(getU2H2(), new Constraints(new Leading(320, 50, 10,
					10), new Leading(120, 50, 12, 12)));
			boardPanel.add(getU2H1(), new Constraints(new Leading(375, 50, 10,
					10), new Leading(120, 50, 12, 12)));

			boardPanel.add(getUser1Total(), new Constraints(new Leading(70, 10,
					10), new Leading(110, 12, 12)));
			boardPanel.add(getUser2Total(), new Constraints(new Leading(445,
					10, 10), new Leading(110, 12, 12)));

			boardPanel.add(getMessage(), new Constraints(new Leading(170, 12,
					12), new Leading(10, 12, 12)));

			// boardPanel.add(getEndTurn(), new Constraints(new Leading(380, 12,
			// 12), new Leading(200, 12, 12)));

			boardPanel.add(getShowLog(), new Constraints(new Leading(380, 12,
					12), new Leading(200, 12, 12)));

			boardPanel.add(getNewGame(), new Constraints(
					new Leading(10, 12, 12), new Leading(200, 12, 12)));

			// add action listeners
			getU1H1().addActionListener(this);
			getU1H2().addActionListener(this);
			getU1H3().addActionListener(this);
			getU1H4().addActionListener(this);
			getU1H5().addActionListener(this);
			getU1H6().addActionListener(this);
			getU2H1().addActionListener(this);
			getU2H2().addActionListener(this);
			getU2H3().addActionListener(this);
			getU2H4().addActionListener(this);
			getU2H5().addActionListener(this);
			getU2H6().addActionListener(this);
			getShowLog().addActionListener(this);
			getNewGame().addActionListener(this);
		}
		return boardPanel;
	}

	private JButton getEndTurn() {
		if (endTurn == null) {
			endTurn = new JButton();
			endTurn.setText("End turn");
			endTurn.setName("endTurn");
		}
		return endTurn;
	}

	private JButton getShowLog() {
		if (showLog == null) {
			showLog = new JButton();
			showLog.setText("Show log");
			showLog.setName("showLog");
		}
		return showLog;
	}

	private JButton getNewGame() {
		if (newGame == null) {
			newGame = new JButton();
			newGame.setText("New Game");
			newGame.setName("newGame");
		}
		return newGame;
	}

	private static JButton getU1H6() {
		if (u1h6 == null) {
			u1h6 = new JButton();
			u1h6.setText("4");
			u1h6.setName("u1h6");
		}
		return u1h6;
	}

	private static JButton getU1H5() {
		if (u1h5 == null) {
			u1h5 = new JButton();
			u1h5.setText("4");
			u1h5.setName("u1h5");
		}
		return u1h5;
	}

	private static JButton getU1H4() {
		if (u1h4 == null) {
			u1h4 = new JButton();
			u1h4.setText("4");
			u1h4.setName("u1h4");
		}
		return u1h4;
	}

	private static JButton getU1H3() {
		if (u1h3 == null) {
			u1h3 = new JButton();
			u1h3.setText("4");
			u1h3.setName("u1h3");
		}
		return u1h3;
	}

	private static JButton getU1H2() {
		if (u1h2 == null) {
			u1h2 = new JButton();
			u1h2.setText("4");
			u1h2.setName("u1h2");
		}
		return u1h2;
	}

	private static JButton getU1H1() {
		if (u1h1 == null) {
			u1h1 = new JButton();
			u1h1.setText("4");
			u1h1.setName("u1h1");
		}
		return u1h1;
	}

	private static JButton getU2H6() {
		if (u2h6 == null) {
			u2h6 = new JButton();
			u2h6.setText("4");
			u2h6.setName("u2h6");
		}
		return u2h6;
	}

	private static JButton getU2H5() {
		if (u2h5 == null) {
			u2h5 = new JButton();
			u2h5.setText("4");
			u2h5.setName("u2h5");
		}
		return u2h5;
	}

	private static JButton getU2H4() {
		if (u2h4 == null) {
			u2h4 = new JButton();
			u2h4.setText("4");
			u2h4.setName("u2h4");
		}
		return u2h4;
	}

	private static JButton getU2H3() {
		if (u2h3 == null) {
			u2h3 = new JButton();
			u2h3.setText("4");
			u2h3.setName("u2h3");
		}
		return u2h3;
	}

	private static JButton getU2H2() {
		if (u2h2 == null) {
			u2h2 = new JButton();
			u2h2.setText("4");
			u2h2.setName("u2h2");
		}
		return u2h2;
	}

	private static JButton getU2H1() {
		if (u2h1 == null) {
			u2h1 = new JButton();
			u2h1.setText("4");
			u2h1.setName("u2h1");
		}
		return u2h1;
	}

	private JPanel getTitlePanel() {
		if (titlePanel == null) {
			titlePanel = new JPanel();
			titlePanel.setBackground(Color.GREEN);
			titlePanel.setLayout(new GroupLayout());
			titlePanel.add(getTitleLabel(), new Constraints(new Leading(200,
					10, 10), new Leading(10, 10, 10)));
		}
		return titlePanel;
	}

	private JLabel getTitleLabel() {
		if (titleLabel == null) {
			titleLabel = new JLabel();
			titleLabel.setText("Mancala");
		}
		return titleLabel;
	}

	/**
	 * Disables button of non-active player
	 */
	public static void disableButtons() {
		if (Mancala.getTurn().getActivePlayer().getName().equals("1")) {
			disableU2Buttons();
			enableU1Buttons();
		} else {
			disableU1Buttons();
			enableU2Buttons();
		}
	}

	public static void disableU1Buttons() {
		System.out.println("u1 disabled");
		getU1H1().setEnabled(false);
		getU1H2().setEnabled(false);
		getU1H3().setEnabled(false);
		getU1H4().setEnabled(false);
		getU1H5().setEnabled(false);
		getU1H6().setEnabled(false);
	}

	private static void enableU1Buttons() {
		System.out.println("u2 disabled");
		getU1H1().setEnabled(true);
		getU1H2().setEnabled(true);
		getU1H3().setEnabled(true);
		getU1H4().setEnabled(true);
		getU1H5().setEnabled(true);
		getU1H6().setEnabled(true);
	}

	public static void disableU2Buttons() {
		getU2H1().setEnabled(false);
		getU2H2().setEnabled(false);
		getU2H3().setEnabled(false);
		getU2H4().setEnabled(false);
		getU2H5().setEnabled(false);
		getU2H6().setEnabled(false);
	}

	private static void enableU2Buttons() {
		getU2H1().setEnabled(true);
		getU2H2().setEnabled(true);
		getU2H3().setEnabled(true);
		getU2H4().setEnabled(true);
		getU2H5().setEnabled(true);
		getU2H6().setEnabled(true);
	}

	public static void changeStoneLabels() {
		if (Mancala.getTurn().getActivePlayer().getName().equals("1")) {
			changeU1StoneLabels(Mancala.getTurn().getActivePlayer());
			changeU2StoneLabels(Mancala.getTurn().getNonActivePlayer());
		} else {
			changeU2StoneLabels(Mancala.getTurn().getActivePlayer());
			changeU1StoneLabels(Mancala.getTurn().getNonActivePlayer());
		}

	}

	public static void changeU1StoneLabels(Player u1) {
		getU1H1().setText(
				String.valueOf(u1.getCellByName(getU1H1().getName())
						.getStoneNumber()));
		getU1H2().setText(
				String.valueOf(u1.getCellByName(getU1H2().getName())
						.getStoneNumber()));
		getU1H3().setText(
				String.valueOf(u1.getCellByName(getU1H3().getName())
						.getStoneNumber()));
		getU1H4().setText(
				String.valueOf(u1.getCellByName(getU1H4().getName())
						.getStoneNumber()));
		getU1H5().setText(
				String.valueOf(u1.getCellByName(getU1H5().getName())
						.getStoneNumber()));
		getU1H6().setText(
				String.valueOf(u1.getCellByName(getU1H6().getName())
						.getStoneNumber()));
		// +mancala itself
		getUser1Total().setText(
				String.valueOf(u1.getCellByName("u1h0").getStoneNumber()));
	}

	public static void changeU2StoneLabels(Player u2) {
		getU2H1().setText(
				String.valueOf(u2.getCellByName(getU2H1().getName())
						.getStoneNumber()));
		getU2H2().setText(
				String.valueOf(u2.getCellByName(getU2H2().getName())
						.getStoneNumber()));
		getU2H3().setText(
				String.valueOf(u2.getCellByName(getU2H3().getName())
						.getStoneNumber()));
		getU2H4().setText(
				String.valueOf(u2.getCellByName(getU2H4().getName())
						.getStoneNumber()));
		getU2H5().setText(
				String.valueOf(u2.getCellByName(getU2H5().getName())
						.getStoneNumber()));
		getU2H6().setText(
				String.valueOf(u2.getCellByName(getU2H6().getName())
						.getStoneNumber()));
		// +mancala itself
		getUser2Total().setText(
				String.valueOf(u2.getCellByName("u2h0").getStoneNumber()));
	}

	public static String getGameOverText(int win) {
		switch (win) {
		case 0:
			return "Game ended with a draw";
		case 1:
			return "Player 1 won";
		case 2:
			return "Player 2 won";
		}
		return "";
	}

	/**
	 * Method that handles all performed actions
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source.getName().equals("showLog")) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new LoggerGUI().setVisible(true);
				}
			});
		} else if (source.getName().equals("newGame")) {
			Mancala.generateStones();
			Mancala.getTurn().getActivePlayer().generateCells();
			Mancala.getTurn().getNonActivePlayer().generateCells();
			enableU1Buttons();
			enableU2Buttons();
			if (Mancala.getTurn().getActivePlayer().getName().equals("2")) {
				Mancala.getTurn().changeTurn();
			}
			disableButtons();
			changeStoneLabels();
		} else {
			Cell activePit = Mancala.getTurn().getActivePlayer().getCellByName(	source.getName());
			Mancala.Play(activePit);
		}
	}
}