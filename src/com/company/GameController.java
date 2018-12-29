package com.company;

import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    int positionX;
    int positionY;
    Position target ;


    public boolean stillAlive(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        if(positionX <= 21 || positionX >= 76 || positionY <= 3 || positionY >= 25){
            return false;
        }
        return true;
    }
    public void showHighScoore(Screen screen){
        printScreen p = new printScreen();
        p.printHighScoore(screen);
    }

    public Boolean isDead(Snake snake){
        List<Position> newSnake = new ArrayList<>();
        Boolean crash = false;
        for (int i = snake.getSize(); i > 0; i--) {
            if(newSnake.size()>0){
                for (int j = 0; j <newSnake.size()-1 ; j++) {
                    Position p = snake.getPosition(snake.getSize()-i);
                    if(p.getX()==newSnake.get(j).getX() && p.getY() == newSnake.get(j).getY()&&!snake.getCantCrash() ){
                        crash = true;
                    }
                }
            }
            //snake.setCantCrash(false);
            newSnake.add(snake.getPosition(snake.getSize()-i));

        }
        return crash;
        //snake.size() = 20  0-19
        //snakesize = 5     15-19
        // snake 0-4
    }

    public Position getTarget() {
        return target;
    }

    public void setTarget(Position target) {
        this.target = target;
    }
}
