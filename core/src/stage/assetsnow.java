package stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.game.GameScreen;
                       
import actor.BarGroup;
import widget.progressBar;
import widget.progressBar2;
                      
public class assetsnow extends Stage{
	String before="input2/";
	String end1=".png";
	String end2=".jpg";
	progressBar bar;
	public Texture texture;
	public boolean visible=false;
    
	GameScreen screen;
	SpriteBatch batch;
    public assetsnow(GameScreen screen){
    	this.screen=screen;
    	texture=new Texture("input2/third.png");
    	if(screen.sandmap!=null){
    	screen.sandmap.dispose();
    	screen.sandmap=null;
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
		GameScreen.assetManager.load(before+"timg"+end2, Texture.class);
		GameScreen.assetManager.load(before+"rpg3"+end1, Texture.class);
		GameScreen.assetManager.load(before+"xianzhi"+end1, Texture.class);
		GameScreen.assetManager.load(before+"emolieshou"+end1, Texture.class);
		GameScreen.assetManager.load(before+"nvjisi"+end1, Texture.class);
		GameScreen.assetManager.load(before+"jiansheng"+end1, Texture.class);
		GameScreen.assetManager.load(before+"snowmap"+end2, Texture.class);
		GameScreen.assetManager.load(before+"snowmap2"+end2, Texture.class);
		GameScreen.assetManager.load(before+"shengqishi"+end1, Texture.class);
		GameScreen.assetManager.load(before+"renwu3"+end1, Texture.class);
		GameScreen.assetManager.load(before+"xiongmao"+end1, Texture.class);
		GameScreen.assetManager.load(before+"door"+end2, Texture.class);
		GameScreen.assetManager.load(before+"point"+end2, Texture.class);
		GameScreen.assetManager.load(before+"battle"+end1, Texture.class);
    }
    
    public void draw(){
		   super.draw();	   
		   if(GameScreen.assetManager.update()){
			   this.visible=false;
			   if(screen.snowmap==null)
			   screen.initsnow();
			   else{
				   screen.snowmap.visible=true;
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
