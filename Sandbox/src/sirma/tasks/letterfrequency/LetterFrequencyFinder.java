package sirma.tasks.letterfrequency;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

/***
 * 
 * @author GEORGI
 *
 *   PROBLEMS with the previous version:
 *   - The code was not well formatted - FIXED
 *   - Some methods could have more restrictive modifier - KINDA FIXED
 *   - Some values were hard coded into variables, better use constants - KINDA FIXED
 *   - No Secondary sorting present... - FIXED
 *   - No cap for printing the # symbol or efficient way of calculating relativity of the frequencies - KINDA FIXED
 *
 */


public final class LetterFrequencyFinder { //could possibly be made final - nothing useful to override or inherit
	
	public static final int PRINT_LIMIT=20; //public or private more appropriate for constants???
	public static final int MAX_NUMBER_SIGNS=20; //public or private more appropriate for constants???
	private static int highestCharFrequency;
	
    public static void main(String[] args) {
    	
        char[] charArray;
        Integer frequency;
        Map<Character, Integer> outputMap;
        Map<Character, Integer> charMap = new TreeMap<>(); //initial sort - the TreeMap interface keeps elements sorted in natural order ( in this case alphabetical )
    
        System.out.println("Input text here:");
        
        try ( Scanner sc = new Scanner(System.in) ) { 	
 
            charArray=sc.nextLine().toUpperCase().toCharArray();
        	
            for (Character c : charArray) {
                frequency = charMap.get(c);
            
                if ( Character.isLetter(c) ) {
            	    charMap.put( c, (frequency == null) ? 1 : frequency + 1 );
                }
            }
    
            outputMap = sortValuesDescending(charMap); //secondary sort to ensure the values are in descending order
            highestCharFrequency=outputMap.values().iterator().next(); 
    
            System.out.println("\nMost frequent letters are:");
            limitPrinting(outputMap);

        } catch (NoSuchElementException nex) {
            System.out.println("NO LINE WAS FOUND!\n");
            nex.printStackTrace(); 	
        } catch (IllegalStateException iex) {
    	    System.out.println("THE SCANNER IS CLOSED!\n");
            iex.printStackTrace();
        }
    }
    
  //What access modifier to use for method private or less restrictive ?
    private static <K, V extends Comparable<? super V>>  Map<Character, Integer>  sortValuesDescending( Map<Character, Integer> map ) {

        List<Map.Entry<Character, Integer>> list = new LinkedList<>( map.entrySet() );
        Map<Character, Integer> resultMap = new LinkedHashMap<>();
       
        Collections.sort( list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue());
            }
        } );
        
        for (Map.Entry<Character, Integer> entry : list) {
            resultMap.put( entry.getKey(), entry.getValue() );
        }  
    	return resultMap;
    }
    
    //What access modifier to use for method private or less restrictive ?
    private static void limitPrinting(Map<Character, Integer> outMap) {
    	
        int printCounter=0;
        int currentFrequency; 
    	
        for ( Map.Entry<Character, Integer> entry : outMap.entrySet() ) {
        	
            if (printCounter==PRINT_LIMIT) {
                break;
            }
         	System.out.print(entry.getKey() + " " + entry.getValue()+" ");
         	
         	currentFrequency=entry.getValue().intValue();
         	
         	for (int i=1; i<=( currentFrequency==highestCharFrequency ? MAX_NUMBER_SIGNS : (currentFrequency*MAX_NUMBER_SIGNS)/highestCharFrequency ); i++) {
         	    System.out.print("#");
         	}
         	System.out.println();	
            printCounter++;
        }
    }
    
}

