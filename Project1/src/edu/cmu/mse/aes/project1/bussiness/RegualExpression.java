package edu.cmu.mse.aes.project1.bussiness;
/*
 * author: Rui Li
 * 
 * This class will keep the regx which will be used for filter out the useful info
 */
public class RegualExpression {
	
	//Such Regx will list out all the links to 20 brands like: http://bikereviews.com/road-bikes/raleigh/
	public static  final String RegxForFilterLinks="Bikes\" href=\"http://bikereviews.com/road-bikes/(.+?)/";
	
	//title="2010 Raleigh Road Bikes" href="http://bikereviews.com/road-bikes/raleigh/2010-raleigh/">2010 Raleigh Road Bikes</a><br
	public final static String regx2="Bikes\" href=\"http://bikereviews.com/road-bikes/(.+?)/\">2010";
	//href="http://bikereviews.com/road-bikes/raleigh/2010-raleigh/raleigh-team-road-bike/" title="
	public final static String regx3="href=\"http://bikereviews.com/road-bikes/(.+?)/\" title=";
	
	public final static String regxForPrice="";
	public final static String regxForFrameSize="/> Sizes:(.+?)<br";
	public final static String regxForFrameMaterial="/> Frame:(.+?)<br";
	//average: <strong>3.93</strong> out of 5)<br
	public final static String regxForrating="average: <strong>(.+?))<br";
	//class="post-title"><h2>Raleigh Team 2010 Road Bike</h2>
	public final static String regxForModel="class=\"post-title\"><h2>(.+?)</h2>";
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
	public final static String regxForComponent="Components</strong><br/>(.+?)<br";

	
	

}
