package mainEngine;

import org.lwjgl.util.vector.Vector3f;

import entities.Player;
import models.RawModel;
import models.TexturedModel;
import planets.Planet;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import textures.ModelTexture;

public class Config{
	
	private Player playerPlanet = null;
	private ModelTexture texturePlanet =null;
	public Config(){
		playerPlanet = null;
		texturePlanet =null;
		
	}
	
	public Config(Planet planet, Loader loader){
		
		RawModel rawPlanet = OBJLoader.loadObjmodel("sphere", loader);
		TexturedModel staticPlanet = new TexturedModel(rawPlanet,new ModelTexture(loader.loadTexture(planet.getColor())));
		texturePlanet = staticPlanet.getTexture();
		texturePlanet.setShineDamper(10f);
		texturePlanet.setReflectivitiy(0f);
		playerPlanet = new Player(staticPlanet,new Vector3f(planet.getDistanceRatio(),0 ,0),0,0,0,planet.getScale());//planet.getScale()
		
	}
	public Player getPlayer(){
		return playerPlanet;
	}
	public ModelTexture getModelTexture(){
		return texturePlanet;
	}
	
}

