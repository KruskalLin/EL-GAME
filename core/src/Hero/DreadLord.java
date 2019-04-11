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
public class DreadLord extends Hero {
	
	
	private TextureAtlas ta1;
	private TextureAtlas ta2;
	private TextureAtlas ta3;
	private TextureAtlas ta4;
	private Animation ani1;
	private float a,b;
	private Sound backlight;
	private Sound heal;
	private Sound shield;
    private Random ran;
    private Date date;
    private Image Skill4;
    private Sound vain;
    private Sound fire;
    private Sound scary;
    private SmallThing ring;
    private SmallThing scar;
    siwangxukong si;
    shangcankongju sh;
    diyuhuo di;
	//恐惧魔王：
	 //死亡虚空（九宫格+i*50，冷却6,耗魔80）
	 //伤残恐惧（诅咒对方，闪避i回合，6，100）  
	 //吸血光环（吸血攻击10%*i，固有）//攻击阶段  
	 //地狱火（烧灼每回合5%总血量，自己愤怒i*10%，暴击2倍10% 共持续2回合，8，150）
	//力量：23 + 2.8	攻击力：56 
	//敏捷：18 + 2.3	初始血量 587 初始魔法 208
	//智力：16 + 1.6	护甲：3

	public DreadLord(GameStage stage,boolean reverse){
		
		   super(stage,reverse);
		   si=new siwangxukong(reverse);
		   sh=new shangcankongju(reverse);
		   di=new diyuhuo(reverse);
		   money=200;
			xp=400;
	       Skill4=new Image(GameScreen.assetManager2.get(("DreadLord/drea.png"),Texture.class));
	       Skill4.setScale(3.0F);
	       pm1=new Pixmap(Gdx.files.internal("hand.png"));
	       pm2 = new Pixmap(Gdx.files.internal("sphere.png")); 
	       date=new Date();
	       ran=new Random(date.getTime());
	       if(!reverse)
		       Skill4.setPosition(-1000, 350);
	         else
	        	 Skill4.setPosition(700+4008, 350);
	       Skill4.setScale(2.5F);
	       Yes1= GameScreen.assetManager2.get(("DreadLord/HeroDreadlordYes1.wav"),Sound.class);
	       Yes2= GameScreen.assetManager2.get(("DreadLord/HeroDreadlordYes2.wav"),Sound.class);
	       Yes3= GameScreen.assetManager2.get(("DreadLord/ss.wav"),Sound.class);
	       Yes4= GameScreen.assetManager2.get(("DreadLord/HeroDreadlordYes4.wav"),Sound.class);
	       attack1= GameScreen.assetManager2.get(("DreadLord/HeroDreadlordYesAttack1.wav"),Sound.class);
	       attack2= GameScreen.assetManager2.get(("DreadLord/HeroDreadlordYesAttack2.wav"),Sound.class);
	       attack3= GameScreen.assetManager2.get(("DreadLord/HeroDreadlordYesAttack3.wav"),Sound.class);
	       ta1=GameScreen.assetManager2.get(("DreadLord/vain.pack"),TextureAtlas.class);
	       ta2=GameScreen.assetManager2.get(("DreadLord/curse.pack"),TextureAtlas.class);
	       ta3=GameScreen.assetManager2.get(("DreadLord/fire.pack"),TextureAtlas.class);
	       ta4=GameScreen.assetManager2.get(("DreadLord/ring.pack"),TextureAtlas.class);
	       war=GameScreen.assetManager2.get(("DreadLord/HeroDreadlordWarcry1.wav"),Sound.class);
	       vain=GameScreen.assetManager2.get(("DreadLord/PossessionMissileHit1.wav"),Sound.class);
	       fire=GameScreen.assetManager2.get(("DreadLord/Incinerate1.wav"),Sound.class);
	       scary=GameScreen.assetManager2.get(("DreadLord/PossessionMissileLaunch1.wav"),Sound.class);
	       Animation ani3=new Animation(0.1F,ta2.getRegions(),PlayMode.NORMAL);
	       if(!reverse)
		       scar=new SmallThing(1400,300,ani3);
		       else 
		     scar=new SmallThing(-1200,300,ani3);
	       Animation ani2=new Animation(0.05F,ta4.getRegions(),PlayMode.LOOP);
	       if(!reverse)
		       ring=new SmallThing(400,100,ani2);
		       else 
		     ring=new SmallThing(100,100,ani2);
	       ring.draw=true;
	       ring.a*=4;
	       ring.b*=4;
	      
	       
	       
	       
	       
	       cooltime1=6;
	       cooltime2=6;
	       cooltime3=0;
	       cooltime4=8;
	       continue1=0;
	       continue2=0;
	       continue3=0;
	       continue4=0;
	       abilityk1=1;
	       abilityk2=2;
	       abilityk3=5;
	       abilityk4=2;
	       maxBlood=1160;
	       maxMagic=208;
	       blood=1160;
	       magic=208;	       
	       force=23;
	       attack=56;
	       quick=18;
	       intelligence=16;
	       defence=3;
	       dforce=(float)2.8;
	       dquick=(float)2.3;
	       dintellience=(float)1.6;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(GameScreen.assetManager2.get(("DreadLord/kongjumowang.png"),Texture.class));
		       else
		    	   image=new Image(GameScreen.assetManager2.get(("DreadLord/kongjumowang_re.png"),Texture.class));
		       if(!reverse)
		       image.setPosition(80,300);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504+40,300);		       
		       if(!reverse){
		    	   button1=new CusButton(17,884,GameScreen.assetManager2.get(("DreadLord/xuwu_white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DreadLord/xuwu.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DreadLord/xuwu.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DreadLord/xuwu_black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"死亡虚空",reverse,6);
			       button2=new CusButton(17,793, GameScreen.assetManager2.get(("DreadLord/sckj-white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DreadLord/sckj.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DreadLord/sckj.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DreadLord/sckj-black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"伤残恐惧",reverse,6);
			       button3=new CusButton(17,702,			    		   GameScreen.assetManager2.get(("DreadLord/XXGH.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("DreadLord/XXGH.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("DreadLord/XXGH.png"),Texture.class),

			    		   null,			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),
"吸血光环",reverse,0);
			       button4=new CusButton(17,612,			    		   GameScreen.assetManager2.get(("DreadLord/14-white.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("DreadLord/14-white.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("DreadLord/14-white.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("DreadLord/14-black.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),
"地狱火",reverse,8);     }else{
	   button1=new CusButton(644-17,884,GameScreen.assetManager2.get(("DreadLord/xuwu_white.png"),Texture.class),
    		   GameScreen.assetManager2.get(("DreadLord/xuwu.png"),Texture.class),
    		   GameScreen.assetManager2.get(("DreadLord/xuwu.png"),Texture.class),
    		   GameScreen.assetManager2.get(("DreadLord/xuwu_black.png"),Texture.class),
    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"死亡虚空",reverse,6);
       button2=new CusButton(644-17,793, GameScreen.assetManager2.get(("DreadLord/sckj-white.png"),Texture.class),
    		   GameScreen.assetManager2.get(("DreadLord/sckj.png"),Texture.class),
    		   GameScreen.assetManager2.get(("DreadLord/sckj.png"),Texture.class),
    		   GameScreen.assetManager2.get(("DreadLord/sckj-black.png"),Texture.class),
    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"伤残恐惧",reverse,6);
       button3=new CusButton(644-17,702,			    		   GameScreen.assetManager2.get(("DreadLord/XXGH.png"),Texture.class),

    		   GameScreen.assetManager2.get(("DreadLord/XXGH.png"),Texture.class),

    		   GameScreen.assetManager2.get(("DreadLord/XXGH.png"),Texture.class),

    		   null,			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),
"吸血光环",reverse,0);
       button4=new CusButton(644-17,612,			    		   GameScreen.assetManager2.get(("DreadLord/14-white.png"),Texture.class),

    		   GameScreen.assetManager2.get(("DreadLord/14.png"),Texture.class),

    		   GameScreen.assetManager2.get(("DreadLord/14.png"),Texture.class),

    		   GameScreen.assetManager2.get(("DreadLord/14-black.png"),Texture.class),

    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),
"地狱火",reverse,8); 
			       }
		       
		       button1.round=6;
		       button2.round=6;
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
			    			  if(magic>=100&!abcool2){ 
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
			    			  if(magic>=150&&!abcool4){  
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
         this.addActor(sh);
         this.addActor(si);
            this.addActor(light);
           this.addActor(sg);
           this.addActor(ring);
           this.addActor(scar);
   
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
	
	
	 //死亡虚空（九宫格+i*50，冷却6,耗魔80）
	@Override
	public boolean ability1() {
		 button1.ct.update(cooltime1);
		   button1.cool();
	
			    a=FruitGroup.fruits[x][y].getX();
			    b=FruitGroup.fruits[x][y].getY();
		if(this.magic>=80&&!abcool1){
			si.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					si.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			si.addAction(sa2);
		
			ani1=new Animation(0.1F,ta1.getRegions(),PlayMode.NORMAL);
	    	DelayAction delay1=Actions.delay(stage.fg.delay1);
        RunnableAction run1=Actions.run(new Runnable(){
            
			@Override
			public void run() {
				// TODO Auto-generated method stub
				FruitGroup.fruits[x][y].Ability1(ani1,200,200,a,b);
				vain.play(1.0F);
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
			button1.isClicked=false;
			return false;
		}	
		
	}

	//伤残恐惧（诅咒对方，闪避i回合，6，100）  
	@Override
	public boolean ability2() {
		  
		if(this.magic>=100&&!abcool2){
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
	            
	            RunnableAction run2=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						scar.reset();
					}
	            	
	            });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
	        RunnableAction run1=Actions.run(new Runnable(){
	            
				@Override
				public void run() {
					// TODO Auto-generated method stub
			        scar.draw=true;
	                 scary.play(1.0F);
				}
	        	
	        });
		  
				   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
				
	    
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 boolean temp=stage.hero1t;
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					magic-=100;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
		            state.add(Hero.State.dodge);
		            cdodge+=3;
		            if(temp){
		            	stage.hero2.state.add(Hero.State.curse);
		            	stage.hero2.ccurse+=1;
		            }else{
		            	stage.hero1.state.add(Hero.State.curse);
		            	stage.hero1.ccurse+=1;
		            }
				}
				 
			 });
			this.addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		button2.isClicked=false;
		return false;
	}
	//吸血光环（吸血攻击10%*i，固有）//攻击阶段  
	@Override
	public boolean ability3() {
		 RunnableAction run = new RunnableAction();
		 DelayAction delay=Actions.delay(stage.fg.delay1);
		 SequenceAction sequenceAction=Actions.sequence(delay,run);
		 blood+=stage.fg.hurt*0.1;
		 run.setRunnable(new Runnable(){
			@Override
			public void run() {
			   
			    bg.cb.blood=blood;
				bg.blo.setText((int)blood+"/"+(int)maxBlood);
			}
			 
		 });
		 this.addAction(sequenceAction);
		return false;
	}
	//地狱火（烧灼每回合5%总血量，自己愤怒i*10%，暴击2倍10% 共持续2回合，8，150）
	@Override
	public boolean ability4() {
		button4.ct.update(cooltime4);
		   button4.cool();	   

		    a=0;
		    b=0;
		    
		if(this.magic>=150&&!abcool4){
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
					Skill4.setPosition(-1000, 350);
				}
				
			});
			SequenceAction sa=Actions.sequence(delay5,mba1,rab,da2, mba2,ra);
			Skill4.addAction(sa); 
				
			stage.fg.delay1+=2;
		 }
			 ani1=new Animation(0.05F,ta3.getRegions(),PlayMode.NORMAL);
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
         RunnableAction run1=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					
				    if(!reverse)
					FruitGroup.fruits[5][1].Ability1(ani1,700,0,a,b);
				    else
				   FruitGroup.fruits[5][1].Ability1(ani1,-700,0,a,b);
					System.out.println(FruitGroup.fruits[5][1].getX()+" "+FruitGroup.fruits[5][1].getY());
					
					fire.play(1.0F);
					stage.viberation();
				}
         	
         });
		    SequenceAction sa1=Actions.sequence(delay1, run1);
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 boolean temp=stage.hero1t;
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					magic-=150;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
		            state.add(Hero.State.crit);
		            ccrit+=3;
		            state.add(Hero.State.angry);
		            cangry+=3;
		            blood*=0.95;
		            bg.cb.blood=blood;
					bg.blo.setText((int)blood+"/"+(int)maxBlood);
		            
				}
				 
			 });
			 FruitGroup.fruits[5][1].addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		return false;
	}

	@Override
	public boolean AI() {
		int k=ran.nextInt(3);
		
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
    
}
