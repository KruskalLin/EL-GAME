package Hero;

import java.util.Date;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game.GameScreen;

import actor.BarGroup;
import actor.Bloodplus;
import actor.CusButton;
import actor.SmallThing;
import stage.GameStage;
 import label.*;
public class Paladin extends Hero {
	//圣骑士：洗礼（恢复120*i，5，80） 
	 //圣洁（消除对方所有增益状态,6-i，40）  
	 //辉耀光环（每回合消耗对方当前i*1/40血量,固有） 
	 //神圣护甲（免疫所有攻击i回合,10，150） 
	//力量：20 + 2.7	攻击力：56                                                         
	//敏捷：15 + 1.8	初始血量：530   初始魔法：221                       
	//智力：17 + 1.8	护甲：4    
	 private Bloodplus bp;
	private TextureAtlas ta1;
	private TextureAtlas ta2;
	private TextureAtlas ta3;
	private TextureAtlas ta4;
	private Animation ani1;
	private float a,b;
	private Sound backlight;
	private Sound shield;
    private Random ran;
    private Date date;
    private Image Skill4;
    private Sound shie;
    private Sound remove;
    private Sound Heal;
    private SmallThing ring;
    private SmallThing skill4;
	private SmallThing removal;
	
	
	xili xi;
	shengjie sh;
	shenshenghujia hu;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Paladin(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       money=300;
	       xp=400;
	       xi=new xili(reverse);
	       hu=new shenshenghujia(reverse);
	       sh=new shengjie(reverse);
	       date=new Date();
	       ran=new Random(date.getTime());
	       bp=new Bloodplus(reverse);
	       Yes1= GameScreen.assetManager2.get(("Paladin/HeroPaladinYes1.wav"),Sound.class);
	       Yes2= GameScreen.assetManager2.get(("Paladin/HeroPaladinYes2.wav"),Sound.class);
	       Yes3= GameScreen.assetManager2.get(("Paladin/HeroPaladinYes3.wav"),Sound.class);
	       Yes4= GameScreen.assetManager2.get(("Paladin/HeroPaladinYes4.wav"),Sound.class);
	       attack1= GameScreen.assetManager2.get(("Paladin/HeroPaladinYesAttack1.wav"),Sound.class);
	       attack2= GameScreen.assetManager2.get(("Paladin/HeroPaladinYesAttack2.wav"),Sound.class);
	       attack3= GameScreen.assetManager2.get(("Paladin/HeroPaladinYesAttack3.wav"),Sound.class);
	       ta1=GameScreen.assetManager2.get(("Paladin/ring.pack"),TextureAtlas.class);
	       ta2=GameScreen.assetManager2.get(("Paladin/holyshield.pack"),TextureAtlas.class);
	       ta3=GameScreen.assetManager2.get(("Paladin/skill2.pack"),TextureAtlas.class);
	       shie=GameScreen.assetManager2.get(("Paladin/ManaShieldCaster1.wav"),Sound.class);
	       remove=GameScreen.assetManager2.get(("Paladin/DispelMagicTarget.wav"),Sound.class);
	       Heal=GameScreen.assetManager2.get(("BladeMaster/Heal.wav"),Sound.class);

	       Animation ani=new Animation(0.05F,ta3.getRegions(),PlayMode.LOOP);
	       if(!reverse)
		       removal=new SmallThing(1450,300,ani);
		       else 
		     removal=new SmallThing(-1300,300,ani);
	       
	       Animation ani3=new Animation(0.05F,ta2.getRegions(),PlayMode.NORMAL);
	       if(!reverse)
		       skill4=new SmallThing(200,300,ani3);
		       else 
		     skill4=new SmallThing(0,300,ani3);
	       Animation ani2=new Animation(0.05F,ta1.getRegions(),PlayMode.LOOP);
	       if(!reverse)
		       ring=new SmallThing(400,300,ani2);
		       else 
		     ring=new SmallThing(200,300,ani2);
	       ring.draw=true;
	       ring.a*=2;
	       ring.b*=2;
	       
	       skill4.a*=2;
	       skill4.b*=2;
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       cooltime1=5;
	       cooltime2=6;
	       cooltime3=0;
	       cooltime4=10;
	       continue1=0;
	       continue2=0;
	       continue3=0;
	       continue4=0;
	       abilityk1=2;
	       abilityk2=2;
	       abilityk3=6;
	       abilityk4=2;
	       maxBlood=1060;
	       maxMagic=221;
	       blood=1060;
	       magic=221;	       
	       force=20;
	       attack=56;
	       quick=15;
	       intelligence=17;
	       defence=4;
	       dforce=(float)2.7;
	       dquick=(float)1.8;
	       dintellience=(float)1.8;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(GameScreen.assetManager2.get(("Paladin/shengqishi.png"),Texture.class));
		       else
		    	   image=new Image(GameScreen.assetManager2.get(("Paladin/shengqishi_re.png"),Texture.class));
		       if(!reverse)
		       image.setPosition(100,450);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504+20,450);		       
		       if(!reverse){
			       button1=new CusButton(17,884,GameScreen.assetManager2.get(("Paladin/xili_white.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/xili.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/xili.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/xili_black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"洗礼",reverse,5);
			       button2=new CusButton(17,793,GameScreen.assetManager2.get(("Paladin/jinghua_white.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/jinghua.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/jinghua.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/jinghua_black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"圣洁",reverse,6);
			       button3=new CusButton(17,702,GameScreen.assetManager2.get(("Paladin/HYJZ.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/HYJZ.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/HYJZ.png"),Texture.class),null,GameScreen.assetManager2.get(("textground.png"),Texture.class),"辉耀光环",reverse,0);
			       button4=new CusButton(17,612,GameScreen.assetManager2.get(("Paladin/hujia_white.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/hujia.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/hujia.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/hujia_black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"神圣护甲",reverse,10);
			       }else{
			    	   button1=new CusButton(644-17,884,GameScreen.assetManager2.get(("Paladin/xili_white.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/xili.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/xili.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/xili_black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"洗礼",reverse,5);
				       button2=new CusButton(644-17,793,GameScreen.assetManager2.get(("Paladin/jinghua_white.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/jinghua.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/jinghua.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/jinghua_black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"圣洁",reverse,6);
				       button3=new CusButton(644-17,702,GameScreen.assetManager2.get(("Paladin/HYJZ.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/HYJZ.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/HYJZ.png"),Texture.class),null,GameScreen.assetManager2.get(("textground.png"),Texture.class),"辉耀光环",reverse,0);
				       button4=new CusButton(644-17,612,GameScreen.assetManager2.get(("Paladin/hujia_white.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/hujia.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/hujia.png"),Texture.class),GameScreen.assetManager2.get(("Paladin/hujia_black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"神圣护甲",reverse,10);
				    
			       }
		       
		       
		       button1.round=5;
		       button2.round=6;
		       button3.round=0;
		       button4.round=10;
		       
		       
		       button1.b.addListener(new ClickListener(){
		    	   public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
		    		   if(!abcool1){ 
		    		   stage.fg.enter.play();
		    		   }
		    	   }
			    	  public void clicked(InputEvent e,float x,float y){	 
			    		  if(stage.fg.canClick){
			    			  if(magic>=60&&!abcool1){ 
			    				  button4.isClicked=false;
					    		  button1.isClicked=true;
					    		  button3.isClicked=false;
					    		  button2.isClicked=false;sphere=true;
				    		
				  		  
				    	  }
			    	  }}
			      });
			      button2.b.addListener(new ClickListener(){
			    	  public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
			    		   if(!abcool2){ 
			    		   stage.fg.enter.play();
			    		   }
			    	   }
			    	  public void clicked(InputEvent e,float x,float y){
			    		  if(stage.fg.canClick){
			    			  if(magic>=80&!abcool2){ 
				    			   button1.isClicked=false;
				    		  button2.isClicked=true;
				    		  button3.isClicked=false;
				    		  button4.isClicked=false; 
				    		
				   
				    	  }
			    	  }}
			      });
			      button3.b.addListener(new ClickListener(){
			    	
			    	  public void clicked(InputEvent e,float x,float y){
			    		 
				    		  button3.isClicked=true;
				    	
			    	  }
			      });
			      button4.b.addListener(new ClickListener(){
			    	  
			    	  public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
			    		   if(!abcool4){ 
			    		   stage.fg.enter.play();
			    		   }
			    	   }
			    	  public void clicked(InputEvent e,float x,float y){
			    		  if(stage.fg.canClick){
			    			  if(magic>=125&&!abcool4){  
			    		  button4.isClicked=true;
			    		  button1.isClicked=false;
			    		  button3.isClicked=false;
			    		  button2.isClicked=false;
			    		 
			    	  }}}
			      });
			      property.b.addListener(new ClickListener(){
			    	  public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
			    		   stage.fg.enter.play();
			    		   
			    	   }
			      });
			      tool.b.addListener(new ClickListener(){
			    	  public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
			    		   stage.fg.enter.play();
			    		   
			    	   }
			      });   
			      this.addActor(image);
					
			       this.addActor(skillpanel);
			   
		           this.addActor(property);
		           this.addActor(tool);    
	            this.addActor(bg);
	            this.addActor(button1);
	            this.addActor(button2);
	            this.addActor(button3);
	            this.addActor(button4); 
	            this.addActor(hb);
	            this.addActor(bp);
	            this.addActor(light);
	           this.addActor(sg);
	           this.addActor(removal);
	         this.addActor(skill4);
	         this.addActor(ring);
	   this.addActor(hu);this.addActor(sh);this.addActor(xi);
	            if(reverse){
	          	   light.setVisible(false);
	          	   skillpanel.setVisible(false);
	          	   button1.setVisible(false);
	          	   button2.setVisible(false);
	          	   button3.setVisible(false);
	          	   button4.setVisible(false);
	          	   property.setVisible(false);
	          	   tool.setVisible(false);
     }
}
	
	//圣骑士：洗礼（恢复120*i，5，80） 
	public boolean ability1() {
		button1.ct.update(cooltime1);
		   button1.cool();
	
		if(this.magic>=80&&!abcool1){
			xi.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
				xi.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
		xi.addAction(sa2);
			
					
	
			 RunnableAction run1 =Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					bp.reset();
				}
				 
			 });
			 DelayAction delay2=Actions.delay(0.5F);
			
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run,delay2,run1);
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					
					int c=ran.nextInt(3);
					if(c==0)
					attack1.play(1.0F);
					else if(c==1)
				    attack2.play(1.0F);
					else
					attack3.play(1.0F);
					magic-=80;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
					float temp=blood;
					blood+=120;
					if(blood>maxBlood)
						blood=maxBlood;
					temp=blood-temp;
					bg.cb.blood=blood;   
					bp.reveal(temp);
					Heal.play(1.0F);
					bg.blo.setText((int)blood+"/"+(int)maxBlood);
				}
				 
			 });
		     this.addAction(sequenceAction);
		     return true;
		}
		return false;
	}
	
	 //圣洁（消除对方所有增益状态,6-i，40）  
	@Override
	public boolean ability2() {
		button2.ct.update(cooltime2);
		   button2.cool();
	
		if(this.magic>=40&&!abcool2){
		sh.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
				sh.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
		sh.addAction(sa2);
			  DelayAction delay2=Actions.delay(1.0F);
	            
	            RunnableAction run4=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						removal.reset();
					}
	            	
	            });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
	        RunnableAction run1=Actions.run(new Runnable(){
	            
				@Override
				public void run() {
					// TODO Auto-generated method stub
			        removal.draw=true;
			        int c=ran.nextInt(3);
					if(c==0)
					attack1.play(1.0F);
					else if(c==1)
				    attack2.play(1.0F);
					else
					attack3.play(1.0F);
				}
	        	
	        });
		  
				   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run4);
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 boolean temp=stage.hero1t;
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					remove.play(1.0F);
					magic-=40;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
		            if(temp){
		            	if(stage.hero2.state.contains(Hero.State.angry)){
		            		stage.hero2.state.remove(Hero.State.angry);
		            		stage.hero2.cangry=0;
		            	}
		            	if(stage.hero2.state.contains(Hero.State.crit)){
		            		stage.hero2.state.remove(Hero.State.crit);
		            		stage.hero2.ccrit=0;
		            	}
		            	if(stage.hero2.state.contains(Hero.State.dodge)){
		            		stage.hero2.state.remove(Hero.State.dodge);
		            		stage.hero2.cdodge=0;
		            	}
		            	if(stage.hero2.state.contains(Hero.State.suck)){
		            		stage.hero2.state.remove(Hero.State.suck);
		            		stage.hero2.csuck=0;
		            	}
		            }else{
		            	if(stage.hero1.state.contains(Hero.State.angry)){
		            		stage.hero1.state.remove(Hero.State.angry);
		            		stage.hero1.cangry=0;
		            	}
		            	if(stage.hero1.state.contains(Hero.State.crit)){
		            		stage.hero1.state.remove(Hero.State.crit);
		            		stage.hero1.ccrit=0;
		            	}
		            	if(stage.hero1.state.contains(Hero.State.dodge)){
		            		stage.hero1.state.remove(Hero.State.dodge);
		            		stage.hero1.cdodge=0;
		            	}
		            	if(stage.hero1.state.contains(Hero.State.suck)){
		            		stage.hero1.state.remove(Hero.State.suck);
		            		stage.hero1.csuck=0;
		            	}
		            }
				}
			 });
			 this.addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		return false;
	}

	
	 //辉耀光环（每回合消耗对方当前i*1/40血量,固有） 
	@Override
	public boolean ability3() {
		 RunnableAction run = new RunnableAction();
		 DelayAction delay=Actions.delay(stage.fg.delay1);
		 SequenceAction sequenceAction=Actions.sequence(delay,run);
		 boolean temp=stage.hero1t;
		 run.setRunnable(new Runnable(){
			@Override
			public void run() {
				if(temp){
					stage.hero2.blood-=stage.hero2.maxBlood/20;
					stage.hero2.bg.cb.blood=stage.hero2.blood;
					stage.hero2.bg.blo.setText((int)stage.hero2.blood+"/"+(int)stage.hero2.maxBlood);
					}else{
						stage.hero1.blood-=stage.hero1.maxBlood/20;
						stage.hero1.bg.cb.blood=stage.hero1.blood;
						stage.hero1.bg.blo.setText((int)stage.hero1.blood+"/"+(int)stage.hero1.maxBlood);
					}			
			}
			
		 });
		 this.addAction(sequenceAction);
		 return false;

	}

	 //神圣护甲（免疫所有攻击i回合,10，150） 
	@Override
	public boolean ability4() {
		button4.ct.update(cooltime4);
		   button4.cool();
	
		if(this.magic>=150&&!abcool4){
		hu.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
				hu.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
		hu.addAction(sa2);
			DelayAction delay1=Actions.delay(stage.fg.delay1);
            RunnableAction run1=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					skill4.draw=true;
					shie.play(stage.volume);
					int c=ran.nextInt(3);
					if(c==0)
					attack1.play(1.0F);
					else if(c==1)
				    attack2.play(1.0F);
					else
					attack3.play(1.0F);
				}
            	
            });
            
            DelayAction delay2=Actions.delay(1.0F);
            
            RunnableAction run2=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					skill4.reset();
				}
            	
            });
		    SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
			
			
			
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					magic-=150;  
					bg.cb.magic=magic;                      
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
		            state.add(Hero.State.dodge);           
		            cdodge+=1;                 
				}                  
                            				 
			 });
			 this.addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		return false;
	}

	@Override
	public boolean AI() {
		int k=ran.nextInt(3);
		k=2;
		if(k==0){
			if(!abcool1)
		    if(ability1()){
		    	abcool1=true;
		    	return true;
		    }
		}
		if(k==1){
			if(!abcool2)
			if(ability2()){
				abcool2=true;
				return true;
			}
		}
		if(k==2){
			if(!abcool4)
			if(ability4()){
				abcool4=true;
				return true;
			}
		}
		
		return false;
	}
      //圣骑士
}
