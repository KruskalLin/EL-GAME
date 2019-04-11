package stage;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.GameScreen;

import widget.progressBar;
public class assetgame extends Stage {
	    public boolean visible=false;
	    String before2="color/";
	    String before="input2/";
	 	String end1=".png";
	 	String end2=".jpg";
	 	progressBar bar;
	 	GameScreen screen;
	 	SpriteBatch batch;
	 	String khero2;
	 	String restage;
	 	Texture background;
	 	Texture hero1;
	 	Texture hero2;
	 	Texture pk;
	 	public assetgame(GameScreen screen,String khero2,String restage){
	 		pk=new Texture("hero/pk.png");
	 		background=new Texture("hero/bj3.png");
	 		this.screen=screen;
	 		this.khero2=khero2;
	 		this.restage=restage;
	 		initTexture();
			batch=new SpriteBatch();
			bar=new progressBar(400,400,0,500);
			if(screen.sandmap!=null){
				screen.sandmap.dispose();
				screen.sandmap=null;
				System.gc();
			}
			if(screen.snowmap!=null){
				screen.snowmap.dispose();
				screen.snowmap=null;
				System.gc();
			}
			if(screen.finalmap!=null){
				screen.finalmap.dispose();
				screen.finalmap=null;
				System.gc();
			}
			if(screen.stage!=null){
				screen.stage.dispose();
				screen.stage=null;
				System.gc();
			}
			GameScreen.assetManager.clear();
			GameScreen.assetManager2.clear();
			GameScreen.assetManager2.load(before2+"blue4"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"blue5"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"Font"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"green4"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"green5"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"NumFont"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"NumFont2"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"purple4"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"purple5"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"red4"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"red5"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"vblue2"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"vgreen2"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"vpurple2"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"vred2"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"vwhite2"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"wblue"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"wgreen"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"white4"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"white5"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"wpurple"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"wred"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"wwhite"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"wyellow"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"yellow4"+end1, Texture.class);
			GameScreen.assetManager2.load(before2+"yellow5"+end1, Texture.class);	
			GameScreen.assetManager2.load(before2+"vyellow2"+end1, Texture.class);
			GameScreen.assetManager2.load(before+"Colorbomb"+".png", Texture.class);
			
			GameScreen.assetManager2.load("backg"+end2, Texture.class);	
			GameScreen.assetManager2.load("background"+end2, Texture.class);
			GameScreen.assetManager2.load("bar"+end2, Texture.class);
			GameScreen.assetManager2.load("bar1"+end1, Texture.class);
			GameScreen.assetManager2.load("bar2"+end1, Texture.class);
			GameScreen.assetManager2.load("Blood"+end1, Texture.class);
			GameScreen.assetManager2.load("Blood1"+end1, Texture.class);
			GameScreen.assetManager2.load("BloodRe"+end1, Texture.class);
			GameScreen.assetManager2.load("BM"+end1, Texture.class);
			GameScreen.assetManager2.load("BM4"+end1, Texture.class);
			GameScreen.assetManager2.load("buff_frenzy_grey"+end1, Texture.class);
			GameScreen.assetManager2.load("buff_frenzy"+end1, Texture.class);
			GameScreen.assetManager2.load("buff_poison_grey"+end1, Texture.class);
			GameScreen.assetManager2.load("buff_poison"+end1, Texture.class);
			GameScreen.assetManager2.load("Button1"+end1, Texture.class);
			GameScreen.assetManager2.load("circle"+end1, Texture.class);
			GameScreen.assetManager2.load("colorHLeft"+end1, Texture.class);
			GameScreen.assetManager2.load("colorHRight"+end1, Texture.class);
			GameScreen.assetManager2.load("colorVDown"+end1, Texture.class);
			GameScreen.assetManager2.load("colorVUp"+end1, Texture.class);
			GameScreen.assetManager2.load("hand"+end1, Texture.class);
			GameScreen.assetManager2.load("hero1"+end2, Texture.class);
			GameScreen.assetManager2.load("hero1"+end1, Texture.class);
			GameScreen.assetManager2.load("hero2"+end2, Texture.class);
			GameScreen.assetManager2.load("hero2"+end1, Texture.class);
			GameScreen.assetManager2.load("menu_down"+end1, Texture.class);
			GameScreen.assetManager2.load("menu"+end1, Texture.class);
			GameScreen.assetManager2.load("menu_down"+end1, Texture.class);
			GameScreen.assetManager2.load("name"+end1, Texture.class);
			GameScreen.assetManager2.load("nameframe"+end1, Texture.class);
			GameScreen.assetManager2.load("Orange"+end1, Texture.class);
			GameScreen.assetManager2.load("point1"+end2, Texture.class);
			GameScreen.assetManager2.load("property_black"+end1, Texture.class);
			GameScreen.assetManager2.load("property"+end1, Texture.class);
			GameScreen.assetManager2.load("Rec"+end1, Texture.class);
			GameScreen.assetManager2.load("Rec2"+end1, Texture.class);
			GameScreen.assetManager2.load("Rec3"+end1, Texture.class);
			GameScreen.assetManager2.load("Rec4"+end1, Texture.class);
			GameScreen.assetManager2.load("roof"+end1, Texture.class);
			GameScreen.assetManager2.load("roofa"+end1, Texture.class);
			GameScreen.assetManager2.load("roofc"+end1, Texture.class);
			GameScreen.assetManager2.load("SkillPanel"+end1, Texture.class);
			GameScreen.assetManager2.load("SkillPanelRe"+end1, Texture.class);
			GameScreen.assetManager2.load("textground"+end1, Texture.class);
			GameScreen.assetManager2.load("ToolButton"+end1, Texture.class);
			GameScreen.assetManager2.load("tools_down"+end1, Texture.class);
			GameScreen.assetManager2.load("tools1"+end1, Texture.class);
			GameScreen.assetManager2.load("trap"+end1, Texture.class);
			GameScreen.assetManager2.load("vanish"+end1, Texture.class);
			GameScreen.assetManager2.load("vanish2"+end1, Texture.class);
			GameScreen.assetManager2.load("vetical"+end1, Texture.class);
			GameScreen.assetManager2.load("BladeMaster/"+"hero1"+end1, Texture.class);
			GameScreen.assetManager2.load("BladeMaster/"+"hero1Re"+end1, Texture.class);
			GameScreen.assetManager2.load(("blackground.png"),Texture.class);
			GameScreen.assetManager2.load(("tools_over.png"),Texture.class);
			//首先剑圣和小怪的图片是全部加载的，然后其他英雄的通过判断进行加入
			initasset();
	 	}
	 	
