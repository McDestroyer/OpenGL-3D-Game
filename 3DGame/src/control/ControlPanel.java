package control;

import org.lwjgl.util.vector.Vector3f;

public class ControlPanel {
	
	// Screen

	public static final float FOV = 70;
	public static final float NEAR_PLANE = 0.1f;
	public static final float FAR_PLANE = 1000;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final int FPS_CAP = 120;
	
	// Background Color
	
	public static float clearRed = 0.3f;
	public static float clearGreen = 0.3f;
	public static float clearBlue = 1.0f;
	
	// Light Color
	
	public static Vector3f lightColor = new Vector3f(1.0f, 1.0f, 1.0f);
	
	//Light Location
	
	public static Vector3f lightLocation = new Vector3f(3000, 2000, 3000);
	
	// Camera Start Position
	
	public static float startX = 0.0f;
	public static float startY = 0.0f;
	public static float startZ = 0.0f;
	
	// Movement Speed
	
	public static float horizontalSpeed = 0.06f;
	public static float verticalSpeed = 0.04f;
	public static float cameraSpeed = 0.075f;
	public static float sprintMultiplier = 1.5f;
	
	public static boolean invertYAxis = true;
	
	// Window Title and Icon
	
	public static final String TITLE = "The game. Well, is it really a game? Idk...";
	//private static final ByteBuffer[] IMG = "The Game";
   
}
