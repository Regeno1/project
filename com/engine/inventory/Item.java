package com.engine.inventory;

import java.awt.image.BufferedImage;

import com.engine.main.Sprite;

public class Item extends Slot {

	public static Item redball = new Item("Red Ball", Sprite.item01.getSprite(32 * 0, 32 * 0, 32, 32), true);
	public static Item greenball = new Item("Green Ball", Sprite.item01.getSprite(32 * 1, 32 * 0, 32, 32), false);
	public static Item purpleball = new Item("Purple Ball", Sprite.item01.getSprite(32 * 2, 32 * 0, 32, 32), false);

	protected String name;
	protected BufferedImage sprite;
	protected boolean usable;

	public Item(String name, BufferedImage sprite, boolean usable) {
		this.name = name;
		this.sprite = sprite;
		this.usable = usable;
	}

	public String getName() {
		return this.name;
	}

	public BufferedImage getSprite() {
		return this.sprite;
	}

	public boolean getUsable() {
		return this.usable;
	}

}