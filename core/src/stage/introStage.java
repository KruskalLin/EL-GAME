package stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.GameScreen;

public class introStage extends Stage {
	private Texture bgTexture;
	private BitmapFont bitmapFont;
	private TextField TextField;
	public boolean visible=false;
	GameScreen screen;
	public introStage(GameScreen screen,Viewport port){
		super(port);
		this.screen=screen;
		bitmapFont = new BitmapFont();
		bitmapFont.getData().setScale(2F);
		bgTexture=new Texture(Gdx.files.internal("background.jpg"));
		TextField.TextFieldStyle style = new TextField.TextFieldStyle();
		//style.background = new TextureRegionDrawable(new TextureRegion(bgTexture));
		style.font = bitmapFont;
		style.fontColor = new Color(0, 1, 1, 1);
		
		TextField = new TextField("死亡骑士统治了冰封王座，成为了新的一代aaaaa巫妖王，并且死亡骑士的法力大大增强，掌握了巫妖王的控制心灵的技能，"
				+ "所有的英雄几乎都被死亡骑士所控制.....", style);
		TextField.setSize(2208, 1242);
		TextField.setPosition(0, 0);
		
		TextField.setAlignment(Align.center);
		this.addActor(TextField);
	}
}
