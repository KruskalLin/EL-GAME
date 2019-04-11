package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class BarGroup extends Group{
    public CustomBar cb;
    public Label mag;
    public Label blo;
    BitmapFont bf1;
    BitmapFont bf2;
    Label.LabelStyle style1 ;
    Label.LabelStyle style2;
    private float magic;
    private float blood;
    private float maxBlood;
    private float maxMagic;
    private boolean reverse;
    public BarGroup(float x,float y,float blood,float magic,float maxBlood,float maxMagic,boolean reverse){
    	cb=new CustomBar(0,0,blood,magic,maxBlood,maxMagic,reverse);
    	this.addActor(cb);
    	
    	style1 = new Label.LabelStyle();
    	bf1=new BitmapFont(Gdx.files.internal("color/NumFont1.fnt"));
    	style1.font=bf1;
    	 blo = new Label((int)blood+"/"+(int)maxBlood, style1);
    	 if(!reverse)
    	 blo.setPosition(231,147);
    	 else
         blo.setPosition(704-231-blo.getWidth(),147);
    	 blo.setScale(0.9F);
    	 style2=new Label.LabelStyle();
    	 bf2=new BitmapFont(Gdx.files.internal("color/NumFont2.fnt"));
    	 style2.font=bf2;
    	 mag=new Label((int)magic+"/"+(int)maxMagic,style2);
    	 mag.setScale(0.9F);
    	 if(!reverse)
    	 mag.setPosition(143, 100);
    	 else
         mag.setPosition(704-143-mag.getWidth(), 100);
    	 this.addActor(blo);
    	 this.addActor(mag);
    	 this.setPosition(x, y);
    	 
    }
    
}
