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
import stage.mapStage;

public class chatstage2 extends Stage {
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
	public chatstage2(Viewport port,mapStage stage){
		//每一个跳转都是由button构成的，所以只要
		super(port);
		this.mstage=stage;
		dhk1=new Texture("story/ouwen.png");
		dhk2=new Texture("story/ouwen.png");
		
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
		嘿，年轻人我等你很久了，能来到这里想必一路上你已经经历过不少的战斗了，
                   是否为不能狗回复生命而感到枯燥？
                  只要你帮我去左手边的药店处带来一瓶超大红和一瓶超大蓝，
                  我就教你一招生命图腾如何？
		*/
		/*年轻人，这么快你就拿到了药品，
很好接下来去寻找左上角的女巫吧，
他会告诉你走出卡姆拉雪原的秘密。
孩子，在你将来遇到困难时，记得大叔一直与你同在。
*/
		if(!stage.screen.mystory32){
		str1="嘿，年轻人我等你很久了，能来到这里想必一路上你已经经历过不少的战斗了，";
		str2=" 是否为不能够回复生命而感到枯燥？";
		str3="只要你帮我去左手边的药店处带来一瓶超大红和一瓶超大蓝，";
		str4=" 我就教你一招生命图腾如何？";
		}else{
			str1="年轻人，这么快你就拿到了药品，";
			str2="很好接下来去寻找左上角的女巫吧，";
			str3="他会告诉你走出卡姆拉雪原的秘密。";
			str4="孩子，在你将来遇到困难时，记得大叔一直与你同在。";
					
		}
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
