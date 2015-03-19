

public class TestWord {
	/*Follows the "Written Method Rules"
	
	The Written Method Rules
 	a.Count the number of vowels (A, E, I, O, U) in the word.
		Add 1 every time the letter 'y' makes the sound of a vowel (A, E, I, O, U).
		Subtract 1 for each silent vowel (like the silent 'e' at the end of a word).
 
	b.Subtract 1 for each diphthong or triphthong in the word.
		Diphthong: when 2 vowels make only 1 sound (aw, oy, oo)
		Triphthong: when 3 vowels make only 1 sound (iou)
 
	c.The number you are left with is the number of syllables in your word.
	*/
	private char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y' };
	
	public TestWord(){
		
	}
	
	public int CountSyllables(String word)
			{
		int numVowels=0;
	
        boolean lastWasVowel = false; 
        boolean foundVowel = false;
        boolean foundDiphthong = false;	//these two flags were used mostly for testing, or future updates 
        boolean foundTriphthong = false;
        
        for (int i =0; i < word.length(); i++)
        { 	
        	foundVowel = false;
            for (int v=0; v < vowels.length;v++){  
            	
           	 	//Special Cases
            		
            	
            	//Diphthong: when 2 vowels make only 1 sound (ai,au, ay, ea, ee, ie, oy, oo, oi, ui)
            	
            	if ((word.length()-i) > 1){
            		//special case
            		if ((word.charAt(i)== 'l') && (word.charAt(i+1)== 'l')){
            			foundDiphthong = false;
            			numVowels--;
               		 	break;
            			} 
            		
            		if ((word.charAt(i)== 'a') && (word.charAt(i+1)== 'i')){
            			foundDiphthong = true;
               		 	break;
            			} 
            		if ((word.charAt(i)== 'a') && (word.charAt(i+1)== 'u')){
            			foundDiphthong = true;
            			break;
            			}
            		if ((word.charAt(i)== 'u') && (word.charAt(i+1)== 'i')){
            			foundDiphthong = true;
            			break;
            			}
            		if ((word.charAt(i)== 'a') && (word.charAt(i+1)== 'y')){
            			foundDiphthong = true;
            			break;
            			}
            		if ((word.charAt(i)== 'e') && (word.charAt(i+1)== 'a')){
            			foundDiphthong = true;
            			break;
            			}
            		if ((word.charAt(i)== 'e') && (word.charAt(i+1)== 'e')){
            			foundDiphthong = true;
            			break;
            			}

            		if ((word.charAt(i)== 'i') && (word.charAt(i+1)== 'e')){
            			foundDiphthong = true;
            			break;
            			}
            		if ((word.charAt(i)== 'o') && (word.charAt(i+1)== 'y')){
            			foundDiphthong = true;
            			break;
            			}
            	 
            		if ((word.charAt(i)== 'o') && (word.charAt(i+1)== 'o')){
            			foundDiphthong = true;
            			break;
            			}
            	 
            		if ((word.charAt(i)== 'o') && (word.charAt(i+1)== 'i')){
            			foundDiphthong = true;
            			break;
            			}
            	 	} 						//end of Diphthong section
            	
            	//Triphthong: when 3 vowels make only 1 sound (iou, eau)
            	if ((word.length() - i )> 2 ){
            		
            		if ((word.charAt(i)== 'i') && (word.charAt(i+1)== 'o') && (word.charAt(i+2)== 'u')){
            			foundTriphthong = true;
            			break;
            			}
                
            		if ((word.charAt(i)== 'e') && (word.charAt(i+1)== 'a') && (word.charAt(i+2)== 'u')){
            			foundTriphthong = true;
            			break;
            			}
            	 	}	//end of Triphthong section
            	
                if (vowels[v]== word.charAt(i))
                {
                	numVowels++;
                    foundVowel = true;
                    lastWasVowel = true;
                    break;
                }
                                    
            } //end of Vowels compare section
            
            
            //if full cycle and no vowel found, set lastWasVowel to false;
            if (!foundVowel){
                lastWasVowel = false;
                }
            
            
            
        }  //end of for (int i =0; i < word.length(); i++) section
        
        //remove es, usually silent
        
        if (word.length() > 2 && 
            word.endsWith("es")){
            numVowels--;}
        
        if ((word.length() > 1) &&
            		(word.endsWith("o")) ){
                numVowels++;}
        
        //"ed" doesn't usually add a syllable
        else if (word.length() > 2 && 
                word.endsWith("ed")){
                numVowels--;}
        
        //Special case "the"
       else if (word.equals("the")){
    	  
    	   //numVowels++;
    		}
        
        // remove silent e
        else if ((word.length() > 1) &&
            //(word.endsWith("e")) && (word.equals("the"))){
        		(word.endsWith("e")) ){
            numVowels--;}
        
       	 	  		

        return numVowels;
    }
	
	}
