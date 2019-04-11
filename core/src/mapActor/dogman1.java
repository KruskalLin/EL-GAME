package mapActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class dogman1 extends enemy {
	public dogman1(){
		super("dogman1");
	}
	public void dispose() {
		walkSheetTexture.dispose();
	}
}
