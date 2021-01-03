/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import util.Constant;

/**
 *
 * @author Terance Wijesuriya
 */
public class GameBackGround extends Point {

    private int[][] rocks = new int[Constant.WIDTH][Constant.HEIGHT];

    public GameBackGround() {
        for (int x = 0; x < Constant.WIDTH; x++) {
            rocks[x][0] = 1;
            rocks[x][Constant.HEIGHT - 1] = 1;
        }
        for (int y = 0; y < Constant.HEIGHT; y++) {
            rocks[0][y] = 1;
            rocks[Constant.WIDTH - 1][y] = 1;
        }
    }

    public boolean isSnakeEatRock(Snake snake) {
        for (int x = 0; x < Constant.WIDTH; x++) {
            for (int y = 0; y < Constant.HEIGHT; y++) {
                if (rocks[x][y] == 1
                        && (x == snake.getHead().x && y == snake.getHead().y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Point getPoint() {
        Random random = new Random();
        int x = 0, y = 0;
        do {
            x = random.nextInt(Constant.WIDTH);
            y = random.nextInt(Constant.HEIGHT);
        } while (rocks[x][y] == 1);
        return new Point(x, y);
    }

    public void draw(Graphics g) {
        g.setColor(Constant.ROCK_COLOR);
        for (int x = 0; x < Constant.WIDTH; x++) {
            for (int y = 0; y < Constant.HEIGHT; y++) {
                if (rocks[x][y] == 1) {
                    g.fill3DRect(x * Constant.CELL_SIZE, y * Constant.CELL_SIZE,
                            Constant.CELL_SIZE, Constant.CELL_SIZE, true);
                }
            }
        }
    }

}
