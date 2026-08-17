package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.jugador.EntradasJugador;
import com.mygdx.game.jugador.Jugador;
import com.mygdx.game.npc.Npc;
import com.mygdx.game.npc.NpcManager;
import com.mygdx.game.util.Render;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Principal extends Game {
    private SpriteBatch batch;
    private Texture image;
    
    private Jugador jugador;
    private EntradasJugador entradasJugador;
    
    private NpcManager npcManager;

    @Override
    public void create() {

        batch = new SpriteBatch();
        Render.batch = batch;
        Render.iniciarShapeDrawer();
        
        jugador = new Jugador("personaje.png");
        entradasJugador = new EntradasJugador(jugador); 

        npcManager = new NpcManager();

        
    	Gdx.input.setInputProcessor(entradasJugador);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // --- UPDATE ---
        jugador.update();
        npcManager.resolverInteracciones(jugador);

        // --- DRAW ---
        Render.batch.begin();
        npcManager.dibujarNpcs();
        jugador.draw(Render.batch);
        Render.batch.end();
    }


    @Override
    public void dispose() {
    	Render.batch.dispose();
    }
}
