package mapActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class dog extends enemy {

	public dog(){
		super("dog");
	}
	
	public void dispose() {
		walkSheetTexture.dispose();
	}
}
