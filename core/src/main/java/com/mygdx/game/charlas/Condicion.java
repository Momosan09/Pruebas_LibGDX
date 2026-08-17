package com.mygdx.game.charlas;

import com.mygdx.game.npc.Npc;
import com.mygdx.game.util.EstadoMundo;

public interface Condicion {
    boolean seCumple(EstadoMundo mundo, Npc npc);
}
