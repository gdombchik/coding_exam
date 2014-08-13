
public class ProblemThree {

	public int stringToInt(String s) {
		int i = 0;
		int number = 0;
		boolean isNegative = false;
		int stringLength = s.length();
		char [] charArray = s.toCharArray();
		char zero = '0';
		
		//if first character is a negative character, move to the next character
		if(charArray[0] == '-'){
			isNegative = true;
			i = 1;
		}
	
		//for each character multiply by 10 and add to the next character.  Example:  for string 123 i am basically doing the following 100+20+3=123
		for(;i<stringLength;i++){
			number = number * 10;
			number = number + (charArray[i] - zero);
		}
		
		//change to a negative int
		if(isNegative){
			number = number * -1;
		}
		
		return number;
	}
	
	public int stringToIntTest(String stringValue) {
		return stringToInt(stringValue);
	}

	public static void main(String[] args) {
		String stringValue123 = "123";
		ProblemThree problemThree = new ProblemThree();
		int i = problemThree.stringToIntTest(stringValue123);
		
		//confirm that the string converted to an int using Integer.parseInt is the same as the custom method stringToInt
		assert (Integer.parseInt(stringValue123) == i) : "value-->" + stringValue123 + " does not equal i--> " + i;
		
		//technically the problem asks to write a routine that converts a String to an Integer and not an int...so, i provide that below 
		assert (new Integer(stringValue123).equals(new Integer(i))) : "value-->" + stringValue123 + " does not equal i--> " + i;
		
		//a limitation of the routine is that the negative sign is the only non-integer character it can handle.  the routine breaks with any additional non-integer character besides a negative sign at the beginning of the string.
		//this works
		String stringValueNegative123 = "-123";
		i = problemThree.stringToIntTest(stringValueNegative123);
		assert (new Integer(stringValueNegative123).equals(new Integer(i))) : "value-->" + stringValueNegative123 + " does not equal i--> " + i;
		//this does not work
		String stringValueDouble123 = "123.0";
		i = problemThree.stringToIntTest(stringValueDouble123);
		assert (new Double(stringValueDouble123).intValue() == i) : "value-->" + stringValueDouble123 + " does not equal i--> " + i;
		
		
	}

}
