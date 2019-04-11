package Hero;

import java.util.Date;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game.GameScreen;

import actor.BarGroup;
import actor.CusButton;
import actor.FruitGroup;
import actor.SmallThing;
import label.Shanbi;
import stage.GameStage;
import label.*;
public class DemonHunter extends Hero {
	private TextureAtlas ta1;
	private TextureAtlas ta2;
	private TextureAtlas ta3;
	private Animation ani1;
	private float a,b;
	private Sound backlight;
	private Sound heal;
	private Sound shield;
    private Random ran;
    private Date date;
    
    private Image Skill4;
    private Shanbi shanbi;
    private SmallThing st;
    private SmallThing st1;
    private SmallThing st2;
    private Sound dodg;
    private Sound bolt;
    private Sound cast;
	//恶魔猎手：  
	//进入闪避状态2回合，6，60
	 //法力损毁（普通攻击消除魔力i*10，固有）//发生在造成伤害   
	//伤害屏障（减少伤害100，固有）  
	//法力虚空（伤害为目标所缺失的魔法值（即 最大魔法值-当前魔法值）*i，并有1回合眩晕，8，130） 
	//力量：20 + 1.2	攻击力：49
	//敏捷：22 + 2.8	初始血量：530  初始魔法：189
	//智力：15 + 1.8	护甲：2.1
    falixukong fa;
    shanshuo sh;
	public DemonHunter(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       money=300;
	       xp=400;
	       Skill4=new Image(GameScreen.assetManager2.get(("Demonhunter/demonhunter.png"),Texture.class));
	       date=new Date();
	       ran=new Random(date.getTime());
	       if(!reverse)
		       Skill4.setPosition(-1000, 200);
	         else
	        	 Skill4.setPosition(700+4008, 200);
	       Skill4.setScale(2.0F);
	       Yes1= GameScreen.assetManager2.get(("DemonHunter/DemonHunterMorphedYes1.wav"),Sound.class);
	       Yes2= GameScreen.assetManager2.get(("DemonHunter/DemonHunterMorphedYes2.wav"),Sound.class);
	       Yes3= GameScreen.assetManager2.get(("DemonHunter/DemonHunterMorphedYes3.wav"),Sound.class);
	       Yes4= GameScreen.assetManager2.get(("DemonHunter/DemonHunterMorphedYes4.wav"),Sound.class);
	       attack1= GameScreen.assetManager2.get(("DemonHunter/DemonHunterMorphedYesAttack2.wav"),Sound.class);
	       attack2= GameScreen.assetManager2.get(("DemonHunter/DemonHunterMorphedYesAttack3.wav"),Sound.class);
	       attack3= GameScreen.assetManager2.get(("DemonHunter/DemonHunterMorphedYesAttack4.wav"),Sound.class);
	       ta1=GameScreen.assetManager2.get(("DemonHunter/at.pack"),TextureAtlas.class);
	       ta2=GameScreen.assetManager2.get(("DemonHunter/vain.pack"),TextureAtlas.class);
	       ta3=GameScreen.assetManager2.get(("DemonHunter/dodge.pack"),TextureAtlas.class);
	       war=GameScreen.assetManager2.get(("DemonHunter/DemonHunterMorphedWarcry1.wav"),Sound.class);
	       dodg=GameScreen.assetManager2.get(("DemonHunter/BlinkArrival1.wav"),Sound.class);
	       bolt=GameScreen.assetManager2.get(("DemonHunter/HolyBolt.wav"),Sound.class);
	       cast=GameScreen.assetManager2.get(("DemonHunter/SorceressCastAttack1.wav"),Sound.class);
	       Animation ani=new Animation(0.05F,ta2.getRegions(),PlayMode.NORMAL);
	      
	       Animation ani2=new Animation(0.05F,ta3.getRegions(),PlayMode.NORMAL);
	   	   Animation ani3=new Animation(0.1F,ta1.getRegions(),PlayMode.NORMAL);
	   	   if(!reverse)
	       st=new SmallThing(1500,300,ani);
	       else 
	    	   st=new SmallThing(-1400,300,ani);
	   	   
	   	  if(reverse)
		       st2=new SmallThing(1000,300,ani3);
		       else 
		    	   st2=new SmallThing(-1200,300,ani3);
	       if(!reverse)
		       st1=new SmallThing(100,300,ani2);
		       else 
		    	   st1=new SmallThing(0,300,ani2);
	       st.a*=2;
	       st.b*=2;
	       st1.a*=3;
	       st1.b*=3;
	       st2.a*=2;
	       st2.b*=2;
	       fa=new falixukong(reverse);
	       sh=new shanshuo(reverse);
	       
	       
	       
	       
	       
	       cooltime1=6;
	       cooltime2=0;
	       cooltime3=0;
	       cooltime4=8;
	       continue1=0;
	       continue2=0;
	       continue3=0;
	       continue4=0;
	       abilityk1=2;
	       abilityk2=5;
	       abilityk3=7;
	       abilityk4=2;
	       maxBlood=1060;
	       maxMagic=189;
	       blood=1060;
	       magic=189;
	       force=27;
	       attack=49;
	       quick=29;
	       intelligence=14;
	       defence=(float)2.1;
	       dforce=(float)1.2;
	       dquick=(float)2.8;
	       dintellience=(float)1.8;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(GameScreen.assetManager2.get(("DemonHunter/emolieshou.png"),Texture.class));
		       else
		    	   image=new Image(GameScreen.assetManager2.get(("DemonHunter/emolieshou_re.png"),Texture.class));
		       if(!reverse)
		       image.setPosition(120,300);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504-200,300);
		       image.setScale(2.0F);
		       if(!reverse){
			       button1=new CusButton(17,884,GameScreen.assetManager2.get(("DemonHunter/sysy_white.png"),
			    		   Texture.class),GameScreen.assetManager2.get(("DemonHunter/sysy.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/sysy.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/sysy_black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"闪避",reverse,6);
			       button2=new CusButton(17,793,GameScreen.assetManager2.get(("DemonHunter/flsh.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/flsh.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/flsh.png"),Texture.class),
			    		   null,
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"法力损毁",reverse,0);
			       button3=new CusButton(17,702,GameScreen.assetManager2.get(("DemonHunter/fshd.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/fshd.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/fshd.png"),Texture.class),
			    		   null,GameScreen.assetManager2.get(("textground.png"),Texture.class),"伤害屏障",reverse,0);
			       button4=new CusButton(17,612,GameScreen.assetManager2.get(("DemonHunter/16-white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/16.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/16.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DemonHunter/16-black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"法力虚空",reverse,8);
			       }else{
			    	   button1=new CusButton(644-17,884,GameScreen.assetManager2.get(("DemonHunter/sysy_white.png"),
				    		   Texture.class),GameScreen.assetManager2.get(("DemonHunter/sysy.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/sysy.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/sysy_black.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"闪避",reverse,6);
				       button2=new CusButton(644-17,793,GameScreen.assetManager2.get(("DemonHunter/flsh.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/flsh.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/flsh.png"),Texture.class),
				    		   null,
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"法力损毁",reverse,0);
				       button3=new CusButton(644-17,702,GameScreen.assetManager2.get(("DemonHunter/fshd.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/fshd.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/fshd.png"),Texture.class),
				    		   null,GameScreen.assetManager2.get(("textground.png"),Texture.class),"伤害屏障",reverse,0);
				       button4=new CusButton(644-17,612,GameScreen.assetManager2.get(("DemonHunter/16-white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/16.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/16.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DemonHunter/16-black.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"法力虚空",reverse,8);
			       }
		       
		       
		       button1.round=6;
		       button2.round=0;
		       button3.round=0;
		       button4.round=8;
		       
		       button1.b.addListener(new ClickListener(){
		    	   public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
		    		   if(!abcool1){ 
		    		   stage.fg.enter.play();
		    		   }
		    	   }
			    	  public void clicked(InputEvent e,float x,float y){	 
			    		  if(stage.fg.canClick){
			    			  if(magic>=60&&!abcool1){ 
				    			   button1.isClicked=true;
				    		
				    		  button4.isClicked=false;
				    	  }}
			    	  }
			      });
			      button2.b.addListener(new ClickListener(){
			    	  public void clicked(InputEvent e,float x,float y){
			    		  if(stage.fg.canClick){
			    			
				    		  button2.isClicked=true;
				    	
			    		  }
			    	  }
			      });
			      button3.b.addListener(new ClickListener(){
			    	  public void clicked(InputEvent e,float x,float y){
			    		  if(stage.fg.canClick)
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
			    			  if(magic>=130&&!abcool2){ 
				    			   button1.isClicked=false;
				    		       button4.isClicked=true;
				    	  }
			    	  }}
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
			      this.addActor(skillpanel);
				   this.addActor(image);
		           this.addActor(property);
		           this.addActor(tool);    
	            this.addActor(bg);
	            this.addActor(button1);
	            this.addActor(button2);
	            this.addActor(button3);
	            this.addActor(button4); 
	            this.addActor(hb);
	            this.addActor(light);
	           this.addActor(sg);
	           this.addActor(st);
	           this.addActor(st1);
	           this.addActor(st2);
	           this.addActor(fa);
	           this.addActor(sh);
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
	            this.addActor(blackground); this.addActor(Skill4);
}
	//进入闪避状态2回合，6，60
	public boolean ability1() {   
		button1.ct.update(cooltime1);
		   button1.cool();

		    
		    
		    
		if(this.magic>=60&&!abcool2){
			
			
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
			int c=ran.nextInt(3);
			if(c==0)
			attack1.play(1.0F);
			else if(c==1)
		    attack2.play(1.0F);
			else
			attack3.play(1.0F);
		
            
            DelayAction delay2=Actions.delay(1.0F);
            
            RunnableAction run2=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					st1.reset();
				}
            	
            });
		 
			
	    
	    	DelayAction delay1=Actions.delay(stage.fg.delay1);
        RunnableAction run1=Actions.run(new Runnable(){
            
			@Override
			public void run() {
				// TODO Auto-generated method stub
		        st1.draw=true;
                 dodg.play(1.0F);
			}
        	
        });
	  
			   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
			
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					magic-=80;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
					state.add(Hero.State.dodge);
					cdodge+=2;
				}
				 
			 });
			 this.addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		return false;
	}
	
	//法力损毁（普通攻击消除魔力i*10，固有）//发生在造成伤害  
	public boolean ability2() {

		boolean temp=stage.hero1t;
		   
        DelayAction delay2=Actions.delay(1.0F);
        
        RunnableAction run2=Actions.run(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				st2.reset();
			}
        	
        });
	 
		
    
    	DelayAction delay1=Actions.delay(stage.fg.delay1);
    RunnableAction run1=Actions.run(new Runnable(){
        
		@Override
		public void run() {
			// TODO Auto-generated method stub
	        st2.draw=true;
	        cast.play(1.0F);
		}
    	
    });
  
		   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
		 RunnableAction run = new RunnableAction();
		 DelayAction delay=Actions.delay(stage.fg.delay1);
		 SequenceAction sequenceAction=Actions.sequence(delay,run);
		 run.setRunnable(new Runnable(){
			@Override
			public void run() {
				if(temp){
				stage.hero2.magic-=10;
				stage.hero2.bg.cb.magic=stage.hero2.magic;                    
				stage.hero2.bg.mag.setText((int)stage.hero2.magic+"/"+(int)stage.hero2.maxMagic);
				}else{
					stage.hero1.magic-=10;
					stage.hero1.bg.cb.magic=stage.hero1.magic;                    
					stage.hero1.bg.mag.setText((int)stage.hero1.magic+"/"+(int)stage.hero1.maxMagic);
				}
			}	 
		 });
		this.addAction(sa1);
	     this.addAction(sequenceAction);
		return false;
	}
	//伤害屏障（减少伤害100，固有）  
	public boolean ability3() {
		stage.fg.hurt-=100;
		if(stage.fg.hurt<=0){
			stage.fg.hurt=0;
		}
		return false;
	}

	//法力虚空（伤害为目标所缺失的魔法值（即 最大魔法值-当前魔法值）*i，并有1回合眩晕，8，130） 
	public boolean ability4() {
		button4.ct.update(cooltime4);
	   button4.cool();	   
	  
		    a=0;
		    b=0;
		if(this.magic>=130&&!abcool4){
			fa.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
			fa.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
		fa.addAction(sa2);
			 if(stage.hero1t){
				 DelayAction delay5=Actions.delay(stage.fg.delay1);
			blackground.setVisible(true);  
			
			DelayAction da2=Actions.delay(0.8F);
			MoveByAction mba1=Actions.moveBy(1550, 0,0.2F,Interpolation.sineIn);
			MoveByAction mba2=Actions.moveBy(1550, 0,0.2F,Interpolation.sineIn);
			RunnableAction rab=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					war.play(1.0F);
				}
				
			});
			RunnableAction ra=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					blackground.setVisible(false);
					Skill4.setPosition(-1000, 350);
				}
				
			});
			SequenceAction sa=Actions.sequence(delay5,mba1,rab,da2, mba2,ra);
			Skill4.addAction(sa); 
				
			stage.fg.delay1+=2;
		 }
			  DelayAction delay2=Actions.delay(1.0F);
	            
