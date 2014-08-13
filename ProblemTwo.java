import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
	

public class ProblemTwo {
	
	private String equals="=";
	
	@Test
	public final void testNullStringThrowsException() {
		try {
			ProblemOne problemOne = new ProblemOne();
			List<Map.Entry<String, Integer>> lists = problemOne.topNTerms(null,2);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("String value is null", e.getMessage());
		}
	}
	
	@Test
	public final void testEmptyStringThrowsException() {
		try {
			ProblemOne problemOne = new ProblemOne();
			List<Map.Entry<String, Integer>> lists = problemOne.topNTerms("",2);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("String value is empty", e.getMessage());
		}
	}

	@Test
	public final void testNTermsOfTwo() {
		ProblemOne problemOne = new ProblemOne();
		List<Map.Entry<String, Integer>> lists = problemOne.topNTerms("Run brown fox run. the See fox run.",2);
		
		//results should be run=3 and fox=2
		
		//first result; run=3
		Map.Entry<String,Integer> firstEntry = (Map.Entry<String,Integer>)lists.get(0);
		Assert.assertEquals("run=3", firstEntry.getKey() + equals + firstEntry.getValue());
		
		//second result; fox=2
		Map.Entry<String,Integer> secondEntry = (Map.Entry<String,Integer>)lists.get(1);
		Assert.assertEquals("fox=2", secondEntry.getKey() + equals + secondEntry.getValue());
	}
	
	@Test
	public final void testNTermsOfThree() {
		ProblemOne problemOne = new ProblemOne();
		List<Map.Entry<String, Integer>> lists = problemOne.topNTerms("Run brown fox run. the See fox run.",3);
		
		//results should be run=3, fox=2, and brown=1
		
		//first result; run=3
		Map.Entry<String,Integer> firstEntry = (Map.Entry<String,Integer>)lists.get(0);
		Assert.assertEquals("run=3", firstEntry.getKey() + equals + firstEntry.getValue());
		
		//second result; fox=2
		Map.Entry<String,Integer> secondEntry = (Map.Entry<String,Integer>)lists.get(1);
		Assert.assertEquals("fox=2", secondEntry.getKey() + equals + secondEntry.getValue());
		
		//third result; brown=1 
		Map.Entry<String,Integer> thirdEntry = (Map.Entry<String,Integer>)lists.get(2);
		Assert.assertEquals("brown=1", thirdEntry.getKey() + equals + thirdEntry.getValue());
	}	
}
