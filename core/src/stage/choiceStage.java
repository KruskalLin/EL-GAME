package stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

import widget.Victory;




public class choiceStage extends Stage {
     
	 GameScreen screen;
	 Image map1;
	 Image map2;
	 Image map3;
	 Image map4;
	 public boolean visible=false;
	 SpriteBatch batch;
	 public choiceStage(GameScreen screen,Viewport port){
		 super(port);
		 screen.choice.dispose();
		 screen.choice=null;
		 System.gc();
		 batch=new SpriteBatch();
		 this.screen=screen;
		 map1=new Image(GameScreen.assetManager.get(("input2/map4.jpg"),Texture.class));
		 map1.setPosition(300, 200);
		 map1.addListener(new ClickListener(){
				public void clicked(InputEvent event,float x,float y){
				    visible=false;
		            screen.my=new assetmy(screen);
		            screen.my.visible=true;          
				}
			 });
		 map2=new Image(GameScreen.assetManager.get(("input2/snowmap3.jpg"),Texture.class));
		 map2.setPosition(1100, 600);
		 map2.addListener(new ClickListener(){
				public void clicked(InputEvent event,float x,float y){
					visible=false;
		            screen.snow=new assetsnow(screen);
		            screen.snow.visible=true;
				}
			 });
		 map3=new Image(GameScreen.assetManager.get(("input2/sandmap3.jpg"),Texture.class));
		 map3.setPosition(300, 600);
		 map3.addListener(new ClickListener(){
				public void clicked(InputEvent event,float x,float y){
					visible=false;
					 screen.sand=new assetsand(screen);
			         screen.sand.visible=true;	
				}
			 });
		 map4=new Image(GameScreen.assetManager.get(("input2/finalmap3.jpg"),Texture.class));
		 map4.setPosition(1100, 200);
		 map4.addListener(new ClickListener(){
				public void clicked(InputEvent event,float x,float y){
					visible=false;
					screen.afinal=new assetfinal(screen);
			        screen.afinal.visible=true;	
				}
			 });
		 this.addActor(map1);
		 this.addActor(map2);
		 this.addActor(map3);
		 this.addActor(map4);  
	 }
}
