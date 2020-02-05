import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A goalie has a very interesting life. They just move back
 *    and forth between two locations all the time
 *
 */
public class Goalie extends Actor
{
  
    /**
     * Act - have the goalie just move back and forth between
     * the goalposts
     */
    public void act() 
    {
        move(1); //Constantly moving with the speed 1 pixel
        
        //If the goalie reaches the edge of the goal post
        if(this.isTouching(GoalPost.class)){
            turn(180); //Turn 180 degree
            getImage().mirrorVertically(); //Fix the upside down image of the goalie after turning 180 degree
        }
    } 
    
}
