package com.kinsoftwares.actors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
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
	
	@Test
	public void act_whenRightKeyPressed_shouldMoveToTheRightDirection() {
		when(input.isKeyPressed(Keys.RIGHT)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);

		verify(turtle).moveBy(1, 0);
	}

	@Test
	public void act_whenRightAndLeftKeyPressed_shouldNotMove() {
		when(input.isKeyPressed(Keys.RIGHT)).thenReturn(true);
		when(input.isKeyPressed(Keys.LEFT)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);

		verify(turtle, never()).moveBy(1, 0);
		verify(turtle, never()).moveBy(-1, 0);
	}
	
	@Test
	public void act_whenUpKeyPressed_shouldMoveToTheUpDirection() {
		when(input.isKeyPressed(Keys.UP)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);

		verify(turtle).moveBy(0, 1);
	}
	
	@Test
	public void act_whenDownKeyPressed_shouldMoveToTheDownDirection() {
		when(input.isKeyPressed(Keys.DOWN)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);

		verify(turtle).moveBy(0, -1);
	}
	
	@Test
	public void act_whenUpAndDownKeyPressed_shouldNotMove() {
		when(input.isKeyPressed(Keys.UP)).thenReturn(true);
		when(input.isKeyPressed(Keys.DOWN)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);

		verify(turtle, never()).moveBy(0, 1);
		verify(turtle, never()).moveBy(0, -1);
	}
	
	@Test
	public void act_whenLeftAndUpKeyPressed_shouldMoveToUpperLeftCorner() {
		when(input.isKeyPressed(Keys.UP)).thenReturn(true);
		when(input.isKeyPressed(Keys.LEFT)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);
		
		verify(turtle).moveBy(0, 1);
		verify(turtle).moveBy(-1, 0);		
	}
	
	@Test
	public void act_whenRightAndUpKeyPressed_shouldMoveToUpperRightCorner() {
		when(input.isKeyPressed(Keys.UP)).thenReturn(true);
		when(input.isKeyPressed(Keys.RIGHT)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);
		
		verify(turtle).moveBy(0, 1);
		verify(turtle).moveBy(1, 0);
	}
	
	@Test
	public void act_whenRightAndDownKeyPressed_shouldMoveToLowerRightCorner() {
		when(input.isKeyPressed(Keys.RIGHT)).thenReturn(true);
		when(input.isKeyPressed(Keys.DOWN)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);
		
		verify(turtle).moveBy(1, 0);
		verify(turtle).moveBy(0, -1);
	}
	
	@Test
	public void act_whenLeftAndDownKeyPressed_shouldMoveToLowerLeftCorner() {
		when(input.isKeyPressed(Keys.LEFT)).thenReturn(true);
		when(input.isKeyPressed(Keys.DOWN)).thenReturn(true);
		Gdx.input = input;

		turtle.act(1);
		
		verify(turtle).moveBy(-1, 0);
		verify(turtle).moveBy(0, -1);
	}
}
