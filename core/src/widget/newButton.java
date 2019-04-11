package widget;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;
import com.game.GameScreen;

import stage.mapStage;

public abstract class newButton extends Group implements Disposable {
	    public Button b;
	    protected Label tf;
	    mapStage stage;
	    protected BitmapFont bitmapFont;
	    public boolean isClicked=false;
	    public introduction intro;
	    public newButton(float x,float y,mapStage stage){  
	    	this.stage=stage;
	    	this.intro=stage.intro;
	        bitmapFont=new BitmapFont(Gdx.files.internal("color/Font.fnt"));	         
	        Label.LabelStyle style=new Label.LabelStyle();
	        style.font = bitmapFont;
	        style.fontColor=new Color(1,1,1,1);
	        tf=new Label("蓝",style); 
	        tf.setAlignment(Align.topLeft);
	        tf.setPosition(-20, -50);
	        tf.setVisible(true);
	        tf.scaleBy(0.5F, 0);
	        this.setPosition(x, y);
	       
	    }
	    public void update(){
	    	
	    }
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

}
