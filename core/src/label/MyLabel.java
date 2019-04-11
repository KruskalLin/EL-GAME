package label;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

public abstract class MyLabel extends Actor{
	  protected Texture label;
	  protected TextureRegion tr;
	  protected boolean reverse;
	  protected Animation ani;
	  protected float stateTime=0;
	  protected boolean draw=false;
      public MyLabel(boolean reverse){
    	  this.reverse=reverse;
    	  if(!reverse)
    	  setPosition(350, 800);
    	  else
    	  setPosition(175,800);
    	  this.setVisible(false);
    	    
      }
	 public void move(float delay){
		 
		 DelayAction delay1=Actions.delay(delay);
		
		 RunnableAction ra=Actions.run(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				draw=true;
				setVisible(true);
			}
			 
		 });
		 
    	 MoveByAction mba=Actions.moveBy(0, 100,0.5F,Interpolation.sineOut);
    	 ParallelAction pa=Actions.parallel(ra,mba);
    	 SequenceAction sa=Actions.sequence(delay1,pa);
    	 this.addAction(sa);
     }
     public void reset(){
    	 setVisible(false);
    	 draw=false;
    	 stateTime=0;
    	 if(!reverse)
       	  setPosition(350, 800);
       	  else
       	  setPosition(175,800);
     }
   
    	 
}
