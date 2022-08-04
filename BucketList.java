import java.util.*;
import java.io.*;

public class BucketList{
	public static void main(String[] args) throws FileNotFoundException {
			
		System.out.println("Enter the name of the categories file:");

		Scanner fileName= new Scanner(System.in);
		String file = fileName.nextLine();

		Scanner open = new Scanner(new File(file));

		ArrayList<String> array = new ArrayList<String>();


		while(open.hasNextLine()){
			array.add(open.nextLine());
		}

		System.out.println("Enter a comma-separated list of words:");
		String line = fileName.nextLine();

		ArrayList<String> words = new ArrayList<String>(); 
		HashMap<String,String> hash = new HashMap<String,String>();

		Scanner tokens = new Scanner(line).useDelimiter(",");
		while(tokens.hasNext()){
			words.add(tokens.next());
		}

		//System.out.println(words);

		System.out.println("Categorised:");

		for (int i=0;i<words.size();i++) {
			String token = words.get(i);
			//System.out.println(token);
			
				if(checkOverlap(array,token)==true){
					String match = longestPossibleMatch(array,words.get(i));
					//hash.put(match,token);
              
					System.out.println(match+": "+token+".");
					//continue;
				}

				else{
	
						if(token.startsWith(array.get(i))){
							System.out.println(array.get(i)+ " "+ token );
						
					}
				}
			
		
		}

      System.out.println("Done ");


		
	}

	public static boolean checkOverlap(ArrayList<String> arr, String word){

		int count = 0;

		for (int i=0;i<arr.size();i++) {
			if(word.startsWith(arr.get(i))){
				count++;
			}
		}

		if(count==0){
			return false;
		}
		
		return true;

		//return false;

	}

	public static ArrayList<String> getMatches(ArrayList<String> arr, String word){


		

		ArrayList<String> matches = new ArrayList<String>();

		for (int i= 0;i<arr.size();i++) {
			if(word.startsWith(arr.get(i))){
				matches.add(arr.get(i));
			}
		}


		return matches;
		
	}

	public static String longestPossibleMatch(ArrayList<String> arr, String word1){
		ArrayList<String> newArray = getMatches(arr, word1); 

		String word = newArray.get(0);
		int wordLength= word.length();
		for (int i=1;i<newArray.size();i++) {
			String word2 = newArray.get(i);

			if(word2.length()>wordLength){
				word=word2;
				wordLength = word2.length();
			}
		}

		return word;
	}
}