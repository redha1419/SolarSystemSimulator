package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;
import planets.Planet;
import renderEngine.DisplayManager;

public class Player extends Entity{
	
	private float counter = 0;
	
	public Player(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}
	public void move (Planet planet){
		super.increaseRotation(0, planet.getRotPerSec()*DisplayManager.getFrameTimeSeconds(), 0);
		//float IncerementDistance = (float)(planet.getSpeed()) * DisplayManager.getFrameTimeSeconds();
		Vector3f position  = super.getPosition();
		float dx = position.x;
		
		float distanceIncrement = 0.3f*DisplayManager.getFrameTimeSeconds();
			
		if(dx < -planet.getDistanceRatio() || dx > planet.getDistanceRatio()){
			counter ++;
		}
		
		if(planet.getDistance() != 0){
			if (counter%2 == 0){
				super.increasePosition(-distanceIncrement, 0, 0);
				float positionZ = (float) (Math.pow(planet.getDistanceRatio(),2) - (Math.pow((double)(position.x),2)));
				positionZ = (float) Math.sqrt(positionZ);
				Vector3f positionN  = new Vector3f(position.x,position.y,positionZ);
				if (dx >= 0 ){
					positionN.setZ(-positionZ);
					super.setPosition(positionN);
					}else if(dx <= 0){
						positionN.setZ(-positionZ);
						super.setPosition(positionN);
					}
			}
			else if(counter%2 != 0){
				super.increasePosition(distanceIncrement, 0, 0);
				float positionZ = (float) (Math.pow(planet.getDistanceRatio(),2) - (Math.pow((double)(position.x),2)));
				positionZ = (float) Math.sqrt(positionZ);
				//System.out.println(position.x);
				Vector3f positionN  = new Vector3f(position.x,position.y,positionZ);
				if (dx >= 0 ){
					positionN.setZ(positionZ);
					super.setPosition(positionN);
					}else if(dx <= 0){
						positionN.setZ(positionZ);
						super.setPosition(positionN);
					}	
			}
			
		}

	}
	public void checkInputs(){
			if (Keyboard.isKeyDown(Keyboard.KEY_W)){
				 this.increasePosition(0, 0, -0.09f);
		}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)){
				 this.increasePosition(0, 0, 0.09f);
		}
			if (Keyboard.isKeyDown(Keyboard.KEY_A)){
				 this.increasePosition(-0.09f, 0, 0);
		}
			if (Keyboard.isKeyDown(Keyboard.KEY_D)){
				 this.increasePosition(0.09f, 0, 0);
		}
	}
}

