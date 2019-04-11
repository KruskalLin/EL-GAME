package Hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.game.GameScreen;

import actor.BarGroup;
import stage.GameStage;

public class semo extends Hero{
	//半兽人：    技能：愤怒，让自己处于愤怒状态5回合
   // 血：700            
  // 力量：  15 
   //敏捷：   6
   //智力：   3
   //攻击力： 30                
  //护甲：     0.9
	public semo(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       money=100;
	       xp=300;
	       maxBlood=700;
	       maxMagic=0;
	       blood=700;
	       magic=0;	       
	       force=15;
	       attack=30;
	       quick=6;
	       intelligence=3;
	       defence=(float)0.9;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(new Texture("smallArmy/semo.png"));
		       else
		    	   image=new Image(new Texture("smallArmy/semo.png"));
	       if(!reverse)
		       image.setPosition(120,300);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504-90+700,300);
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
