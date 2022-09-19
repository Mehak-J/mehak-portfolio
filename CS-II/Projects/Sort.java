import java.io.*;
import java.util.*;

public class Sort {
    public static void main(String args[]) throws Exception {
	String[] words = readUnsortedFileAsStringArray();
	
        sort(words);

	writeSortedContentToFile(words);

	printFromSortedFile();

	deleteSortedFile();
    }

    private static void deleteSortedFile() throws Exception {
	File file = new File("sorted.txt");
	file.delete(); 
    }
    
    private static void printFromSortedFile() throws Exception {
	BufferedReader reader  = new BufferedReader(new FileReader("sorted.txt"));
	String word = "";
	while ((word = reader.readLine()) != null)  {
	    System.out.println(word);
	}
    }

    private static void writeSortedContentToFile(String[] words) throws Exception {
	BufferedWriter writer = new BufferedWriter(new FileWriter("sorted.txt"));
	for(int i=0; i < words.length; i++) {
	    writer.write(words[i] + "\n");  
	}
	writer.close();
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
