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

public class tobutton5 extends newButton{
	 private Label label;
	 Texture texture1;
	 Texture texture2;
	 Button.ButtonStyle style = new Button.ButtonStyle();
	
	 public tobutton5(float x, float y, mapStage stage) {
		   super(x, y, stage);
		Label.LabelStyle style2=new Label.LabelStyle();
       style2.font=bitmapFont;
       label=new Label(stage.screen.tool1c+"", style2);
       label.setColor(Color.RED);
       label.setPosition(40, 0);
      texture1=new Texture("input2/zhonghong.png");
      texture2=new Texture("input2/zhonghong2.png");
       style.up = new TextureRegionDrawable(new TextureRegion(texture1));
       style.over=new TextureRegionDrawable(new TextureRegion(texture2));
       b=new Button(style);
       b.setPosition(0, 0);
       b.addListener(new ClickListener() {
      	 @Override
           public void clicked(InputEvent event, float x, float y) {
      		stage.sound.play();
      		  if(stage.screen.tool2c>0){
                  stage.screen.blood+=400;
                  if(stage.screen.blood>=stage.screen.maxBlood){
                	  stage.screen.blood=stage.screen.maxBlood;
                  }
                  stage.screen.tool2c-=1;
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
       tf.setText("中血瓶：      恢复400血量");
       this.addActor(b);                
       this.addActor(label);                     
	}                           
	      public void dispose(){
	    	  texture1.dispose();
	    	  texture2.dispose();
	      }
	 @Override                    
		public void update(){                           
			label.setText(stage.screen.tool2c+"");                      
			if(stage.screen.tool2c==0){                               
				style.up=new TextureRegionDrawable(new TextureRegion(texture2));
				style.over=new TextureRegionDrawable(new TextureRegion(texture2));
			}else{                                              
				 style.up = new TextureRegionDrawable(new TextureRegion(texture1));
			     style.over=new TextureRegionDrawable(new TextureRegion(texture2));
			}
			
		}

}

