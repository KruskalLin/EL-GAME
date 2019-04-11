package stage;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;
import com.game.position;

import mapActor.demo;
import mapActor.dog;
import mapActor.dogman1;
import mapActor.dogman2;
import mapActor.dogman3;
import mapActor.fisherman;
import mapActor.spiderf;
import mapActor.spiders;
import mapActor.wolf3;
import mapHero.*;
import storystage.storyStage1;
import storystage.storystage2;
import widget.ToolGroup;
import widget.abbutton1;
import widget.abbutton2;
import widget.abbutton3;
import widget.abbutton4;
import widget.infbutton1;
import widget.infbutton2;
import widget.introduction;
import widget.progressBar2;

public class sandMap extends mapStage{
	public boolean mstory;
	public boolean mstory2;
	ArrayList<dogman1> enemy1v;
	ArrayList<dogman1> enemy1h;
	ArrayList<dogman2> enemy2v;
	ArrayList<dogman2> enemy2h;
	ArrayList<wolf3> enemy3v;
	ArrayList<wolf3> enemy3h;
	dafashi player2;
	nvhaiwu player3;
	xiongmao player4;
	shengqishi player5;
   public sandMap(GameScreen screen,Viewport port){
	   super(screen,port);
	   music = Gdx.audio.newMusic(Gdx.files.internal("sound2/mons.mp3"));
		music.setLooping(true);
		music.play();
      re();
      rekind="sand";
      intro=new introduction(750,1200);
	   bar2=new progressBar2(330,1300,screen.blood,screen.maxBlood,screen.magic,screen.maxMgic,screen.XP,screen.maxXP,this);
	   this.addActor(bar2);
	   tg=new ToolGroup(-20,700,this);
	   this.addActor(tg);
	   this.addActor(intro);
	  button1=new abbutton1(190,1242-180,this);
	  button2=new abbutton2(190+75,1242-180,this);
	  button3=new abbutton3(190+150,1242-180,this);
	  button4=new abbutton4(190+225,1242-180,this);
	  button=new infbutton1(200,1150,this);
	  mbutton=new infbutton2(200,1250,this);
	  mbutton.setScale((float)1.2);
	    mbutton.setPosition(190+300, 1242-150);
	    button.setPosition(190+300,1242-190);
	    button1.setScale((float)1.2);
	    button2.setScale((float)1.2);
	    button3.setScale((float)1.2);
	    button4.setScale((float)1.2);
	    this.addActor(mbutton);
	    this.addActor(button);
	    this.addActor(button1);
	    this.addActor(button2);
	    this.addActor(button3);
	    this.addActor(button4);
	    batch2=new SpriteBatch();
		mapWidth=5700;
		mapHeight=5100;
		map = new TmxMapLoader().load("input2/sandmap.tmx");
		texture9=new Texture("input2/kuang.png");
		texture1 = (GameScreen.assetManager.get(("input2/sandmap.jpg"),Texture.class));
  		texture2= (GameScreen.assetManager.get(("input2/sandmap2.jpg"),Texture.class));
  		texture3=(GameScreen.assetManager.get(("input2/point.jpg"),Texture.class));
  		texture6=(GameScreen.assetManager.get("input2/timg.jpg", Texture.class));
  		texture5=(GameScreen.assetManager.get(("input2/battle.png"),Texture.class));
  		enemy1h=new ArrayList<dogman1>();
        enemy1v=new ArrayList<dogman1>();     
        enemy2h=new ArrayList<dogman2>();
        enemy2v=new ArrayList<dogman2>();
        enemy3h=new ArrayList<wolf3>();
        enemy3v=new ArrayList<wolf3>();
        player2=new dafashi();
        player3=new nvhaiwu();
        player4=new xiongmao();
        player5=new shengqishi();
        initmap();
	    setMap();
	    this.updateItem();
	    this.screen=screen;
	    while(screen.XP>=screen.maxXP){
			 screen.XP-=screen.maxXP;
			 screen.rank++;
			 screen.attack+=20;
			 screen.defence+=1;
			 screen.force+=10;
			 screen.quick+=5;
			 screen.intelligence+=6;
			 this.addActor(up);
			 updateItem();
		 }
	    cbutton1.addListener(new ClickListener(){
			public void clicked(InputEvent e,float x,float y){
				sg.setVisible(true);
			}
		});
	}
	@Override
	public void newView() {
		
		if(tex5){
			screen.rox=player.x;
			screen.roy=player.y;
			screen.isStore=true;
		temp+=Gdx.graphics.getDeltaTime();
		if(temp>=2){
			temp=0;
			this.visible=false;
			screen.game=new assetgame(screen,kenemy,rekind);
			screen.game.visible=true;
			tex5=false;
			tap=true;
		}
	}
		if(change){
		temp+=Gdx.graphics.getDeltaTime();
		if(temp>=2){	
			temp=0;
			this.visible=false;
			screen.snow=new assetsnow(screen);
			screen.snow.visible=true;	
	}
	}
		if(mstory){
			temp+=Gdx.graphics.getDeltaTime();
			if(temp>=2){
				temp=0;
			 this.visible=false;
			  screen.story2=new storystage2(new StretchViewport(2208, 1242),screen);
			  screen.story2.visible=true;
             story.clear();
             mstory=false;
             tap=true;
		}
		}
		
	}
    
