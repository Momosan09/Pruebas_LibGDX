package com.mygdx.game.npc;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.charlas.DialogoManager;
import com.mygdx.game.enumeradores.EstadosJugador;
import com.mygdx.game.eventos.Listeners;
import com.mygdx.game.jugador.Jugador;
import com.mygdx.game.util.EstadoMundo;
import com.mygdx.game.util.MundoConfig;
import com.mygdx.game.util.Render;

public class NpcManager {

	private EstadoMundo estadoM;
    private Npc npc1,npc2;
	private ArrayList<Npc> npcs;
	private DialogoManager dM;
	
	public NpcManager(EstadoMundo estadoM, DialogoManager dM) {
		this.estadoM = estadoM;
		this.dM = dM;
		
		npcs = new ArrayList<>();
		
		npc1 = new Npc(6,6,"npc.png",MundoConfig.bundle.get("dialogos.npc.npc1_todosLosDialogos"));
		npc2 = new Npc(6,0,"npc.png",MundoConfig.bundle.get("dialogos.npc.npc2_todosLosDialogos"));
		
		agregarNpc(npc1);
		agregarNpc(npc2);
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
	    	//Listeners.ejecutarInteraccion(masCercano);
	    	dM.iniciar(masCercano);
	        //masCercano.interactuar(jugador);
	        MundoConfig.locutor = masCercano;
	        MundoConfig.estadoJugador =EstadosJugador.DIALOGO;
	        MundoConfig.acutualizarCharla = true;
	        
	    }else {
	        MundoConfig.estadoJugador =EstadosJugador.JUGANDO;
	        MundoConfig.acutualizarCharla = false;
	        jugador.resetInteraccion();
	    }

	    //jugador.resetInteraccion();
	}
}
