package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Disposable;

public class CustomBar extends Actor implements Disposable{
      private Texture plat;
      private Texture bar1;
      private Texture bar2;
      
      public float blood;
      public float magic;
      private boolean reverse;
      private float px;
      private float py;
      private float maxBlood;
      private float maxMagic;
      public CustomBar(float x,float y,float blood,float magic,float maxBlood,float maxMagic,boolean reverse){
    	  plat=new Texture("Blood1.png");
    	  bar1=new Texture("bar1.png");
    	  bar2=new Texture("bar2.png");
    	  this.blood=blood;
    	  this.magic=magic;
    	  this.maxBlood=maxBlood;
    	  this.maxMagic=maxMagic;
    	  this.reverse=reverse;
    	  this.setPosition(x, y);
          px=1.6F;
          py=1.3F;
      }
	  @Override
      public void draw(Batch batch, float alpha) {
    	// TODO Auto-generated method stub
		  if(reverse)
    	batch.draw(plat,this.getX()+69, this.getY(),plat.getWidth()*px,plat.getHeight()*py,0,0,plat.getWidth(),plat.getHeight(),reverse,false);
		  else
			  batch.draw(plat,this.getX(), this.getY(),plat.getWidth()*px,plat.getHeight()*py);
    	if(!reverse){
    	batch.draw(bar1,this.getX()+9,this.getY()+142,330/maxBlood*blood*px,bar1.getHeight()*py);
    	batch.draw(bar2,this.getX()+9,this.getY()+95,240*magic/maxMagic*px,bar2.getHeight()*py);
    	}else{
    		batch.draw(bar1,this.getX()+688-330/maxBlood*blood*px,this.getY()+142,330/maxBlood*blood*px,bar1.getHeight()*py);
        	batch.draw(bar2,this.getX()+688-240*magic/maxMagic*px,this.getY()+95,240*magic/maxMagic*px,bar2.getHeight()*py);
    	}
    	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		plat.dispose();
		bar1.dispose();
		bar2.dispose();
	}
}
