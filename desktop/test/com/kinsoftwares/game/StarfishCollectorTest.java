package com.kinsoftwares.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kinsoftwares.actors.BaseActor;
import com.kinsoftwares.fixtures.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class StarfishCollectorTest {
	private StarfishCollector starfishCollectorTest;
	private Stage stageMock;

	@Before
	public void setup() {
		starfishCollectorTest = Mockito.spy(new StarfishCollector());
		stageMock = mock(Stage.class);
	}

	@Test
	public void load_ShouldInstantiateMainStage() {
		starfishCollectorTest.load(stageMock);
		assertThat(starfishCollectorTest.getMainStage()).isNotNull();
	}

	@Test
	public void load_ShouldInstantiateOceanActor() {
		starfishCollectorTest.load(stageMock);
		assertThat(starfishCollectorTest.getOcean()).isNotNull();
	}

	@Test
	public void load_whenInstantiateOceanActor_SetTexture() {
		starfishCollectorTest.load(stageMock);
		Texture oceanTexture = new Texture("water.jpg");

		BaseActor ocean = starfishCollectorTest.getOcean();

		assertThat(ocean.getHeight()).isEqualTo(oceanTexture.getHeight());
		assertThat(ocean.getWidth()).isEqualTo(oceanTexture.getWidth());
	}

	@Test
	public void load_whenInstantiateOceanActor_AddItToMainStage() {
		starfishCollectorTest.load(stageMock);

		verify(stageMock).addActor(starfishCollectorTest.getOcean());

	}

	@Test
	public void load_ShouldInstantiateStarfishActor() {
		starfishCollectorTest.load(stageMock);
		assertThat(starfishCollectorTest.getStarfish()).isNotNull();
	}

	@Test
	public void load_whenInstantiateStarfishActor_SetTexture() {
		starfishCollectorTest.load(stageMock);
		Texture starfishTexture = new Texture("starfish.png");

		BaseActor starfish = starfishCollectorTest.getStarfish();

		assertThat(starfish.getHeight()).isEqualTo(starfishTexture.getHeight());
		assertThat(starfish.getWidth()).isEqualTo(starfishTexture.getWidth());
	}

	@Test
	public void load_whenIntantiateStarfishActor_SetPosition() {
		starfishCollectorTest.load(stageMock);

		BaseActor starfish = starfishCollectorTest.getStarfish();

		assertThat(starfish.getRectangle().getX()).isEqualTo(180);
		assertThat(starfish.getRectangle().getY()).isEqualTo(180);
	}

	@Test
	public void load_whenInstantiateStarfishActor_AddItToMainStage() {
		starfishCollectorTest.load(stageMock);

		verify(stageMock).addActor(starfishCollectorTest.getStarfish());

	}
}
