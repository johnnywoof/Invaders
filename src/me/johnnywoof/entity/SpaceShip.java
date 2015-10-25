package me.johnnywoof.entity;

import me.johnnywoof.InvadersGame;

import java.awt.*;

public class SpaceShip extends BaseEntity {

	public boolean movingLeft = false, movingRight = false, isFiring = false;
	private int firingCooldown = 0;

	public SpaceShip(InvadersGame invadersGame) {
		super(invadersGame, (invadersGame.getWidth() / 2) - 25, invadersGame.getHeight() - 50, 45, 30);
	}

	@Override
	public void tick() {
		if (this.movingLeft) {
			this.x -= 15;
			if (this.collidesWithBorder())
				this.x = 0;
		}
		if (this.movingRight) {
			this.x += 15;
			if (this.collidesWithBorder())
				this.x = (this.invadersGame.getWidth() - this.width);
		}
		if (this.isFiring && this.firingCooldown <= 0) {
			this.invadersGame.entities.add(new Projectile(this.invadersGame, this.x + 20, this.y - 10));
			this.firingCooldown = 5;
		} else if (this.firingCooldown > 0) {
			this.firingCooldown--;
		}
	}

	@Override
	public void collide(BaseEntity e) {

	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.drawLine(this.x + 20, this.y, this.x, this.y + 30);
		//-g.setColor(Color.CYAN);
		g.drawLine(this.x + 20, this.y, this.x + 40, this.y + 30);
	}
}
