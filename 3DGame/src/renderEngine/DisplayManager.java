package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import control.ControlPanel;

public class DisplayManager {
	
	// Screen Size
	private static final int WIDTH = ControlPanel.WIDTH;
	private static final int HEIGHT = ControlPanel.HEIGHT;
	// FPS Cap
	private static final int FPS_CAP = ControlPanel.FPS_CAP;
	// Window Title
	private static final String TITLE = ControlPanel.TITLE;
	// Icon (later)
	//private static final ByteBuffer[] IMG = ControlPanel.IMG;
	

	public static void createDisplay() {
		
		ContextAttribs attribs = new ContextAttribs(3,2)
				.withForwardCompatible(true)
				.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(TITLE);
			//Display.setIcon(IMG);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		
	}
	
	public static void updateDisplay() {
		
		Display.sync(FPS_CAP);
		Display.update();
		
	}
	
	public static void closeDisplay() {

		Display.destroy();
		
	}
	
	
}