import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;


public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	
	public void mousePressed (MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		int counter1 = 1;
		int counter2 = 1;
		int counter3 = 1;
		int counter4 = 1;
		String sum = "";
		
		//play button
		
		if(mouseOver (mx,my,400, 20, 100, 40)) {
			if (Game.gameState == Game.STATE.Game) {
				Game.gameState = Game.STATE.Menu;
				 counter1 = 1;
				 counter2 = 1;
				 counter3 = 1;
				 counter4 = 1;
				 CYOA.setChoice("");
			}
			
		}
		
		if (mouseOver (mx, my, 200, 250, 200, 64)) {
			if (Game.gameState == Game.STATE.Menu) {
				Game.gameState = Game.STATE.Game;
				//handler.addObject(new Player(Game.width/2-32, Game.height/2-32, ID.Player));	
			}
		} else if (mouseOver (mx, my, 550, 20, 40, 40)) {
			if (Game.gameState == Game.STATE.Game) {
				for(int i=1; i<(counter1+1); i++) {
					sum+=1;
				}
				counter1++;
				CYOA.addChoice(sum);
				CYOA.setChoice(CYOA.getChoice());
			}
			
		} else if (mouseOver (mx, my, 550, 80, 40, 40)) {
			if (Game.gameState == Game.STATE.Game) {
				for(int i=1; i<(counter2+1); i++) {
					sum+=2;
				}
				counter2++;
				CYOA.addChoice(sum);
				CYOA.setChoice(CYOA.getChoice());
			}
		} else if (mouseOver (mx, my, 550, 140, 40, 40)) {
			if (Game.gameState == Game.STATE.Game) {
				for(int i=1; i<(counter3+1); i++) {
					sum+=3;
				}
				counter3++;
				CYOA.addChoice(sum);
				CYOA.setChoice(CYOA.getChoice());
			}
		} else if (mouseOver (mx, my, 550, 200, 40, 40)) {
			if (Game.gameState == Game.STATE.Game) {
				for(int i=1; i<(counter4+1); i++) {
					sum+="_";
				}
				counter4++;
				CYOA.addChoice(sum);
				CYOA.setChoice(CYOA.getChoice());
			}
		} else if (mouseOver (mx, my, 400, 60, 100, 40)) {
			if (Game.gameState == Game.STATE.Game) {
				if(CYOA.getChoice().substring(0,1).equals("1")) {
					CYOA.setChoice("1");
				}
					
				} if(CYOA.getChoice().substring(0,1).equals("2")) {
					CYOA.setChoice("2");
					
				} if (CYOA.getChoice().substring(0,1).equals("3")) {
					CYOA.setChoice("3");
				}
	
			}
		
		
	}
	
	public void mouseReleased (MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && (mx< x + width)) {
			if (my > y && (my< y + height)) {
				return true;
			} 
		}
		
		return false;
	}
	
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		if (Game.gameState == Game.STATE.Game) {
			Font fnt = new Font("arial", 1, 50);		
			Font fnt2 = new Font ("arial", 1, 20);
			g.setFont(fnt);
			g.setColor(Color.white);
			
			g.drawRect(170, 260, 440, 170);
			g.drawRect(20, 260, 130, 170);
			
			g.setFont(fnt2);
			g.drawRect(550, 20, 40, 40);
			g.drawString("1", 570, 40);
			
			g.drawRect(550, 80, 40, 40);
			g.drawString("2", 570, 100);
			
			g.drawRect(550, 140, 40, 40);
			g.drawString("3", 570, 160);
			
			g.drawRect(550, 200, 40, 40);
			g.drawString("", 570, 220);
			
			g.drawRect(400, 20, 100, 40);
			g.drawString("Restart", 410, 50);
			
		
			g.drawRect(400, 60, 100, 40);
			g.drawString("Back", 410, 90);
			
			new CYOA (g);
			
		} else if (Game.gameState == Game.STATE.Menu) {
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font ("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Maturity in Fiction", 100, 70);
			
			g.setFont(fnt2);
			g.drawRect(200, 250, 200, 64);
			g.drawString("Play", 270, 290);	
		
	}
	
	}
		
	}