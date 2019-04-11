package stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.game.GameScreen;

import actor.BarGroup;
import widget.progressBar;

public class assetfinal extends Stage {
	
	String before="input2/";
	String end1=".png";
	String end2=".jpg";
	progressBar bar;
	public boolean visible=false;
    public Texture texture;
	GameScreen screen;
	SpriteBatch batch;
	 public assetfinal(GameScreen screen){
		
		this.screen=screen;
		texture=new Texture("input2/forth.jpg");
		if(screen.snowmap!=null){
		screen.snowmap.dispose();
		screen.snowmap=null;
		System.gc();
		}
		if(screen.gs!=null){
			screen.gs.dispose();
			screen.gs=null;
			System.gc();
		}
		batch=new SpriteBatch();
		bar=new progressBar(400,400,0,500);
		GameScreen.assetManager.clear();
		GameScreen.assetManager2.clear();
		GameScreen.assetManager.clear();
		GameScreen.assetManager.load(before+"timg"+end2, Texture.class);
		GameScreen.assetManager.load(before+"semimos"+end1, Texture.class);
		GameScreen.assetManager.load(before+"finalmap"+end2, Texture.class);
		GameScreen.assetManager.load(before+"finalmap2"+end2, Texture.class);
		GameScreen.assetManager.load(before+"door"+end2, Texture.class);
		GameScreen.assetManager.load(before+"demo"+end1, Texture.class);
		GameScreen.assetManager.load(before+"spider"+end1, Texture.class);
		GameScreen.assetManager.load(before+"spider2"+end1, Texture.class);
		GameScreen.assetManager.load(before+"siqi"+end1, Texture.class);
		GameScreen.assetManager.load(before+"huoyan"+end1, Texture.class);
		GameScreen.assetManager.load(before+"kongju"+end1, Texture.class);
		GameScreen.assetManager.load(before+"rpg3"+end1, Texture.class);
		GameScreen.assetManager.load(before+"point"+end2, Texture.class);
		GameScreen.assetManager.load(before+"battle"+end1, Texture.class);
	}
	 public void draw(){
		   super.draw();	   
		   if(GameScreen.assetManager.update()){
			   this.visible=false;
			   if(screen.finalmap==null)
			   screen.initfinal();
			   else{
				   screen.finalmap.visible=true;
			   }
		   }else{
			   bar.blood=GameScreen.assetManager.getProgress()*500;
		   }
		   batch.begin();
		   batch.draw(texture, 0, 0, texture.getWidth(),texture.getHeight());
		   bar.draw(batch, 1);
		   batch.end();
	   } 
	
	 public void dispose(){
	    	super.dispose();
	    	bar.dispose();
	    	texture.dispose();
	    }
    
    
    
    
    
    
}
