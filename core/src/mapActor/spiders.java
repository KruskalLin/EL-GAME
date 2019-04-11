package mapActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class spiders extends enemy {
    public spiders(){
    	super("spider2");
    }
    public void dispose() {
		walkSheetTexture.dispose();
	}
}
