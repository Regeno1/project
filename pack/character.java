package pack;

import java.util.ArrayList;

public class character {

	private String dName;
	private int dLevel;

	private ArrayList<Item> dItems;
	private ArrayList<Skill> dSkills;

	private long dGUID;

	private ItemManager dItemManager;

	public character(String name, long guid) {
		dName = name;
		dLevel = 1;
		dItems = new ArrayList<Item>();
		dSkills = new ArrayList<Skill>();
		dGUID = guid;

		dItemManager = new ItemManager();

		initItems();
	}

	private void initItems() {
		createItem(ItemDef.AXE, 1);
		createItem(ItemDef.HEALING_POTION, 3);
		createItem(ItemDef.DIRTY_PANTS, 1);
		createItem(ItemDef.DAGGER, 1);
	}

	public boolean createItem(int itemCode, int itemCount) {
		dItems.add(dItemManager.createItem(itemCode, itemCount));
		return true;
	}

	public boolean removeItem(long guid) {
		return true;
	}
}
