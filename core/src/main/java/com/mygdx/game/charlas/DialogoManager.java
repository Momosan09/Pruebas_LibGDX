package com.mygdx.game.charlas;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.eventos.Listeners;
import com.mygdx.game.eventos.EventoSeleccionRespuesta;
import com.mygdx.game.hud.HUD;
import com.mygdx.game.npc.Npc;
import com.mygdx.game.util.EstadoMundo;

public class DialogoManager implements EventoSeleccionRespuesta{

    private Npc npcActual;
    private EstadoMundo mundo;
    private HUD hud;

    public DialogoManager(EstadoMundo mundo) {
        this.mundo = mundo;
    	hud = new HUD();
    	
    	Listeners.agregarListeners(this);
    }

    public void iniciar(Npc npc) {	
    	if(npc != null) {    		
        this.npcActual = npc;
        npc.iniciarCharla(mundo);
    	}
    }

    public void elegirRespuesta(int indice) {

        Charla charla = npcActual.getCharlaActual();

        if (charla == null) {
        	return;
        }else {
        	

        Respuesta respuesta = charla.respuestas().get(indice);

        System.out.println("las respuestas");
        respuesta.consecuencia().ejecutar(mundo, npcActual);
        }
    }
    
    public void dibujarHud() {
    	hud.dibujar();
    }
    
    public Stage getStage() {
    	return hud.getStage();
    }

	@Override
	public void respuestaSeleccionada(Respuesta respuesta) {
		respuesta.consecuencia().ejecutar(mundo, npcActual);
		
	}
}
