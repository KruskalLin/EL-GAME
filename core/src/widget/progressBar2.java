package widget;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

import stage.mapStage;

public class progressBar2 extends Actor implements Disposable{
	 private Texture plat;
     private Texture bar1;
    private Texture bar2;
    private Texture bar3;
     public float blood;
     public float magic;
     public float xp;
     private boolean reverse;
     private float px;
     private float py;
     public float maxMagic;
     public float maxXp;
     public float maxBlood;
     public mapStage stage;
     public progressBar2(float x,float y,float blood,float maxBlood,float magic,float maxMagic,float xp,float maxXp,mapStage stage){
   	  plat=new Texture("input2/tiao.png");
   	  bar1=new Texture("input2/xie.png");
   	  bar2=new Texture("input2/blue.png");
   	  bar3=new Texture("input2/jingyan.png");
   	  this.stage=stage;
   	  this.blood=blood;
   	  this.magic=magic;
   	  this.maxMagic=maxMagic;
   	  this.xp=xp;
   	  this.maxXp=maxXp;
   	  System.out.println(magic);
   	  this.maxBlood=maxBlood;
   	  this.setPosition(x, y);
         px=1.65F;
         py=1.6F;
     }
	  @Override
     public void draw(Batch batch, float alpha) {
   	batch.draw(plat,this.getX()-175, this.getY()-320,plat.getWidth()/(float)1.3,plat.getHeight()/(float)1.3,0,0,plat.getWidth(),plat.getHeight(),reverse,false);
   	batch.draw(bar1,this.getX()-140,(this.getY()-95),330/maxBlood*blood*px/(float)1.3,bar1.getHeight()*py/(float)1.3);
   	batch.draw(bar2,this.getX()-140,this.getY()-127,330/maxMagic*magic*px/(float)1.3,bar1.getHeight()*py/(float)1.3);
   	batch.draw(bar3,this.getX()-140,this.getY()-160,330/maxXp*xp*px/(float)1.3,bar1.getHeight()*py/(float)1.3);
   	}
	  public void update(){
		  blood=stage.screen.blood;
		  magic=stage.screen.magic;
		  xp=stage.screen.XP;
		  maxBlood=stage.screen.maxBlood;
		  maxMagic=stage.screen.maxMgic;
		  maxXp=stage.screen.maxXP;  
	  }
	@Override
	public void dispose(){
		plat.dispose();
		bar1.dispose();
		bar2.dispose();
		bar3.dispose();
		
	}

}
