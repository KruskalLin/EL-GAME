package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Blood extends Group{
       private Label num;
       BitmapFont bf;
       Label.LabelStyle style;
       public float number=0;
       private boolean reverse;
       private Bloodv bloodv;
       public Blood(boolean reverse){
    	   this.reverse=reverse;
    	   style= new Label.LabelStyle();
       	bf=new BitmapFont(Gdx.files.internal("color/Num.fnt"));
       	style.font=bf;
       	num=new Label("-"+(int)(number)+"",style);
     	  if(!reverse)
     	  setPosition(175, 850);
     	  else
     	  setPosition(704-175-150,850);
     	  bloodv=new Bloodv(-50,-40);
     	  this.addActor(bloodv);
     	  this.setVisible(false);
     	  this.setSize(200, 100);
          this.setScale(3.0F);
     	  this.addActor(num);
       }
       public void reveal(float number){ 
    	   this.setVisible(true); 
    	   this.number=number;
    	   num.setText("-"+(int)number+"");
    	   bloodv.setPosition(num.getX()-40, -40);
    	 
       }
       public void reset(){
    	   this.setVisible(false);
       }
}
