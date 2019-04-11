package actor;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Fruit extends Actor {    //水果类
     protected int row;
     protected int col;
     protected State state;
     protected FruitGroup fg;
     protected TextureRegion[] tr;        //动画region
     protected TextureRegion im;
     protected Texture img;
     protected int width,height;
     protected int source,target;
     public static enum State{
    	 Clicked,nonClicked;
     }
     public Fruit(){
    	 this.state=State.nonClicked;
    	 
             
      
     }
     
     public void setCoordination(int i, int j) {
 		this.row = j;
 		this.col = i;
 	 }
     public void setRow(int i) {
  		this.row = i;
  	 }
     public void setCol(int j) {
   		this.col = j;
   	 }
     public int getRow(){
    	 return this.row;
     }
     public int getCol(){
    	 return this.col;
     }
     @Override
     public void act(float delta) {
         super.act(delta);
     }

     @Override
     public void draw(Batch batch, float parentAlpha) { 	 
         super.draw(batch, parentAlpha);
         if (im == null || !isVisible()) {
             return;
         }
         batch.draw(
                 im, 
                 getX(), getY(), 
                 getOriginX(), getOriginY(), 
                 getWidth(), getHeight(), 
                 getScaleX(), getScaleY(),
                 getRotation()
         );
     }
     
 
}

