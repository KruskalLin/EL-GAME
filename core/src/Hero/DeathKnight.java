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
public class DeathKnight extends Hero {
	private TextureAtlas ta1;
	private TextureAtlas ta2;
	private TextureAtlas ta3;
	private Animation ani1;
    private Sound dongjie;
	private Sound backlight;
	private Sound shield;
    private Random ran;
    private Date date;
    private Image Skill4;
    private Bloodplus bp;
    private Sound Heal;
    private SmallThing st;
    private SmallThing st1;
    private SmallThing st2;
    private siwangchanrao siwangchanrao;
    private wuguangzhidu wuguangzhidun;
    private huiguang huiguang;
  //死亡骑士： 
 //死亡缠绕（补现有血30%*i，6，80）  
// 无光之盾（i回合免疫伤害并反弹，7，80） 
 //霜之哀伤（有i*5几率使对方冰冻3回合，6回合诅咒，固有）//任意阶段 
 //回光（下2*i回合受到的伤害转为血，10，150）
//终极大招：邪恶凝视（立即消除对方所有增益状态，并使对方沉默6回合，自己攻击力增加100%，每次附加攻击对方剩余血量10%，持续6回合）

//力量：31 +2.7	攻击力：75 
//敏捷：25 + 1.5	攻速：初始血量612 初始魔法273
//智力：21 + 2.0	护甲：4.0
	public DeathKnight(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       bp=new Bloodplus(reverse);
	       Heal=   GameScreen.assetManager2.get(("BladeMaster/Heal.wav"),Sound.class);
	       Skill4=new Image( GameScreen.assetManager2.get(("DeathKnight/huiguang.png"),Texture.class));
	      money=100;
	      xp=400;
	       
	      wuguangzhidun=new wuguangzhidu(reverse);
	      siwangchanrao=new siwangchanrao(reverse);
	      huiguang =new huiguang(reverse);
	       date=new Date();
	       ran=new Random(date.getTime());
	       if(!reverse)
		       Skill4.setPosition(-1000, 350);
	         else
	        	 Skill4.setPosition(700+4008, 350);
	       Skill4.setScale(2.0F);
	       Yes1=  GameScreen.assetManager2.get(("DeathKnight/DeathKnightYes1.wav"),Sound.class);
	       Yes2=   GameScreen.assetManager2.get(("DeathKnight/DeathKnightYes2.wav"),Sound.class);
	       Yes3=   GameScreen.assetManager2.get(("DeathKnight/DeathKnightYes3.wav"),Sound.class);
	       Yes4=   GameScreen.assetManager2.get(("DeathKnight/DeathKnightYes4.wav"),Sound.class);
	       attack1=   GameScreen.assetManager2.get(("DeathKnight/DeathKnightYesAttack1.wav"),Sound.class);
	       attack2=   GameScreen.assetManager2.get(("DeathKnight/DeathKnightYesAttack2.wav"),Sound.class);
	       attack3=   GameScreen.assetManager2.get(("DeathKnight/DeathKnightYesAttack3.wav"),Sound.class);
	       ta1=GameScreen.assetManager2.get(("DeathKnight/sh.pack"),TextureAtlas.class);
	       ta2=GameScreen.assetManager2.get(("DeathKnight/ice.pack"),TextureAtlas.class);
	       ta3=GameScreen.assetManager2.get(("DeathKnight/shield.pack"),TextureAtlas.class);
	       Animation ani=new Animation(0.2F,ta2.getRegions(),PlayMode.LOOP);
	       if(!reverse)
	       st=new SmallThing(300,600,ani);
	       else 
	    	   st=new SmallThing(-100,600,ani);
	       st.draw=true;
	       Animation ani2=new Animation(0.05F,ta3.getRegions(),PlayMode.NORMAL);
	   	   Animation ani3=new Animation(0.1F,ta1.getRegions(),PlayMode.NORMAL);
	   	  if(!reverse)
		       st2=new SmallThing(200,300,ani3);
		       else 
		    	   st2=new SmallThing(0,300,ani3);
	       if(!reverse)
		       st1=new SmallThing(100,300,ani2);
		       else 
		    	   st1=new SmallThing(0,300,ani2);
	       war=   GameScreen.assetManager2.get(("DeathKnight/DeathKnightWarcry1.wav"),Sound.class);
	       shield=  GameScreen.assetManager2.get(("DeathKnight/DarkSummoningLaunch1.wav"),Sound.class);
	       backlight=  GameScreen.assetManager2.get(("DeathKnight/ResurrectTarget.wav"),Sound.class);
	       dongjie=  GameScreen.assetManager2.get(("DeathKnight/FreezingBreathTarget1.wav"),Sound.class);
	       cooltime1=6;
	       cooltime2=7;
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
	       maxBlood=1224;
	       maxMagic=273;
	       blood=1224;
	       magic=273;	       
	       force=31;
	       attack=75;
	       quick=25;
	       intelligence=21;
	       defence=4;
	       dforce=(float)2.7;
	       dquick=(float)1.5;
	       dintellience=(float)2.0;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image( GameScreen.assetManager2.get(("DeathKnight/DK.png"),Texture.class));
		       else
		    	   image=new Image( GameScreen.assetManager2.get(("DeathKnight/DK_re.png"),Texture.class));
	       image.setScale(0.5F);
		       if(!reverse)
		       image.setPosition(-20,350);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504+900,350);		       
		       if(!reverse){
			       button1=new CusButton(17,884, GameScreen.assetManager2.get(("DeathKnight/swcr_white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/swcr.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/swcr.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/swcr_black.png"),Texture.class), 
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"死亡缠绕",reverse,6);
			       button2=new CusButton(17,793, GameScreen.assetManager2.get(("DeathKnight/Wgzd_white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/Wgzd.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/Wgzd.png"),Texture.class), 
			    		   GameScreen.assetManager2.get(("DeathKnight/Wgzd_black.png"),Texture.class), 
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"无光之盾",reverse,8);
			       button3=new CusButton(17,702, GameScreen.assetManager2.get(("DeathKnight/szas.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/szas.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/szas.png"),Texture.class),
			    		   null, GameScreen.assetManager2.get(("textground.png"),Texture.class),"霜之哀伤",reverse,0);
			       button4=new CusButton(17,612, GameScreen.assetManager2.get(("DeathKnight/hgfz_white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/hgfz.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/hgfz.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("DeathKnight/hgfz_black.png"),Texture.class), 
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"回光",reverse,10);
			       }else{
			    	   button1=new CusButton(704-17-60,884, GameScreen.assetManager2.get(("DeathKnight/swcr_white.png"),Texture.class),
			    			   GameScreen.assetManager2.get(("DeathKnight/swcr.png"),Texture.class),
			    			   GameScreen.assetManager2.get(("DeathKnight/swcr.png"),Texture.class),
			    			   GameScreen.assetManager2.get(("DeathKnight/swcr_black.png"),Texture.class),
			    			   GameScreen.assetManager2.get(("textground.png"),Texture.class),"死亡缠绕",reverse,6);
				       button2=new CusButton(704-77,793, GameScreen.assetManager2.get(("DeathKnight/Wgzd_white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DeathKnight/Wgzd.png"),Texture.class), 
				    		   GameScreen.assetManager2.get(("DeathKnight/Wgzd.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DeathKnight/Wgzd_black.png"),Texture.class), 
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"无光之盾",reverse,8);
				       button3=new CusButton(704-17-60,702, GameScreen.assetManager2.get(("DeathKnight/szas.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DeathKnight/szas.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DeathKnight/szas.png"),Texture.class),
				    		   null, GameScreen.assetManager2.get(("textground.png"),Texture.class),"霜之哀伤",reverse,0);
				       button4=new CusButton(704-17-60,612, GameScreen.assetManager2.get(("DeathKnight/hgfz_white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DeathKnight/hgfz.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DeathKnight/hgfz.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("DeathKnight/hgfz_black.png"),Texture.class), 
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"回光",reverse,10);
				      
			       }
		       button1.round=6;
		       button2.round=8;
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
			    			  if(magic>=80&&!abcool1){ 
				    			   button1.isClicked=true;
				    		  button2.isClicked=false;
				    		  button4.isClicked=false;
				    	  }}
			    	  }
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
				    	  }
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
			    			  if(magic>=80&&!abcool2){ 
				    			   button1.isClicked=false;
				    		  button2.isClicked=false;
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
			      });      this.addActor(image);
			      Skill4.setScale(1.5F);
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
           this.addActor(siwangchanrao);
           this.addActor(wuguangzhidun);
           this.addActor(huiguang);
           this.addActor(st);
           this.addActor(st1);
           this.addActor(st2);
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
	//死亡缠绕（补现有血30%*i，6，80）
	@Override
	public boolean ability1() {
		
		 button1.ct.update(cooltime1);
		   button1.cool();
		
		
		
		if(this.magic>=80&&!abcool1){
			siwangchanrao.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run2=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					siwangchanrao.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run2);
			siwangchanrao.addAction(sa2);
			
			int c=ran.nextInt(3);
			if(c==0)
			attack1.play(stage.volume);
			else if(c==1)
		    attack2.play(stage.volume);
			else
			attack3.play(stage.volume);
			
					
	
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
					magic-=80;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
					float temp=blood;
					blood*=1.3;
					if(blood>=maxBlood){
						blood=maxBlood;
					}
					temp=blood-temp;
					bp.reveal(temp);
					Heal.play(stage.volume);
					bg.cb.blood=blood;
					bg.blo.setText((int)blood+"/"+(int)maxBlood);
				}
				 
			 });
		     this.addAction(sequenceAction);
		     return true;
		}
		button1.isClicked=false;
		return false;
	}
    
	//无光之盾（i回合免疫伤害并反弹，7，80）
	@Override
	public boolean ability2() {
		button2.ct.update(cooltime2);
		   button2.cool();
		 
		if(this.magic>=80&&!abcool2){
			wuguangzhidun.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					wuguangzhidun.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			wuguangzhidun.addAction(sa2);
			
			int c=ran.nextInt(3);
			if(c==0)
			attack1.play(stage.volume);
			else if(c==1)
		    attack2.play(stage.volume);
			else
			attack3.play(stage.volume);
		
            
            DelayAction delay2=Actions.delay(stage.volume);
            
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
                 shield.play(stage.volume);
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
		            state.add(Hero.State.reflect);
		            creflect+=1;
				}
				 
			 });
			 this.addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		button2.isClicked=false;
		return false;
	}
	//霜之哀伤（有i*5几率使对方冰冻3回合，6回合诅咒，固有）//任意阶段 
	@Override
	public boolean ability3() {
		int k=ran.nextInt(10);
		if(k==1){
			
			
			dongjie.play(stage.volume);
			if(stage.hero1t){
				
				
				
				stage.hero2.state.add(Hero.State.dizzy);
				stage.hero2.cdizzy+=3;
				
				stage.hero2.state.add(Hero.State.curse);
				stage.hero2.ccurse+=6;
			}else{
				stage.hero1.state.add(Hero.State.dizzy);
				stage.hero1.cdizzy+=3;
				
				stage.hero1.state.add(Hero.State.curse);
				stage.hero1.ccurse+=6;
			}
		}
		return false;
	}
	//回光（下2*i回合受到的伤害转为血，10，150）
	@Override
	public boolean ability4() {
		
		button4.ct.update(cooltime4);
		   button4.cool();	 
		if(this.magic>=150&&!abcool4){
			huiguang.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					huiguang.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			huiguang.addAction(sa2);
			 if(stage.hero1t){
				 DelayAction delay5=Actions.delay(stage.fg.delay1);
			blackground.setVisible(true);  
			
			DelayAction da2=Actions.delay(0.8F);
			MoveByAction mba1=Actions.moveBy(1650, 0,0.2F,Interpolation.sineIn);
			MoveByAction mba2=Actions.moveBy(1550, 0,0.2F,Interpolation.sineIn);
			RunnableAction rab=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					war.play(stage.volume);
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
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
            RunnableAction run1=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					st1.draw=true;
					backlight.play(stage.volume);
				}
            	
            });
            
            DelayAction delay2=Actions.delay(stage.volume);
            
            RunnableAction run2=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					st1.reset();
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
		            state.add(Hero.State.suck);
		            csuck+=1;
				}
			 });
			 this.addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		button4.isClicked=false;
		return false;
	}

	@Override
	public boolean AI() {
		if(blood<=200){
			if(!abcool1)
			if(ability1()){
				abcool1=true;
				return true;
			}else{
				return false;
			}
		}else{
			int k=ran.nextInt(2);
			if(k==0){
				if(!abcool2)
				if(ability2()){
					abcool2=true;
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
			
			
		}
		return false;
	}
}
