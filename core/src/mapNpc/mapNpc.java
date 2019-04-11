package mapNpc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.game.GameScreen;

public abstract class mapNpc extends Actor {
	 String before="input2/";
	 String end=".png";
	 public float x;
	 public float y;
	 Animation<TextureRegion> walkAnimation1;
     TextureRegion currentFrame;
	 static float stateTime=0;
	 Texture walkSheetTexture;
	 public mapNpc(){
		 
	 }
	 public mapNpc(int cols,int rows,String path){
		 walkSheetTexture = GameScreen.assetManager.get((before+path+end),Texture.class);
    	 int frameRows = rows;  
         int frameCols = cols;  
         int perCellWidth = walkSheetTexture.getWidth() / frameCols;    
         int perCellHeight = walkSheetTexture.getHeight() / frameRows;   
         TextureRegion[][] cellRegions = TextureRegion.split(walkSheetTexture, perCellWidth, perCellHeight);
        
         TextureRegion[] cellRegion=new TextureRegion[frameRows*frameCols];
         int k=0;
         for(int i=0;i<frameRows;i++){
        	 for(int j=0;j<frameCols;j++){
        		 cellRegion[k]=cellRegions[i][j];
        		 k++;
        	 }
	 }
         walkAnimation1 = new Animation<TextureRegion>(0.1F, cellRegion);
         walkAnimation1.setPlayMode(Animation.PlayMode.LOOP);
         currentFrame = walkAnimation1.getKeyFrame(stateTime);
         
         this.setSize(perCellWidth,perCellHeight);
	 }
	 public void draw( SpriteBatch batch,float parentAlpha) { 
         stateTime+=Gdx.graphics.getDeltaTime();
         currentFrame = walkAnimation1.getKeyFrame(stateTime);
	     batch.draw(
         currentFrame, 
         x, y, 
         getOriginX(), getOriginY(), 
         getWidth()/2, getHeight()/2, 
         getScaleX(), getScaleY(),
         getRotation());

}
	 public void act(float delta) {
	        super.act(delta);
	    }
	 
	 
     
}
