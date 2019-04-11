package widget;
                            
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;

import stage.GameStage;
                               
public class Victory extends Group implements Disposable{
	 private Texture plat;
	 public Label label;
	 public Label label2;
	 public Button button;
	 protected BitmapFont bitmapFont;
	 public GameStage stage;
	 public Victory(int x,int y,GameStage stage){
		 this.stage=stage;
		 plat=new Texture("input2/victory.png");
		 bitmapFont=new BitmapFont(Gdx.files.internal("color/Font.fnt"));
		 Label.LabelStyle style2=new Label.LabelStyle();
	     style2.font=bitmapFont;
	     label=new Label("", style2);
	     label.setFontScale(3);
	     label2=new Label("",style2);
	     label2.setFontScale(3);
	     Button.ButtonStyle style = new Button.ButtonStyle();
	     style.up = new TextureRegionDrawable(new TextureRegion(new Texture("input2/vbutton1.png")));
	     style.over=new TextureRegionDrawable(new TextureRegion(new Texture("input2/vbutton2.png")));
	     button=new Button(style);
	     button.setSize(400, 100);
	     label.setPosition(300, 400);
	     label2.setPosition(300,300);
	     button.setPosition(300, 120);
	     button.addListener(new ClickListener(){
	    	 public void clicked(InputEvent e,float x,float y){
	    		 stage.remap();	
	    	 }
	     });
	     this.addActor(button);
	     this.addActor(label);
	     this.addActor(label2);
		 this.setPosition(x, y);
		 this.setSize(plat.getWidth(), plat.getHeight());
	 }                      
	 public void draw(Batch batch, float alpha) {
		                             
		   	batch.draw(plat,this.getX()-140,this.getY()-155,plat.getWidth()*(float)1.5,plat.getHeight()*(float)1.5);
		    super.draw(batch, 1);          
		   	}                 
	@Override                       
	public void dispose() {                   
		plat.dispose();                          
	}                       
}                                          
