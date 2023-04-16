package zork;

import java.util.ArrayList;

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
    
    public boolean addItem(Item item) {
        if (item.getWeight() + currentWeight <= maxWeight)
        	return items.add(item);
        else {
            System.out.println("There is no room to add the item.");
            return false;
        }
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

	public Item getItem(int index) {
		return items.get(index);
	}
    
    public ArrayList<Item> getInventory() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
