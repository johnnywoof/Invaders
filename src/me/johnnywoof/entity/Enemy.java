package me.johnnywoof.entity;

import me.johnnywoof.InvadersGame;

public abstract class Enemy extends BaseEntity {
	public Enemy(InvadersGame invadersGame, int x, int y, int width, int height) {
		super(invadersGame, x, y, width, height);
	}
}
