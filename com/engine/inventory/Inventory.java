package com.engine.inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

	public List<Slot> slots = new ArrayList<Slot>();

	public int curSlot = 0;
	public int curSlotX = 0, curSlotY = 0;

	public int maxSlotsX = 1, maxSlotsY = 1;

	public boolean slotU, slotD, slotL, slotR;
	public boolean isOpened;

	public Inventory(int lines, int columns, int maxItemPerSlot) {
		this.maxSlotsX = lines;
		this.maxSlotsY = columns;

		if (this.maxSlotsX < 1) {
			this.maxSlotsX = 1;
		}
		if (this.maxSlotsY < 1) {
			this.maxSlotsY = 1;
		}

		for (int i = 0; i < ((lines * columns)); i++) {
			slots.add(new Slot());
			slots.get(i).setMaxAmount(maxItemPerSlot);
		}
	}

	public void addItem(Item item, int amount) {
		for (int i = 0; i < slots.size(); i++) {
			Slot slot = slots.get(i);
			if (slot.getCurItem() == null) {
				if (amount <= slot.getMaxAmount()) {
					slot.setCurItem(item);
					slot.addAmount(amount);
					return;
				} else {
					slot.setCurItem(item);
					slot.addAmount(slot.getMaxAmount());
					amount -= slot.getMaxAmount();
				}
			} else if (slot.getCurItem() == item && slot.getAmount() < slot.getMaxAmount()) {
				if (amount <= Math.abs(slot.getAmount() - slot.getMaxAmount())) {
					slot.addAmount(amount);
					return;
				} else {
					slot.addAmount(Math.abs(slot.getAmount() - slot.getMaxAmount()));
					amount -= Math.abs(slot.getAmount() - slot.getMaxAmount());
				}
			}

		}

	}

	public void removeItem(Item item, int amount) {
		for (int i = slots.size() - 1; i > -1; i--) {
			Slot slot = slots.get(i);
			if (slot.getCurItem() == item) {
				if (amount <= slot.getAmount()) {
					slot.subtractAmount(amount);
					if (slot.getAmount() <= 0) {
						slot.setCurItem(null);
					}
					return;
				} else {
					amount -= slot.getAmount();
					slot.subtractAmount(slot.getAmount());
					slot.setCurItem(null);
				}

			}

		}
	}

	public void useItem() {
		Slot slot = slots.get(curSlot);
		if (slot.getCurItem() != null && slot.getCurItem().getUsable() == true) {
			if (slot.getCurItem() == Item.redball) {
				removeItem(Item.redball, 1);
				System.out.println("Usou Bola Vermelha");
			}
		}

	}

	public boolean checkSpace(Item item) {
		for (int i = 0; i < slots.size(); i++) {
			Slot slot = slots.get(i);
			if (slot.getCurItem() == null) {
				return true;
			}
			if (slot.getCurItem() == item && slot.getAmount() < slot.getMaxAmount()) {
				return true;
			}
		}
		return false;
	}

	public int curItens() {
		int total = 0;
		for (int i = 0; i < slots.size(); i++) {
			total += slots.get(i).getAmount();
		}
		return total;
	}

	public int maxItens() {
		int total = 0;
		for (int i = 0; i < slots.size(); i++) {
			total += slots.get(i).getMaxAmount();
		}
		return total;
	}

	public void update() {
		if (slotU) {
			slotU = false;
			curSlotY--;
			if (curSlotY < 0) {
				curSlotY = maxSlotsY - 1;
			}
		}
		if (slotD) {
			slotD = false;
			curSlotY++;
			if (curSlotY > maxSlotsY - 1) {
				curSlotY = 0;
			}
		}
		if (slotL) {
			slotL = false;
			curSlotX--;
			if (curSlotX < 0) {
				curSlotX = maxSlotsX - 1;
			}
		}
		if (slotR) {
			slotR = false;
			curSlotX++;
			if (curSlotX > maxSlotsX - 1) {
				curSlotX = 0;
			}
		}
	}

	public void render(int x, int y, int boxSize, Graphics g) {
		int loopX = -1, loopY = 0;
		for (int i = 0; i < slots.size(); i++) {
			Slot slot = slots.get(i);
			loopX++;
			if (loopX > maxSlotsX - 1) {
				loopX = 0;
				loopY++;
				if (loopY > maxSlotsY - 1) {
					loopY = 0;
				}
			}

			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(x + (boxSize * loopX), y + (boxSize * loopY), boxSize, boxSize);
			g.setColor(Color.BLACK);
			g.drawRect(x + (boxSize * loopX), y + (boxSize * loopY), boxSize, boxSize);

			if (slot.getCurItem() != null) {
				g.drawImage(slot.getCurItem().getSprite(), x + (boxSize * loopX), y + (boxSize * loopY), boxSize,
						boxSize, null);
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial", Font.BOLD, boxSize / 4));
				g.drawString(slot.getAmount() + "/" + slot.getMaxAmount(), x + (boxSize * loopX) + boxSize / 4,
						y + (boxSize * loopY) + boxSize - 5);
			}
		}
		g.setColor(Color.WHITE);
		g.drawRect(x + (boxSize * curSlotX), y + (boxSize * curSlotY), boxSize, boxSize);
	}
}