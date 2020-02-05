import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The "player" that is trying to score goals
 * 
 */
public class Shooter extends Actor
{
    /**
     * Act - allows the player to move and kicks the ball whenever
     *   they "run into" the ball
     */
    public void act() 
    {
     if(Greenfoot.isKeyDown("right")){
           this.move(1); //When the user holds the right key, the shooter moves to right with the speed 1 pixel
        }
     if(Greenfoot.isKeyDown("left")){
           this.move(-1);//When the user holds the left key, the shooter moves to left with the speed 1 pixel
        }
     if(Greenfoot.isKeyDown("up")){
           this.setLocation(getX(), getY()-1);
           //When the user holds the up key, the shooter moves upward with the speed 1 pixel
        }
     if(Greenfoot.isKeyDown("down")){
           this.setLocation(getX(), getY()+1);
           //When the user holds the down key, the shooter moves downward with the speed 1 pixel
        }
    }    
}
