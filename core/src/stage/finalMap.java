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
import mapActor.dogman1;
import mapActor.dogman2;
import mapActor.semimos;
import mapActor.spiders;
import mapActor.wolf2;
import mapHero.huoyan;
import mapHero.kongju;
import mapHero.siqi;
import storystage.chatStage;
import storystage.chatstage2;
import storystage.chatstage6;
import storystage.chatstage7;
import storystage.storyStage1;
import storystage.storystage4;
import widget.ToolGroup;
import widget.abbutton1;
import widget.abbutton2;
import widget.abbutton3;
import widget.abbutton4;
import widget.infbutton1;
import widget.infbutton2;
import widget.introduction;
import widget.progressBar2;


public class finalMap extends mapStage {
	public boolean mstory;
	public boolean mstory2;
	public boolean mstory3;
	siqi sq;
	huoyan hy;
	kongju kongju;
	ArrayList<demo> enemy1v;
	ArrayList<demo> enemy1h;
	ArrayList<semimos> enemy2v;
	ArrayList<semimos> enemy2h;
	ArrayList<spiders> enemy3v;
	ArrayList<spiders> enemy3h;
	  public finalMap(GameScreen screen,Viewport port){
		super(screen,port);
		music = Gdx.audio.newMusic(Gdx.files.internal("sound2/fear2.mp3"));
		music.setLooping(true);
		music.play();
		re();
	    rekind="final";
		batch2=new SpriteBatch();
		mapWidth=5120;
		mapHeight=3840;
		map = new TmxMapLoader().load("input2/finalmap.tmx");
		 texture9=new Texture("input2/kuang.png");
		texture1 = (GameScreen.assetManager.get(("input2/finalmap.jpg"),Texture.class));
  		texture2= (GameScreen.assetManager.get(("input2/finalmap2.jpg"),Texture.class));
  		texture3=(GameScreen.assetManager.get(("input2/point.jpg"),Texture.class));
  		texture6=(GameScreen.assetManager.get("input2/timg.jpg", Texture.class));
  		texture5=(GameScreen.assetManager.get(("input2/battle.png"),Texture.class));
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
  		 enemy1h=new ArrayList<demo>();
         enemy1v=new ArrayList<demo>();     
         enemy2h=new ArrayList<semimos>();
         enemy2v=new ArrayList<semimos>();
         enemy3h=new ArrayList<spiders>();
         enemy3v=new ArrayList<spiders>();
         sq=new siqi();
         hy=new huoyan();
         kongju=new kongju();
         initmap();
	    setMap();
	    this.updateItem();
	    this.screen=screen;
	    System.out.println(player.x);
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
		  
		  music.pause();
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
			screen.choice=new assetchoice(screen);
			screen.choice.visible=true;	
	}
	}
		if(mstory){
			temp+=Gdx.graphics.getDeltaTime();
			if(temp>=2){
				temp=0;
			 this.visible=false;
			  screen.story4=new storystage4(new StretchViewport(2208, 1242),screen);
			  screen.story4.visible=true;
             story.clear();
             mstory=false;
             tap=true;
		}
		}
		if(mstory2){
			temp+=Gdx.graphics.getDeltaTime();
			if(temp>=2){
				temp=0;
			 
			  screen.chat6=new chatstage6(new StretchViewport(2208, 1242),this);
			  screen.chat6.visible=true;
             story2.clear();
             mstory2=false;
             tap=true;
		}
		}
		if(mstory3){
			temp+=Gdx.graphics.getDeltaTime();
			if(temp>=2){
				temp=0;
			 
			  screen.chat7=new chatstage7(new StretchViewport(2208, 1242),this);
			  screen.chat7.visible=true;
             story3.clear();
             mstory3=false;
             tap=true;
		}
		}
	}

	  public void initmap(){
	  	   if(!screen.initfinal){
	  		   screen.initfinal=true;
	  		   MapLayers layers =map.getLayers();;
	  			for(MapLayer layer : layers){			
	  				if(layer.getName().equals("demov")){
	  				       MapObjects objs = layer.getObjects();	             
	  							for(MapObject obj : objs ){	 
	  									RectangleMapObject	ro = (RectangleMapObject) obj;
	  									screen.finalro1v.add(new position(ro.getRectangle().x,ro.getRectangle().y));							
	  							}					      
	  			   }
	  				if(layer.getName().equals("demoh")){
	  				            MapObjects objs = layer.getObjects();
	  							for(MapObject obj : objs ){	 
	  									RectangleMapObject	ro = (RectangleMapObject) obj;
	  									screen.finalro1h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
	  							}					      
	  			   }
	  				if(layer.getName().equals("spiderfv")){
	  				       MapObjects objs = layer.getObjects();
	  				             
	  				             
	  							for(MapObject obj : objs ){	
	  								    
	  									RectangleMapObject	ro = (RectangleMapObject) obj;
	  									screen.finalro2v.add(new position(ro.getRectangle().x,ro.getRectangle().y));								
	  									
	  							}					      
	  			   }
	  				if(layer.getName().equals("spiderfh")){
	  				            MapObjects objs = layer.getObjects();
	  				         
	  				           
	  							for(MapObject obj : objs ){	
	  									RectangleMapObject	ro = (RectangleMapObject) obj;
	  									screen.finalro2h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
	  							}					      
	  			   }
	  				if(layer.getName().equals("spidersv")){
	  				       MapObjects objs = layer.getObjects();
	  				             
	  				             
	  							for(MapObject obj : objs ){	
	  								   
	  									RectangleMapObject	ro = (RectangleMapObject) obj;
	  									screen.finalro3v.add(new position(ro.getRectangle().x,ro.getRectangle().y));								
	  									
	  							}					      
	  			   }
	  				if(layer.getName().equals("spidersh")){
	  				            MapObjects objs = layer.getObjects();
	  				         
	  				           
	  							for(MapObject obj : objs ){	
	  								   
	  								    
	  									RectangleMapObject	ro = (RectangleMapObject) obj;
	  									screen.finalro3h.add(new position(ro.getRectangle().x,ro.getRectangle().y));
	  							}					      
	  				}
	  				}
	  	   }
	     }

	  public void meetstory(){

      	if(!screen.finalstory1){
      	for(int i=0;i<story.size();i++){
  			RectangleMapObject obj=story.get(i);
  			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
  				  tap=false;
  				  mstory=true;	
  				  screen.finalstory1=true;
  			}	
  		}
      	}
      	if(!screen.finalstory2){
      	for(int i=0;i<story2.size();i++){
  			RectangleMapObject obj=story2.get(i);
  			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
  				  tap=false;
  				  mstory2=true;
  				  screen.finalstory2=true;
  			}	
  		}
      	}
      	if((!screen.finalstory3)){
      		                                 
      	for(int i=0;i<story3.size();i++){
  			RectangleMapObject obj=story3.get(i);
  			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
  				  tap=false;
  				  mstory3=true; 
  				  screen.finalstory3=true;
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
				screen.finalro1h.remove(i);
				kenemy="demo";
		      }
		}
		for(int i=0;i<ro1v.size();i++){
			RectangleMapObject obj=ro1v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy1v.remove(i);
					ro1v.remove(i);
					screen.finalro1v.remove(i);
					kenemy="demo";
			}
		}
		for(int i=0;i<ro2h.size();i++){
			RectangleMapObject obj=ro2h.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy2h.remove(i);
					ro2h.remove(i);
					screen.finalro2h.remove(i);
					kenemy="semimos";
			}	
		}
		for(int i=0;i<ro2v.size();i++){
			RectangleMapObject obj=ro2v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy2v.remove(i);
					ro2v.remove(i);
					screen.finalro2v.remove(i);
					kenemy="semimos";
			}	
		}
		for(int i=0;i<ro3h.size();i++){
			RectangleMapObject obj=ro3h.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy3h.remove(i);
					ro3h.remove(i);
					screen.finalro3h.remove(i);
					kenemy="spiders";
			}	
		}
		for(int i=0;i<ro3v.size();i++){
			RectangleMapObject obj=ro3v.get(i);
			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
				  tex5=true;
				  tap=false;
				  enemy3v.remove(i);
					ro3v.remove(i);
					screen.finalro3v.remove(i);
					kenemy="spiders";
			}	
		}
		MapLayers layers = map.getLayers();	
		for(MapLayer layer : layers){
			if(!screen.DeathKnight){
		if(layer.getName().equals("siqi")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						// tap=false;
						 kenemy="siqi";
						 screen.DeathKnight=true;
					}
					}
				
				}	      
			}
			if(!screen.FireLord){
		if(layer.getName().equals("huoyan")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						// tap=false;
						 kenemy="huoyan";
						 screen.FireLord=true;
					}
					}
				
				}	
			}
			if(!screen.DreadLord){
		if(layer.getName().equals("kongju")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="kongju";
						 screen.DreadLord=true;
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
						System.out.println(player.x);
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
			if(layer.getName().equals("siqi")) {
				MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
					RectangleMapObject	ro = (RectangleMapObject) obj;
					sq.x=ro.getRectangle().x;
					sq.y=ro.getRectangle().y;	
					story3.add(ro);
				}
				
			}
			if(layer.getName().equals("huoyan")) {
				MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
					RectangleMapObject	ro = (RectangleMapObject) obj;
					hy.x=ro.getRectangle().x;
					hy.y=ro.getRectangle().y;	
					story2.add(ro);
				}
				
			}
			if(layer.getName().equals("kongju")) {
				MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
					RectangleMapObject	ro = (RectangleMapObject) obj;
					kongju.x=ro.getRectangle().x;
					kongju.y=ro.getRectangle().y;	
				}
				
			}
			if(layer.getName().equals("demov")){
				for(int i=0;i<screen.finalro1v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.finalro1v.get(i).x;
					ro.getRectangle().y=screen.finalro1v.get(i).y;
					 enemy1v.add(new demo());
					 ro1v.add(ro);
				}
			       					      
		   }
			if(layer.getName().equals("demoh")){
				for(int i=0;i<screen.finalro1h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.finalro1h.get(i).x;
					ro.getRectangle().y=screen.finalro1h.get(i).y;
					 enemy1h.add(new demo());
					 ro1h.add(ro);
				}				      
		   }
			if(layer.getName().equals("spiderfv")){
				for(int i=0;i<screen.finalro2v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.finalro2v.get(i).x;
					ro.getRectangle().y=screen.finalro2v.get(i).y;
					 enemy2v.add(new semimos());
					 ro2v.add(ro);
				}
			      	
											      
		   }
			if(layer.getName().equals("spiderfh")){
				for(int i=0;i<screen.finalro2h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.finalro2h.get(i).x;
					ro.getRectangle().y=screen.finalro2h.get(i).y;
					 enemy2h.add(new semimos());
					 ro2h.add(ro);
				}					      
		   }
			if(layer.getName().equals("spidersv")){
				for(int i=0;i<screen.finalro3v.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.finalro3v.get(i).x;
					ro.getRectangle().y=screen.finalro3v.get(i).y;
					 enemy3v.add(new spiders());
					 ro3v.add(ro);
				}					      
		   }
			if(layer.getName().equals("spidersh")){
				for(int i=0;i<screen.finalro3h.size();i++){
					RectangleMapObject	ro=new RectangleMapObject();
					ro.getRectangle().x=screen.finalro3h.get(i).x;
					ro.getRectangle().y=screen.finalro3h.get(i).y;
					 enemy3h.add(new spiders());
					 ro3h.add(ro);
				}				      
		   }

						
		}
		}

	public void re(){
		music.play();
		if(screen.afinal!=null){
		screen.afinal.dispose();
	    screen.afinal=null;
	    System.gc();
		}
		 if(screen.story4!=null){
		 screen.story4.dispose();
		 screen.story4=null;
		 System.gc();
		 }
		 if(screen.gs!=null){
			 screen.gs.dispose();
			 GameScreen.assetManager2.clear();
			 screen.gs=null;
			 System.gc();
		 }
		 if(screen.chat6!=null){
			 screen.chat6.dispose();
			 screen.chat6=null;
			 System.gc();
		 }
	 }
	@Override
	public void draw() {
		
		findEnemy();
		meetstory();
	    change();
		if(player.x>=screenWidth/2&&player.x<=mapWidth-screenWidth/2)
			camera.position.x=(float)player.x;
			if(player.y>=screenHeight/2&&player.y<=mapHeight-screenHeight/2)
			camera.position.y=(float)player.y;
			
		batch.setProjectionMatrix(camera.combined);
		camera.update();
		batch.begin();
		 batch.draw(texture1, 0, 0, texture1.getWidth(), texture1.getHeight());
		 if(tex5)
			    batch.draw(texture5, camera.position.x-texture5.getWidth()/2, camera.position.y-texture5.getHeight()/2, texture5.getWidth(), texture5.getHeight());
			   
		  update(); 
	    door.draw(batch, 1);
	    player.draw(batch,1);
	   sq.draw(batch, 1);
	   hy.draw(batch, 1);
	   kongju.draw(batch, 1);
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
	    batch2.draw(texture3,Gdx.graphics.getWidth()-texture2.getWidth()/2-7+(player.x/5120)*248/2,Gdx.graphics.getHeight()-10-texture2.getWidth()/2+(player.y/3840)*248/2 , texture3.getWidth(), texture3.getHeight());	    
	    batch2.end();
		super.draw();
	}
    
	public void dispose(){
		
		map.dispose();
		music.dispose();
	}
}
