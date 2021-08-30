import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}
	
	public void tick() {
		x+= velX;
		y+= velY;
		
		//set boundaries
		x= Game.clamp(x, 0, Game.width-45);
		y= Game.clamp(y, 0, Game.height-250);
		
		
	}
	
	public void render (Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	
}