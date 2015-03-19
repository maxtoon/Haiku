
public class Main {
	
	public Main(String fileName){			//normal file I/O constructor
		FileIO getText = new FileIO(fileName);
		getText.readFile();
	}
	//Test Constructor for a single word
	public Main(){
		int count;
		String word;
		word = "jello";
		TestWord currentWord = new TestWord();
		count = currentWord.CountSyllables(word);
		System.out.println("The count is: "+ count);	
		System.out.println("The word is: "+ word);	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Comment one or the other out to run
		
		//Test constructor, only for a SINGLE WORD***********
		//Main main = new Main();
		
		
		//File IO constructor
		Main main= new Main("g://haiku.txt");
		
		
	}

}
