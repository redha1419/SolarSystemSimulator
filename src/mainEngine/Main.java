package mainEngine;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Light;

import guis.GuiRenderer;
import guis.GuiTexture;

import planets.Orbit;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;

//@SuppressWarnings("unused")
public class Main extends Orbit{

	public static void main(String[] args) {
		
		try {
			Orbit.main(args);
			System.out.println("Planet data created succesfully!");
		} catch (IOException e) {
			System.err.println("Planet data could not be created!");
			e.printStackTrace();
		}
		
		DisplayManager.createDisplay();
		Loader loader = new Loader(); 
		
		///GUIS
		List<GuiTexture> guis = new ArrayList<GuiTexture>();
		GuiTexture gui = new GuiTexture(loader.loadTexture("1.0"), new Vector2f(-0.59f,0.9f), new Vector2f(0.4f,0.09f));
		guis.add(gui);
		
		GuiRenderer guiRenderer = new GuiRenderer(loader);
		
		
		
		/*
		/////3D-MODElS////////// -REAL VARIABLES - ATTRIVUTES FOR 1 OBJECT - SUN
		
		RawModel rawSun = OBJLoader.loadObjmodel("sphere", loader);
		TexturedModel staticSun = new TexturedModel(rawSun,new ModelTexture(loader.loadTexture(planets[0].getColor())));
		staticSun.getTexture().setHasTransperency(true);
		staticSun.getTexture().setUseFakeLighting(true);
		ModelTexture textureSun = staticSun.getTexture();
		textureSun.setShineDamper(1000000000000000000000000f);
		textureSun.setReflectivitiy(10000000000000000000000f);
		Entity entitySun = new Entity(staticSun,new Vector3f(0,0 ,-10),0,0,0,planets[0].getScale());
		
		
		
		/////////////// -REAL VARIABLES - ATTRIVUTES FOR 1 OBJECT - MERCURY  - max x - vector is +/- 6.87 ... tested
		RawModel rawSpaceShip = OBJLoader.loadObjmodel("sphere", loader);
		TexturedModel staticSpaceShip = new TexturedModel(rawSpaceShip,new ModelTexture(loader.loadTexture(planets[0].getColor())));
		ModelTexture textureSpaceShip = staticSpaceShip.getTexture();
		textureSpaceShip.setShineDamper(10f);
		textureSpaceShip.setReflectivitiy(0f);
		//Entity entityMercury = new Entity(staticMercury,new Vector3f(mercury.getDistanceRatio(),0 ,-10),0,0,0,mercury.getScale());
		Player player = new Player(staticSpaceShip,new Vector3f(0,0,10),0,0,0,1);
		*/
		
		//planets[0].setColor("sunmap");
		
		
		List<Config> configs = new ArrayList<Config>();
		for(int i = 0; i<= 9;i++){
			Config configurationPlanet = new Config(planets[i],loader);
			if(i == 9){
				System.out.println("Planet "+i+" loaded");
				System.out.println("Succesfully configured all planets!");
			}else{
			System.out.println("Planet "+i+" loaded...");
			}
			configs.add(configurationPlanet);
		}		
		configs.get(0).getModelTexture().setShineDamper(1000000000000000000000000f);
		configs.get(0).getModelTexture().setReflectivitiy(10000000000000000000000f);
		
		

		////////////////////////////LIGHTS & CAMERA//////////////////////////////
		
		
		//Light ambientLight = new Light(new Vector3f(0,0,10), new Vector3f(1,1,1));
		Light sunLight = new Light(new Vector3f(0,0f ,0f), new Vector3f(10,10,10),new Vector3f(2f,1f,0.49f));
		List<Light> lights = new ArrayList<Light>();
		//lights.add(ambientLight);
		lights.add(sunLight);
		Camera camera = new Camera();
		
		
		////////////////////RENDERING!!!
		
		MasterRenderer renderer = new MasterRenderer(loader);
		
		while(!Display.isCloseRequested()){
			//game logic
			
			for (int i=0;i<=9; i++){
			configs.get(i).getPlayer().move(planets[i]);
			}
			
			
			for (int i=0;i<=9; i++){
				renderer.processEntity(configs.get(i).getPlayer());
			}
			camera.move();
			renderer.render(lights, camera);
			guiRenderer.render(guis);
			DisplayManager.updateDisplay();
			
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				break;
			}
			
		}
		guiRenderer.cleanUp();
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		System.out.println("Succesfully Terminated!");
		
	}

}
