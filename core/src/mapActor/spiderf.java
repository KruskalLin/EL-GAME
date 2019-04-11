package mapActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class spiderf extends enemy {
    public spiderf(){
    	super("spider");
    }

    public void dispose() {
		walkSheetTexture.dispose();
	}
 }
