package label;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class yinshen  extends MyLabel{

	public yinshen(boolean reverse) {
		super(reverse);
		// TODO Auto-generated constructor stub
		tr=new TextureRegion(new Texture("POM/yinshen.png")); 
		this.setSize(tr.getRegionWidth(), tr.getRegionHeight());
	}
	@Override
    public void draw(Batch batch, float alpha) {
    	// TODO Auto-generated method stub
   	
   	 batch.draw(tr,this.getX(), this.getY(),this.getWidth(),this.getHeight());
    }
}