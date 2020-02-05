import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The "Soccer Field" itself
 */
public class MyWorld extends World
{ 
    //Create an instant variable: ScoreBoard in the world.
    private ScoreBoard score;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
 
    public MyWorld()
    {    
        //Makes the World 800x600 boxes, with 1 box being 1 pixel wide and 1 pixel high.
        super(800, 600, 1); 
        
        //Initialize score
        score = new ScoreBoard();
        
        //Set the x position of ball; 125 plus a random number between 0 to 299. 
        //This generates x between 125 and 425.
        int ballx = 125 + Greenfoot.getRandomNumber(300);
        
        //Set the y position of ball; 125 plus a random number between 0 to 299. 
        //This generates y between 125 and 425.
        int bally = 125 + Greenfoot.getRandomNumber(300);
        
        //Add a new ball to the World, with the position (ballX,ballY)
        addObject(new Ball(), ballx, bally);
        
        //Add a scoreboard with counter
        addObject(score, 400, 15);
        
        //Add a goalPost under the scoreboard
        addObject(new GoalPost(), 250, 50);
        
        //Add another goalpost under the scoreboard
        addObject(new GoalPost(), 550, 50);
        
        //Add a new goalie with the initial position which is the center of the width of the world.
        addObject(new Goalie(), getWidth()/2, 70); 
        
        //Add a new shooter with the initial position which is the center of the world.
        addObject(new Shooter(), getWidth()/2, getHeight()/2);

    }
    /** 
     * returns the Scoreboard that is added by the constructor. 
     * 
     * @return score (the Scoreboard)
     */
    public ScoreBoard getScore(){
        return score;
    }
  
}
