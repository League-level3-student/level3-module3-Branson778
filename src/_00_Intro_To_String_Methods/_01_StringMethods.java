package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	String longe;
    	if(s1.length()>s2.length()) {
    		longe = s1;
    	}
    	else {
    		longe = s2;
    	}
        return longe;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
        if(s.contains("underscores")) {
       s = 	s.replace(' ', '_');
        }
    	return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	s1 = s1.trim();
    	s2 = s2.trim();
    	s3 = s3.trim();
    	String sub1 = s1.substring(s1.indexOf(" "));
    	String sub2 = s2.substring(s2.indexOf(" "));
    	String sub3 = s3.substring(s3.indexOf(" "));
    	int temp = sub1.compareTo(sub2);
    	if(temp > 0) {
    		int temp2 = sub2.compareTo(sub3);
    		if(temp2 > 0) {
    			return s3;
    		}
    		else {
    			return s2;
    		}
    	}
    	else {
    		int temp3 = sub1.compareTo(sub3);
    		if(temp3 > 0) {
    			return s3;
    		}
    		else {
    			return s1;
    		}
    	}
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
    	for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				int temp = Character.getNumericValue(s.charAt(i));
				sum = sum + temp;
			}
		}
        return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
        int count = 0;
        int index = s.indexOf(substring);
        while( index != -1 ) {
            count++;
            index = s.indexOf(substring, index + substring.length());
        }
    	return count;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	return Utilities.encrypt(s.getBytes(), (byte) key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        return Utilities.decrypt(s, (byte) key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
       int count = 0;
       int whileLooper = 0;
       int index = 0;
       String[] words = s.split(" ");
       while(whileLooper==0) {
    	   if(index>=words.length) {
    		   break;
    	   }
    	   if(words[index].endsWith(substring)) {
    		   count++;
    	   }
    	   index++;
       }
    	return count;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
       int first = s.indexOf(substring)+substring.length();
       int finall = first;
       for (int i = first; i < s.length(); i++) {
		 finall = s.indexOf(substring,i);
		 i = finall+substring.length();
	}
    	return finall-first;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
       String s2 = s.trim();
    	s2 = s2.toLowerCase();
        s2 = s2.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\.", "");
        s2 = s2.replaceAll("\\?", "");
        s2 = s2.replaceAll(",", "");
        s2 = s2.replaceAll(":", "");
        s2 = s2.replaceAll(";", "");
        s2 = s2.replaceAll("-", "");
       String flips = "";
       for (int i = s2.length()-1; i >= 0; i--) {
		flips += s2.charAt(i);
	}
       if(s2.equals(flips)) {
    	   return true;
       }
       else {
    	   return false;
       }
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
