package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200;
		config.height = 768;
		config.title = "Dark Souls Ripoff";
		config.backgroundFPS = 120;
		config.foregroundFPS = 120;
		
		new LwjglApplication(new MainGame(), config);
	}
}
