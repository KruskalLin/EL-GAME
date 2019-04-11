package Hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.game.GameScreen;

import actor.BarGroup;
import stage.GameStage;

public class spider2 extends Hero {
	//spider2    血1200
    //力量  34
     //敏捷30
    //攻击 57
     //护甲  4
	public spider2(GameStage stage,boolean reverse){
	       super(stage,reverse);
	      money=100;
	      xp=300;
	      
	       maxBlood=1200;
	       maxMagic=0;
	       blood=1200;
	       magic=0;	       
	       force=34;
	       attack=57;
	       quick=30;
	       intelligence=9;
	       defence=(float)4;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(new Texture("smallArmy/zhizhu.png"));
		       else
		    	   image=new Image(new Texture("smallArmy/zhizhu.png"));
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
