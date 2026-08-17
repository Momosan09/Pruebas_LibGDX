package com.mygdx.game.eventos;

import java.util.EventListener;

import com.mygdx.game.charlas.Respuesta;

public interface EventoSeleccionRespuesta extends EventListener{
		void respuestaSeleccionada(Respuesta respuesta);
}
