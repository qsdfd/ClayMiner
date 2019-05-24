import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.Area;

import java.awt.*;
import java.util.concurrent.TimeUnit;


@ScriptManifest(name = "ClayMinez", author = "Dokato", version = 1.0, info = "", logo = "") 
public class mainClay extends Script {
	
	private final Area BANK_AREA1 = new Area(3097,3498,3091,3494);
	private final Area BANK_AREA2 = new Area(3091,3494,3094,3489);
	private final Area MINE_AREA = new Area(3054,9821,3050,9816);
	
	private long timeBegan;
	private long timeRan;
	
	private String status;
	private int clayMined;
	private int moneyMade;
	private int bankTrips;
	private final static int clayPrice=142;

	@Override
    public void onStart(){
		timeBegan = System.currentTimeMillis();
		clayMined=0;
		bankTrips=0;
    }
    
    @Override
    public void onExit() {
    }
    
    public void walkToMine() throws InterruptedException{
    	status="Walking to the mine";
    	if(map.canReach(new Position(3052,9819,0))){
    		localWalker.walk(new Area(3054,9820,3052,9817), true);
    	}else if(map.canReach(new Position(3041,9829,0))){
    		localWalker.walk(new Area(3040,9830,3043,9827), true);
    	}else if(map.canReach(new Position(3034,9834,0))){
    		localWalker.walk(new Area(3032,9835,3036,9832), true);
    	}else if(map.canReach(new Position(3023,9839,0))){
    		localWalker.walk(new Area(3023,9837,3022,9841), true);
    	}else if(map.canReach(new Position(3018,3450,0))){// MINE LADDER
    		if(new Area(3013,3453,3020,3447).contains(myPlayer())){
    			objects.closest("Trapdoor").interact("Climb-down");
    			sleep(random(1000,2000));
    		}else{
    			localWalker.walk(new Area(3017,3451,3020,3449), true);
    		}
    	}else if(map.canReach(new Position(3016,3455,0))){
    		localWalker.walk(new Area(3016,3455,3015,3452), true);
    	}else if(map.canReach(new Position(3020,3460,0))){
    		localWalker.walk(new Area(3021,3461,3020,3458), true);
    	}else if(map.canReach(new Position(3028,3462,0))){
    		localWalker.walk(new Area(3029,3463,3026,3461), true);
    	}else if(map.canReach(new Position(3033,3469,0))){
    		localWalker.walk(new Area(3034,3471,3031,3469), true);
    	}else if(map.canReach(new Position(3044,3471,0))){
    		localWalker.walk(new Area(3045,3472,3042,3469), true);
    	}else if(map.canReach(new Position(3054,3472,0))){
    		localWalker.walk(new Area(3055,3473,3053,3468), true);
    	}else if(map.canReach(new Position(3064,3477,0))){
    		localWalker.walk(new Area(3065,3478,3063,3475), true);
    	}else if(map.canReach(new Position(3064,3488,0))){
    		localWalker.walk(new Area(3064,3490,3064,3487), true);
    	}else if(map.canReach(new Position(3065,3497,0))){
    		localWalker.walk(new Area(3065,3498,3064,3496), true);
    	}else if(map.canReach(new Position(3064,3507,0))){
    		localWalker.walk(new Area(3065,3508,3064,3505), true);
    	}else if(map.canReach(new Position(3071,3512,0))){
    		localWalker.walk(new Area(3071,3511,3074,3513), true);
    	}else if(map.canReach(new Position(3080,3502,0))){
    		localWalker.walk(new Area(3079,3504,3082,3501), true);
    	}else if(map.canReach(new Position(3087,3496,0))){
    		localWalker.walk(new Area(3086,3499,3088,3494), true);
    	}
    }
    
    public void walkToBank() throws InterruptedException{
    	status="Walking to the bank";
    	if(map.canReach(new Position(3091,3494,0))){
    		int k=random(0,10);
    		if(k<5){
    			localWalker.walk(BANK_AREA1,true);
    		}else{
    			localWalker.walk(BANK_AREA2,true);
    		}
    	}else if(map.canReach(new Position(3087,3496,0))){
    		localWalker.walk(new Area(3086,3499,3088,3494), true);
    	}else if(map.canReach(new Position(3080,3502,0))){
    		localWalker.walk(new Area(3079,3504,3082,3501), true);
    	}else if(map.canReach(new Position(3071,3512,0))){
    		localWalker.walk(new Area(3071,3511,3074,3513), true);
    	}else if(map.canReach(new Position(3064,3507,0))){
    		localWalker.walk(new Area(3065,3508,3063,3505), true);
    	}else if(map.canReach(new Position(3065,3497,0))){
    		localWalker.walk(new Area(3065,3498,3064,3496), true);
    	}else if(map.canReach(new Position(3064,3488,0))){
    		localWalker.walk(new Area(3064,3490,3063,3487), true);
    	}else if(map.canReach(new Position(3064,3477,0))){
    		localWalker.walk(new Area(3065,3478,3062,3475), true);
    	}else if(map.canReach(new Position(3054,3472,0))){
    		localWalker.walk(new Area(3055,3473,3053,3468), true);
    	}else if(map.canReach(new Position(3044,3471,0))){
    		localWalker.walk(new Area(3045,3472,3042,3469), true);
    	}else if(map.canReach(new Position(3033,3469,0))){
    		localWalker.walk(new Area(3034,3471,3031,3469), true);
    	}else if(map.canReach(new Position(3028,3462,0))){
    		localWalker.walk(new Area(3029,3463,3026,3461), true);
    	}else if(map.canReach(new Position(3020,3460,0))){
    		localWalker.walk(new Area(3021,3461,3020,3458), true);
    	}else if(map.canReach(new Position(3016,3455,0))){
    		localWalker.walk(new Area(3016,3455,3015,3452), true);
    	}else if(map.canReach(new Position(3019,9849,0))){// DUNGEON MINE
    		if(new Area(3021,9847,3017,9851).contains(myPlayer())){
    			objects.closest("Ladder").interact("Climb-up");
    			sleep(random(1000,2000));
    		}else{
    			localWalker.walk(new Area(3018,9851,3020,9849), true);
    		}
    	}else if(map.canReach(new Position(3023,9839,0))){
    		localWalker.walk(new Area(3023,9837,3022,9841), true);
    	}else if(map.canReach(new Position(3034,9834,0))){
    		localWalker.walk(new Area(3032,9835,3036,9832), true);
    	}else if(map.canReach(new Position(3041,9829,0))){
    		localWalker.walk(new Area(3040,9830,3043,9827), true);
    	}
    }
    
