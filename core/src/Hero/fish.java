package Hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import actor.BarGroup;
import stage.GameStage;

public class fish  extends Hero {
	//spider2    血1200
    //力量  34
     //敏捷30
    //攻击 57
     //护甲  4
	public fish(GameStage stage,boolean reverse){
	       super(stage,reverse);
	      money=50;
	      xp=100;
	       maxBlood=500;
	       maxMagic=0;
	       blood=500;
	       magic=0;	       
	       force=34;
	       attack=20;
	       quick=30;
	       intelligence=9;
	       defence=(float)0.4;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(new Texture("smallArmy/yuren.png"));
		       else
		    	   image=new Image(new Texture("smallArmy/yuren.png"));
	       
	       image.setSize(image.getWidth()*2, image.getHeight()*2);
	       if(!reverse)
		       image.setPosition(120,300);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504-90+200,300);
	       this.addActor(hb);
	         
           this.addActor(light);
          this.addActor(sg);
   this.addActor(bg);
   this.addActor(image);
        
}
	@Override
	public boolean ability1() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ability2() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ability3() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ability4() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AI() {
		// TODO Auto-generated method stub
		return false;
	}

}
