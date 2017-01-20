package textures;

public class ModelTexture {
	
	private int textureID;
	
	private float shineDamper = 1;
	private float reflectivitiy = 0;
	
	
	private boolean hasTransperency = false;
	private boolean useFakeLighting = false;
	
	public ModelTexture(int id){
		this.textureID = id;
		
	}
	
	
	public boolean isUseFakeLighting() {
		return useFakeLighting;
	}


	public void setUseFakeLighting(boolean useFakeLighting) {
		this.useFakeLighting = useFakeLighting;
	}


	public boolean isHasTransperency() {
		return hasTransperency;
	}

	public void setHasTransperency(boolean hasTransperency) {
		this.hasTransperency = hasTransperency;
	}

	public int getID(){
		return this.textureID;
	}
	public float getShineDamper() {
		return shineDamper;
	}
	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}
	public float getReflectivitiy() {
		return reflectivitiy;
	}
	public void setReflectivitiy(float reflectivitiy) {
		this.reflectivitiy = reflectivitiy;
	}
	
}
