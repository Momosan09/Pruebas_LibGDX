package com.mygdx.game.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.charlas.Respuesta;
import com.mygdx.game.eventos.EventoSeleccionRespuesta;
import com.mygdx.game.eventos.Listeners;
import com.mygdx.game.util.HelpDebug;
import com.mygdx.game.util.MundoConfig;

public class HUD{

	
	private Stage stage = new Stage(new ScreenViewport());
	private Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
	private Label monologo;
	private List<String> respuestas;
	//Gdx.input.setInputProcessor(stage);

	public HUD() {
		
	Table table = new Table();
	table.setFillParent(true);

	Table table1 = new Table();

	table1.add().grow();

	table1.row();
	VerticalGroup verticalGroup = new VerticalGroup();

	monologo = new Label("El texto de la charla", skin);
	monologo.setColor(skin.getColor("black"));
	verticalGroup.addActor(monologo);

	respuestas = new List<>(skin);
	respuestas.setName("listaRespuestas");
	respuestas.setItems("respuesta1", "respuesta2", "respuesta3");
	verticalGroup.addActor(respuestas);
	table1.add(verticalGroup).pad(10.0f);
	table.add(table1).grow();
	stage.addActor(table);
	
	
	respuestas.addListener(new ChangeListener() {

	    @Override
	    public void changed(ChangeEvent event, Actor actor) {

	        int indice = respuestas.getSelectedIndex();

	        if (indice >= 0 &&
	            indice < MundoConfig.locutor.getCharlaActual().respuestas().size()) {

	            Respuesta r = MundoConfig.locutor
	                    .getCharlaActual()
	                    .respuestas()
	                    .get(indice);

	            Listeners.setRespuestaElegida(r);
	        }
	    }
	});
	}
	
	
	
	
	
	public void actualizarCharla() {
		if(MundoConfig.acutualizarCharla) {
			
		monologo.setText(MundoConfig.locutor.getCharlaActual().monologo());
		
		java.util.List<Respuesta> lista = MundoConfig.locutor.getCharlaActual().respuestas();

		if(!lista.isEmpty()) {
		    respuestas.setVisible(true);
		String[] items = new String[lista.size()];

		for (int i = 0; i < lista.size(); i++) {
		    items[i] = lista.get(i).texto();
		}

		respuestas.setItems(items);
		MundoConfig.acutualizarCharla = false;
	}else {
	    respuestas.setVisible(false);
	}
	}
		
	}
	
	public void dibujar() {
	    actualizarCharla();
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	}

	public Stage getStage() {
		return stage;
	}

}
