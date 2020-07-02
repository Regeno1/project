package com.engine.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.engine.inventory.Inventory;

public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	// <THREAD CREATION>//
	private boolean isRunning;
	private Thread thread;
	public static int FPS;
	// <THREAD CREATION>//

	// <FRAME CREATION>//
	public static JFrame frame;
	public static int WIDTH = 640;
	public static int HEIGHT = 480;
	public static BufferedImage layer;
	// <FRAME CREATION>//

	public static Input Input = new Input();
	public static Inventory Inventory = new Inventory(4, 4, 30);

	public static void main(String args[]) {
		Main main = new Main();
		main.start();
	}

	public Main() {
		initFrame();
		addKeyListener(Input);
		addMouseListener(Input);
	}

	public void initFrame() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		frame = new JFrame("Inventory");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		;
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void update() {

	}

	public void render() {
		// <BUFFERSTRATEGY INITIALIZATION>//
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		// <BUFFERSTRATEGY INITIALIZATION>//
		Graphics g = layer.getGraphics();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// <IN IMAGE DRAW>//

		// <IN IMAGE DRAW>//
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH, HEIGHT, null);
		// <OUT IMAGE DRAW>//

		if (Inventory != null) {
			Inventory.update();
			Inventory.render(50, 50, 64, g);
		}

		// <OUT IMAGE DRAW>//
		bs.show();
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}

	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				update();
				render();
				FPS++;
				delta--;
			}
			if (System.currentTimeMillis() - timer >= 1000) {
				FPS = 0;
				timer += 1000;
			}
		}
		stop();
	}

}
