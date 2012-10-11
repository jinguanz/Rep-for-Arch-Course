package edu.cmu.mse.aes.project1.bussiness;

/*
 * author: Rui Li
 * 
 * This class will keep the regx which will be used for filter out the useful info
 */
public class RegualExpression {
	
	//Such Regx will list out all the links to 20 brands like: http://bikereviews.com/road-bikes/raleigh/
	public static  final String RegxForFilterLinks="Bikes\" href=\"http://bikereviews.com/road-bikes/(.+?)/";
	
 
	//href="http://bikereviews.com/road-bikes/raleigh/2011-raleigh/" title="2011 Raleigh Road Bikes">2011 Raleigh Road Bikes</a><br
	//href="http://bikereviews.com/road-bikes/scott/2010-scott/" title="2010 Scott Road Bikes">2010 Scott Road Bikes</a><br
	//href="http://bikereviews.com/road-bikes/trek/2010-trek/" title="2010 Trek Road Bikes">2010 Trek Road Bikes</a><br
	public final static String regx2="href=\"http://bikereviews.com/road-bikes/(.+?)/\" title=\"2010";
	// Bikes" href="http://bikereviews.com/road-bikes/raleigh/2010-raleigh/">2010 Raleigh Road Bikes</a><br
	public final static String regx2ForDumppages="href=\"http://bikereviews.com/road-bikes/(.+?)/\">2010";
	//href="http://bikereviews.com/road-bikes/raleigh/2010-raleigh/raleigh-team-road-bike/" title="
	public final static String regx3="href=\"http://bikereviews.com/road-bikes/(.+?)/\" title=";
	
	//$9999."
	//$1,099.99<br
	public final static String regxForPrice="[" +"\\p{Sc}\u0024\u060B"+"][\\d,]+";
	public final static String regxForFrameSize="/> Sizes:(.+?)<br";
	public final static String regxForFrameMaterial="/> Frame:(.+?)<br";
	//average: <strong>3.93</strong> out of 5)<br
	public final static String regxForrating="average: <strong>(.+?)<br";
	//class="post-title"><h2>Raleigh Team 2010 Road Bike</h2>
	public final static String regxForModel="class=\"post-title\"><h2>(.+?)</h2>";
	
	public final static String regxForFork="/> Fork:(.+?)<br";
	/*Components</strong><br
	/> Handlebar: FSA K-Force Carbon Compact<br
	/> Stem: FSA OS99 CSI<br
	/> Seatpost: FSA K-Force Light<br
	/> Seat: Selle Italia SLR Kit Carbonio<br
	/> Headset: FSA Carbon Integrated Cartridge Bearings<br
	/> Brake Levers: SRAM Red<br
	/> Brakes: SRAM Red<br
	/> Grips: Raleigh Gel Tape w/SRAM White Hoods<br
	/> Extras: Water Bottle Mounts, Cateye Reflector Set<br
	*/
	public final static String regxForComponent="Components</strong>(.+?)<strong>";
//    /> Headset: Integrated Steel Cup<br
//    /> Brakes: Scott Pro SCBR-520 Catridge Pads<br
//    /> Handlebar: Scott Road Drop OS Anatomic 31.8 mm<br
//    /> H&#8217;Stem: Scott Road Team OS 1-1/8&#8243; / four Bolt 31.8 mm<br
//    /> Seatpost: Scott Alloy 31.6mm<br
//    /> Seat: Scott Road Team<br
	public final static String regxForHeadSet="/> Headset: (.+?)<br";
	public final static String regxForBrakes="/> Brakes: (.+?)<br";
	public final static String regxForHanlebar="/> Handlebar: (.+?)<br";
	public final static String regxForStem="/> Stem: (.+?)<br";
	public final static String regxForSeatPost="/> Seatpost: (.+?)<br";
	public final static String regxForSeat="/> Seat: (.+?)<br";
	public final static String regxForSaddle="/> Saddles: (.+?)<br";
	
	
	//this section of the regx are used to clean the data 
	//modelclass="post-title"><h2>Scott CR1 Elite 2010 Road Bike</h2>
	public final static String regxCleanModel="<h2>(.+?)<";
	//<strong>3.53</strong> out of 5)<br
	public final static String regxCleanRating="<strong>(.+?)</";
	
	

}
