package com.mygdx.game.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Render {

	public static SpriteBatch batch;
	public static ShapeDrawer drawer;
	
	public static void iniciarShapeDrawer() {	
		if(batch != null) {
			
	Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
	pixmap.setColor(Color.WHITE);
	pixmap.drawPixel(0, 0);
	Texture texture = new Texture(pixmap); //remember to dispose of later
	pixmap.dispose();
	TextureRegion region = new TextureRegion(texture, 0, 0, 1, 1);
	
	drawer = new ShapeDrawer(batch, region);
		}
	}
	
}
