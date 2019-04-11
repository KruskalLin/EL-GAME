package mapActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.game.GameScreen;

public class Player extends Actor implements Disposable{
	     public  float x;
		public  float y;
	     public Animation<TextureRegion> walkAnimation1;
	     public Animation<TextureRegion> walkAnimation2;
	     public Animation<TextureRegion> walkAnimation3;
	     public Animation<TextureRegion> walkAnimation4;
	      public TextureRegion currentFrame;
	       static float stateTime=0;
	   
	      private Texture walkSheetTexture;
	      public Player(){
	    	 walkSheetTexture = GameScreen.assetManager.get("input2/rpg3.png",Texture.class);
	    	 int frameRows = 4;  
	         int frameCols = 8;  
	         int perCellWidth = walkSheetTexture.getWidth() / frameCols;    
	         int perCellHeight = walkSheetTexture.getHeight() / frameRows;   
	         TextureRegion[][] cellRegions = TextureRegion.split(walkSheetTexture, perCellWidth, perCellHeight);
	         walkAnimation1 = new Animation<TextureRegion>(0.05F, cellRegions[0]);
	         walkAnimation2 = new Animation<TextureRegion>(0.05F, cellRegions[1]);
	         walkAnimation3 = new Animation<TextureRegion>(0.05F, cellRegions[2]);
	         walkAnimation4 = new Animation<TextureRegion>(0.05F, cellRegions[3]);
	         walkAnimation1.setPlayMode(Animation.PlayMode.LOOP);
	         walkAnimation2.setPlayMode(Animation.PlayMode.LOOP);
	         walkAnimation3.setPlayMode(Animation.PlayMode.LOOP);
	         walkAnimation4.setPlayMode(Animation.PlayMode.LOOP);
	         currentFrame = walkAnimation1.getKeyFrame(stateTime);
	         this.setSize(perCellWidth/6,perCellHeight/6);
	    }
	    public void act(float delta) {
	        super.act(delta);
	    }
	    public void draw( SpriteBatch batch,float parentAlpha) {
	    	      
	    	        super.draw(batch, parentAlpha);
	      	        batch.draw(
	                currentFrame, 
	                x,y, 
	                getOriginX(), getOriginY(), 
	                getWidth(), getHeight(), 
	                getScaleX(), getScaleY(),
	                getRotation());
	      
	    }
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			walkSheetTexture.dispose();
		}
	    
	   	   
	  
}
