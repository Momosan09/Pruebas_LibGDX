package com.mygdx.eventos;

import java.util.EventListener;

import com.mygdx.game.jugador.Jugador;

public interface EventoInteraccion extends EventListener{
	void interactuar(Jugador jugador);
}
