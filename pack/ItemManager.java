package pack;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {
	private long dCurrentGUID = 100000000000L;

	private HashMap dItemMap = new HashMap();

	public ItemManager() {
		initItems();
	}

	private void initItems() {
		dItemMap.put(ItemDef.RED_STICK, "red stick");
		dItemMap.put(ItemDef.HEALING_POTION, "healing potion");
		dItemMap.put(ItemDef.ROTTEN_APPLE, "rotten apple");
		dItemMap.put(ItemDef.SHORT_KNIFE, "short knife");
		dItemMap.put(ItemDef.DAGGER, "dagger");
		dItemMap.put(ItemDef.AXE, "axe");
		dItemMap.put(ItemDef.DIRTY_PANTS, "dirty pants");
		dItemMap.put(ItemDef.BLONDIE_HAIR, "blondie hair");
		dItemMap.put(ItemDef.TELEPORT_SCROLL, "teleport scroll");
	}

	public long getGuid() {
		dCurrentGUID += 1;
		return dCurrentGUID;
	}

	public Item createItem(int itemCode, int itemCount) {
		Object itemNameObj = dItemMap.get(itemCode);
		if (itemNameObj == null)
			return null;

		return Item.createItem((String) itemNameObj, itemCode, getGuid(), itemCount);
	}
}
