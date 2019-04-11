package stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

import net.mwplay.cocostudio.ui.CocoStudioUIEditor;
import net.mwplay.cocostudio.ui.widget.TTFLabel;
import widget.GameSet;
import widget.setgroup;

public class startStage2 extends Stage {
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Label  label0;
	Label  label1;
	Label  label2;
	Label  label3;
	Label  label4;
	Texture texture;
	SpriteBatch batch;
	public GameSet gset;
	public GameScreen screen;
	public boolean visible;
	public static Music music;
	public static Sound sound;
	CocoStudioUIEditor editor;
	FileHandle defaultFont;
	
	public startStage2(GameScreen screen, Viewport viewport) {
	        super( viewport);
	        init();
			this.screen=screen;
	    }
	 public void init(){
		 gset=new GameSet(900,400,screen);
		 gset.setVisible(false);
		 this.addActor(gset);
		 batch=new SpriteBatch();
		music=GameScreen.assetManager.get("input1/mymusic.ogg", Music.class);
		sound=GameScreen.assetManager.get("sound2/sound2.wav", Sound.class);
	    defaultFont = Gdx.files.internal("input1/fff.fnt");;
	    Label.LabelStyle style2=new Label.LabelStyle();
        style2.font=new BitmapFont(defaultFont);
	    Button.ButtonStyle style = new Button.ButtonStyle();   
	    style.up = new TextureRegionDrawable(new TextureRegion(GameScreen.assetManager.get("input1/button.png", Texture.class)));
	    style.over=new TextureRegionDrawable(new TextureRegion(GameScreen.assetManager.get("input1/button2.png", Texture.class)));
	    label0=new Label("新的冒险", style2);
	    label1=new Label("继续征程", style2);
	    label2=new Label("立即游戏", style2);
	    label3=new Label("游戏帮助", style2);
	    label4=new Label("游戏设置", style2);
	    button0=new Button(style);
	    button1=new Button(style);
	    button2=new Button(style);
	    button3=new Button(style);
	    button4=new Button(style);
	    button0.setOrigin(0,200);
	    button1.setOrigin(0,500);
	    button2.setOrigin(0,500);
	    button3.setOrigin(0,500);
	    button4.setOrigin(0,300);
	    label0.setPosition(1700, 1000);
	    label1.setPosition(1700, 790);
	    label2.setPosition(1700, 570);
	    label3.setPosition(1700, 360);
	    label4.setPosition(1700, 150);
	    button0.setPosition(1600, 900);
	    button1.setPosition(1600, 690);
	    button2.setPosition(1600, 470);
	    button3.setPosition(1600, 260);
	    button4.setPosition(1600, 50);
	    button0.setScale(100);
	    button0.setSize(600, 300);
	    button1.setSize(600, 300);
	    button2.setSize(600, 300);
	    button3.setSize(600, 300);
	    button4.setSize(600, 300);
	    button0.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		music.pause();
	    	    screen.isStore=false;
	    	    visible=false;  
	    	    screen.hero1="BladeMaster";
	    	    GameScreen.assetManager.clear();
	    	    screen.initmain();
	    	    screen.mood=false;
	    	    //sound.play();
	    	}
	    });
	    button1.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		music.pause();                   
	    	    screen.isStore=true;  
	    	    screen.hero1="BladeMaster";
	    	    GameScreen.assetManager.clear();                    
	    	    screen.initmain2();                               
	    	    visible=false;
	    	    screen.mood=false;
	    	    //sound.play();
	    	}                                      
	    });                        
	    button2.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		music.pause();
	    	    screen.isStore=true;
	    	    GameScreen.assetManager.clear();
	    	    screen.achoice2=new assetchoice2(screen);
	 		    screen.achoice2.visible=true;
	    	    visible=false;
	    	    //sound.play();
	    	}
	    });
	    button4.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		gset.setVisible(true);
	    		//sound.play();
	    	}
	    });
	   
	    music.setVolume(GameScreen.volume1);
	    music.play();
	    texture=GameScreen.assetManager.get("input1/bei.jpg", Texture.class);
        this.addActor(button0);
        this.addActor(button1);
        this.addActor(button2);
        this.addActor(button3);
        this.addActor(button4);
        this.addActor(label0);
        this.addActor(label1);
        this.addActor(label2);
        this.addActor(label3);
        this.addActor(label4);
        
	 }
	 @Override
	 public void draw(){
		 batch.begin();
		 batch.draw(texture, 0, 0, texture.getWidth()*(float)1.07, texture.getHeight()/(float)1.05);
		 batch.end();
		 super.draw();
	 }
	 public void dispose(){
		 this.clear(); 
		 super.dispose();
		 music.dispose();
		 texture.dispose();
		 sound.dispose();
	 }
}

 
