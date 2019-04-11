package stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

import net.mwplay.cocostudio.ui.CocoStudioUIEditor;
import widget.sureStage;
public class shopStage extends Stage {
	public sureStage stage;
	public GameScreen screen;
	Button button;
	public boolean visible;
	public int kind;
	public shopStage(Viewport viewport,GameScreen screen){
		super(viewport);
		this.screen=screen;
		 Button.ButtonStyle style = new Button.ButtonStyle();
	     style.up = new TextureRegionDrawable(new TextureRegion(new Texture("input2/vbutton1.png")));
	     style.over=new TextureRegionDrawable(new TextureRegion(new Texture("input2/vbutton2.png")));
	     button=new Button(style);
	     button.setSize(400, 100);
	     button.setPosition(1500, 100);
	     button.addListener(new ClickListener(){
	    	 public void clicked(InputEvent e,float x,float y){
	    		 visible=false;
	    		 screen.stage.visible=true;
	    		 screen.stage.player.y-=70;
	    		 screen.stage.ro.getRectangle().y-=70;
	    		 screen.stage.updateItem();
	    		 screen.stage.re();
	    		 
	    	 }
	     });
		stage=new sureStage(this);
		FileHandle defaultFont = Gdx.files.internal("input2/ziti.ttf");;
	    CocoStudioUIEditor editor = new CocoStudioUIEditor(
	    Gdx.files.internal("input2/MainScene.json"), null, null, defaultFont, null);
	    Group group = editor.createGroup();
	    this.addActor(group);
	    addActor(stage);
	    addActor(button);
	    stage.setVisible(false);
    	for(int i=1;i<=10;i++){
    
    	group.findActor("Button_1").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将花费100金币购买此道具");
    			kind=1;
    		}
    	});
    	group.findActor("Button_2").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将花费300金币购买此道具");
    			kind=2;
    		}
    	});
    	group.findActor("Button_3").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将花费600金币购买此道具");
    			kind=3;
    		}
    	});
    	group.findActor("Button_4").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将花费1000金币购买此道具");
    			kind=4;
    		}
    	});
    	group.findActor("Button_5").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您无法购买此道具");
    			kind=5;
    		}
    	});
    	group.findActor("Button_6").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将花费100金币购买此道具");
    			kind=6;
    		}
    	});
    	group.findActor("Button_7").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将花费300金币购买此道具");
    			kind=7;
    		}
    	});
    	group.findActor("Button_8").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将花费600金币购买此道具");
    			kind=8;
    		}
    	});
    	group.findActor("Button_9").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将花费1000金币购买此道具");
    			kind=9;
    		}
    	});
    	group.findActor("Button_10").addListener(new ClickListener(){
    		public void clicked(InputEvent e,float x,float y){
    			screen.stage.sound.play();
    			stage.setVisible(true);
    			stage.label.setText("您将无法购买此道具");
    			kind=10;
    		}
    	});
    	
    }
	  
	}
	public void remove(){
	    
	}
	
	
	
}

