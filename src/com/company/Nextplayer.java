package com.company;


import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

public class Nextplayer {

    public static void nextplayer(int player) throws InterruptedException {
        Screen screen = TerminalFacade.createScreen();
        screen.startScreen();
        screen.putString(10, 5, "Snake", Terminal.Color.WHITE, Terminal.Color.BLACK);
        screen.refresh();
        int x = 30;
        int y = 10;
        printScreen print = new printScreen();

        boolean keepRunning = true;
        Key key = screen.readInput();
        while(keepRunning){
            while(key == null){
                key = screen.readInput();
            }


            switch(key.getKind()){
                case Escape:
                    screen.stopScreen();
                    System.exit(0);
                    break;
                case ArrowRight:
                        while(key==null || key.getKind()== Key.Kind.ArrowRight || key.getKind()== Key.Kind.ArrowLeft){
                            x++;
                            key = print.printscreen(x,y,screen);

                    }
                    break;
                case ArrowLeft:
                    while(key==null || key.getKind()== Key.Kind.ArrowRight || key.getKind()== Key.Kind.ArrowLeft){
                        x--;
                        key = print.printscreen(x,y,screen);
                    }
                    break;
                case ArrowUp:
                    while(key==null || key.getKind()== Key.Kind.ArrowUp || key.getKind()== Key.Kind.ArrowDown){
                        y--;
                        key = print.printscreen(x,y,screen);
                    }
                    break;
                case ArrowDown:
                    while(key==null || key.getKind()== Key.Kind.ArrowUp || key.getKind()== Key.Kind.ArrowDown){
                        y++;
                        key = print.printscreen(x,y,screen);
                    }
                    break;
            }

            }


        }


    }

