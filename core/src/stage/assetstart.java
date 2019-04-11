package stage;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.GameScreen;


import widget.progressBar;

public class assetstart extends Stage{
	String before="input1/";
	String end1=".png";
	String end2=".jpg";
	progressBar bar;
	public boolean visible=false;
	GameScreen screen;
	SpriteBatch batch;
	public assetstart(GameScreen screen){
		this.screen=screen;
		if(screen.gs!=null){
			screen.gs.dispose();
			GameScreen.assetManager2.clear();
			screen.gs=null;
			System.gc();
		}
		if(screen.stage!=null){
			screen.stage.dispose();
			GameScreen.assetManager2.clear();
			screen.stage=null;
			System.gc();
		}
		if(screen.sandmap!=null){
			screen.sandmap.dispose();
			GameScreen.assetManager2.clear();
			screen.sandmap=null;
			System.gc();
		}
		if(screen.snowmap!=null){
			screen.snowmap.dispose();
			GameScreen.assetManager2.clear();
			screen.snowmap=null;
			System.gc();
		}
		if(screen.finalmap!=null){
			screen.finalmap.dispose();
			GameScreen.assetManager2.clear();
			screen.finalmap=null;
			System.gc();
		}
		
		batch=new SpriteBatch();
		bar=new progressBar(400,400,0,500);
		GameScreen.assetManager.clear();
		GameScreen.assetManager2.clear();
		
		GameScreen.assetManager.load(before+"bei"+end2, Texture.class);
		GameScreen.assetManager.load(before+"button"+end1, Texture.class);
		GameScreen.assetManager.load(before+"button2"+end1, Texture.class);
		GameScreen.assetManager.load(before+"mymusic.ogg", Music.class);
		GameScreen.assetManager.load("sound2/"+"sound2.wav", Sound.class);
		GameScreen.assetManager.load(before+"fff1"+end1, Texture.class);
		GameScreen.assetManager.load(before+"fff2"+end1, Texture.class);
	}
	
	 public void draw(){
		   super.draw();	   
		   if(GameScreen.assetManager.update()){		  
			   this.visible=false;
			    screen.initstart();
		   }else{
			   bar.blood=GameScreen.assetManager.getProgress()*500;
		   }
		   batch.begin();
		   bar.draw(batch, 1);
		   batch.end();
	   }
	 public void dispose(){
	    	super.dispose();
	    	bar.dispose();
	    }
}
