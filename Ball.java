import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
                
 /**
 * The ball in our soccer game
 * 
 * @author Yuki Tsukamoto 
 * @version 10/24/2019
 */
 public class Ball extends Actor
 {
    //Create instant variables: the ball's speed and shoot angle
    private int speed;
    private double angle;
     /**
     * Constructor for a ball. 
     */
    public Ball()
    {
       speed = 0; //Initialize the speed
       angle = 0; //Initialize the angle
    }
       
    /**
     * Act - do whatever the Ball wants to do.
     * 
     * In our case, if we are moving, we shoud
     *   1) actually move
     *   2) check to see if we are hitting anything else
     *       * if the scoreboard, were we a goal or a miss? 
     *       * if the goalie, we're a miss
     *       * if any side (other than top, where screboard is),
     *            we're a miss
     */
    public void act() 
        {
        //The ball's position and the shooter's position
        int ballX, ballY, shooterX, shooterY; 
        
        //Variables to calcuate the shooting angle
        double deltaX, deltaY, tan;
        
        //Here, the speed is initially zero
        this.move(speed); 
        
        //Check if the shooter kicks↓
        Shooter isKicking = 
        (Shooter) this.getOneIntersectingObject(Shooter.class);
        
        //If the shooter kicks the ball
        if(isKicking!= null){
            ballX = this.getX(); //Get the current x position of the ball
            ballY = this.getY(); //Get the current y position of the ball
            
            //Get shooter's current x position, calling the shooter object the shooter class
            shooterX = (getWorld().getObjects(Shooter.class).get(0)).getX();
            //Get shooter's current y position, calling the shooter object the shooter class
            shooterY = (getWorld().getObjects(Shooter.class).get(0)).getY();
            
            deltaX = ballX - shooterX; //X1 - X2
            deltaY = shooterY - ballY; //Y2 - Y1
            
            tan = deltaY/deltaX; //calculate the tangent of the kicking angle
            
            //Since the arctan returns a limited range, we need to modify the value of theta
            //If deltaX < 0, we need to add 180 degree
            if(deltaX < 0){
            angle = Math.toDegrees(Math.atan(tan))+180;
            }
            
            //Otherwise, we do not need to do it
            else {
            angle = Math.toDegrees(Math.atan(tan));
            }
            setRotation(-(int)angle); //Set the direction where the ball goes
            speed = 1; //Move to the determined direction with the speed 1 pixel 
        }//if(isKicking!=null)
        
        //Call the methods in the class World
        World world = getWorld();
        //Call the methods in the class MyWorld
        MyWorld myworld = (MyWorld)world;
        
        //check is the goalie stops the ball
        Goalie stopsBall =
        (Goalie) this.getOneIntersectingObject(Goalie.class);
        
        //The final x position of the ball after being kicked
        int newBallX = getX();
        //The final y position of the ball after being kicked
        int newBallY = getY();
        
        //Get the value of the width of the World 
        int worldWidth = world.getWidth();
        //Get the value of the height of the World 
        int worldHeight = world.getHeight();
        
        //Goalie stops the ball or ball reaches an edge
        if(stopsBall!=null||(((newBallX < 250||newBallX > 550) && newBallY == 50))
        ||newBallX <= 0||newBallX >= worldWidth-1||newBallY >= worldHeight-1){
                ScoreBoard score = myworld.getScore(); //Call the method getScore() in the class ScoreBoard
                score.addMiss(); //Add 1 to the "Misses:", calling the method addMiss() in the class ScoreBoard
                world.removeObject(this); //Remove the ball once the Missing point is added
                
                //generate a new ball at a random location
                world.addObject(new Ball(),
                125 + Greenfoot.getRandomNumber(300),
                125 + Greenfoot.getRandomNumber(300));
            }
            
        //If the ball goals without being caught by a goalie
        if(stopsBall==null && newBallX > 250 && newBallX < 550 && newBallY == 50){
                ScoreBoard score = myworld.getScore();//Call the method getScore() in the class ScoreBoard
                score.addGoal();//Add 1 to the "Goals:", calling the method addGoal() in the class ScoreBoard
                world.removeObject(this);//Remove the ball once the goal point is added
                
                //generate a new ball at a random location
                world.addObject(new Ball(),
                125 + Greenfoot.getRandomNumber(300),
                125 + Greenfoot.getRandomNumber(300));
            }
    }//public void act
}


