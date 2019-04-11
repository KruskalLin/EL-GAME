package Hero;

import actor.BarGroup;
import actor.Bloodplus;
import actor.CusButton;
import actor.FruitGroup;
import label.*;
import stage.GameStage;

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
//涓�鍒囧拰灞忓箷鏄剧ず鏈夊叧鐨勯兘瑕佸姞鍦╠elay1閲�
public class BladeMaster extends Hero{
	private TextureAtlas ta1;
	private Animation ani1;
	private float a,b;
	private boolean aiturn=false;
	private Baoji baoji;
	private Shanbi Shanbi;
	private Bloodplus bp;
	private Sound StormOfBlade;
	private Sound Heal;
	private Sound War;
    private Random ran;
    private Date date;
    private jianrenfengbao jianrenfengbao;
	public BladeMaster(GameStage stage,boolean reverse){
		       super(stage,reverse);
		       bp=new Bloodplus(reverse);
		       pm1=new Pixmap(Gdx.files.internal("hand.png"));
		       pm2 = new Pixmap(Gdx.files.internal("sphere.png")); 
		       date=new Date();
		       ran=new Random(date.getTime());
		       money=200;
		       xp=500;
		       Yes1= GameScreen.assetManager2.get(("BladeMaster/HeroBladeMasterYes1.wav"),Sound.class);
		       Yes2= GameScreen.assetManager2.get(("BladeMaster/HeroBladeMasterYes2.wav"),Sound.class);
		       Yes3= GameScreen.assetManager2.get(("BladeMaster/HeroBladeMasterYes3.wav"),Sound.class);
		       Yes4= GameScreen.assetManager2.get(("BladeMaster/HeroBladeMasterYes4.wav"),Sound.class);
		       attack1= GameScreen.assetManager2.get(("BladeMaster/HeroBladeMasterYesAttack1.wav"),Sound.class);
		       attack2= GameScreen.assetManager2.get(("BladeMaster/HeroBladeMasterYesAttack2.wav"),Sound.class);
		       attack3= GameScreen.assetManager2.get(("BladeMaster/HeroBladeMasterYesAttack3.wav"),Sound.class);
		       StormOfBlade= GameScreen.assetManager2.get(("BladeMaster/StormOfBlade.wav"),Sound.class);
		       Heal=GameScreen.assetManager2.get(("BladeMaster/Heal.wav"),Sound.class);
		       cooltime1=6;
		       cooltime2=6;
		       cooltime3=0;
		       cooltime4=0;
		       continue1=0;
		       continue2=1;
		       continue3=0;
		       continue4=0;
		       abilityk1=1;
		       abilityk2=3;
		       abilityk3=4;
		       abilityk4=8;
		       maxBlood=1060;
		       maxMagic=182;
		       blood=1000;
		       magic=182;	       
		       force=27;
		       attack=49;
		       quick=29;
		       intelligence=14;
		       defence=4;
		       dforce=(float)1.9;
		       dquick=(float)2.9;
		       dintellience=(float)1.4;
		       baoji=new Baoji(reverse);
		       Shanbi=new Shanbi(reverse);
		       jianrenfengbao=new jianrenfengbao(reverse);
		       bg=new BarGroup(0,1010,blood,magic,maxBlood,maxMagic,reverse);
		       if(!reverse)
			       image=new Image(GameScreen.assetManager2.get(("BladeMaster/Hero1.png"),Texture.class));
			       else
			    	   image=new Image(GameScreen.assetManager2.get(("BladeMaster/Hero1Re.png"),Texture.class));
			       if(!reverse)
			       image.setPosition(120,200);
			       else
			       image.setPosition(2208-image.getWidth()-120-1504,200);		       
			       if(!reverse){
			    	   button1=new CusButton(17,884,GameScreen.assetManager2.get(("BladeMaster/jrfb_white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/jrfb.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/jrfb.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/jrfb_black.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"剑刃风暴",reverse,6);
				       button2=new CusButton(17,793,GameScreen.assetManager2.get(("BladeMaster/zlsw_white.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/zlsw.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/zlsw.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/zlsw_black.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"生命图腾",reverse,6);
				       button3=new CusButton(17,702,GameScreen.assetManager2.get(("BladeMaster/blbl.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/blbl.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/blbl.png"),Texture.class),
				    		   null,
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"剑舞",reverse,0);
				       button4=new CusButton(17,612,GameScreen.assetManager2.get(("BladeMaster/hhzf.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/hhzf.png"),Texture.class),
				    		   GameScreen.assetManager2.get(("BladeMaster/hhzf.png"),Texture.class),
				    		   null,
				    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"疾风刃",reverse,0);  }else{
				    			   button1=new CusButton(644-17,884,GameScreen.assetManager2.get(("BladeMaster/jrfb_white.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/jrfb.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/jrfb.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/jrfb_black.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"剑刃风暴",reverse,6);
							       button2=new CusButton(644-17,793,GameScreen.assetManager2.get(("BladeMaster/zlsw_white.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/zlsw.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/zlsw.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/zlsw_black.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"生命图腾",reverse,6);
							       button3=new CusButton(644-17,702,GameScreen.assetManager2.get(("BladeMaster/blbl.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/blbl.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/blbl.png"),Texture.class),
							    		   null,
							    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"剑舞",reverse,0);
							       button4=new CusButton(644-17,612,GameScreen.assetManager2.get(("BladeMaster/hhzf.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/hhzf.png"),Texture.class),
							    		   GameScreen.assetManager2.get(("BladeMaster/hhzf.png"),Texture.class),
							    		   null,
							    		   GameScreen.assetManager2.get(("textground.png"),Texture.class),"疾风刃",reverse,0);  
			       }
			       
			       button1.round=6;
			       button2.round=6;
			       button3.round=0;
			       button4.round=0;
			       
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
				    		  sphere=true;
				  		    Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm2, pm2.getWidth()/2, pm2.getHeight()/2));
				    	  }}}
				      });
				      button2.b.addListener(new ClickListener(){
				    	  public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
				    		  if((magic>=100||run2)&&(!abcool2||run2)){
				    		   stage.fg.enter.play();
				    		  }
				    	   }
				    	  public void clicked(InputEvent e,float x,float y){
				    		  if(stage.fg.canClick){
				    			  if((run2)&&(!abcool2||run2)){
				    			  button1.isClicked=false;
				    		      button2.isClicked=true;
				    		      sphere=false;
				    		      Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm1,0,0));
				    		  }}
				    	  }
				      });
				      button3.b.addListener(new ClickListener(){
				    	  public void clicked(InputEvent e,float x,float y){
				    		  if(stage.fg.canClick)
				    		  button3.isClicked=true;
				    	  }
				      });
				      button4.b.addListener(new ClickListener(){
				    	  public void clicked(InputEvent e,float x,float y){
				    		  if(stage.fg.canClick)
				    		  button4.isClicked=true;
				    		  
				    	  }
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
				      ta1=GameScreen.assetManager2.get(("BladeMaster/StormOfBlade.pack"),TextureAtlas.class);
			       this.addActor(skillpanel);
			       this.addActor(image);
		           this.addActor(property);
		           this.addActor(tool);    
	               this.addActor(bg);
	               this.addActor(button1);
	               this.addActor(button2);
	               this.addActor(button3);
	               this.addActor(button4);
	               this.addActor(baoji);
	               this.addActor(Shanbi);
	               this.addActor(hb);
	               this.addActor(bp);
	               this.addActor(light);
	               this.addActor(jianrenfengbao);
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
	
	@Override
	//绗簩绫诲拰绗竴绫荤殑鍒ゆ柇鏉′欢鍑犱箮涓�鏍�
	//绗竴绉嶆妧鑳界殑浣跨敤锛岄檺鍒舵潯浠讹細钃濓紝鍐峰嵈锛屽叾浠栨病鏈夛紝浣跨敤瀹岀洿鎺ヨ缃负鍐峰嵈锛屾敞鎰忔墍鏈夊姞鍑忛兘鍐欏湪delay閲岄潰锛屽湪涓ゆ柟鐨勫尯鍒笂锛屽彧瑕佸湪鍑忎笂鍔犱竴涓垽鏂�
	      public boolean ability1() {
		   button1.ct.update(cooltime1);
		   button1.cool();
		if(!aiturn){
		    a=FruitGroup.fruits[x][y].getX();
		    b=FruitGroup.fruits[x][y].getY();}
           System.out.println(x+" "+y);
		    if(this.magic>=80&&!abcool1){ 
		    	  jianrenfengbao.move(stage.fg.delay1);
					DelayAction delay2=Actions.delay((float) (stage.fg.delay1+1.0));
			        RunnableAction run2=Actions.run(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
							jianrenfengbao.reset();
						}
			        	
			        });
				    SequenceAction sa2=Actions.sequence(delay2, run2);
					jianrenfengbao.addAction(sa2);
					
		    	ani1=new Animation(0.1F,ta1.getRegions(),PlayMode.NORMAL);
		    	DelayAction delay1=Actions.delay(stage.fg.delay1);
            RunnableAction run1=Actions.run(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					FruitGroup.fruits[x][y].Ability1(ani1,250,254,a,b);
					int c=ran.nextInt(3);
					if(c==0)
					attack1.play(stage.volume);
					else if(c==1)
				    attack2.play(stage.volume);
					else
					attack3.play(stage.volume);
					StormOfBlade.play(stage.volume);
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
				stage.fg.hurt+=50;
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
				
			}}else{                              
				if(stage.hero1.blood>=50){
				   stage.fg.hurt+=50;
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
				}
			} 
			FruitGroup.fruits[x][y].addAction(sa1);                       
			this.addAction(sequenceAction);
			
			return true;
		}else{
			button1.isClicked=false;
			return false;
		}
		
	}
     
	public void ability5() {
		
		try{
			for(int i=0;i<FruitGroup.ROW;i++){
				FruitGroup.bombFruit2.add(FruitGroup.fruits[x][i]);
			}
			for(int i=0;i<FruitGroup.COL;i++){
				FruitGroup.bombFruit2.add(FruitGroup.fruits[i][y]);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
	}                                               
	@Override
	public boolean ability3() {
		//鍐欎竴涓敱鐧惧垎涔�10鍑犵巼瑙﹀彂鐨勬妧鑳�
		//鍥烘湁鎶�鑳斤紝鏃犻渶鍐峰嵈
		int k=ran.nextInt(10);
		if(k==1){
		stage.fg.addFruit();
		stage.fg.changeBomb();
		}
		return true;
	}
		
	@Override
	public boolean ability4() {
		//鍥烘湁鎶�鑳斤紝鏃犻渶鍐�
		
		
		if(stage.hero1t){
		int k=ran.nextInt(10);
		if(k==1){
		stage.fg.hurt*=2;
	 if((!reverse&&stage.hero1t)||(reverse&&stage.hero2t)){
		    baoji.move(stage.fg.delay1);
			DelayAction delay2=Actions.delay((float) (stage.fg.delay1+1.0));
	        RunnableAction run2=Actions.run(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					baoji.reset();
				}
	        	
	        });
		    SequenceAction sa2=Actions.sequence(delay2, run2);
			baoji.addAction(sa2);
			}
		}
		}else{
			int k=ran.nextInt(10);
			if(k==1){
				stage.fg.hurt=0;
				if((!reverse&&stage.hero1t)||(reverse&&stage.hero2t)){	
				    Shanbi.move(stage.fg.delay1);
					DelayAction delay3=Actions.delay((float) (stage.fg.delay1+1.0));
			        RunnableAction run3=Actions.run(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
							Shanbi.reset();
						}
			        	
			        });
				    SequenceAction sa3=Actions.sequence(delay3, run3);
					Shanbi.addAction(sa3);
			}
			}
		}
		return true;
	}
     
