package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;

public class GameScreen implements Screen{

	private MainGame game;
	private SpriteBatch batch;

	private Texture knightText;
	
	private Sprite knightSprite;

	private int knightX = 100, knightY = 100;
	
	private OrthographicCamera cam;
	
	private Sprite mapSprite;
	
	private TiledMap map;
	
	private TiledMapRenderer tmRender;

	public GameScreen (SpriteBatch batch, MainGame game){
		this.game = game;
		this.batch = batch;

	}

	@Override
	public void show() {
		
		map = new TmxMapLoader().load("map.tmx");
		tmRender = new OrthogonalTiledMapRenderer(map);
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		cam = new OrthographicCamera (30,30*(h/w));
		
		cam.position.set(600, 350, 0);
		
		cam.update();


		knightText = new Texture ("knight.png");
		knightSprite = new Sprite (knightText);
		knightSprite.setSize(32f, 48f);
		
		mapSprite = new Sprite (new Texture (Gdx.files.internal("world.png")));

		mapSprite.setPosition(0, 0);
		mapSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render(float delta) {
		batch.begin();
		Gdx.gl.glClearColor(.8f, .8f, .8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		tmRender.setView(cam);
		
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		
		if (Gdx.input.isKeyPressed(Keys.D)){
			//knightX += 2;
			cam.translate(1,0,0);
		}
		if (Gdx.input.isKeyPressed(Keys.A)){
			//knightX -= 2;
			cam.translate(-1,0,0);
		}
		if (Gdx.input.isKeyPressed(Keys.W)){
			//knightX += 2;
			cam.translate(0,1,0);
		}
		if (Gdx.input.isKeyPressed(Keys.S)){
			//knightX -= 2;
			cam.translate(0,-1,0);
		}
				
		float viewportWidth = cam.viewportWidth;
		float viewportHeight = cam.viewportHeight;
		
		//cam.position.x = MathUtils.clamp(cam.position.x, viewportWidth/2f, 50-viewportWidth /2f);
		//cam.position.y = MathUtils.clamp(cam.position.y, viewportHeight/2f, 25-viewportHeight /2f);
		
		//mapSprite.draw(batch);
		
		//tmRender.render();
		
		System.out.println("x: "+cam.position.x);
		System.out.println("y: "+cam.position.y);
		
		//batch.draw(knightSprite, cam.position.x, cam.position.y, 32f, 48f);
		knightSprite.setPosition(cam.position.x, cam.position.y);
		knightSprite.draw(batch);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		cam.viewportHeight = Gdx.graphics.getHeight() * height/width;
		cam.viewportWidth = Gdx.graphics.getWidth();
		cam.update();
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
