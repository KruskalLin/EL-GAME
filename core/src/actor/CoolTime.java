package actor;                  
                 
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
                            
public class CoolTime extends Actor implements Disposable{
    private Texture black;
    private int round=0;
    private int maxRound;
    public CoolTime(int maxRound){
    	black=new Texture("black.png");
    	this.maxRound=maxRound;
    }
    public void update(int round){
           this.round=round;
    }
    @Override
    public void draw(Batch batch, float alpha) {
  	// TODO Auto-generated method stub
	  batch.draw(black,this.getX(),this.getY(),black.getWidth(),black.getHeight()/maxRound*round);
    }
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		black.dispose();
	}
                    
}          