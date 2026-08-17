package com.mygdx.game.jugador;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Jugador {

	private Vector2 posicion;
	private Texture textura;
	private Sprite sprite;
	private int velocidad = 100;
	
	public Jugador(String ruta) {
		this.posicion = new Vector2(0,0);
		this.textura = new Texture(ruta);
		this.sprite = new Sprite(textura);
		sprite.setPosition(posicion.x, posicion.y);
		
	}
	


	public void update() {
		float delta = Gdx.graphics.getDeltaTime();

	    if (Gdx.input.isKeyPressed(Input.Keys.W)) {
	        posicion.y += velocidad * delta;
	    }
	    if (Gdx.input.isKeyPressed(Input.Keys.S)) {
	        posicion.y -= velocidad * delta;
	    }
	    if (Gdx.input.isKeyPressed(Input.Keys.A)) {
	        posicion.x -= velocidad * delta;
	    }
	    if (Gdx.input.isKeyPressed(Input.Keys.D)) {
	        posicion.x += velocidad * delta;
	    }

	    sprite.setPosition(posicion.x, posicion.y);
	    
	}
	
	public void draw(SpriteBatch batch) {
	    sprite.draw(batch);
	    update();
	}
	
	protected void interactuar() {
		System.out.println("hola");
	}


	
	
}
