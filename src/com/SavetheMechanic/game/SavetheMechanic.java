package com.SavetheMechanic.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SavetheMechanic extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	World world;
	Mechanic mechanic;
	Gear gear;
	
	@Override
	public void create () {
		world=new World(new Vector2(0, -98f),true);
		batch = new SpriteBatch();
		img = new Texture("City.png");
		mechanic=new Mechanic(world);
		gear=new Gear(world);
}

	@Override
	public void render () {
		
	world.step(Gdx.graphics.getDeltaTime(), 6, 2);
	
	Gdx.gl.glClearColor(1, 1, 1, 0);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	gear.sprite.setPosition(gear.body.getPosition().x, gear.body.getPosition().y);
	batch.begin();
	batch.draw(img,0,0);
	mechanic.sprite.draw(batch);
	gear.sprite.draw(batch);
	gear.renderablesprites(gear.sprite);
//	if(gear.sprite.getY()<0){
//		gear.sprite.draw(batch);
		//gear.sprite.setPosition(Gdx.graphics.getWidth() / 2 - gear.sprite.getWidth() / 2,Gdx.graphics.getHeight() / 2);
//	}
//	batch.draw(gear.sprite,gear.sprite.getX(),gear.sprite.getY());
	batch.end();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
		batch.dispose();
		img.dispose();
	}

}
