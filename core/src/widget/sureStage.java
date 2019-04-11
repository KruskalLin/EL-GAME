package widget;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;

import net.mwplay.cocostudio.ui.CocoStudioUIEditor;
import stage.mapStage;
import stage.shopStage;

public class sureStage  extends Group {
	Texture dialogt;
	Window window;
	Button buttonok;
	Button buttoncancel;
	Texture okup;
	Texture okdown;
	Texture cancelup;
	Texture canceldown;
	public Label label;
	SpriteBatch batch;

	
	
	public sureStage(shopStage stage) {
		batch=new SpriteBatch();
		dialogt= new Texture(Gdx.files.internal("input2/yaodiandhk.png"));
		BitmapFont font= new BitmapFont(Gdx.files.internal("input2/dhkfont.fnt"));
		TextureRegionDrawable WindowDrawable = new TextureRegionDrawable(new TextureRegion(dialogt)); 
		WindowStyle style= new WindowStyle(font,font.getColor(),WindowDrawable);
		window= new Window("",style);
		window.setSize(1200, 600);
		window.setPosition(550, 400	);
		window.setModal(false);	
		okup= new Texture("input2/dhkanniuok.png");
		okdown= new Texture("input2/dhkanniuok2.png");
		Button.ButtonStyle styleok = new Button.ButtonStyle(); 
	    styleok.up = new TextureRegionDrawable(new TextureRegion(okup));
	    styleok.down = new TextureRegionDrawable(new TextureRegion(okdown));
	    buttonok = new Button(styleok);
	    buttonok.setPosition(800, 500);
	    buttonok.setHeight(80);
	    cancelup= new Texture("input2/dhkanniucancel.png");
	    canceldown= new Texture("input2/dhkanniucancel2.png");
	    Button.ButtonStyle stylecancel = new Button.ButtonStyle();
	    stylecancel.up= new TextureRegionDrawable(new TextureRegion(cancelup));
	    stylecancel.down= new TextureRegionDrawable(new TextureRegion(canceldown));
	    buttoncancel= new Button(stylecancel);
		buttoncancel.setPosition(1250, 500);
		buttoncancel.setHeight(80);
		
		Label.LabelStyle lstyle = new Label.LabelStyle();
		lstyle.font=font;
		//label的文字随着点击的button不同而不同
		label=new Label("你将花费1000金币购买此商品",lstyle);
		label.setPosition(780, 680);	                                                                                      
				                                
			addActor(label);                        
			addActor(buttonok);                           
			addActor(buttoncancel);                                  
			buttoncancel.addListener(new ClickListener(){                                
				public void clicked(InputEvent v, float x, float y){    
					stage.screen.stage.sound.play();
					stage.stage.setVisible(false);	                         
				}                                                    
			});                                                                          
			buttonok.addListener(new ClickListener(){                                   
				public void clicked(InputEvent v, float x, float y){  
					stage.screen.stage.sound.play();
				     switch(stage.kind){                                       
				     case 1:
				    	 if(stage.screen.money>=100){                        
				    		 stage.screen.money-=100;                     
				    		 stage.screen.tool1c+=1;                
				    		 stage.stage.setVisible(false);
				    	 }
				    	 
				         break;
				     case 2:
				    	 if(stage.screen.money>=300){
				    		 stage.screen.money-=300;
				    		 stage.screen.tool2c+=1;
				    		 stage.stage.setVisible(false);
				    	 }
				    	 break;
				     case 3:
				    	 if(stage.screen.money>=600){
				    		 stage.screen.money-=600;
				    		 stage.screen.tool3c+=1;
				    		 stage.stage.setVisible(false);
				    	 }	
				    	 break;
				     case 4:
				    	 if(stage.screen.money>=1000){
				    		 stage.screen.money-=1000;
				    		 stage.screen.tool4c+=1;
				    		 stage.stage.setVisible(false);
				    	 }
				    	 break;
				     case 5: 		
				    		 stage.stage.setVisible(false);
				    	 break;
				     case 6:	 
				    	 if(stage.screen.money>=100){
				    		 stage.screen.money-=100;
				    		 stage.screen.tool6c+=1;
				    		 stage.stage.setVisible(false);
				    	 }	
				    	 break;
				     case 7:
				    	 if(stage.screen.money>=300){
				    		 stage.screen.money-=300;
				    		 stage.screen.tool7c+=1;
				    		 stage.stage.setVisible(false);
				    	 }	
				    	 break;
				     case 8:
				    	 if(stage.screen.money>=600){
				    		 stage.screen.money-=600;
				    		 stage.screen.tool8c+=1;
				    		 stage.stage.setVisible(false);
				    	 }	
				    	 break;
				     case 9:
				    	 if(stage.screen.money>=1000){
				    		 stage.screen.money-=1000;
				    		 stage.screen.tool9c+=1;
				    		 stage.stage.setVisible(false);
				    	 }	
				    	 break;
				     case 10:	    	
				    		 stage.stage.setVisible(false);		    	 
				    	 break;
				    	 
				     }
				}
			});
			
	}
	@Override
	
	
	public void draw(Batch batch, float parentAlpha){	
		
		batch.draw(dialogt, 740, 450, dialogt.getWidth()*(float)1.5, dialogt.getHeight()*(float)1.5);
		super.draw(batch,1);
		
	}

	public void dispose(){
		 okup.dispose();;
		 okdown.dispose();;
	 	 cancelup.dispose();;
	     canceldown.dispose();
		 dialogt.dispose();
	}
}
