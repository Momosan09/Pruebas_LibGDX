package com.mygdx.game.charlas;

import com.mygdx.game.npc.Npc;
import com.mygdx.game.util.EstadoMundo;

public interface Consecuencia {
    void ejecutar(EstadoMundo mundo, Npc npc);
}
