package mapActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class wolf extends enemy {
     public wolf(){
    	 super("wolf");
     }
     public void dispose() {
 		walkSheetTexture.dispose();
 	}
}
