import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.StringTokenizer;


public class FileIO {

	private String fileName;
	private int count=0;
	

public FileIO(String fileName){
	this.fileName = fileName;
	
}


		public void readFile()
	{
		
		BufferedReader br = null;
		TestWord test = new TestWord();
		int count=0;
		int sum = 0;
		String word = null, lineOne=null, lineTwo=null, lineThree=null;
		boolean foundOne, foundTwo, foundThree;
	
		try {
			String sentence = null;
			String sCurrentLine, currentLine;
			System.out.println("Read File is: "+fileName+"\n");

			//use Buffered Reader to read in one line from the file
			br = new BufferedReader(new FileReader(fileName));//use Buffered Reader to read in one line from the file
			
			foundOne=false;
			foundTwo = false;
			foundThree = false;
			
			while ((currentLine= (br.readLine())) != null) {
					sCurrentLine = currentLine.toLowerCase(); //set read line to lower case
					BreakIterator bi = BreakIterator.getSentenceInstance(); //break line into sentences
					bi.setText(sCurrentLine);
					int index = 0;
					while (bi.next() != BreakIterator.DONE) {
						sentence = (sCurrentLine.substring(index, bi.current())).replaceAll("\\W", " "); //remove punctuation
						System.out.println("Sentence: " + sentence);
						index = bi.current();
						StringTokenizer st = new StringTokenizer(sentence);//Tokenize sentences to a series of words
						 
						while (st.hasMoreElements()) {
							word=((String)st.nextElement());
							//System.out.println("Word " + word); //for testing
							count =test.CountSyllables(word); //submit word to count syllables, return number of syllables
							//System.out.println("Count syllables in word "+count+"\n");// for testing
							sum = sum + count; //sum for the sentence
											} //end of While loop
						
						
					}  //  while (bi.next() != BreakIterator.DONE)
					
						
				
				System.out.println("Sum of syllables in evaluated line: "+sum+"\n");
				
				//Haiku logic begins here too detect the 5/7/5 syllable pattern
				
				if ((sum == 5) && (!foundOne)){
					foundOne = true;
					lineOne = sCurrentLine;
					sum=0;
					System.out.println("Line 1 passes with 5 "+lineOne+"\n");
						}
				else if ((sum == 7) && (foundOne) && (!foundTwo)){
					foundTwo = true;
					lineTwo=sCurrentLine;
					System.out.println("Found line Two that passes");
					sum=0;
				}
				else if ((sum == 5) && (foundOne) && (foundTwo) && (!foundThree)){
					foundThree = true;
					lineThree = sCurrentLine;
					sum=0;
					System.out.println(" Found a Haiku");
					System.out.println(lineOne+"\n"+lineTwo+"\n"+lineThree+"\n");
				}
				else{
					foundOne = false;
					foundTwo = false;
					foundThree = false;
					lineOne = null;
					lineTwo = null;
					lineThree = null;
					sum=0;
				}
			}		//end of Haiku logic

 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
 

		
	}
	
	
	
}
