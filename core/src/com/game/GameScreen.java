package com.game;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.logging.FileHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import Hero.Hero;
import actor.Fruit;
import stage.GameStage;
import stage.MyStage;

import stage.assetchoice;
import stage.assetchoice2;
import stage.assetfinal;
import stage.assetgame;
import stage.assetmy;
import stage.assetsand;
import stage.assetsnow;
import stage.assetstart;
import stage.choiceStage;
import stage.choicestage2;
import stage.finalMap;
import stage.introStage;
import stage.sandMap;
import stage.shopStage;
import stage.snowMap;
import stage.startStage;
import stage.startStage2;
import storystage.chatStage;
import storystage.chatstage2;
import storystage.chatstage3;
import storystage.chatstage4;
import storystage.chatstage5;
import storystage.chatstage6;
import storystage.chatstage7;
import storystage.storyStage1;
import storystage.storystage2;
import storystage.storystage3;
import storystage.storystage4;
import widget.GameSet;


public class GameScreen implements Screen{
	public Music music;
	public Sound sound;
	public static float volume1=(float)0.5;
	public static float volume2=(float)0.5;
       public GameStage gs;
       public choiceStage cstage;
       private MainGame mainGame;
       public MyStage stage;
       public finalMap finalmap;
       public snowMap snowmap;
       public sandMap sandmap;
       public introStage instage;
       public static AssetManager assetManager ; 
       public static AssetManager assetManager2;
       public assetchoice choice;
       public assetgame game;
       public assetsnow snow;
       public assetmy my;
       public assetsand sand;
       public assetfinal afinal;
       public storyStage1 story;
       public storystage2 story2;
       public storystage3 story3;
       public storystage4 story4;
       public chatStage chat;
       public chatstage2 chat2;
       public chatstage3 chat3;
       public chatstage4 chat4;
       public chatstage5 chat5;
       public chatstage6 chat6;
       public chatstage7 chat7;
       public shopStage shop;
       public startStage2 start;
       public assetstart astart;
       public choicestage2 cstage2;
       public assetchoice2 achoice2;
       Pixmap pm; 
       public boolean isStore;
       public String hero1;
       public String hero2;
       public  boolean mood;
 //      力量：27 + 1.9	攻击力：49
      // 敏捷：29 + 2.9	初始血量：530  初始魔法:182
       //智力：14 + 1.4	护甲：4.0
       //此处需要有人物必须要有的属性 
     public  final int maxrank=15;;
     public final int maxabrank=3;       
     public  float maxBlood=1060;
     public  float blood=1060;
     public  float magic=182;
     public  float maxMgic=182;
     public  float XP=0;
     public float maxXP=500;
     public int rank=1;
     public int abrank1=1;
     public int abrank2=1;
     public int abrank3=1;
     public int abrank4=1;
     public float attack=49;
     public float defence=4;
     public float force=27;
     public float quick=29;
     public float intelligence=14;
     public float dforce=(float)1.9;
     public float dquick=(float)2.9;
     public float dintelligence=(float)1.4;       
     public int money=999;
     public int tool1c=0;
     public int tool2c=0;
     public int tool3c=0;
     public int tool4c=0;
     public int tool5c=0;
     public int tool6c=0;
     public int tool7c=0;
     public int tool8c=0;
     public int tool9c=0;
     public int tool10c=0; 
     public String map="my";
     public float rox;
     public float roy;
     FileHandle file;
     String data;
     String[] data2;
                                         
                                 
     //下面是关于剧情和人物必须存储的部分        
     public boolean ArchMage;         
     public boolean BladeMaster;
     public boolean DeathKnight;
     public boolean DemonHunter;
     public boolean DreadLord;
     public boolean FarSeer;
     public boolean FireLord;
     public boolean NagaSeaWitch;
     public boolean Paladin;
     public boolean PandaBrewmaster;
     public boolean POM;
     public boolean DemonHunter2;
     public boolean FarSeer2;
     public boolean Paladin2;
     public boolean PandaBrewmaster2;
     public boolean POM2;
     public boolean mystory1;
     public boolean mystory2;
     public boolean mystory31;
     public boolean mystory32;
     public boolean mystory33;
     public boolean mystory41;
     public boolean mystory42;
     public boolean mystory43;
     public boolean mystory5;
     public boolean mystory6;
    public  boolean sandstory1;
    public boolean sandstory2;
    public boolean snowstory;
    public boolean finalstory1;
    public boolean finalstory2;
    public boolean finalstory3;
     
     
     
