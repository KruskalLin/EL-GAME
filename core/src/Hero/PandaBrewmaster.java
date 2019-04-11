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
import actor.Bloodplus;
import actor.CusButton;
import actor.FruitGroup;
import actor.SmallThing;
import stage.GameStage;
import label.*;
public class PandaBrewmaster extends Hero {
	
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
	    private Sound firesound;
	    private Sound firsound;
	    private Sound Heal;
	    private SmallThing fire;
	    private SmallThing fir;
		private SmallThing skill;
		private leitingyiji lei;
		private mizui mizui;
		private penhuo penhuo;
	
	
	
	
	
	
	
	//熊猫酒仙： 雷霆一击（九宫格+i*50，冷却6,耗魔80）
	//喷火（烧灼对方总血量4%*i，持续3回合，冷却6，耗魔80） 
	//醉拳（暴击2倍，i*8%，固有）//伤害阶段  
	//迷醉（愤怒i*20%，所有非固有技能效果翻倍，12，200）
	//力量：23 + 2.9	攻击力：52 
	//敏捷：16 + 2.0	初始血量 587  初始魔法：182
	//智力：14 + 1.3	护甲：3.3
	public PandaBrewmaster(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       money=300;
	       xp=600;
	       Skill4=new Image( GameScreen.assetManager2.get(("Panda/skll4.png"),Texture.class));
	       pm1=new Pixmap(Gdx.files.internal("hand.png"));
	       pm2 = new Pixmap(Gdx.files.internal("sphere.png")); 
	       date=new Date();
	       lei=new leitingyiji(reverse);
	       mizui=new mizui(reverse);
	       penhuo=new penhuo(reverse);
	       ran=new Random(date.getTime());
	       if(!reverse)
		       Skill4.setPosition(-1200, 350);
	         else
	        	 Skill4.setPosition(700+4008, 350);
	       Yes1=  GameScreen.assetManager2.get(("Panda/PandarenBrewmasterStormWhat1.wav"),Sound.class);
	       Yes2=  GameScreen.assetManager2.get(("Panda/PandarenBrewmasterStormWhat1.wav"),Sound.class);
	       Yes3=  GameScreen.assetManager2.get(("Panda/PandarenBrewmasterStormYes1.wav"),Sound.class);
	       Yes4=  GameScreen.assetManager2.get(("Panda/PandarenBrewmasterStormYes1.wav"),Sound.class);
	       attack1=  GameScreen.assetManager2.get(("Panda/PandarenBrewmasterStormYesAttack1.wav"),Sound.class);
	       attack2=  GameScreen.assetManager2.get(("Panda/PandarenBrewmasterStormYesAttack1.wav"),Sound.class);
	       attack3=  GameScreen.assetManager2.get(("Panda/PandarenBrewmasterStormYesAttack1.wav"),Sound.class);
	       war=  GameScreen.assetManager2.get(("Panda/PandarenBrewmasterStormWarcry1.wav"),Sound.class);
	       firesound= GameScreen.assetManager2.get(("Panda/Incinerate1.wav"),Sound.class);
	   	   firsound= GameScreen.assetManager2.get(("Panda/FlameStrikeBirth1.wav"),Sound.class);
	   	
	       
	       
	       
	       ta1=GameScreen.assetManager2.get(("Panda/skill4.pack"),TextureAtlas.class);
	       ta2=GameScreen.assetManager2.get(("Panda/ji.pack"),TextureAtlas.class);
	        ta3=GameScreen.assetManager2.get(("Panda/skill1.pack"),TextureAtlas.class);
	       
	        
	        Animation ani=new Animation(0.08F,ta1.getRegions(),PlayMode.NORMAL);
		       if(!reverse)
		       skill=new SmallThing(200,400,ani);
		       else 
		    	   skill=new SmallThing(0,400,ani);
		       Animation ani2=new Animation(0.05F,ta3.getRegions(),PlayMode.NORMAL);
		   	   Animation ani3=new Animation(0.1F,ta3.getRegions(),PlayMode.NORMAL);
		   	  if(!reverse)
			       fir=new SmallThing(1400,300,ani3);
			       else 
			    	   fir=new SmallThing(-1600,300,ani3);
		   
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       cooltime1=6;
	       cooltime2=6;
	       cooltime3=0;
	       cooltime4=12;
	       continue1=0;
	       continue2=3;
	       continue3=0;
	       continue4=0;
	       abilityk1=1;
	       abilityk2=3;
	       abilityk3=5;
	       abilityk4=2;
	       maxBlood=1180;
	       maxMagic=300;
	       blood=1180;
	       magic=300;	       
	       force=23;
	       attack=52;
	       quick=16;
	       intelligence=14;
	       defence=(float)3.3;
	       dforce=(float)2.9;
	       dquick=(float)2.0;
	       dintellience=(float)1.3;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image( GameScreen.assetManager2.get(("Panda/xiongmao.png"),Texture.class));
		       else
		    	   image=new Image( GameScreen.assetManager2.get(("Panda/xiongmao_re.png"),Texture.class));
	       image.setScale(0.45F);
		       if(!reverse)
		       image.setPosition(100,350);
		       else
		       image.setPosition(70,350);		       
		       if(!reverse){
			       button1=new CusButton(17,884, GameScreen.assetManager2.get(("Panda/5-white.png"),Texture.class), GameScreen.assetManager2.get(("Panda/5.png"),Texture.class), GameScreen.assetManager2.get(("Panda/5.png"),Texture.class), GameScreen.assetManager2.get(("Panda/5-black.png"),Texture.class), GameScreen.assetManager2.get(("textground.png"),Texture.class),"雷霆一击",reverse,6);
			       button2=new CusButton(17,793, GameScreen.assetManager2.get(("Panda/4-white.png"),Texture.class), GameScreen.assetManager2.get(("Panda/4.png"),Texture.class), GameScreen.assetManager2.get(("Panda/4.png"),Texture.class), GameScreen.assetManager2.get(("Panda/4-black.png"),Texture.class), GameScreen.assetManager2.get(("textground.png"),Texture.class),"喷火",reverse,6);
			       button3=new CusButton(17,702, GameScreen.assetManager2.get(("Panda/1.png"),Texture.class), GameScreen.assetManager2.get(("Panda/1.png"),Texture.class), GameScreen.assetManager2.get(("Panda/1.png"),Texture.class),null, GameScreen.assetManager2.get(("textground.png"),Texture.class),"醉拳",reverse,0);
			       button4=new CusButton(17,612, GameScreen.assetManager2.get(("Panda/2-white.png"),Texture.class), GameScreen.assetManager2.get(("Panda/2.png"),Texture.class), GameScreen.assetManager2.get(("Panda/2.png"),Texture.class), GameScreen.assetManager2.get(("Panda/2-black.png"),Texture.class), GameScreen.assetManager2.get(("textground.png"),Texture.class),"迷醉",reverse,12);
			       }else{
			    	    button1=new CusButton(644-17,884, GameScreen.assetManager2.get(("Panda/5-white.png"),Texture.class), GameScreen.assetManager2.get(("Panda/5.png"),Texture.class), GameScreen.assetManager2.get(("Panda/5.png"),Texture.class), GameScreen.assetManager2.get(("Panda/5-black.png"),Texture.class), GameScreen.assetManager2.get(("textground.png"),Texture.class),"雷霆一击",reverse,6);
					       button2=new CusButton(644-17,793, GameScreen.assetManager2.get(("Panda/4-white.png"),Texture.class), GameScreen.assetManager2.get(("Panda/4.png"),Texture.class), GameScreen.assetManager2.get(("Panda/4.png"),Texture.class), GameScreen.assetManager2.get(("Panda/4-black.png"),Texture.class), GameScreen.assetManager2.get(("textground.png"),Texture.class),"喷火",reverse,6);
					       button3=new CusButton(644-17,702, GameScreen.assetManager2.get(("Panda/1.png"),Texture.class), GameScreen.assetManager2.get(("Panda/1.png"),Texture.class), GameScreen.assetManager2.get(("Panda/1.png"),Texture.class),null, GameScreen.assetManager2.get(("textground.png"),Texture.class),"醉拳",reverse,0);
					       button4=new CusButton(644-17,612, GameScreen.assetManager2.get(("Panda/2-white.png"),Texture.class), GameScreen.assetManager2.get(("Panda/2.png"),Texture.class), GameScreen.assetManager2.get(("Panda/2.png"),Texture.class), GameScreen.assetManager2.get(("Panda/2-black.png"),Texture.class), GameScreen.assetManager2.get(("textground.png"),Texture.class),"迷醉",reverse,12);
					   
			       }
		       
		       
		       button1.round=6;
		       button2.round=6;
		       button3.round=0;
		       button4.round=12;
		       
		       
		       button1.b.addListener(new ClickListener(){
		    	   public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
		    		   if(!abcool1){ 
		    		   stage.fg.enter.play();
		    		   }
		    	   }
			    	  public void clicked(InputEvent e,float x,float y){	 
			    		  if(stage.fg.canClick){
			    			  if(magic>=80&&!abcool1){ 
				    			   button1.isClicked=true;
				    		  button2.isClicked=false;
				    		  button4.isClicked=false;
				    		  sphere=true;
				  		    Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm2, pm2.getWidth()/2, pm2.getHeight()/2));
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
			    			  if(magic>=80&&!abcool2){ 
				    			   button1.isClicked=false;
				    		  button2.isClicked=true;
				    		  button4.isClicked=false;
				    		  sphere=false;
				    		  Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm1,0,0));
				    	  }
			    	  }}
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
			    			  if(magic>=200&&!abcool4){  
			    		  button4.isClicked=true;
			    		  button1.isClicked=false;
			    		  button2.isClicked=false;
			    		  sphere=false;
			    		  Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm1,0,0));
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
			      this.addActor(skillpanel);
				     this.addActor(image);
			           this.addActor(property);
			           this.addActor(tool);    
		      this.addActor(bg);
		            this.addActor(button1);
		            this.addActor(button2);
		            this.addActor(button3);
		            this.addActor(button4); 
		            this.addActor(light);
		           this.addActor(sg);
		           this.addActor(lei);
		           this.addActor(mizui);
		           this.addActor(penhuo);
		                 this.addActor(fir);
		                 this.addActor(skill);
		                   this.addActor(hb);
		            this.addActor(blackground); this.addActor(Skill4);
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
	//熊猫酒仙： 雷霆一击（九宫格+i*50，冷却6,耗魔80）
	@Override
	public boolean ability1() {
		 button1.ct.update(cooltime1);
		   button1.cool();
	
			    a=FruitGroup.fruits[x][y].getX();
			    b=FruitGroup.fruits[x][y].getY();
		 if(this.magic>=80&&!abcool1){
				lei.move(stage.fg.delay1);
				DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
		        RunnableAction run3=Actions.run(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						lei.reset();
					}
		        	
		        });
			    SequenceAction sa2=Actions.sequence(delay3, run3);
				lei.addAction(sa2);
		    	ani1=new Animation(0.05F,ta2.getRegions(),PlayMode.NORMAL);
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
         RunnableAction run1=Actions.run(new Runnable(){
             
				@Override
				public void run() {
					// TODO Auto-generated method stub
					FruitGroup.fruits[x][y].Ability1(ani1,340,200,a,b);
					int c=ran.nextInt(3);
					if(c==0)
					attack1.play(1.0F);
					else if(c==1)
				    attack2.play(1.0F);
					else
					attack3.play(1.0F);
					firesound.play(1.0F);
				}
         	
         });
		    SequenceAction sa1=Actions.sequence(delay1, run1);
			 
			 
				for(int i=x-1;i<=x+1;i++){
					for(int j=y-1;j<=y+1;j++){
						try{
						FruitGroup.bombFruit2.add(FruitGroup.fruits[i][j]);
					}
					catch(ArrayIndexOutOfBoundsException e){
					}
			   }
		    } 
				 RunnableAction run = new RunnableAction();
				 DelayAction delay=Actions.delay(stage.fg.delay1+1);
				 SequenceAction sequenceAction=Actions.sequence(delay,run);
				 
				if(stage.hero1t){
				if(stage.hero2.blood>=50){
					stage.hero2.blood-=50;
					run.setRunnable(new Runnable(){
						@Override
						public void run() {	
							stage.hero2.bg.cb.blood=stage.hero2.blood;
							stage.hero2.bg.blo.setText((int)stage.hero2.blood+"/"+(int)stage.hero2.maxBlood);
						}
					});
					
				}}else{                              
					if(stage.hero1.blood>=50){
					   stage.hero1.blood-=50;
					   run.setRunnable(new Runnable(){
							@Override
							public void run() {	
								 stage.hero1.bg.cb.blood=stage.hero1.blood;
								 stage.hero1.bg.blo.setText((int)stage.hero1.blood+"/"+(int)stage.hero1.maxBlood);
							}
							
						});			  
					}
				}
				 run.setRunnable(new Runnable(){
					@Override
					public void run() {
						magic-=80;
						bg.cb.blood=blood;                     
						bg.blo.setText((int)blood+"/"+(int)maxBlood);
						bg.cb.magic=magic;                    
						bg.mag.setText((int)magic+"/"+(int)maxMagic);				
					}                                              
					                    
				 });              
				 FruitGroup.fruits[x][y].addAction(sa1);   
				this.addAction(sequenceAction);
				return true;
			}else{
				return false;
			}
	}
    
	//喷火（烧灼对方总血量4%*i，持续3回合，冷却6，耗魔80） 
	@Override
	public boolean ability2() {
		//长期技能的模板
		button2.ct.update(cooltime2);
		   button2.cool();

		   
				if((this.magic>=80||run2)&&(!abcool2||run2)){
					if(!run2)
					abround2=stage.round;
					if(!run2){
					this.magic-=80;
					}        
				if(this.blood>maxBlood){
					blood=maxBlood;
				}
				penhuo.move(stage.fg.delay1);
				DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
		        RunnableAction run3=Actions.run(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						penhuo.reset();
					}
		        	
		        });
			    SequenceAction sa2=Actions.sequence(delay3, run3);
				penhuo.addAction(sa2);
				  DelayAction delay2=Actions.delay(1.0F);
		            
		            RunnableAction run4=Actions.run(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							fir.reset();
						}
		            	
		            });
				 
					
			    
			    	DelayAction delay1=Actions.delay(stage.fg.delay1);
		        RunnableAction run1=Actions.run(new Runnable(){
		            
					@Override
					public void run() {
						// TODO Auto-generated method stub
				        fir.draw=true;
		                 firsound.play(1.0F);
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
						bg.cb.magic=magic;
						bg.mag.setText((int)magic+"/"+(int)maxMagic);
						if(temp){
							stage.hero2.blood*=0.8;
							stage.hero2.bg.cb.blood=stage.hero2.blood;
							stage.hero2.bg.blo.setText((int)stage.hero2.blood+"/"+(int)stage.hero2.maxBlood);
							}else{
								stage.hero1.blood*=0.8;
								stage.hero1.bg.cb.blood=stage.hero1.blood;
								stage.hero1.bg.blo.setText((int)stage.hero1.blood+"/"+(int)stage.hero1.maxBlood);
							}	
					}
				 });this.addAction(sa1);
				this.addAction(sequenceAction);
				run2=true;
				return true;
				}else{
					return false;
				}
	}
	//醉拳（暴击2倍，i*8%，固有）//伤害阶段  
	@Override
	public boolean ability3() {
		stage.fg.hurt*=2;
		return false;
	}
    
	//迷醉（愤怒i*20%，所有非固有技能效果翻倍，12，200）
	@Override
	public boolean ability4() {
		button4.ct.update(cooltime4);
		   button4.cool();
		if(this.magic>=120&&!abcool4){
			mizui.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					mizui.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			mizui.addAction(sa2);
			 if(stage.hero1t){
				 DelayAction delay5=Actions.delay(stage.fg.delay1);
			blackground.setVisible(true);  
			
			DelayAction da2=Actions.delay(0.8F);
			MoveByAction mba1=Actions.moveBy(1750, 0,0.2F,Interpolation.sineIn);
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
					Skill4.setPosition(-1200, 350);
				}
				
			});
			SequenceAction sa=Actions.sequence(delay5,mba1,rab,da2, mba2,ra);
			Skill4.addAction(sa); 
				
			stage.fg.delay1+=2;
		 }
			  DelayAction delay2=Actions.delay(1.0F);
	            
	            RunnableAction run4=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						skill.reset();
					}
	            	
	            });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
	        RunnableAction run1=Actions.run(new Runnable(){
	            
				@Override
				public void run() {
					// TODO Auto-generated method stub
			        skill.draw=true;
			        stage.viberation();
	                 firesound.play(1.0F);
				}
	        	
	        });
		  
				   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run4);
			
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					magic-=120;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
		            state.add(Hero.State.dodge);
		            cdodge+=2;
		            state.add(Hero.State.angry);
		            cangry+=2;
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
				 while(stage.fg.vanish()){
					  stage.fg.descend();
				  }
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
       //熊猫酒仙
}
