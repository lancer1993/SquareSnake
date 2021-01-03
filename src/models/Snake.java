/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import listener.SnakeListener;
import util.Constant;

/**
 *
 * @author Terance Wijesuriya
 */
public final class Snake {

    public static final int UP = 1;
    public static final int DOWN = -1;
    public static final int LEFT = 2;
    public static final int RIGHT = -2;

    public int win = 0;
    public int MaxScore = 0;
    private int oldDirection, newDirection;
    boolean suspend = false;
    public boolean life;

    private Point oldTail;
    private LinkedList<Point> body = new LinkedList<>();
    private Set<SnakeListener> listeners = new HashSet<>();

    public Snake() {
        init();
    }

    public void init() {
        Constant.SPEED = 200;
        body.clear();
        win = 0;
        int x = Constant.WIDTH / 2;
        int y = Constant.HEIGHT / 2;
        for (int i = 0; i < 2; i++) {
            Point init = new Point(x--, y);
            body.addFirst(init);
        }
        oldDirection = newDirection = LEFT;
        life = true;
    }

    public void move() {
        if (!(oldDirection + newDirection == 0)) {
            oldDirection = newDirection;
        }

        oldTail = body.removeLast();

        int x = body.getFirst().x;
        int y = body.getFirst().y;
        switch (oldDirection) {
            case UP:
                y--;
                if (y < 0) {
                    y = Constant.HEIGHT - 1;
                }
                break;
            case DOWN:
                y++;
                if (y > Constant.HEIGHT - 1) {
                    y = 0;
                }
                break;
            case LEFT:
                x--;
                if (x < 0) {
                    x = Constant.WIDTH - 1;
                }
                break;
            case RIGHT:
                x++;
                if (x > Constant.WIDTH - 1) {
                    x = 0;
                }
                break;
        }
        Point newHead = new Point(x, y);
        body.addFirst(newHead);

    }

    public void die() {
        life = false;
        JOptionPane.showMessageDialog(new JFrame(), "Game Over!\nYour Score is " + String.valueOf(MaxScore));
        MaxScore = 0;
    }

    public Point getHead() {
        return body.getFirst();
    }

    public void changeDirection(int direction) {
        newDirection = direction;
    }

    public void eatFood() {
        MaxScore = MaxScore + 1;
        body.addLast(oldTail);
    }

    public boolean isEatBody() {
        for (int i = 1; i < body.size(); i++) {
            if (body.get(i).equals(this.getHead())) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics g) {
        g.setColor(Constant.SNAKE_COLOR);
        for (Point p : body) {
            g.fill3DRect((p.x) * Constant.CELL_SIZE, p.y * Constant.CELL_SIZE, Constant.CELL_SIZE, Constant.CELL_SIZE, true);
        }

        Point pd = body.getFirst();
        g.setColor(Constant.HEAD_COLOR);
        g.fill3DRect((pd.x) * Constant.CELL_SIZE, pd.y * Constant.CELL_SIZE, Constant.CELL_SIZE, Constant.CELL_SIZE, true);
    }

    public void initSnake() {
        Constant.SNAKE_COLOR = new Color(0xCD2626);
    }

    private class SnakeRun implements Runnable {

        @Override
        public void run() {
            while (life) {
                move();
                listeners.forEach((l) -> {
                    l.snakeMoved(Snake.this);
                });
                try {
                    Thread.sleep(Constant.SPEED);
                    synchronized (this) {
                        while (suspend) {
                            Thread.sleep(100);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void pause() {
        suspend = !suspend;
    }

    public void start() {
        new Thread(new SnakeRun()).start();
    }

    public void addSnakeListener(SnakeListener l) {
        if (l != null) {
            this.listeners.add(l);
        }
    }

    public void reborn() {
        initSnake();
        start();
        init();
        life = true;
    }

}
