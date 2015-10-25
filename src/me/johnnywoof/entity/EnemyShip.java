package me.johnnywoof.entity;

import me.johnnywoof.InvadersGame;

import java.awt.*;

public class EnemyShip extends Enemy {

	public EnemyShip(InvadersGame invadersGame, int x) {
		super(invadersGame, x, 10, 45, 20);
	}

	@Override
	public void tick() {
		this.y += 5;
	}

	@Override
	public void collide(BaseEntity e) {

	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.width, this.height);
		/*g.drawLine(this.x + 20, this.y, this.x, this.y - 30);
		g.drawLine(this.x + 20, this.y, this.x + 40, this.y - 30);*/
	}
}
