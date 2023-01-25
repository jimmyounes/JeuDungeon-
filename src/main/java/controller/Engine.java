package controller;

import GameState.GameState;
import GameState.GameStateManager;
import GameState.WindowManager;
import model.Dungeon;
import GameState.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Engine {

        //private static GameStateManager gameStateManager;
       public static  Game game;
        WindowManager windowManager;

        public Engine() {
        }

        public void start(){

         //  gameStateManager=new GameStateManager();
               game=new Game();
            WindowManager windowManager=new WindowManager();
            windowManager.addPanel(new GameScreen());
            windowManager.addKeyListener(new Keyboard());
            windowManager.showWindow();
            while (true){

            }
        }
        private static class GameScreen extends JPanel {

            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                try {
                        game.render(g);
                    //gameStateManager.render(g);

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
        private static class Keyboard implements KeyListener {

            @Override
            public void keyPressed(KeyEvent key) {
                try {
                    game.keyPressed(key.getKeyChar());
                    //gameStateManager.keyPressed(key.getKeyChar());
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }


            @Override
            public void keyTyped(KeyEvent arg0) {}

        }

    }


