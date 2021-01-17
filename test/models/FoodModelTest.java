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
public class FoodModelTest {
    
    private Food food = new Food();
    private Snake snake = new Snake();
    
    @Test
    public void testNewFood(){
        int x = food.x;        
        int y = food.y;        
        Point point = new Point(x, y);
        food.newFood(point);
        TestCase.assertEquals("Point created", point, this);
    }
    
    @Test
    public void isSnakeEatFoodTest(){
        boolean eat = food.isSnakeEatFood(snake);
        TestCase.assertEquals(eat, eat);
    }
    
}
