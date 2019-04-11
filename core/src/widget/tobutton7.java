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

public class tobutton7 extends newButton{
	 private Label label;
	 Texture texture1;
	 Texture texture2;
	 Button.ButtonStyle style = new Button.ButtonStyle();
	
	 public tobutton7(float x, float y, mapStage stage) {
		   super(x, y, stage);
		Label.LabelStyle style2=new Label.LabelStyle();
      style2.font=bitmapFont;
      label=new Label(stage.screen.tool1c+"", style2);
      label.setColor(Color.RED);
      label.setPosition(40, 0);
     texture1=new Texture("input2/zhonglan.png");
     texture2=new Texture("input2/zhonglan2.png");
      style.up = new TextureRegionDrawable(new TextureRegion(texture1));
      style.over=new TextureRegionDrawable(new TextureRegion(texture2));
      b=new Button(style);
      b.setPosition(0, 0);
      b.addListener(new ClickListener() {
     	 @Override
          public void clicked(InputEvent event, float x, float y) {
     		stage.sound.play();
     		  if(stage.screen.tool7c>0){
                  stage.screen.magic+=75;
                  if(stage.screen.magic>=stage.screen.maxMgic){
                	  stage.screen.magic=stage.screen.maxMgic;
                  }
                  stage.screen.tool7c-=1;
                  stage.updateItem();
       		      }
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
      tf.setText("中蓝瓶：      恢复75魔法");
      this.addActor(b);                
      this.addActor(label);                     
	}                           
	 public void dispose(){
		 texture1.dispose();
		 texture2.dispose();
	 }
	 
	 @Override                    
		public void update(){                           
			label.setText(stage.screen.tool7c+"");                      
			if(stage.screen.tool7c==0){                               
				style.up=new TextureRegionDrawable(new TextureRegion(texture2));
				style.over=new TextureRegionDrawable(new TextureRegion(texture2));
			}else{                                              
				 style.up = new TextureRegionDrawable(new TextureRegion(texture1));
			     style.over=new TextureRegionDrawable(new TextureRegion(texture2));
			}
			
		}

}

