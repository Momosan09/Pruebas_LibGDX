package com.mygdx.game.eventos;

import java.util.ArrayList;
import java.util.EventListener;
import com.mygdx.game.charlas.Respuesta;
import com.mygdx.game.npc.Npc;

public abstract class Listeners {

	private static ArrayList<EventListener> listeners = new ArrayList<>();
	
	
	public static void agregarListeners(EventListener e) {
		if(!listeners.contains(e)) {
			listeners.add(e);
		}
	}
	
	
	public static void ejecutarInteraccion(Npc npc) {
		for(int i = 0; i<listeners.size();i++) {
			if((listeners.get(i) instanceof EventoInteraccion)) {
				((EventoInteraccion) listeners.get(i)).interactuar(npc);;
			}
		}
	}
	
	public static void setRespuestaElegida(Respuesta r) {

	    for (EventListener listener : listeners) {
	        if (listener instanceof EventoSeleccionRespuesta) {
	            ((EventoSeleccionRespuesta) listener).respuestaSeleccionada(r);
	        }

	    }

	}
}
