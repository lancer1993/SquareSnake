/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Graphics;
import java.awt.Point;
import util.Constant;

/**
 *
 * @author Terance Wijesuriya
 */
public class Food extends Point {

    public void newFood(Point p) {
        this.setLocation(p);
    }

    public boolean isSnakeEatFood(Snake snake) {
        return this.equals(snake.getHead());
    }

    public void draw(Graphics g) {
        g.setColor(Constant.FOOD_COLOR);
        g.fill3DRect(x * Constant.CELL_SIZE, y * Constant.CELL_SIZE,
                Constant.CELL_SIZE, Constant.CELL_SIZE, true);

    }
}
