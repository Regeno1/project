package com.engine.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	public static Sprite item01 = new Sprite("/spr_Item01.png");

	private BufferedImage sheet;

	public Sprite(String path) {
		try {
			sheet = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getSprite(int x, int y, int w, int h) {
		return sheet.getSubimage(x, y, w, h);
	}

}