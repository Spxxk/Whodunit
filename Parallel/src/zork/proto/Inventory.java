package zork.proto;

import java.util.ArrayList;

import zork.exceptions.InventoryLimitExceeded;

public class Inventory {
    private ArrayList<Item> items;
    private int maxWeight;
    private int currentWeight;
    
    public Inventory(int maxWeight) {
        this.items = new ArrayList<Item>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }
    
    public int getMaxWeight() {
        return maxWeight;
    }
    
    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int weight) {
        this.currentWeight += weight;
    }
    
    public void addItem(Item item) throws InventoryLimitExceeded {
        if (item.getWeight() + currentWeight <= maxWeight)
        	items.add(item);
        else {
            throw new InventoryLimitExceeded(item);
        }
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

	public Item getItem(int index) {
		return items.get(index);
	}
    
    public ArrayList<Item> getContents() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