	@Override
	//闄愬埗鏉′欢锛岃摑锛屽喎鍗存垨鑰呮鍦ㄨ繍琛岋紙姝ｅ湪杩愯鏃跺鐣岀殑璋冪敤鏄湁鏉′欢鐨勶級锛岄櫎浜嗘瘡鍥炲悎鐨勮嚜鍔ㄨ皟鐢ㄥ叾浣欒皟鐢ㄦ椂閮借鍔犱笂鍐峰嵈闄愬埗杩欎竴涓垽鏂潯浠�
	//涓ゆ柟闈㈢殑鍖哄埆锛屽彲鑳界殑鏃跺�欏姞涓婂璞＄殑鍒ゆ柇
	public boolean ability2() {
		//闀挎湡鎶�鑳界殑妯℃澘
		   button2.cool();
		button2.ct.update(cooltime2);
		if((this.magic>=100||run2)&&(!abcool2||run2)){
			if(!run2)
			abround2=stage.round;
			if(!run2){
			this.magic-=100;
			}        
		
		 RunnableAction run = new RunnableAction();
		 DelayAction delay=Actions.delay(stage.fg.delay1);
		 RunnableAction run1 =Actions.run(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				bp.reset();
			}
			 
		 });
		 DelayAction delay2=Actions.delay(0.5F);
		 SequenceAction sequenceAction=Actions.sequence(delay,run,delay2,run1);
		 run.setRunnable(new Runnable(){
			@Override
			public void run() {
				float temp=blood;
				blood+=0.1*maxBlood;
				if(blood>maxBlood){
			      blood=maxBlood;
		         }
				temp=blood-temp;
				bp.reveal(temp);
				bg.cb.blood=blood;
				bg.blo.setText((int)blood+"/"+(int)maxBlood);
				bg.cb.magic=magic;
				bg.mag.setText((int)magic+"/"+(int)maxMagic);	
				Heal.play(stage.volume);
			}
		 });
		this.addAction(sequenceAction);
		run2=true;
		return true;
		}else{
			button2.isClicked=false;
			return false;
		}
		
	}
    //鎬濊�傾I濡備綍閲婃斁鎶�鑳�
	@Override
	public boolean AI() {
		x=ran.nextInt(8);y=ran.nextInt(10);
		aiturn=true;
		a=x*100;
		b=y*100;
		System.out.println(a+" "+b);
		if(this.blood<=7888800){
			if(!abcool2){
			if(ability2()){
				abcool2=true;	  
				return true;
			}else{
				return false;
			}
			}else{
				return false;
			}
		}else if(ability1()){
			 while(stage.fg.vanish()){
				  stage.fg.descend();
			  }
			abcool1=true;
			return true;
		}else{
			return false;
		}
	}
	

	
	
}