	 public void initmap(){
  	   if(!screen.initsand){
  		   screen.initsand=true;
  		   MapLayers layers =map.getLayers();;
  			for(MapLayer layer : layers){			
  				if(layer.getName().equals("dogman1v")){
  				       MapObjects objs = layer.getObjects();	             
  							for(MapObject obj : objs ){	 
  									RectangleMapObject	ro = (RectangleMapObject) obj;
  									screen.sandro1v.add(new position(ro.getRectangle().x,ro.getRectangle().y));							
  							}					      
  			   }
  				if(layer.getName().equals("dogman1h")){
  				            MapObjects objs = layer.getObjects();
  							for(MapObject obj : objs ){	
  								   
  									RectangleMapObject	ro = (RectangleMapObject) obj;
  									screen.sandro1h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
  							}					      
  			   }
  				if(layer.getName().equals("dogman2v")){
  				       MapObjects objs = layer.getObjects();
  				             
  				             
  							for(MapObject obj : objs ){	
  								    
  									RectangleMapObject	ro = (RectangleMapObject) obj;
  									screen.sandro2v.add(new position(ro.getRectangle().x,ro.getRectangle().y));								
  									
  							}					      
  			   }
  				if(layer.getName().equals("dogman2h")){
  				            MapObjects objs = layer.getObjects();
  				         
  				           
  							for(MapObject obj : objs ){	
  									RectangleMapObject	ro = (RectangleMapObject) obj;
  									screen.sandro2h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
  							}					      
  			   }
  				if(layer.getName().equals("wolfv")){
  				       MapObjects objs = layer.getObjects();
  				             
  				             
  							for(MapObject obj : objs ){	
  								   
  									RectangleMapObject	ro = (RectangleMapObject) obj;
  									screen.sandro3v.add(new position(ro.getRectangle().x,ro.getRectangle().y));								
  									
  							}					      
  			   }
  				if(layer.getName().equals("wolfh")){
  				            MapObjects objs = layer.getObjects();
  				         
  				           
  							for(MapObject obj : objs ){	
  								   
  								    
  									RectangleMapObject	ro = (RectangleMapObject) obj;
  									screen.sandro3h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
  							}					      
  				}
  				}
  	   }
     }
	
