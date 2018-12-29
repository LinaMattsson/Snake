package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class printScreen {
    int targets = 0;
    int steps = 0;
    private List<Integer> target =  new ArrayList<>();
    GameController game = new GameController();

    public printScreen() {
        target.add(50);
        target.add(20);
    }


    public Key printscreen(Snake snake, Screen screen) throws InterruptedException {
        steps++;
        Key key;
        isTarget(snake);

            screen.clear();
            for (int i = snake.getSize()-1; i > 0; i--) {
                if(i == snake.getSize()-1){
                    screen.putString(snake.getPosition(i).getX(), snake.getPosition(i).getY(), "^^", Terminal.Color.RED, Terminal.Color.YELLOW);

                }
                else {
                    screen.putString(snake.getPosition(i).getX(), snake.getPosition(i).getY(), "XX", Terminal.Color.CYAN, Terminal.Color.CYAN);
                }
            }

            screen.putString(7, 5, "Snake", Terminal.Color.WHITE, Terminal.Color.BLACK);
            screen.putString(7, 7, "Scoore: " + ((targets * 10) + steps), Terminal.Color.WHITE, Terminal.Color.BLACK);

            screen.putString(20, 25, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", Terminal.Color.GREEN, Terminal.Color.GREEN);
            screen.putString(20, 3, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", Terminal.Color.GREEN, Terminal.Color.GREEN);
            for (int i = 3; i < 25; i++) {
                screen.putString(20, i, "AA", Terminal.Color.GREEN, Terminal.Color.GREEN);
                screen.putString(76, i, "AA", Terminal.Color.GREEN, Terminal.Color.GREEN);
                //x under 22 över 75 quit;
                //y under 4 över 24 quit;
            }

            screen.putString(target.get(0), target.get(1), "TT", Terminal.Color.MAGENTA, Terminal.Color.MAGENTA);

            Thread.sleep(300);
            screen.refresh();
            key = screen.readInput();

        return key;
    }

    public void isTarget(Snake snake){
        game.setTarget(new Position(target.get(0), target.get(1), false));

        if(target.get(1)== snake.getPosition(snake.getSize()-1).getY()&&(target.get(0)== snake.getPosition(snake.getSize()-1).getX()||target.get(0)+1== snake.getPosition(snake.getSize()-1).getX())){
            targets++;
            snake.setCantCrash(true);
            snake.addOneToSnake();
            snake.moveSnake(new Position(target.get(0),target.get(1),true));
            newTarget();
        }
        else{
            System.out.println("Hej");
        }
    }

    public void newTarget(){
        target.clear();
        target.add((11 + (int)(Math.random() * 26))*2);
        target.add(4 + (int)(Math.random() * 20));
    }

    public void printHighScoore(Screen screen){

        screen.refresh();
        System.out.println("jadå");
        //screen.putString(10, 5, "Snake", Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(30, 7, "Scoore: " + steps+(targets*10), Terminal.Color.WHITE, Terminal.Color.BLACK);

        //screen.putString(20, 25, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", Terminal.Color.GREEN, Terminal.Color.GREEN);
        //screen.putString(20, 3, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", Terminal.Color.GREEN, Terminal.Color.GREEN);
//        for (int i = 3; i < 25; i++) {
//            screen.putString(20, i, "AA", Terminal.Color.MAGENTA, Terminal.Color.GREEN);
//            screen.putString(76, i, "AA", Terminal.Color.MAGENTA, Terminal.Color.GREEN);
//            //x under 22 över 75 quit;
//            //y under 4 över 24 quit;
//
//        }
    }
}
