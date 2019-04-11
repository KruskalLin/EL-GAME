package stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.game.GameScreen;

import actor.BarGroup;
import widget.progressBar;
import widget.progressBar2;

public class assetmy extends Stage {
    public boolean visible;
    String before="input2/";
 	String end1=".png";
 	String end2=".jpg";
 	GameScreen screen;
 	SpriteBatch batch;
 	progressBar bar2;
 	Texture texture;
 	
 	public assetmy(GameScreen screen){
 		this.screen=screen;
 		texture=new Texture("input2/first.png");
 		
		batch=new SpriteBatch();
		bar2=new progressBar(400,400,0,500);
		if(screen.cstage!=null){
		screen.cstage.dispose();
		screen.cstage=null;
		System.gc();
		}
		if(screen.gs!=null){
			screen.gs.dispose();
			screen.gs=null;
			System.gc();
		}
		GameScreen.assetManager2.clear();
		GameScreen.assetManager.clear();
		GameScreen.assetManager.load(before+"firstnpc"+end1, Texture.class);
		GameScreen.assetManager.load(before+"ouwend"+end1, Texture.class);
		GameScreen.assetManager.load(before+"battle"+end1, Texture.class);
		GameScreen.assetManager.load(before+"dog"+end1, Texture.class);
		GameScreen.assetManager.load(before+"dogman3"+end1, Texture.class);
		GameScreen.assetManager.load(before+"emolieshou"+end1, Texture.class);
		GameScreen.assetManager.load(before+"fish"+end1, Texture.class);
		GameScreen.assetManager.load(before+"map"+end2, Texture.class);
		GameScreen.assetManager.load(before+"map2"+end2, Texture.class);
		GameScreen.assetManager.load(before+"map3"+end2, Texture.class);
		GameScreen.assetManager.load(before+"point"+end2, Texture.class);
		GameScreen.assetManager.load(before+"renwu"+end1, Texture.class);
		GameScreen.assetManager.load(before+"renwu2"+end1, Texture.class);
		GameScreen.assetManager.load(before+"rpg3"+end1, Texture.class);
		GameScreen.assetManager.load(before+"xianzhi"+end1, Texture.class);
		GameScreen.assetManager.load(before+"nvjisi"+end1, Texture.class);
		GameScreen.assetManager.load(before+"door"+end2, Texture.class);
		GameScreen.assetManager.load(before+"timg"+end2, Texture.class);
		GameScreen.assetManager.load(before+"tiao"+end1, Texture.class);
		GameScreen.assetManager.load(before+"renbutton1"+end1, Texture.class);
		GameScreen.assetManager.load(before+"renwubutton2"+end1, Texture.class);
		GameScreen.assetManager.load(before+"renwubutton3"+end1, Texture.class);
		GameScreen.assetManager.load(before+"baobutton1"+end1, Texture.class);
		GameScreen.assetManager.load(before+"baobutton2"+end1, Texture.class);
		GameScreen.assetManager.load(before+"zhuangshi"+end1, Texture.class);                                                      
 	}                                          
 	 public void draw(){                             
		   super.draw();	   
		   if(GameScreen.assetManager.update()){
			   this.visible=false;
			   
			   if(screen.stage==null)
			   screen.initmy();
			   else{
				   screen.stage.visible=true;
			   }
		   }else{                 
			 
			  bar2.blood=GameScreen.assetManager.getProgress()*500;
		   }            
		   System.out.println(Gdx.graphics.getWidth()+" "+Gdx.graphics.getHeight());
		   batch.begin();   
		   batch.draw(texture, 0, 0, texture.getWidth(),texture.getHeight());
		 
		   bar2.draw(batch, 1);
		   batch.end();
	   }
 	 public void dispose(){
     	super.dispose();
     	try{
     	texture.dispose();
     	bar2.dispose();
     	
     	}catch(NullPointerException e){
     		
     	}
     }
} 

