package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Light extends Actor{
	private TextureAtlas ta;
	private Animation ani;
	private TextureRegion tr;
	private float stateTime=0;
	private boolean reverse;
	public Light(boolean reverse){
		this.reverse=reverse;
		if(!reverse){
			setPosition(600,950);
		}else{
			setPosition(27,950);
		}
		ta=new TextureAtlas("light.pack");
		ani=new Animation(0.2F,ta.getRegions());
		ani.setPlayMode(PlayMode.LOOP);
		
	}
	@Override
	public void draw(Batch batch,float alpha){
   	 stateTime+=Gdx.graphics.getDeltaTime();
   	 tr=(TextureRegion) ani.getKeyFrame(stateTime);
   	 batch.draw(tr, getX(), getY(),  
                tr.getRegionWidth() / 2,  
                tr.getRegionHeight() / 2,  
                tr.getRegionWidth(),  
                tr.getRegionHeight(), getScaleX(), getScaleY(),  
                getRotation()); 
    }
	
}



