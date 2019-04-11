package stage;

import java.util.Date;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

import Hero.BladeMaster;
import actor.CusButton;

public class choicestage2 extends Stage{
    //界面设计初步定为11个英雄334排布
	//         ***      
    //         ****         
    //        ****
	//左右两边各有一个相框，上面有文字说明自己放选择的英雄名称
    //选择完毕之后下面有pk按钮，直接选择就可以
    //先设计button类仍然采用cusbutton?  对于这个button的需求，移动到button上有文字显示出来，点击之后又出发效果，好像
	//上面设置一个label 请选择您的英雄：字体要注意
	//所以button直接采用cusbutton     点击之后代表确定，直接回进
     Button hero1;
     Button hero2;
     Button hero3;
     Button hero4;
     Button hero5;
     Button hero6;
     Button hero7;
     Button hero8;
     Button hero9;
     Button hero10;
     Button hero11;
     public Date date=new Date();	     
     public Random ran=new Random(date.getTime());
     Label label1;
     Label label2;
     Label label3;
     Button sure;
     Sound sound;
     Texture background;
    public  GameScreen screen;
    public boolean visible;
    public SpriteBatch batch;
     public choicestage2(GameScreen screen,Viewport viewport){
    	 super(viewport);
    	 this.screen=screen;
    	 batch=new SpriteBatch();
    	 background=new Texture("hero/bjj.png");
    	 sound=Gdx.audio.newSound(new FileHandle("hero/hero.wav"));
    	 screen.mood=true;
    	 FileHandle defaultFont = Gdx.files.internal("input1/fff.fnt");;
 	    Label.LabelStyle style2=new Label.LabelStyle();
         style2.font=new BitmapFont(defaultFont);
    	 label1=new Label("",style2);
    	 label2=new Label("",style2);
    	 label2=new Label("",style2);
    	
    	Button.ButtonStyle style = new Button.ButtonStyle();           
 	    style.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/hero1black.png")));
 	    style.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/hero1Re.png")));
 	    hero1=new Button(style);
 	    
 	   Button.ButtonStyle style22 = new Button.ButtonStyle();           
	    style22.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/FarSeerblack.png")));
	    style22.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/Farseer.png")));
	  
	    
	    Button.ButtonStyle style3 = new Button.ButtonStyle();           
 	    style3.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/emolieshou-black.png")));
 	    style3.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/emolieshou.png")));
 	   hero2=new Button(style3);
 	    hero3=new Button(style22);
 	     
 	    Button.ButtonStyle style4 = new Button.ButtonStyle();           
	    style4.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/POMblack.png")));
	    style4.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/POM.png")));
	    hero4=new Button(style4);
	    Button.ButtonStyle style5 = new Button.ButtonStyle();           
 	    style5.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/dafashiblack.png")));
 	    style5.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/dafashi.png")));
 	    
 	   Button.ButtonStyle style6= new Button.ButtonStyle();           
	    style6.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/shengqishi-black.png")));
	    style6.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/shengqishi.png")));
	    
	    Button.ButtonStyle style7 = new Button.ButtonStyle();           
 	    style7.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/DK-black.png")));
 	    style7.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/DK.png")));
 	    hero6=new Button(style7);
 	    hero7=new Button(style6);
 	    Button.ButtonStyle style8 = new Button.ButtonStyle();           
	    style8.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/kongjublack.png")));
	    style8.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/kongjumowang.png")));
	    hero8=new Button(style8);
	    Button.ButtonStyle style9 = new Button.ButtonStyle();           
 	    style9.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/hero2Re.png")));
 	    style9.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/hero2.png")));
 	   hero5=new Button(style9);
 	    hero9=new Button(style5);
 	   Button.ButtonStyle style10 = new Button.ButtonStyle();           
	    style10.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/xiongmaoblack.png")));
	    style10.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/xiongmao.png")));
	    hero10=new Button(style10);
	  
	    
    	 hero1.setPosition(100, 600);
    	 hero2.setPosition(500, 600);
    	 hero3.setPosition(950, 600);
    	 hero4.setPosition(1400, 600);
    	 hero5.setPosition(1800, 600);
    	 hero6.setPosition(100, 0);
    	 hero7.setPosition(500, 0);
    	 hero8.setPosition(950, 0);
    	 hero9.setPosition(1400, 0);
    	 hero10.setPosition(1800, 0);
    	 
    	 hero1.setSize(400, 600);
         hero2.setSize(500, 600);
         hero3.setSize(400, 600);
         hero4.setSize(400, 600);
         hero5.setSize(400, 600);
         hero6.setSize(400, 600);
         hero7.setSize(400, 600);
         hero8.setSize(400, 600);
         hero9.setSize(400, 600);
         hero10.setSize(400, 600);
    	 hero1.addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.hero1="BladeMaster";
    		    choosehero2();
    		    initGame();
    		}
    		 public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                 sound.play();
              }
    	 });
    	 hero3.addListener(new ClickListener(){
     		public void clicked(InputEvent e,float x,float y){
     			screen.hero1="FarSeer";
     		    choosehero2();
     		   initGame();
     		}
     		 public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                 sound.play();
              }
     	 });
    	 
    	 hero2.addListener(new ClickListener(){
      		public void clicked(InputEvent e,float x,float y){
      			screen.hero1="DemonHunter";
      		    choosehero2();
      		  initGame();
      		}
      		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                sound.play();
             }
      	 });
    	 
    	 hero4.addListener(new ClickListener(){
       		public void clicked(InputEvent e,float x,float y){
       			screen.hero1="POM";
       		    choosehero2();
       		 initGame();
       		}
       		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                sound.play();
             }
       	 });
    	 hero9.addListener(new ClickListener(){
        		public void clicked(InputEvent e,float x,float y){
        			screen.hero1="ArchMage";
        		    choosehero2();
        		    initGame();
        		}
        		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                    sound.play();
                 }
        	 });
    	 hero7.addListener(new ClickListener(){
     		public void clicked(InputEvent e,float x,float y){
     			screen.hero1="Paladin";
     		    choosehero2();
     		   initGame();
     		}
     		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                sound.play();
             }
     	 });
    	 hero6.addListener(new ClickListener(){
      		public void clicked(InputEvent e,float x,float y){
      			screen.hero1="DeathKnight";
      		    choosehero2();
      		  initGame();
      		}
      		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                sound.play();
             }
      	 });
    	 hero8.addListener(new ClickListener(){
       		public void clicked(InputEvent e,float x,float y){
       			screen.hero1="DreadLord";
       		    choosehero2();
       		 initGame();
       		}
       		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                sound.play();
             }
       	 });
    	 hero5.addListener(new ClickListener(){
        		public void clicked(InputEvent e,float x,float y){
        			screen.hero1="FireLord";
        		    choosehero2();
        		    initGame();
        		}
        		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                    sound.play();
                 }
        	 });
    	 hero10.addListener(new ClickListener(){
     		public void clicked(InputEvent e,float x,float y){
     			screen.hero1="PandaBrewmaster";
     		    choosehero2();
     		   initGame();
     		}
     		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                sound.play();
             }
     	 });
    	
    	 this.addActor(hero1);
    	 this.addActor(hero2);
    	 this.addActor(hero3);
    	 this.addActor(hero4);
    	 this.addActor(hero5);
    	 this.addActor(hero6);
    	 this.addActor(hero7);
    	 this.addActor(hero8);
    	 this.addActor(hero9);
    	 this.addActor(hero10);	
     }
     public void choosehero2(){
    	 int k=ran.nextInt(3);
    	  
    	 switch(k){
    	 case 0:
    		 screen.hero2="FireLord";
    		 break;
    	 case 1:
    		 screen.hero2="PandaBrewmaster";
    		 break;
    	 case 2:
    		 screen.hero2="FarSeer";
    		 break;
    	 case 3:
    		 screen.hero2="DemoHunter";
    		 break;
    	 case 4:
    		 screen.hero2="DreadLord";
    		 break;
    	 case 5:
    		 screen.hero2="FarSeer";
    		 break;
    	 case 6:
    		 screen.hero2="FireLord";
    		 break;
    	 case 7:
    		 screen.hero2="FireLord";
    		 break;
    	 case 8:
    		 screen.hero2="Paladin";
    		 break;
    	 case 9:
    		 screen.hero2="PandaBrewmaster";
    		 break;
    	 case 10:
    		 screen.hero2="POM";
    		 break;  
    	 }
     }
     
     public void initGame(){
    	 this.visible=false;
    	 screen.game=new assetgame(screen,"","");
    	 screen.game.visible=true;
     }
     
     public void draw(){
    	 batch.begin();
    	// batch.draw(background, 0, 0,background.getWidth()*(float)1.5, background.getHeight()*(float)1.5);
    	 batch.end();
    	 super.draw();
     }
}             


