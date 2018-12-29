package com.company;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Position> snake;
    private int snakeSize = 2;
    private Boolean cantCrash = false;

    public Snake(Position p){
        snake = new ArrayList<>();
        snake.add(p);
    }

    public List<Position> getSnake() {
        return snake;
    }

    public void addOneToSnake(){
        snakeSize++;
    }

    public int getSize(){
        return snakeSize;
    }

    public void moveSnake(Position p){
        snake.add(p);
        if(p.getTarget()==true){
            setCantCrash(true);

        }
        else{
            setCantCrash(false);
        }
        if(snake.size()==getSize()+1) {
            snake.remove(0);
            System.out.println(snake.get(0).getX());
        }
        else{
            System.out.println("target");
            setCantCrash(true);
        }
    }

    public Position getPosition(int index){
        return snake.get(index);
    }

    public Boolean getCantCrash() {
        return cantCrash;
    }

    public void setCantCrash(Boolean cantCrash) {
        this.cantCrash = cantCrash;
    }
}