      //下面写18个arraylist,用来存放每个地图上的小怪
      public ArrayList<position> myro1h;
      public ArrayList<position> myro1v;
      public ArrayList<position> myro2h;
      public ArrayList<position> myro2v;
      public ArrayList<position> myro3h;
      public ArrayList<position> myro3v;
      public ArrayList<position> sandro1h;
      public ArrayList<position> sandro1v;
      public ArrayList<position> sandro2h;
      public ArrayList<position> sandro2v;
      public ArrayList<position> sandro3h;
      public ArrayList<position> sandro3v;
      public ArrayList<position> finalro1h;
      public ArrayList<position> finalro1v;
      public ArrayList<position> finalro2h;
      public ArrayList<position> finalro2v;
      public ArrayList<position> finalro3h;
      public ArrayList<position> finalro3v;
      
      public boolean initmy;
      public boolean initsand;
      public boolean initsnow;
      public boolean initfinal;
      public SpriteBatch batch;
      public GameScreen(MainGame mainGame) {
    	  //下面在这里初始化那些arraylist
    	  batch=new SpriteBatch();
    	  myro1h=new ArrayList<position>();
    	  myro1v=new ArrayList<position>();
    	  myro2h=new ArrayList<position>();
    	  myro2v=new ArrayList<position>();
    	  myro3h=new ArrayList<position>();
    	  myro3v=new ArrayList<position>();
    	  sandro1h=new ArrayList<position>();
    	  sandro1v=new ArrayList<position>();
    	  sandro2h=new ArrayList<position>();
    	  sandro2v=new ArrayList<position>();
    	  sandro3h=new ArrayList<position>();
    	  sandro3v=new ArrayList<position>();
    	  finalro1h=new ArrayList<position>();
    	  finalro1v=new ArrayList<position>();
    	  finalro2h=new ArrayList<position>();
    	  finalro2v=new ArrayList<position>();
    	  finalro3h=new ArrayList<position>();
    	  finalro3v=new ArrayList<position>();
    	   assetManager=new AssetManager();
    	   assetManager2=new AssetManager();
    	  this.mainGame=mainGame;
    	   pm = new Pixmap(Gdx.files.internal("hand.png"));
		   Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0));
		   // chat7=new chatstage7(new StretchViewport(2208, 1242),null);
		   //chat7.visible=true;
		   astart=new assetstart(this);
    	   astart.visible=true;
            
      } 
       public void initmain2(){
    	   start.dispose();
    	   start=null;
    	   System.gc();
    	   file=Gdx.files.local("store");
    	   data=file.readString();
    	   data2=data.split("\n");
    	   initData();
    	  
    	   if(map.equals("my")){
    		   my=new assetmy(this);
	           my.visible=true; 
    	   }
    	   if(map.equals("sand")){
    		   sand=new assetsand(this);
	           sand.visible=true; 
    	   }
    	   if(map.equals("snow")){
    		   snow=new assetsnow(this);
	           snow.visible=true; 
    	   }
    	   if(map.equals("final")){
    		   afinal=new assetfinal(this);
	           afinal.visible=true; 
    	   }
       }
       public void initmain(){
    	   start.dispose();
    	   start=null;
    	   System.gc();
    	   file=Gdx.files.local("start");
    	   data=file.readString();
    	   data2=data.split("\n");
    	   initData();
    	   
    	   my=new assetmy(this);
           my.visible=true; 
       }
       public void initchoice2(){
    	  cstage2=new choicestage2(this,new StretchViewport(2208, 1242));
          cstage2.visible=true;
 		   Gdx.input.setInputProcessor(cstage2);
      }
       public void initchoice(){
    	   cstage=new choiceStage(this,new StretchViewport(2208, 1242));
           cstage.visible=true;
  		   Gdx.input.setInputProcessor(cstage);
       }
       public void initmy(){
    	   stage=new MyStage(this,new StretchViewport(2208, 1242));
    	   stage.visible=true;
    	   Gdx.input.setInputProcessor(stage);
       }
       public void initsnow(){
    	   snowmap=new snowMap(this,new StretchViewport(2208, 1242));
    	   snowmap.visible=true;
    	   Gdx.input.setInputProcessor(snowmap);
       }
       public void initsand(){
    	   sandmap=new sandMap(this,new StretchViewport(2208, 1242));
    	   sandmap.visible=true;
    	   Gdx.input.setInputProcessor(sandmap);
       }
       public void initfinal(){
    	   finalmap=new finalMap(this,new StretchViewport(2208, 1242));
    	   finalmap.visible=true;
    	   Gdx.input.setInputProcessor(finalmap);
       }
       public void initgame(String khero2,String restage){
    	   gs=new GameStage(new StretchViewport(2208, 1242),batch,this,khero2,restage,mood);
    	   GameStage.visible=true;
    	   Gdx.input.setInputProcessor(gs);
       }
       @Override
       public void dispose () {
   		if (gs != null) {
               gs.dispose();
           }
   		
   	}
       
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
	     	Gdx.gl.glClearColor(0, 0, 0, 0);
   		    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
   		    
   		    if(snowmap!=null)
   		    	if(snowmap.visible){
   		    		snowmap.act();
   		    		snowmap.draw();
   		    	}
   		
   		    
   		    if(stage!=null)
   	       if(stage.visible){
   	    	   Gdx.input.setInputProcessor(stage);
   	    	   stage.act();
   	    	   stage.draw();
   	       }
   		 if(instage!=null)
     	       if(instage.visible){
     	    	   Gdx.input.setInputProcessor(stage);
     	    	   instage.act();
     	    	   instage.draw();
     	       }
   		    
   	       if(gs!=null)
   	       if(GameStage.visible){
   	    	   Gdx.input.setInputProcessor(gs);
   	    	if(gs!=null)
               gs.act();
   	    	if(gs!=null)
               gs.draw();
   	       }
   	       if(finalmap!=null)
   	       if(finalmap.visible){
	    	Gdx.input.setInputProcessor(finalmap);
            finalmap.act();
            finalmap.draw();
	       }
   	    if(cstage!=null)
    	       if(cstage.visible){
 	         	Gdx.input.setInputProcessor(cstage);
               cstage.act();
               cstage.draw();
    	       }    
   	 if(sandmap!=null)
	     if(sandmap.visible){
         Gdx.input.setInputProcessor(sandmap);
         sandmap.act();
         sandmap.draw();
	       }
   	if(sand!=null)
	     if(sand.visible){
        Gdx.input.setInputProcessor(sand);
        sand.act();
        sand.draw();
	       }
   	if(snow!=null)
	     if(snow.visible){
       Gdx.input.setInputProcessor(snow);
       snow.act();
       snow.draw();
	   }
   	if(afinal!=null)
	     if(afinal.visible){
      Gdx.input.setInputProcessor(afinal);
      afinal.act();
      afinal.draw();
	   }
   	if(my!=null)
	     if(my.visible){
     Gdx.input.setInputProcessor(my);
     my.act();
     my.draw();
	   }
   	if(choice!=null)
	     if(choice.visible){
    Gdx.input.setInputProcessor(choice);
    choice.act();
    choice.draw();
	   }
   	if(game!=null)
	     if(game.visible){
    Gdx.input.setInputProcessor(game);
    game.act();
    game.draw();
	   }
	if(story!=null)
	     if(story.visible){
	    
	    Gdx.input.setInputProcessor(story);
   story.act();
   story.draw();
	   }
	if(story2!=null)
	     if(story2.visible){
	    
	    Gdx.input.setInputProcessor(story2);
  story2.act();
  story2.draw();
	   }
	if(story3!=null)
	     if(story3.visible){
	    
	    Gdx.input.setInputProcessor(story3);
  story3.act();
  story3.draw();
	   }
	if(story4!=null)
	     if(story4.visible){
	    
	    Gdx.input.setInputProcessor(story4);
  story4.act();
  story4.draw();
	   }
	if(shop!=null)
	     if(shop.visible){
	    
	    Gdx.input.setInputProcessor(shop);
     shop.act();
     shop.draw();
	   }
	if(start!=null)
	     if(start.visible){
	    Gdx.input.setInputProcessor(start);
    start.act();
    start.draw();
	   }
	if(astart!=null)
	     if(astart.visible){
	    Gdx.input.setInputProcessor(astart);
   astart.act();
   astart.draw();
	   }
	if(cstage2!=null)
	     if(cstage2.visible){
	    Gdx.input.setInputProcessor(cstage2);
  cstage2.act();
  cstage2.draw();
	   }
	if(achoice2!=null)
	     if(achoice2.visible){
	    Gdx.input.setInputProcessor(achoice2);
 achoice2.act();
 achoice2.draw();
	   }
	
	if(chat!=null)
	     if(chat.visible){
	    Gdx.input.setInputProcessor(chat);
chat.act();
chat.draw();
	   }
	if(chat2!=null)
	     if(chat2.visible){
	    Gdx.input.setInputProcessor(chat2);
chat2.act();
chat2.draw();
	   }
	if(chat3!=null)
	     if(chat3.visible){
	    Gdx.input.setInputProcessor(chat3);
chat3.act();
chat3.draw();
	   }
	
	if(chat4!=null)
	     if(chat4.visible){
	    Gdx.input.setInputProcessor(chat4);
chat4.act();
chat4.draw();
	   }
	if(chat5!=null)
	     if(chat5.visible){
	    Gdx.input.setInputProcessor(chat5);
chat5.act();
chat5.draw();
	   }
	if(chat6!=null)
	     if(chat6.visible){
	    Gdx.input.setInputProcessor(chat6);
chat6.act();
chat6.draw();
	   }
	
	if(chat7!=null)
	     if(chat7.visible){
	    Gdx.input.setInputProcessor(chat7);
chat7.act();
chat7.draw();
	   }
   	 
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	
    public void initData(){  
    	 rank=Integer.parseInt(data2[0]);
         abrank1=Integer.parseInt(data2[1]);
         abrank2=Integer.parseInt(data2[2]);
         abrank3=Integer.parseInt(data2[3]);
         abrank4=Integer.parseInt(data2[4]);
         blood=Float.parseFloat(data2[5]);
         maxBlood=Float.parseFloat(data2[6]);
         magic=Float.parseFloat(data2[7]);
         maxMgic=Float.parseFloat(data2[8]);
         XP=Float.parseFloat(data2[9]);
         maxXP=Float.parseFloat(data2[10]);
          attack=Float.parseFloat(data2[11]);
          defence=Float.parseFloat(data2[12]);
          force=Float.parseFloat(data2[13]);
          intelligence=Float.parseFloat(data2[14]);
          quick=Float.parseFloat(data2[15]);
          money=Integer.parseInt(data2[16]);
          tool1c=Integer.parseInt(data2[17]);
          tool2c=Integer.parseInt(data2[18]);
          tool3c=Integer.parseInt(data2[19]);
          tool4c=Integer.parseInt(data2[20]);
          tool5c=Integer.parseInt(data2[21]);
          tool6c=Integer.parseInt(data2[22]);
          tool7c=Integer.parseInt(data2[23]);
          tool8c=Integer.parseInt(data2[24]);
          tool9c=Integer.parseInt(data2[25]);
          tool10c=Integer.parseInt(data2[26]);
          map=data2[27];
          rox=Float.parseFloat(data2[28]);
          roy=Float.parseFloat(data2[29]);
          
    }
      public void storeGame(){
    	  data=rank+"\n"+
               abrank1+"\n"+
    		   abrank2+"\n"+
               abrank3+"\n"+
    		   abrank4+"\n"+
    		   blood+"\n"+
    		   maxBlood+"\n"+
    		   magic+"\n"+
    		   maxMgic+"\n"+
    		   XP+"\n"+
    		   maxXP+"\n"+
    		   attack+"\n"+
    		   defence+"\n"+
    		   force+"\n"+
    		   intelligence+"\n"+
    		   quick+"\n"+
    		   money+"\n"+
    		   tool1c+"\n"+
    		   tool2c+"\n"+
    		   tool3c+"\n"+
    		   tool4c+"\n"+
    		   tool5c+"\n"+
    		   tool6c+"\n"+
    		   tool7c+"\n"+
    		   tool8c+"\n"+
    		   tool9c+"\n"+
    		   tool10c+"\n"+
    		   map+"\n"
    		   +rox+"\n"
    		   +roy+"\n"
    		   +ArchMage+"\n"
    		   +BladeMaster+"\n"
    		   +DeathKnight+"\n"
    		   +DemonHunter+"\n"
    		   +DreadLord+"\n"
    		   +FarSeer+"\n"
    		   +FireLord+"\n"
    		   +NagaSeaWitch+"\n"
    		   +Paladin+"\n"+
    		   PandaBrewmaster+"\n"
    		   +POM+"\n";
    	      file=Gdx.files.local("store");
    		  file.writeString(data, false); 
      }
       
     public void dis(){
    	 start.dispose();
    	 start=null;
    	 System.gc();
     }

     public void initstart(){
    	 start=new startStage2(this,new StretchViewport(2208, 1242));
	   	   start.visible=true;
     }

    
}
