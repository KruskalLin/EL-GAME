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
import actor.CusButton;
import actor.FruitGroup;
import actor.SmallThing;
import stage.GameStage;
import label.*;
public class ArchMage extends Hero {
	private TextureAtlas ta1;
	private TextureAtlas ta2;
	private TextureAtlas ta3;
	private TextureAtlas ta4;
	private TextureAtlas ta5;
	private Animation ani1;
	private float a,b;
    private Random ran;
    private Date date;
    private Image Skill4;
    private Sound mag;
    private Sound magflow;
    private Sound vain;
    private Sound heal;
    private SmallThing book;
    private SmallThing magflo;
    private SmallThing vaining;
    private SmallThing skill4;
    zhihuizhishu zhi;
    falisunhui fa;
    xuwu xu;
    chongjibo ch;
    
	
	
	
	
	
	
	
	
	
	//大魔法师：冲击波（九宫格+i*50，冷却6,耗魔80）  
	// 智慧之书（补魔50*i，4，耗魔20）
	  //法力流逝（3回合每回合流逝总魔法15%+2.5*i，如果回合中魔法为零时进入 眩晕1回合,6，80）
	// 虚无（进入5回合闪避状态，前三技能冷却时间减少i,如果其他技能还在冷却，还需冷却局数立即少i,9，120）
	//力量：16+ 1.8	攻击力：38
	//敏捷：15 + 1.6	初始血量：454  初始魔法：286
	//智力：22 + 2.8	护甲：0.9
	public ArchMage(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       
	       zhi=new zhihuizhishu(reverse);
	       fa=new falisunhui(reverse);
	       xu=new xuwu(reverse);
	       ch=new chongjibo(reverse);
	       money=400;
	       xp=300;
	       
	       pm1=new Pixmap(Gdx.files.internal("hand.png"));
	       pm2 = new Pixmap(Gdx.files.internal("sphere.png")); 
	       date=new Date();
	       ran=new Random(date.getTime());
	     
	       Yes1= GameScreen.assetManager2.get(("Arc/HeroArchMageYes1.wav"),Sound.class);
	       Yes2= GameScreen.assetManager2.get(("Arc/HeroArchMageYes2.wav"),Sound.class);
	       Yes3= GameScreen.assetManager2.get(("Arc/HeroArchMageYes3.wav"),Sound.class);
	       Yes4= GameScreen.assetManager2.get(("Arc/HeroArchMageYes4.wav"),Sound.class);
	       attack1= GameScreen.assetManager2.get(("Arc/HeroArchMageYesAttack1.wav"),Sound.class);
	       attack2= GameScreen.assetManager2.get(("Arc/HeroArchMageYesAttack2.wav"),Sound.class);
	       attack3= GameScreen.assetManager2.get(("Arc/HeroArchMageYesAttack3.wav"),Sound.class);
	       mag=GameScreen.assetManager2.get(("Arc/FragBombs.wav"),Sound.class);
	       magflow=GameScreen.assetManager2.get(("Arc/InnerFireBirth.wav"),Sound.class);
	       vain=GameScreen.assetManager2.get(("Arc/ManaShieldCaster1.wav"),Sound.class);
	       heal=GameScreen.assetManager2.get(("FarSeer/SpiritWalkerMorph.wav"),Sound.class);
	       ta1=GameScreen.assetManager2.get(("FarSeer/heal.pack"),TextureAtlas.class);
	       ta2=GameScreen.assetManager2.get(("Arc/BO.pack"),TextureAtlas.class);
	       ta3=GameScreen.assetManager2.get(("Arc/skill4.pack"),TextureAtlas.class);
	       ta4=GameScreen.assetManager2.get(("Arc/fight.pack"),TextureAtlas.class);
	       Animation ani=new Animation(0.05F,ta1.getRegions(),PlayMode.NORMAL);
		      
	       Animation ani2=new Animation(0.05F,ta4.getRegions(),PlayMode.NORMAL);
	   	   Animation ani3=new Animation(0.1F,ta3.getRegions(),PlayMode.NORMAL);
	   	   if(!reverse)
	       book=new SmallThing(200,300,ani);
	       else 
	    	   book=new SmallThing(100,300,ani);
	   	   
	   	  if(!reverse)
		       magflo=new SmallThing(1500,400,ani2);
	   	  
		       else 
		    	   magflo=new SmallThing(-1300,400,ani2);
	       if(!reverse)
		       skill4=new SmallThing(50,200,ani3);
		       else 
		    	   skill4=new SmallThing(0,200,ani3);
	       
	       
	       book.a*=2;
	       book.b*=2;
	       
	       
	      skill4.a*=3;
	      skill4.b*=3;
	       
	       
	       
	       
	       cooltime1=6;
	       cooltime2=4;
	       cooltime3=6;
	       cooltime4=9;
	       continue1=0;
	       continue2=0;
	       continue3=3;
	       continue4=0;
	       abilityk1=1;
	       abilityk2=2;
	       abilityk3=3;
	       abilityk4=2;
	       maxBlood=908;
	       maxMagic=286;
	       blood=908;
	       magic=286;	       
	       force=16;
	       attack=38;
	       quick=15;
	       intelligence=22;
	       defence=(float)0.9;
	       dforce=(float)1.8;
	       dquick=(float)1.6;
	       dintellience=(float)2.8;
	       
	 
	       
	       if(!reverse){
		       button1=new CusButton(17,884,GameScreen.assetManager2.get(("Arc/10-white.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/10.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/10.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/10-black.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"冲击波",reverse,6);
		       button2=new CusButton(17,793,GameScreen.assetManager2.get(("Arc/11-white.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/11.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/11.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/11-black.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"智慧之书",reverse,4);
		       button3=new CusButton(17,702,GameScreen.assetManager2.get(("Arc/12-white.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/12.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/12.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/12-black.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"法力流逝",reverse,6);
		       button4=new CusButton(17,612,GameScreen.assetManager2.get(("Arc/9-white.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/9.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/9.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("Arc/9-black.png"),Texture.class),
		    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"虚无",reverse,9);
		       }else{
		    	    button1=new CusButton(644-17,884,GameScreen.assetManager2.get(("Arc/10-white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/10.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/10.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/10-black.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"冲击波",reverse,6);
				       button2=new CusButton(644-17,793,GameScreen.assetManager2.get(("Arc/11-white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/11.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/11.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/11-black.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"智慧之书",reverse,4);
				       button3=new CusButton(644-17,702,GameScreen.assetManager2.get(("Arc/12-white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/12.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/12.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/12-black.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"法力流逝",reverse,6);
				       button4=new CusButton(644-17,612,GameScreen.assetManager2.get(("Arc/9-white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/9.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/9.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("Arc/9-black.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"虚无",reverse,9);
		       }
	       
	       button1.round=6;
	       button2.round=4;
	       button3.round=6;
	       button4.round=9;
	       
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(GameScreen.assetManager2.get(("Arc/dafashi.png"),Texture.class));
		       else
		    	   image=new Image(GameScreen.assetManager2.get(("Arc/dafashi_re.png"),Texture.class));
		       if(!reverse)
		       image.setPosition(120,300);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504,300);		       

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
					    		  button2.isClicked=false;  sphere=true;
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
			    			  if(magic>=80&!abcool2){ 
				    			   button1.isClicked=false;
				    		  button2.isClicked=true;
				    		  button3.isClicked=false;
				    		  button4.isClicked=false; 
				    		 sphere=false;
				    		  Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm1,0,0));
				    		  
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
	           this.addActor(ch);
	           this.addActor(fa);
	           this.addActor(zhi);
	           this.addActor(xu);
	            this.addActor(light);
	           this.addActor(sg);
	           this.addActor(book);
	           this.addActor(magflo);
	           this.addActor(skill4);
	        
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
	
	
	
	
	
	
	
	
	
	
	
	//大魔法师：冲击波（九宫格+i*50，冷却6,耗魔80）  
	@Override
	public boolean ability1() {
		 button1.ct.update(cooltime1);
		   button1.cool();
	
			    a=FruitGroup.fruits[x][y].getX();
			    b=FruitGroup.fruits[x][y].getY();
		if(this.magic>=80&&!abcool1){
			ch.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					ch.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			ch.addAction(sa2);
	    	ani1=new Animation(0.08F,ta2.getRegions(),PlayMode.NORMAL);
	    	DelayAction delay1=Actions.delay(stage.fg.delay1);
        RunnableAction run1=Actions.run(new Runnable(){
            
			@Override
			public void run() {
				// TODO Auto-generated method stub
				FruitGroup.fruits[x][y].a=1.5F;
				FruitGroup.fruits[x][y].b=1.5F;
				FruitGroup.fruits[x][y].Ability1(ani1,200,200,a,b);
				int c=ran.nextInt(3);
				if(c==0)
				attack1.play(stage.volume);
				else if(c==1)
			    attack2.play(stage.volume);
				else
				attack3.play(stage.volume);
				mag.play(stage.volume);
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
    
	// 智慧之书（补魔50*i，4，耗魔20）
	@Override
	public boolean ability2() {
		 button2.ct.update(cooltime2);
		   button2.cool();
		if(this.magic>=40&&!abcool2){
			zhi.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					zhi.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			zhi.addAction(sa2);
			 DelayAction delay2=Actions.delay(stage.volume);
		        
		        RunnableAction run2=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						book.reset();
					}
		        	
		        });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
		    RunnableAction run1=Actions.run(new Runnable(){
		        
				@Override
				public void run() {
					// TODO Auto-generated method stub
			        book.draw=true;
			        heal.play(stage.volume);
			    	int c=ran.nextInt(3);
					if(c==0)
					attack1.play(stage.volume);
					else if(c==1)
				    attack2.play(stage.volume);
					else
					attack3.play(stage.volume);
				}
		    	
		    });
		  
				   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
			
			
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					magic+=80;
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
	//法力流逝（3回合每回合流逝总魔法15%+2.5*i，如果回合中魔法为零时进入 眩晕1回合,6，80）
	@Override
	public boolean ability3() {
		//长期技能的模板
		 button3.ct.update(cooltime3);
		   button3.cool();
				if((this.magic>=100||run3)&&(!abcool3||run3)){
					
					if(!run3)
					abround3=stage.round;
					if(!run3){
					this.magic-=80;
					}     
					fa.move(stage.fg.delay1);
					DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
			        RunnableAction run4=Actions.run(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
						fa.reset();
						}
			        	
			        });
				    SequenceAction sa2=Actions.sequence(delay3, run4);
					fa.addAction(sa2);
					 DelayAction delay2=Actions.delay(stage.volume);
				        
				        RunnableAction run2=Actions.run(new Runnable(){

							@Override
							public void run() {
								// TODO Auto-generated method stub
								magflo.reset();
							}
				        	
				        });
					 
						
				    
				    	DelayAction delay1=Actions.delay(stage.fg.delay1);
				    RunnableAction run1=Actions.run(new Runnable(){
				        
						@Override
						public void run() {
							// TODO Auto-generated method stub
					        magflo.draw=true;
					        magflow.play(stage.volume);
					        int c=ran.nextInt(3);
							if(c==0)
							attack1.play(stage.volume);
							else if(c==1)
						    attack2.play(stage.volume);
							else
							attack3.play(stage.volume);
						}
				    	
				    });
				  
						   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
				 RunnableAction run = new RunnableAction();
				 DelayAction delay=Actions.delay(stage.fg.delay1);
				 SequenceAction sequenceAction=Actions.sequence(delay,run);
				 run.setRunnable(new Runnable(){
					public void run() {
						if(stage.hero1t){
						stage.hero2.magic*=0.75;
						stage.hero2.magic-=2.5;
						stage.hero2.bg.cb.magic=stage.hero2.magic;
						stage.hero2.bg.mag.setText((int)stage.hero2.magic+"/"+(int)stage.hero2.maxMagic);
						if(stage.hero2.magic==0){
							stage.hero2.state.add(Hero.State.dizzy);
							stage.hero2.cdizzy=1;
						}
						}else{
							stage.hero1.magic*=0.75;
							stage.hero1.magic-=2.5;
							stage.hero1.bg.cb.magic=stage.hero1.magic;
							stage.hero1.bg.mag.setText((int)stage.hero1.magic+"/"+(int)stage.hero1.maxMagic);
							if(stage.hero1.magic==0){
								stage.hero1.state.add(Hero.State.dizzy);
								stage.hero1.cdizzy=1;
							}
						}
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

	// 虚无（进入5回合闪避状态，前三技能冷却时间减少i,如果其他技能还在冷却，还需冷却局数立即少i,9，120）
	@Override
	public boolean ability4() {
		 button4.ct.update(cooltime4);
		   button4.cool();
				if((this.magic>=100||run4)&&(!abcool4||run4)){
					xu.move(stage.fg.delay1);
					DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
			        RunnableAction run3=Actions.run(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
							xu.reset();
						}
			        	
			        });
				    SequenceAction sa2=Actions.sequence(delay3, run3);
				xu.addAction(sa2);
					if(!run4)
					abround4=stage.round;
					if(!run4){
					this.magic-=120;
					}        
				if(this.blood>maxBlood){
					blood=maxBlood;
				}
				
				 DelayAction delay2=Actions.delay(stage.volume);
			        
			        RunnableAction run2=Actions.run(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							skill4.reset();
						}
			        	
			        });
				 
					
			    
			    	DelayAction delay1=Actions.delay(stage.fg.delay1);
			    RunnableAction run1=Actions.run(new Runnable(){
			        
					@Override
					public void run() {
						// TODO Auto-generated method stub
				        skill4.draw=true;
				        attack1.play(stage.volume);
				        vain.play(stage.volume);
				        int c=ran.nextInt(3);
						if(c==0)
						attack1.play(stage.volume);
						else if(c==1)
					    attack2.play(stage.volume);
						else
						attack3.play(stage.volume);
					}
					
			    	
			    });
			  
					   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
				 RunnableAction run = new RunnableAction();
				 DelayAction delay=Actions.delay(stage.fg.delay1);
				 SequenceAction sequenceAction=Actions.sequence(delay,run);
				 run.setRunnable(new Runnable(){
					@Override
					public void run() {
						if(continue1!=0){
							continue1-=1;
						}
						if(continue2!=0){
							continue2-=1;
						}
						if(continue3!=0){
							continue3-=1;
						}
						state.add(Hero.State.dodge);
						cdodge+=5;
						
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
		if(magic<=50){
			if(!abcool2)
			if(ability2()){
				abcool2=true;
				return true;
			}else{
				return false;
			}
		}else{
			//int k=ran.nextInt(3);
			int k=2;
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
				if(!abcool3)
				if(ability3()){
					abcool3=true;
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
			
		}
		
		
		return false;
	}
       
}
