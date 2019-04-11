package stage;                                      
                                                
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
                             
import mapHero.*;
import mapNpc.qseller;
import storystage.storyStage1;
import storystage.storystage3;
import widget.ToolGroup;
import widget.abbutton1;
import widget.abbutton2;
import widget.abbutton3;
import widget.abbutton4;
import widget.infbutton1;
import widget.infbutton2;
import widget.introduction;
import widget.progressBar2;
                                   
public class snowMap extends mapStage {
	public boolean mstory;
    jiansheng player2;
    xiongmao player3;
    shengqishi player4;
    xianzhi player5;
    nvjisi player6;
   
    emolieshou player7;
   public snowMap(GameScreen screen,Viewport port){
		super(screen,port);
		music = Gdx.audio.newMusic(Gdx.files.internal("sound2/peace.mp3"));
		music.setLooping(true);
		music.play();
    	rekind="snow";
		batch2=new SpriteBatch();
		mapWidth=5700;
		mapHeight=5100;
		map = new TmxMapLoader().load("input2/snowmap.tmx");
		 texture9=new Texture("input2/kuang.png");
		texture1 = (GameScreen.assetManager.get(("input2/snowmap.jpg"),Texture.class));
  		texture2=(GameScreen.assetManager.get(("input2/snowmap2.jpg"),Texture.class));
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
  		player2=new jiansheng();
  		player3=new xiongmao();
  		player4=new shengqishi();
  		player5=new xianzhi();
  		player6=new nvjisi();
  		player7=new emolieshou();
  
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
			screen.afinal=new assetfinal(screen);
			screen.afinal.visible=true;	
		}
	}
		if(mstory){
			temp+=Gdx.graphics.getDeltaTime();
			if(temp>=2){
				temp=0;
			 this.visible=false;
			  screen.story3=new storystage3(new StretchViewport(2208, 1242),screen);
			  screen.story3.visible=true;
             story.clear();
             mstory=false;
             tap=true;
		}
		}
		
	}
	@Override
	public void findEnemy() {
		MapLayers layers = map.getLayers();	
		for(MapLayer layer : layers){
			if(!screen.BladeMaster){
		if(layer.getName().equals("player2")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="jiansheng";
						 screen.BladeMaster=true;
					}
					}
				
				}	      
			}
			if(!screen.PandaBrewmaster2){
		if(layer.getName().equals("player3")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="xiongmao";
						 screen.PandaBrewmaster2=true;
					}
					}
				
				}	
			}
			if(!screen.Paladin2){
		if(layer.getName().equals("player4")){
            MapObjects objs = layer.getObjects();
			for(MapObject obj : objs ){
					RectangleMapObject	ro1= (RectangleMapObject) obj;
					if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
						 tex5=true;
						 tap=false;
						 kenemy="shengqishi";
						 screen.Paladin2=true;
					}              
					}               
				}	                 
		                     
		}               
			if(!screen.FarSeer2){
				if(layer.getName().equals("player5")){
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
			if(!screen.POM2){
				if(layer.getName().equals("player6")){
		            MapObjects objs = layer.getObjects();
					for(MapObject obj : objs ){
							RectangleMapObject	ro1= (RectangleMapObject) obj;
							if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
								 tex5=true;
								 tap=false;
								 kenemy="nvjisi";
								 screen.POM2=true;
							}
							}
						}	      
				
				}
			if(!screen.DemonHunter2){
				if(layer.getName().equals("player7")){
		            MapObjects objs = layer.getObjects();
					for(MapObject obj : objs ){
							RectangleMapObject	ro1= (RectangleMapObject) obj;
							if (Intersector.overlaps(ro1.getRectangle(), ro.getRectangle())) {
								 tex5=true;
								 tap=false;
								 kenemy="emolieshou";
								 screen.DemonHunter2=true;
							}
							}
						}	      
				
				}
		}
		
		}
		     

	public void meetstory(){
		if(!screen.snowstory){
	      	for(int i=0;i<story.size();i++){
	  			RectangleMapObject obj=story.get(i);
	  			if (Intersector.overlaps(obj.getRectangle(), ro.getRectangle())) {
	  				  tap=false;
	  				  mstory=true;	
	  				  screen.snowstory=true;
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
			if(layer.getName().equals("player6")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player6.x=ro.getRectangle().x;
						player6.y=ro.getRectangle().y;
					
					}	      
				}
			if(layer.getName().equals("player7")){
	            MapObjects objs = layer.getObjects();
				for(MapObject obj : objs ){
						RectangleMapObject	ro = (RectangleMapObject) obj;
						player7.x=ro.getRectangle().x;
						player7.y=ro.getRectangle().y;
					
					}	      
				}
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
	    player2.draw(batch,1);
	    player3.draw(batch,1);
	    player4.draw(batch,1);
	    player5.draw(batch,1);
	    player6.draw(batch,1);
	    player7.draw(batch,1);
	   
	    batch.end();
	    batch2.begin();
	    batch2.draw(texture9, Gdx.graphics.getWidth()-texture9.getWidth()/2+80, Gdx.graphics.getHeight()-texture9.getHeight()/2+80, texture9.getWidth()/(float)2.4, texture9.getHeight()/(float)2.4);
		   
	    batch2.draw(texture6, 0, Gdx.graphics.getHeight()-texture6.getHeight()/(float)1.4, texture6.getWidth()/(float)1.4, texture6.getHeight()/(float)1.4);batch2.draw(texture2,Gdx.graphics.getWidth()-texture2.getWidth()/2-7, Gdx.graphics.getHeight()-texture2.getHeight()/2-10, texture2.getWidth()/2, texture2.getHeight()/2);
	    batch2.draw(texture3,Gdx.graphics.getWidth()-texture2.getWidth()/2-7+(player.x/5700)*248/2,Gdx.graphics.getHeight()-10-texture2.getWidth()/2+(player.y/5100)*248/2 , texture3.getWidth(), texture3.getHeight());	    
	    batch2.end();
		super.draw();
	}
	public void re(){
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
