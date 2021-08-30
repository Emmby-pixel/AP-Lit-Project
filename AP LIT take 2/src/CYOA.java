import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//import java.awt.event.MouseEvent;

public class CYOA {
	private Font fnt = new Font("arial", 1, 20);
	private static String choice = "";
	
	public CYOA(Graphics g) {
		g.setFont(fnt);
		if(choice.equals("")) {
			g.drawString("Hello! Pick one:", 180, 280);
			g.drawString("1. 1796", 180, 320);
			g.drawString("2. 1861", 180, 340);
			g.drawString("3. 1951", 180, 360);
		}
		
		//Wilhelm Meister
		if(choice.equals("1")) {
			presentQuestions(g, "res/wilhelm face.png");
			//Text: 
			g.drawString("Hello! I'm Wilhelm Meister from Johann", 180, 280);
			g.drawString("Wolfgang von Goethe’s Wilhelm Meister’s ", 180, 300);
			g.drawString("Apprenticeship!", 180, 320);
		}
				//if 1
				if (choice.equals("11")) {
					presentQuestions(g, "res/wilhelm face.png");
					g.drawString("Have I mentioned the acting yet??", 180, 280);
				}
				//if 2
				if (choice.equals("12")) {
					presentQuestions(g, "res/wilhelm face.png");
					g.drawString("Acting is my passion. Better than being rich,", 180, 280);
					g.drawString("being rich, amiright???", 180, 300);
				}
				//if 3
				if (choice.equals("13")) {
					presentQuestions(g, "res/wilhelm face.png");
					g.drawString("Yikes... that can of worms? I mean ok", 180, 280);
					g.drawString("I guess. I’m not even sure if I can count the ", 180, 300);
					g.drawString("number of children and romances I’ve had", 180, 320);
					g.drawString("lol jk.", 180, 340);
				}
				//if 4
				if (choice.equals("1_")) {
					clearScreen (g);
				}
		
		//Pip
		if(choice.equals("2")) {
			presentQuestions(g, "res/pip face.png");
			
			//Text:
			g.drawString("Hello! I'm Pip Pirrip from Charles", 180, 280);
			g.drawString("Dickens’s Great ", 180, 300);
			g.drawString("Expectations!", 180, 320);
			
		}
			//if 1
			if (choice.equals("21")) {
				presentQuestions(g, "res/pip face.png");
				g.drawString("Oh boy. Did you know I barely knew how to read", 180, 280);
				g.drawString("when I was young. I was taught by my “friend” Biddy.", 180, 300);
				g.drawString("Crazy, right?", 180, 320);
			}
			//if 2
			if (choice.equals("22")) {
				presentQuestions(g, "res/pip face.png");
				g.drawString("Haven't you heard?? I'm a straight up", 180, 280);
				g.drawString("gentleman.", 180, 300);
			}
			//if 3
			if (choice.equals("23")) {
				presentQuestions(g, "res/pip face.png");
				g.drawString("Family?? Uhh about that...", 180, 280);
			}
			//if 4
			if (choice.equals("2_")) {
				clearScreen (g);
			}
		
		//Holden
		if(choice.equals("3")) {
			presentQuestions(g, "res/Holden face.png");
			
			//Text:
			g.drawString("...Hey I'm Holden Caulfield from J.D.", 180, 280);
			g.drawString("Salinger's The Catcher in the Rye ", 180, 300);
			
		}
			//if 1
			if (choice.equals("31")) {
				presentQuestions(g, "res/Holden face.png");
				g.drawString("Yeah haha you can say I go to school.", 180, 280);
			}
			//if 2
			if (choice.equals("32")) {
				presentQuestions(g, "res/Holden face.png");
				g.drawString("uhh you know I'm still a teenager right?", 180, 280);
			}
			//if 3
			if (choice.equals("33")) {
				presentQuestions(g, "res/Holden face.png");
				g.drawString("... I mean yeah I guess I have a family.", 180, 280);
			}
			
			//if 4
			if (choice.equals("3_")) {
				clearScreen (g);
			}
		
		
		//other
		if (choice.equals("_")) {
			clearScreen (g);
		}
}

	
	public static void setChoice (String newChoice) {
		choice = newChoice;
		System.out.println(choice);
	}
	
	public static void addChoice (String newChoice) {
		choice+=newChoice;
	}
	
	public static String getChoice () {
		return choice;
	}
	
	public static void clearScreen (Graphics g) {
			g.setColor(Color.black);
			g.fillRect(180, 265, 400, 160);
	}
	
	public void presentQuestions(Graphics g, String path) {		
		ShowPicture.paint(path, g);
		clearScreen(g);
		g.setColor(Color.white);
		g.setFont(fnt);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		
		
		g.drawRect(40, 20, 300, 40);
		g.drawString("1. Ask about his education", 50, 50);
		
		g.drawRect(40, 80, 300, 40);
		g.drawString("2. Ask about his work", 50, 110);
		
		g.drawRect(40, 140, 300, 40);
		g.drawString("3. Ask about his family",50,170);
		
	}
	
	
}
