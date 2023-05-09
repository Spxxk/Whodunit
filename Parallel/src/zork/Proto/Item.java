package zork.proto;

public class Item extends OpenableObject {
    private double weight;
    private String name;
    private boolean isOpenable;

    private final double HASH; 
    
    public Item(String name, double weight, boolean isOpenable) {
        this.weight = weight;
        this.name = name;
        this.isOpenable = isOpenable;

        HASH = Math.random();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        if (!(o instanceof Item)) return false;

        Item i = (Item) o;

        return HASH == i.getHash() && name.equals(i.getName()) && weight == i.getWeight();
    }
    
    public void open() {
        if (!isOpenable)
            System.out.println("The " + name + " cannot be opened.");
        
    }

    public double getHash() {
        return HASH;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isOpenable() {
        return isOpenable;
    }
    
    public void setOpenable(boolean isOpenable) {
        this.isOpenable = isOpenable;
    }
    
    public static String arrayToString(String[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = (i == 0) ? arr[0] : result + " " + arr[i];
        }

        return result;
    }
}
