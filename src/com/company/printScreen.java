package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;

public class printScreen {
    int targets = 0;
    List<Integer> target = new List<Integer>() {
    }{50, 20}

    public Key printscreen(int x, int y, Screen screen) throws InterruptedException {
        screen.clear();
        screen.putString(x, y, "X", Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(target.get(0),target.get(1),"T", Terminal.Color.MAGENTA, Terminal.Color.MAGENTA);
        Thread.sleep(500);
        Key key=screen.readInput();
        screen.refresh();
        return key;
    }
    public void isTarget(int x, int y){
        if(target.get(0)==x && target.get(1)==y){
            targets++;
            newTarget();
        }

    }
    public void newTarget(){
        target.clear();
        target.add(1 + (int)(Math.random() * 150));
        target.add(1 + (int)(Math.random() * 30));

    }
}
