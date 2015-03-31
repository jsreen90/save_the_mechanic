package com.SavetheMechanic.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class Mechanic implements InputProcessor  {
	
	Texture texture;
	Sprite sprite;
	Body body;
	

	public Mechanic(World world) {
		texture= new Texture("mechanic.png");
		sprite= new Sprite(texture);
		sprite.setPosition(Gdx.graphics.getWidth()/2, 0);
		BodyDef bodydef=new BodyDef();
		bodydef.type=BodyType.DynamicBody;
		bodydef.position.set(sprite.getX(),sprite.getY());
		
		body=world.createBody(bodydef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);
		FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
		fixtureDef.restitution=0.5f;
		
		Gdx.input.setInputProcessor(this);
		
	}

	@Override
	public boolean keyDown(int keycode) {
		try {
			if(keycode==Keys.RIGHT){
				sprite.setFlip(true, false);
				sprite.setX(sprite.getX()+20f);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	try {
		if(keycode==Keys.LEFT){
			sprite.setFlip(false, false);
			sprite.setX(sprite.getX()-20f);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
