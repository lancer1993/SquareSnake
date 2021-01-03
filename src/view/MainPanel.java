/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import models.Food;
import models.GameBackGround;
import models.Snake;
import util.Constant;

/**
 *
 * @author Terance Wijesuriya
 */
public class MainPanel extends JPanel {

    private Food food;
    private Snake snake;
    private GameBackGround gameBackGround;

    public void display(Food food, Snake snake, GameBackGround gameBackGround) {
        this.food = food;
        this.snake = snake;
        this.gameBackGround = gameBackGround;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Constant.GAME_PANEL_COLOR);
        g.fillRect(0, 0, Constant.WIDTH * Constant.CELL_SIZE,
                Constant.HEIGHT * Constant.CELL_SIZE + 50);

        if (gameBackGround != null && snake != null && food != null) {
            this.gameBackGround.draw(g);
            this.snake.draw(g);
            this.food.draw(g);
        }
    }

}
