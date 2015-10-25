package me.johnnywoof.entity;

import me.johnnywoof.InvadersGame;

import java.awt.*;

public class Projectile extends BaseEntity {

	public Projectile(InvadersGame invadersGame, int x, int y) {
		super(invadersGame, x, y, 2, 4);
	}

	@Override
	public void tick() {
		this.y -= 20;

		if (this.y < 0)
			this.die();
	}

	@Override
	public void collide(BaseEntity e) {
		System.out.println("Collided");
		if (e instanceof Enemy) {
			System.out.println("Collide");
			this.die();
			e.die();
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
}
