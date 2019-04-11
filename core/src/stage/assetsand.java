package stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.game.GameScreen;

import actor.BarGroup;
import widget.progressBar;

public class assetsand extends Stage {
	String before="input2/";
	String end1=".png";
	String end2=".jpg";
	progressBar bar;
	Texture texture;
	public boolean visible=false;

	GameScreen screen;
	SpriteBatch batch;
    public assetsand(GameScreen screen){
    	texture=new Texture("input2/second.png");
    	if(screen.stage!=null){
    	
    	screen.stage.dispose();
		screen.stage=null;
		System.gc();
    	}
		if(screen.gs!=null){
			screen.gs.dispose();
			screen.gs=null;
			System.gc();
		}
		this.screen=screen;
		batch=new SpriteBatch();
		bar=new progressBar(400,400,0,500);
		GameScreen.assetManager.clear();
		GameScreen.assetManager2.clear();
		GameScreen.assetManager.load(before+"timg"+end2, Texture.class);
		GameScreen.assetManager.load(before+"point"+end2, Texture.class);
		GameScreen.assetManager.load(before+"rpg3"+end1, Texture.class);
		GameScreen.assetManager.load(before+"jiansheng"+end1, Texture.class);
		GameScreen.assetManager.load(before+"nvhaiwu"+end1, Texture.class);	
		GameScreen.assetManager.load(before+"xiongmao"+end1, Texture.class);
		GameScreen.assetManager.load(before+"shengqishi"+end1, Texture.class);
		GameScreen.assetManager.load(before+"damofashi"+end1, Texture.class);
		GameScreen.assetManager.load(before+"dogman1"+end1, Texture.class);
		GameScreen.assetManager.load(before+"dogman2"+end1, Texture.class);
		GameScreen.assetManager.load(before+"wolf3"+end1, Texture.class);
		GameScreen.assetManager.load(before+"sandmap"+end2, Texture.class);
		GameScreen.assetManager.load(before+"sandmap2"+end2, Texture.class);
		GameScreen.assetManager.load(before+"door"+end2, Texture.class);
		GameScreen.assetManager.load(before+"battle"+end1, Texture.class);
    }
    public void draw(){
		   super.draw();	   
		   if(GameScreen.assetManager.update()){
			   this.visible=false;
			   System.out.println(screen==null);
			   System.out.println(screen.sandmap==null);
			   if(screen.sandmap==null)
			   screen.initsand();
			   else{
				   screen.sandmap.visible=true;
			   }
		   }else{
			   bar.blood=GameScreen.assetManager.getProgress()*500;
		   }
		   batch.begin();
		   batch.draw(texture, 0, 0, texture.getWidth()*(float)1.3,texture.getHeight()*(float)1.35);
		   bar.draw(batch, 1);
		   batch.end();
	   }
    public void dispose(){
    	super.dispose();
    	bar.dispose();
    	texture.dispose();
    }
}
