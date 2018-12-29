package com.company;


import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

public class Nextplayer {

    public static void nextplayer(int player) throws InterruptedException {
        Screen screen = TerminalFacade.createScreen();
        GameController game = new GameController();
        screen.startScreen();
        int steps = 0;
        int x = 30;
        int y = 10;
        int size = 1;
        Snake snake = new Snake(new Position(0,0, false));
        snake.moveSnake(new Position(x,y, false));
        screen.putString(10, 5, "Snake", Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.putString(10, 7, "Scoore" + steps, Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.refresh();

        printScreen print = new printScreen();
        boolean keepRunning = true;
        Key key = screen.readInput();

        while(keepRunning && game.stillAlive(x,y)){
            while(key == null){
                key = screen.readInput();
            }
                print.isTarget(snake);
            switch(key.getKind()){
                case Escape:
                    screen.stopScreen();
                    System.exit(0);
                    break;
                case ArrowRight:
                        while(!game.isDead(snake) && game.stillAlive(x,y) && (key==null || key.getKind()== Key.Kind.ArrowRight || key.getKind()== Key.Kind.ArrowLeft)){
                            x+=2;
                            snake.moveSnake(new Position(x,y,false));
                            key = print.printscreen(snake,screen);
                    }
                    break;
                case ArrowLeft:
                    while(!game.isDead(snake) && game.stillAlive(x,y) && (key==null || key.getKind()== Key.Kind.ArrowRight || key.getKind()== Key.Kind.ArrowLeft)){
                        x-=2;
                        snake.moveSnake(new Position(x,y, false));
                        key = print.printscreen(snake,screen);
                    }
                    break;
                case ArrowUp:
                    while(!game.isDead(snake) && game.stillAlive(x,y) && (key==null || key.getKind()== Key.Kind.ArrowUp || key.getKind()== Key.Kind.ArrowDown)){
                        y--;
                        snake.moveSnake(new Position(x,y, false));
                        key = print.printscreen(snake,screen);
                    }
                    break;
                case ArrowDown:
                    while(!game.isDead(snake) && game.stillAlive(x,y) && (key==null || key.getKind()== Key.Kind.ArrowUp || key.getKind()== Key.Kind.ArrowDown)){
                        y++;
                        snake.moveSnake(new Position(x,y, false));
                        key = print.printscreen(snake,screen);
                    }
                    break;
            }

            }
        System.out.println("jippi");
        game.showHighScoore(screen);
    }

        }