	 public void meetstory(){
		 if(!screen.sandstory1){
	        	for(int i=0;i<story.size();i++){
	    			RectangleMapObject obj=story.get(i);
	    			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
	    				  tap=false;
	    				  mstory=true;	
	    				  screen.sandstory1=true;
	    			}	
	    		}
	        	}
	 }
	 
	@Override
	public void findEnemy() {
		for(int i=0;i<ro1h.size();i++){
			RectangleMapObject obj=ro1h.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				tex5=true;
				tap=false;
				enemy1h.remove(i);
				ro1h.remove(i);
				screen.sandro1h.remove(i);
				kenemy="dogman1";
		      }
		}
		for(int i=0;i<ro1v.size();i++){
			RectangleMapObject obj=ro1v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy1v.remove(i);
					ro1v.remove(i);
					screen.sandro1v.remove(i);
					kenemy="dogman1";
			}
		}
		for(int i=0;i<ro2h.size();i++){
			RectangleMapObject obj=ro2h.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy2h.remove(i);
					ro2h.remove(i);
					screen.sandro2h.remove(i);
					kenemy="dogman2";
			}	
		}
		for(int i=0;i<ro2v.size();i++){
			RectangleMapObject obj=ro2v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy2v.remove(i);
					ro2v.remove(i);
					screen.sandro2v.remove(i);
					kenemy="dogman2";
			}	
		}
		for(int i=0;i<ro3h.size();i++){
			RectangleMapObject obj=ro3h.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy3h.remove(i);
					ro3h.remove(i);
					screen.sandro3h.remove(i);
					kenemy="wolf3";
			}	
		}
		for(int i=0;i<ro3v.size();i++){
			RectangleMapObject obj=ro3v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy3v.remove(i);
					ro3v.remove(i);
					screen.sandro3v.remove(i);
					kenemy="wolf3";
			}	
		}
		MapLayers layers = map.getLayers();	
		for(MapLayer layer : layers){
			if(!screen.ArchMage){
		if(layer.getName().equals("player2")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="dafashi";
						 screen.ArchMage=true;
					}
					}
				}	      
			}
			if(!screen.NagaSeaWitch){
		if(layer.getName().equals("player3")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="nvhaiwu";
						 screen.NagaSeaWitch=true;
					}
					}
				
				}	
			}
			if(!screen.PandaBrewmaster){
		if(layer.getName().equals("player4")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="xiongmao";
						 screen.PandaBrewmaster=true;
					}
					}
				}	      
		
		}
			if(!screen.Paladin){
				if(layer.getName().equals("player5")){
		            MapObjects objs = layer.getObjects();
					for(MapObject obj : objs ){
							RectangleMapObject	ro1= (RectangleMapObject) obj;
							if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
								 tex5=true;
								 tap=false;
								 kenemy="shengqishi";
								 screen.Paladin=true;
							}
							}
						}	      
				
				}
		}

		
	}

	@Override
	public void setMap() {
		MapLayers layers = map.getLayers();	
		for(MapLayer layer : layers){			
			if(layer.getName().equals("player")) {
				MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
					ro = (RectangleMapObject) obj;
					if(!screen.isStore){
						player.x=ro.getRectangle().x;
						player.y=ro.getRectangle().y;
						}else{
						player.x=screen.rox;
						ro.getRectangle().x=screen.rox;
						player.y=screen.roy;
						ro.getRectangle().y=screen.roy;
						screen.isStore=false;
						}
				}
			}
			if(layer.getName().equals("story")){
	            MapObjects objs = layer.getObjects();
	         
	           
				for(MapObject obj : objs ){	 
						RectangleMapObject	ro = (RectangleMapObject) obj;
						story.add(ro);
				}					      
   }           
			
			if(layer.getName().equals("player2")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player2.x=ro.getRectangle().x;
						player2.y=ro.getRectangle().y;
					
					}	      
				}
			if(layer.getName().equals("player3")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player3.x=ro.getRectangle().x;
						player3.y=ro.getRectangle().y;
					
					}	      
				}
			if(layer.getName().equals("player4")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player4.x=ro.getRectangle().x;
						player4.y=ro.getRectangle().y;
					
					}	      
				}
			if(layer.getName().equals("player5")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player5.x=ro.getRectangle().x;
						player5.y=ro.getRectangle().y;
					
					}	      
				}
			if(layer.getName().equals("dogman1v")){
				for(int i=0;i<screen.sandro1v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.sandro1v.get(i).x;
					ro.getRectangle().y=screen.sandro1v.get(i).y;
					 enemy1v.add(new dogman1());
					 ro1v.add(ro);
				}
			       					      
		   }
			if(layer.getName().equals("dogman1h")){
				for(int i=0;i<screen.sandro1h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.sandro1h.get(i).x;
					ro.getRectangle().y=screen.sandro1h.get(i).y;
					 enemy1h.add(new dogman1());
					 ro1h.add(ro);
				}				      
		   }
			if(layer.getName().equals("dogman2v")){
				for(int i=0;i<screen.sandro2v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.sandro2v.get(i).x;
					ro.getRectangle().y=screen.sandro2v.get(i).y;
					 enemy2v.add(new dogman2());
					 ro2v.add(ro);
				}
			      	
											      
		   }
			if(layer.getName().equals("dogman2h")){
				for(int i=0;i<screen.sandro2h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.sandro2h.get(i).x;
					ro.getRectangle().y=screen.sandro2h.get(i).y;
					 enemy2h.add(new dogman2());
					 ro2h.add(ro);
				}					      
		   }
			if(layer.getName().equals("wolfv")){
				for(int i=0;i<screen.sandro3v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.sandro3v.get(i).x;
					ro.getRectangle().y=screen.sandro3v.get(i).y;
					 enemy3v.add(new wolf3());
					 ro3v.add(ro);
				}					      
		   }
			if(layer.getName().equals("wolfh")){
				for(int i=0;i<screen.sandro3h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.sandro3h.get(i).x;
					ro.getRectangle().y=screen.sandro3h.get(i).y;
					 enemy3h.add(new wolf3());
					 ro3h.add(ro);
				}				      
		   }
						
		}
		
	}

	@Override
	public void draw() {
		
		change();
       findEnemy();  
       meetstory();
	   if(player.x>=screenWidth/2&&player.x<=mapWidth-screenWidth/2)
			camera.position.x=(float)player.x;
			if(player.y>=screenHeight/2&&player.y<=mapHeight-screenHeight/2)
			camera.position.y=(float)player.y;
			
		batch.setProjectionMatrix(camera.combined);
		camera.update();
		batch.begin();
		 batch.draw(texture1, 0, 0, texture1.getWidth(), texture1.getHeight());
		 update(); 
	    door.draw(batch, 1);
	    player.draw(batch,1);
	   player2.draw(batch, 1);
	   player3.draw(batch, 1);
	   player4.draw(batch, 1);
	   player5.draw(batch, 1);
	   if(tex5)
		    batch.draw(texture5, camera.position.x-texture5.getWidth()/2, camera.position.y-texture5.getHeight()/2, texture5.getWidth(), texture5.getHeight());
		   
	    for(int i=0;i<enemy1v.size();i++){
			enemy1v.get(i).drawv(batch, 1,ro1v.get(i).getRectangle());
		    }
		    for(int i=0;i<enemy1h.size();i++){
			    enemy1h.get(i).drawh(batch, 1,ro1h.get(i).getRectangle());
		    }        
		    for(int i=0;i<enemy2v.size();i++){
				enemy2v.get(i).drawv(batch, 1,ro2v.get(i).getRectangle());
			    }
			   
			    for(int i=0;i<enemy2h.size();i++){
				    enemy2h.get(i).drawh(batch, 1,ro2h.get(i).getRectangle());
			    }        
			    for(int i=0;i<enemy3v.size();i++){
					enemy3v.get(i).drawv(batch, 1,ro3v.get(i).getRectangle());
				    }
				   
				    for(int i=0;i<enemy3h.size();i++){
					    enemy3h.get(i).drawh(batch, 1,ro3h.get(i).getRectangle());
				    }     
	    batch.end();
	   
	    batch2.begin();
	    batch2.draw(texture9, Gdx.graphics.getWidth()-texture9.getWidth()/2+80, Gdx.graphics.getHeight()-texture9.getHeight()/2+80, texture9.getWidth()/(float)2.4, texture9.getHeight()/(float)2.4);
		   
	    batch2.draw(texture6, 0, Gdx.graphics.getHeight()-texture6.getHeight()/(float)1.4, texture6.getWidth()/(float)1.4, texture6.getHeight()/(float)1.4);batch2.draw(texture2,Gdx.graphics.getWidth()-texture2.getWidth()/2-7, Gdx.graphics.getHeight()-texture2.getHeight()/2-10, texture2.getWidth()/2, texture2.getHeight()/2);
	    batch2.draw(texture3,Gdx.graphics.getWidth()-texture2.getWidth()/2-7+(player.x/5700)*248/2,Gdx.graphics.getHeight()-10-texture2.getWidth()/2+(player.y/5100)*248/2 , texture3.getWidth(), texture3.getHeight());	    
	    batch2.end();
		super.draw();
	}
   
	public void re(){
		if(screen.sand!=null){
		 screen.sand.dispose();
	   	   screen.sand=null;
	     System.gc();
		}
		 if(screen.story!=null){
		 screen.story.dispose();
		 screen.story=null;
		 System.gc();
		 }
		 if(screen.gs!=null){
			 screen.gs.dispose();
			 GameScreen.assetManager2.clear();
			 screen.gs=null;
			 System.gc();
		 }
		 if(screen.my!=null){
			 screen.my.dispose();
			 screen.my=null;
			 System.gc();
		 }
		 if(screen.snow!=null){
			 screen.snow.dispose();
			 screen.snow=null;
			 System.gc();
		 }
	 }	
	
public void dispose(){
		map.dispose();
		music.dispose();
	}
}
