package stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

import Hero.*;
import actor.FruitGroup;
import widget.Lose;
import widget.Victory;

  

public class GameStage extends Stage{
	 //如何将这个Stage和地图接起来，参数传递是有问题的吗？//将所有的角色确定编号，在创建时根据相应的编号去给定应该是什么角色
	 //地图层和实际游戏部分一些应该共享的数据，主角的属性，各种值，
	 //并且从GameStage出去后，需要判断一些复杂的逻辑              
	public static float volume=1.0F;
	 public FruitGroup fg;
	 public Hero hero1;
	 public Hero hero2;
	 Pixmap pm; 
	 public static boolean visible;
	 public  boolean hero1t=true;
	 public  boolean hero2t=false;                                      
     private Image background;
     public int round;
     private Batch batch;
     private Camera oc;
     private Music bgm;
     public Image blackground;
     private Image unstoppable;
     private Image combowhore;
     private Image monsterkill;
     private Image whickedsick;
     private Image dominating;
     private Image killingspree;
     public static Sound unstop;
     public static Sound com;
     public static Sound mon;
     public static Sound whick;
     public static Sound dom;
     public static Sound kill;
     String khero2;
     String restage;
     public GameScreen screen;
     public Victory victory;
     public Lose lose;
     Texture texture1;
     Texture texture2;
     Texture texture3;
     Texture texture4;
     Texture texture5;
     Texture texture6;
     Texture texture7;
	 public GameStage(Viewport viewport,Batch batch,GameScreen screen,String khero2,String restage,boolean mood) {  
		    super(viewport,batch);
		    this.screen=screen;
		    this.khero2=khero2;
		    this.restage=restage;
		    if(screen.game!=null){
		    screen.game.dispose();
			screen.game=null;
			System.gc();
		    }
		    if(screen.stage!=null){
		    	screen.stage.dispose();
		    	screen.stage=null;
		    	System.gc();
		    }
		    if(screen.sand!=null){
		    	screen.sand.dispose();
		    	screen.sand=null;
		    	System.gc();
		    }
		    if(screen.snow!=null){
		    	screen.snow.dispose();
		    	screen.snow=null;
		    	System.gc();
		    }
		    if(screen.afinal!=null){
		    	screen.afinal.dispose();
		    	screen.afinal=null;
		    	System.gc();
		    }
		    if(screen.stage!=null){
		    	screen.stage.dispose();
		    	screen.stage=null;System.gc();
		    }
		    
		    texture1=new Texture("blackground.png");
		    texture2=new Texture("unstoppable.png");
		    texture3=new Texture("combowhore.png");
		    texture4=new Texture("monsterkill.png");
		    texture5=new Texture("whickedsick.png");
		    texture6=new Texture("dominating.png");
		    texture7=new Texture("killingspree.png");
		    background=new Image(GameScreen.assetManager2.get("background.jpg", Texture.class));
		    blackground=new Image(texture1);
	    	blackground.setVisible(false);
	    	unstoppable=new Image(texture2);
	    	unstoppable.setVisible(false);
	    	unstoppable.setPosition(300, 1200);
	    	combowhore=new Image(texture3);
	    	combowhore.setVisible(false);
	    	combowhore.setPosition(300, 1200);
	    	monsterkill=new Image(texture4);
	    	monsterkill.setVisible(false);
	    	monsterkill.setPosition(300, 1200);
	    	whickedsick=new Image(texture5);
	    	whickedsick.setVisible(false);
	    	whickedsick.setPosition(300, 1200);
	    	dominating=new Image(texture6);
	    	dominating.setVisible(false);
	    	dominating.setPosition(300, 1200);
	    	killingspree=new Image(texture7);
	    	killingspree.setVisible(false);
	    	killingspree.setPosition(300, 1200);
	    	
	    	unstop= Gdx.audio.newSound(Gdx.files.internal("Sound/Unstoppable.mp3"));
	    	com=Gdx.audio.newSound(Gdx.files.internal("Sound/Combowhore.mp3"));
	    	mon=Gdx.audio.newSound(Gdx.files.internal("Sound/monster_kill.mp3"));
	    	whick=Gdx.audio.newSound(Gdx.files.internal("Sound/WhickedSick.mp3"));
	    	dom=Gdx.audio.newSound(Gdx.files.internal("Sound/Dominating.mp3"));
	    	kill=Gdx.audio.newSound(Gdx.files.internal("Sound/Killing_Spree.mp3"));
		    bgm = Gdx.audio.newMusic(Gdx.files.internal("Illidans.mp3"));
		    
		    bgm.setLooping(true);
		    bgm.play();
		    this.batch=batch;
		    oc=this.getCamera();
	  	     oc.update();
		    round=0;
		    if(!mood){
		        hero1=new BladeMaster(this,false);
		        hero1.attack=screen.attack;
		        hero1.defence=screen.defence;
		        hero1.blood=screen.blood;
		        hero1.magic=screen.magic;
		        hero1.maxMagic=screen.maxMgic;
		        hero1.maxBlood=screen.maxBlood;
		        initHero2();
			    }else{
			    	initHero();
			    }
	        hero2.setPosition(1500, 0);
	        fg=new FruitGroup(this);
	       this.addActor(background);
			this.addActor(fg);
			this.addActor(hero2);
			this.addActor(hero1);		
			this.addListener(new ClickListener(){
				public void clicked(InputEvent event,float x,float y){
					//开始的时候是看有没有第二种或者第三种技能触发，并且这种技能触发之后就可以去直接执行AI；
					if(fg.canClick){
					if(hero1.button1.isClicked&&(hero1.abilityk1==2||hero1.abilityk1==3)&&!hero1.abcool1){
						 fg.canClick=false;		 
	      				 hero1.button1.isClicked=false;
      				 if(hero1.ability1()){
      					 hero1.sphere=false;
      				   fg.eAI();
      				 }
      				 hero1.abcool1=true;	 
      			  }else if(hero1.button2.isClicked&&(hero1.abilityk2==2||hero1.abilityk2==3)&&!hero1.abcool2){
      				  fg.canClick=false;  
     				  hero1.button2.isClicked=false;
      				  if(hero1.ability2()){
      					 hero1.sphere=false;
      				  fg.eAI();
      				  }
      				  hero1.abcool2=true;
      			  }else if(hero1.button3.isClicked&&(hero1.abilityk3==2||hero1.abilityk3==3)&&!hero1.abcool3){
      				fg.canClick=false;		  
    				 hero1.button3.isClicked=false;
      				  if(hero1.ability3()){
      					 hero1.sphere=false;
      				  fg.eAI();
      				  }
      				hero1.abcool3=true;
      			  }else if(hero1.button4.isClicked&&(hero1.abilityk4==2||hero1.abilityk4==3)&&!hero1.abcool4){
      				  fg.canClick=false;
    				  hero1.button4.isClicked=false;
      				  if(hero1.ability4()){
      					 hero1.sphere=false;
      				  fg.eAI();
      				  }
      				 hero1.abcool4=true;  
      			  }	
					
					}
					
				}
			});
		    pm = new Pixmap(Gdx.files.internal("hand.png"));
			
	    	this.addActor(blackground);
	    	this.addActor(whickedsick);
	    	this.addActor(dominating);
	    	this.addActor(combowhore);
	    	this.addActor(killingspree);
	    	this.addActor(monsterkill);
	    	this.addActor(unstoppable);
		    Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0)); 
		    nextRound();
	 }                      
          
	 
	 public void remap(){
		 switch(restage){
		 case "my":
			 visible=false;
			 screen.my=new assetmy(screen);
			 screen.my.visible=true;
			 break;
		 case "snow":
			 visible=false;
			 screen.snow=new assetsnow(screen);
			 screen.snow.visible=true;
			 break;
		 case "sand":
			 visible=false;
			 screen.sand=new assetsand(screen);
			 screen.sand.visible=true;
			 break;
		 case "final":
		     visible=false;
		     screen.afinal=new assetfinal(screen);
			 screen.afinal.visible=true; 
		     break;
		 default:
			 visible=false;
			 screen.astart=new assetstart(screen);
	    	 screen.astart.visible=true;
		 }
	 }

	 public void initHero2(){
		 switch(khero2){
		   case "demo":
			   hero2=new demo(this,true);
			   break;
		   case "dog":
			   hero2=new dog(this,true);
			   break;
		   case "dogman2":
			   hero2=new dogman2(this,true);
			   break;
		   case "dogman3":
			   hero2=new dogman3(this,true);
			   break;
		   case "fisherman":
			   hero2=new fish(this,true);
			   break;
		   case "semimos":
			   hero2=new semo(this,true);
			   break;
		   case "spiders":
			   hero2=new spider2(this,true);
			   break;
		   
		   case "wolf3":
			   hero2=new wolf2(this,true);
			   break;
		   	   
		   case "dafashi":
			   hero2=new ArchMage(this,true);
			   break;
		   case "emolieshou":
			   hero2=new DemonHunter(this,true);
			   break;
		   case "huoyan":
			   hero2=new FireLord(this,true);
			   break;
		   case "jiansheng":
			   hero2=new BladeMaster(this,true);
			   break;
		   case "kongju":
			   hero2=new DreadLord(this,true);
			   break;
		   case "nvjisi":
			   hero2=new POM(this,true);
			   break;
		   case "shengqishi":
			   hero2=new Paladin(this,true);
			   break;
		   case "siqi":
			   hero2=new DeathKnight(this,true);
			   break;
		   case "xianzhi":
			   hero2=new FarSeer(this,true);
			   break;
		   case "xiongmao":
			   hero2=new PandaBrewmaster(this,true);
			   break;
	       default:
	    	   hero2=new PandaBrewmaster(this,true);
	    	   break;		   
		 }
	 }
	 public void nextRound(){
		 //在这个方法里，进行下一轮开始之前的所有初始化，并且这个方法调用的时间在上一次结束的时候用delay给出
		  //检查状态
		  fg.hcount1=0;
		  fg.hcount2=0;
		  fg.hurt=0;
		  fg.delay1=0;
		  hero1t=true;
		  hero2t=false;
		  hero1.button1.isClicked=false;
		  hero1.button2.isClicked=false;
		  hero1.button3.isClicked=false;
		  hero1.button4.isClicked=false;//进行这方面的初始化，是防止一些奇怪情况的出现
		  if(hero1.state.contains(Hero.State.poisoned)){	  
			  RunnableAction run = new RunnableAction();
			  DelayAction delay=Actions.delay(fg.delay1+1);
			  SequenceAction sequenceAction=Actions.sequence(delay,run);
			  run.setRunnable(new Runnable(){
				@Override
				public void run() {
					fg.hurt2=40;
					hero2.blood-=fg.hurt2;
					hero2.bg.cb.blood=hero2.blood;
				    hero2.bg.blo.setText((int)hero2.blood+"/"+(int)hero2.maxBlood);
				    fg.hurt2=0;
				}
			  });
			  this.addAction(sequenceAction);
			 hero1.cpoisoned-=1;
			 if(hero1.cpoisoned==0){
				 hero1.state.remove(Hero.State.poisoned);
			 }
		  }		  
		  if(hero1.state.contains(Hero.State.dizzy)){
			  hero1.cdizzy-=1;
			  if(hero1.cdizzy==0){
				  hero1.state.remove(Hero.State.dizzy);
			  }
			  fg.eAI();
		  }
		  if(hero1.state.contains(Hero.State.silent)){
			  hero1.csilent-=1;
			  if(hero1.csilent==0){
				  hero1.state.remove(Hero.State.silent);
			  }
			   //封锁所有的技能，想一下逻辑，给所有的技能部分再加一层锁，综合起来之后再加
		  }
		 
		  //固有的必须释放的技能
		  if(hero1.abilityk1==6){
			  hero1.ability1();
		  }
		  if(hero1.abilityk2==6){
			  hero1.ability2();
		  }
		  if(hero1.abilityk3==6){
			  hero1.ability3();
		  }
		  if(hero1.abilityk4==6){
			  hero1.ability4();
		  }
		  if(hero2.abilityk1==6){
			  hero2.ability1();
		  }
		  if(hero2.abilityk2==6){
			  hero2.ability2();
		  }
		  if(hero2.abilityk3==6){
			  hero2.ability3();
		  }
		  if(hero2.abilityk4==6){
			  hero2.ability4();
		  }
		
		  		  
		  
		  //第三种技能在每回合释放的地点
		  if(hero1.abilityk1==3){
				if(hero1.run1){
					hero1.ability1();
				}
				if(round-hero1.abround1>=hero1.continue1){
					hero1.run1=false;
				}
			}
		  
			if(hero1.abilityk2==3){
				if(hero1.run2){
					hero1.ability2();
				}
				if(round-hero1.abround2>=hero1.continue2){
					hero1.run2=false;
				}
			}
			if(hero1.abilityk3==3){
				if(hero1.run3){
					hero1.ability3();
				}
				if(round-hero1.abround3>=hero1.continue3){
					hero1.run3=false;
				}
			}
			if(hero1.abilityk4==3){
				if(hero1.run4){
					hero1.ability4();
				}
				if(round-hero1.abround4>=hero1.continue4){
					hero1.run4=false;
				}
			}
			
		  //这是每回合英雄的技能冷却恢复的地方
		  if(hero1.abcool1){
			  hero1.button1.ct.update(hero1.cooltime1-round+hero1.abround1);
			   if(round-hero1.abround1>=hero1.cooltime1){
				  hero1.button1.reset();
				   hero1.abcool1=false;
			   }
			}else{
				hero1.abround1=round;
			}
			if(hero1.abcool2){
				hero1.button2.ct.update(hero1.cooltime2-round+hero1.abround2);
				   if(round-hero1.abround2>=hero1.cooltime2){
					  
					   hero1.button2.reset();
					   hero1.abcool2=false;
				   }
				}else{
					 hero1.abround2=round;
				}
			if(hero1.abcool3){
				hero1.button3.ct.update(hero1.cooltime3-round+hero1.abround3);
				   if(round-hero1.abround3>=hero1.cooltime3){
					   hero1.button3.reset();
					   hero1.abcool3=false;
				   }
				}else{
					 hero1.abround3=round;
				}
			if(hero1.abcool4){
				hero1.button4.ct.update(hero1.cooltime4-round+hero1.abround4);
				   if(round-hero1.abround4>=hero1.cooltime4){
					   hero1.button4.reset();
					   hero1.abcool4=false;
				   }
				}else{
					 hero1.abround4=round;
				} 
	            //电脑控制角色技能冷却的地方		
			if(hero2.abcool1){
				   if(round-hero2.abround1>=hero2.cooltime1){
					 
					   hero2.abcool1=false;
				   }
				
			}else{
				  hero2.abround1=round;
			   }
			if(hero2.abcool2){
					   if(round-hero2.abround2>=hero2.cooltime2){
						   
						  
						   hero2.abcool2=false;
					   }
					}else{
						 hero2.abround2=round;
					}
				if(hero2.abcool3){
					   if(round-hero2.abround3>=hero2.cooltime3){
						 
						   hero2.abcool3=false;
					   }
					}else{
						  hero2.abround3=round;
					}
				if(hero2.abcool4){
					   if(round-hero2.abround4>=hero2.cooltime4){
						   
						   hero2.abcool4=false;
					   }
					}else{
						hero2.abround4=round;
					} 
		
				  hero1.sg.update(hero1.state);
				  hero2.sg.update(hero2.state);
	 }
	 @Override
	 public void draw(){
		 oc.update();
		 batch.setProjectionMatrix(oc.combined);
		 super.draw();
	 }
	 public void dispose() {
	        super.dispose();
	        pm.dispose();
	        bgm.dispose();
	        texture1.dispose();
	        texture2.dispose();
	        texture3.dispose();
	        texture4.dispose();
	        texture5.dispose();
	        texture6.dispose();
	        texture7.dispose();
	     unstop.dispose();
	        com.dispose();
	         mon.dispose();
	        whick.dispose();
	       dom.dispose();
	         kill.dispose();
	        
	    }
	 
	 public void move(float delay,int hurt){
		    DelayAction da=Actions.delay(delay+1);
		    DelayAction da2=Actions.delay(0.8F);
			MoveByAction mba1=Actions.moveBy(0,-900,0.2F,Interpolation.sineIn);
			MoveByAction mba2=Actions.moveBy(0,-1200,0.2F,Interpolation.sineIn);
			RunnableAction ra=Actions.run(new Runnable(){
               
				@Override
				public void run() {
					// TODO Auto-generated method stub 
					blackground.setVisible(true);
					if(hurt>100&&hurt<=300){
					killingspree.setVisible(true);
					kill.play(1.0F);}
					else if(hurt>300&&hurt<=500){
						dominating.setVisible(true);
						dom.play(1.0F);
					}else if(hurt>500&&hurt<=700){
						unstoppable.setVisible(true);
						unstop.play(1.0F);
					}else if(hurt>700&&hurt<=900){
						whickedsick.setVisible(true);
						whick.play(1.0F);
					}else if(hurt>900&&hurt<=1100){
						monsterkill.setVisible(true);
						mon.play(1.0F);
					}else if(hurt>1100){
						combowhore.setVisible(true);
						com.play(1.0F);
					}
				}
				
			});
			RunnableAction ra2=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub 
					reset();
				}
				
			});
			SequenceAction sa=Actions.sequence(da,ra,mba1, da2,mba2,ra2);
			if(hurt>100&&hurt<=300){
				killingspree.addAction(sa);}
				else if(hurt>300&&hurt<=500){
					dominating.addAction(sa);
				}else if(hurt>500&&hurt<=700){
					unstoppable.addAction(sa);
				}else if(hurt>700&&hurt<=900){
					whickedsick.addAction(sa);
				}else if(hurt>900&&hurt<=1100){
					monsterkill.addAction(sa);
				}else if(hurt>1100){
					combowhore.addAction(sa);
				}
			
	 }
	 public void reset(){
		 blackground.setVisible(false);
		 unstoppable.setVisible(false);
		 unstoppable.setPosition(300, 1200);
		 dominating.setVisible(false);
		 dominating.setPosition(300, 1200);
		 killingspree.setVisible(false);
		 killingspree.setPosition(300, 1200);
		 whickedsick.setVisible(false);
		 whickedsick.setPosition(300, 1200);
		 monsterkill.setVisible(false);
		 monsterkill.setPosition(300, 1200);
		 combowhore.setVisible(false);
		 combowhore.setPosition(300, 1200);
	 }
	 
	 public void initHero(){
    	 switch(screen.hero1){
    		 case "BladeMaster":
    			hero1=new BladeMaster(this,false); 
    			break;
    		 case "ArchMage":
     			hero1=new ArchMage(this,false); 
     			break;	
    		 case "DeathKnight":
      			hero1=new DeathKnight(this,false); 
      			break;	
    		 case "DemonHunter":
       			hero1=new DemonHunter(this,false); 
       			break;	
    		 case "DreadLord":
        			hero1=new DreadLord(this,false); 
        			break;	
    		 case "FarSeer":
     			hero1=new FarSeer(this,false); 
     			break;	
    		
    		 case "Paladin":
       			hero1=new Paladin(this,false); 
       			break;
    		 case "PandaBrewmaster":
        			hero1=new PandaBrewmaster(this,false); 
        			break;
    		 case "POM":
     			hero1=new POM(this,false); 
     			break;
    		 case "FireLord":
      			hero1=new FireLord(this,false); 
      			break;	
    	 }
    	 switch(screen.hero2){
		 case "BladeMaster":
			hero2=new BladeMaster(this,true); 
			break;
		 case "ArchMage":
 			hero2=new ArchMage(this,true); 
 			break;	
		 case "DeathKnight":
  			hero2=new DeathKnight(this,true); 
  			break;	
		 case "DemonHunter":
   			hero2=new DemonHunter(this,true); 
   			break;	
		 case "DreadLord":
    	    hero2=new DreadLord(this,true); 
    		  break;	
		 case "FarSeer":
 			hero2=new FarSeer(this,true); 
 			  break;	
		 
		 case "Paladin":
   			hero2=new Paladin(this,true); 
   			break;
		 case "PandaBrewmaster":
    			hero2=new PandaBrewmaster(this,true); 
    			break;
		 case "POM":
 			hero2=new POM(this,true); 
 			break;
		 case "FireLord":
  			hero2=new FireLord(this,true); 
  			break;	
	 }

     }

	 
	 public void viberation(){
		 RunnableAction ra1=Actions.run(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				 oc.translate(-15, 0, 0);
			}
			
		 });
		 RunnableAction ra2=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					 oc.translate(15, 0, 0);
				}
				
			 });
		 RunnableAction ra3=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					 oc.translate(-15, 0, 0);
				}
				
			 });
		 RunnableAction ra4=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					 oc.translate(15, 0, 0);
				}
				
			 });
		 RunnableAction ra5=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					 oc.translate(-15, 0, 0);
				}
				
			 });
		 DelayAction da=Actions.delay(0.003F);
		 SequenceAction sa=Actions.sequence(ra1,da, ra2,da, ra3, da,ra4,da, ra5);
		 this.addAction(sa);
		 
	 }
}
