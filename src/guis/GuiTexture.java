package guis;

import org.lwjgl.util.vector.Vector2f;

public class GuiTexture {
	
	private int texture;
	private Vector2f postition;
	private Vector2f scale;
	
	public GuiTexture(int texture, Vector2f postition, Vector2f scale) {
		super();
		this.texture = texture;
		this.postition = postition;
		this.scale = scale;
	}

	public int getTexture() {
		return texture;
	}

	public Vector2f getPostition() {
		return postition;
	}

	public Vector2f getScale() {
		return scale;
	}
	
}
