package mapActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class fishermans extends enemy {
    public fishermans(){
    	super("fish2");
    }
    public void dispose() {
		walkSheetTexture.dispose();
	}
}
