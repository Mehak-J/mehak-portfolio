import java.io.*;
import java.util.*;

public class Sort {
    public static void main(String args[]) throws Exception {
	String[] words = readUnsortedFileAsStringArray();
	
        sort(words);

	print(words);
    }
    
    private static void print(String[] words) {
	for(int i=0; i < words.length; i++) {
	    System.out.println(words[i]);
	}
    }

    private static String[] convertListToStringArray(List<String> wList) throws Exception {
	String[] words = new String[wList.size() - 1];
	for(int i=0; i < wList.size() - 1; i++) {
	    words[i] = wList.get(i);
	}
	return words;
    }
    
    private static String[] readUnsortedFileAsStringArray() throws Exception {
	File file = new File("unsorted.txt");
	BufferedReader reader  = new BufferedReader(new FileReader(file));

	String word;
	List<String> wList = new ArrayList();
	while ((word = reader.readLine()) != null) {
	   wList.add(word);
	}

        return convertListToStringArray(wList);
    }
    
    private static void sort(String[] words) {
	int size = words.length;
	//mehaks  sorting logic
	for(int i = 0; i < size-1; i++) {
	    for (int j = i+1; j < words.length; j++) {
		//this thingy compares each elements of the array to all the remaining elements
		if(words[i].compareTo(words[j]) > 0) {
		    //swapping array elements
		    String temp = words[i];
		    words[i] = words[j];
		    words[j] = temp;
		 }
	     }
	}
    }

    
}  
