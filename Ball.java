/**
 * Models a simple solid sphere. 
 * This class represents a Ball object. When combined with the GameArena class,
 * instances of the Ball class can be displayed on the screen.
 */

import java.util.Random;

public class Ball 
{
	// The following instance variables define the
	// information needed to represent a Ball
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;			// The X coordinate of this Ball
	private double yPosition;			// The Y coordinate of this Ball
	private double size;				// The diameter of this Ball
	private int layer;					// The layer of this ball is on.
	private String colour;				// The colour of this Ball

										// Permissable colours are:
										// BLACK, BLUE, CYAN, DARKGREY, GREY,
										// GREEN, LIGHTGREY, MAGENTA, ORANGE,
										// PINK, RED, WHITE, YELLOW or #RRGGBB 
	private int movementX = 1;
	private int movementY = 0;
	/**
	 * Constructor. Creates a Ball with the given parameters.
	 * @param x The x co-ordinate of centre of the Ball (in pixels)
	 * @param y The y co-ordinate of centre of the Ball (in pixels)
	 * @param diameter The diameter of the Ball (in pixels)
	 * @param col The colour of the Ball (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 */
	public Ball(double x, double y, double diameter, String col)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
		this.colour = col;
		this.layer = 0;
	}	

	public int getMovementX(){
		return this.movementX;
	}
	public int getMovementY(){
		return this.movementY;
	}
	public void setMovementX(int mov){
		this.movementX = mov;
	}
	public void setMovementY(int mov){
		this.movementY = mov;
	}
	/**
	 * Constructor. Creates a Ball with the given parameters.
	 * @param x The x co-ordinate of centre of the Ball (in pixels)
	 * @param y The y co-ordinate of centre of the Ball (in pixels)
	 * @param diameter The diameter of the Ball (in pixels)
	 * @param col The colour of the Ball (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 * @param layer The layer this ball is to be drawn on. Objects with a higher layer number are always drawn on top of those with lower layer numbers.
	 */
	public Ball(double x, double y, double diameter, String col, int layer)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
		this.colour = col;
		this.layer = layer;
	}	

	/**
	 * Obtains the current position of this Ball.
	 * @return the X coordinate of this Ball within the GameArena.
	 */
	public double getXPosition()
	{
		return xPosition;
	}

	/**
	 * Obtains the current position of this Ball.
	 * @return the Y coordinate of this Ball within the GameArena.
	 */
	public double getYPosition()
	{
		return yPosition;
	}

	/**
	 * Moves the current position of this Ball to the given co-ordinates
	 * @param x the new x co-ordinate of this Ball
	 */
	public void setXPosition(double x)
	{
		this.xPosition = x;
	}

	/**
	 * Moves the current position of this Ball to the given co-ordinates
	 * @param y the new y co-ordinate of this Ball
	 */
	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

	/**
	 * Obtains the size of this Ball.
	 * @return the diameter of this Ball,in pixels.
	 */
	public double getSize()
	{
		return size;
	}
	
	/**
	 * Sets the diameter of this Ball to the given size.
	 * @param s the new diameter of this Ball, in pixels.
	 */
	public void setSize(double s)
	{
		size = s;
	}

	/**
	 * Obtains the layer of this Ball.
	 * @return the layer of this Ball.
	 */
	public int getLayer()
	{
		return layer;
	}

	/**
	 * Sets the layer of this Ball.
	 * @param l the new layer of this Ball. Higher layer numbers are drawn on top of low layer numbers.
	 */
	public void setLayer(int l)
	{
		layer = l;
	}

	/**
	 * Obtains the colour of this Ball.
	 * @return a textual description of the colour of this Ball.
	 */
	public String getColour()
	{
		return colour;
	}

	/**
	 * Sets the colour of this Ball.
	 * @param c the new colour of this Ball, as a String value. Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or #RRGGBB.
	 */
	public void setColour(String c)
	{
		colour = c;
	}

	public void move(GameArena arena){
		int movementX = this.getMovementX();
		int movementY = this.getMovementY();
		Random rand = new Random();
		this.setYPosition(this.getYPosition()+movementY);
		this.setXPosition(this.getXPosition()+movementX);
		if (this.getXPosition() == arena.getArenaWidth() || this.getYPosition() == 0 || this.getXPosition() == 0|| this.getYPosition() == arena.getArenaHeight()){
			int r = rand.nextInt(4);
			if(Math.abs(movementX) != Math.abs(movementY)){
				if( this.getXPosition() == arena.getArenaWidth()){
					this.setMovementY(-1);
					this.setMovementX(-1);
				}
				if( this.getXPosition() == 0){
					this.setMovementY(1);
					this.setMovementX(1);
				}
				if( this.getYPosition() == arena.getArenaHeight()){
					this.setMovementY(-1);
					this.setMovementX(1);
				}
				if( this.getYPosition() == 0){
					this.setMovementY(1);
					this.setMovementX(-1);
				}
			}
			if(Math.abs(movementX) == Math.abs(movementY)){
				if (r == 0){
					this.setMovementY(-1*movementY);
					this.setMovementX(-1*movementX);
				}
				if (r == 1){
					this.setMovementY(1*movementY);
					this.setMovementX(-1*movementX);
				}
				if (r == 2){
					this.setMovementY(-1*movementY);
					this.setMovementX(1*movementX);
				}
			}
		}
		try{
			Thread.sleep(1);
		} catch (InterruptedException iex) {}
	}

}
