package me.johnnywoof;

import me.johnnywoof.entity.BaseEntity;
import me.johnnywoof.entity.EnemyShip;
import me.johnnywoof.entity.SpaceShip;
import me.johnnywoof.entity.StarParticle;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvadersGame extends JPanel {

	public final List<BaseEntity> entities = new CopyOnWriteArrayList<>();

	private final Random random = new Random();

	public SpaceShip spaceShip;

	public InvadersGame() {
		this.setBackground(Color.black);
	}

	public void start() {
		this.spaceShip = new SpaceShip(this);
		this.entities.add(this.spaceShip);
		new java.util.Timer().scheduleAtFixedRate(new GameTimer(this), 0, 50);
	}

	public void tick() {

		if (this.random.nextBoolean())
			this.entities.add(new StarParticle(this, this.random.nextInt(this.getWidth()), 0));

		if (this.random.nextInt(32) == 3) {
			this.entities.add(new EnemyShip(this, this.random.nextInt(this.getWidth())));
		}

		for (BaseEntity e : this.entities)
			for (BaseEntity e2 : this.entities)
				if (e2.canCollide && e != e2 && e.intersects(e2)) {
					//System.out.println("collide");
					e.collide(e2);
				}

		for (BaseEntity e : this.entities)
			e.tick();

		this.repaint();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D graphics2D = (Graphics2D) g;

		for (BaseEntity e : this.entities) {
			e.render(graphics2D);
		}

		graphics2D.dispose();

	}

}
