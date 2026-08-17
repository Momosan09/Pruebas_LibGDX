package com.mygdx.game.charlas.consecuencias;

import com.mygdx.game.charlas.Consecuencia;
import com.mygdx.game.npc.Npc;
import com.mygdx.game.util.EstadoMundo;
import com.mygdx.game.util.MundoConfig;

public class ConsecuenciaIniciarCharla implements Consecuencia {

    private String idSiguienteCharla;

    public ConsecuenciaIniciarCharla(String id) {
        this.idSiguienteCharla = id;
    }

    @Override
    public void ejecutar(EstadoMundo mundo, Npc npc) {
        npc.setCharlaActual(idSiguienteCharla);
        MundoConfig.acutualizarCharla = true;
    }
}
