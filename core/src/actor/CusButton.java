package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;

public class CusButton extends Group implements Disposable{
    public Button b;
    public TextField tf;
    private Texture up;
    private Texture over;
    private Texture down;
    private Texture cool;
    private Texture textground;
    private BitmapFont bitmapFont;
    public int round=0;
    public int maxRound;
    public boolean isClicked=false;
    public CoolTime ct;
    public CusButton(float x,float y,Texture up,Texture over,Texture down,Texture cool,Texture textground,String str,boolean reverse,int maxRound){
    	this.maxRound=maxRound;
    	 this.up= up;
    	 this.over=over;
         this.down=down;
         if(cool!=null)
         this.cool=cool;
         if(maxRound!=0)
         ct=new CoolTime(maxRound);
    	Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(new TextureRegion(up));
        style.over=new TextureRegionDrawable(new TextureRegion(over));
        style.down=new TextureRegionDrawable(new TextureRegion(down));
        b=new Button(style);
        b.setPosition(0, 0);
        
        bitmapFont=new BitmapFont(Gdx.files.internal("color/hero2.fnt"));
        TextField.TextFieldStyle textstyle = new TextField.TextFieldStyle();
        this.textground=textground; 
        textstyle.background = new TextureRegionDrawable(new TextureRegion(textground));
        textstyle.font = bitmapFont;
        textstyle.fontColor=new Color(1,1,1,1);
        tf=new TextField("hahaha",textstyle); 
        tf.setAlignment(Align.center);
        tf.setText(str);
        if(!reverse){
        tf.setPosition(70, 70);}
        else{
        tf.setPosition(-130-60, 70);}
        tf.setVisible(false);
        tf.scaleBy(0.5F, 0);
        b.addListener(new ClickListener() {
        	 @Override
             public void clicked(InputEvent event, float x, float y) {
                   
             }
        	 @Override
        	 public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                tf.setVisible(true);
             }
        	 @Override
             public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
              tf.setVisible(false);
             }
        });
        this.setPosition(x, y);
        this.addActor(b);
        this.addActor(tf);
        if(ct!=null)
        this.addActor(ct);
    }
    public void reset(){if(maxRound>0){
    	Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(new TextureRegion(up));
        style.over=new TextureRegionDrawable(new TextureRegion(over));
        style.down=new TextureRegionDrawable(new TextureRegion(down));
        b.setStyle(style);}
    }
    public void cool(){
    	if(cool!=null){
    	Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(new TextureRegion(cool));
        style.over=new TextureRegionDrawable(new TextureRegion(cool));
        style.down=new TextureRegionDrawable(new TextureRegion(cool));
        b.setStyle(style);
    	}   }
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
