package widget;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Disposable;

import stage.mapStage;

public class ToolGroup extends Group implements Disposable {
    mapStage stage;
	Texture panel;
    newButton button1;
    newButton button2;
    newButton button3;
    newButton button4;
    newButton button5;
    newButton button6;
    newButton button7;
    newButton button8;
    public ToolGroup(float x,float y,mapStage stage){
		 panel=new Texture("input2/toolpanel.png");
		 button1=new tobutton1(22,170,stage);
		 button2=new tobutton2(75,170,stage);
		 button3=new tobutton3(22,230,stage);
		 button4=new tobutton4(75,230,stage);
		 button5=new tobutton5(22,110,stage);
		 button6=new tobutton6(75,110,stage);
		 button7=new tobutton7(22,50,stage);
		 button8=new tobutton8(75,50,stage);
		 
		 button1.setScale((float)0.8);
		 button2.setScale((float)0.8);
		 button3.setScale((float)0.8);
		 button4.setScale((float)0.8);
		 button5.setScale((float)0.8);
		 button6.setScale((float)0.8);
		 button7.setScale((float)0.8);
		 button8.setScale((float)0.8);
		 
		 this.addActor(button1);
		 this.addActor(button2);
		 this.addActor(button3);
		 this.addActor(button4);
		 this.addActor(button5);
		 this.addActor(button6);
		 this.addActor(button7);
		 this.addActor(button8);
		 this.setPosition(x, y);
		 this.setSize(panel.getWidth()/2, panel.getHeight()/2);
	 }
	 public void draw(Batch batch, float alpha) {
		 batch.draw(panel,this.getX(),this.getY(),panel.getWidth()/2, panel.getHeight()/2);
		 super.draw(batch, 1);
		   	
	}
	@Override
	public void dispose() {
		button1.dispose();
		button2.dispose();
		button3.dispose();
		button4.dispose();
		button5.dispose();
		button6.dispose();
		button7.dispose();
		button8.dispose();	
		panel.dispose();
	}
	
	public void update(){
		button1.update();
		button2.update();
		button3.update();
		button4.update();
		button5.update();
		button6.update();
		button7.update();
		button8.update();
		
	}
}
