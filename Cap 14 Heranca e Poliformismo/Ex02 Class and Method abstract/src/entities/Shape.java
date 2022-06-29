package entities;

import entities.enums.Color;

public abstract class Shape {

    private Color color;  // Pertence a enums Color

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract double area();
}