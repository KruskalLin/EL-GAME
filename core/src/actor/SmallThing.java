package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SmallThing extends Actor{
     public TextureRegion tr;
     private Animation ani;
     private float stateTime=0;
     public boolean draw=false;
     public int a=1,b=1;
     public SmallThing(float x,float y,Animation ani){
    	 setPosition(x,y); 
    	 this.ani=ani;
     }
     @Override
     public void draw(Batch batch,float alpha){
    	 super.draw(batch, alpha);
    	 if(ani!=null&&draw){
    	 stateTime+=Gdx.graphics.getDeltaTime();
    	 tr=(TextureRegion) ani.getKeyFrame(stateTime);
    	 batch.draw(tr, getX(), getY(),  
                 tr.getRegionWidth() / 2,  
                 tr.getRegionHeight() / 2,  
                 tr.getRegionWidth(),  
                 tr.getRegionHeight(), getScaleX()*a, getScaleY()*b,  
                 getRotation()); 
     }
     }
     
     public void reset(){
    	   this.setVisible(false);
    	   draw=false;
    	   stateTime=0;
    	  
       }
	
	
	
	

}
