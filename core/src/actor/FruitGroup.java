package actor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.SizeToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;

import Hero.Hero;
import actor.CommonFruit.Colors;
import stage.GameStage;
import widget.Lose;
import widget.Victory;
public class FruitGroup extends Group implements Disposable{
	private Image background;
	 public static final int ROW = 10;
	 public static final int COL= 8;
	 private static ArrayList<CommonFruit> e;
     private static ArrayList<CommonFruit> v;
     private static ArrayList<Vertical> clearv1;
     private static ArrayList<Vertical> clearv2;
     private static ArrayList<Horizon> clearh1;
     private static ArrayList<Horizon> clearh2;
    
	public GameStage stage;
    public static CommonFruit[][] fruits;
    int[][] score;
	public Vector<Colors> ColorV;
    CommonFruit fruit1;
    CommonFruit fruit2;
    private Date date;
    private Random ran;
	int kind;
	static final int height=100;
	static final int width=100;
	float vt=(float)1.0;
    public float delay1;
    float ve=(float)5; 
    public int hcount1=0;
    public int hcount2=0;
    public float volume;
    Hero hero1;
    Hero hero2;
    public int hurt=0;   //普通攻击
    public int hurt2=0;  //特殊攻击
    
    private boolean end=false;
    public boolean canClick=true;
    public static ArrayList<CommonFruit> bombList=new ArrayList<CommonFruit>();
    public static ArrayList<CommonFruit> bombFruit2=new ArrayList<CommonFruit>();
   public  ArrayList<CommonFruit> bombFruit=new ArrayList<CommonFruit>();
    public ArrayList<CommonFruit> smallList=new ArrayList<CommonFruit>();
    public static ArrayList<ArrayList<CommonFruit>> bigList=new ArrayList<ArrayList<CommonFruit>>();
    
    private static TreeSet<Integer> vanishXSet=new TreeSet<Integer>();        
    public static Sound eliminate;
    public static Sound desc;
    public static Sound enter;
    public static Sound woosh;
    public static Sound bloody;
    class position{
    	public  position(int x,int y){
    		this.x=x;
    		this.y=y;
    	}
    	int x;
     	int y;
    }
    public FruitGroup(GameStage stage) {
    	 background=new Image(new Texture("trap.png"));
   	  background.setPosition(-435,-192);
   	  this.addActor(background);
    	this.stage=stage;
    	volume=stage.volume;
     	  hero1=stage.hero1;
     	  hero2=stage.hero2;
          init();
          this.setPosition(704, 100);  
          
    }
    
