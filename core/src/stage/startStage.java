package stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;
import com.game.MainGame;

import net.mwplay.cocostudio.ui.CocoStudioUIEditor;
import net.mwplay.cocostudio.ui.widget.TTFLabel;

public class startStage extends Stage {
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	public GameScreen screen;
	public boolean visible;
	Music music;
	CocoStudioUIEditor editor;
	public startStage(GameScreen screen, Viewport viewport) {
	        super( viewport);
	        init();
			this.screen=screen;
	    }
	 public void init(){
		music=Gdx.audio.newMusic(Gdx.files.internal("input1/mymusic.ogg"));
	    FileHandle defaultFont = Gdx.files.internal("input1/ZITI.TTF");;
	    editor = new CocoStudioUIEditor(Gdx.files.internal("input1/MainScene1.json"), null, null, defaultFont, null);
	    Group group = editor.createGroup();
	    button0=(Button)editor.findActor("button10");
	    button1=editor.findActor("button11");
	    button2=(Button)editor.findActor("button12");
	    button3=editor.findActor("button13");
	    button4=(Button)editor.findActor("button14");
	    button0.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		music.pause();
	    	    screen.isStore=false;
	    	   screen.initmain();
	    	    visible=false;
	    	 
	    	}
	    });
	    button1.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		music.pause();
	    	    screen.isStore=true;
	    	    screen.initmain2();
	    	    visible=false;
	    	    System.out.println("sss");
	    	}
	    });
	    music.play();
        TTFLabel text2=editor.findActor("text2");
	    text2.setText("20000");
	    addActor(group);
	 }
	 public void dispose(){
		 this.clear(); 
		 super.dispose();
		 music.dispose();
	 }
}

 