    public String getPickaxe(){
    	int lvl=skills.getStatic(Skill.MINING);
    	
    	if(lvl<6){
    		return "Bronze pickaxe";
    	}else if(lvl<21){
    		return "Steel pickaxe";
    	}else if(lvl<31){
    		return "Mithril pickaxe";
    	}else if(lvl<41){
    		return "Adamant pickaxe";
    	}else if(lvl>=41){
    		return "Rune pickaxe";
    	}else{
    		return "Bronze pickaxe";
    	}
    }
    
    public void bank() throws InterruptedException{
    	status="Banking...";
    	int c=0;
    	if(bank.isOpen()){
    		if(inventory.isFull()){
    			while(inventory.isFull()){
    				if(getInventory().contains("Clay")){
    					c=1;
    				}
	    			bank.depositAll();
	    			if(c==1){
	    				bankTrips++;
	    			}
	    			sleep(random(300,600));
    			}
    		}
    		while(!inventory.contains("Steel pickaxe")){
    			bank.withdraw("Steel pickaxe",1);
    			sleep(random(300,600));
			}
    	}else{
    		objects.closest("Bank booth").interact("Bank");
    		sleep(random(1200,1800));
    	}
    }


    @Override
    public int onLoop() throws InterruptedException{
    	if(!inventory.isFull()&&getInventory().contains("Steel pickaxe")){
    		status="Mining clay...";
    		if(MINE_AREA.contains(myPlayer())){
    			camera.toTop();
    			if(!myPlayer().isUnderAttack()){
	    			if(!myPlayer().isAnimating()&&!myPlayer().isMoving()){
	    				objects.closest(14181).interact("Mine");
	    				sleep(random(1200,1500));
	    			}
    			}else{
    				localWalker.walk(new Area(3032,9825,3031,9824), true);
    				sleep(random(3000,5000));
    			}
    		}else{
    			walkToMine();
    		}
    	}else{
    		if(BANK_AREA1.contains(myPlayer())||BANK_AREA2.contains(myPlayer())){
    			bank();
    		}else{
    			walkToBank();
    		}
    	}
    	return 100; 
    }


    @Override
    public void onPaint(Graphics2D g1){
    	timeRan = System.currentTimeMillis() - this.timeBegan;
    	moneyMade=clayMined*clayPrice;
    	Graphics2D g = (Graphics2D)g1;
    	
    	g.setFont(new Font("Arial", 0, 13));
	     g.setColor(new Color(255, 255, 255));
	     g.drawString("Runtime: "+ft(timeRan), 20, 185);
	     g.drawString("Clay mined: "+clayMined, 20, 200);
	     g.drawString("Clay price: "+clayPrice, 20, 215);
	     g.drawString("Money made: "+moneyMade, 20, 230);
	     g.drawString("Banktrips: "+bankTrips, 20, 245);
	     g.drawString("Current lvl: "+skills.getStatic(Skill.MINING), 20, 260);
	     g.drawString("Status: "+status, 20, 275);
    }
    
    public void onMessage(Message message) throws java.lang.InterruptedException{
    	String clayTxt = message.getMessage().toLowerCase();
    	
    	if(clayTxt.contains("some clay")&&(getInventory().contains("Clay"))){
    		clayMined++;
    	}
    }
    
    private String ft(long duration){ //the method will format seconds, minutes & hours into seconds. Otherwise the time ran would show in milliseconds and that would get majorly confusing.
		String res = "";
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		long hours = TimeUnit.MILLISECONDS.toHours(duration)
		- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
		- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
		.toHours(duration));
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
		- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
		.toMinutes(duration));
		if (days == 0){
		res = (hours + ":" + minutes + ":" + seconds);
		}else{
		res = (days + ":" + hours + ":" + minutes + ":" + seconds);
		}
		return res;
	} 
    
}