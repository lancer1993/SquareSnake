/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Point;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Terance Wijesuriya
 */
public class GameBackGroundModelTest {
    
    private GameBackGround gameBackGround = new GameBackGround();
    private Snake snake = new Snake();    
    
    @Test
    public void isSnakeEatRockTest(){
        boolean eat = gameBackGround.isSnakeEatRock(snake);
        TestCase.assertEquals("Snake eats a rock", eat, eat);
    }
    
    @Test
    public void testPoint(){
        Point point = gameBackGround.getPoint();
        TestCase.assertEquals("Point is valid", point, this);
    }
    
}
