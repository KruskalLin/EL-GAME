package widget;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
                          
import stage.mapStage;                   
public class infbutton2 extends newButton{
	 private Label label;
	 private Label label2;
	public infbutton2(float x, float y, mapStage stage) {
	     super(x, y, stage);
	     Label.LabelStyle style2=new Label.LabelStyle();
	     style2.font=bitmapFont;
	     label=new Label("1", style2);
	     label.setPosition(-65, -30);
	     label2=new Label("1", style2);
	     label2.setPosition(-65, -100);
	     Button.ButtonStyle style = new Button.ButtonStyle();
	     style.up = new TextureRegionDrawable(new TextureRegion(new Texture("input2/baobutton1.png")));
	     style.over=new TextureRegionDrawable(new TextureRegion(new Texture("input2/baobutton2.png")));
	     b=new Button(style);
	     b.setPosition(0, 0);
	     b.addListener(new ClickListener() {
	    	 @Override
	         public void clicked(InputEvent event, float x, float y) {
                                                                               	                                                                                       
	         }            
	    	 @Override
	    	 public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
	            intro.addActor(tf);
	            intro.addActor(label);
	            intro.addActor(label2);
	         }
	    	 @Override
	         public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
	          intro.removeActor(tf);
	          intro.removeActor(label);
	          intro.removeActor(label2);
	         }
	    });
	     tf.setPosition(-65, -67);
	     tf.setText("魔法值 "+stage.screen.magic+"/"+stage.screen.maxMgic);
	     label.setText("生命值"+stage.screen.blood+"/"+stage.screen.maxBlood);
	     label2.setText("经验值 "+stage.screen.XP+"/"+stage.screen.maxXP);
	     this.addActor(b);
	     
		}

	    public void update(){
	    	 tf.setText("魔法值 "+stage.screen.magic+"/"+stage.screen.maxMgic);
		     label.setText("生命值"+stage.screen.blood+"/"+stage.screen.maxBlood);
		     label2.setText("经验值 "+stage.screen.XP+"/"+stage.screen.maxXP);
	    }
	}
