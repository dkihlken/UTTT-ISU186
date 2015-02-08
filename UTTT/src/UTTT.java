/* Definitions:
 * X=1
 * O=2
 * empty=0
 */




public class UTTT {
	
	
	//precondition: Array is length 8
	public static int checkWin(int[] currArray){
		//Check if X wins
		if((currArray[0]==1 && currArray[1]==1 && currArray[2]==1) || (currArray[3]==1 && currArray[4]==1 && currArray[5]==1)
			|| (currArray[6]==1 && currArray[7]==1 && currArray[8]==1) || (currArray[0]==1 && currArray[3]==1 && currArray[6]==1)
			|| (currArray[1]==1 && currArray[4]==1 && currArray[7]==1) || (currArray[2]==1 && currArray[5]==1 && currArray[8]==1)
			|| (currArray[0]==1 && currArray[4]==1 && currArray[8]==1) || (currArray[6]==1 && currArray[4]==1 && currArray[2]==1)){
				return 1;	
			}
		//Check if O wins
		else if((currArray[0]==2 && currArray[1]==2 && currArray[2]==2) || (currArray[3]==2 && currArray[4]==2 && currArray[5]==2)
				|| (currArray[6]==2 && currArray[7]==2 && currArray[8]==2) || (currArray[0]==2 && currArray[3]==2 && currArray[6]==2)
				|| (currArray[1]==2 && currArray[4]==2 && currArray[7]==2) || (currArray[2]==2 && currArray[5]==2 && currArray[8]==2)
				|| (currArray[0]==2 && currArray[4]==2 && currArray[8]==2) || (currArray[6]==2 && currArray[4]==2 && currArray[2]==2)){
			return 2;
		}
		//No winner yet
		else{
			return 0;
		}
		
	}
	//postcondition: returns 0 for no winner, 1 for X winner, 2 for O winner

	
	
	//precondition: Array is length 9 and -1<pos<9 and character is 1 or 2
	public static void placeMark(int[] currArray, int pos, int character){
	
	}
	//postcondition: character is placed into pos position in the array

	
	
	//precondition: Array is length 9 and -1<pos<9
	public static boolean checkValidMove(int[] currArray, int pos){
		return true;
	}
	//postcondition: returns if that move position is an empty place
	
	//precondition: array is length 9 and width 9 and full of 0, 1,or 2
	public static void printGrid(int [][] currArray){
		
	}
	//postcondition: prints the current board with brackets and Xs and Os
	
	
	
	public static void main(String[] args) {
		
    }
}
 
