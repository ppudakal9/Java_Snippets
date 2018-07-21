package com.snippets;

public class StringtoInt extends CodingPractice {

	public static void main (String[] args) {
		StringtoInt inputStr = new StringtoInt();
		int result = inputStr.strToInt("12 3");
		System.out.println("result = "+result);
		int sum = inputStr.sumOfNumbers(result);
		System.out.println("sum = "+sum);
	}
	public static int strToInt( String str ){
		
		int intValue = 0;
		boolean positiveInt = true;
		int i = 0;
		
		if(str.length()==0) {
			return 0;
		}
		
		//Check if there is a negative sign in the given string
		if(str.charAt(0)=='-') {
			positiveInt = false;
			i = 1;
		}
		
		while(i < str.length()) {
			if(str.charAt(i) == ' ') {
				i++;
				continue;
			} 
			intValue = intValue * 10;
			intValue += str.charAt(i++) - '0'; // ASCII value of '0' is 48
		}
		
		if(!positiveInt) {
			intValue = -intValue;
		}
		
		return intValue;
	}
	
	public static int sumOfNumbers( int result ){
	
		int sum = 0;
		int quo = result;
		int i = result;
		if(result==0) {
			return 0;
		}
		
		while(i>10) {
			i = quo/10;//12, 1
			sum=sum+(quo%10);//3, 3+2 = 5
			quo = i;//12, 1
			
		}
		sum+=quo; //5+1
		
		return sum;
	}
}
