package com.engine.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.engine.inventory.Item;

public class Input implements KeyListener, MouseListener {

	/// InvKeyLock:
	boolean invU, invD, invL, invR;

	/// ===KEYBOARD===\\\
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (invU == false) {
				invU = true;
				Main.Inventory.slotU = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (invD == false) {
				invD = true;
				Main.Inventory.slotD = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (invL == false) {
				invL = true;
				Main.Inventory.slotL = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (invR == false) {
				invR = true;
				Main.Inventory.slotR = true;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_F1) {
			Main.Inventory.addItem(Item.redball, 1);
		}

		if (e.getKeyCode() == KeyEvent.VK_F2) {
			Main.Inventory.removeItem(Item.redball, 10);
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Main.Inventory.useItem();
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			invU = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			invD = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			invL = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			invR = false;
		}

	}

	public void keyTyped(KeyEvent e) {

	}

	/// ===MOUSE===\\\
	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}