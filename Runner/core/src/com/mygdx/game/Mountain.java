package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.mygdx.game.MyGdxGame.SCREEN_WIDTH;
import static com.mygdx.game.MyGdxGame.SPEED;

public class Mountain extends Actor {
    private Texture texture;

    public Mountain(Texture texture, float startX) {
        this.texture = texture;
        setX(startX);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        float newPositionX = getX() - SPEED;
        if(newPositionX <= - SCREEN_WIDTH){
            newPositionX = SCREEN_WIDTH;
        }
        setX(newPositionX);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY());
    }
}
