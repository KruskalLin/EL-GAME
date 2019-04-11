package stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.GameScreen;

import widget.progressBar;

public class assetchoice extends Stage{
	String before="input2/";
	String end1=".png";
	String end2=".jpg";
	progressBar bar;
	public boolean visible=false;

	GameScreen screen;
	SpriteBatch batch;
	public assetchoice(GameScreen screen){
		this.screen=screen;
		if(screen.finalmap!=null){
			screen.finalmap.dispose();
			screen.finalmap=null;
			System.gc();
		}
		if(screen.stage!=null){
			screen.stage.dispose();
			screen.stage=null;
			System.gc();
		}
		if(screen.sandmap!=null){
			screen.sandmap.dispose();
			screen.sandmap=null;
			System.gc();
		}
		if(screen.snowmap!=null){
			screen.snowmap.dispose();
			screen.snowmap=null;
			System.gc();
		}
		batch=new SpriteBatch();
		bar=new progressBar(400,400,0,500);
		GameScreen.assetManager.clear();
		GameScreen.assetManager.load(before+"map4"+end2, Texture.class);
		GameScreen.assetManager.load(before+"sandmap3"+end2, Texture.class);
		GameScreen.assetManager.load(before+"snowmap3"+end2, Texture.class);
		GameScreen.assetManager.load(before+"finalmap3"+end2, Texture.class);
		GameScreen.assetManager.load(before+"renbutton1"+end1, Texture.class);
		GameScreen.assetManager.load(before+"renwubutton2"+end1, Texture.class);
		GameScreen.assetManager.load(before+"renwubutton3"+end1, Texture.class);
	}
	 public void draw(){
		   super.draw();	   
		   if(GameScreen.assetManager.update()){		  
			   this.visible=false;
			   screen.initchoice();
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
