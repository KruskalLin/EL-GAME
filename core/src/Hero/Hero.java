package Hero;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Disposable;
import com.game.GameScreen;

import actor.BarGroup;
import actor.Blood;
import actor.CusButton;
import actor.Light;
import actor.StateGroup;
import stage.GameStage;

                                         
public abstract class Hero extends Group implements Disposable{
	
	
	
	
	
	     public enum State{                                    
	     	 poisoned,burned,dizzy,frozen,numb,curse,silent,angry,invisible,dodge,suck,crit,crazy,reflect,defence
	     }
	     public float money;
	     public float xp;
	     public float a,b;
         public Date date=new Date();	     
	     public Random ran=new Random(date.getTime());
	     protected Image image;                                 
	     protected int width,height;        
	     public BarGroup bg;
	     public Blood hb;
	     public int abilityk1;
	     public int abilityk2;
	     public int abilityk3;
	     public int abilityk4;
	     
	     public StateGroup sg;
	     //说明每个技能的种类，如果是1，说明需要在棋盘上释放，如果是2，说明是无须在棋盘上释放的技能并且一个回合，如果是3，就是多个回合的，如果是
	     //如果是4，就是固有的技能,
	     //但是固有技能触发条件多样，再次进行分类，4.交换时触发5.伤害时触发 6.任意时间触发 7.被造成伤害的时候触发8.伤害和被造成
	     
	     public boolean abcool1=false;
	     public boolean abcool2=false;
	     public boolean abcool3=false;
	     public boolean abcool4=false;
	     
	    public Sound what1;
	 	public Sound what2;
	 	public Sound what3;
	 	public Sound what4;
	 	public Sound Yes1;
	 	public Sound Yes2;
	 	public Sound Yes3;
	 	public Sound Yes4;
	 	public Sound attack1;
		public Sound attack2;
		public Sound attack3;
	    public Sound war;
	     public int abround1=0;
	     public int abround2=0;
	     public int abround3=0;
	     public int abround4=0;
	     
	     public int cooltime1;
	     public int cooltime2;
	     public int cooltime3;
	     public int cooltime4;
	     
	     public int continue1;
	     public int continue2;
	     public int continue3;
	     public int continue4;
	     
	     public boolean run1=false;
	     public boolean run2=false;
	     public boolean run3=false;
	     public boolean run4=false;
	    
	     public CusButton button1;
	     public CusButton button2;
	     public CusButton button3;
	     public CusButton button4;                                
	     //技能button
	     protected Image skill1;
	     protected Image skill2;
	     protected Image skill3;
	     protected Image skill4;
	     
	     public int cpoisoned=0;
	     public int cburned=0;
	     public int cdizzy=0;
	     public int cfrozen=0;
	     public int cnumb=0;
	     public int ccurse=0;
	     public int csilent=0;
	     public int cflash=0;
	     public int cangry=0;
	     public int cdodge=0;
	     public int csuck=0;
	     public int ccrit=0;
	     public int ccrazy=0;
	     public int cinvisible=0;
	     public int creflect=0;
	     public int cdefence=0;
	     
	     
	     //特效image
	     //道具栏加号的引用
	     //人物属性面板的使用
	                     
	     public float maxBlood;
	     public float maxMagic;
	     public float blood;
	     public float magic;
	     public float attack;
	     public float defence;
	     public float force;
	     public float quick;
	     public float dforce;
	     public float dquick;
	     public float dintellience;
	     
	     public ArrayList<State> state;
	     public float intelligence;
	     public int rank;
	     public int abrank1;
	     public int abrank2;
	     public int abrank3;
	     public int abrank4;
	     //各种属性
	     public int x;
	     public int y;
	    //适应消除性技能
	     protected Image skillpanel;
	     protected CusButton tool;
	     protected CusButton property;
	     protected  boolean reverse;
	     
	     protected Image blackground;
	     
	     protected TextField tf;
	     
	     public GameStage stage;   
	     
	     public boolean sphere=false;
	    public Pixmap pm1;
	 	public Pixmap pm2;
	 	
	 	public Light light;
	     
	     public Hero(){
	    	 
	     }
	     public Hero(GameStage stage,boolean reverse){
	    	 this.reverse=reverse;
	    	 this.stage=stage;
	    	 state=new ArrayList<State>();
	    	 if(!reverse){
	    			this.setPosition(0,0);
	    		}else{
	    			this.setPosition(1504,0);
	    		}
	    	 hb=new Blood(reverse);
	    	 light=new Light(reverse);
	    	 blackground =new Image(GameScreen.assetManager2.get(("blackground.png"),Texture.class));
		       blackground.setVisible(false);
	    	 if(!reverse)
	    	  tool=new CusButton(20, 200, GameScreen.assetManager2.get(("tools1.png"),Texture.class), GameScreen.assetManager2.get(("tools_over.png"),Texture.class), GameScreen.assetManager2.get(("tools_down.png"),Texture.class), null,GameScreen.assetManager2.get(("textground.png"),Texture.class), "Tool",reverse,0);
	    			 else
	    	 tool=new CusButton(704-80-20, 200, GameScreen.assetManager2.get(("tools1.png"),Texture.class), GameScreen.assetManager2.get(("tools_over.png"),Texture.class), GameScreen.assetManager2.get(("tools_down.png"),Texture.class), null,GameScreen.assetManager2.get(("textground.png"),Texture.class), "Tool",reverse,0);
	    					
	    	 if(!reverse)
			property=new CusButton(20, 300, GameScreen.assetManager2.get(("property.png"),Texture.class), GameScreen.assetManager2.get(("property_black.png"),Texture.class), GameScreen.assetManager2.get(("property_black.png"),Texture.class),null, GameScreen.assetManager2.get(("textground.png"),Texture.class), "Property",reverse,0);
					 else
			 property=new CusButton(704-80-20, 300, GameScreen.assetManager2.get(("property.png"),Texture.class), GameScreen.assetManager2.get(("property_black.png"),Texture.class), GameScreen.assetManager2.get(("property_black.png"),Texture.class), null,GameScreen.assetManager2.get(("textground.png"),Texture.class), "Tool",reverse,0);
							
	    	
	    	 
	    	  if(reverse){
		    	   skillpanel=new Image(GameScreen.assetManager2.get(("SkillPanelRe.png"),Texture.class));
		    	   skillpanel.setPosition(704-skillpanel.getWidth(), 520);
		       }else{
		    	   skillpanel=new Image(GameScreen.assetManager2.get(("SkillPanel.png"),Texture.class));   
		    	   skillpanel.setPosition(0, 520);
		       }
	    	 
	    	  rank=1;
	    	  abrank1=1;
	    	  abrank2=1;
	    	  abrank3=1;
	    	  abrank4=1;
	    	  state=new ArrayList<State>();
	          sg=new StateGroup(state,reverse);
		 
	     }
	     public abstract boolean ability1();
	     public abstract boolean ability2();
	     public abstract boolean ability3();
	     public abstract boolean ability4();
	     public abstract boolean AI();
	     public void act(float delta){
	    	 super.act(delta);
	     }
	     
	     @Override
	     public void dispose(){
	    	 
	     }

	     
	     
}
