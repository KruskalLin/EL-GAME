package storystage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

public class storystage2 extends Stage{
	Label text;
	String str;
	Texture ice;
	Texture chunhei;
	Image icei;
	Image chunheii;
	public boolean visible=false;
	static double statetime=0;   
	public Button button;
	GameScreen screen;
	Texture tbutton1;
	Texture tbutton2;
	public storystage2(Viewport viewport,GameScreen screen){
		this.screen=screen;
		str="欢迎来到诺德拉沙窟，这里有被黑化的英雄等待这你\n"
				+ "并且还会有狼人出没,\n"
				
				+ "还有一点，走出这个沙窟的秘密是顺序的，\n"
				;
		BitmapFont font= new BitmapFont(Gdx.files.internal("hero1.fnt"));
		Label.LabelStyle lstyle= new Label.LabelStyle();
		lstyle.font=font;
		text=new Label(null, lstyle);
		text.setPosition(50,400);
		tbutton1=new Texture("input2/vbutton1.png");
		tbutton2=new Texture("input2/vbutton2.png");
		 Button.ButtonStyle style = new Button.ButtonStyle();
	     style.up = new TextureRegionDrawable(new TextureRegion(tbutton1));
	     style.over=new TextureRegionDrawable(new TextureRegion(tbutton2));
	     button=new Button(style);
	     button.setPosition(600, 50);
	     button.setSize(200, 50);
		ice=new Texture("input2/sandd.jpg");
		chunhei= new Texture("input2/black.png");
		icei=new Image(new TextureRegion(ice));
		chunheii= new Image(new TextureRegion(chunhei));
		chunheii.setPosition(0,-150);
		chunheii.setSize(2000,1200);
		icei.setSize(1920, 1080);
		button.addListener(new ClickListener(){
			public void clicked(InputEvent e,float x,float y){
				screen.story2.visible=false;
				screen.sandmap.visible=true;
				screen.sandmap.re();
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
	public void dispose(){
		tbutton1.dispose();
		tbutton2.dispose();
		ice.dispose();
		chunhei.dispose();
	}
}