    public void print(){
    	for(int j=ROW-1;j>=0;j--){
       		for(int i=0;i<COL;i++){
       	        System.out.print(fruits[i][j].color+"  ");
       		}
       		System.out.print("\r\n");
    	}
    }
   
    
    public void init(){   	
    	
    	eliminate= Gdx.audio.newSound(Gdx.files.internal("bomb.wav"));
    	desc= Gdx.audio.newSound(Gdx.files.internal("desc.wav"));
    	enter= Gdx.audio.newSound(Gdx.files.internal("enter.wav"));
    	woosh= Gdx.audio.newSound(Gdx.files.internal("woosh.wav"));
    	bloody= Gdx.audio.newSound(Gdx.files.internal("Blood.wav"));
    	v=new ArrayList();
    	e=new ArrayList();
    	clearv1=new ArrayList();
    	clearv2=new ArrayList();
    	clearh1=new ArrayList();
    	clearh2=new ArrayList();
    	score=new int[COL][ROW];
    	fruits=new CommonFruit[COL][ROW];
    	List<CommonFruit> list=new ArrayList<CommonFruit>();
    	for(int i=0;i<COL;i++){
    		for (int j=0;j<ROW;j++){
    			list.add(fruits[i][j]);
    		}
    	}
    	
       	ColorV=new Vector<Colors>();   
       	date=new Date();  	
       	ran=new Random(date.getTime());
       	Colors random;
       	Colors[] colors=Colors.values();     
       	for(Colors color:colors){
       		ColorV.add(color);
       	}
       	for(int i=0;i<COL;i++){
       		for(int j=0;j<ROW;j++){		
       			if(ColorV.isEmpty()){
       				init();
       				return;
       			}else{
       				
       				random=ColorV.get(ran.nextInt(ColorV.size()));
    		    	fruits[i][j]=new CommonFruit(i,j,random,0,stage);
    		    	
    		    	if(Flag(i,j)){
    		    		j=j-1;
    		    		ColorV.remove(random);
    		    	}else{
    		    		ColorV.clear();
    		    		for(Colors color:colors){
    		    	   		ColorV.add(color);
    		    	   	}
    		    	}
       			}
       		}
       	}                                        
        addActor();
        addListener();
    	initAnimation();
       }     
    //点击的原因：交换相消，使用技能，没事   
    public void addListener(){
    	this.addListener(new ClickListener(){
        	  public void clicked(InputEvent event,float x,float y){//发生在点击棋盘的逻辑发生的时候
        		
        		  if(canClick){     //可以确定可以被用户点击；	  
        		  canClick=false;     //进入后封锁；
        		   //一些基本状态的初始化，
        		  	 if(x<0||x>800||y>1000||y<0)
        		  	 {
        		  		 for(int k=0;k<COL;k++){
        		  			 for(int h=0;h<ROW;h++){
        		  				 fruits[k][h].ring=false;
        		  			 }
        		  		 }
        		  	 }
        		  int i=(int)(x/width);                                       
        		  int j=(int)(y/height); //找到点击的位置                                     
        		  if(i<COL&&j<ROW){
        			  //最基本的消除和技能逻辑，这部份的基本逻辑是正确的，没有什么问题
        			  hero1.x=i;
    				  hero1.y=j;
    				  //关于冷却是否可用的问题放到每个技能方法里去解决
    				  
        			  if(hero1.button1.isClicked&&hero1.abilityk1==1&&hero1.ability1()){
        				  Gdx.graphics.setCursor(Gdx.graphics.newCursor(hero1.pm1,0,0));
        				  hero1.button1.isClicked=false;
        				  hero1.sphere=false;
        				  hero1.abcool1=true;
        				  while(vanish()){
            				  descend();
            			  }
        				  fruit1=null;
        				  fruit2=null;
        			  }else if(hero1.button2.isClicked&&hero1.abilityk2==1&&hero1.ability2()){	
        				  Gdx.graphics.setCursor(Gdx.graphics.newCursor(hero1.pm1,0,0));
        				  hero1.button2.isClicked=false;
        				  hero1.sphere=false;
        				  hero1.abcool2=true;
        				  while(vanish()){
            				  descend();
            			  }
        				  fruit1=null;
        				  fruit2=null;
        			  }else if(hero1.button3.isClicked&&hero1.abilityk3==1&&hero1.ability3()){
        				  Gdx.graphics.setCursor(Gdx.graphics.newCursor(hero1.pm1,0,0));
        				  hero1.button3.isClicked=false;
        				  hero1.sphere=false;
        				  hero1.abcool3=true;
        				  while(vanish()){
            				  descend();
            			  }
        				  fruit1=null;
        				  fruit2=null;
        			  }else if(hero1.button4.isClicked&&hero1.abilityk4==1&&hero1.ability4()){
        				  Gdx.graphics.setCursor(Gdx.graphics.newCursor(hero1.pm1,0,0));
        				  hero1.button4.isClicked=false;
        				  hero1.sphere=false;
        				  hero1.abcool4=true;
        				  while(vanish()){
            				  descend();
            			  }
        				  fruit1=null;
        				  fruit2=null;
        			  }else{	  
        	     if(fruit1==null&&fruit2==null){
                       fruit1=fruits[i][j];
                       canClick=true;
                       fruit1.clicked();
                       fruit1.ring=true;
                       int a=ran.nextInt(4);
                       if(a==0)
                       hero1.Yes1.play(volume);
                       else if(a==1)
                       hero1.Yes2.play(volume);
                       else if(a==2)
                       hero1.Yes3.play(volume);
                       else
                       hero1.Yes4.play(volume);
                      return;
        		 }else if(fruit1!=null&&fruit2==null){
        			
                    CommonFruit tem=fruits[i][j];                
                    if(near(fruit1,tem)){
                  	  fruit2=tem;
                  	fruit1.clicked();
              	    fruit2.ring=true;
                    }else{
                    	fruit1.ring=false;
                  	  fruit1=tem; 
                  	fruit1.clicked();
                  	int a=ran.nextInt(4);
                    if(a==0)
                        hero1.Yes1.play(volume);
                        else if(a==1)
                        hero1.Yes2.play(volume);
                        else if(a==2)
                        hero1.Yes3.play(volume);
                        else
                        hero1.Yes4.play(volume);
              	  fruit1.ring=true;
                    } 
                    if(!(fruit1!=null&&fruit2!=null)){
                    	 
                    canClick=true;
                    return;
                    }
        		 }
        		 if(fruit1!=null&&fruit2!=null){
                           fruit1.ring=false;
            			 fruit2.ring=false;
            			 woosh.play(volume);
        			 swap(fruit1,fruit2);
        			 //交换技能是否触发,放在此处逻辑上也没有问题
        			 //目前好像只有剑圣的第二个技能
        			 
        			 if(hero1.abilityk1==4){
        				 hero1.ability1();
        			 }
        			 if(hero1.abilityk2==4){
        				 hero1.ability2();
        			 }
        			 if(hero1.abilityk3==4){
        				 hero1.ability3();
        			 }
        			 if(hero1.abilityk4==4){
        				 hero1.ability4();
        			 }
        			 
        			 while(vanish()){
        				 descend();
        			 }	 
        			  fruit1=null;
        			  fruit2=null;
        		 }
        		 
        			  }  	
        			  calculate(hcount1,hero1,hero2);
        			
        			   	
        			 int temp=hurt;
        			 System.out.println(hurt);
         			 RunnableAction run = new RunnableAction();
         			 run.setRunnable(new Runnable(){
 						@Override
 						public void run() {
 							
 							 stage.hero2.blood-=temp;
 							 stage.hero2.bg.cb.blood=stage.hero2.blood;
 		      				 stage.hero2.bg.blo.setText((int)stage.hero2.blood+"/"+(int)stage.hero2.maxBlood);	
 		      				 stage.hero2.hb.reveal(temp);
 		      				 bloody.play(volume);
 		      				if(hero2.blood<=0){
 		      					end=true;
 							    stage.victory=new Victory(570,100,stage); 
 							    stage.victory.label.setText("得到金钱 "+stage.hero2.money);
 							    stage.victory.label.setText("得到经验"+" "+stage.hero2.xp);
 								stage.addActor(stage.victory);
 	                        stage.screen.XP+=hero2.xp;
 	                        stage.screen.money+=hero2.money;
 	                        stage.screen.blood=hero1.blood;
 	                        stage.screen.magic=hero1.magic;
 		      				 }
 						}  
          			  });  
         			 RunnableAction run1 = new RunnableAction();
      			          run1.setRunnable(new Runnable(){
						@Override
						public void run() {
		      				 stage.hero2.hb.reset();
						}  
       			  });
       			     DelayAction delay=Actions.delay(delay1);
       			     DelayAction delayplus=Actions.delay(1F);
       			     SequenceAction sequenceAction=Actions.sequence(delay,run,delayplus,run1);
         			  fruits[0][0].addAction(sequenceAction);
         			
         			   stage.move(delay1,temp*4);
         		
      				  hurt=0;			
        			  eAI();
        		  }
        	  }
        	  }
          });
    }      
       public void eAI(){   
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
    	   DelayAction delay3=Actions.delay(delay1+2);
    	   RunnableAction run7=Actions.run(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				hero1.light.setVisible(false);
				hero2.light.setVisible(true);
			}
    		   
    	   });
    	   SequenceAction sequenceAction3=Actions.sequence(delay3,run7);
    	   this.addAction(sequenceAction3);
    	   delay1+=4;
    	   stage.hero1t=false;
		   stage.hero2t=true; 
    	   RunnableAction run = new RunnableAction();
		   DelayAction delay=Actions.delay(delay1);
		   SequenceAction sequenceAction=Actions.sequence(delay,run);
    	   if(hero2.abilityk1==3){
				if(hero2.run1){
					hero2.ability1();
				}
				if(stage.round-hero2.abround1>=hero2.continue1){
					hero2.run1=false;
				}
			}
			if(hero2.abilityk2==3){
				if(hero2.run2){
					hero2.ability2();
				}
				if(stage.round-hero2.abround2>=hero2.continue2){
					hero2.run2=false;
				}
			}
			if(hero2.abilityk3==3){
				if(hero2.run3){
					hero2.ability3();
				}
				if(stage.round-hero2.abround3>=hero2.continue3){
					hero2.run3=false;
				}
			}
			if(hero2.abilityk4==3){
				if(hero2.run4){
					hero2.ability4();
				}
				if(stage.round-hero2.abround4>=hero2.continue4){
					hero2.run4=false;
				}
			}
			 int k=ran.nextInt(2);
			if(hero2.state.contains(Hero.State.poisoned)){
				 run = new RunnableAction();
				   delay=Actions.delay(stage.fg.delay1+1);
				   RunnableAction run1 = new RunnableAction();
			          run1.setRunnable(new Runnable(){
					@Override
					public void run() {
	      				 stage.hero2.hb.reset();
					}  
			  });
			     DelayAction delayplus=Actions.delay((float) (0.5));
				   sequenceAction=Actions.sequence(delay,run,delayplus,run1);
				  run.setRunnable(new Runnable(){

					@Override
					public void run() {
						stage.fg.hurt2=40;
						hero2.blood-=stage.fg.hurt2;
						hero2.bg.cb.blood=hero2.blood;
					    hero2.bg.blo.setText((int)hero2.blood+"/"+(int)hero2.maxBlood);
					    hero2.hb.reveal(stage.fg.hurt2);
					    bloody.play(volume);
					    stage.fg.hurt2=0;
					}		  
				  });
				  this.addAction(sequenceAction);
				 hero2.cpoisoned-=1;
				 if(hero2.cpoisoned==0){
					 hero2.state.remove(Hero.State.poisoned);
				 }
				 
			  }		  
			  if(hero2.state.contains(Hero.State.dizzy)){
				  hero2.cdizzy-=1;
				  if(hero2.cdizzy==0){
					  hero2.state.remove(Hero.State.dizzy);
				  }
				  end();
				  return;
			  }
			  if(hero2.state.contains(Hero.State.silent)){
				  hero2.csilent-=1;
				  if(hero2.csilent==0){
					  hero2.state.remove(Hero.State.silent);
				  }
				   k=0;        //直接让电脑不能使用技能
			  }
			  	
    		    canClick=false;                  	
    		    hcount2=0;
    		    hcount1=0;
    		       //更换操作权	   
  			   
  			   
  			    if(k==1||k==0){
  			    	if(hero2.AI()){   		
  			    	}else{
  			    		cumputerAI();	  			    
  		  			    swap(fruit1,fruit2);
  		  			    while(vanish()){
  		   				 descend();
  		   			    }
  			    	}
  			    }else{
  			    cumputerAI();
  			    swap(fruit1,fruit2);
  			    while(vanish()){
   				 descend();
   			    }
  			    }
  			   fruit1=null;                                  
  			   fruit2=null; 
  			  delay=Actions.delay(delay1); 
  			  DelayAction delayplus=Actions.delay(1F);
  			 calculate(hcount2,hero2,hero1);
  			 int temp=hurt;
  			 RunnableAction run1 = new RunnableAction();
		          run1.setRunnable(new Runnable(){
			@Override
			public void run() {
 				 stage.hero1.hb.reset();
 				 
			}  
		  });
		    run.setRunnable(new Runnable() {
			    public void run() {       
			       
			        stage.hero1.blood-=temp;
					stage.hero1.bg.cb.blood=stage.hero1.blood;
					stage.hero1.bg.blo.setText((int)stage.hero1.blood+"/"+(int)stage.hero1.maxBlood);
					stage.hero1.hb.reveal(temp);
					bloody.play(volume);
					hurt=0;
					
					
	   	    }
			}); 
  			   sequenceAction=Actions.sequence(delay,run,delayplus,run1);
			   
			   
			  fruits[0][0].addAction(sequenceAction);
  			   end();
  			 DelayAction delay4=Actions.delay(delay1+1);
      	   RunnableAction run8=Actions.run(new Runnable(){

  			@Override
  			public void run() {
  				// TODO Auto-generated method stub
  				hero2.light.setVisible(false);
  				hero1.light.setVisible(true);
  			}
      		   
      	   });
      	   SequenceAction sequenceAction4=Actions.sequence(delay4,run8);
      	   this.addAction(sequenceAction4);
  			   delay1+=2;
  		 }
       public void end(){
			   RunnableAction run = new RunnableAction();
			   DelayAction delay=Actions.delay(delay1);
			   run.setRunnable(new Runnable() {
			    public void run() {	
			        canClick=true;
			        stage.round++;
					stage.nextRound();
					if(hero1.blood<=0){
						end=true;
						stage.lose=new Lose(570,100,stage); 
						stage.addActor(stage.lose);
					}
	   	    }
			}); 
		   	  SequenceAction sequenceAction=Actions.sequence(delay,run);
			  fruits[0][0].addAction(sequenceAction);
       }
       
       //实际伤害=攻击力*(1-护甲*0.06/(护甲*0.06+1))
       public void calculate(int count,Hero hero1,Hero hero2){
    	    hurt+=count*(int)((float)hero1.attack*(1-hero2.defence*0.6/(hero2.defence*0.6+1)));
    	    System.out.println(hurt);
  		  if(hero1.state.contains(Hero.State.curse)){
  			  hero1.ccurse-=1;
  			  if(hero1.ccurse==0){
  				  hero1.state.remove(Hero.State.curse);
  			  }
  			  hurt*=0.85;
  			  
  		  }
  		if(hero1.state.contains(Hero.State.angry)){
			  hero1.cangry-=1;
			  if(hero1.cangry==0){
				  hero1.state.remove(Hero.State.angry);
			  }
			  hurt*=3;
		  }
  		if(hero1.state.contains(Hero.State.crit)){
			  hero1.ccrit-=1;
			  if(hero1.ccrit==0){
				  hero1.state.remove(Hero.State.crit);
			  }
			  int k=ran.nextInt(3);
			  if(k==1){
				  hurt*=8;
			  }
		}
  		
  		if(hero2.state.contains(Hero.State.dodge)){
  			  hero2.cdodge-=1;
			  if(hero2.cdodge==0){
				  hero2.state.remove(Hero.State.dodge);
			  }
			  hurt=0;
  		}
  		if(hero2.state.contains(Hero.State.defence)){
			  hero2.cdefence-=1;
			  if(hero2.cdefence==0){
				  hero2.state.remove(Hero.State.defence);
			  }
			  hurt-=60;
			  if(hurt<=0){
				  hurt=0;
			  }
		}
  		
  		//嗜血稍后再考虑
  		
  		//下面是自己方的技能造成的影响
    	     if(hero1.abilityk1==5||hero1.abilityk1==8){
				 hero1.ability1();
			 }
			 if(hero1.abilityk2==5||hero1.abilityk2==8){
				 hero1.ability2();
			 }
			 if(hero1.abilityk3==5||hero1.abilityk3==8){
				 hero1.ability3();
			 }
			 if(hero1.abilityk4==5||hero1.abilityk4==8){
				 hero1.ability4();
			 }
		     //下面是对方的技能造成的影响
			 if(hero2.abilityk1==7||hero2.abilityk1==8){
				 hero2.ability1();
			 }
			 if(hero2.abilityk2==7||hero2.abilityk2==8){
				 hero2.ability2();
			 }
			 if(hero2.abilityk3==7||hero2.abilityk3==8){
				 hero2.ability3();
			 }
			 if(hero2.abilityk4==7||hero2.abilityk4==8){
				 hero2.ability4();
			 }
		     
			 if(hero2.state.contains(Hero.State.reflect)){
				  hero2.creflect-=1;
				  if(hero2.creflect==0){
					  hero2.state.remove(Hero.State.reflect);
				  }
				  int temp=hurt;
				  RunnableAction run = new RunnableAction();
				   DelayAction delay=Actions.delay(delay1-5);	
				   DelayAction delayplus=Actions.delay(1F);
				   run.setRunnable(new Runnable() {
				    public void run() {	
				        hero1.blood-=temp;
				        hero1.bg.cb.blood=hero1.blood;
				        hero1.bg.blo.setText((int)hero1.blood+"/"+(int)hero1.maxBlood);
				        hero1.hb.reveal(temp);
				        bloody.play(volume);
		   	    }
				}); 
				   RunnableAction run1 = new RunnableAction();
			          run1.setRunnable(new Runnable(){
					@Override
					public void run() {
	      				 stage.hero1.hb.reset();
					}  
			  });
			     
		
			   	  SequenceAction sequenceAction=Actions.sequence(delay,run,delayplus,run1);
			   	  fruits[0][0].addAction(sequenceAction);
				  hurt=0;
			}
			 if(hero2.state.contains(Hero.State.suck)){
	  			  hero2.csuck-=1;
				  if(hero2.csuck==0){
					  hero2.state.remove(Hero.State.suck);
				  }
				  hurt=-hurt;
	  		}
			 
			 
       }
       public void addFruit(){
    	   //bombList.add(fruit1);
    	   //bombList.add(fruit2);
    	   bombList.add(fruits[hero1.x][hero1.y]);
       }
    
    public void swap(CommonFruit one,CommonFruit two){
        
    	if(one.kind==4){
    		one.kind=5;
    		one.color=two.color;
    		kind=two.kind;
    	}
    	if(two.kind==4){
    		two.kind=5;
    		two.color=one.color;
    		kind=one.kind;
    	}
    	
    	//one.setPosition(one.getCol()*one.height, one.getRow()*one.width);
    	DelayAction delay=Actions.delay(delay1);
        MoveToAction action=Actions.moveTo(two.col*two.height, two.row*two.width,0.1F);
        SequenceAction sequenceAction=Actions.sequence(delay,action);
        one.addAction(sequenceAction);
        
        //two.setPosition(two.getCol()*two.height, two.getRow()*two.width);
        DelayAction delay2=Actions.delay(delay1);
        MoveToAction action2=Actions.moveTo(one.col*one.height, one.row*one.width,0.1F);
        SequenceAction sequenceAction2=Actions.sequence(delay2,action2);
        two.addAction(sequenceAction2);     
        int x=two.col;
        int y=two.row;
        CommonFruit fruit1=one;
        CommonFruit fruit2=two;
        
        fruits[fruit1.col][fruit1.row]=two;
        fruits[fruit2.col][fruit2.row]=one;
        fruits[fruit1.col][fruit1.row].col=one.col;
        fruits[fruit1.col][fruit1.row].row=one.row;
        fruits[x][y].col=x;
        fruits[x][y].row=y;
 
        delay1+=0.1;
    }
    
    public void descend(){
    	    float size=0;
    	    for(int i=0;i<ROW;i++){
    	    	for(int j=0;j<COL;j++){
    	    		if(fruits[j][i]==null){
    	    		    vanishXSet.add(j);	
    	    		}
    	    	}
    	    }
    	    for(int f:vanishXSet){
    		ArrayList<CommonFruit> col=new ArrayList<CommonFruit>();
    		for(int i=ROW-1;i>=0;i--){
    			if(fruits[f][i]!=null){
    				col.add(fruits[f][i]);
    			}
    		}
    		col.sort((CommonFruit f1,CommonFruit f2)->-Integer.compare(f1.row,f2.row));
    		//冒泡排序进行替换
    		
    		for(int i=0;i<col.size();i++){
    			
    			DelayAction delay = Actions.delay(delay1);
    			MoveToAction action=Actions.moveTo(col.get(i).col*height,(col.size()-1-i)*width,(col.get(i).row-col.size()+1+i)/ve,Interpolation.circleIn);
    			 float a=(col.get(i).row-col.size()+1+i)/ve;
    			 RunnableAction descen=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						desc.play(volume/10);
					}
    				 
    			 });
    			SequenceAction sequenceAction = Actions.sequence( delay,action,descen);
    			col.get(i).addAction(sequenceAction);
    			
    			fruits[col.get(i).col][col.size()-1-i]=col.get(i);
    			fruits[col.get(i).col][col.size()-1-i].row=col.size()-1-i;  
    			if(a>=size){
    				size=a;
    			}
    			
    		}
    		for(int i=col.size();i<ROW;i++){
    			fruits[f][i]=null;
    		}    		
    }
    	
    	 makeup();
    	}
    
    public void makeup(){
    	float size=0;
    	ColorV=new Vector<Colors>();
       	date=new Date();
       	ran=new Random(date.getTime());
       	Colors random;
       	Colors[] colors=Colors.values();
       	for(Colors color:colors){
       		ColorV.add(color);
       	}
       for(int f:vanishXSet){                                 
    	   ArrayList<Integer> al=new ArrayList<Integer>();
   		   for(int i=0;i<ROW;i++){
   			if(fruits[f][i]==null)
   				al.add(i);
   		   }
   		   for(int i=0;i<al.size();i++){ 
          	random=ColorV.get(ran.nextInt(ColorV.size()));
     		CommonFruit cf=new CommonFruit(f,al.get(i),random,0,stage);
     		cf.setPosition(f*height,(al.get(i)+al.size())*width);
     		//cf.setSize(0, 0);
     		//ScaleToAction scale=Actions.scaleTo(80, 80);
     	    MoveToAction action=Actions.moveTo(f*width,al.get(i)*height,(al.size()/ve),Interpolation.circleIn);
     	   DelayAction delay = Actions.delay(delay1);
     		 RunnableAction descen=Actions.run(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						desc.play(volume/10);
					}
 				 
 			 });
     	
			 SequenceAction sequenceAction = Actions.sequence(delay,action,descen);
     	    cf.addAction(sequenceAction);
     	    this.addActor(cf);     	    
     	    fruits[f][al.get(i)]=cf;
     	    if(al.size()/ve>=size){
     	    	size=al.size()/ve;
     	    }
        }
   		  
        	}
       delay1+=size;
       for(CommonFruit f:v){
    	   if(f.life<0){
    		   f.dispose();
    		   e.add(f);
    	   }
       }
       for(CommonFruit a:e){
    	   if(v.contains(a)){
    		   v.remove(a);
    		   this.removeActor(a);
    	   }
       }
   for(Vertical v:clearv1){
    	   if(v.life<0){
    		   v.dispose();
    		   clearv2.add(v);
    	   }
       }
       for(Vertical v:clearv2){
    	   if(clearv1.contains(v)){
    		   clearv1.remove(v);
    		   this.removeActor(v);
    	   }
       }
       for(Horizon v:clearh1){
    	   if(v.life<0){
    		   v.dispose();
    		   clearh2.add(v);
    	   }
       }
       for(Horizon v:clearh2){
    	   if(clearh1.contains(v)){
    		   clearh1.remove(v);
    		   this.removeActor(v);
    	   }
       }
       e.clear();
      clearv2.clear();
      clearh2.clear();
       System.gc();
  }
    
    public boolean vanish(){
    	boolean vanish=true;
    	ScaleToAction action1;
    	SizeToAction action;  	
    	DelayAction delay;
    	SequenceAction sequenceAction;
    	for(int i=0;i<COL;i++){
    		for(int j=0;j<ROW;j++){
    			if(fruits[i][j].kind==5){
    				  if(kind==0){
    				   addSame(fruits[i][j]);	 
			    	   action1=Actions.scaleTo(0F, 0F, vt,Interpolation.fade);     		       
				       delay = Actions.delay(delay1);
				       sequenceAction = Actions.sequence(delay,action1 );
				       fruits[i][j].vani(delay1);
				       fruits[i][j].addAction(sequenceAction);
				       CommonFruit a=fruits[i][j];
				       v.add(a);
				       fruits[i][j]=null;
				       vanish=false;
    				  }else{
    					 changeSame(fruits[i][j]);
    					 action1=Actions.scaleTo(0F, 0F, vt,Interpolation.fade);     		       
   				       delay = Actions.delay(delay1);
   				    fruits[i][j].vani(delay1);
   				       sequenceAction = Actions.sequence(delay,action1 );
   				       fruits[i][j].addAction(sequenceAction);
   				    CommonFruit a=fruits[i][j];
				       v.add(a);
   				       fruits[i][j]=null;
   				       vanish=false;
    				  }
    			}
    		}
    	}
    	
    	
    	
    	for (int i = 0; i < COL;i++) {  
            for (int j = 0; j < ROW; j++) {  
            		 if(Flag(i,j)&&fruits[i][j].add==false){
            		 ArrayList<CommonFruit> smallList=new ArrayList<CommonFruit>();
            		 this.smallList.clear();
            		 addNear(i,j);
            		 smallList=(ArrayList<CommonFruit>)this.smallList.clone();
            		 if(stage.hero1t){
            			 hcount1+=smallList.size();
            		 }else{
            			 hcount2+=smallList.size();
            		 }
            		 bigList.add(smallList);
            		 }
            	 }
    	}
    	
         if(bigList.isEmpty()&&vanish&&bombFruit2.isEmpty()&&bombFruit.isEmpty()){
     		return false;
     	}
    	
    	
    	
        for( int i=0;i<bigList.size();i++){
        	 ArrayList<CommonFruit> smallList=bigList.get(i);
        	if(checkCol(smallList)){
        		if(smallList.size()==3){ 
        			  
        		      addAction(smallList);       		  
        		}else if(smallList.size()==4){
        		     
        			  int col=smallList.get(1).col;
        			  int row=smallList.get(1).row;
        			  CommonFruit.Colors color=smallList.get(1).color;
        			  addAction(smallList);
        			  action=Actions.sizeTo(width, height, vt);
        			   delay = Actions.delay(delay1);
        			   sequenceAction=Actions.sequence(delay,action);
        			  fruits[col][row]=new CommonFruit(col,row,color,1,stage);
        			  fruits[col][row].setSize(0, 0);
        			  fruits[col][row].addAction(sequenceAction);
        			  fruits[col][row].setPosition(col*width, row*height);
        			  addActor(fruits[col][row]);        		  
        		}else if(smallList.size()>=5){
        			
        			 int col=smallList.get(2).col;
       			     int row=smallList.get(2).row;
       			     CommonFruit.Colors color=smallList.get(2).color;
       			     addAction(smallList);
       			     delay = Actions.delay(delay1);
       			  action=Actions.sizeTo(80, 80, vt);
   			         sequenceAction=Actions.sequence(delay,action);
   			         fruits[col][row]=new CommonFruit(col,row,color,4,stage);
   			         fruits[col][row].setSize(0, 0);
   			         fruits[col][row].addAction(sequenceAction);     
    			     fruits[col][row].setPosition(col*width, row*height);
    			     addActor(fruits[col][row]);     
        		}
        		
        	}else if(checkRow(smallList)){
        		
                if(smallList.size()==3){
                	
                	addAction(smallList);
        		}else if(smallList.size()==4){
        			
        		  int col=smallList.get(1).col;
      			  int row=smallList.get(1).row;
      			  CommonFruit.Colors color=smallList.get(1).color;
      			  addAction(smallList);
      			 delay = Actions.delay(delay1);
      			action=Actions.sizeTo(width, height, vt);
			         sequenceAction=Actions.sequence(delay,action);
			         fruits[col][row]=new CommonFruit(col,row,color,2,stage);
			         fruits[col][row].setSize(0, 0);
			         fruits[col][row].addAction(sequenceAction);     
      			  fruits[col][row].setPosition(col*width, row*height);
      			  addActor(fruits[col][row]);
        		}else if(smallList.size()>=5){
        		  
        	      int col=smallList.get(2).col;
      			  int row=smallList.get(2).row;
      			  CommonFruit.Colors color=smallList.get(2).color;
      			 addAction(smallList);
      			 delay = Actions.delay(delay1);
      			action=Actions.sizeTo(width, height, vt);
			         sequenceAction=Actions.sequence(delay,action);
			         fruits[col][row]=new CommonFruit(col,row,color,4,stage);
			         fruits[col][row].setSize(0, 0);
			         fruits[col][row].addAction(sequenceAction);     
   			      fruits[col][row].setPosition(col*width, row*height);
   			      addActor(fruits[col][row]);
        		}
                
        	}else{
        		
                if(smallList.size()==5){ 	
        			int col=findChange(smallList).x;
        			int row=findChange(smallList).y;
        			CommonFruit.Colors color=smallList.get(1).color;
        			addAction(smallList);   		       
        			 delay = Actions.delay(delay1);
        			 action=Actions.sizeTo(width, height, vt);
   			         sequenceAction=Actions.sequence(delay,action);
   			         fruits[col][row]=new CommonFruit(col,row,color,3,stage);
   			         fruits[col][row].setSize(0, 0);
   			         fruits[col][row].addAction(sequenceAction);     
        			fruits[col][row].setPosition(col*width, row*height);
        			addActor(fruits[col][row]);
        		}else if(smallList.size()==6){
        			                       
        			int col=findChange(smallList).x;
        			int row=findChange(smallList).y;
        			CommonFruit.Colors color=smallList.get(1).color;
        			addAction(smallList);
        			 delay = Actions.delay(delay1);
        			 action=Actions.sizeTo(width, height, vt);
   			         sequenceAction=Actions.sequence(delay,action);
   			         fruits[col][row]=new CommonFruit(col,row,color,3,stage);
   			         fruits[col][row].setSize(0, 0);
   			         fruits[col][row].addAction(sequenceAction);     
        			fruits[col][row].setPosition(col*width, row*height);
        			addActor(fruits[col][row]);
        		}else {
        			
        			int col=findChange(smallList).x;
        			int row=findChange(smallList).y;
        			CommonFruit.Colors color=smallList.get(1).color;
        			addAction(smallList);
        			 delay = Actions.delay(delay1);
        			 action=Actions.sizeTo(width, height, vt);
   			         sequenceAction=Actions.sequence(delay,action);
   			         fruits[col][row]=new CommonFruit(col,row,color,4,stage);
   			         fruits[col][row].setSize(0, 0);
   			         fruits[col][row].addAction(sequenceAction);     
        			fruits[col][row].setPosition(col*width, row*height);
        			addActor(fruits[col][row]);
        		}
        	}
        	 
        }
              if(stage.hero1t){
            	  hcount1+=bombFruit.size();
              }else{
            	  hcount2+=bombFruit.size();
              }
              ArrayList<CommonFruit> bombFruit4=(ArrayList<CommonFruit>)bombFruit2.clone();
 		     addAction(bombFruit4);
 		     while(!bombFruit.isEmpty()){
              ArrayList<CommonFruit> bombFruit3=(ArrayList<CommonFruit>)bombFruit.clone();
              bombFruit.clear();
       		  addAction(bombFruit3);
 		     }
       		  
        
        for(int i=0;i<COL;i++){
        	for(int j=0;j<ROW;j++){
        		if(fruits[i][j]!=null){
        			fruits[i][j].add=false;
        		}
        	}
       }
        
        delay1+=vt;
        bombFruit2.clear();
        vanishXSet.clear();
    	bombFruit.clear();
    	bigList.clear();
        return true;
        
    }
    
     public void changeBomb(){
    	ScaleToAction action2;
    	SizeToAction action;  	
    	DelayAction delay;
    	SequenceAction sequenceAction;
    	for(CommonFruit f:bombList){
    	int col=f.col;
		  int row=f.row;
		  CommonFruit.Colors color=f.color;
		    action2=Actions.scaleTo(0, 0, vt);
		    delay = Actions.delay(delay1);
		    action=Actions.sizeTo(width, height, vt); 
	        sequenceAction=Actions.sequence(delay,action2);
	        fruits[col][row].addAction(sequenceAction);
	        fruits[col][row]=null;
	        sequenceAction=Actions.sequence(delay,action);
	        fruits[col][row]=new CommonFruit(col,row,color,2,stage);
	        fruits[col][row].setSize(0, 0);
	        fruits[col][row].addAction(sequenceAction);     
		     fruits[col][row].setPosition(col*width, row*height);
		     addActor(fruits[col][row]);
		    
    	}
    	bombList.clear();
    }
   
    
     public void changeBomb2(){
    	ScaleToAction action2;
    	SizeToAction action;  	
    	DelayAction delay;
    	SequenceAction sequenceAction;
    	for(CommonFruit f:bombList){
    	int col=f.col;
		  int row=f.row;
		  CommonFruit.Colors color=f.color;
		    action2=Actions.scaleTo(0, 0, vt);
		    delay = Actions.delay(delay1);
		    action=Actions.sizeTo(width, height, vt);
		    
	        sequenceAction=Actions.sequence(delay,action2);
	        fruits[col][row].addAction(sequenceAction);
	        fruits[col][row]=null;
	        sequenceAction=Actions.sequence(delay,action);
	        fruits[col][row]=new CommonFruit(col,row,color,3,stage);
	        fruits[col][row].setSize(0, 0);
	        fruits[col][row].addAction(sequenceAction);     
		    fruits[col][row].setPosition(col*width, row*height);
		    addActor(fruits[col][row]);
    	}
    	bombList.clear();
    }
    
     
    
   public void addAction(ArrayList<CommonFruit> list){
	   ScaleToAction action;  	
   	   DelayAction delay;
   	   SequenceAction sequenceAction;
   	  
	   for(CommonFruit f:list){ 
		   try{
			  switch(f.kind){
			      case 0:
				       action=Actions.scaleTo(0F, 0F, vt,Interpolation.fade);     		       
				       delay = Actions.delay(delay1);
				       sequenceAction = Actions.sequence(delay,action );
				       fruits[f.col][f.row].vani(delay1);
				       fruits[f.col][f.row].
				       addAction(sequenceAction);
				       CommonFruit a=fruits[f.col][f.row];
				       v.add(a);
				       fruits[f.col][f.row]=null;
				       
				       break;
			      case 1:
			    	   addCol(f);
			    	   Vertical ver=new Vertical(f.getCol());
			    	   this.addActor(ver);
			    	   ver.move(delay1);
			    	   clearv1.add(ver);
			    	   RunnableAction woos=Actions.run(new Runnable(){

							@Override
							public void run() {
								// TODO Auto-generated method stub
								woosh.play(volume/1.5F);
							}
		 				 
		 			 });
			    	   action=Actions.scaleTo(0F, 0F, vt,Interpolation.fade);     		       
				       delay = Actions.delay(delay1);
				       fruits[f.col][f.row].vani(delay1);
				       sequenceAction = Actions.sequence(delay,action,woos);
				       fruits[f.col][f.row].addAction(sequenceAction);
				       CommonFruit a1=fruits[f.col][f.row];
				       v.add(a1);
				       fruits[f.col][f.row]=null;
				
				       break;
			      case 2:
			    	  addRow(f);
			    	   Horizon hor=new Horizon(f.getRow());
			    	   this.addActor(hor);
			    	   hor.move(delay1);
			    	   clearh1.add(hor);
			    	   action=Actions.scaleTo(0F, 0F, vt,Interpolation.fade);   
			    	   RunnableAction woos2=Actions.run(new Runnable(){

							@Override
							public void run() {
								// TODO Auto-generated method stub
								woosh.play(volume/1.5F);
							}
		 				 
		 			 });
				       delay = Actions.delay(delay1);
				       fruits[f.col][f.row].vani(delay1);
				       sequenceAction = Actions.sequence(delay,action,woos2 );
				       fruits[f.col][f.row].addAction(sequenceAction);
				       CommonFruit a2=fruits[f.col][f.row];
				       v.add(a2);
				       fruits[f.col][f.row]=null;
				     
				       break;
			      case 3:
			    	   addRec(f);
			    	   action=Actions.scaleTo(0F, 0F, vt,Interpolation.fade);     		       
				       delay = Actions.delay(delay1);
				       RunnableAction woos3=Actions.run(new Runnable(){

							@Override
							public void run() {
								// TODO Auto-generated method stub
								woosh.play(volume/1.5F);
							}
		 				 
		 			 });
				       sequenceAction = Actions.sequence(delay,action,woos3 );
				       fruits[f.col][f.row].addAction(sequenceAction);
				       fruits[f.col][f.row].vani(delay1);
				       CommonFruit a3=fruits[f.col][f.row];
				       v.add(a3);
				       fruits[f.col][f.row]=null;
				       
				       break;
			      case 4:
			    	   addSame(f);
			    	   action=Actions.scaleTo(0F, 0F, vt,Interpolation.fade);     		       
				       delay = Actions.delay(delay1);
				       sequenceAction = Actions.sequence(delay,action );
				       fruits[f.col][f.row].vani(delay1);
				       fruits[f.col][f.row].addAction(sequenceAction);
				       CommonFruit a4=fruits[f.col][f.row];
				       v.add(a4);
				       fruits[f.col][f.row]=null;
				 
				       break;
			  }
		   }catch(NullPointerException e){
			   
		   }
		  }
	   
   }
   
    public void addNear(int a,int b){
    
	   smallList.add(fruits[a][b]);
	   fruits[a][b].add=true;
	   if(a<7&&Flag(a+1,b)&&fruits[a+1][b].add==false&&fruits[a+1][b].color==fruits[a][b].color&&fruits[a+1][b]!=null){
           addNear(a+1,b);		   
	   }
	   if(a>=1&&Flag(a-1,b)&&fruits[a-1][b].add==false&&fruits[a-1][b].color==fruits[a][b].color&&fruits[a-1][b]!=null){
           addNear(a-1,b);		   
	   }
	   if(b<9&&Flag(a,b+1)&&fruits[a][b+1].add==false&&fruits[a][b+1].color==fruits[a][b].color&&fruits[a][b+1]!=null){
           addNear(a,b+1);		   
	   }
	   if(b>=1&&Flag(a,b-1)&&fruits[a][b-1].add==false&&fruits[a][b-1].color==fruits[a][b].color&&fruits[a][b-1]!=null){
           addNear(a,b-1);		   
	   }
	   
   
	   
   }
   
    public void changeSame(CommonFruit f){
    	ScaleToAction action;  	
    	   DelayAction delay;
    	   SequenceAction sequenceAction;
    	for(int i=0;i<COL;i++){
    		for(int j=0;j<ROW;j++){
    			if(fruits[i][j].color==f.color){
    				action=Actions.scaleTo(0F, 0F, vt,Interpolation.fade);     		       
				       delay = Actions.delay(delay1);
				       sequenceAction = Actions.sequence(delay,action );
				       fruits[i][j].addAction(sequenceAction);
    				fruits[i][j]=null;
    				fruits[i][j]=new CommonFruit(i,j,f.color,kind,stage);
    				addActor(fruits[i][j]);
    				if(kind==1){
    					addCol(fruits[i][j]);
    				}else if(kind==2){
    					addRow(fruits[i][j]);
    				}else if(kind==3){
    					addRec(fruits[i][j]);
    				}
    			}
    		}
    	}
    }
    
     public boolean checkCol(ArrayList<CommonFruit> list){
    	 int col=list.get(0).col;
    	 for(CommonFruit f: list){
    		 if(f.col!=col){
    			 return false;
    		 }
    	 }
    	 return true;
     }
     
     public boolean checkRow(ArrayList<CommonFruit> list){
    	 int row=list.get(0).row;
    	 for(CommonFruit f: list){
    		 if(f.row!=row){
    			 return false;
    		 }
    	 }
    	 return true;
     }
   
     public position findChange(ArrayList<CommonFruit> list){
    	 int col= findCol(list);
    	 int row=findRow(list);
 
    	 return new position(col,row);  
     }
     
    
     
     public int findCol(ArrayList<CommonFruit> list){
    	 int[] count=new int[list.size()];
    	 for(int i=0;i<count.length;i++){
    		 count[i]=0;
    	 }                                                                              
    	 for(int i=0;i<list.size();i++){
    		 for(int j=i;j<list.size();j++){
    			 if(list.get(i).col==list.get(j).col){
    				 count[i]++;
    				 count[j]++;
    			 }
    		 }
    	 }
    	 int max=0;
    	 int k=0;
    	 for(int i=0;i<count.length;i++){
    		 if(count[i]>max){
    			 max=count[i];
    			 k=list.get(i).col;
    		 }
    	 }
    	 
    	 
    	 return k;
     }
     
     
     public int findRow(ArrayList<CommonFruit> list){
    	 int[] count=new int[list.size()];
    	 for(int i=0;i<count.length;i++){
    		 count[i]=0;
    	 }
    	 for(int i=0;i<list.size();i++){
    		 for(int j=i;j<list.size();j++){
    			 if(list.get(i).row==list.get(j).row){
    				 count[i]++;
    				 count[j]++;
    			 }
    		 }
    	 }
    	 int max=0;
    	 int k=0;
    	 for(int i=0;i<count.length;i++){
    		 if(count[i]>max){
    			 max=count[i];
    			 k=list.get(i).row;
    	}
    	 }
    	 
    	 
    	 return k;
     }
     public void addCol(CommonFruit f){
    	 for(int i=0;i<ROW;i++){
    		 bombFruit.add(fruits[f.col][i]);
    	 }
     }
     
     public void addRow(CommonFruit f){
    	 for(int i=0;i<COL;i++){
    		 bombFruit.add(fruits[i][f.row]);
    	 }
     }
     public void addSame(CommonFruit f){
    	 for(int i=0;i<COL;i++){
    		 for(int j=0;j<ROW;j++){
    			 try{
    				if(fruits[i][j].color==f.color){
    					bombFruit.add(fruits[i][j]);
    				}
    			 }catch(NullPointerException e){
    				 
    			 }
    		 }
    	 }
     }
     public void addRec(CommonFruit f){
    	for(int i=f.col-1;i<=f.col+1;i++){
    		for(int j=f.row-1;j<=f.row+1;j++){
    			try{
    				bombFruit.add(fruits[i][j]);
    			}catch(ArrayIndexOutOfBoundsException e){				
    			}
    		}
    	}
    	 
     }
     public boolean near(Fruit one,Fruit two){
    	if(one.getRow()==two.getRow()&&(one.getCol()==(two.getCol()-1)||(one.getCol()==(two.getCol()+1)))){
    		return true;
    	}else if(one.getCol()==two.getCol()&&(one.getRow()==(two.getRow()-1)||(one.getRow()==(two.getRow()+1)))){
    		return true;
    	}
    	return false;
    }
     
    private boolean Flag(int i,int j){
    	return FlagROW(i,j)||FlagCOL(i,j);
    }
    private boolean FlagROW(int i,int j){
    	if(i>=2&&i<COL-2){
    		return equalColor(fruits[i-2][j],fruits[i-1][j],fruits[i][j])||equalColor(fruits[i-1][j],fruits[i][j],fruits[i+1][j])||equalColor(fruits[i][j],fruits[i+1][j],fruits[i+2][j]);
    	}else if(i==1){
    		return equalColor(fruits[i-1][j],fruits[i][j],fruits[i+1][j])||equalColor(fruits[i][j],fruits[i+1][j],fruits[i+2][j]);
    	}else if(i==0){
    		return equalColor(fruits[i][j],fruits[i+1][j],fruits[i+2][j]);
    	}else if(i==COL-2){
    		return equalColor(fruits[i-2][j],fruits[i-1][j],fruits[i][j])||equalColor(fruits[i-1][j],fruits[i][j],fruits[i+1][j]);
    	}else if(i==COL-1){
    		return equalColor(fruits[i-2][j],fruits[i-1][j],fruits[i][j]);
    	}
    	return false;
    }
    private boolean FlagCOL(int i,int j){
        if(j>=2&&j<ROW-2){
    		return equalColor(fruits[i][j-2],fruits[i][j-1],fruits[i][j])||equalColor(fruits[i][j-1],fruits[i][j],fruits[i][j+1])||equalColor(fruits[i][j],fruits[i][j+1],fruits[i][j+2]);
    	}else if(j==1){
    		return equalColor(fruits[i][j-1],fruits[i][j],fruits[i][j+1])||equalColor(fruits[i][j],fruits[i][j+1],fruits[i][j+2]);
    	}else if(j==0){
    		return equalColor(fruits[i][j],fruits[i][j+1],fruits[i][j+2]);
    	}else if(j==ROW-2){
    		return equalColor(fruits[i][j-2],fruits[i][j-1],fruits[i][j])||equalColor(fruits[i][j-1],fruits[i][j],fruits[i][j+1]);
    	}else if(j==ROW-1){
    		return equalColor(fruits[i][j-2],fruits[i][j-1],fruits[i][j]);
    	}
    	return false;
    }
    private boolean equalColor(Fruit a,Fruit b,Fruit c){
    	if(a instanceof CommonFruit&&b instanceof CommonFruit&&c instanceof CommonFruit){
    		CommonFruit one=(CommonFruit)a;
    		CommonFruit two=(CommonFruit)b;
    		CommonFruit three=(CommonFruit)c;
    	if(one.color!=null&&two.color!=null&&three.color!=null&&one.color==two.color&&one.color==three.color)
    	        return true;
    	}
    	return false;
    }
    public void initAnimation(){
        for(int i=0;i<COL;i++){
        	for(int j=0;j<ROW;j++){
        		fruits[i][j].target=j;
        		fruits[i][j].source=j+ROW;
        			fruits[i][j].setPosition(fruits[i][j].col*fruits[i][j].height, fruits[i][j].source*fruits[i][j].width);
        			MoveToAction action = Actions.moveTo(fruits[i][j].col*fruits[i][j].height,fruits[i][j].target*fruits[i][j].width, 2F,Interpolation.circle);
        			fruits[i][j].addAction(action);
        	    }
        	}
        			
        	
    	
    }
    public void dispose() {
		// TODO Auto-generated method stub
		
	}
	private boolean die(){
    	for(int i=0;i<ROW;i++){
    		for(int j=0;j<COL;j++){
    			if(!isDied(i,j)){
    				return false;
    			}
    		}
    	}
    	return true;
    }
    private boolean isDied(int i,int j){
    	Colors color=((CommonFruit)fruits[i][j]).color;
    	if((i>=1&&i<ROW-1)&&j==0){
    		if(((CommonFruit)fruits[i-1][j+1]).color==((CommonFruit)fruits[i][j]).color&&((CommonFruit)fruits[i+1][j+1]).color==((CommonFruit)fruits[i][j]).color){
    			return false;
    		}
    	}else if((i>=1&&i<ROW-1)&&j==COL-1){
    		if(((CommonFruit)fruits[i-1][j-1]).color==((CommonFruit)fruits[i][j]).color&&((CommonFruit)fruits[i+1][j-1]).color==((CommonFruit)fruits[i][j]).color){
    			return false;
    		}
    	}
    	if((j>=1&&j<COL-1)&&i==0){
    		if(((CommonFruit)fruits[i+1][j-1]).color==((CommonFruit)fruits[i][j]).color&&((CommonFruit)fruits[i+1][j+1]).color==((CommonFruit)fruits[i][j]).color){
    			return false;
    		}
    	}else if((j>=1&&j<COL-1)&&i==ROW-1){
    		if(((CommonFruit)fruits[i-1][j-1]).color==((CommonFruit)fruits[i][j]).color&&((CommonFruit)fruits[i-1][j+1]).color==((CommonFruit)fruits[i][j]).color){
    			return false;
    		}
    	}
    	if(i>=1&&i<ROW-1&&j>=1&&j<COL-1){
    		if((((CommonFruit)fruits[i+1][j-1]).color==((CommonFruit)fruits[i][j]).color&&((CommonFruit)fruits[i+1][j+1]).color==((CommonFruit)fruits[i][j]).color)||
    	      (((CommonFruit)fruits[i-1][j-1]).color==((CommonFruit)fruits[i][j]).color&&((CommonFruit)fruits[i-1][j+1]).color==((CommonFruit)fruits[i][j]).color)||
    	      (((CommonFruit)fruits[i-1][j+1]).color==((CommonFruit)fruits[i][j]).color&&((CommonFruit)fruits[i+1][j+1]).color==((CommonFruit)fruits[i][j]).color)||
    	      (((CommonFruit)fruits[i-1][j-1]).color==((CommonFruit)fruits[i][j]).color&&((CommonFruit)fruits[i+1][j-1]).color==((CommonFruit)fruits[i][j]).color)){
    			return false;
    		}
    	}
    	if(i>=1&&((CommonFruit)fruits[i-1][j]).color==color){
    		if(i==1&&j==0){
    			if(((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color){
    			return false;
    			}
    		}else if(i==1&&j==COL-1){
    			if(((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i+1][j-1]).color==color){
    				return false;
    			}
    		}else if(i==ROW-1&&j==0){
    			if(((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color){
    				return false;
    			}
    		}else if(i==ROW-1&&j==COL-1){
    			if(((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j-1]).color==color){
    				return false;
    			}
    		}else if(i==1){
    			if(((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i+1][j-1]).color==color){
    				return false;
    			}
    		}else if(i==ROW-1){
    			if(((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color||((CommonFruit)fruits[i-2][j-1]).color==color){
    				return false;
    			}
    		}else if(i==2&&j==0){
    			if(((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color){
    				return false;
    			}
    		}else if(i==2&&j==COL-1){
    			if(((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i+1][j-1]).color==color||((CommonFruit)fruits[i-3][j-1]).color==color){
    				return false;
    			}
    		}else if(i==ROW-2&&j==0){
    			if(((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color){
    				return false;
    			}
    		}else if(i==ROW-2&&j==COL-1){
    			if(((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j-1]).color==color||((CommonFruit)fruits[i+1][j-1]).color==color){
    				return false;
    			}
    		}else if(i==2){
    			if(((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color||((CommonFruit)fruits[i+1][j-1]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color){
    				return false;
    			}
    		}else if(i==ROW-2){
    			if(((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i+1][j-1]).color==color||((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j-1]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color){
    				return false;
    			}
    		}else if(j==0){
    			if(((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color){
    				return false;
    			}
    		}else if(j==COL-1){
    			if(((CommonFruit)fruits[i+1][j-1]).color==color||((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j-1]).color==color){
    				return false;
    			}
    		}else{
    			if(((CommonFruit)fruits[i+1][j-1]).color==color||((CommonFruit)fruits[i+2][j]).color==color||((CommonFruit)fruits[i-3][j]).color==color||((CommonFruit)fruits[i-2][j-1]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i-2][j+1]).color==color){
    				return false;
    			}
    		}
    	}
    	if(j>=1&&((CommonFruit)fruits[i][j-1]).color==color){
    		if(i==0&&j==1){
    			if(((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color){
    			return false;
    			}
    		}else if(i==ROW-1&&j==1){
    			if(((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i-1][j+1]).color==color){
    				return false;
    			}
    		}else if(i==0&&j==COL-1){
    			if(((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color){
    				return false;
    			}
    		}else if(i==ROW-1&&j==COL-1){
    			if(((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i-1][j-2]).color==color){
    				return false;
    			}
    		}else if(j==1){
    			if(((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i-1][j+1]).color==color){
    				return false;
    			}
    		}else if(i==COL-1){
    			if(((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color||((CommonFruit)fruits[i-1][j-2]).color==color){
    				return false;
    			}
    		}else if(i==0&&j==2){
    			if(((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color){
    				return false;
    			}
    		}else if(i==ROW-1&&j==2){
    			if(((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i-1][j+1]).color==color||((CommonFruit)fruits[i-1][j-3]).color==color){
    				return false;
    			}
    		}else if(i==0&&j==COL-2){
    			if(((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color){
    				return false;
    			}
    		}else if(i==ROW-1&&j==COL-2){
    			if(((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i-1][j-2]).color==color||((CommonFruit)fruits[i-1][j+1]).color==color){
    				return false;
    			}
    		}else if(j==2){
    			if(((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color||((CommonFruit)fruits[i-1][j+1]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color){
    				return false;
    			}
    		}else if(j==COL-2){
    			if(((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i-1][j+1]).color==color||((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i-1][j-2]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color){
    				return false;
    			}
    		}else if(i==0){
    			if(((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color){
    				return false;
    			}
    		}else if(i==ROW-1){
    			if(((CommonFruit)fruits[i-1][j+1]).color==color||((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i-1][j-2]).color==color){
    				return false;
    			}
    		}else{
    			if(((CommonFruit)fruits[i-1][j+1]).color==color||((CommonFruit)fruits[i][j+2]).color==color||((CommonFruit)fruits[i][j-3]).color==color||((CommonFruit)fruits[i-1][j-2]).color==color||((CommonFruit)fruits[i+1][j+1]).color==color||((CommonFruit)fruits[i+1][j-2]).color==color){
    				return false;
    			}
    		}
    	}
    	return true;
    }
    public void addActor(){
    	for(int i=0;i<COL;i++){
       		for(int j=0;j<ROW;j++){
       	        addActor(fruits[i][j]);
       		}
    	}

    }

    
    public void cumputerAI(){
    	
    	for(int i=0;i<ROW;i++){
    		for(int j=0;j<COL-1;j++){
    			try{
    				if(fruits[j][i].color==fruits[j+1][i].color){
    				     try{
    				    	 if(fruits[j+3][i].color==fruits[j][i].color){
    				    		 fruit1=fruits[j+2][i];
    				    		 fruit2=fruits[j+3][i];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[j-2][i].color==fruits[j][i].color){
    				    		 fruit1=fruits[j-2][i];
    				    		 fruit2=fruits[j-1][i];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[j-1][i+1].color==fruits[j][i].color){
    				    		 fruit1=fruits[j-1][i+1];
    				    		 fruit2=fruits[j-1][i];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[j-1][i-1].color==fruits[j][i].color){
    				    		 fruit1=fruits[j-1][i-1];
    				    		 fruit2=fruits[j-1][i];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[j+2][i-1].color==fruits[j][i].color){
    				    		 fruit1=fruits[j+2][i-1];
    				    		 fruit2=fruits[j+2][i];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[j+2][i+1].color==fruits[j][i].color){
    				    		 fruit1=fruits[j+2][i];
    				    		 fruit2=fruits[j+2][i+1];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				}
    			}
    	        catch(ArrayIndexOutOfBoundsException e){
    	        	
    	        }
    		}
    	}
    	for(int i=0;i<COL;i++){
    		for(int j=0;j<ROW-1;j++){
    			try{
    				if(fruits[i][j].color==fruits[i][j+1].color){
    				     try{
    				    	 if(fruits[i][j+3].color==fruits[i][j].color){
    				    		 fruit1=fruits[i][j+2];
    				    		 fruit2=fruits[i][j+2];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[i][j-2].color==fruits[i][j].color){
    				    		 fruit1=fruits[i][j-2];
    				    		 fruit2=fruits[i][j-1];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[i+1][j-1].color==fruits[i][j].color){
    				    		 fruit1=fruits[i+1][j-1];
    				    		 fruit2=fruits[i][j-1];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[i-1][j-1].color==fruits[i][j].color){
    				    		 fruit1=fruits[i-1][j-1];
    				    		 fruit2=fruits[i][j-1];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[i-1][j+2].color==fruits[i][j].color){
    				    		 fruit1=fruits[i-1][j+2];
    				    		 fruit2=fruits[i][j+2];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				     try{
    				    	 if(fruits[i+1][j+2].color==fruits[i][j].color){
    				    		 fruit1=fruits[i][j+2];
    				    		 fruit2=fruits[i+1][j+2];
    				    		 return;
    				    	 }
    				     }catch(ArrayIndexOutOfBoundsException e){
    				    	 
    				     }
    				}
    			}
    	        catch(ArrayIndexOutOfBoundsException e){	
    	        }
    		}
    	}
    	fruit1=fruits[4][5];
    	fruit2=fruits[4][6];
   }
    
 }

