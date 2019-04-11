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
import stage.GameStage;
import label.*;
public class FarSeer extends Hero {
	private TextureAtlas ta1;
	private TextureAtlas ta2;
	private TextureAtlas ta3;
	private TextureAtlas ta4;
	private Animation ani1;
	private float a,b;
    private Random ran;
    private Date date;
    private Image Skill4;
    private Sound Heal;
    private Sound bolt1;
    private Sound bolt2;
    private Sound bolt3;
    private SmallThing st1;
    private SmallThing st2;
    private SmallThing st3;
    
    dianliu di;
    shandian sh;
    mingxiang mi;
    jingtaifengbao ji;
    
	
	
	//萨尔： 电流（使对方麻痹i回合，6，60） 
	 //闪电（九宫格+i*50，冷却6,耗魔80） 
	 //冥想（3回合恢复血i*100，恢复魔i*60，8，80）
	   //静态风暴（对方进入沉默状态3回合，每回合扣血i*150，10，125）
	//力量：19 + 1.9	攻击力：49 
	//敏捷：22+ 2.5	初始血量:511  初始魔法：286
	//智力：22 + 2.8	护甲：0.9
	public FarSeer(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       di=new dianliu(reverse);
	       sh=new shandian(reverse);
	       mi=new mingxiang(reverse);
	       ji=new jingtaifengbao(reverse);
	       money=200;
	       xp=500;
	       
	       Skill4=new Image(GameScreen.assetManager2.get(("FarSeer/far.png"),Texture.class));
	       Skill4.setScale(2.0F);
	       pm1=new Pixmap(Gdx.files.internal("hand.png"));
	       pm2 = new Pixmap(Gdx.files.internal("sphere.png")); 
	       date=new Date();
	       ran=new Random(date.getTime());
	       if(!reverse)
		       Skill4.setPosition(-1000, 350);
	         else
	        	 Skill4.setPosition(700+4008, 350);
	       Skill4.setScale(1.5F);
	       Yes1=  GameScreen.assetManager2.get(("FarSeer/HeroFarseerYes1.wav"),Sound.class);
	       Yes2=  GameScreen.assetManager2.get(("FarSeer/HeroFarseerYes2.wav"),Sound.class);
	       Yes3=  GameScreen.assetManager2.get(("FarSeer/HeroFarseerYes3.wav"),Sound.class);
	       Yes4=  GameScreen.assetManager2.get(("FarSeer/HeroFarseerYes4.wav"),Sound.class);
	       attack1=  GameScreen.assetManager2.get(("FarSeer/HeroFarseerYesAttack1.wav"),Sound.class);
	       attack2=  GameScreen.assetManager2.get(("FarSeer/HeroFarseerYesAttack2.wav"),Sound.class);
	       attack3=  GameScreen.assetManager2.get(("FarSeer/HeroFarseerYesAttack3.wav"),Sound.class);
	       bolt1=  GameScreen.assetManager2.get(("FarSeer/LightningShieldTarget.wav"),Sound.class);
	       bolt2=  GameScreen.assetManager2.get(("FarSeer/PurgeTarget1.wav"),Sound.class);
	       bolt3=  GameScreen.assetManager2.get(("FarSeer/LightningBolt.wav"),Sound.class);
	       Heal=  GameScreen.assetManager2.get(("FarSeer/SpiritWalkerMorph.wav"),Sound.class);
	       ta1=GameScreen.assetManager2.get(("FarSeer/heal.pack"),TextureAtlas.class);
	       ta2=GameScreen.assetManager2.get(("FarSeer/ele.pack"),TextureAtlas.class);
	       ta3=GameScreen.assetManager2.get(("FarSeer/lightning.pack"),TextureAtlas.class);
	       ta4=GameScreen.assetManager2.get(("FarSeer/ss.pack"),TextureAtlas.class);
	       Animation ani=new Animation(0.05F,ta2.getRegions(),PlayMode.NORMAL);
		      
	       Animation ani2=new Animation(0.05F,ta4.getRegions(),PlayMode.NORMAL);
	   	   Animation ani3=new Animation(0.1F,ta1.getRegions(),PlayMode.NORMAL);
	   	   if(!reverse)
	       st3=new SmallThing(1500,300,ani);
	       else 
	    	   st3=new SmallThing(-1400,300,ani);
	   	   
	   	  if(!reverse)
		       st2=new SmallThing(1500,300,ani2);
		       else 
		    	   st2=new SmallThing(-1200,300,ani2);
	       if(!reverse)
		       st1=new SmallThing(250,500,ani3);
		       else 
		    	   st1=new SmallThing(0,500,ani3);
	       st1.a*=2;
	       st1.b*=2;
	       
	       
	       st2.a*=2;
	       st2.b*=2;
	       
	       
	       
	       
	       
	       
	       
	       cooltime1=6;
	       cooltime2=6;
	       cooltime3=8;
	       cooltime4=10;
	       continue1=0;
	       continue2=0;
	       continue3=3;
	       continue4=3;
	       abilityk1=2;
	       abilityk2=1;
	       abilityk3=3;
	       abilityk4=3;
	       maxBlood=1022;
	       maxMagic=300;
	       blood=1022;
	       magic=300;
	       
	       force=19;
	       attack=49;
	       quick=22;
	       intelligence=22;
	       defence=(float)0.9;
	       dforce=(float)1.9;
	       dquick=(float)2.5;
	       dintellience=(float)2.8;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(GameScreen.assetManager2.get(("FarSeer/Farseer_re.png"),Texture.class));
		       else
		    	   image=new Image(GameScreen.assetManager2.get(("FarSeer/Farseer.png"),Texture.class));
		       if(!reverse)
		       image.setPosition(120,400);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504,400);
		       
		       
		       if(!reverse){
			       button1=new CusButton(17,884,GameScreen.assetManager2.get(("FarSeer/5-white.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/5.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/5.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/5-black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"电流",reverse,6);
			       button2=new CusButton(17,793,GameScreen.assetManager2.get(("FarSeer/4-white.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/4.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/4.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/4-black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"闪电",reverse,6);
			       button3=new CusButton(17,702,GameScreen.assetManager2.get(("FarSeer/3-white.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/3.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/3.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/3-black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"冥想",reverse,8);
			       button4=new CusButton(17,612,GameScreen.assetManager2.get(("FarSeer/2-white.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/2.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/2.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/2-black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"静态风暴",reverse,10);
			       }else{
			    	    button1=new CusButton(704-60-17,884,GameScreen.assetManager2.get(("FarSeer/5-white.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/5.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/5.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/5-black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"电流",reverse,6);
					       button2=new CusButton(704-60-17,793,GameScreen.assetManager2.get(("FarSeer/4-white.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/4.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/4.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/4-black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"闪电",reverse,6);
					       button3=new CusButton(704-60-17,702,GameScreen.assetManager2.get(("FarSeer/3-white.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/3.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/3.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/3-black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"冥想",reverse,8);
					       button4=new CusButton(704-60-17,612,GameScreen.assetManager2.get(("FarSeer/2-white.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/2.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/2.png"),Texture.class),GameScreen.assetManager2.get(("FarSeer/2-black.png"),Texture.class),GameScreen.assetManager2.get(("textground.png"),Texture.class),"静态风暴",reverse,10);
					  
			       }
		       
		       button1.round=6;
		       button2.round=6;
		       button3.round=8;
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
					    		  button2.isClicked=false;
				    		 sphere=false; 
				  		   Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm1,0,0));
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
				    		  sphere=true;
				    		  Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm2, pm2.getWidth()/2, pm2.getHeight()/2));
				    		  
				    	  }
			    	  }}
			      });
			      button3.b.addListener(new ClickListener(){
			    	   public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
			    		   if(!abcool3){ 
			    		   stage.fg.enter.play();
			    		   }
			    	   }
			    	  public void clicked(InputEvent e,float x,float y){
			    		  if(magic>=80&&!abcool3){  
				    		  button4.isClicked=false;
				    		  button1.isClicked=false;
				    		  button3.isClicked=true;
				    		  button2.isClicked=false;
				    		  sphere=false;
				    		  Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm1,0,0));
				    	  }
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
	         this.addActor(di);
	         this.addActor(ji);
	         this.addActor(mi);
	         this.addActor(sh);
	            this.addActor(light);
	           this.addActor(sg);
	           this.addActor(st1);
	           this.addActor(st2);
	           this.addActor(st3);
	   
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
	
	
	
	
	//萨尔： 电流（使对方麻痹i回合，6，60） 
	@Override
	public boolean ability1() {
		 button1.ct.update(cooltime1);
		   button1.cool();
		if(this.magic>=60&&!abcool1){
			di.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
			di.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
		di.addAction(sa2);
			magic-=60;
			boolean temp=stage.hero1t;
			  DelayAction delay2=Actions.delay(1.0F);
		        
		        RunnableAction run2=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						st3.reset();
					}
		        	
		        });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
		    RunnableAction run1=Actions.run(new Runnable(){
		        
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int c=ran.nextInt(3);
					if(c==0)
					attack1.play(1.0F);
					else if(c==1)
				    attack2.play(1.0F);
					else
					attack3.play(1.0F);
			        st3.draw=true;
			        bolt2.play(1.0F);
				}
		    	
		    });
		  
				   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
					if(temp){
						stage.hero2.state.add(Hero.State.dizzy);
						stage.hero2.cdizzy+=2;
					}else{
						stage.hero1.state.add(Hero.State.dizzy);
						stage.hero1.cdizzy+=2;
					}
				}
				 
			 });
			 this.addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		return false;
	}
	 //闪电（九宫格+i*50，冷却6,耗魔80）
	@Override
	public boolean ability2() {
		 button2.ct.update(cooltime2);
		   button2.cool();
	
			    a=FruitGroup.fruits[x][y].getX();
			    b=FruitGroup.fruits[x][y].getY();
		   if(this.magic>=80&&!abcool2){
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
				ani1=new Animation(0.1F,ta3.getRegions(),PlayMode.NORMAL);
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
	        RunnableAction run1=Actions.run(new Runnable(){
	            
				@Override
				public void run() {
					// TODO Auto-generated method stub
					FruitGroup.fruits[x][y].Ability1(ani1,100,100,a,b);
					bolt1.play(1.0F);
					int c=ran.nextInt(3);
					if(c==0)
					attack1.play(1.0F);
					else if(c==1)
				    attack2.play(1.0F);
					else
					attack3.play(1.0F);
		            stage.viberation();
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
			}	}

	 //冥想（3回合恢复血i*100，恢复魔i*60，8，80）
	@Override
	public boolean ability3() {
		//长期技能的模板
		button3.ct.update(cooltime3);
		   button3.cool();
				if((this.magic>=100||run3)&&(!abcool3||run3)){
				mi.move(stage.fg.delay1);
					DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
			        RunnableAction run4=Actions.run(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
					mi.reset();
						}
			        	
			        });
				    SequenceAction sa2=Actions.sequence(delay3, run4);
				mi.addAction(sa2);
					if(!run3)
					abround3=stage.round;
					if(!run3){
					this.magic-=100;
					}        
				if(this.blood>maxBlood){
					blood=maxBlood;
				}
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
				        Heal.play(1.0F);
				        int c=ran.nextInt(3);
						if(c==0)
						attack1.play(1.0F);
						else if(c==1)
					    attack2.play(1.0F);
						else
						attack3.play(1.0F);
					}
			    	
			    });
			  
					   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
				 RunnableAction run = new RunnableAction();
				 DelayAction delay=Actions.delay(stage.fg.delay1);
				 SequenceAction sequenceAction=Actions.sequence(delay,run);
				 run.setRunnable(new Runnable(){
					@Override
					public void run() {
						blood+=100;
						bg.cb.blood=blood;
						bg.blo.setText((int)blood+"/"+(int)maxBlood);
						magic+=60;
						bg.cb.magic=magic;
						bg.mag.setText((int)magic+"/"+(int)maxMagic);				
					}
				 });
				 this.addAction(sa1);
				this.addAction(sequenceAction);
				run3=true;
				return true;
				}else{
					return false;
				}


	}

	//静态风暴（对方进入沉默状态3回合，每回合扣血i*150，10，125）
	@Override
	public boolean ability4() {
		button4.ct.update(cooltime4);
		   button4.cool();
		//长期技能的模板
				if((this.magic>=150||run4)&&(!abcool4||run4)){
				ji.move(stage.fg.delay1);
					DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
			        RunnableAction run3=Actions.run(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
						ji.reset();
						}
			        	
			        });
				    SequenceAction sa2=Actions.sequence(delay3, run3);
				ji.addAction(sa2);
					if(!run4)
					abround4=stage.round;
					if(!run4){
					this.magic-=150;
					if(stage.hero1t){
						stage.hero2.state.add(Hero.State.silent);
						stage.hero2.csilent+=3;
					}else{
						stage.hero1.state.add(Hero.State.silent);
						stage.hero1.csilent+=3;
					}
					}        
				if(this.blood>maxBlood){
					blood=maxBlood;
				}
				 boolean temp=stage.hero1t;
				
		/*		 if(temp){
					 DelayAction delay5=Actions.delay(stage.fg.delay1);
				blackground.setVisible(true);  
				
				DelayAction da2=Actions.delay(0.8F);
				MoveByAction mba1=Actions.moveBy(1750, 0,0.2F,Interpolation.sineIn);
				MoveByAction mba2=Actions.moveBy(1550, 0,0.2F,Interpolation.sineIn);
				RunnableAction rab=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						attack3.play(1.0F);
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
			 }*/
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
	                    bolt3.play(1.0F);
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
						stage.hero2.blood-=150;
						stage.hero2.bg.cb.blood=stage.hero2.blood;
						stage.hero2.bg.blo.setText((int)stage.hero2.blood+"/"+(int)stage.hero2.maxBlood);
						}else{
							stage.hero1.blood-=150;
							stage.hero1.bg.cb.blood=stage.hero1.blood;
							stage.hero1.bg.blo.setText((int)stage.hero1.blood+"/"+(int)stage.hero1.maxBlood);
						}
						bg.cb.magic=magic;
						bg.mag.setText((int)magic+"/"+(int)maxMagic);				
					}
				 });
				 
				 this.addAction(sa1);
				this.addAction(sequenceAction);
				run4=true;
				return true;
				}else{
					return false;
				}

	}





	@Override
	public boolean AI() {
		if(blood<=500||magic<100){
			if(!abcool3)
			if(ability3()){
				abcool3=true;
				return true;
			}
		}else{
			int k=ran.nextInt(2);
			k=3;
			if(k==1){
				if(!abcool1)
				if(ability1()){
					abcool1=true;
					return true;
				}
			}
			if(k==2){
				if(!abcool2)
				if(ability2()){
					 while(stage.fg.vanish()){
						  stage.fg.descend();
					  }
					abcool2=true;
					return true;
				}
			}
			if(k==3){
				if(!abcool4)
				if(ability4()){
					abcool4=true;
					return true;
				}
			}
		}
		return false;
	}
      
}
