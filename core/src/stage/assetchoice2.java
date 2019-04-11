package stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.GameScreen;

import widget.progressBar;

public class assetchoice2 extends Stage{
	String before="input2/";
	String end1=".png";
	String end2=".jpg";
	progressBar bar;
	public boolean visible=false;
    
	GameScreen screen;
	SpriteBatch batch;
	public assetchoice2(GameScreen screen){
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
		GameScreen.assetManager.load("Skill1.png", Texture.class);
		GameScreen.assetManager.load("input2/timg.jpg", Texture.class);
		GameScreen.assetManager.load("textground.png", Texture.class);
	}
	 public void draw(){
		   super.draw();	   
		   if(GameScreen.assetManager.update()){		  
			   this.visible=false;
			   screen.initchoice2();
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