	 	public void initasset(){
	 		 if(!screen.mood){
	 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes4.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/StormOfBlade.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/StormOfBlade.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("BladeMaster/jrfb_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/jrfb.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/blbl.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/jrfb_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/zlsw_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/zlsw.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/zlsw_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/hhzf.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/Hero1.png"),Texture.class);
	 			GameScreen.assetManager2.load(("BladeMaster/Hero1Re.png"),Texture.class);
	 			switch(khero2){
	 		   case "demo":
	 			   
	 			   break;
	 		   case "dog":
	 			  
	 			   break;
	 		  case "dogman1":
	 			  
	 			   break;
	 		   case "dogman2":
	 			  
	 			   break;
	 		  case "dogman3":
	 			  
	 			   break;
	 		   case "fisherman":
	 			  
	 			   break;
	 		   case "semimos":
	 			  
	 			   break;
	 		  
	 		   case "spiders":
	 			  
	 			   break;
	 		   case "wolf":
	 			  
	 			   break;
	 		   case "wolf3":
	 			  
	 			   break;   
	 		   case "dafashi":
	 			  GameScreen.assetManager2.load(("Arc/HeroArchMageYes1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/HeroArchMageYes2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/HeroArchMageYes3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/HeroArchMageYes4.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/FragBombs.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/InnerFireBirth.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Arc/ManaShieldCaster1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/SpiritWalkerMorph.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/heal.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Arc/BO.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Arc/skill4.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Arc/fight.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Arc/10-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/10.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/10-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/11-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/12-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/9-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/11-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/12-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/9-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/11.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/12.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/9.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/dafashi.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Arc/dafashi_re.png"),Texture.class);
		 			
	 			   break;
	 		   case "emolieshou":
	 			  GameScreen.assetManager2.load(("Demonhunter/demonhunter.png"),Texture.class);
	 			 GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes4.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack4.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/at.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("DemonHunter/vain.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("DemonHunter/dodge.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedWarcry1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/BlinkArrival1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/HolyBolt.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/SorceressCastAttack1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("DemonHunter/emolieshou.png"),Texture.class);
	 			GameScreen.assetManager2.load(("DemonHunter/emolieshou_re.png"),Texture.class);
	 			GameScreen.assetManager2.load(("DemonHunter/sysy_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("DemonHunter/sysy.png"),Texture.class);
	 			GameScreen.assetManager2.load(("DemonHunter/sysy_black.png"),Texture.class);

	 			GameScreen.assetManager2.load(("DemonHunter/flsh.png"),Texture.class);
	 			GameScreen.assetManager2.load(("DemonHunter/fshd.png"),Texture.class);
	 			GameScreen.assetManager2.load(("DemonHunter/16-white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("DemonHunter/16.png"),Texture.class);
	 			GameScreen.assetManager2.load(("DemonHunter/16-black.png"),Texture.class);
	 			   break;
	 		   case "huoyan":
	 			  GameScreen.assetManager2.load(("FireLord/firelord.png"),Texture.class);
	 			 GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes5.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordWarcry1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/BloodlustTarget.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/Shockwave.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/BlizzardLoop1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("FireLord/wjly_skill.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("FireLord/firepush.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("FireLord/angry.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("FireLord/huoyanlingzhu.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/huoyanlingzhu_re.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/fire_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/fire.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/fire_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/angry_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/angry_.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/angry_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/burned.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/wjly_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/wjly.png"),Texture.class);
	 			GameScreen.assetManager2.load(("FireLord/wjly_black.png"),Texture.class);

	 			   break;
	 		   case "jiansheng":
	 			  GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes4.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/StormOfBlade.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/StormOfBlade.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("BladeMaster/jrfb_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/jrfb.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/blbl.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/jrfb_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/zlsw_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/zlsw.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/zlsw_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/hhzf.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/Hero1.png"),Texture.class);
		 			GameScreen.assetManager2.load(("BladeMaster/Hero1Re.png"),Texture.class);
	 			   break;
	 		   case "kongju":
	 			  GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/ss.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes4.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordWarcry1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/PossessionMissileHit1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/Incinerate1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/PossessionMissileLaunch1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DreadLord/vain.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("DreadLord/curse.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("DreadLord/fire.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("DreadLord/ring.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("DreadLord/xuwu_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/xuwu.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/xuwu_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/sckj-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/sckj.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/sckj-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/XXGH.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/14-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/14-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/kongjumowang.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/kongjumowang_re.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DreadLord/drea.png"),Texture.class);
	 			   break;
	 		   case "nvjisi":
	 			  GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes4.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/WindWalk.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/StarfallCaster1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/CorrosiveBreathMissileLaunch1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/ReviveNightElf.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("POM/star.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("POM/moon.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("POM/invisible.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("POM/hori.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("POM/vert.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("POM/8-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/8.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/8-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/3-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/6-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/6.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/6-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/7.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/7-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/7-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/3.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/3-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/POM.png"),Texture.class);
		 			GameScreen.assetManager2.load(("POM/POM_re.png"),Texture.class);
	 			   break;
	 		   case "shengqishi":
	 			  GameScreen.assetManager2.load(("Paladin/HeroPaladinYes1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes4.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/ManaShieldCaster1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/DispelMagicTarget.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Paladin/ring.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Paladin/holyshield.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Paladin/skill2.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Paladin/xili_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/xili.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/xili_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/jinghua_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/jinghua.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/jinghua_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/HYJZ.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/hujia_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/hujia.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/hujia_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/shengqishi.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Paladin/shengqishi_re.png"),Texture.class);
	 			   break;
	 		   case "siqi":
	 			  GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes4.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightWarcry1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DarkSummoningLaunch1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/ResurrectTarget.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/FreezingBreathTarget1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("DeathKnight/sh.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("DeathKnight/ice.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("DeathKnight/shield.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("DeathKnight/swcr_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/swcr.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/swcr_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/Wgzd_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/Wgzd.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/Wgzd_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/szas.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/hgfz_white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/hgfz.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/hgfz_black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DK.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/DK_re.png"),Texture.class);
		 			GameScreen.assetManager2.load(("DeathKnight/huiguang.png"),Texture.class);
	 			   break;
	 		   case "xianzhi":
	 			  GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes4.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack2.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack3.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/LightningShieldTarget.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/PurgeTarget1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/LightningBolt.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/SpiritWalkerMorph.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("FarSeer/heal.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("FarSeer/ele.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("FarSeer/lightning.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("FarSeer/ss.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("FarSeer/5-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/5.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/5-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/4-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/4.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/4-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/3.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/3-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/3-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/2-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/2.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/2-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/Farseer_re.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/Farseer.png"),Texture.class);
		 			GameScreen.assetManager2.load(("FarSeer/far.png"),Texture.class);
	 			   break;
	 		   case "xiongmao":
	 			  GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormWhat1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormYes1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormYesAttack1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormWarcry1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Panda/Incinerate1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Panda/FlameStrikeBirth1.wav"),Sound.class);
		 			GameScreen.assetManager2.load(("Panda/skill4.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Panda/ji.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Panda/skill1.pack"),TextureAtlas.class);
		 			GameScreen.assetManager2.load(("Panda/xiongmao.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/xiongmao_re.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/5-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/5.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/5-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/4-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/4-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/4.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/1.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/2.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/2-white.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/2-black.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/xiongmao.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/xiongmao_re.png"),Texture.class);
		 			GameScreen.assetManager2.load(("Panda/skll4.png"),Texture.class);
	 			   break;
	 	       
	 		 }
	 	 }else{
	 		switch(screen.hero1){
  		 case "BladeMaster":
  			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes4.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/StormOfBlade.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/StormOfBlade.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("BladeMaster/jrfb_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/jrfb.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/blbl.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/jrfb_black.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/zlsw_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/zlsw.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/zlsw_black.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/hhzf.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/Hero1.png"),Texture.class);
 			GameScreen.assetManager2.load(("BladeMaster/Hero1Re.png"),Texture.class);
  			break;
  		 case "ArchMage":
  			GameScreen.assetManager2.load(("Arc/HeroArchMageYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/HeroArchMageYes2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/HeroArchMageYes3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/HeroArchMageYes4.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/FragBombs.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/InnerFireBirth.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Arc/ManaShieldCaster1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/SpiritWalkerMorph.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/heal.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("Arc/BO.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("Arc/skill4.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("Arc/fight.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("Arc/10-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/10.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/10-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/11-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/12-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/9-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/11-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/12-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/9-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/11.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/12.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/9.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/dafashi.png"),Texture.class);
 			GameScreen.assetManager2.load(("Arc/dafashi_re.png"),Texture.class);
 			
   			break;	
  		 case "DeathKnight":
  			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes4.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/DeathKnightWarcry1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/DarkSummoningLaunch1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/ResurrectTarget.wav"),Sound.class);
 			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/FreezingBreathTarget1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DeathKnight/sh.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DeathKnight/ice.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DeathKnight/shield.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DeathKnight/swcr_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/swcr.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/swcr_black.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/Wgzd_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/Wgzd.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/Wgzd_black.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/szas.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/hgfz_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/hgfz.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/hgfz_black.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/DK.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/DK_re.png"),Texture.class);
 			GameScreen.assetManager2.load(("DeathKnight/huiguang.png"),Texture.class);
			   break;
    			
  		 case "DemonHunter":
  			 GameScreen.assetManager2.load(("Demonhunter/demonhunter.png"),Texture.class);
 			 GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes4.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack4.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/at.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DemonHunter/vain.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DemonHunter/dodge.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedWarcry1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/BlinkArrival1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/HolyBolt.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/SorceressCastAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DemonHunter/emolieshou.png"),Texture.class);
 			GameScreen.assetManager2.load(("DemonHunter/emolieshou_re.png"),Texture.class);
 			GameScreen.assetManager2.load(("DemonHunter/sysy_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("DemonHunter/sysy.png"),Texture.class);
 			GameScreen.assetManager2.load(("DemonHunter/sysy_black.png"),Texture.class);

 			GameScreen.assetManager2.load(("DemonHunter/flsh.png"),Texture.class);
 			GameScreen.assetManager2.load(("DemonHunter/fshd.png"),Texture.class);
 			GameScreen.assetManager2.load(("DemonHunter/16-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("DemonHunter/16.png"),Texture.class);
 			GameScreen.assetManager2.load(("DemonHunter/16-black.png"),Texture.class);
     			break;	
  		 case "DreadLord":
  			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/ss.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes4.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordWarcry1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/PossessionMissileHit1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/Incinerate1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/PossessionMissileLaunch1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("DreadLord/vain.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DreadLord/curse.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DreadLord/fire.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DreadLord/ring.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("DreadLord/xuwu_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/xuwu.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/xuwu_black.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/sckj-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/sckj.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/sckj-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/XXGH.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/14-white.png"),Texture.class);
 			
 			GameScreen.assetManager2.load(("DreadLord/14-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/kongjumowang.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/kongjumowang_re.png"),Texture.class);
 			GameScreen.assetManager2.load(("DreadLord/drea.png"),Texture.class);
      			break;	
  		 case "FarSeer":
  			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes4.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/LightningShieldTarget.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/PurgeTarget1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/LightningBolt.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/SpiritWalkerMorph.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FarSeer/heal.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("FarSeer/ele.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("FarSeer/lightning.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("FarSeer/ss.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("FarSeer/5-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/5.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/5-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/4-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/4.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/4-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/3.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/3-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/3-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/2-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/2.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/2-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/Farseer_re.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/Farseer.png"),Texture.class);
 			GameScreen.assetManager2.load(("FarSeer/far.png"),Texture.class);
   			break;	
  		 case "Paladin":
  			 GameScreen.assetManager2.load(("Paladin/HeroPaladinYes1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes4.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/ManaShieldCaster1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/DispelMagicTarget.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/ring.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("Paladin/holyshield.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("Paladin/skill2.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("Paladin/xili_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/xili.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/xili_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/jinghua_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/jinghua.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/jinghua_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/HYJZ.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/hujia_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/hujia.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/hujia_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/shengqishi.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/shengqishi_re.png"),Texture.class);
     			break;
  		 case "PandaBrewmaster":
  			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormWhat1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormYesAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormWarcry1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Panda/Incinerate1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Panda/FlameStrikeBirth1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("Panda/skill4.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("Panda/ji.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("Panda/skill1.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("Panda/xiongmao.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/xiongmao_re.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/5-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/5.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/5-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/4-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/4-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/4.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/1.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/2.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/2-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/2-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/xiongmao.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/xiongmao_re.png"),Texture.class);
 			GameScreen.assetManager2.load(("Panda/skll4.png"),Texture.class);
      			break;
  		 case "POM":
  			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes4.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/WindWalk.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/StarfallCaster1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/CorrosiveBreathMissileLaunch1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/ReviveNightElf.wav"),Sound.class);
 			GameScreen.assetManager2.load(("POM/star.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("POM/moon.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("POM/invisible.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("POM/hori.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("POM/vert.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("POM/8-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/8.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/8-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/3-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/6-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/6.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/6-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/7.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/7-white.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/7-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/3.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/3-black.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/POM.png"),Texture.class);
 			GameScreen.assetManager2.load(("POM/POM_re.png"),Texture.class);
   			break;
  		 case "FireLord":
  			 GameScreen.assetManager2.load(("FireLord/firelord.png"),Texture.class);
 			 GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes5.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack2.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack3.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordWarcry1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/BloodlustTarget.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/Shockwave.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/BlizzardLoop1.wav"),Sound.class);
 			GameScreen.assetManager2.load(("FireLord/wjly_skill.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("FireLord/firepush.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("FireLord/angry.pack"),TextureAtlas.class);
 			GameScreen.assetManager2.load(("FireLord/huoyanlingzhu.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/huoyanlingzhu_re.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/fire_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/fire.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/fire_black.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/angry_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/angry_.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/angry_black.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/burned.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/wjly_white.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/wjly.png"),Texture.class);
 			GameScreen.assetManager2.load(("FireLord/wjly_black.png"),Texture.class);

    			break;	
  	 }
  	 switch(screen.hero2){
  	 case "BladeMaster":
			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes2.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes3.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYes4.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack2.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/HeroBladeMasterYesAttack3.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/StormOfBlade.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/StormOfBlade.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("BladeMaster/jrfb_white.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/jrfb.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/blbl.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/jrfb_black.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/zlsw_white.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/zlsw.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/zlsw_black.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/hhzf.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/Hero1.png"),Texture.class);
			GameScreen.assetManager2.load(("BladeMaster/Hero1Re.png"),Texture.class);
			break;
		 case "ArchMage":
			GameScreen.assetManager2.load(("Arc/HeroArchMageYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/HeroArchMageYes2.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/HeroArchMageYes3.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/HeroArchMageYes4.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack2.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/HeroArchMageYesAttack3.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/FragBombs.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/InnerFireBirth.wav"),Sound.class);
			GameScreen.assetManager2.load(("Arc/ManaShieldCaster1.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/SpiritWalkerMorph.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/heal.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("Arc/BO.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("Arc/skill4.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("Arc/fight.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("Arc/10-white.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/10.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/10-black.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/11-white.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/12-white.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/9-white.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/11-black.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/12-black.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/9-black.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/11.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/12.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/9.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/dafashi.png"),Texture.class);
			GameScreen.assetManager2.load(("Arc/dafashi_re.png"),Texture.class);
			
			break;	
		 case "DeathKnight":
			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes2.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes3.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYes4.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack2.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/DeathKnightYesAttack3.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/DeathKnightWarcry1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/DarkSummoningLaunch1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/ResurrectTarget.wav"),Sound.class);
			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/FreezingBreathTarget1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DeathKnight/sh.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DeathKnight/ice.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DeathKnight/shield.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DeathKnight/swcr_white.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/swcr.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/swcr_black.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/Wgzd_white.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/Wgzd.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/Wgzd_black.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/szas.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/hgfz_white.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/hgfz.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/hgfz_black.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/DK.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/DK_re.png"),Texture.class);
			GameScreen.assetManager2.load(("DeathKnight/huiguang.png"),Texture.class);
			   break;		
		 case "DemonHunter":
		    GameScreen.assetManager2.load(("Demonhunter/demonhunter.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes2.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes3.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYes4.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack2.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack3.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedYesAttack4.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/at.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DemonHunter/vain.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DemonHunter/dodge.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DemonHunter/DemonHunterMorphedWarcry1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/BlinkArrival1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/HolyBolt.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/SorceressCastAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DemonHunter/emolieshou.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/emolieshou_re.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/sysy_white.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/sysy.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/sysy_black.png"),Texture.class);

			GameScreen.assetManager2.load(("DemonHunter/flsh.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/fshd.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/16-white.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/16.png"),Texture.class);
			GameScreen.assetManager2.load(("DemonHunter/16-black.png"),Texture.class);
  			break;	
		 case "DreadLord":
			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes2.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/ss.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYes4.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack2.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordYesAttack3.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/HeroDreadlordWarcry1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/PossessionMissileHit1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/Incinerate1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/PossessionMissileLaunch1.wav"),Sound.class);
			GameScreen.assetManager2.load(("DreadLord/vain.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DreadLord/curse.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DreadLord/fire.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DreadLord/ring.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("DreadLord/xuwu_white.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/xuwu.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/xuwu_black.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/sckj-white.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/sckj.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/sckj-black.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/XXGH.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/14-white.png"),Texture.class);
			
			
			GameScreen.assetManager2.load(("DreadLord/kongjumowang.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/kongjumowang_re.png"),Texture.class);
			GameScreen.assetManager2.load(("DreadLord/drea.png"),Texture.class);
   			break;	
		 case "FarSeer":
			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes2.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes3.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYes4.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack2.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/HeroFarseerYesAttack3.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/LightningShieldTarget.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/PurgeTarget1.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/LightningBolt.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/SpiritWalkerMorph.wav"),Sound.class);
			GameScreen.assetManager2.load(("FarSeer/heal.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("FarSeer/ele.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("FarSeer/lightning.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("FarSeer/ss.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("FarSeer/5-white.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/5.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/5-black.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/4-white.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/4.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/4-black.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/3.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/3-white.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/3-black.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/2-white.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/2.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/2-black.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/Farseer_re.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/Farseer.png"),Texture.class);
			GameScreen.assetManager2.load(("FarSeer/far.png"),Texture.class);
			break;	
		 case "Paladin":
			 GameScreen.assetManager2.load(("Paladin/HeroPaladinYes1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYes4.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack2.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/HeroPaladinYesAttack3.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/ManaShieldCaster1.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/DispelMagicTarget.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("BladeMaster/Heal.wav"),Sound.class);
	 			GameScreen.assetManager2.load(("Paladin/ring.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("Paladin/holyshield.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("Paladin/skill2.pack"),TextureAtlas.class);
	 			GameScreen.assetManager2.load(("Paladin/xili_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/xili.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/xili_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/jinghua_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/jinghua.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/jinghua_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/HYJZ.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/hujia_white.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/hujia.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/hujia_black.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/shengqishi.png"),Texture.class);
	 			GameScreen.assetManager2.load(("Paladin/shengqishi_re.png"),Texture.class);
  			break;
		 case "PandaBrewmaster":
			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormWhat1.wav"),Sound.class);
			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormYesAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("Panda/PandarenBrewmasterStormWarcry1.wav"),Sound.class);
			GameScreen.assetManager2.load(("Panda/Incinerate1.wav"),Sound.class);
			GameScreen.assetManager2.load(("Panda/FlameStrikeBirth1.wav"),Sound.class);
			GameScreen.assetManager2.load(("Panda/skill4.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("Panda/ji.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("Panda/skill1.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("Panda/xiongmao.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/xiongmao_re.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/5-white.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/5.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/5-black.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/4-white.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/4-black.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/4.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/1.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/2.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/2-white.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/2-black.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/xiongmao.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/xiongmao_re.png"),Texture.class);
			GameScreen.assetManager2.load(("Panda/skll4.png"),Texture.class);
   			break;
		 case "POM":
			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes2.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes3.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYes4.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack2.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/HeroMoonPriestessYesAttack3.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/WindWalk.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/StarfallCaster1.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/CorrosiveBreathMissileLaunch1.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/ReviveNightElf.wav"),Sound.class);
			GameScreen.assetManager2.load(("POM/star.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("POM/moon.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("POM/invisible.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("POM/hori.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("POM/vert.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("POM/8-white.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/8.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/8-black.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/3-white.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/6-white.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/6.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/6-black.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/7.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/7-white.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/7-black.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/3.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/3-black.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/POM.png"),Texture.class);
			GameScreen.assetManager2.load(("POM/POM_re.png"),Texture.class);
			break;
		 case "FireLord":
			 GameScreen.assetManager2.load(("FireLord/firelord.png"),Texture.class);
			 GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes1.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes2.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes3.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYes5.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack1.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack2.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordYesAttack3.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/NerubianCryptLordWarcry1.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/BloodlustTarget.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/Shockwave.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/BlizzardLoop1.wav"),Sound.class);
			GameScreen.assetManager2.load(("FireLord/wjly_skill.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("FireLord/firepush.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("FireLord/angry.pack"),TextureAtlas.class);
			GameScreen.assetManager2.load(("FireLord/huoyanlingzhu.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/huoyanlingzhu_re.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/fire_white.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/fire.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/fire_black.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/angry_white.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/angry_.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/angry_black.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/burned.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/wjly_white.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/wjly.png"),Texture.class);
			GameScreen.assetManager2.load(("FireLord/wjly_black.png"),Texture.class);

 			break;	
 			}

	 	 }

	 	}
	 	
	 	 public void draw(){                             
			   super.draw();	   
			   if(GameScreen.assetManager2.update()){
				   this.visible=false;
				   screen.initgame(khero2,restage);
			   }else{                 
				   bar.blood=GameScreen.assetManager2.getProgress()*500;
			   }                    
			   batch.begin();    
			   batch.draw(background, 0, 0, background.getWidth(), background.getHeight());
			   batch.draw(hero1, 200, 300, 300, 450);
			   batch.draw(hero2, 1000, 300, 300, 450);
			   batch.draw(pk, 500, 300, 400, 400);
			   bar.draw(batch, 1);
			   batch.end();
		   }
	 	 public void dispose(){
	     	super.dispose();
	     }
	 	 
	 	 public void initTexture(){
	 		 
	 		 if(!screen.mood){
	 			 hero1=new Texture("hero/hero1Re.png");
	 			switch(khero2){
	 		   case "demo":
	 			   hero2=new Texture("hero2/demo.png");
	 			   break;
	 		   case "dog":
	 			  hero2=new Texture("hero2/wolf.png");
	 			   break;
	 		  case "dogman1":
	 			  hero2=new Texture("hero2/dogman.png");
	 			   break;
	 		   case "dogman2":
	 			  hero2=new Texture("hero2/dogman.png");
	 			   break;
	 		  case "dogman3":
	 			  hero2=new Texture("hero2/semo.png");
	 			   break;
	 		   case "fisherman":
	 			  hero2=new Texture("hero2/yuren.png");
	 			   break;
	 		   case "semimos":
	 			  hero2=new Texture("hero2/semimos.png");
	 			   break;
	 		  
	 		   case "spiders":
	 			  hero2=new Texture("hero2/zhizhu.png");
	 			   break;
	 		   case "wolf":
	 			  hero2=new Texture("hero2/gebu.png");
	 			   break;
	 		   case "wolf3":
	 			  hero2=new Texture("hero2/langren.png");
	 			   break;   
	 		   case "dafashi":
	 			  hero2=new Texture("hero2/dafashi.png");
	 			   break;
	 		   case "emolieshou":
	 			  hero2=new Texture("hero2/emolieshou.png");
	 			   break;
	 		   case "huoyan":
	 			  hero2=new Texture("hero2/hero2.png");
	 			   break;
	 		   case "jiansheng":
	 			  hero2=new Texture("hero2/hero1Re.png");
	 			   break;
	 		   case "kongju":
	 			  hero2=new Texture("hero2/kongjumowang.png");
	 			   break;
	 		   case "nvjisi":
	 			  hero2=new Texture("hero2/POM.png");
	 			   break;
	 		   case "shengqishi":
	 			  hero2=new Texture("hero2/shengqishi.png");
	 			   break;
	 		   case "siqi":
	 			  hero2=new Texture("hero2/DK.png");
	 			   break;
	 		   case "xianzhi":
	 			  hero2=new Texture("hero2/Farseer.png");
	 			   break;
	 		   case "xiongmao":
	 			  hero2=new Texture("hero2/xiongmao.png");
	 			   break;
	 			default:
	 				hero2=new Texture("hero2/xiongmao.png");
		 			   break;
	 	       
	 		 }
	 	 }else{
	 		switch(screen.hero1){
   		 case "BladeMaster":
   			hero1=new Texture("hero/hero1Re.png");
   			break;
   		 case "ArchMage":
   			hero1=new Texture("hero2/dafashi.png");
    			break;	
   		 case "DeathKnight":
   			hero1=new Texture("hero2/DK.png");
     			break;	
   		 case "DemonHunter":
   			hero1=new Texture("hero2/emolieshou.png");
      			break;	
   		 case "DreadLord":
   			hero1=new Texture("hero2/kongjumowang.png"); 
       			break;	
   		 case "FarSeer":
   			hero1=new Texture("hero2/Farseer.png");
    			break;	
   		 case "Paladin":
   			hero1=new Texture("hero2/shengqishi.png");
      			break;
   		 case "PandaBrewmaster":
   			hero1=new Texture("hero2/xiongmao.png");
       			break;
   		 case "POM":
   			hero1=new Texture("hero2/POM.png");
    			break;
   		 case "FireLord":
   			hero1=new Texture("hero2/hero2.png");
     			break;	
     	default:
     		hero1=new Texture("hero2/hero2.png");
 			break;
   	 }
   	 switch(screen.hero2){
   	 case "BladeMaster":
			hero2=new Texture("hero/hero1Re.png");
			break;
		 case "ArchMage":
			hero2=new Texture("hero2/dafashi.png");
 			break;	
		 case "DeathKnight":
			hero2=new Texture("hero2/DK.png");
  			break;	
		 case "DemonHunter":
			hero2=new Texture("hero2/emolieshou.png");
   			break;	
		 case "DreadLord":
			hero2=new Texture("hero2/kongjumowang.png"); 
    			break;	
		 case "FarSeer":
			hero2=new Texture("hero2/Farseer.png");
 			break;	
		 case "Paladin":
			hero2=new Texture("hero2/shengqishi.png");
   			break;
		 case "PandaBrewmaster":
			hero2=new Texture("hero2/xiongmao.png");
    			break;
		 case "POM":
			hero2=new Texture("hero2/POM.png");
 			break;
		 case "FireLord":
			hero2=new Texture("hero2/hero2.png");
  			break;	 
  			default:
  				hero2=new Texture("hero2/hero2.png");
  	  			break;
  			}

	 	 }
	 	 }
}
