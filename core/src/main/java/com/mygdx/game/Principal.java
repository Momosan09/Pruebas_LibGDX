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
import com.mygdx.game.util.Render;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Principal extends Game {
    private SpriteBatch batch;
    private Texture image;
    
    private Jugador jugador;
    private EntradasJugador entradasJugador;

    @Override
    public void create() {

        batch = new SpriteBatch();
        Render.batch = batch;
        jugador = new Jugador("personaje.png");
        entradasJugador = new EntradasJugador(jugador);
        
    	Gdx.input.setInputProcessor(entradasJugador);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        Render.batch.begin();
        jugador.draw(Render.batch);
        Render.batch.end();
    }

    @Override
    public void dispose() {
    	Render.batch.dispose();
    }
}
