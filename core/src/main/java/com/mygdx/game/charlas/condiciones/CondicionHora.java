package com.mygdx.game.charlas.condiciones;

import com.mygdx.game.charlas.Condicion;
import com.mygdx.game.npc.Npc;
import com.mygdx.game.util.EstadoMundo;

public class CondicionHora implements Condicion {

    private int horaMin;
    private int horaMax;

    public CondicionHora(int horaMin, int horaMax) {
        this.horaMin = horaMin;
        this.horaMax = horaMax;
    }

    @Override
    public boolean seCumple(EstadoMundo mundo, Npc npc) {
        int horaActual = mundo.getHora();
        return horaActual >= horaMin && horaActual <= horaMax;
    }
}
