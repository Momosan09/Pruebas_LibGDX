package com.mygdx.game.charlas.condiciones;

import com.mygdx.game.charlas.Condicion;
import com.mygdx.game.npc.Npc;
import com.mygdx.game.util.EstadoMundo;

public class CondicionLluvia implements Condicion {

    private boolean debeEstarLloviendo;

    public CondicionLluvia(boolean debeEstarLloviendo) {
        this.debeEstarLloviendo = debeEstarLloviendo;
    }

    @Override
    public boolean seCumple(EstadoMundo mundo, Npc npc) {
       // System.out.println("\n\t\t\t=== DEBUG ===\n\tValor Esperado=" + debeEstarLloviendo+ " | Valor del mundo=" + mundo.isLloviendo());
        return mundo.isLloviendo() == debeEstarLloviendo;
    }

}
