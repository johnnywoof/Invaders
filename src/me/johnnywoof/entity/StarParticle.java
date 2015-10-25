package me.johnnywoof.entity;

import me.johnnywoof.InvadersGame;

import java.awt.*;

public class StarParticle extends BaseEntity {

	public StarParticle(InvadersGame invadersGame, int x, int y) {
		super(invadersGame, x, y, 1, 1);
		this.canCollide = false;
	}

	@Override
	public void tick() {
		this.y += 10;

		if (this.isOffScreen())
			this.die();
	}

	@Override
	public void collide(BaseEntity e) {
		this.canCollide = false;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.GRAY);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

}
