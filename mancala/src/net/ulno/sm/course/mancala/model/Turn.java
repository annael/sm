package net.ulno.sm.course.mancala.model;

public class Turn {

	private Player activePlayer;
	private Player nonActivePlayer;


	public Turn(Player active, Player notActive){
		this.activePlayer = active;
		this.nonActivePlayer = notActive;
	}
	
	public void changeTurn(){
		Player active = this.getActivePlayer();
		Player nonActive = this.getNonActivePlayer();
		this.setActivePlayer(nonActive);
		this.setNonActivePlayer(active);
	}
	
	public Player getNonActivePlayer() {
		return nonActivePlayer;
	}

	public void setNonActivePlayer(Player nonActivePlayer) {
		this.nonActivePlayer = nonActivePlayer;
	}
	
	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}
	
}
