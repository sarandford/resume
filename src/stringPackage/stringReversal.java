/**
* the stringReversal class contains the methods and main which reverse an input String
* @author Sarah Ford
* @since August 22, 2014
* @status working properly
*/
package stringPackage;
import java.util.Scanner; 
public class stringReversal {
	/**
	 * the stringReversal method reads string input and converts it to a char array
	 * @param void
	 * @return a char []
	 */
	stringReversal(){}
	private char [] getString(){
		Scanner input=new Scanner(System.in);
		System.out.println ("Enter the string which you would like reversed followed by END: ");
		String word= "";
		while (!(input.hasNext("END"))){
			word+=" "+input.next();
		}
		input.close();
		word = word.toLowerCase();
		return word.toCharArray();		
	}
	/**
	The reverse method accpets an array of characters and prints them in reverse order to the console 
	@param letters a char []
	@return void
	*
	 */
	private void reverse(char [] letters){
		for(int i=letters.length-1;i>=0; i--){
			System.out.print(letters[i]);
		}
	}
	/**
	The main method runs both the other methods and instanitates the class
	@param args an array of type String
	@return void
	 **/
	public static void main(String[] args) {
		stringReversal obj=new stringReversal();
		char [] letters =obj.getString();
		obj.reverse(letters);
		

	}

}
