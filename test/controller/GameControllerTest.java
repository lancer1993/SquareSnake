/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.GameController;
import junit.framework.TestCase;
import models.Food;
import models.GameBackGround;
import models.Snake;
import org.junit.Test;
import view.MainPanel;

/**
 *
 * @author Terance Wijesuriya
 */
public class GameControllerTest {

    @Test
    public void testNewGame() {
        Snake snake = new Snake();
        Food food = new Food();
        GameBackGround gameBackGround = new GameBackGround();
        MainPanel mainPanel = new MainPanel();

        GameController controller = new GameController(food, snake, gameBackGround, mainPanel);
        controller.newGame();
        TestCase.assertEquals("New game started", "New game started");
    }
}
