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

public class abbutton4  extends newButton{
	 private Label label;
	public abbutton4(float x, float y, mapStage stage) {
		   super(x, y, stage);
      Button.ButtonStyle style = new Button.ButtonStyle();
      style.up = new TextureRegionDrawable(new TextureRegion(new Texture("Skill4.png")));
      style.over=new TextureRegionDrawable(new TextureRegion(new Texture("Skill4black.png")));
      b=new Button(style);
      b.setPosition(0, 0);
      b.addListener(new ClickListener() {
     	 @Override
          public void clicked(InputEvent event, float x, float y) {
                
          }
     	 @Override
     	 public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
             intro.addActor(tf);
          }
     	 @Override
          public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
           intro.removeActor(tf);
          }
     });
      
      tf.setText("技能4：  幻影");
      this.addActor(b);
      
	}

}
