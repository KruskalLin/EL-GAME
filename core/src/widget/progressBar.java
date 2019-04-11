package widget;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class progressBar extends Actor implements Disposable{
	 private Texture plat;
     private Texture bar1;
   
     public float blood;
     public float magic;
     private boolean reverse;
     private float px;
     private float py;
     private float maxBlood;
     public progressBar(float x,float y,float blood,float maxBlood){
   	  plat=new Texture("input2/options.png");
   	  bar1=new Texture("input2/grey.png");
   	  this.blood=blood;
   	  
   	  this.maxBlood=maxBlood;
   	  this.setPosition(x, y);
         px=2.65F;
         py=1.6F;
     }
	  @Override
     public void draw(Batch batch, float alpha) {
   	// TODO Auto-generated method stub
   	batch.draw(plat,this.getX()-205, this.getY()-200,plat.getWidth()*2,plat.getHeight()*py,0,0,plat.getWidth(),plat.getHeight(),reverse,false);
   	
   	batch.draw(bar1,this.getX()-140,this.getY()-155,330/maxBlood*blood*px,bar1.getHeight()*py);
   	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		plat.dispose();
		bar1.dispose();
		
	}

}
