package com.mygdx.game.eventos;

import java.util.EventListener;

import com.mygdx.game.jugador.Jugador;
import com.mygdx.game.npc.Npc;

public interface EventoInteraccion extends EventListener{
	void interactuar(Npc npc);
}
