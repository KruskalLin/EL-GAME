package label;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Baoji extends MyLabel{
	private TextureAtlas ta;
     public Baoji(boolean reverse) {
		super(reverse);
		// TODO Auto-generated constructor stub
		ta=new  TextureAtlas("baoji/baoji.pack");
		ani=new Animation(0.1F,ta.getRegions());
		ani.setPlayMode(PlayMode.NORMAL);
		tr=new TextureRegion(new Texture("baoji.png")); 
		this.setSize(tr.getRegionWidth(), tr.getRegionHeight());
	}
     @Override
     public void draw(Batch batch, float alpha) {
     	// TODO Auto-generated method stub
    	 if(draw){
    		 stateTime+=Gdx.graphics.getDeltaTime();
    	 batch.draw(tr,getX(), getY(),this.getWidth(),this.getHeight());
         TextureRegion tra=(TextureRegion) ani.getKeyFrame(stateTime);
         if(reverse)
         batch.draw(tra,-100, 500,tra.getRegionWidth(),tra.getRegionHeight());
   	     else
   		 batch.draw(tra,80, 500,tra.getRegionWidth(),tra.getRegionHeight());
          }
    	 }
}
