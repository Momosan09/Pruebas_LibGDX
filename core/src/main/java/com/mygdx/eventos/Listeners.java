package com.mygdx.eventos;

import java.util.ArrayList;
import java.util.EventListener;

import com.mygdx.game.jugador.Jugador;

public abstract class Listeners {

	private static ArrayList<EventListener> listeners = new ArrayList();
	
	
	public static void agregarListeners(EventListener e) {
		if(!listeners.contains(e)) {
			listeners.add(e);
		}
	}
	
	
	public static void ejecutarInteraccion(Jugador jugador) {
		for(int i = 0; i<listeners.size();i++) {
			if((listeners.get(i) instanceof EventoInteraccion)) {
				((EventoInteraccion) listeners.get(i)).interactuar(jugador);;
			}
		}
	}
}
