package com.kinsoftwares.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kinsoftwares.actors.BaseActor;
import com.kinsoftwares.actors.Turtle;

public class StarfishCollector extends ApplicationAdapter {
	private Turtle turtle;
	private BaseActor starfish;
	private BaseActor ocean;
	private BaseActor winMessage;

	private Stage mainStage;

	private boolean win;

	@Override
	public void create() {
		load(new Stage());
	}

	@Override
	public void render() {
		// check user input
        mainStage.act(1/60f);
        // check win condition: turtle must be overlapping starfish
        if (turtle.overlaps(starfish))
        {
            starfish.remove();
            winMessage.setVisible(true);
        }
        // clear screen
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // draw graphics
        mainStage.draw();
	}

	@Override
	public void dispose() {

	}

	public void update(float dt) {

	}

	public void initialize() {
		ocean = new BaseActor();
		ocean.setTexture(new Texture("water.jpg"));
		mainStage.addActor(ocean);
		
		starfish = new BaseActor();
		starfish.setTexture(new Texture("starfish.png"));
		starfish.setPosition(380, 380);
		mainStage.addActor(starfish);
		
		turtle = new Turtle();
		turtle.setTexture(new Texture("turtle-1.png"));
		turtle.setPosition(20, 20);
		mainStage.addActor(turtle);
		
		winMessage = new BaseActor();
		winMessage.setTexture(new Texture("you-win.png"));
		winMessage.setPosition(180, 180);
		winMessage.setVisible(false);
		mainStage.addActor(winMessage);

		win = false;
	}

	public void load(Stage mainStage) {
		this.mainStage = mainStage;
		initialize();
	}

	public Stage getMainStage() {
		return mainStage;
	}

	public BaseActor getOcean() {
		return ocean;
	}

	public BaseActor getStarfish() {
		return starfish;
	}
}
