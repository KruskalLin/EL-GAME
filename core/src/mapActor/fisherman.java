package mapActor;

public class fisherman extends enemy {
   
     public fisherman(){
        super("fish");
    }
     public void dispose() {
 		walkSheetTexture.dispose();
 	}
}
