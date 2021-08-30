import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput (Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player
				
				if(key == KeyEvent.VK_UP) {
					tempObject.setVelocityY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_DOWN) {
					tempObject.setVelocityY(5);
					keyDown[1] = true;
				}
				if(key == KeyEvent.VK_LEFT) {
					tempObject.setVelocityX(-5);
					keyDown[2] = true;
				}
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setVelocityX(5);
					keyDown[3] = true;
				}
				
			}
		}
		
		
	}
	
	public void keyReleased (KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player
				
				if(key == KeyEvent.VK_UP) {
					keyDown[0] = false;
				}
				if(key == KeyEvent.VK_DOWN) {
					keyDown[1] = false;
				}
				if(key == KeyEvent.VK_LEFT) {
					keyDown[2] = false;
				}
				if(key == KeyEvent.VK_RIGHT) {
					keyDown[3] = false;
				}
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) {
					tempObject.setVelocityY(0);
				}
				
				//horizontal movement
				if(!keyDown[2] && !keyDown[3]) {
					tempObject.setVelocityX(0);
				}
			}
		}
	}
}