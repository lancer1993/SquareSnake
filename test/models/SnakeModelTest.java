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
public class SnakeModelTest {
    
    private Snake snake = new Snake();
    
    @Test
    public void testMove(){
        snake.move();
        TestCase.assertEquals("Moving is started", "Moving is started");
    }
    
    @Test
    public void testDie(){
        snake.die();
        TestCase.assertEquals("Snake dead", "Snake dead");
    }
    
    @Test
    public void testGetHead(){
        Point point = snake.getHead();
        TestCase.assertEquals("X & Y : " + point.x + " - "+point.y, "Actual X & Y : "+ point.x + " - " + point.y);
    }
    
    @Test
    public void testChangeDirection(){
        snake.changeDirection(1);
        TestCase.assertEquals("Direction changed", "Snake direction changing");
    }
    
    @Test
    public void testEatFood(){
        snake.eatFood();
        TestCase.assertEquals("Sanke ate", "Snake is starting eat");
    }
    
    @Test
    public void isEatBody() {
        boolean eat = snake.isEatBody();
        TestCase.assertEquals("Sanke ate its body", eat, eat);
    }
    
    @Test
    public void pause() {
        snake.pause();
        TestCase.assertEquals("Game paused", "Game paused");
        
    }
    
    @Test
    public void start() {
        snake.start();
        TestCase.assertEquals("Game started", "Game started");
    }
    
    @Test
    public void reborn() {
        snake.reborn();
        TestCase.assertEquals("Game re-started", "Game re-started");
    }
    
}
