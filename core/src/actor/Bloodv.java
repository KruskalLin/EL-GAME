package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bloodv extends Actor{
     private TextureAtlas ta;
     public TextureRegion tr;
     private Animation ani;
     private float stateTime=0;
     public Bloodv(float x,float y){
    	 setPosition(x,y);
    	 ta=new TextureAtlas("bloodv.pack");
    	 ani=new Animation(0.1F,ta.getRegions());
    	 ani.setPlayMode(PlayMode.LOOP);
     }
     @Override
     public void draw(Batch batch,float alpha){
    	 super.draw(batch, alpha);
    	 stateTime+=Gdx.graphics.getDeltaTime();
    	 tr=(TextureRegion) ani.getKeyFrame(stateTime);
    	 batch.draw(tr, getX(), getY(),  
                 tr.getRegionWidth() / 2,  
                 tr.getRegionHeight() / 2,  
                 tr.getRegionWidth(),  
                 tr.getRegionHeight(), getScaleX()/2, getScaleY()/2,  
                 getRotation()); 
     }
}
