package actor;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool.Poolable;

import stage.GameStage;

public class CommonFruit extends Fruit implements Disposable,Poolable{
    public enum Colors{ 
   	 Blue,Purple,Yellow,Green,Red,White
    }
    public Colors color;
    int kind;
    public float a=1,b=1;
    boolean add=false;
    private Animation ani;
    public float life=1.0F;
    private TextureAtlas ta;
    private TextureRegion tr;
    public boolean ring=false;
    public boolean vanish=false;
    private TextureAtlas va;
    private Animation van;
    private TextureRegion vani;
    private SequenceAction sa;
    private RunnableAction ra;
    static float stateTime1=0;
    float stateTime2=0;
    float stateTime3=0;
    DelayAction delay;
    private RepeatAction ka;
    private ScaleByAction sba;
    private MoveByAction mba;
    public boolean rings;
    public boolean VH=false;
    public boolean fat;
    private TextureRegion vani4;
    private Animation van4;
    private TextureAtlas ta4;
    private Animation abili;
    private TextureRegion ability;
    private int offsetX;
    private int offsetY;
    private float k;
    private float h;
    private GameStage gamestage;
    public CommonFruit(int i,int j,Colors color,int k,GameStage gamestage){
    	this.setVisible(true);
    	this.row=j;
    	this.col=i;
    	this.color=color;
    	this.kind=k;
    	this.gamestage=gamestage;
    	getImg();
   	  height=100;
   	  width=100;
      im=new TextureRegion(img);	
      this.setSize(100,100);
      this.setOrigin(50, 50);
      this.addListener(new ClickListener(){
    	  public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
    		  
    		  if(gamestage.hero1.sphere){
    				for(int i=col-1;i<=col+1;i++){
    					for(int j=row-1;j<=row+1;j++){
    						try{
    						FruitGroup.fruits[i][j].setScale(1.2F);
    				        
    						
    					}
    					catch(ArrayIndexOutOfBoundsException e){
    					}
    			   }
    		    } 
    		  }
    		  gamestage.fg.enter.play(0.1F);
              setScale(1.2F); 
           }
      	 @Override
           public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
      		if(gamestage.hero1.sphere){
				for(int i=col-1;i<=col+1;i++){
					for(int j=row-1;j<=row+1;j++){
						try{
						FruitGroup.fruits[i][j].setScale(1.0F);
					}
					catch(ArrayIndexOutOfBoundsException e){
					}
			   }
		    } 
		  }
               setScale(1.0F);
           }
      });
     }
     
    
    public void clicked(){
    	ta=new TextureAtlas("Ring4.pack");
    	ani=new Animation(2.0F,ta.getRegions(),PlayMode.LOOP); 
    }  
    
   
    public void getImg(){
          if(kind==0){
        	  switch(this.color){
           	  case Blue:
           		  img=new Texture(Gdx.files.internal("color/blue5.png"));
           		  break;
           	  
           	  case Green:
           		  img=new Texture(Gdx.files.internal("color/green5.png"));
           		  break;
           	  case Red:
           		  img=new Texture(Gdx.files.internal("color/red5.png"));
           		  break;
           	case Purple:
         		  img=new Texture(Gdx.files.internal("color/purple5.png"));
         		  break;
           	case Yellow:
         		  img=new Texture(Gdx.files.internal("color/yellow5.png"));
         		  break;
           	case White:
       		  img=new Texture(Gdx.files.absolute("color/white5.png"));
       		  break;	  
           	  }
               
          }else if(kind==1){
        	  switch(this.color){
    	   	  case Blue:
    	   		  img=new Texture(Gdx.files.absolute("color/vblue2.png"));
    	   		  break;
        	  
    	   	  case Green:
    	   		  img=new Texture(Gdx.files.absolute("color/vgreen2.png"));
    	   		  break;
    	   	  case Red:
    	   		  img=new Texture(Gdx.files.absolute("color/vred2.png"));
    	   		  break;
    	   	 case Purple:
       		  img=new Texture(Gdx.files.absolute("color/vpurple2.png"));
       		  break;
         	 case Yellow:
       		  img=new Texture(Gdx.files.absolute("color/vyellow2.png"));
       		  break;
         	case White:
         		  img=new Texture(Gdx.files.internal("color/wwhite.png"));
         		  break;
    	   	  }
          }else if(kind==2){
        	  switch(this.color){
           	  case Blue:
           		  img=new Texture(Gdx.files.absolute("color/blue4.png"));
           		  break;
           	  
           	  case Green:
           		  img=new Texture(Gdx.files.absolute("color/green4.png"));
           		  break;
           	  case Red:
           		  img=new Texture(Gdx.files.absolute("color/red4.png"));
           		  break;
           	case Purple:
         		  img=new Texture(Gdx.files.absolute("color/purple4.png"));
         		  break;
           	case Yellow:
         		  img=new Texture(Gdx.files.absolute("color/yellow4.png"));
         		  break;
           	case White:
         		  img=new Texture(Gdx.files.internal("color/white4.png"));
         		  break;
         		  
        	  }
          }else if(kind==3){
        	  switch(this.color){
           	  case Blue:
           		  img=new Texture(Gdx.files.absolute("color/wblue.png"));
           		  break;
           	 
           	  case Green:
           		  img=new Texture(Gdx.files.absolute("color/wgreen.png"));
           		  break;
           	  case Red:
           		  img=new Texture(Gdx.files.absolute("color/wred.png"));
           		  break;
           	case Purple:
         		  img=new Texture(Gdx.files.absolute("color/wpurple.png"));
         		  break;
           	case Yellow:
         		  img=new Texture(Gdx.files.absolute("color/wyellow.png"));
         		  break;
           	case White:
         		  img=new Texture(Gdx.files.internal("color/wwhite.png"));
         		  break;
        	  }
          }else if(kind==4){
        	  img=new Texture(Gdx.files.absolute("Colorbomb.png"));
          }
    }
    
    public void setColors(Colors color){
    	this.color=color;
    }
    public Colors getColors(){
    	return this.color;
    }
	

    
	@Override
	 public void act(float delta) {
	        super.act(delta);
	    }

 
    @Override
    public void draw(Batch batch, float parentAlpha) {
        stateTime1+=Gdx.graphics.getDeltaTime();
        if (im == null || !isVisible()) {
            return;
        }
        if(this.getY()>=1000){
        	
        }else{
        batch.draw(
                im, 
                getX(), getY(), 
                getOriginX(), getOriginY(), 
                getWidth(), getHeight(), 
                getScaleX(), getScaleY(),
                getRotation()
        );
        }
        if(ring){
        	tr=(TextureRegion) ani.getKeyFrame(stateTime1);
        }else if(ta!=null){
        	ta.dispose();
        }
        
        if(tr!=null){

        if(ring){
        	 batch.draw(tr, getX()-34, getY()-33,  
                     tr.getRegionWidth() / 2,  
                     tr.getRegionHeight() / 2,  
                     tr.getRegionWidth(),  
                     tr.getRegionHeight(), getScaleX(), getScaleY(),  
                     getRotation()); 
        	
        
        }
        }
        if(abili!=null&&life>0){
        	stateTime3+=Gdx.graphics.getDeltaTime();
        	ability=(TextureRegion) abili.getKeyFrame(stateTime3);
        	batch.draw(ability, k-offsetX, h-offsetY,  
                    ability.getRegionWidth() / 2,  
                    ability.getRegionHeight() / 2,  
                    ability.getRegionWidth(),  
                    ability.getRegionHeight(),1.0F*a, 1.0F*b,  
                    getRotation()); 
        }
        if(vanish&&life>-5){
        	life-=Gdx.graphics.getDeltaTime();
        }
        if(vanish){
        	
        	stateTime2+=Gdx.graphics.getDeltaTime();
        	vani=(TextureRegion) van.getKeyFrame(stateTime2,false); 
            
        }
        if(vani!=null){
        if(vanish){
        	stateTime2+=Gdx.graphics.getDeltaTime();	
        	if(kind==3){
        		vani4=(TextureRegion) van4.getKeyFrame(stateTime2,false);
        	}
           
        	batch.draw(vani, getX(), getY()+5,  
                    vani.getRegionWidth() / 2,  
                    vani.getRegionHeight() / 2); 
        	if(kind==3){
        		 batch.draw(vani4, getX()-159, getY()-143,  
                         vani4.getRegionWidth() / 2,  
                         vani4.getRegionHeight() / 2,  
                         vani4.getRegionWidth(),  
                         vani4.getRegionHeight(),1.0F,1.0F,  
                         getRotation()); 
        	}
        }
     
       }
        if(life<0){
        	this.setVisible(false);
        }
    }

    public void vani(float delay1){
    	
    	
    	
    	delay=Actions.delay(delay1);
  	  va=new TextureAtlas("Vanish.pack");
  van=new Animation(0.1F,va.getRegions(),PlayMode.NORMAL);
  
     if(kind==3){
    	  ta4=new TextureAtlas("Rec.pack");
    	  van4=new Animation(0.1F,ta4.getRegions(),PlayMode.NORMAL);
      }
  	  ra = Actions.run(new Runnable() {
            @Override
            public void run() {
               vanish=true; 
               gamestage.fg.eliminate.play(0.6F);
              
            }
        });
        sa = Actions.sequence(delay, ra);
        this.addAction(sa);
     
  }


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
		if(ta!=null)
		ta.dispose();
		if(va!=null)
		va.dispose();
		if(img!=null)
		img.dispose();
		if(ta4!=null)
		ta4.dispose();
		
	}
    public void Ability1(Animation ani,int a,int b,float getx,float gety){
    	this.stateTime3=0;
    	this.offsetX=a;
    	this.offsetY=b;
    	this.k=getx;
    	this.h=gety;
    	this.abili=ani;
    
    }

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.setScale(1.0F);
		this.setPosition(this.getRow()*FruitGroup.height, this.getCol()*FruitGroup.width);
		
		
		
	}

}
