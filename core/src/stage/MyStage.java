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
import com.game.*;

import actor.BarGroup;
import mapActor.dog;
import mapActor.dogman3;
import mapActor.fisherman;
import mapHero.emolieshou;
import mapHero.nvjisi;
import mapHero.xianzhi;
import mapNpc.*;
import mapNpc.wseller;
import storystage.chatStage;
import storystage.chatstage2;
import storystage.chatstage3;
import storystage.chatstage4;
import storystage.storyStage1;
import widget.LevelUp;
import widget.ToolGroup;
import widget.abbutton1;
import widget.abbutton2;
import widget.abbutton3;
import widget.abbutton4;
import widget.infbutton1;
import widget.infbutton2;
import widget.introduction;
import widget.progressBar2;
public class MyStage extends mapStage {
	boolean mstory;
	boolean mstory2;
	boolean mstory3;
	boolean mstory4;
	boolean mshop;
	ArrayList<fisherman> enemy1v;
	ArrayList<fisherman> enemy1h;
	ArrayList<dog> enemy2v;
	ArrayList<dog> enemy2h;
	ArrayList<dogman3> enemy3v;
	ArrayList<dogman3> enemy3h;
	mseller ms;
	ouwen ouwen;
	first first;
	nvjisi player2;
	xianzhi player3;
	emolieshou player4;
	    public MyStage(GameScreen screen,Viewport viewport){
	    super(screen,viewport);	
	    rekind="my";
	    music= Gdx.audio.newMusic(Gdx.files.internal("sound2/snow.mp3"));
		music.setLooping(true);
		music.play();
	    batch2=new SpriteBatch();
	    mapWidth=4500;
	    mapHeight=4500;
	    texture9=new Texture("input2/kuang.png");
	    texture1 = (GameScreen.assetManager.get(("input2/map.jpg"),Texture.class));
  		texture2= (GameScreen.assetManager.get(("input2/map3.jpg"),Texture.class));
  		texture3=(GameScreen.assetManager.get(("input2/point.jpg"),Texture.class));
		texture5=(GameScreen.assetManager.get(("input2/battle.png"),Texture.class));
		texture6=(GameScreen.assetManager.get("input2/timg.jpg", Texture.class));	
		intro=new introduction(750,1200);
		 bar2=new progressBar2(330,1300,screen.blood,screen.maxBlood,screen.magic,screen.maxMgic,screen.XP,screen.maxXP,this);
		    this.addActor(bar2);
		    tg=new ToolGroup(-20,720,this);
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
		bg=new BarGroup(texture6.getWidth(),Gdx.graphics.getHeight()-100,1000,1000,1000,1000,false);
		bg.setScale((float)0.5, (float)0.5);
		map = new TmxMapLoader().load("input2/map2.tmx");
		player2=new nvjisi();
		player3=new xianzhi();
		player4=new emolieshou();
        enemy1h=new ArrayList<fisherman>();
        enemy1v=new ArrayList<fisherman>();   
        enemy2h=new ArrayList<dog>();
        enemy2v=new ArrayList<dog>();
        enemy3h=new ArrayList<dogman3>();
        enemy3v=new ArrayList<dogman3>();
        ms=new mseller();
       
        ouwen=new ouwen();
        first=new first();
        this.screen=screen;
        initmap();
        setMap();
        this.updateItem();
        re();
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
	    public void draw(){ 
	    	change();
	    	meetshop();
	    	meetStory();
		    findEnemy();  
		    if(player.x>=screenWidth/2&&player.x<=mapWidth-screenWidth/2)
			camera.position.x=(float)player.x;
		    else if(player.x<screenWidth/2){
		    	camera.position.x=screenWidth/2;
		    }else if(player.x>=mapWidth-screenWidth/2){
		    	camera.position.x=mapWidth-screenWidth/2;
		    }
			if(player.y>=screenHeight/2&&player.y<=mapHeight-screenHeight/2)
			camera.position.y=(float)player.y;
			else if(player.y<screenHeight/2){
		    	camera.position.y=screenHeight/2;
		    }else if(player.y>=mapHeight-screenHeight/2){
		    	camera.position.y=mapHeight-screenHeight/2;
		    }
			batch.setProjectionMatrix(camera.combined);
			camera.update();
			batch.begin();
			batch.draw(texture1, 0, 0, texture1.getWidth(), texture1.getHeight());	
		    if(tex5)
		    batch.draw(texture5, camera.position.x-texture5.getWidth()/2, camera.position.y-texture5.getHeight()/2, texture5.getWidth(), texture5.getHeight());
		    update(); 
		    door.draw(batch, 1);
		    player.draw(batch,1);
		    player2.draw(batch,1);
		    player3.draw(batch, 1);
		    player4.draw(batch, 1);  
		   ms.draw(batch, 1);
		  
		   ouwen.draw(batch, 1);
		   first.draw(batch, 1);
		   
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
		   
		    batch2.draw(texture6, 0, Gdx.graphics.getHeight()-texture6.getHeight()/(float)1.4, texture6.getWidth()/(float)1.4, texture6.getHeight()/(float)1.4);
		    batch2.draw(texture2,Gdx.graphics.getWidth()-texture2.getWidth()/2-7, Gdx.graphics.getHeight()-texture2.getHeight()/2-10, texture2.getWidth()/2, texture2.getHeight()/2);
		    batch2.draw(texture3,Gdx.graphics.getWidth()-texture2.getWidth()/2-7+(player.x/4500)*248/2,Gdx.graphics.getHeight()-10-texture2.getWidth()/2+(player.y/4500)*248/2 , texture3.getWidth(), texture3.getHeight());	    
		    batch2.end();
		    super.draw();
		    
	}
		public void findEnemy(){
			MapLayers layers =map.getLayers();;
		for(int i=0;i<ro1h.size();i++){
			RectangleMapObject obj=ro1h.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				tex5=true;
				tap=false;
				enemy1h.remove(i);
				ro1h.remove(i);
				screen.myro1h.remove(i);
				kenemy="fisherman";
		      }
		}
		for(int i=0;i<ro1v.size();i++){
			RectangleMapObject obj=ro1v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy1v.remove(i);
					ro1v.remove(i);
					screen.myro1v.remove(i);
					kenemy="fisherman";
			}
		}
		for(int i=0;i<ro2h.size();i++){
			RectangleMapObject obj=ro2h.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy2h.remove(i);
					ro2h.remove(i);
					screen.myro2h.remove(i);
					kenemy="dog";
			}	
		}
		for(int i=0;i<ro2v.size();i++){
			RectangleMapObject obj=ro2v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy2v.remove(i);
					ro2h.remove(i);
					screen.myro2v.remove(i);
					kenemy="dog";
			}	
		}
		for(int i=0;i<ro3h.size();i++){
			RectangleMapObject obj=ro3h.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy3h.remove(i);
					ro3h.remove(i);
					screen.myro3h.remove(i);
					kenemy="dogman3";
			}	
		}
		for(int i=0;i<ro3v.size();i++){
			RectangleMapObject obj=ro3v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy3v.remove(i);
					ro3v.remove(i);
					screen.myro3v.remove(i);
					kenemy="dogman3";
			}	
		}
		for(MapLayer layer : layers){
			if(!screen.POM){
		if(layer.getName().equals("nvjisi")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 end=true;
						 tap=false;
						 kenemy="nvjisi";
						 screen.POM=true;
					}
					}
				
				}	      
			}
			if(!screen.FarSeer){
		if(layer.getName().equals("xianzhi")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="xianzhi";
						 screen.FarSeer=true;
					}
					}
				
				}	
			}
			if(!screen.DemonHunter){
		if(layer.getName().equals("ermolieshou")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="emolieshou";
						 screen.DemonHunter=true;
					}
					}
				
				}	      
		
		}
		}
	}     
  
        public void meetStory(){
        	
        	if(screen.tool4c>=1&&screen.tool9c>=1){
        		screen.mystory32=true;
        		
        	}
        	if(screen.DemonHunter&&screen.FarSeer){
        		screen.mystory42=true;
        	}
        	if(!screen.mystory1){
        	for(int i=0;i<story.size();i++){
    			RectangleMapObject obj=story.get(i);
    			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
    				  tap=false;
    				  mstory=true;	
    				  screen.mystory1=true;
    			}	
    		}
        	}
        	if(!screen.mystory2){
        	for(int i=0;i<story2.size();i++){
    			RectangleMapObject obj=story2.get(i);
    			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
    				  tap=false;
    				  mstory2=true;
    				  screen.mystory2=true;
    			}	
    		}
        	}
        	if((!screen.mystory31)||(!screen.mystory33&&screen.mystory32)){
        		           System.out.println(screen.mystory32);                      
        	for(int i=0;i<story3.size();i++){
    			RectangleMapObject obj=story3.get(i);
    			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
    				  tap=false;
    				  mstory3=true; 
    				  if(!screen.mystory31){
    					  screen.mystory31=true;
    				  }else{
    					  screen.mystory33=true;
    				  }
    			}	
    		}
        	}
        	if((!screen.mystory41)||(screen.mystory42&&!screen.mystory43)){
        	for(int i=0;i<story4.size();i++){
    			RectangleMapObject obj=story4.get(i);
    			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
    				  tap=false;
    				  mstory4=true;
    				  if(!screen.mystory41){
    					  screen.mystory41=true;
    				  }else{
    					  screen.mystory43=true;
    				  }
    				 
    			}	
    		}
        	}
        }
      
       public void initmap(){
    	   if(!screen.initmy){
    		   screen.initmy=true;
    		   MapLayers layers =map.getLayers();;
    			for(MapLayer layer : layers){			
    				if(layer.getName().equals("fishv")){
    				       MapObjects objs = layer.getObjects();	             
    							for(MapObject obj : objs ){	 
    									RectangleMapObject	ro = (RectangleMapObject) obj;
    									screen.myro1v.add(new position(ro.getRectangle().x,ro.getRectangle().y));							
    							}					      
    			   }
    				if(layer.getName().equals("fishh")){
    				            MapObjects objs = layer.getObjects();
    							for(MapObject obj : objs ){	
    								   
    									RectangleMapObject	ro = (RectangleMapObject) obj;
    									screen.myro1h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
    							}					      
    			   }
    				if(layer.getName().equals("dogv")){
    				       MapObjects objs = layer.getObjects();
    				             
    				             
    							for(MapObject obj : objs ){	
    								    
    									RectangleMapObject	ro = (RectangleMapObject) obj;
    									screen.myro2v.add(new position(ro.getRectangle().x,ro.getRectangle().y));								
    									
    							}					      
    			   }
    				if(layer.getName().equals("dogh")){
    				            MapObjects objs = layer.getObjects();
    				         
    				           
    							for(MapObject obj : objs ){	
    									RectangleMapObject	ro = (RectangleMapObject) obj;
    									screen.myro2h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
    							}					      
    			   }
    				if(layer.getName().equals("dogmanv")){
    				       MapObjects objs = layer.getObjects();
    				             
    				             
    							for(MapObject obj : objs ){	
    								   
    									RectangleMapObject	ro = (RectangleMapObject) obj;
    									screen.myro3v.add(new position(ro.getRectangle().x,ro.getRectangle().y));								
    									
    							}					      
    			   }
    				if(layer.getName().equals("dogmanh")){
    				            MapObjects objs = layer.getObjects();
    				         
    				           
    							for(MapObject obj : objs ){	
    								   
    								    
    									RectangleMapObject	ro = (RectangleMapObject) obj;
    									screen.myro3h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
    							}					      
    				}
    				}
    	   }
       }
        
        
         public void meetshop(){
        
        	for(int i=0;i<shop.size();i++){
    			RectangleMapObject obj=shop.get(i);
    			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
    				  tap=false;
    				  mshop=true;
    				 
    			}	
    		}
        }
        public void setMap() {	
        	MapLayers layers =map.getLayers();;
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

			if(layer.getName().equals("nvjisi")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player2.x=ro.getRectangle().x;
						player2.y=ro.getRectangle().y;
					    
					}	      
				}
			if(layer.getName().equals("xianzhi")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player3.x=ro.getRectangle().x;
						player3.y=ro.getRectangle().y;
					
					}	      
				}
			if(layer.getName().equals("ermolieshou")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player4.x=ro.getRectangle().x;
						player4.y=ro.getRectangle().y;
					                     
					}	                 
				}                
			                  
		if(layer.getName().equals("npc1")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro = (RectangleMapObject) obj;
					
					shop.add(ro);
				}	      
			}
		if(layer.getName().equals("npc2")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro = (RectangleMapObject) obj;
				   
				}	      
			}     	
			if(layer.getName().equals("fishv")){
				for(int i=0;i<screen.myro1v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.myro1v.get(i).x;
					ro.getRectangle().y=screen.myro1v.get(i).y;
					 enemy1v.add(new fisherman());
					 ro1v.add(ro);
				}
			       					      
		   }
			if(layer.getName().equals("fishh")){
				for(int i=0;i<screen.myro1h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.myro1h.get(i).x;
					ro.getRectangle().y=screen.myro1h.get(i).y;
					 enemy1h.add(new fisherman());
					 ro1h.add(ro);
				}				      
		   }
			if(layer.getName().equals("dogv")){
				for(int i=0;i<screen.myro2v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.myro2v.get(i).x;
					ro.getRectangle().y=screen.myro2v.get(i).y;
					 enemy2v.add(new dog());
					 ro2v.add(ro);
				}
			      	
											      
		   }
			if(layer.getName().equals("dogh")){
				for(int i=0;i<screen.myro2h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.myro2h.get(i).x;
					ro.getRectangle().y=screen.myro2h.get(i).y;
					 enemy2h.add(new dog());
					 ro2h.add(ro);
				}					      
		   }
			if(layer.getName().equals("dogmanv")){
				for(int i=0;i<screen.myro3v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.myro3v.get(i).x;
					ro.getRectangle().y=screen.myro3v.get(i).y;
					 enemy3v.add(new dogman3());
					 ro3v.add(ro);
				}					      
		   }
			if(layer.getName().equals("dogmanh")){
				for(int i=0;i<screen.myro3h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.myro3h.get(i).x;
					ro.getRectangle().y=screen.myro3h.get(i).y;
					 enemy3h.add(new dogman3());
					 ro3h.add(ro);
				}				      
		   }
			if(layer.getName().equals("story1")){
	            MapObjects objs = layer.getObjects();
	         
	           
				for(MapObject obj : objs ){	 
						RectangleMapObject	ro = (RectangleMapObject) obj;
						story.add(ro);
				}					      
   }           
			if(layer.getName().equals("story2")){
	            MapObjects objs = layer.getObjects();
	         
	           
				for(MapObject obj : objs ){	 
						RectangleMapObject	ro = (RectangleMapObject) obj;
						first.x=ro.getRectangle().x;
						first.y=ro.getRectangle().y;
						story2.add(ro);
				}
				
   }
			if(layer.getName().equals("story3")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){	 
						RectangleMapObject	ro = (RectangleMapObject) obj;
						ouwen.x=ro.getRectangle().x;
						ouwen.y=ro.getRectangle().y;
						story3.add(ro);
				}					      
   }
			if(layer.getName().equals("story4")){
	            MapObjects objs = layer.getObjects();
	         
	           
				for(MapObject obj : objs ){	 
						RectangleMapObject	ro = (RectangleMapObject) obj;
						ms.x=ro.getRectangle().x;
						ms.y=ro.getRectangle().y;
						story4.add(ro);
				}					      
   }
			
		}
	}
		@Override
		public void newView() {
			
			
			if(tex5){
				music.pause();
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
				screen.sand=new assetsand(screen);
				screen.sand.visible=true;	
		}
		}
			if(mstory){
				
				temp+=Gdx.graphics.getDeltaTime();
				if(temp>=2){
					temp=0;
				 this.visible=false;
				  screen.story=new storyStage1(new StretchViewport(2208, 1242),screen);
				  screen.story.visible=true;
                 story.clear();
                 mstory=false;
                 tap=true;
			}
			}
			if(mstory2){
				temp+=Gdx.graphics.getDeltaTime();
				if(temp>=2){
					temp=0;
				 
				  screen.chat=new chatStage(new StretchViewport(2208, 1242),this);
				  screen.chat.visible=true;
                 story2.clear();
                 mstory2=false;
                 tap=true;
			}
			}
			if(mstory3){
				temp+=Gdx.graphics.getDeltaTime();
				if(temp>=2){
					temp=0;
				 
				  screen.chat2=new chatstage2(new StretchViewport(2208, 1242),this);
				  screen.chat2.visible=true;
				 if(screen.mystory33)
                 story3.clear();
                 mstory3=false;
                 tap=true;
			}
			}
			if(mstory4){
				temp+=Gdx.graphics.getDeltaTime();
				if(temp>=2){
					temp=0;
				  screen.chat3=new chatstage3(new StretchViewport(2208, 1242),this);
				  screen.chat3.visible=true;
				 if(screen.mystory43)
                 story4.clear();
                 mstory4=false;
                 tap=true;
			}
			}
			if(end){
				screen.rox=player.x;
				screen.roy=player.y;
				screen.isStore=true;
				temp+=Gdx.graphics.getDeltaTime();
				if(temp>=2){
				temp=0;
				screen.chat4=new chatstage4(new StretchViewport(2208, 1242),this);
				screen.chat4.visible=true;
                end=false;
                tap=true;
			}
			}
			if(mshop){
				temp+=Gdx.graphics.getDeltaTime();
				if(temp>=2){
				 temp=0;
				 this.visible=false;
				  screen.shop=new shopStage(new StretchViewport(2208, 1242), screen);
				  screen.shop.visible=true;
                 mshop=false;
                 tap=true;
			}
			}
		}
		public void dispose(){
			 music.dispose();
			 texture1.dispose();
			 texture2.dispose();
			 texture3.dispose();
			 texture5.dispose();
			 map.dispose();
	         super.dispose(); 
			 for(int i=0;i<enemy1v.size();i++){
					enemy1v.get(i).dispose();
				    }
				   
				    for(int i=0;i<enemy1h.size();i++){
					    enemy1h.get(i).dispose();
				    }        
				    for(int i=0;i<enemy2v.size();i++){
						enemy2v.get(i).dispose();
					    }
					   
					    for(int i=0;i<enemy2h.size();i++){
						    enemy2h.get(i).dispose();
					    }        
					    for(int i=0;i<enemy3v.size();i++){
							enemy3v.get(i).dispose();
						    }
						   
						    for(int i=0;i<enemy3h.size();i++){
							    enemy3h.get(i).dispose();
						    }
			
			 
		}
	
        
		 public void re(){	
			 music.play();
			 if(screen.my!=null){
				 screen.my.dispose();
				 screen.my=null;
				 System.gc();
			 }
			 if(screen.cstage!=null){
					screen.cstage.dispose();
					screen.cstage=null;
					System.gc();
			}
			 if(screen.story!=null){
			 screen.story.dispose();
			 screen.story=null;
			 System.gc();
			 } 
			 if(screen.chat2!=null){
				 screen.chat2.dispose();
				 screen.chat2=null;
				 System.gc();
				 }
			 if(screen.chat3!=null){
				 screen.chat3.dispose();
				 screen.chat3=null;
				 System.gc();
				 }
			 if(screen.chat4!=null){
				 screen.chat4.dispose();
				 screen.chat4=null;
				 System.gc();
				 }
			 if(screen.chat!=null){
				 screen.chat.dispose();
				 screen.chat=null;
				 System.gc();
				 }
			 if(screen.gs!=null){
				 screen.gs.dispose();
				 GameScreen.assetManager2.clear();
				 screen.gs=null;
				 System.gc();
			 }
			 if(screen.shop!=null){
				 screen.shop.dispose();
				 screen.shop=null;
				 System.gc();
			 }
			 if(screen.sand!=null){
				 screen.sand.dispose();
				 screen.sand=null;
				 System.gc();
			 }
			 
		 }
}
