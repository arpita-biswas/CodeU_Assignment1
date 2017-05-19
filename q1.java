import java.util.HashMap;

public class q1 {
	
	public static HashMap<Character, Integer> computeCharCount(String s){
		HashMap<Character, Integer> s_charCount = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(s_charCount.containsKey(c))
				s_charCount.put(c, s_charCount.get(c) + 1);
			else
				s_charCount.put(s.charAt(i), 1);
		}
		return s_charCount;
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
				
		// compute char count of s1
		 HashMap<Character, Integer> s1_charCount = computeCharCount(s1);

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
	
	public static void main(String[] args) {

		String s1;
		String s2;
		
		s1 = "Listen";	s2 = "Silent";	//true
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));
		
		s1 = "12$b";	s2 = "$b12"; 	// true
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));
		
		s1 = "$b12";	s2 = "12$b"; 	// true
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));
		
		s1 = "red";	s2 = "zed"; 	//false
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));
				
		s1 = "blue";	s2 = "red"; 	//false
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));
		
		s1 = "";	s2 = "";	//true
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));
		
		s1 = "";	s2 = "34e";	//false
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));
		
		s1 = "hello world";	s2 = "world hello";	//true
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));
		
		s1 = null;	s2 = "sc";	//Error statement: invalid input
		System.out.println(s1+" , "+s2+" => " + checkPermute(s1, s2));

	}
}


