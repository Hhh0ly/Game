package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

	public static final int SPEED = 1;
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	private Stage stage;

	@Override
	public void create () {
		// Создаем объект сцены в которой будет храняться объекты актеров
		stage = new Stage();
		Texture mountainTexture = new Texture("mountains.png");
		Mountain mountain1 = new Mountain(mountainTexture, 0);
		stage.addActor(mountain1);
		Mountain mountain2 = new Mountain(mountainTexture, 1280);
		stage.addActor(mountain2);

		Texture landTexture1 = new Texture("land/landscape0.png");
		Texture landTexture2 = new Texture("land/landscape1.png");
		Texture stoneTexture = new Texture("land/landscape2.png");

		float offset = 256;
		for(int i = 0; i < 5; i++){
			float startX = offset * i;

			Texture texture;
			if(i % 2 == 0){
				texture = landTexture1;
			}else {
				texture = landTexture2;
			}
			UsualLand land = new UsualLand(texture, startX);
			stage.addActor(land);
		}
		UsualLand stoneLand = new UsualLand(stoneTexture, SCREEN_WIDTH);
		stage.addActor(stoneLand);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		// Метод act сцены вызывает метод act у всех актеров находящихся на сцене
		stage.act();
		// Метод draw сцены вызывает метод draw у всех актеров находящихся на сцене
		stage.draw();
	}
	
	@Override
	public void dispose () {

	}
}
