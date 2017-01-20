package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;
public class Camera {

	private Vector3f position = new Vector3f(0,0,5);
	private float pitch = 0;
	private float yaw = 0;
	private float roll;
	
	
	public Camera(){
		}
	
	public void move(){
	
		calculatePitch();
		calculateYaw();
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)){
			position.z -=0.009f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)){
			position.z +=0.009f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)){
			position.x +=0.009f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)){
			position.x -=0.009f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)){
			position.y +=0.009f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Z)){
			position.y -=0.009f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_E)){
			position.set(0,0,1.5f);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_R)){
			roll -=0.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_T)){
			roll +=0.1f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_X)){
			position.z -= 0.5f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_C)){
			position.z += 0.5f;
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

	
	private void calculatePitch(){
		//if(Mouse.isButtonDown(0)){  //Mouse button 1 = right
			float pitchChange = Mouse.getDY() *0.1f;
			pitch -= pitchChange;
			if(pitch > 50){
				pitch = 50;
			}
			if (pitch < -50){
				pitch = -50;
			}
		//}
	}
	private void calculateYaw(){
	 //Mouse button 1 = right
			float yawChange = Mouse.getDX() *0.1f;
			yaw += yawChange;
			if(yaw > 80){
				yaw = 80;
			}
			if (yaw < -80){
				yaw = -80;
			}
		}
	}