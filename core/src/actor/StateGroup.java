package actor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.Vector;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import Hero.Hero.State;
public class StateGroup extends Group{
	     private boolean reverse;
	     private static ArrayList<State> state;
	     private static ArrayList<CusButton> image;
	     private CusButton angry;
	     private CusButton burned;
	     private CusButton crazy;
	     private CusButton crit;
	     private CusButton curse;
	     private CusButton defence;
	     private CusButton dodge;
	     private CusButton frozen;
	     private CusButton dizzy;
	     private CusButton invisible;
	     private CusButton numb;
	     private CusButton poison;
	     private CusButton reflect;
	     private CusButton silent;
	     private CusButton suck;
	     public StateGroup(ArrayList<State> state,boolean reverse){
	    	 this.reverse=reverse;
	    	image=new ArrayList<CusButton>();
	    		   angry=new CusButton(17,884, new Texture("HeroState/Angry.png"), new Texture("HeroState/Angry.png"), new Texture("HeroState/Angry.png"),null,new Texture("textground.png"),"愤怒",reverse,0);
	    		   
	    		   burned=new CusButton(17,884, new Texture("HeroState/Burned.png"), new Texture("HeroState/Burned.png"), new Texture("HeroState/Burned.png"),null,new Texture("textground.png"),"烧伤",reverse,0);
	
	    		   crazy=new CusButton(17,884, new Texture("HeroState/Crazy.png"), new Texture("HeroState/Crazy.png"), new Texture("HeroState/Crazy.png"),null,new Texture("textground.png"),"狂",reverse,0);
	               
	    		   crit=new CusButton(17,884, new Texture("HeroState/Crit.png"), new Texture("HeroState/Crit.png"), new Texture("HeroState/Crit.png"),null,new Texture("textground.png"),"暴击",reverse,0);

	    		   curse=new CusButton(17,884, new Texture("HeroState/Curse.png"), new Texture("HeroState/Curse.png"), new Texture("HeroState/Curse.png"),null,new Texture("textground.png"),"诅咒",reverse,0);
	    	
	    		   defence=new CusButton(17,884, new Texture("HeroState/Defence.png"), new Texture("HeroState/Defence.png"), new Texture("HeroState/Defence.png"),null,new Texture("textground.png"),"无敌",reverse,0);
	    
	    		   dizzy=new CusButton(17,884, new Texture("HeroState/dizzy.png"), new Texture("HeroState/dizzy.png"), new Texture("HeroState/dizzy.png"),null,new Texture("textground.png"),"眩晕",reverse,0);
	  
	    		   dodge=new CusButton(17,884, new Texture("HeroState/Dodge.png"), new Texture("HeroState/Dodge.png"), new Texture("HeroState/Dodge.png"),null,new Texture("textground.png"),"闪避",reverse,0);
	    
	    		   frozen=new CusButton(17,884, new Texture("HeroState/Frozen.png"), new Texture("HeroState/Frozen.png"), new Texture("HeroState/Frozen.png"),null,new Texture("textground.png"),"冰冻",reverse,0);
	
	    		   invisible=new CusButton(17,884, new Texture("HeroState/Invisible.png"), new Texture("HeroState/Invisible.png"), new Texture("HeroState/Invisible.png"),null,new Texture("textground.png"),"haha",reverse,0);
	    		   numb=new CusButton(17,884, new Texture("HeroState/Numb.png"), new Texture("HeroState/Numb.png"), new Texture("HeroState/Numb.png"),null,new Texture("textground.png"),"haha",reverse,0);
	    
	    		   poison=new CusButton(17,884, new Texture("HeroState/Poison.png"), new Texture("HeroState/Poison.png"), new Texture("HeroState/Poison.png"),null,new Texture("textground.png"),"中毒",reverse,0);
	   
	    		   reflect=new CusButton(17,884, new Texture("HeroState/Reflect.png"), new Texture("HeroState/Reflect.png"), new Texture("HeroState/Reflect.png"),null,new Texture("textground.png"),"反射",reverse,0);
	    
	    		   silent=new CusButton(17,884, new Texture("HeroState/Silent.png"), new Texture("HeroState/Silent.png"), new Texture("HeroState/Silent.png"),null,new Texture("textground.png"),"沉默",reverse,0);
	    	
	    		   suck=new CusButton(17,884, new Texture("HeroState/Suck.png"), new Texture("HeroState/Suck.png"), new Texture("HeroState/Suck.png"),null,new Texture("textground.png"),"嗜血",reverse,0);}
	     
	     public void update(ArrayList statelist){
	    	 this.state=statelist;
	    	 this.clearChildren();
	    	 if(image!=null)
	    	 image.clear();
	         for(int i=0;i<state.size();i++){
	        	 image.add(getImage(state.get(i)));
	         }
	         for(int i=0;i<image.size();i++){
	        	 this.addActor(image.get(i));
	         }
	         for(int i=0;i<image.size();i++){
	        	 if(!reverse)
	        	 image.get(i).setPosition(200+60*i, 1000);
	        	 else
	        		 image.get(i).setPosition(450-120*i, 1000);
	         }
	     }
	    public CusButton getImage(State state){
	    	if(state==State.angry)
	        return angry;
	    	else if(state==State.burned)
	    		return burned;
	    	else if(state==State.crazy)
	    		return crazy;
	    	else if(state==State.crit)
	    		return crit;
	    	else if(state==State.curse)
	    		return curse;
	    	else if(state==State.defence)
	    		return defence;
	    	else if(state==State.dizzy)
	    		return dizzy;
	    	else if(state==State.dodge)
	    		return dodge;
	    	else if(state==State.frozen)
	    		return frozen;
	    	else if(state==State.invisible)
	    		return invisible;
	    	else if(state==State.numb)
	    		return numb;
	    	else if(state==State.poisoned)
	    		return poison;
	    	else if(state==State.reflect)
	    		return reflect;
	    	else if(state==State.silent)
	    		return silent;
	    	else if(state==State.suck)
	    		return suck;
	    	return null;
	    }
}
	     
