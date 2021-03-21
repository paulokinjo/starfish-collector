package com.kinsoftwares.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Turtle extends BaseActor {
	private static final int MOVE_LEFT = -1;
	private static final int MOVE_UP = 1;
	private static final int MOVE_DOWN = -1;
	private static final int MOVE_RIGHT = 1;
	private static final int DO_NOT_MOVE = 0;
	
	public void act(float dt) {
		super.act(dt);

		boolean leftKey = Gdx.input.isKeyPressed(Keys.LEFT);
		boolean rightKey = Gdx.input.isKeyPressed(Keys.RIGHT);
		boolean upKey = Gdx.input.isKeyPressed(Keys.UP);
		boolean downKey = Gdx.input.isKeyPressed(Keys.DOWN);

		if ((leftKey && rightKey) || (upKey && downKey)) {
			return;
		}
		
		if (leftKey) {
			this.moveBy(MOVE_LEFT, DO_NOT_MOVE);
		} else if (rightKey) {
			this.moveBy(MOVE_RIGHT, DO_NOT_MOVE);
		}

		if (upKey) {
			this.moveBy(DO_NOT_MOVE, MOVE_UP);
		} else if (downKey) {
			this.moveBy(DO_NOT_MOVE, MOVE_DOWN);
		}
	}
}
