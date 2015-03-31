package com.SavetheMechanic.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Gear  {
	Texture texture;
	Sprite sprite;
	Body body;
	
	public Gear(World world) {
		texture= new Texture("gear.png");
		sprite= new Sprite(texture);
//		sprite.setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
		sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2,Gdx.graphics.getHeight() / 2);
		
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
	}
	public void renderablesprites(Sprite sprite){
		sprite.rotate(-8);
	}
}


