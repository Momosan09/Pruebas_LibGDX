package com.mygdx.game.jugador;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.Render;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Jugador {

	private Vector2 posicion;
	private Texture textura;
	private Sprite sprite;
	private int velocidad = 100;
	private float centroX;
	private float centroY;
	private int radioInteraccion = 2*64;
	private boolean quiereInteractuar = false;
	
	private Circle areaInteraccion;
	
	public Jugador(String ruta) {
		this.posicion = new Vector2(0,0);
		this.textura = new Texture(ruta);
		this.sprite = new Sprite(textura);
		sprite.setPosition(posicion.x, posicion.y);
		centroX = posicion.x+textura.getWidth()/2;
		centroY = posicion.y+textura.getHeight()/2;
		areaInteraccion = new Circle(posicion, radioInteraccion);
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
		areaInteraccion.setPosition(posicion.x+textura.getWidth()/2, posicion.y+textura.getHeight()/2);
		
	}
	
	public void draw(SpriteBatch batch) {
	    sprite.draw(batch);
	    dibujarAreaDeInteraccion();
	}
	
	private void dibujarAreaDeInteraccion() {
		Render.drawer.circle(areaInteraccion.x, areaInteraccion.y, areaInteraccion.radius);
		
	}
	
	public Circle getAreaInteraccion() {
	    return areaInteraccion;
	}

	public void solicitarInteraccion() {
	    quiereInteractuar = true;
	}

	public boolean quiereInteractuar() {
	    return quiereInteractuar;
	}

	public void resetInteraccion() {
	    quiereInteractuar = false;
	}



	
	
}
