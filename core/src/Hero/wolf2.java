package Hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.game.GameScreen;

import actor.BarGroup;
import stage.GameStage;

public class wolf2 extends Hero {
	//狼人2：   血： 700
   // 力量  20
    //敏捷  18
    //智力  10
    //攻击力  32 
    //护甲    1
	public wolf2(GameStage stage,boolean reverse){
	       super(stage,reverse);
          money=100;
          xp=1000;
	       maxBlood=700;
	       maxMagic=0;
	       blood=700;
	       magic=0;	       
	       force=20;
	       attack=32;
	       quick=18;
	       intelligence=10;
	       defence=(float)1;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(new Texture("smallArmy/langren.png"));
		       else
		    	   image=new Image(new Texture("smallArmy/langren.png"));
	       if(!reverse)
		       image.setPosition(120,300);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504-90+700,300);
	       image.setScale(0.7F);
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
