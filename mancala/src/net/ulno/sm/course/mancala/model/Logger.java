package net.ulno.sm.course.mancala.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public final class Logger implements Serializable {
	private static final long serialVersionUID = 3652765666114489556L;
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
		this.winner = winner;
		this.p1 = p1;
		this.p2 = p2;
	}

	public Logger() {
		winner = "";
		p1 = 0;
		p2 = 0;
	}

	public Logger(String fileName) throws Exception {
		try {
			InputStream file = new FileInputStream(fileName);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			try {
				Logger l = new Logger();
				l = (Logger) input.readObject();
				this.winner = l.getWinner();
				this.p1 = l.getP1();
				this.p2 = l.getP2();
			} finally {
				input.close();
			}
		} catch (ClassNotFoundException ex) {
			//System.out.println("EXCEPTION");
			ex.printStackTrace();
		} catch (IOException ex) {
			//System.out.println("EXCEPTION");
			throw ex;
		}
	}

	public void writeData(String fileName) {
		try {
			OutputStream file = new FileOutputStream(fileName);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			try {
				output.writeObject(this);
			} finally {
				output.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}