package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	for(int i = 0; i < clues.length; i++) {
    		System.out.println(clues[i]);
    	}
    	HashMap <String, Integer> hash = new HashMap();
    	Node <TrainCar >head = train.getHead();
    	while(head != null){
    		System.out.println(head.getValue().questionPassenger());
    		String info = head.getValue().questionPassenger();
    		String s = info;
    		int num = 0;
        	for(int i = 0; i < clues.length; i++) {
    		if(info.contains(clues[i])) {
    			System.out.println("bruh");
    			s = s.substring(0, s.indexOf(clues[i]));
    			String sList[] = s.split(" ");
    			s = sList[sList.length-1];
    			if (!hash.containsKey(s)) {
    				hash.put(s, 1);
    			}else {
    				int temp = hash.get(s);
    				hash.put(s, temp+1);
    			}

    		}
        	}
        	
    		head = head.getNext();
    		
    	}
    		String maxKey = "";
    		int i = -10000000;
    		for(String a : hash.keySet()) {
    			if(hash.get(a)> i){
    				i = hash.get(a);
    				maxKey = a;
    			}
    		}

        return maxKey;

    }

}
// Possibly useful String functions:
//   .split
//   .endsWith
//   .indexOf