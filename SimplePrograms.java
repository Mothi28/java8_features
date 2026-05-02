package example.features.java8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimplePrograms {
	
	public static void main (String args[]) {
		
		List<Integer> l = Arrays.asList(1,2,3,4,5,5,6,6,7);
		System.out.println("Removed the duplicates ");
		System.out.println(l.stream().distinct().collect(Collectors.toList()));
		//.forEach(System.out::print);
		
		String s="([)]";
		isBalanced(s);
		List<Integer> l1 = Arrays.asList(1,2,3);
		List<Integer> l2 = Arrays.asList(4,5);

		System.out.println(pairList(l1, l2));
		
		String frq="asdfghssdff";
		findHighFreq(frq);
		
		/*Map<String,Integer> brack = new HashMap<>();
		int openBoxCount=0;
		int closeBoxCount=0;
		int openCurCount=0;
		int closeCurCount=0;
		int openFlowCount=0;
		int closeFlowCount=0;
		boolean curFlag=false;
		boolean boxFlag=false;
		boolean flowFlag=false;

		brack.put("openBox",0 );
		brack.put("closeBox", 0);
		brack.put("openFlow",0);
		brack.put("closeFlow", 0);
		brack.put("openCur",0);
		brack.put("closeCur", 0);
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				openCurCount++;
			}
			if(s.charAt(i)==')') {
				closeCurCount++;
			}
			if(s.charAt(i) =='[') {
				openBoxCount++;
			}
			if(s.charAt(i)==']') {
				closeBoxCount++;
			}
			if(s.charAt(i)=='{') {
				openFlowCount++;
			}
			if(s.charAt(i)=='}') {
				closeFlowCount++;
			}
		}
		brack.put("openCur", openCurCount);
		brack.put("closeCur", closeCurCount);
		brack.put("openBox",openBoxCount );
		brack.put("closeBox", closeBoxCount);
		brack.put("openFlow",openFlowCount);
		brack.put("closeFlow", closeFlowCount);
		
		if((s.contains("(")||s.contains(")")) && brack.get("openCur")==brack.get("closeCur")) {
			curFlag=true;
		}
		if((s.contains("[")||s.contains("]")) && brack.get("openBox")==brack.get("closeBox")) {
			boxFlag=true;
		}
		if((s.contains("{")||s.contains("}")) && brack.get("openFlow")==brack.get("closeFlow")) {
			flowFlag=true;
		}
		
		if(curFlag && boxFlag && flowFlag) {
			System.out.println("String Balanced ");
		}
		else {
			System.out.println("String imbalanced ");
		}
		*/
	}
	
	static boolean isBalanced(String s) {

        //Stack<Character> stack = new Stack<>(); "([)]"

        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {

            // Step 1: push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // Step 2: handle closing brackets
            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (!isMatching(top, ch)) return false;
            }
        }

        // Step 3: final validation
        return stack.isEmpty();
    }

    static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    static List<String> pairList(List<Integer> l1, List<Integer> l2) {
//	
//    	I wrote the code 
//    	//[1,2,3]
//    	//[4,5]
//    	int loopOutCounter=0;
//    	int loopInpCounter=0;
//    	String set="";
//
//    	if(l1.size()>l2.size()) 
//    	{
//    		loopOutCounter=l1.size();
//    		loopInpCounter=l2.size();
//    	}
//    	else if(l2.size()>l1.size()) {
//    		loopOutCounter=l2.size();
//    		loopInpCounter=l1.size();
//
//    	}
//    	else {
//    		loopOutCounter=l1.size();
//    		loopInpCounter=l1.size();
//    	}
//    	
//    	for (int i=0;i<loopOutCounter;i++) {
//    		
//    		if(i<loopInpCounter)
//    		{
//    			set="("+String.valueOf(l1.get(i))+","+String.valueOf(l2.get(i))+")";
//    			System.out.println("Set created here "+set);
//    		}
//    		
//    	}
//    	
    	//OPtimized code 

    	    List<String> result = new ArrayList<>();

    	    int minSize = Math.min(l1.size(), l2.size());

    	    for (int i = 0; i < minSize; i++) {
    	        result.add("(" + l1.get(i) + "," + l2.get(i) + ")");
    	    }

    	    return result;

   	
    }
    
    static void findHighFreq(String s){
    Map<Character, Integer> freq = new HashMap<>();

    for (char ch : s.toCharArray()) {
        freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }

    int max = 0;
    for (int count : freq.values()) {
        max = Math.max(max, count);
    }

    // collect all chars with max frequency
    List<Character> result = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
        if (entry.getValue() == max) {
            result.add(entry.getKey());
        }
    }

    System.out.println("Max freq: " + max);
    System.out.println("Chars: " + result);
    }
}
    

