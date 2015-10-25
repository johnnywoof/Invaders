package me.johnnywoof.entity;

import me.johnnywoof.InvadersGame;

import java.awt.*;

public abstract class BaseEntity extends Rectangle {

	public int x, y, width, height;
	public boolean canCollide = true;
	protected final InvadersGame invadersGame;

	public BaseEntity(InvadersGame invadersGame, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.invadersGame = invadersGame;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void die() {
		this.invadersGame.entities.remove(this);
	}

	public abstract void tick();

	public abstract void collide(BaseEntity e);

	public abstract void render(Graphics2D g);

	public boolean collidesWithBorder() {
		return this.x < 0 || this.x > (this.invadersGame.getWidth() - this.width)
				|| this.y < 0 || this.y > this.invadersGame.getHeight();
	}

	public boolean isOffScreen() {
		return this.x < (this.width * -1) || this.x > (this.invadersGame.getWidth() + this.width)
				|| this.y < (this.height * -1) || this.y > (this.invadersGame.getHeight() + this.height);
	}

}
