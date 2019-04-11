package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BloodGre extends Actor{
	 private TextureAtlas ta;
     public TextureRegion tr;
     private Animation ani;
     public float stateTime=0;
     public boolean draw=false;
     public BloodGre(){
    	 ta=new TextureAtlas("Heal.pack");
    	 ani=new Animation(0.05F,ta.getRegions());
    	 ani.setPlayMode(PlayMode.NORMAL);
     }
     @Override
     public void draw(Batch batch,float alpha){
    	 if(draw){
    	 stateTime+=Gdx.graphics.getDeltaTime();
    	 tr=(TextureRegion) ani.getKeyFrame(stateTime);
    	 batch.draw(tr, getX(), getY(),  
                 tr.getRegionWidth() / 2,  
                 tr.getRegionHeight() / 2,  
                 tr.getRegionWidth(),  
                 tr.getRegionHeight(), (float)(getScaleX()*1.5), (float)(getScaleY()*1.5),  
                 getRotation()); 
     }}
}
