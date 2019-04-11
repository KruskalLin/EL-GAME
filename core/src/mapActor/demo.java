package mapActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class demo extends enemy {
	public demo(){
         super("demo");
	}

	public void dispose() {
		walkSheetTexture.dispose();
	}
}
