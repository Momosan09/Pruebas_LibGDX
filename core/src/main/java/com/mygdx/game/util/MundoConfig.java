package com.mygdx.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.I18NBundle;
import com.mygdx.game.enumeradores.EstadosJugador;
import com.mygdx.game.npc.Npc;

public abstract class MundoConfig {

	public static Npc locutor = null;
	public static EstadosJugador estadoJugador = EstadosJugador.JUGANDO;
	
	public static I18NBundle bundle = I18NBundle.createBundle(Gdx.files.internal("locale/locale"));
	public static boolean acutualizarCharla = true;
}
