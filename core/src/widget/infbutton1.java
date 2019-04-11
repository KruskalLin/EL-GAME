package widget;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import stage.mapStage;

public class infbutton1 extends newButton{
	 private Label label;
	 private Label label2;
	public infbutton1(float x, float y, mapStage stage) {
		
     super(x, y, stage);
     Label.LabelStyle style2=new Label.LabelStyle();
     style2.font=bitmapFont;
     label=new Label("1", style2);
     label.setPosition(-65, -30);
     label2=new Label("1",style2);
     label2.setPosition(-65, -100);
     Button.ButtonStyle style = new Button.ButtonStyle();
     style.up = new TextureRegionDrawable(new TextureRegion(new Texture("input2/renbutton1.png")));
     style.over=new TextureRegionDrawable(new TextureRegion(new Texture("input2/renwubutton2.png")));
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
     tf.setPosition(-65, -70);
     label2.setText("金钱 "+stage.screen.money);
     label.setText("攻击"+"  "+stage.screen.attack+" 护甲"+"  "+stage.screen.defence+" 力量"+"  "+stage.screen.force);
     tf.setText("敏捷"+"  "+stage.screen.quick+" 智力 "+" "+stage.screen.intelligence+" 等级"+"  "+stage.screen.rank);
     this.addActor(b);
	}
	public void update(){
		label2.setText("金钱 "+stage.screen.money);
	     label.setText("攻击"+"  "+stage.screen.attack+" 护甲"+"  "+stage.screen.defence+" 力量"+"  "+stage.screen.force);
	     tf.setText("敏捷"+"  "+stage.screen.quick+" 智力 "+" "+stage.screen.intelligence+" 等级"+"  "+stage.screen.rank);
	}

}

