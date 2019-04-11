package Hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.game.GameScreen;

import actor.BarGroup;
import stage.GameStage;

public class wolf3 extends Hero {
	//狼人3     血   800
    //力量28
    //敏捷  23
   //智力  17
   //攻击力45
    // 护甲 1.6

	public wolf3(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       money=70;
	       xp=140;
	       maxBlood=800;
	       maxMagic=0;
	       blood=800;
	       magic=0;	       
	       force=28;
	       attack=45;
	       quick=23;
	       intelligence=3;
	       defence=(float)1.6;
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
