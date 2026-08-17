package com.mygdx.game.npc;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.eventos.Listeners;
import com.mygdx.game.charlas.Charla;
import com.mygdx.game.charlas.DialogoLoader;
import com.mygdx.game.jugador.Jugador;
import com.mygdx.game.util.EstadoMundo;
import com.mygdx.game.util.HelpDebug;
import com.mygdx.game.util.Render;

public class Npc implements Interactuable{
	
	private Vector2 posicion;
	private Texture textura;
	private Sprite sprite;
	private int velocidad = 100;
	private float centroX;
	private float centroY;
	private String nombre; // compone el nombre con un valor variable solo para este ejemplo
	private int radioInteraccion = 2*64;
	
	private Circle areaInteraccion;
	
	private HashMap<String, Charla> charlas = new HashMap<>();
	private Charla charlaActual;
	
	public Npc(int posicionX, int posicionY, String ruta, String rutaCharlas) {
		this.posicion = new Vector2(posicionX*64,posicionY*64);
		this.textura = new Texture(ruta);
		this.sprite = new Sprite(textura);
		sprite.setPosition(posicion.x, posicion.y);
		nombre = "npc" + this.hashCode();
		areaInteraccion = new Circle(posicion, radioInteraccion);
		areaInteraccion.setPosition(posicion.x+textura.getWidth()/2, posicion.y+textura.getHeight()/2);
		cargarCharlas(rutaCharlas);
		
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
    public void interactuar(Npc npc) {
    	//System.out.println("iniciar charla");
       //iniciarCharla(estadoM);
    }

	public void agregarCharla(Charla charla) {
	    charlas.put(charla.id(), charla);
	}

	public void iniciarCharla(EstadoMundo mundo) {
	        if (charlaActual.puedeMostrarse(mundo, this)) {
	            mostrarCharla();
	            return;
	        
	    }

	    //System.out.println(HelpDebug.debub(getClass())+"No hay charla disponible.");
	}

	private void mostrarCharla() {
		
	    System.out.println(charlaActual.monologo());

	    int i = 1;
	    for (var respuesta : charlaActual.respuestas()) {
	        System.out.println(i + ": " + respuesta.texto());
	        i++;
	    }
	   // respuestaDeSalida(i);
	    
	}
	
	private void respuestaDeSalida(int i) {
		System.out.println(i+": Salir.");
		
	}

	public void setCharlaActual(String idSiguienteCharla) {

	    Charla siguiente = charlas.get(idSiguienteCharla);

	    if (siguiente != null) {
	        charlaActual = siguiente;
	        mostrarCharla();
	    }
	}
	
	public void cargarCharlas(String rutaJson) {

	    List<Charla> lista = DialogoLoader.cargar(rutaJson);

	    for (int i = 0; i<lista.size();i++) {
	        agregarCharla(lista.get(i));
	    }
	    
	    charlaActual = lista.get(0);
	    
	    //setCharlaActual(lista.get(0).id());
	}

	public Charla getCharlaActual() {
		return charlaActual;
	}

	public String getNombre() {
		return nombre;
	}
	
}
