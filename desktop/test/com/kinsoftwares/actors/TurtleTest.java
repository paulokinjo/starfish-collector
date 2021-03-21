package com.kinsoftwares.actors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.kinsoftwares.fixtures.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class TurtleTest {

	private Turtle turtle;
	private Input input;
	
	@Before
	public void setup() {
		turtle = Mockito.spy(new Turtle());
		input = mock(Input.class);
	}
	
	@Test
	public void act_whenLeftKeyPressed_shouldMoveToTheLeftDirection() {
		when(input.isKeyPressed(Keys.LEFT)).thenReturn(true);
		Gdx.input = input;
		
		turtle.act(1);
		
		verify(turtle).moveBy(-1, 0);
	}
}
