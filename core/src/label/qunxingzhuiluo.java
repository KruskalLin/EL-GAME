package label;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class qunxingzhuiluo  extends MyLabel{

	public qunxingzhuiluo(boolean reverse) {
		super(reverse);
		// TODO Auto-generated constructor stub
		tr=new TextureRegion(new Texture("POM/qunxingzhuiluo.png")); 
		this.setSize(tr.getRegionWidth(), tr.getRegionHeight());
	}
	@Override
    public void draw(Batch batch, float alpha) {
    	// TODO Auto-generated method stub
   	
   	 batch.draw(tr,this.getX(), this.getY(),this.getWidth(),this.getHeight());
    }
}
