package main;

/*******************************************************************************
* Thomas Barrett
* Period 1
* Mar 24, 2016
* Description: GameComponent with a position, width, and height, and movement
*******************************************************************************/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

@SuppressWarnings("serial")
public class GameObject extends Rectangle2D.Double implements Directions{
	
	//scene that object belongs to
	public Scene scene;
	
	//position and movement information
	public double dx, dy;

	//creates a new game object based on coordinates and dimensions
	public GameObject(Scene s,double x, double y, double width, double height)
	{
		super(x, y, width, height);
		
		scene=s;
	}
	
	//creates a new game object based on coordinates and dimensions
	public GameObject(double x, double y, double width, double height)
	{
		super(x,y,width,height);
		scene=null;
	}
		
	//stops the object
	public void stop()
	{
		dx=0;
		dy=0;
	}

	//returns the distance in pixels away from object
	public double distance(GameObject o)
	{
		return Math.sqrt((o.y-y)*(o.y-y)+(o.x-x)*(o.x-x));
	}


	//returns the orientation of an object in relation to another
	public int directionComparedTo(GameObject o)
	{
		if (o.x+o.width/2>x+width/2)
			return Left;
		return Right;
	}
	
	//sets the objects horizontal speed
	public void setHorizontalSpeed(int x)
	{
		dx=x;
	}

	//sets the objects vertical speed
	public void setVerticalSpeed(int y)
	{
		dy=y;
	}

	//sets the objects horizontal and vertical speed
	public void setSpeed(int x, int y)
	{
		dx=x;
		dy=y;
	}

	//sets the objects speed in a specified direction
	public void setSpeedInDirection(int direction, int speed)
	{
		switch (direction)
		{
			case Up:
				dy=-speed;
				break;
			case Down:
				dy=speed;
				break;
			case Left:
				dx=-speed;
				break;
			case Right:
				dx=speed;
				break;
		}
	}


	//increases the objects speed in a certain direction by the given value
	public void accelerate(int dx, int dy)
	{

		this.dx+=dx;
		this.dy+=dy;
	}

	//moves position according to dx and dy values
	public void update()
	{
		x+=dx;
		y+=dy;
	}

	//paints grey square of width and height
	public void paint(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

}
