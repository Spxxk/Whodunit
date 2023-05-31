package zork.proto;

import java.security.NoSuchAlgorithmException;

import zork.utils.Hash;

public class Item extends OpenableObject {
    public static boolean array;
    private double weight;
    private final String name;
    private boolean isOpenable;
    private boolean needsContext;

    private final String _hash; 
    
    public Item(String name, double weight, boolean isOpenable, Boolean needsContext) {
        this.weight = weight;
        this.name = name;
        this.isOpenable = isOpenable;

        
        String proposedHash = null;

        try {
            proposedHash = Hash.generateHash(String.valueOf(Math.random()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Internal Error.");
        }

        _hash = proposedHash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        if (!(o instanceof Item)) return false;

        Item i = (Item) o;

        return _hash.equals(i.getHash()) && name.equals(i.getName()) && weight == i.getWeight();
    }
    
    public void open() {
        if (!isOpenable)
            System.out.println("The " + name + " cannot be opened.");
        
    }

    public String getHash() {
        return _hash;
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
