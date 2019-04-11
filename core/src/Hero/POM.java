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
public class POM extends Hero{
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
    private Sound star;
    private Sound wind;
    private Sound arr;
    private Sound moon;
    private SmallThing hori;
    private SmallThing vert;
    private SmallThing windwalk;
    private SmallThing moonn;
	private shenjian shen;
	private yuezhizhufu yue;
	private yinshen yin;
	private qunxingzhuiluo qun;
	
	
	
	//月之女祭司：  群星坠落（九宫格+i*50，冷却6,耗魔80）  
	 //隐身（60%闪避i回合，7，80）  
	 //神箭（消除一行一列，9-i，80）
	  //月之祝福（进入暴击2倍伤害（10%）愤怒（增益20%）状态i+1回合，9，150）
	//力量：17 + 1.9	攻击力：49
	//敏捷：20 + 2.8	初始血量：473  初始魔法：221
	//智力：17 + 1.7	护甲：1.9
	public POM(GameStage stage,boolean reverse){
	       super(stage,reverse);
	       shen=new shenjian(reverse);
	       yue=new yuezhizhufu(reverse);
	       yin=new yinshen(reverse);
	       qun=new qunxingzhuiluo(reverse);
	       money=300;
	       xp=500;
	       Pixmap pm3=new Pixmap(Gdx.files.internal("POM/curso.png"));
	       
	       pm1=new Pixmap(Gdx.files.internal("hand.png"));
	       pm2 = new Pixmap(Gdx.files.internal("sphere.png")); 
	       date=new Date();
	       ran=new Random(date.getTime());
	       Yes1= GameScreen.assetManager2.get(("POM/HeroMoonPriestessYes1.wav"),Sound.class);
	       Yes2= GameScreen.assetManager2.get(("POM/HeroMoonPriestessYes2.wav"),Sound.class);
	       Yes3= GameScreen.assetManager2.get(("POM/HeroMoonPriestessYes3.wav"),Sound.class);
	       Yes4= GameScreen.assetManager2.get(("POM/HeroMoonPriestessYes4.wav"),Sound.class);
	       attack1= GameScreen.assetManager2.get(("POM/HeroMoonPriestessYesAttack1.wav"),Sound.class);
	       attack2= GameScreen.assetManager2.get(("POM/HeroMoonPriestessYesAttack2.wav"),Sound.class);
	       attack3= GameScreen.assetManager2.get(("POM/HeroMoonPriestessYesAttack3.wav"),Sound.class);
	       wind= GameScreen.assetManager2.get(("POM/WindWalk.wav"),Sound.class);
	       star=GameScreen.assetManager2.get(("POM/StarfallCaster1.wav"),Sound.class);
	       arr=GameScreen.assetManager2.get(("POM/CorrosiveBreathMissileLaunch1.wav"),Sound.class);
	       moon= GameScreen.assetManager2.get(("POM/ReviveNightElf.wav"),Sound.class);
	       ta1=GameScreen.assetManager2.get(("POM/star.pack"),TextureAtlas.class);
	       ta2=GameScreen.assetManager2.get(("POM/moon.pack"),TextureAtlas.class);
	       ta3=GameScreen.assetManager2.get(("POM/invisible.pack"),TextureAtlas.class);
	       ta4=GameScreen.assetManager2.get(("POM/hori.pack"),TextureAtlas.class);
	       ta5=GameScreen.assetManager2.get(("POM/vert.pack"),TextureAtlas.class);
	       
		   Animation anih=new Animation(0.05F,ta4.getRegions(),PlayMode.NORMAL);  
		   Animation aniv=new Animation(0.05F,ta5.getRegions(),PlayMode.NORMAL);   
	       Animation ani2=new Animation(0.05F,ta2.getRegions(),PlayMode.NORMAL);
	   	   Animation ani3=new Animation(0.1F,ta3.getRegions(),PlayMode.NORMAL);
	   	   if(!reverse)
	       moonn=new SmallThing(250,300,ani2);
	       else 
	    	   moonn=new SmallThing(0,300,ani2);
	   	   
	   
	       if(!reverse)
		       windwalk=new SmallThing(250,300,ani3);
		       else 
		    	   windwalk=new SmallThing(100,300,ani3);
	       
	       hori=new SmallThing(0,0,anih);
	       vert=new SmallThing(0,0,aniv);
	       windwalk.a*=2.5;
	       windwalk.b*=2.5;
	       moonn.a*=3;
	       moonn.b*=3;
	       
	       
	       
	       
	       
	       
	       cooltime1=6;
	       cooltime2=7;
	       cooltime3=9;
	       cooltime4=9;
	       continue1=0;
	       continue2=0;
	       continue3=0;
	       continue4=0;
	       abilityk1=1;
	       abilityk2=2;
	       abilityk3=1;
	       abilityk4=2;
	       maxBlood=960;
	       maxMagic=221;
	       blood=960;
	       magic=221;	       
	       force=17;
	       attack=49;
	       quick=20;
	       intelligence=17;
	       defence=(float)1.9;
	       dforce=(float)1.9;
	       dquick=(float)2.8;
	       dintellience=(float)1.7;
	       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
	       if(!reverse)
		       image=new Image( GameScreen.assetManager2.get(("POM/POM.png"),Texture.class));
		       else
		    	   image=new Image( GameScreen.assetManager2.get(("POM/POM_re.png"),Texture.class));
		       if(!reverse)
		       image.setPosition(220,300);
		       else
		       image.setPosition(2208-image.getWidth()-120-1504-100,300);		       
		       if(!reverse){
		    	   button1=new CusButton(17,884,GameScreen.assetManager2.get(("POM/8-white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/8.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/8.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/8-black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"群星坠落",reverse,6);
			       button2=new CusButton(17,793,GameScreen.assetManager2.get(("POM/6-white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/6.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/6.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/6-black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"隐身",reverse,7);
			       button3=new CusButton(17,702,GameScreen.assetManager2.get(("POM/7-white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/7.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/7.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/7-black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"神箭",reverse,9);
			       button4=new CusButton(17,612,GameScreen.assetManager2.get(("POM/3-white.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/3.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/3.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("POM/3-black.png"),Texture.class),
			    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"月之祝福",reverse,9);      }else{
			    			   button1=new CusButton(644-17,884,GameScreen.assetManager2.get(("POM/8-white.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/8.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/8.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/8-black.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"群星坠落",reverse,6);
						       button2=new CusButton(644-17,793,GameScreen.assetManager2.get(("POM/6-white.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/6.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/6.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/6-black.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"隐身",reverse,7);
						       button3=new CusButton(644-17,702,GameScreen.assetManager2.get(("POM/7-white.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/7.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/7.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/7-black.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"神箭",reverse,9);
						       button4=new CusButton(64417,612,GameScreen.assetManager2.get(("POM/3-white.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/3.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/3.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("POM/3-black.png"),Texture.class),
						    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"月之祝福",reverse,9);     
						    
			       }
		       
		       
		       button1.round=6;
		       button2.round=7;
		       button3.round=9;
		       button4.round=9;
		       
		       
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
				    		  Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm3,0,0));
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
	         this.addActor(windwalk);
	         this.addActor(moonn);
	       this.addActor(qun);
	       this.addActor(shen);
	       this.addActor(yue);
	       this.addActor(yin);
	            this.addActor(light);
	           this.addActor(sg);
	         
	   
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
	//月之女祭司：  群星坠落（九宫格+i*50，冷却6,耗魔80）
	@Override
	public boolean ability1() {
		 button1.ct.update(cooltime1);
		   button1.cool();
	
			    a=FruitGroup.fruits[x][y].getX();
			    b=FruitGroup.fruits[x][y].getY();
		 if(this.magic>=80&&!abcool1){
				qun.move(stage.fg.delay1);
				DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
		        RunnableAction run3=Actions.run(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						qun.reset();
					}
		        	
		        });
			    SequenceAction sa2=Actions.sequence(delay3, run3);
				qun.addAction(sa2);
			 int c=ran.nextInt(3);
				if(c==0)
				attack1.play(stage.volume);
				else if(c==1)
			    attack2.play(stage.volume);
				else
				attack3.play(stage.volume);
			 ani1=new Animation(0.05F,ta1.getRegions(),PlayMode.NORMAL);
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
	        RunnableAction run1=Actions.run(new Runnable(){
	            
				@Override
				public void run() {
					// TODO Auto-generated method stub
					FruitGroup.fruits[x][y].Ability1(ani1,200,200,a,b);
					star.play(1.0F);
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
			}
	}

	//隐身（100%闪避i回合，7，80）  
	@Override
	public boolean ability2() {
		button2.ct.update(cooltime2);
		   button2.cool();
		if(this.magic>=80&&!abcool2){
			yin.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					yin.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			yin.addAction(sa2);
			 DelayAction delay2=Actions.delay(1.0F);
		        
		        RunnableAction run2=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
					  windwalk.reset();
					}
		        	
		        });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
		    RunnableAction run1=Actions.run(new Runnable(){
		        
				@Override
				public void run() {
					// TODO Auto-generated method stub
			        windwalk.draw=true;
			        wind.play(1.0F);
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
					magic-=80;
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
    
	//神箭（消除一行一列，9-i，80）
	@Override
	public boolean ability3() {
		button3.ct.update(cooltime3);
		   button3.cool();
		   
		   a=FruitGroup.fruits[x][y].getX();
		    b=FruitGroup.fruits[x][y].getY();
		   
		   
		    stage.fg.addActor(hori);
	         stage.fg.addActor(vert);
		   
		   
		   
		 if(this.magic>=80&&!abcool3){
			
			    shen.move(stage.fg.delay1);
				DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
		        RunnableAction run3=Actions.run(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						shen.reset();
					}
		        	
		        });
			    SequenceAction sa2=Actions.sequence(delay3, run3);
				shen.addAction(sa2);
			 DelayAction delay2=Actions.delay(1.0F);
		        
		        RunnableAction run2=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
					  hori.reset();
					  vert.reset();
					  vert.setPosition(a, 1000);
					  hori.setPosition(-30, b);
					  arr.play(stage.volume);
					  int c=ran.nextInt(3);
						if(c==0)
						attack1.play(stage.volume);
						else if(c==1)
					    attack2.play(stage.volume);
						else
						attack3.play(stage.volume);
					  
					}
		        	
		        });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
		    RunnableAction run1=Actions.run(new Runnable(){
		        
				@Override
				public void run() {
					// TODO Auto-generated method stub
					  vert.setPosition(a, 1000);
					  hori.setPosition(-30, b);
			        horiMove(hori);
			        vertMove(vert);
			        vert.draw=true;
			        hori.draw=true;
			        arr.play(1.0F);
				}
		    	
		    });
		  
				   SequenceAction sa1=Actions.sequence(delay1, run1,delay2,run2);
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 try{
					for(int i=0;i<FruitGroup.ROW;i++){
						FruitGroup.bombFruit2.add(FruitGroup.fruits[x][i]);
					}
					for(int i=0;i<FruitGroup.COL;i++){
						FruitGroup.bombFruit2.add(FruitGroup.fruits[i][y]);
					}
				}catch(ArrayIndexOutOfBoundsException e){
					
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
				 stage.fg.addAction(sa1);
				this.addAction(sequenceAction);
				return true;
			}else{
				return false;
			}

	}
   
	//月之祝福（进入暴击2倍伤害（10%）愤怒（增益20%）状态i+1回合，9，150）
	@Override
	public boolean ability4() {
		button4.ct.update(cooltime4);
		   button4.cool();
		if(this.magic>=80&&!abcool2){
			yue.move(stage.fg.delay1);
			DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run3=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
				yue.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay3, run3);
			yue.addAction(sa2);
			 DelayAction delay2=Actions.delay(1.0F);
		        
		        RunnableAction run2=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
					  moonn.reset();
					}
		        	
		        });
			 
				
		    
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
		    RunnableAction run1=Actions.run(new Runnable(){
		        
				@Override
				public void run() {
					// TODO Auto-generated method stub
			        moonn.draw=true;
			        moon.play(1.0F);
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
					magic-=80;
					bg.cb.magic=magic;                    
					bg.mag.setText((int)magic+"/"+(int)maxMagic);
		            state.add(Hero.State.crit);
		            ccrit+=2;
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
		//int k=ran.nextInt(4);
		int k=0;
		if(k==1){
			if(!abcool1)
		if(ability1()){
			 while(stage.fg.vanish()){
				  stage.fg.descend();
			  }
			abcool1=true;
			return true;
		}
		}else if(k==2){
			if(!abcool3)
			if(ability3()){
				 while(stage.fg.vanish()){
					  stage.fg.descend();
				  }
				abcool3=true;
				return true;
			}
			
		}else if(k==3){
			if(!abcool2)
			if(ability2()){
				abcool2=true;
				return true;
			}
		}else{
			if(!abcool4)
			if(ability4()){
				abcool4=true;
				return true;
			}
			
		}
		return false;
	}
     //女祭司
	
	
	
	public void horiMove(SmallThing st){
		MoveByAction mba=Actions.moveBy(600,0,0.2F);
		st.addAction(mba);
	}
	public void vertMove(SmallThing st){
		MoveByAction mba=Actions.moveBy(0,-1070,0.2F);
		st.addAction(mba);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
