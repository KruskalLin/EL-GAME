package stage;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

import actor.BarGroup;
import actor.CusButton;
import mapActor.Player;
import mapActor.enemy;
import mapActor.fisherman;
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
import widget.setgroup;


public abstract class mapStage extends Stage {
	public  boolean visible=false;
	public boolean end;
	TiledMap map;
	Texture texture9;
	CusButton cbutton1;
	CusButton cbutton2;
	public static float stateTime=0;
	RectangleMapObject ro;
	public Player player;
	float initx;
	float inity;
	public String kenemy;
	public String rekind;
	public boolean tex5=false;	
	public LevelUp up;
	public boolean change=false;
	public  OrthographicCamera camera;
	SpriteBatch batch;
	SpriteBatch batch2;
	public setgroup sg;
	public Texture texture5;
	public  boolean tap=true;
	public int mapWidth;
	public int mapHeight;
	int screenWidth=2208;
	int screenHeight=1242;
	Image door;
	
	public introduction intro;
	public Music music;
	public Sound sound;
	 public abbutton1 button1;
     public abbutton2 button2;
     public abbutton3 button3;
     public abbutton4 button4;   
     ToolGroup tg;
     public progressBar2 bar2;
     public infbutton1 button;
     public  infbutton2 mbutton;
     
    public 	GameScreen screen;
	Texture texture1;
	Texture texture2;
	Texture texture3;
	Texture texture6;
	float temp=0;
	BarGroup bg; 
	public  ArrayList<RectangleMapObject> ro1h;
	public  ArrayList<RectangleMapObject> ro1v;
	public  ArrayList<RectangleMapObject> ro2h;
	public  ArrayList<RectangleMapObject> ro2v;
	public  ArrayList<RectangleMapObject> ro3h;
	public  ArrayList<RectangleMapObject> ro3v;
	
	public  ArrayList<RectangleMapObject> story;
	public  ArrayList<RectangleMapObject> story2;
	public  ArrayList<RectangleMapObject> story3;
	public  ArrayList<RectangleMapObject> story4;
	public  ArrayList<RectangleMapObject> shop;
	
    public mapStage(){
	}
	public mapStage(GameScreen screen,Viewport viewport){
		super(viewport);
		ro=new RectangleMapObject();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,2208,1242 );
		ro1h=new ArrayList<RectangleMapObject>();
	    ro1v=new ArrayList<RectangleMapObject>();
	    ro2h=new ArrayList<RectangleMapObject>();
	    ro2v=new ArrayList<RectangleMapObject>();
	    ro3h=new ArrayList<RectangleMapObject>();
	    ro3v=new ArrayList<RectangleMapObject>();
	    story=new ArrayList<RectangleMapObject>();
	    story2=new ArrayList<RectangleMapObject>();
	    story3=new ArrayList<RectangleMapObject>();
	    story4=new ArrayList<RectangleMapObject>();
	    shop=new ArrayList<RectangleMapObject>();
	    up=new LevelUp(400,400,this);
	    cbutton1=new CusButton(2000,50,new Texture("input2/set.png"),new Texture("input2/set2.png"),new Texture("input2/set2.png"),
	    		null,new Texture("textground.png"), "设置",true,0);
	     player=new Player();
	     door=new Image(GameScreen.assetManager.get(("input2/door.jpg"),Texture.class));
	     sound=Gdx.audio.newSound(Gdx.files.internal("sound2/button.wav"));
	     
	     this.screen=screen;
	     sg=new setgroup(1000,500,this);
	     sg.setVisible(false);
	     this.addActor(sg);
	     this.addActor(cbutton1);   
	 }
	 
	 public void update() {
		    enemy.tap=tap;
			if(tap){
		     stateTime += Gdx.graphics.getDeltaTime();
			 if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				        ro.getRectangle().x-=3;
				        if(passEnble(ro)){
				        	player.x=ro.getRectangle().x;
				        	player.currentFrame = player.walkAnimation2.getKeyFrame(stateTime);
				        }else{
				        	ro.getRectangle().x+=3;
				        }
				 
		       }
		        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
		        	  ro.getRectangle().x+=3;
				        if(passEnble(ro)){
				        	player.x=ro.getRectangle().x;
				        	player.currentFrame = player.walkAnimation4.getKeyFrame(stateTime);
				        }else{
				        	ro.getRectangle().x-=3;
				        }
		        	
		    }
		        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
		        	  ro.getRectangle().y-=3;
				        if(passEnble(ro)){
				        	player.y=ro.getRectangle().y;
				        	player.currentFrame = player.walkAnimation1.getKeyFrame(stateTime);
				        }else{
				        	ro.getRectangle().y+=3;
				        }
		        	
		    }
		        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
		        	  ro.getRectangle().y+=3;
				        if(passEnble(ro)){ 	
				        	player.y=ro.getRectangle().y;
				        	player.currentFrame = player.walkAnimation3.getKeyFrame(stateTime);
				        }else{
				        	ro.getRectangle().y-=3;
				        }          
		    }       
			}else{
				newView();
			}
			
	}
	 
	 public  boolean passEnble(RectangleMapObject ro){
	        MapLayers layers = map.getLayers();
			for(MapLayer layer : layers) {
		       if(layer.getName().equals("obstacle")){
	              MapObjects objs = layer.getObjects();
				   for(MapObject obj : objs ){
				   RectangleMapObject roe = (RectangleMapObject) obj;		
				   Rectangle rectangle = roe.getRectangle();
				      if (Intersector.overlaps(rectangle, ro.getRectangle())) {
				        return false;
				      }
				    }
		        }
				 }
			return true;
		}
     
	 public  abstract void newView();//里面可以加一些相对复杂的逻辑
	 
	 public abstract void findEnemy();
	 
	 public abstract void setMap();
	 
	 public  void draw(){
		 super.draw();
	 }
	 
	 public void updateItem(){
		 tg.update();
		 bar2.update();
		 button.update();
		 mbutton.update();
	 }
	 
	 public void re(){
		 
	 }
	 public void change(){
			MapLayers layers = map.getLayers();	
			for(MapLayer layer : layers){	
				if(layer.getName().equals("out")){
					 MapObjects objs = layer.getObjects();
					 for(MapObject obj : objs ){
							RectangleMapObject	ro = (RectangleMapObject) obj;
							door.setPosition(ro.getRectangle().x, ro.getRectangle().y);
							if (Intersector.overlaps(this.ro.getRectangle(), ro.getRectangle())) {
						           tap=false;   
						           change=true;
						      }
						}	  
				 }
			}
			
		}

     public void dispose(){
    	 
     }
}
