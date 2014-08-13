import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class ProblemOne {
	
	public List<Map.Entry<String,Integer>> topNTerms(String stringValue,int nTerms){
		if(stringValue==null){
			throw new IllegalArgumentException("String value is null");
		}else if(stringValue.length()==0){
			throw new IllegalArgumentException("String value is empty");
		}else{
			//remove the period
			String stringValueWithoutPeriod = stringValue.replace(".", "");
			
			//create string array without period
			String [] arrayOfstringValueWithoutPeriod = stringValueWithoutPeriod.split(" ");
			
			//create an ordered map where the map key is the word and the map value is the word count.  the treemap is ordered by word.
			Map<String,Integer> topNTerms =  new TreeMap<String,Integer>();
			for(int i=0; i < arrayOfstringValueWithoutPeriod.length; i++){
				String lowerCaseStringValue = arrayOfstringValueWithoutPeriod[i].toLowerCase();
				if(topNTerms.containsKey(lowerCaseStringValue)){
					topNTerms.put(lowerCaseStringValue, topNTerms.get(lowerCaseStringValue) + new Integer(1));
				}else{
					topNTerms.put(lowerCaseStringValue, new Integer(1));
				}
			}
									
		   List<Map.Entry<String,Integer>> list = new ArrayList<Entry<String, Integer>>(topNTerms.entrySet());
			 
		   //reverse sort the list by map value (word count).  the list is already sorted by keys by the treemap.  after sort of word count, the list should now by sorted by map value (word count) and map key (word)
		   Collections.sort(list, new Comparator() {
		             public int compare(Object o1, Object o2) {
			           return ((Map.Entry<String,Integer>) (o2)).getValue().compareTo(((Map.Entry<String,Integer>) (o1)).getValue());
		             }
		   });
		
		  //only return the top nTerms specified
		  return list.subList(0, nTerms);
		}
	}
}
