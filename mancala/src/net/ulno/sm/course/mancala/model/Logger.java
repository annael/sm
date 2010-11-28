package net.ulno.sm.course.mancala.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class Logger implements Serializable {

	private String winner;
	private int p1;
	private int p2;

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public int getP1() {
		return p1;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}

	public Logger(String winner, int p1, int p2) {
		super();
		this.winner = winner;
		this.p1 = p1;
		this.p2 = p2;
	}

	public Logger() {
		this("", 0, 0);
	}

	private static final long serialVersionUID = 7526471155622776147L;

	/**
	 * Always treat de-serialization as a full-blown constructor, by validating
	 * the final state of the de-serialized object.
	 */
	public static void readObject(ObjectInputStream aInputStream)
			throws ClassNotFoundException, IOException {
		aInputStream.defaultReadObject();
	}

	/**
	 * This is the default implementation of writeObject. Customise if
	 * necessary.
	 */
	public static void writeObject(ObjectOutputStream aOutputStream)
			throws IOException {
		aOutputStream.defaultWriteObject();
	}
}