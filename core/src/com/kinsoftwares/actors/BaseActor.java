package com.kinsoftwares.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BaseActor extends Actor {
	private TextureRegion textureRegion;
	private Rectangle rectangle;
	
	public BaseActor() {
		super();
		
		textureRegion = new TextureRegion();
		rectangle = new Rectangle();
	}
	
	public void setTexture(Texture t) {
		textureRegion.setRegion(t);
		setSize(t.getWidth(), t.getHeight());
		rectangle.setSize(t.getWidth(), t.getHeight());
	}
	
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}
	
	public Rectangle getRectangle() {
		rectangle.setPosition(getX(), getY());
		return rectangle;
	}
	
	public boolean overlaps(BaseActor other) {
		return this.getRectangle().overlaps(other.getRectangle());
	}
	
	public void act(float dt) {
		super.act(dt);
	}
	
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		Color c = getColor();
		
		batch.setColor(c.r, c.g, c.b, c.a);
		
		if(isVisible()) {
			batch.draw(textureRegion, 
					getX(), getY(), 
					getOriginX(), getOriginY(), 
					getWidth(),	getHeight(), 
					getScaleX(), getScaleY(), 
					getRotation());
		}
	}
}
