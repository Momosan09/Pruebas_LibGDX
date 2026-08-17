package com.mygdx.game.npc;

import java.util.ArrayList;
import java.util.Iterator;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.eventos.Listeners;
import com.mygdx.game.jugador.Jugador;

import com.mygdx.game.util.Render;

public class NpcManager {

    private Npc npc1;
	private ArrayList<Npc> npcs;
	
	public NpcManager() {
		npcs = new ArrayList<>();
		
		npc1 = new Npc("npc.png");
		
		agregarNpc(npc1);
	}
	
	public void agregarNpc(Npc npc) {
		npcs.add(npc);
	}
	
	public void dibujarNpcs() {
		for (Npc npc : npcs) {
			npc.draw(Render.batch);
		}
	}
	


	public void resolverInteracciones(Jugador jugador) {

	    if (!jugador.quiereInteractuar()) return;

	    Npc masCercano = null;
	    float menorDistancia = Float.MAX_VALUE;

	    Circle areaJugador = jugador.getAreaInteraccion();

	    for (Npc npc : npcs) {

	        Circle areaNpc = npc.getAreaInteraccion();

	        if (areaNpc.overlaps(areaJugador)) {

	            float distancia = Vector2.dst(areaNpc.x, areaNpc.y,areaJugador.x, areaJugador.y);

	            if (distancia < menorDistancia) {
	                menorDistancia = distancia;
	                masCercano = npc;
	            }
	        }
	    }

	    if (masCercano != null) {
	    	Listeners.ejecutarInteraccion(jugador);
	        masCercano.interactuar(jugador);
	    }

	    jugador.resetInteraccion();
	}


	
}
