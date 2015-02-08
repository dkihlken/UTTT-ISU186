import java.util.Scanner;

/* Definitions:
 * X=1
 * O=2
 * empty=0
 */




public class UTTT {
	static int [][] Board = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
	static int [] BigBoard = {0,0,0,0,0,0,0,0,0};
	static Scanner kb = new Scanner(System.in);
	
	
	//precondition: Array is length 8
	public static void checkWin(int[] currArray,int currBoard){
		//Check if X wins
		if((currArray[0]==1 && currArray[1]==1 && currArray[2]==1) || (currArray[3]==1 && currArray[4]==1 && currArray[5]==1)
			|| (currArray[6]==1 && currArray[7]==1 && currArray[8]==1) || (currArray[0]==1 && currArray[3]==1 && currArray[6]==1)
			|| (currArray[1]==1 && currArray[4]==1 && currArray[7]==1) || (currArray[2]==1 && currArray[5]==1 && currArray[8]==1)
			|| (currArray[0]==1 && currArray[4]==1 && currArray[8]==1) || (currArray[6]==1 && currArray[4]==1 && currArray[2]==1)){
				BigBoard[currBoard] = 1;	
			}
		//Check if O wins
		else if((currArray[0]==2 && currArray[1]==2 && currArray[2]==2) || (currArray[3]==2 && currArray[4]==2 && currArray[5]==2)
				|| (currArray[6]==2 && currArray[7]==2 && currArray[8]==2) || (currArray[0]==2 && currArray[3]==2 && currArray[6]==2)
				|| (currArray[1]==2 && currArray[4]==2 && currArray[7]==2) || (currArray[2]==2 && currArray[5]==2 && currArray[8]==2)
				|| (currArray[0]==2 && currArray[4]==2 && currArray[8]==2) || (currArray[6]==2 && currArray[4]==2 && currArray[2]==2)){
			BigBoard[currBoard] = 2;
		}
		//No winner yet
	}
	//postcondition: changes corresponding value in bigboard to what the winner is

	
	
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
	public static void printGrid(int [][] A){
		System.out.println("|"+ A[0][0]+"|"+A[0][1]+"|"+A[0][2]+"|     |"+A[1][0]+"|"+A[1][1]+"|"+A[1][2]+"|     |"+A[2][0]+"|"+A[2][1]+"|"+A[2][2]+"|");
		System.out.println("|"+ A[0][3]+"|"+A[0][4]+"|"+A[0][5]+"|     |"+A[1][3]+"|"+A[1][4]+"|"+A[1][5]+"|     |"+A[2][3]+"|"+A[2][4]+"|"+A[2][5]+"|");
		System.out.println("|"+ A[0][6]+"|"+A[0][7]+"|"+A[0][8]+"|     |"+A[1][6]+"|"+A[1][7]+"|"+A[1][8]+"|     |"+A[2][6]+"|"+A[2][7]+"|"+A[2][8]+"|");
		System.out.println("-------------------------------");
		System.out.println("|"+ A[3][0]+"|"+A[3][1]+"|"+A[3][2]+"|     |"+A[4][0]+"|"+A[4][1]+"|"+A[4][2]+"|     |"+A[5][0]+"|"+A[5][1]+"|"+A[5][2]+"|");
		System.out.println("|"+ A[3][3]+"|"+A[3][4]+"|"+A[3][5]+"|     |"+A[4][3]+"|"+A[4][4]+"|"+A[4][5]+"|     |"+A[5][3]+"|"+A[5][4]+"|"+A[5][5]+"|");
		System.out.println("|"+ A[3][6]+"|"+A[3][7]+"|"+A[3][8]+"|     |"+A[4][6]+"|"+A[4][7]+"|"+A[4][8]+"|     |"+A[5][6]+"|"+A[5][7]+"|"+A[5][8]+"|");
		System.out.println("-------------------------------");
		System.out.println("|"+ A[6][0]+"|"+A[6][1]+"|"+A[6][2]+"|     |"+A[7][0]+"|"+A[7][1]+"|"+A[7][2]+"|     |"+A[8][0]+"|"+A[8][1]+"|"+A[8][2]+"|");
		System.out.println("|"+ A[6][3]+"|"+A[6][4]+"|"+A[6][5]+"|     |"+A[7][3]+"|"+A[7][4]+"|"+A[7][5]+"|     |"+A[8][3]+"|"+A[8][4]+"|"+A[8][5]+"|");
		System.out.println("|"+ A[6][6]+"|"+A[6][7]+"|"+A[6][8]+"|     |"+A[7][6]+"|"+A[7][7]+"|"+A[7][8]+"|     |"+A[8][6]+"|"+A[8][7]+"|"+A[8][8]+"|");
		
	}
	//postcondition: prints the current board with brackets and Xs and Os
	
	public static void runTwoPlayer(){
		int x;
		int y;
		System.out.println("What x");
		x = kb.nextInt();
		System.out.println("What y");
		y = kb.nextInt();
		placeMark(Board[x],y,1);
		x = y;
		printGrid(Board);
		do{
			System.out.println("(player 2) What y");
			y = kb.nextInt();
			if(checkValidMove(Board[x],y)){
				placeMark(Board[x],y,2);
			}
			printGrid(Board);
			x=y;
			System.out.println("(player 1) What y");
			y = kb.nextInt();
			if(checkValidMove(Board[x],y)){
				placeMark(Board[x],y,1);
			}
			x=y;
			printGrid(Board);
			
		}while(checkBigBoardWin(BigBoard)==0);
	}
	
	public static int checkBigBoardWin(int [] B){
		
		if((B[0]==1 && B[1]==1 && B[2]==1) || (B[3]==1 && B[4]==1 && B[5]==1)
				|| (B[6]==1 && B[7]==1 && B[8]==1) || (B[0]==1 && B[3]==1 && B[6]==1)
				|| (B[1]==1 && B[4]==1 && B[7]==1) || (B[2]==1 && B[5]==1 && B[8]==1)
				|| (B[0]==1 && B[4]==1 && B[8]==1) || (B[6]==1 && B[4]==1 && B[2]==1)){
					return 1;	
				}
		if((B[0]==2 && B[2]==2 && B[2]==2) || (B[3]==2 && B[4]==2 && B[5]==2)
				|| (B[6]==2 && B[7]==2 && B[8]==2) || (B[0]==2 && B[3]==2 && B[6]==2)
				|| (B[2]==2 && B[4]==2 && B[7]==2) || (B[2]==2 && B[5]==2 && B[8]==2)
				|| (B[0]==2 && B[4]==2 && B[8]==2) || (B[6]==2 && B[4]==2 && B[2]==2)){
					return 2;	
				}
		return 0;
	}
	
	public static void main(String[] args) {
		
		int choice;
		printGrid(Board);
		System.out.println("What mode would you like to play? (0 for 2 player, 1 for person vs Ai, 2 for AI vs AI)");
		choice = kb.nextInt();
		
		if(choice == 0){
			runTwoPlayer();
		}
		}
    }

 
