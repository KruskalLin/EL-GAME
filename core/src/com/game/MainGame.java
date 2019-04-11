package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MainGame   extends Game {

   
    private GameScreen gs;
   
    
    
    

    @Override
    public void create() {
    	Gdx.graphics.setVSync(true);
    	gs=new GameScreen(this);
    	
        setScreen(gs);
    }
	@Override
	public void dispose () {
		super.dispose();
		if(gs!=null){
			gs.dispose();
			gs=null;
		}
	}
}
