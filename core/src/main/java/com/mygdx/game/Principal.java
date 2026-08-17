package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.charlas.DialogoManager;
import com.mygdx.game.enumeradores.EstadosJugador;
import com.mygdx.game.hud.HUD;
import com.mygdx.game.jugador.EntradasJugador;
import com.mygdx.game.jugador.Jugador;
import com.mygdx.game.npc.Npc;
import com.mygdx.game.npc.NpcManager;
import com.mygdx.game.util.EstadoMundo;
import com.mygdx.game.util.MundoConfig;
import com.mygdx.game.util.Render;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Principal extends Game {
    private SpriteBatch batch;
    private Texture image;
    
    private Jugador jugador;
    private EntradasJugador entradasJugador;
    
    private NpcManager npcManager;
    private DialogoManager dialogoManager;
    
    private EstadoMundo estadoM;
    


    @Override
    public void create() {
    	
    	estadoM = new EstadoMundo(); 
    	
    	estadoM.setLloviendo(false);
    	
    	dialogoManager = new DialogoManager(estadoM);
    	
        batch = new SpriteBatch();
        Render.batch = batch;
        Render.iniciarShapeDrawer();
        
        jugador = new Jugador("personaje.png");
        entradasJugador = new EntradasJugador(jugador); 

        npcManager = new NpcManager(estadoM, dialogoManager);

        
    	Gdx.input.setInputProcessor(entradasJugador);
    	

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // --- UPDATE ---
        jugador.update();
        npcManager.resolverInteracciones(jugador);
    	Gdx.input.setInputProcessor(entradasJugador);//TODO esto esta pesimo, pero es para el debug
    	

        // --- DRAW ---
        Render.batch.begin();
        npcManager.dibujarNpcs();
        jugador.draw(Render.batch);
        Render.batch.end();
        
        if(MundoConfig.estadoJugador == EstadosJugador.DIALOGO) {
        	Render.batch.begin();
        	Gdx.input.setInputProcessor(dialogoManager.getStage());//TODO esto esta pesimo, pero es para el debug x2
        	dialogoManager.dibujarHud();
        	Render.batch.end();
        }
    }


    @Override
    public void dispose() {
    	Render.batch.dispose();
    	
    }
}
