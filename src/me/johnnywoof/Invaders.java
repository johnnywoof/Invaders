package me.johnnywoof;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Invaders {

	public Invaders() {
		JFrame frame = new JFrame("Invaders");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		final InvadersGame invadersGame = new InvadersGame();

		frame.setPreferredSize(new Dimension(500, 600));
		frame.add(invadersGame, BorderLayout.CENTER);

		frame.addKeyListener(new KeyListener() {
			//37 = Left, 39 = Right
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == 37) {
					invadersGame.spaceShip.movingLeft = true;
				} else if (e.getKeyCode() == 39) {
					invadersGame.spaceShip.movingRight = true;
				} else if (e.getKeyCode() == 0) {
					invadersGame.spaceShip.isFiring = true;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 37) {
					invadersGame.spaceShip.movingLeft = true;
				} else if (e.getKeyCode() == 39) {
					invadersGame.spaceShip.movingRight = true;
				} else if (e.getKeyCode() == 0) {
					invadersGame.spaceShip.isFiring = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 37) {
					invadersGame.spaceShip.movingLeft = false;
				} else if (e.getKeyCode() == 39) {
					invadersGame.spaceShip.movingRight = false;
				} else if (e.getKeyCode() == 32) {
					invadersGame.spaceShip.isFiring = false;
				}
			}
		});

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		invadersGame.start();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Invaders();
			}
		});
	}

}
