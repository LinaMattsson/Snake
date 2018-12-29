package com.company;

public class Position {
    private int x;
    private int y;
    private boolean target;
    printScreen printSnake = new printScreen();

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

    public Position(int x, int y, boolean target){
        this.target = target;
        this.x = x;
        this.y = y;
    }

    public boolean getTarget(){
        return target;
    }
}
