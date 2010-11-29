package net.ulno.sm.course.mancala.model;

import java.util.Stack;

public class Cell {

	private Player owner;
	private boolean mancala;
	private int orderNr; // left to right: 6-5-4-3-2-1; 0 is mancala
	private String name;
	private Stack<Stone> stones;
	
	public Cell(Player owner, boolean mancala, int order) {
		this.owner = owner;
		this.mancala = mancala;
		this.orderNr = order;
		this.stones = new Stack<Stone>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stone getStone() {
		return this.stones.pop();
	}

	public void addStone(Stone stone) {
		this.stones.push(stone);
	}

	public int getOrderNr() {
		return orderNr;
	}

	public void setOrderNr(int orderNr) {
		this.orderNr = orderNr;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getStoneNumber() {
		return stones.size();
	}
	
	public Stack<Stone> getAllStones() {
		return stones;
	}	

	public boolean isMancala() {
		return mancala;
	}

	public void setMancala(boolean mancala) {
		this.mancala = mancala;
	}

}