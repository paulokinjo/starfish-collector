package com.kinsoftwares.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.kinsoftwares.game.StarfishCollector;

public class DesktopLauncher {
	public static void main (String[] arg) {
		StarfishCollector starfishGame = new StarfishCollector();				
		LwjglApplication launcher = new LwjglApplication(starfishGame, "Starfish Collector", 800, 600);
	}
}
