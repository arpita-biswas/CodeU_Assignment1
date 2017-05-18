
import java.util.HashMap;

public class q1 {
	
	public static void computeCharCount(String s, HashMap<Character, Integer> s_charCount){

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(s_charCount.containsKey(c))
				s_charCount.put(c, s_charCount.get(c) + 1);
			else
				s_charCount.put(s.charAt(i), 1);
		}
	}

	public static boolean checkPermute(String s1, String s2) {
		
		// if one of s1 and s2 is null, not a valid input
		// return false
		if(s1==null || s2==null){
			System.err.println("Invalid input");
			System.exit(-1);
		}
		
		// if lengths differ, return false 
		if(s1.length() != s2.length()){
			return false;
		}
		
		// if both s1 and s2 are empty strings, then they are vacuously permutations of each other
		// return true
		if(s1.length()==0 && s2.length()==0){
			return true;
		}
		
		// we are comparing characters, so case does not matter
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		HashMap<Character, Integer> s1_charCount = new HashMap<Character, Integer>();		
		
		// compute char count of s1
		computeCharCount(s1, s1_charCount);

		// compare s2 with s1
		for(int i=0; i<s2.length(); i++){
			char c = s2.charAt(i);
			if(s1_charCount.containsKey(c)){
				int count = s1_charCount.get(c);
				if(count>0){
					s1_charCount.put(c, count-1);
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	/**
	* params
	* args[0] : s1
	* args[1] : s2
	*/
	public static void main(String[] args) {

		if(args.length != 2){ 
			System.err.println("Insufficient number of arguments");
			return;
		}
		System.out.println("s1=*"+args[0]+"*");
		System.out.println("s2=*"+args[1]+"*");
		System.out.println("Permutation: " + checkPermute(args[0], args[1]));
	}
}


