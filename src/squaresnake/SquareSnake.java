/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squaresnake;

import controller.GameController;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Food;
import models.GameBackGround;
import models.Snake;
import util.Constant;
import view.MainPanel;

/**
 *
 * @author Terance Wijesuriya
 */
public class SquareSnake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Snake snake = new Snake();
        Food food = new Food();
        GameBackGround gameBackGround = new GameBackGround();

        MainPanel mainPanel = new MainPanel();
        GameController gameController = new GameController(food, snake, gameBackGround, mainPanel);        

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Square Snake");        

        mainPanel.setSize(Constant.WIDTH * Constant.CELL_SIZE, Constant.HEIGHT * Constant.CELL_SIZE);        
        mainPanel.addKeyListener(gameController);
        snake.addSnakeListener(gameController);

        frame.setSize(Constant.WIDTH * Constant.CELL_SIZE + 15, Constant.HEIGHT * Constant.CELL_SIZE + 35);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.addKeyListener(gameController);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gameController.newGame();
    }

}
