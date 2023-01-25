package GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class WindowManager {

    public JFrame frame;
    private JPanel panel;
    Graphics graphics;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;

    public WindowManager() {

        frame = new JFrame("Dungeon Crawler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

    }

    public void addPanel(JPanel panel) {
        this.panel = panel;
        this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.panel.setFocusable(true);
        this.panel.requestFocusInWindow();
    }
    public void showWindow(){
        this.frame.setContentPane(panel);
        frame.setVisible(true);
    }
    public void addKeyListener(KeyListener listener) {
        try {
            this.panel.addKeyListener(listener);
        } catch(NullPointerException e) {
            System.err.println("[WindowManager]: Error! Tried to add KeyListener before JPanel");
            System.exit(-1);
        }
    }

}
