package mapActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.game.GameScreen;

public abstract class enemy extends Actor implements Disposable{
	 String path="input2/";
	 String end=".png";
	 Animation<TextureRegion> walkAnimation1;
     Animation<TextureRegion> walkAnimation2;
     Animation<TextureRegion> walkAnimation3;
     Animation<TextureRegion> walkAnimation4;
     Animation<TextureRegion> walkAnimation;
     TextureRegion currentFrame;
     public boolean die=false;
     public static boolean tap;
     float stateTime=0;
     Texture walkSheetTexture;
     public enemy(){
    	 
     }
     
     public enemy(String name){
    	 walkSheetTexture =GameScreen.assetManager.get(path+name+end, Texture.class);
    	 int frameRows = 4;  
         int frameCols = 4;  
         int perCellWidth = walkSheetTexture.getWidth() / frameCols;    
         int perCellHeight = walkSheetTexture.getHeight() / frameRows;
         TextureRegion[][] cellRegions = TextureRegion.split(walkSheetTexture, perCellWidth, perCellHeight);
         walkAnimation1 = new Animation<TextureRegion>(0.08F, cellRegions[0]);
         walkAnimation2 = new Animation<TextureRegion>(0.08F, cellRegions[1]);
         walkAnimation3 = new Animation<TextureRegion>(0.08F, cellRegions[2]);
         walkAnimation4 = new Animation<TextureRegion>(0.08F, cellRegions[3]);
         walkAnimation1.setPlayMode(Animation.PlayMode.LOOP);
         walkAnimation2.setPlayMode(Animation.PlayMode.LOOP);
         walkAnimation3.setPlayMode(Animation.PlayMode.LOOP);
         walkAnimation4.setPlayMode(Animation.PlayMode.LOOP);
         walkAnimation= walkAnimation1;
         this.setSize((float)(perCellWidth*1.2),(float)(perCellHeight*1.2));
     }
    
     public void act(float delta) {
         super.act(delta);
     }
     
     public void drawv( SpriteBatch batch,float parentAlpha,Rectangle rec,double time,double distance){
    	 super.draw(batch, parentAlpha);
     	if(tap){
     	            stateTime+=Gdx.graphics.getDeltaTime();
     	            currentFrame = walkAnimation.getKeyFrame(stateTime);
     	            if(stateTime>=time){
     	        	stateTime=0;
     	        	if(walkAnimation.equals(walkAnimation1)){
     	        		walkAnimation=walkAnimation4;
     	        	}else{
     	        		walkAnimation=walkAnimation1;
     	        	}
     	        }else{
     	        	if(walkAnimation.equals(walkAnimation1)){
     	        		rec.y-=distance;
     	        	}else{
     	        		rec.y+=distance;
     	        	}
     	        }
     	}
       	        batch.draw(
                 currentFrame, 
                 rec.x ,rec.y ,
                 getOriginX(), getOriginY(), 
                 getWidth(), getHeight(), 
                 getScaleX(), getScaleY(),
                 getRotation());
     }
     public void drawh( SpriteBatch batch,float parentAlpha,Rectangle rec,double time,double distance){
    	 super.draw(batch, parentAlpha);
     	
     	if(tap){  
     	            stateTime+=Gdx.graphics.getDeltaTime();
     	            currentFrame = walkAnimation.getKeyFrame(stateTime);
     	            if(stateTime>=time){
     	        	stateTime=0;
     	        	if(walkAnimation.equals(walkAnimation3)){
     	        		walkAnimation=walkAnimation2;
     	        	}else{
     	        		walkAnimation=walkAnimation3;
     	        	}
     	         }else{
     	        	if(walkAnimation.equals(walkAnimation2)){
     	        		rec.x-=distance;
     	        	}else{
     	        		 rec.x+=distance;
     	        	}
     	         }
     	}
     	
       	        batch.draw(
                 currentFrame, 
                rec.x ,rec.y ,
                 getOriginX(), getOriginY(), 
                 getWidth(), getHeight(), 
                 getScaleX(), getScaleY(),
                 getRotation());
     

     }

     public void drawv( SpriteBatch batch,float parentAlpha,Rectangle rec){
    	 drawv(batch,parentAlpha,rec,1.6,1.5);
     }
     public void drawh( SpriteBatch batch,float parentAlpha,Rectangle rec){
    	 drawh(batch,parentAlpha,rec,1.6,1.5);
     }

}
