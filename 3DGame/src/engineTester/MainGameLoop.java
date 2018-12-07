package engineTester;
 
import models.RawModel;
import models.TexturedModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import control.ControlPanel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import textures.ModelTexture;
import entities.Camera;
import entities.Entity;
import entities.Light;
 
public class MainGameLoop {
	
	public static boolean run = true;
 
    public static void main(String[] args) {
 
        DisplayManager.createDisplay();
        Loader loader = new Loader();
         
        /* Model + texture names list:
         * stall + stall
         * dragon + blank
         * exampleOBJ + white
         * tree + tree
        */
        // Models
        
        // Example of setting the model(s) and texture(s) to be used in the loop below:
        RawModel Model = OBJLoader.loadObjModel("exampleOBJ", loader);
        TexturedModel staticModel = new TexturedModel(Model,new ModelTexture(loader.loadTexture("white")));
        ModelTexture texture = staticModel.getTexture();
        texture.setShineDamper(10f);
        texture.setReflectivity(1f);
        // -----
        
        // You can make new Entities at any time
        // Single model example                                  location    rotation scale
        //Entity model = new Entity(staticModel, new Vector3f(0, -4.5f, -25), 0, 0, 0, 1f);
        // -----
        
        // Lights

        //Light light = new Light(new Vector3f(0, 0.0f, 20), new Vector3f(0.625f, 0.0f, 0.0f));
        //Light light = new Light(new Vector3f(0, 0.0f, 20), new Vector3f(0.2f, 0.2f, 1.0f));
        Light light = new Light(ControlPanel.lightLocation, ControlPanel.lightColor);
        // -----
        
        
        Camera camera = new Camera();
        
        List<Entity> allModels = new ArrayList<Entity>();
        Random random = new Random();
        // Example of creating 200 entities using the model and texture stated above:
        for (int i = 0; i < 200; i++) {
        	float x = random.nextFloat() * 100 - 50;
        	float y = (random.nextFloat() * 100 - 50) * 0; // Set to 0 temporarily
        	float z = random.nextFloat() * -300;
        	allModels.add(new Entity(staticModel, new Vector3f(x, y, z),
        			random.nextFloat() * 180f * 0, random.nextFloat() * 180f, 0f, 0.2f));
        }
        // -----
        MasterRenderer renderer = new MasterRenderer();
        while(!Display.isCloseRequested() && run){
            camera.move();
            // Entity for-loops here scroll through all entities in the specified list:
            for (Entity model : allModels) {
                renderer.processEntity(model);
            }
            // -----
            renderer.render(light, camera);
            DisplayManager.updateDisplay();
        }
        
        renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
 
    }
 
}