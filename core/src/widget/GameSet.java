package widget;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.game.GameScreen;

import stage.startStage2;
public class GameSet  extends Group{
    Button button1;
    Texture texture;
    Label label;
    Label label2;
    public Slider slider;
    public Slider slider2;
    public Texture slider_background;
    public Texture slider_knob;
    public GameScreen screen2;
    public GameSet(float x,float y,GameScreen screen){
    	BitmapFont font= new BitmapFont(Gdx.files.internal("hero/ffont.fnt"));
		Label.LabelStyle lstyle= new Label.LabelStyle();
		screen2=screen;
		lstyle.font=font;
		label=new Label("背景音量",lstyle);
		label2=new Label("游戏音效",lstyle);
    	texture=new Texture("input2/group.png");        
    	Button.ButtonStyle style = new Button.ButtonStyle();           
	    style.up = new TextureRegionDrawable(new TextureRegion(new Texture("hero/sure.png")));
	    style.over=new TextureRegionDrawable(new TextureRegion(new Texture("hero/sure2.png")));
	    button1=new Button(style); 
	    slider_background = new Texture(Gdx.files.internal("hero/background.png"));
        slider_knob = new Texture(Gdx.files.internal("hero/knob.png"));
	    Slider.SliderStyle ss = new Slider.SliderStyle();
        ss.background = new TextureRegionDrawable(new TextureRegion(slider_background));
        ss.knob = new TextureRegionDrawable(new TextureRegion(slider_knob));
        slider = new Slider(0f, 10f, 1f, false, ss);
        slider2 = new Slider(0f, 10f, 1f, false, ss);
        slider.setValue(5);
        slider2.setValue(5);
        
 	    button1.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    			setVisible(false);	
	    	}
	    });
	    button1.setPosition(0, 0);
	    label.setPosition(30, 300);
	    label2.setPosition(30, 150);
	    slider.setPosition(180, 300);
	    slider2.setPosition(180, 150);
	    this.addActor(label);
	    label.setVisible(true);
	    button1.setSize(330, 110);
	   slider.addListener(new ChangeListener(){

		@Override
		public void changed(ChangeEvent event, Actor actor) {
			GameScreen.volume1=slider.getVisualPercent();
			
			
			startStage2.music.setVolume(GameScreen.volume1);
			
		}
		    
	   });
	    this.setPosition(x, y);
	    this.addActor(button1);
	    this.addActor(label);
	    this.addActor(label2);
	    this.addActor(slider);
	    this.addActor(slider2);
    }                             
    public void draw(Batch batch, float alpha) {         
		 batch.draw(texture,this.getX(),this.getY(),texture.getWidth()*(float)1.5, texture.getHeight()*(float)1.3);
		 super.draw(batch, 1);                                                
	}                  
}
