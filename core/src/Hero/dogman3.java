package Hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.game.GameScreen;

import actor.BarGroup;
import stage.GameStage;

public class dogman3 extends Hero {
	//dogman3  血800
    //力量： 28
    //敏捷:  18
    //智力 ： 9
   //攻击   39
     // 护甲 1.5
	public dogman3(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       money=90;
	       xp=600;
	       maxBlood=800;
	       maxMagic=0;
	       blood=800;
	       magic=0;	       
	       force=28;
	       attack=39;
	       quick=18;
	       intelligence=9;
	       defence=(float)1.5;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(new Texture("smallArmy/semimos.png"));
		       else
		    	   image=new Image(new Texture("smallArmy/semimos.png"));
	       if(!reverse)
		       image.setPosition(120,300);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504-90+200,200);
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
