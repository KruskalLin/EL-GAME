package mapActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class semimos extends enemy{
	public semimos(){
		super("semimos");
	}
	public void dispose() {
		walkSheetTexture.dispose();
	}
}
