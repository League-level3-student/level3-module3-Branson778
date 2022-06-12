package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
        StringBuilder build = new StringBuilder(str);
    	return build.append(characters).toString();
    }
    
    public static String reverse(String str) {
    	StringBuilder build = new StringBuilder(str);
    	return build.reverse().toString();
    }
    
    public static String insert(String str, int index, char newChar) {
    	 StringBuilder build = new StringBuilder(str);
    	return build.insert(index, newChar).toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	 StringBuilder build = new StringBuilder(str);
    	return build.delete(startIndex, endIndex).toString();
    }
}