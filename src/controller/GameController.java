/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import listener.SnakeListener;
import models.Food;
import models.GameBackGround;
import models.Snake;
import util.Constant;
import view.MainPanel;

/**
 *
 * @author Terance Wijesuriya
 */
public class GameController extends KeyAdapter implements SnakeListener {

    private final Food food;
    private final Snake snake;
    private final GameBackGround gameBackGround;
    private final MainPanel mainPanel;

    public GameController(Food food, Snake snake, GameBackGround gameBackGround, MainPanel mainPanel) {
        super();
        this.food = food;
        this.snake = snake;
        this.gameBackGround = gameBackGround;
        this.mainPanel = mainPanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                snake.changeDirection(Snake.UP);
                break;
            case KeyEvent.VK_DOWN:
                snake.changeDirection(Snake.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                snake.changeDirection(Snake.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                snake.changeDirection(Snake.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                snake.pause();
                break;
            case KeyEvent.VK_ENTER:
                snake.reborn();
                break;
            case KeyEvent.VK_INSERT:
                snake.eatFood();
                break;
        }

    }

    @Override
    public void snakeMoved(Snake snake) {
        if (snake.isEatBody()) {
            snake.die();
        }
        if (gameBackGround.isSnakeEatRock(snake)) {
            snake.die();
        }
        if (food.isSnakeEatFood(snake)) {
            snake.eatFood();
            snake.win = snake.win + 1;
            Constant.SPEED -= Constant.SPEED_ADD;
            food.newFood(gameBackGround.getPoint());
        }
        mainPanel.display(food,snake,gameBackGround);
    }
    
    public void newGame() {
        snake.start();
        food.newFood(gameBackGround.getPoint());
    }

}
