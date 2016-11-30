package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{

	private MainGame game;
	private SpriteBatch batch;

	private Texture knightText;

	private Sprite knightSprite;

	private int knightX = 100, knightY = 100;

	public GameScreen (SpriteBatch batch, MainGame game){
		this.game = game;
		this.batch = batch;

	}

	@Override
	public void show() {
		knightText = new Texture ("knight.png");
		knightSprite = new Sprite (knightText);
	}

	@Override
	public void render(float delta) {
		batch.begin();
		Gdx.gl.glClearColor(.8f, .8f, .8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Keys.D)){
			knightX += 2;
		}
		if (Gdx.input.isKeyPressed(Keys.A)){
			knightX -= 2;
		}
		batch.draw(knightSprite, knightX, knightY, 32f, 64f);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
