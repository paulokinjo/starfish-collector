package com.kinsoftwares.actos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kinsoftwares.actors.BaseActor;
import com.kinsoftwares.fixtures.GdxTestRunner;


@RunWith(GdxTestRunner.class)
public class BaseActorTest {
	
	private BaseActor actor;
	private Texture testTexture;
	
	@Before
	public void setup() {
		actor = new BaseActor();
		testTexture = new Texture(Gdx.files.internal("assets/turtle-1.png"));		
	}
	
	@Test
	public void actoBeta_whenConstructed_shouldInstantiateTextureRegion() {
		assertThat(actor.getTextureRegion()).isNotNull();
	}
	
	@Test
	public void actoBeta_whenConstructed_shouldInstantiateRectangle() {
		assertThat(actor.getRectangle()).isNotNull();
	}
	
	@Test
	public void setTexture_whenValidTexture_shouldSetTextureRegionHeight() {	
		actor.setTexture(testTexture);
		assertThat(actor.getTextureRegion().getRegionHeight()).isEqualTo(testTexture.getHeight());		
	}
	
	@Test
	public void setTexture_whenValidTexture_shouldSetTextureRegionWidth() {
		actor.setTexture(testTexture);
		assertThat(actor.getTextureRegion().getRegionWidth()).isEqualTo(testTexture.getWidth());
	}
	
	@Test
	public void setTexture_whenValidTexture_shouldSetActorsHeight() {
		actor.setTexture(testTexture);
		assertThat(actor.getHeight()).isEqualTo(testTexture.getHeight());
	}
	
	@Test
	public void setTexture_whenValidTexture_shouldSetActorsWidth() {
		actor.setTexture(testTexture);
		assertThat(actor.getWidth()).isEqualTo(testTexture.getWidth());
	}
	
	@Test
	public void setTexture_whenValidTexture_shouldSetRectangleHeight() {
		actor.setTexture(testTexture);
		assertThat(actor.getRectangle().height).isEqualTo(testTexture.getHeight());
	}
	
	@Test
	public void setTexture_whenValidTexture_shouldSetRectangleWidth() {
		actor.setTexture(testTexture);
		assertThat(actor.getRectangle().width).isEqualTo(testTexture.getWidth());
	}
	
	@Test
	public void getRectangle_whenPropelySetup_shouldHaveConfiguredPositions() {
		actor.setPosition(10.0f, 10.0f);		
		
		Vector2 rectPos = actor.getRectangle().getPosition(new Vector2(actor.getX(), actor.getY()));
		
		assertThat(rectPos).isEqualTo(new Vector2(actor.getX(), actor.getY()));
	}
	
	@Test
	public void overlaps_whenRectanglesOveralps_returnsTrue() {		
		BaseActor otherActor = new BaseActor();
		otherActor.setTexture(testTexture);
		otherActor.setPosition(100, 100);
		
		actor.setTexture(testTexture);
		actor.setPosition(100, 100);
		
		boolean overlaps = actor.overlaps(otherActor);
		
		assertThat(overlaps).isTrue();
	}
	
	@Test
	public void overlaps_whenRectanglesDoNotOveralps_returnsFalse() {
		BaseActor otherActor = new BaseActor();
		otherActor.setPosition(-100, -100);
		
		actor.setPosition(100, 100);
		
		boolean overlaps = actor.overlaps(otherActor);
		
		assertThat(overlaps).isFalse();
	}
	
	@Test
	public void draw_shouldUseGetColorToApplyTintColorEffect() {
		BaseActor spy =  Mockito.spy(new BaseActor());	
		SpriteBatch batch =  mock(SpriteBatch.class);
		
		Mockito.doNothing().when((Actor)spy).draw(null, 0f);
		
		spy.draw(batch, 0f);
		
		verify(spy).getColor();
	}
	
	@Test
	public void draw_shouldApplyColorRGBA() {
		BaseActor spy =  Mockito.spy(new BaseActor());	
		SpriteBatch batch =  mock(SpriteBatch.class);
		
		Mockito.doNothing().when((Actor)spy).draw(null, 0f);
		
		spy.draw(batch, 0f);
				
		verify(batch).setColor(spy.getColor().r, spy.getColor().g, spy.getColor().b, spy.getColor().a);
	}
	
	@Test
	public void draw_shouldNotDrawWhenInvisible() {
		BaseActor spy =  Mockito.spy(new BaseActor());	
		SpriteBatch batch =  mock(SpriteBatch.class);
		
		Mockito.doNothing().when((Actor)spy).draw(null, 0f);
	
		spy.setVisible(false);
		spy.draw(batch, 0f);			
				
		verify(batch, never()).draw(
				spy.getTextureRegion(), 
				spy.getX(), spy.getY(), 
				spy.getOriginX(), spy.getOriginY(), 
				spy.getWidth(), spy.getHeight(), 
				spy.getScaleX(), spy.getScaleY(), 
				spy.getRotation());
	}
	
	@Test
	public void draw_shouldDrawWhenVisible() {
		BaseActor spy =  Mockito.spy(new BaseActor());	
		SpriteBatch batch =  mock(SpriteBatch.class);
		
		Mockito.doNothing().when((Actor)spy).draw(null, 0f);
		
		spy.draw(batch, 0f);
		
		spy.setVisible(true);
				
		verify(batch).draw(
				spy.getTextureRegion(), 
				spy.getX(), spy.getY(), 
				spy.getOriginX(), spy.getOriginY(), 
				spy.getWidth(), spy.getHeight(), 
				spy.getScaleX(), spy.getScaleY(), 
				spy.getRotation());
	}
}
