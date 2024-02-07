package com.tutorial.springWebSocketDemo.springWebSocketDemo;


public class Entity {
    private String name;
    private float amount;
    private String icon;
    private boolean increase;

    public Entity(String name, float amount, String icon) {
        this.name = name;
        this.amount = amount;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean getIncrease() {
        return increase;
    }

    public void setIncrease(boolean increase) {
        this.increase = increase;
    }
}
