package com.engine.inventory;

import java.util.Comparator;

public class Slot {

	private Item curItem;
	private int amount, maxAmount;

	public Slot() {

	}

	public Item getCurItem() {
		return curItem;
	}

	public void setCurItem(Item curItem) {
		this.curItem = curItem;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void addAmount(int toAdd) {
		this.amount += toAdd;
	}

	public void subtractAmount(int toSubtract) {
		this.amount -= toSubtract;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	public static Comparator<Slot> slotSorter = new Comparator<Slot>() {

		@Override
		public int compare(Slot slot0, Slot slot1) {
			if (slot1.getCurItem() != slot0.getCurItem()) {
				return +1;
			}
			return 0;
		}
	};

}