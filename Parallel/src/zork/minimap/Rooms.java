package zork.minimap;

import java.awt.Color;

public class Rooms {
    private int x;
    private int y;
    private int size;
    private Color color;
    private String name;

    public Rooms(int x, int y, int size, Color color, String name) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.name = name;
    }

    // getters and setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
