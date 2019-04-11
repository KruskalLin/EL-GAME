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
import com.game.GameScreen;

import stage.assetstart;
import stage.mapStage;

public class setgroup extends Group{
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Texture texture;
    Label label;
    Texture texture1;
    Texture texture2;
    Texture texture3;
    Texture texture4;
    Texture texture5;
    Texture texture6;
    Texture texture7;
    Texture texture8;
    
    
    public setgroup(float x,float y,mapStage map){
    	texture1=new Texture("input2/save.png");
    	texture2=new Texture("input2/save2.png");
    	texture3=new Texture("input2/returng.png");
    	texture4=new Texture("input2/returng2.png");
    	texture5=new Texture("input2/exit.png");
    	texture6=new Texture("input2/exit2.png");
    	texture7=new Texture("input2/set1.png");
    	texture8=new Texture("input2/set3.png");
    	
    	BitmapFont font= new BitmapFont(Gdx.files.internal("input2/dhkfont.fnt"));
		Label.LabelStyle lstyle= new Label.LabelStyle();
		lstyle.font=font;
		
    	texture=new Texture("input2/group.png");        
    	Button.ButtonStyle style = new Button.ButtonStyle();           
	    style.up = new TextureRegionDrawable(new TextureRegion(texture1));
	    style.over=new TextureRegionDrawable(new TextureRegion(texture2));
	    button1=new Button(style);        
	    Button.ButtonStyle style2 = new Button.ButtonStyle(); 
	    style2.up = new TextureRegionDrawable(new TextureRegion(texture3));
	    style2.over=new TextureRegionDrawable(new TextureRegion(texture4));
	    button2=new Button(style2);
	    Button.ButtonStyle style3 = new Button.ButtonStyle(); 
	    style3.up = new TextureRegionDrawable(new TextureRegion(texture5));
	    style3.over=new TextureRegionDrawable(new TextureRegion(texture6));
	    button3=new Button(style3);
	    Button.ButtonStyle style4 = new Button.ButtonStyle(); 
	    style4.up = new TextureRegionDrawable(new TextureRegion(texture7));
	    style4.over=new TextureRegionDrawable(new TextureRegion(texture8));
	    button4=new Button(style4);
	    button1.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		map.screen.map=map.rekind;
				map.screen.rox=map.player.x;
				map.screen.roy=map.player.y;
				map.screen.storeGame();	 
				map.sg.setVisible(false);
	    	}
	    });
	    button2.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		map.sg.setVisible(false);		
	    	}
	    });
	    button3.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		 map.visible=false;
	    		 map.dispose();
				 map.screen.astart=new assetstart(map.screen);
		    	 map.screen.astart.visible=true;
	    	}
	    });
	    button4.addListener(new ClickListener(){
	    	public void clicked(InputEvent e,float x,float y){
	    		
	    	}
	    });
	    button1.setPosition(0, 0);
	    button2.setPosition(0, 100);
	    button3.setPosition(0, 200);
	    button4.setPosition(0, 300);
	    

	    
	  
	    button1.setSize(330, 110);
	    button2.setSize(330, 110);
	    button3.setSize(330, 110);
	    button4.setSize(330, 110);
	    this.setPosition(x, y);
	    this.addActor(button1);
	    this.addActor(button2);
	    this.addActor(button3);
	    this.addActor(button4);
    }                             
    public void draw(Batch batch, float alpha) {         
		 batch.draw(texture,this.getX(),this.getY(),texture.getWidth()*(float)1.5, texture.getHeight()*(float)1.3);
		 super.draw(batch, 1);                                                
	} 
    
    public void dispose(){
    	texture.dispose();
    	texture1.dispose();
    	texture2.dispose();
    	texture3.dispose();
    	texture4.dispose();
    	texture5.dispose();
    	texture6.dispose();
    	texture7.dispose();
    	
    }
}