	            RunnableAction run2=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						st.reset();
					}
	            	
	            });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
	        RunnableAction run1=Actions.run(new Runnable(){
	            
				@Override
				public void run() {
					// TODO Auto-generated method stub
			        st.draw=true;
                    bolt.play(1.0F);
				}
	        	
	        });
		  
				   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
				
			boolean temp=stage.hero1t;
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					if(temp){
						stage.hero2.blood-=(stage.hero2.maxMagic-stage.hero2.magic);
						stage.hero2.bg.cb.blood=stage.hero2.blood;                    
						stage.hero2.bg.blo.setText((int)stage.hero2.blood+"/"+(int)stage.hero2.maxBlood);
						stage.hero2.state.add(Hero.State.dizzy);
						stage.hero2.cdizzy+=1;
						}else{
							stage.hero1.blood-=(stage.hero1.maxMagic-stage.hero1.magic);
							stage.hero1.bg.cb.blood=stage.hero1.blood;                    
							stage.hero1.bg.blo.setText((int)stage.hero1.blood+"/"+(int)stage.hero1.maxBlood);
							stage.hero1.state.add(Hero.State.dizzy);
							stage.hero1.cdizzy+=1;
						}
					magic-=130;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
				}
				 
			 });
			 this.addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		return false;
	}
    //恶魔猎手

	@Override
	public boolean AI() {
		int k=ran.nextInt(2);
		if(k==0){
			if(!abcool1)
			if(ability1()){
				abcool1=true;
				return true;
			}
		}
		if(k==1){
			if(!abcool4)
			if(ability4()){
				abcool4=true;
				return true;
			}
		}
		return false;
	}
}
