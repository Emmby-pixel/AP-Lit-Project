/// AP LIT 


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
//import java.io.File;
//import java.lang.reflect.Array;

//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3981424055224478122L;
	
	public static final int width=640, height = width/12*9;
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private Menu menu;
	
	public enum STATE {
		Menu, Game
	};
	
	public static STATE gameState = STATE.Menu; 
	
	public Game() {
		handler = new Handler();
		menu = new Menu(this, handler);
		this.addKeyListener(new KeyInput (handler));		
		this.addMouseListener(menu);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		
		new Windows(width, height, "Title", this);
		
		//will need to do for each ID object?
		if (gameState == STATE.Game) {
			//sets box at x,y
			handler.addObject(new Player(width/2-32, height/2-32, ID.Player));
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0.0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta+= (now-lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
				frames++;
			}
			if(System.currentTimeMillis()-timer >1000) {
				timer+=1000;
				//System.out.println("FPS: "+frames);
				frames = 0;
			}
		}
		stop();
     }
	
	private void tick() {
		handler.tick();
		
		if(gameState == STATE.Menu) {
			menu.tick();
		}
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0,0,width, height);
		
		handler.render(g);
		
		if (gameState == STATE.Menu || gameState == STATE.Game) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp (int var, int min, int max) {
		if(var>=max) {
			return var=max;
		}
		else if (var <=min) {
			return var=min;
		}
		return var;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
		
		
		
	}
}