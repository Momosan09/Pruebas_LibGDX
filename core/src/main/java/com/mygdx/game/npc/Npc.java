package com.mygdx.game.npc;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.eventos.Listeners;
import com.mygdx.game.jugador.Jugador;
import com.mygdx.game.util.Render;

public class Npc implements Interactuable{
	
	private Vector2 posicion;
	private Texture textura;
	private Sprite sprite;
	private int velocidad = 100;
	private float centroX;
	private float centroY;
	
	private int radioInteraccion = 2*64;
	
	private Circle areaInteraccion;
	
	public Npc(String ruta) {
		this.posicion = new Vector2(6*64,6*64);
		this.textura = new Texture(ruta);
		this.sprite = new Sprite(textura);
		sprite.setPosition(posicion.x, posicion.y);
		
		areaInteraccion = new Circle(posicion, radioInteraccion);
		areaInteraccion.setPosition(posicion.x+textura.getWidth()/2, posicion.y+textura.getHeight()/2);
		
		Listeners.agregarListeners(this);
	}
	
	public void draw(SpriteBatch batch) {
	    sprite.draw(batch);
	    dibujarAreaDeInteraccion();
	}
	
	public void dibujarAreaDeInteraccion() {
		Render.drawer.circle(areaInteraccion.x, areaInteraccion.y, areaInteraccion.radius);
	}


    @Override
    public Circle getAreaInteraccion() {
        return areaInteraccion;
    }

    @Override
    public void interactuar(Jugador jugador) {
        System.out.println("El evento");
    }
	
}
