package Hero;

import java.util.Date;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
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
import stage.GameStage;
import label.*;
public class FireLord extends Hero {
	//火焰领主： 火压（九宫格+i*50，冷却6,耗魔80） 
	 //炎之愤怒（愤怒i*15%，8，80） 
	  //祭祀（固有，烧灼对方总血量1*i/40）  
	 //无间炼狱（消除两个九宫格，烧灼效果翻倍，持续i回合，鼠标点击为下面那个九宫格，冷却10,耗魔200）
	//力量：26(+3.2)	攻击力：53 
	//敏捷 11(+0.9)	初始血量：601  初始魔法169
	//智力：13(+2.1)	护甲：0.54
	
	private TextureAtlas ta1;
	private TextureAtlas ta2;
	private TextureAtlas ta3;
	private Animation ani1;
	private float a,b;
	private Sound firepush;
	private Sound angry;
	private Sound wjly;
    private Random ran;
    private Date date;
    private Image Skill4;
    private huoya huoya;
    private yanzhifennu yanzhifennu;
    private wujianlianyu wujianlianyu;
	public FireLord(GameStage stage,boolean reverse){
	       super(stage,reverse);
	     
	       money=200;
	       xp=600;
	       huoya=new huoya(reverse);
	       yanzhifennu=new yanzhifennu(reverse);
	       wujianlianyu=new wujianlianyu(reverse);
	       Skill4=new Image(GameScreen.assetManager2.get(("FireLord/firelord.png"),Texture.class));
	       pm1=new Pixmap(Gdx.files.internal("hand.png"));
	       pm2 = new Pixmap(Gdx.files.internal("sphere.png")); 
	       date=new Date();
	       ran=new Random(date.getTime());
	       if(!reverse)
		       Skill4.setPosition(-1000, 350);
	         else
	        	 Skill4.setPosition(700+4008, 350);
	       Yes1= GameScreen.assetManager2.get(("FireLord/NerubianCryptLordYes1.wav"),Sound.class);
	       Yes2= GameScreen.assetManager2.get(("FireLord/NerubianCryptLordYes2.wav"),Sound.class);
	       Yes3= GameScreen.assetManager2.get(("FireLord/NerubianCryptLordYes3.wav"),Sound.class);
	       Yes4= GameScreen.assetManager2.get(("FireLord/NerubianCryptLordYes5.wav"),Sound.class);
	       attack1= GameScreen.assetManager2.get(("FireLord/NerubianCryptLordYesAttack1.wav"),Sound.class);
	       attack2= GameScreen.assetManager2.get(("FireLord/NerubianCryptLordYesAttack2.wav"),Sound.class);
	       attack3= GameScreen.assetManager2.get(("FireLord/NerubianCryptLordYesAttack3.wav"),Sound.class);
	       war=GameScreen.assetManager2.get(("FireLord/NerubianCryptLordWarcry1.wav"),Sound.class);
	       angry=GameScreen.assetManager2.get(("FireLord/BloodlustTarget.wav"),Sound.class);
	       firepush=GameScreen.assetManager2.get(("FireLord/Shockwave.wav"),Sound.class);
	       wjly=GameScreen.assetManager2.get(("FireLord/BlizzardLoop1.wav"),Sound.class);
	       ta2=GameScreen.assetManager2.get(("FireLord/wjly_skill.pack"),TextureAtlas.class);
	       ta1=GameScreen.assetManager2.get(("FireLord/firepush.pack"),TextureAtlas.class);
	       ta3=GameScreen.assetManager2.get(("FireLord/angry.pack"),TextureAtlas.class);
	       cooltime1=6;
	       cooltime2=8;
	       cooltime3=0;
	       cooltime4=10;
	       continue1=0;
	       continue2=0;
	       continue3=0;
	       continue4=0;
	       abilityk1=1;
	       abilityk2=2;
	       abilityk3=6;   //
	       abilityk4=2;
	       maxBlood=1202;
	       maxMagic=300;
	       blood=1202;
	       magic=300;	       
	       force=26;
	       attack=53;
	       quick=11;
	       intelligence=13;
	       defence=(float)0.54;
	       dforce=(float)3.2;
	       dquick=(float)0.9;
	       dintellience=(float)2.1;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image(GameScreen.assetManager2.get(("FireLord/huoyanlingzhu.png"),Texture.class));
		       else
		    	   image=new Image(GameScreen.assetManager2.get(("FireLord/huoyanlingzhu_re.png"),Texture.class));
		       if(!reverse)
		       image.setPosition(-70,350);
		       else
		       image.setPosition(2408-image.getWidth()-120-1504,350);		       
		       if(!reverse){
			       button1=new CusButton(17,884,GameScreen.assetManager2.get(("FireLord/fire_white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("FireLord/fire.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("FireLord/fire.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("FireLord/fire_black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class)," 火压",reverse,6);
			       button2=new CusButton(17,793, GameScreen.assetManager2.get(("FireLord/angry_white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("FireLord/angry_.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("FireLord/angry_.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("FireLord/angry_black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"炎之愤怒a",reverse,8);
			       button3=new CusButton(17,702,			    		   GameScreen.assetManager2.get(("FireLord/burned.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("FireLord/burned.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("FireLord/burned.png"),Texture.class),

			    		   null,			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),
"祭祀",reverse,0);
			       button4=new CusButton(17,612,			    		   GameScreen.assetManager2.get(("FireLord/wjly_white.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("FireLord/wjly.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("FireLord/wjly.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("FireLord/wjly_black.png"),Texture.class),

			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),
"无间炼狱",reverse,10);
			       }else{
			    	      button1=new CusButton(644-17,884,GameScreen.assetManager2.get(("FireLord/fire_white.png"),Texture.class),
					    		   GameScreen.assetManager2.get(("FireLord/fire.png"),Texture.class),
					    		   GameScreen.assetManager2.get(("FireLord/fire.png"),Texture.class),
					    		   GameScreen.assetManager2.get(("FireLord/fire_black.png"),Texture.class),
					    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"火压",reverse,6);
					       button2=new CusButton(644-17,793, GameScreen.assetManager2.get(("FireLord/angry_white.png"),Texture.class),
					    		   GameScreen.assetManager2.get(("FireLord/angry_.png"),Texture.class),
					    		   GameScreen.assetManager2.get(("FireLord/angry_.png"),Texture.class),
					    		   GameScreen.assetManager2.get(("FireLord/angry_black.png"),Texture.class),
					    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"炎之愤怒a",reverse,8);
					       button3=new CusButton(644-17,702,			    		   GameScreen.assetManager2.get(("FireLord/burned.png"),Texture.class),

					    		   GameScreen.assetManager2.get(("FireLord/burned.png"),Texture.class),

					    		   GameScreen.assetManager2.get(("FireLord/burned.png"),Texture.class),

					    		   null,			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),
		"祭祀",reverse,0);
					       button4=new CusButton(644-17,612,			    		   GameScreen.assetManager2.get(("FireLord/wjly_white.png"),Texture.class),

					    		   GameScreen.assetManager2.get(("FireLord/wjly.png"),Texture.class),

					    		   GameScreen.assetManager2.get(("FireLord/wjly.png"),Texture.class),

					    		   GameScreen.assetManager2.get(("FireLord/wjly_black.png"),Texture.class),

					    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),
		"无间炼狱",reverse,10);
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
			      Skill4.setScale(1.5F);
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
                 this.addActor(wujianlianyu);
                 
                 this.addActor(huoya);
                 this.addActor(yanzhifennu);
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
	//火焰领主： 火压（九宫格+i*50，冷却6,耗魔80） 
	@Override
	public boolean ability1() {
		 button1.ct.update(cooltime1);
		   button1.cool();
	
			    a=FruitGroup.fruits[x][y].getX();
			    b=FruitGroup.fruits[x][y].getY();
	    
			 
			    
		 if(this.magic>=80&&!abcool1){	
			
				huoya.move(stage.fg.delay1);
				DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
		        RunnableAction run3=Actions.run(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						huoya.reset();
					}
		        	
		        });
			    SequenceAction sa2=Actions.sequence(delay3, run3);
				huoya.addAction(sa2);
			    	ani1=new Animation(0.1F,ta1.getRegions(),PlayMode.NORMAL);
			    	DelayAction delay1=Actions.delay(stage.fg.delay1);
	            RunnableAction run1=Actions.run(new Runnable(){
                    
					@Override
					public void run() {
						// TODO Auto-generated method stub
						FruitGroup.fruits[x][y].Ability1(ani1,296,264,a,b);
						int c=ran.nextInt(3);
						if(c==0)
						attack1.play(1.0F);
						else if(c==1)
					    attack2.play(1.0F);
						else
						attack3.play(1.0F);
						firepush.play(0.5F);
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
				 stage.fg.hurt+=50;
				 /*
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
				*/
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

	 //炎之愤怒（愤怒i*15%，8，80） 
	@Override
	public boolean ability2() {
		button2.ct.update(cooltime2);
		   button2.cool();

		    a=FruitGroup.fruits[0][5].getX();
		    b=FruitGroup.fruits[0][5].getY();
		if(this.magic>=80&&!abcool2){
			yanzhifennu.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
				   yanzhifennu.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			yanzhifennu.addAction(sa2);
	    	ani1=new Animation(0.1F,ta3.getRegions(),PlayMode.NORMAL);
	    	DelayAction delay1=Actions.delay(stage.fg.delay1);
        RunnableAction run1=Actions.run(new Runnable(){
            
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(!reverse)
				FruitGroup.fruits[0][5].Ability1(ani1,600,600,a,b);
				else 
					FruitGroup.fruits[0][5].Ability1(ani1,-1000,600,a,b);
				angry.play(1.0F);
			}
        	
        });
	    SequenceAction sa1=Actions.sequence(delay1, run1);
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					magic-=80;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
		            state.add(Hero.State.angry);
		            cangry+=3;
				}
				 
			 });
			 FruitGroup.fruits[0][5].addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
		button2.isClicked=false;
		return false;
	}
    
	 //祭祀（固有，烧灼对方总血量1*i/40）  
	@Override
	public boolean ability3() {
		 
	     RunnableAction run = new RunnableAction();
		 DelayAction delay=Actions.delay(stage.fg.delay1);
		 SequenceAction sequenceAction=Actions.sequence(delay,run);
	
		
		 boolean temp=stage.hero1t;	
		 if(!temp&&!stage.hero2.state.contains(State.burned)) 
          stage.hero2.state.add(State.burned);
          else if(temp&&stage.hero2.state.contains(State.burned))
        stage.hero1.state.add(State.burned);
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
	 //无间炼狱（消除低3行，，冷却10,耗魔200）
	@Override
	public boolean ability4() {
		button4.ct.update(cooltime4);
		   button4.cool();	   
		  
			    a=0;
			    b=0;
			 if(this.magic>=200&&!abcool4){	
				 
					wujianlianyu.move(stage.fg.delay1);
					DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
			        RunnableAction run3=Actions.run(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
							wujianlianyu.reset();
						}
			        	
			        });
				    SequenceAction sa2=Actions.sequence(delay3, run3);
				wujianlianyu.addAction(sa2);
				 
				 
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
				    	ani1=new Animation(0.05F,ta2.getRegions(),PlayMode.NORMAL);
				    	DelayAction delay1=Actions.delay(stage.fg.delay1);
		            RunnableAction run1=Actions.run(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							FruitGroup.fruits[5][1].Ability1(ani1,0,0,a,b);
							System.out.println(FruitGroup.fruits[5][1].getX()+" "+FruitGroup.fruits[5][1].getY());
							wjly.play(1.0F);
							stage.viberation();
						}
		            	
		            });
				    SequenceAction sa1=Actions.sequence(delay1, run1);
			 RunnableAction run = new RunnableAction();
			 DelayAction delay=Actions.delay(stage.fg.delay1);
			 SequenceAction sequenceAction=Actions.sequence(delay,run);
			    try{
					for(int i=0;i<FruitGroup.COL;i++){
						for(int j=0;j<3;j++){
						FruitGroup.bombFruit2.add(FruitGroup.fruits[i][j]);
						}
					}
				}catch(ArrayIndexOutOfBoundsException e){
				}
			    while(stage.fg.vanish()){
			    	stage.fg.descend();
			    }
			    if(stage.hero1t){
			    	stage.fg.hcount1+=24;
			    }else{
			    	stage.fg.hcount2+=24;
			    }
			 run.setRunnable(new Runnable(){
				@Override
				public void run() {
					magic-=200;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
				}
			 });	
			 FruitGroup.fruits[5][1].addAction(sa1);
		     this.addAction(sequenceAction);
		     return true;
		}
			 button4.isClicked=false;
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
