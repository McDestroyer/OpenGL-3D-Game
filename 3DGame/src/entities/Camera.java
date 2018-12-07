package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import control.ControlPanel;
import engineTester.MainGameLoop;
import toolbox.Maths;
 
public class Camera {
     
    private Vector3f position = new Vector3f(ControlPanel.startX, ControlPanel.startY,
    		ControlPanel.startZ);
    private float pitch;
    private float yaw;
    private float roll;
     
    public Camera(){}
     
    public void move(){
    	                // Movement
    	// Forward
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            position.z -= ControlPanel.horizontalSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            position.z -= ControlPanel.horizontalSpeed * ControlPanel.sprintMultiplier;
        }
        // Backward
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            position.z += ControlPanel.horizontalSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            position.z += ControlPanel.horizontalSpeed * ControlPanel.sprintMultiplier;
        }
        // Right
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            position.x += ControlPanel.horizontalSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            position.x += ControlPanel.horizontalSpeed * ControlPanel.sprintMultiplier;
        }
        // Left
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            position.x -= ControlPanel.horizontalSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            position.x -= ControlPanel.horizontalSpeed * ControlPanel.sprintMultiplier;
        }
        // Up
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            position.y += ControlPanel.verticalSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            position.y += ControlPanel.verticalSpeed * ControlPanel.sprintMultiplier;
        }
        // Down
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            position.y -= ControlPanel.verticalSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)){
            position.y -= ControlPanel.verticalSpeed * ControlPanel.sprintMultiplier;
        }
                        // Mouse
        if(Display.isActive() && Mouse.isInsideWindow()) {
        	// Horizontal
        	yaw = (yaw + ControlPanel.cameraSpeed * (Mouse.getX() - ControlPanel.WIDTH / 2)) % 360;
        	// Horizontal loop
        	if(yaw > 180) yaw -= 360; else if(yaw < -180) yaw += 360;
        	// Vertical
        	if(ControlPanel.invertYAxis){
        		pitch = Maths.min(Maths.max(pitch + -ControlPanel.cameraSpeed * (Mouse.getY() - ControlPanel.HEIGHT / 2), -90.0f), 90.0f);
        	}
        	if(!ControlPanel.invertYAxis){
        		pitch = Maths.min(Maths.max(pitch + ControlPanel.cameraSpeed * (Mouse.getY() - ControlPanel.HEIGHT / 2), -90.0f), 90.0f);
        	}
        	// Reset
        	Mouse.setCursorPosition(ControlPanel.WIDTH / 2, ControlPanel.HEIGHT / 2);
        	System.out.println(yaw + " / " + pitch);
        }
                       // Exit
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
        	MainGameLoop.run = false;
        	
        }
    }
 
    public Vector3f getPosition() {
        return position;
    }
 
    public float getPitch() {
        return pitch;
    }
 
    public float getYaw() {
        return yaw;
    }
 
    public float getRoll() {
        return roll;
    }
     
     
 
}