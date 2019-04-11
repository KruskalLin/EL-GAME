package widget;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Disposable;
public class introduction extends Group implements Disposable{
	 private Texture plat;
	 public introduction(int x,int y){
		 plat=new Texture("input2/panel.png");
		 this.setPosition(x, y);
		 this.setSize(plat.getWidth(), plat.getHeight());
	 }
	 public void draw(Batch batch, float alpha) {
		
		   	batch.draw(plat,this.getX()-140,this.getY()-155,plat.getWidth()*(float)1.5,plat.getHeight()*(float)1.5);
		    super.draw(batch, 1);
		   	}
	@Override
	public void dispose() {
		plat.dispose();
		
	
	}
}
