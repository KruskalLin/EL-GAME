package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Disposable;

public class Horizon  extends Actor implements Disposable{
	 private TextureRegion vani4;
	    public Animation van4;
	    public TextureAtlas ta4;
	    private int row;
	    private boolean can=false;
	    private float stateTime=0;
	    private MoveByAction mba;
	    private ScaleByAction sba;
	    private RunnableAction ra;
	    private DelayAction da;
	    private ParallelAction pa;
	    private SequenceAction sa;
	    public float life=10.0F;
	    public Horizon(int row){
	    	this.row=row;
	    	this.setPosition(-20,row*100+15);
	    }
	     public void move(float delay){
	    	 mba=Actions.moveBy(580,0,0.5F);
	    	 ta4=new TextureAtlas("Horizon.pack");
	    	 van4=new Animation(0.15F,ta4.getRegions(),PlayMode.NORMAL); 
	    	 da=Actions.delay(delay);
	    	 ra=Actions.run(new Runnable(){
           
				@Override
				public void run() {
					// TODO Auto-generated method stub
				    	can=true;
				}
	    		 
	    	 });
	    	 pa=Actions.parallel(mba, ra);
	    	 sa=Actions.sequence(da, pa);
	    	 this.addAction(sa);
	     }
	    
	    
	    @Override
	    public void draw(Batch batch, float parentAlpha) {
	    	stateTime+=Gdx.graphics.getDeltaTime();
	    	
	    	if(can){
	    		if(life>-5){
	    		life-=Gdx.graphics.getDeltaTime();
	    		}
	    		vani4=(TextureRegion) van4.getKeyFrame(stateTime);
         if(vani4!=null){
         	this.setSize(vani4.getRegionWidth(), vani4.getRegionHeight());
	        batch.draw(
	                vani4, 
	                getX(), getY(), 
	                getOriginX(), getOriginY(), 
	                getWidth(), getHeight(), 
	                getScaleX(), getScaleY(),
	                getRotation()
	        );
	      }}
	    if(life<0||this.getX()>=580){
	    	this.setVisible(false);
	    }
	    	}
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			ta4.dispose();
		}

}
