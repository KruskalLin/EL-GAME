package Hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.game.GameScreen;

import actor.BarGroup;
import stage.GameStage;

public class spider1 extends Hero {
	//spider1  血 500
    //力量   24
     //敏捷  20
    //攻击  38
      //护甲  1.3
	public spider1(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       money=80;
	       xp=160;
	       maxBlood=500;
	       maxMagic=0;
	       blood=500;
	       magic=0;	       
	       force=24;
	       attack=38;
	       quick=20;
	       intelligence=7;
	       defence=(float)1.3;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(new Texture("BladeMaster/Hero1.png"));
		       else
		    	   image=new Image(new Texture("BladeMaster/Hero1Re.png"));
		       if(!reverse)
		       image.setPosition(120,200);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504,200);		       
		       if(!reverse)
			       image=new Image(GameScreen.assetManager2.get(("BladeMaster/hero1.png"),Texture.class));
			       else
			    	 image=new Image(GameScreen.assetManager2.get(("BladeMaster/hero1Re.png"),Texture.class));
			       if(!reverse)
			       image.setPosition(120,200);
			       else
			       image.setPosition(2208-image.getWidth()-120-1504,200);		       
			          
		     
		       this.addActor(skillpanel);
		       this.addActor(image);
	           this.addActor(property);
	           this.addActor(tool);    
            this.addActor(bg);
        
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
