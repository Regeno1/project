package pack;

public class Item {
	private String dName;
	private int dItemCode;
	private int dItemCount;
	private long dGUID;

	public Item(String name, int itemCode, long guid, int itemCount) {
		dName = name;
		dItemCode = itemCode;
		dGUID = guid;
		dItemCount = itemCount;

	}

	public static Item createItem(String name, int itemCode, long guid, int itemCount) {
		return new Item(name, itemCode, guid, itemCount);
	}
}
