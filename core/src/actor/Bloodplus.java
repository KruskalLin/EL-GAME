package actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Bloodplus extends Group{
	 private Label num;
     BitmapFont bf;
     Label.LabelStyle style;
     public float number=0;
     private boolean reverse;
     BloodGre bg;
     public Bloodplus(boolean reverse){
    	 this.reverse=reverse;
    	   style= new Label.LabelStyle();
       	bf=new BitmapFont(Gdx.files.internal("Bloodplus.fnt"));
       	style.font=bf;
      
       	num=new Label("+"+(int)(number)+"",style);
       	bg=new BloodGre();
     	  if(!reverse)
     	  setPosition(370, 800);
     	  else
     	  setPosition(704-500,800);
     	  this.addActor(bg);
     	  this.setVisible(false);
     	 
     	  this.setScale(2.0F);
     	  this.addActor(num);
     }
     public void reveal(float number){ 
  	   this.setVisible(true); 
  	   this.number=number;
  	   num.setText("+"+(int)number+"");
  	   bg.setPosition(num.getX()-100, -160);
  	   bg.draw=true;
     }
     public void reset(){
  	   this.setVisible(false);
  	   bg.draw=false;
  	   bg.stateTime=0;
  	  
     }
}
