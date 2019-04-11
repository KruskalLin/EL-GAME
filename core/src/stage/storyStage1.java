package stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

public class storyStage1 extends Stage{
	Label text;
	String str;
	String str2;
	Texture ice;
	Texture chunhei;
	Image icei;
	Image chunheii;
	public boolean visible=false;
	static double statetime=0;   
	public Button button;
	GameScreen screen;
	
	public storyStage1(Viewport viewport,GameScreen screen){
		this.screen=screen;
		str="天地初开,乱世混沌一分为四,经过长期的\n纷乱割据,最终整个世界处在巫妖王的绝对统治之中";
		BitmapFont font= new BitmapFont(Gdx.files.internal("input2/dhkfont.fnt"));
		Label.LabelStyle lstyle= new Label.LabelStyle();
		lstyle.font=font;
		text=new Label(null, lstyle);
		text.setPosition(50,400);
		 Button.ButtonStyle style = new Button.ButtonStyle();
	     style.up = new TextureRegionDrawable(new TextureRegion(new Texture("input2/vbutton1.png")));
	     style.over=new TextureRegionDrawable(new TextureRegion(new Texture("input2/vbutton2.png")));
	     button=new Button(style);
	     button.setPosition(600, 50);
	     button.setSize(200, 50);
		ice=new Texture("input2/ice.png");
		chunhei= new Texture("input2/black.png");
		icei=new Image(new TextureRegion(ice));
		chunheii= new Image(new TextureRegion(chunhei));
		chunheii.setPosition(0,-150);
		chunheii.setSize(2000,1200);
		icei.setSize(1920, 1080);
		button.addListener(new ClickListener(){
			public void clicked(InputEvent e,float x,float y){
				screen.story.visible=false;
				screen.stage.visible=true;
				screen.stage.re();
			}
		});
		addActor(icei);
		addActor(chunheii);
		addActor(text);
		this.addActor(button);
		}
	public void draw(){
		super.draw();
		statetime+=Gdx.graphics.getDeltaTime();
		if((int)statetime/0.1<str.length()-1){
			try{
		text.setText(str.substring(0, (int) (statetime/0.1)));
			}catch(StringIndexOutOfBoundsException e){
				
			}
		}else{
			
		}
	}
}
