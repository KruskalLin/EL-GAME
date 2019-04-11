package widget;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Disposable;

import stage.GameStage;
import stage.MyStage;
import stage.mapStage;

public class LevelUp extends Group implements Disposable{
	private Texture plat;
	public mapStage stage;
	float stateTime=0;
	public LevelUp(int x,int y,mapStage myStage){
		 this.stage=myStage;
		 this.setPosition(x, y);
		 plat=new Texture("input2/level.png");
	}
	
	 public void draw(Batch batch, float alpha) {
		    stateTime+=Gdx.graphics.getDeltaTime();
		    if(stateTime<=2){
		    	System.out.println(stateTime);
		   	batch.draw(plat,this.getX()-140,this.getY()-155,plat.getWidth()*(float)1.5,plat.getHeight()*(float)1.5);
		    super.draw(batch, 1);
		    }else{
			
		    	this.setVisible(false);
		    }
	}
	@Override
	public void dispose() {
		plat.dispose();
	}

}
