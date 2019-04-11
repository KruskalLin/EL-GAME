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
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;

import stage.mapStage;
	
public class chatStage extends Stage {
	Texture dhk1;
	Texture dhk2;
	Image dhki;
	Image dhki2;
	Texture b11;
	Texture b22;
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	String str1;
	String str2;
	String str3;
	String str4;
	Label text1;
	Label text2;
	Label text3;
    Label text4;
	public boolean visible;
	public mapStage mstage;
	public Texture background;
	public chatStage(Viewport port,mapStage stage){
		//每一个跳转都是由button构成的，所以只要
		super(port);
		this.mstage=stage;
		dhk1=new Texture("story/start.png");
		dhk2=new Texture("story/start.png");
		
		dhki= new Image(new TextureRegion(dhk1));
		dhki.setSize(1500, 200);
		dhki.setPosition(200, 50);
		
		dhki2= new Image(new TextureRegion(dhk2));
		dhki2.setSize(1500, 200);
		dhki2.setPosition(200, 50);
		//上面是两个对话框的初始化
		
		b11=new Texture("input3/next.png");
		b22=new Texture("input3/next2.png");
		Button.ButtonStyle bstyle= new Button.ButtonStyle();
		bstyle.up=new TextureRegionDrawable(new TextureRegion(b11));
		bstyle.down=new TextureRegionDrawable(new TextureRegion(b22));
		b1=new Button(bstyle);
		b1.setSize(100, 100);
		b1.setPosition(1600, 40);
		b1.addListener(new ClickListener(){
			public void clicked(InputEvent v,float x, float y){
		
				addActor(text2);
				addActor(b2);
				
				
				text1.remove();
				b1.remove();
			}
		});
		b2=new Button(bstyle);
		b2.setSize(100, 100);
		b2.setPosition(1600, 40);
		b2.addListener(new ClickListener(){
			public void clicked(InputEvent v,float x,float y){
			    text2.remove();
				b2.remove();
						

				addActor(text3);
				addActor(b3);
				}
		});
		b3=new Button(bstyle);
		b3.setSize(100, 100);
		b3.setPosition(1600, 40);
		b3.addListener(new ClickListener(){
			public void clicked(InputEvent v,float x,float y){
			    text3.remove();
				b3.remove();
			
	
				addActor(text4);
				addActor(b4);
				}
		});
		b4=new Button(bstyle);
		b4.setSize(100, 100);
		b4.setPosition(1600, 40);
		b4.addListener(new ClickListener(){
			public void clicked(InputEvent v,float x,float y){
			        visible=false;
			        mstage.re();
				}
		});
		
		
		//这边是跳转button的初始化，注意好顺序即可，以上都是一样的
		/*
		欢迎来到艾泽拉斯大陆的卡姆拉雪原，你是上帝派来解救我们的勇士吗？
		噢，我们的日子实在是不好过，看到那遍布雪原 的怪兽了嘛，
		但凡走近他们就会开始战斗，每次战斗结束你都会获得一定的经验与金钱。
		熟悉了这些后就快去找雪原右下角的欧文大叔吧，他等你很久了。
		*/
		
		str1="欢迎来到艾泽拉斯大陆的卡姆拉雪原，你是上帝派来解救我们的勇士吗？";
		str2="噢，我们的日子实在是不好过，看到那遍布雪原 的怪兽了嘛";
		str3="但凡走近他们就会开始战斗，每次战斗结束你都会获得一定的经验与金钱";
		str4="熟悉了这些后就快去找雪原右下角的欧文大叔吧，他等你很久了。";
		//这边是所有对话String的初始化
		
		
		BitmapFont font= new BitmapFont(Gdx.files.internal("input3/dhkfont.fnt"));
		Label.LabelStyle lstyle= new Label.LabelStyle();
		lstyle.font=font;	
		text1=new Label(null, lstyle);
		text2=new Label(null, lstyle);
		text3=new Label(null, lstyle);
		text4=new Label(null, lstyle);
		text1.setPosition(470, 150);
		text2.setPosition(470, 150);
		text3.setPosition(470, 150);
		text4.setPosition(470, 150);
		text1.setText(str1);
		text2.setText(str2);
		text3.setText(str3);
		text4.setText(str4);
		//所有label的初始化
		
		
		//返回地图的button的初始化
		//此处还要初始化background
		addActor(dhki);
		addActor(text1);
		addActor(b1);
	}
	
	public void draw(){
		super.draw();
	}
	
}
