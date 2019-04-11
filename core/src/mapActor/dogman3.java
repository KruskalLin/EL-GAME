package mapActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class dogman3 extends enemy {
	 public dogman3(){
		 super("dogman3");
	 }

	@Override
	public void dispose() {
		walkSheetTexture.dispose();
	}
}
