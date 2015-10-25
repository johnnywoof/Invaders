package me.johnnywoof;

import java.util.TimerTask;

public class GameTimer extends TimerTask {

	private final InvadersGame invadersGame;

	public GameTimer(InvadersGame invadersGame) {
		this.invadersGame = invadersGame;
	}

	@Override
	public void run() {
		this.invadersGame.tick();
	}

}
