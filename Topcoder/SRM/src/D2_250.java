import java.util.HashMap;
import java.util.Map;

/*
 * 
Problem Statement
    
An electronics manufacturer has called you in to make a program to decode resistor color codes. 
You are given a vector <string> code containing three elements corresponding to the first three color bands on a resistor. 
Return the # of Ohms the resistor represents.  
The first two bands of resistors represent the value, while the third is a multiplier, as shown in the following chart: 
Color:      Value:       Multiplier:

black         0                   1
brown         1                  10
red           2                 100
orange        3               1,000
yellow        4              10,000
green         5             100,000
blue          6           1,000,000
violet        7          10,000,000
grey          8         100,000,000
white         9       1,000,000,000
 For example if you are given { "yellow", "violet", "red" }, you would return 4700.
Definition
    
Class:
ColorCode
Method:
getOhms
Parameters:
vector <string>
Returns:
long long
Method signature:
long long getOhms(vector <string> code)
(be sure your method is public)
    

Notes
-
Actual resistors can have a 4th and even a 5th band representing the tolerance, and the amount the value might change in 1,000 hours of use, respectively, but for our purposes we will only deal with the first three bands.
Constraints
-
code consists of 3 elements each containing one of the color words above, all in lower case.
Examples
0)

    
{ "yellow", "violet", "red" }
Returns: 4700
The example from the problem statement.
1)

    
{ "orange", "red", "blue" }
Returns: 32000000

2)

    
{ "white", "white", "white" }
Returns: 99000000000
The maximum possible.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class D2_250 {
	private static final Map<String,String> map = new HashMap<String,String>();
	static {
		map.put("black","0:");
		map.put("brown","1:0");
		map.put("red","2:00");
		map.put("orange","3:000");
		map.put("yellow","4:0000");
		map.put("green","5:00000");
		map.put("blue","6:000000");
		map.put("violet","7:0000000");
		map.put("grey","8:00000000");
		map.put("white","9:000000000");
	}

	public long getOhms(String[] code){
		StringBuilder sb = new StringBuilder();
		String line= "";
		line = map.get(code[0]).split(":")[0];
		sb.append(line);
		line = map.get(code[1]).split(":")[0];
		sb.append(line);
		line = map.get(code[2]).split(":")[1];
		sb.append(line);
		return Long.parseLong(sb.toString());
	}

	public static void main(String[] args) {
		new D2_250().getOhms(new String[]{"white", "black", "black"});
	}
}
