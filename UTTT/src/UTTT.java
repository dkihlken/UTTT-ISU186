	import java.util.Random;
import java.util.Scanner;

	/* Definitions:
	 * X=1
	 * O=2
	 * empty=0
	 */

	public class UTTT {
		static int [][] Board = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
		static int [] BigBoard = {0,0,0,0,0,0,0,0,0};
		static char [][] CharBoard = {{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' ',' ',' '}};
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
		public static void placeMark(int[] currArray,char[] charArray, int pos, int character){
		currArray[pos]=character;
		if(character == 1){
			charArray[pos] = 'X';
		}else{
			charArray[pos] = 'O';
		}
		}
		//postcondition: character is placed into pos position in the array

		//precondition: Array is length 9 and -1<pos<9
		public static boolean checkValidMove(int[] currArray, int pos){
			if(currArray[pos]==0){
				return true;
			}else{
				return false;
			}
		}
		//postcondition: returns if that move position is an empty place
		
		//precondition: array is leng0th 9 and width 9 and full of 0, 1,or 2
		public static void printGrid(char [][] A){
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
			//System.out.println(BigBoard[0] + "," + BigBoard[1] + "," + BigBoard[2] + "," + BigBoard[3] + "," + BigBoard[4] + "," + BigBoard[5] + "," + BigBoard[6] + "," + BigBoard[7] + "," + BigBoard[8]);
			
		}
		//postcondition: prints the current board with brackets and Xs and Os
		
		public static void runTwoPlayer(){
		
			int x;  //Big Board
			int y;  //Little Board
			boolean p1ValBad = true;  // ends the x loop
			boolean p2ValBad = true;  // ends the y loop
			//Initial moves
		
			do{
				System.out.println("What x");
				x = kb.nextInt();
				if(x<=8 && x>=0){
					p1ValBad = false;
				}
				else{
					System.out.println("Invalid move. Please try again.");
					p1ValBad = true;
				}
			}while(p1ValBad);
			do{
				System.out.println("What y");
				y = kb.nextInt();
				if(y<=8 && y>=0){
					p2ValBad = false;
					placeMark(Board[x],CharBoard[x],y,1);
					x = y;
					printGrid(CharBoard);
				}
				else{
					System.out.println("Invalid move. Please try again.");
					p2ValBad = true;
				}	
			}while(p2ValBad);
			
			//Subsequent moves
			do{ //end game
				p1ValBad = true;
				p2ValBad = true;
				
				do{ // move is valid
					if (BigBoard[x]!=0 || checkFullGridSmall(Board[x])){
						do{
							System.out.println("What x");
							x = kb.nextInt();
							if(x<=8 && x>=0){
								p1ValBad = false;
							}
							else{
								System.out.println("Invalid move. Please try again.");
								p1ValBad = true;
							}
						}while(p1ValBad);
					}
					System.out.println("(player 2) What y");
					y = kb.nextInt();
					if(y<=8 && y>=0 && checkValidMove(Board[x],y)){
						p1ValBad = false;
						placeMark(Board[x],CharBoard[x],y,2);
						checkWin(Board[x],x);
						x=y;
						printGrid(CharBoard);
					}
					else{
						System.out.println("Invalid move. Please try again.");
						p1ValBad = true;
					}
				}while(p1ValBad);
				
			
				do { //move is valid
					if (BigBoard[x]!=0 || checkFullGridSmall(Board[x])){
						do{
							System.out.println("What x");
							x = kb.nextInt();
							if(x<=8 && x>=0){
								p2ValBad = false;
							}
							else{
								System.out.println("Invalid move. Please try again.");
								p2ValBad = true;
							}
						}while(p2ValBad);
					}
					System.out.println("(player 1) What y");
					y = kb.nextInt();
					if(y<=8 && y>=0 && checkValidMove(Board[x],y)){
						p2ValBad = false;
						placeMark(Board[x],CharBoard[x],y,1);
						checkWin(Board[x],x);
						x=y;
						printGrid(CharBoard);
					}
					else{
						System.out.println("Invalid move. Please try again.");
						p2ValBad = true;
					}
				}while(p2ValBad);
				
			}while(checkBigBoardWin(BigBoard)==0 && !checkFullGrid());
			
			//results
		}
		
		public static void runOnePlayer(){
			
			int x;  //Big Board
			int y;  //Little Board
			boolean p1ValBad = true;  // ends the x loop
			boolean p2ValBad = true;  // ends the y loop
			//Initial moves
		
			do{
				System.out.println("What x");
				x = kb.nextInt();
				if(x<=8 && x>=0){
					p1ValBad = false;
				}
				else{
					System.out.println("Invalid move. Please try again.");
					p1ValBad = true;
				}
			}while(p1ValBad);
			do{
				System.out.println("What y");
				y = kb.nextInt();
				if(y<=8 && y>=0){
					p2ValBad = false;
					placeMark(Board[x],CharBoard[x],y,1);
					x = y;
					printGrid(CharBoard);
				}
				else{
					System.out.println("Invalid move. Please try again.");
					p2ValBad = true;
				}	
			}while(p2ValBad);
			
			//Subsequent moves
			do{ //end game
				p1ValBad = true;
				p2ValBad = true;
				
				do{ // move is valid
					if (BigBoard[x]!=0 || checkFullGridSmall(Board[x])){
						do{
							System.out.println("What x");
							x = doubleMinMaxAIMoveChoice();
							if(x<=8 && x>=0){
								p1ValBad = false;
							}
							else{
								p1ValBad = true;
							}
						}while(p1ValBad);
					}
					y = minMaxAIMoveChoice(x);
					if(y<=8 && y>=0 && checkValidMove(Board[x],y)){
						p1ValBad = false;
						placeMark(Board[x],CharBoard[x],y,2);
						checkWin(Board[x],x);
						x=y;
						printGrid(CharBoard);
					}
					else{
						System.out.println("Invalid move. Please try again.");
						p1ValBad = true;
					}
				}while(p1ValBad);
				
			
				do { //move is valid
					if (BigBoard[x]!=0 || checkFullGridSmall(Board[x])){
						do{
							System.out.println("What x");
							x = kb.nextInt();
							if(x<=8 && x>=0){
								p2ValBad = false;
							}
							else{
								System.out.println("Invalid move. Please try again.");
								p2ValBad = true;
							}
						}while(p2ValBad);
					}
					System.out.println("(player 1) What y");
					y = kb.nextInt();
					if(y<=8 && y>=0 && checkValidMove(Board[x],y)){
						p2ValBad = false;
						placeMark(Board[x],CharBoard[x],y,1);
						checkWin(Board[x],x);
						x=y;
						printGrid(CharBoard);
					}
					else{
						System.out.println("Invalid move. Please try again.");
						p2ValBad = true;
					}
				}while(p2ValBad);
				
			}while(checkBigBoardWin(BigBoard)==0 && !checkFullGrid());
			
			//results
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
		
		
		public static boolean checkFullGrid(){
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					if(Board[i][j]==0){
						return false;
					}
				}
			}
			return true;
		}
		
		
		public static boolean checkFullGridSmall(int D[]){
			for(int j = 0; j < 9; j++){
				if(D[j]==0){
					return false;
				}
			}
		return true;
		}
		
		
		public static int minMaxAIMoveChoice(int x){
			int [][] tempBoard = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
			copy(tempBoard,Board);
			int [] movetots = {0,0,0,0,0,0,0,0,0};
			
			for(int i = 0; i<9; i++){
				if(tempBoard[x][i] == 0){
					System.out.println("calculating");
					tempBoard[x][i] = 2;
					movetots[i] = runBoardPossibilities(tempBoard);
					tempBoard[x][i] = 0;
					System.out.println("calculating");
					
				}
			}
			for(int i=0; i<9; i++){
				if(BigBoard[i]!=0 || checkFullGridSmall(Board[i]))
					movetots[i] -= 1000;
			}
			int max = Integer.MIN_VALUE;
			int place = 0;
			for(int i = 0; i<9; i++){
				if(max<movetots[i] && tempBoard[x][i]==0){
					max = movetots[i];
					place = i;
				}
			}
			return place;
		}
		
		public static int runBoardPossibilities(int [][] temp){
			Random r = new Random();
			int total = 0;
			int winner = 0;
			int [][]temp2 = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
			for(int i = 0; i < 1000000;i++){
				copy(temp2,temp);
				for(int row = 0; row<temp2.length;row++){
					for(int col = 0; col<temp2[0].length;col++){
						if(temp2[row][col]==0){
							temp2[row][col] = r.nextInt(2)+1;
						}
					}
				}
				winner = checkFullBoardWinner(temp2);
				if(winner == 2){
					total+=4;
				}
				if(winner == 1){
					total--;
				}
			}
			return total;
		}
		public static int checkFullBoardWinner(int [][]board){
			int [] tbb =  {0,0,0,0,0,0,0,0,0};
			
			for(int i = 0; i<8; i++){
				tbb[i] = checkBigBoardWin(board[i]);
			}
			
			return checkBigBoardWin(tbb);
		}
		public static void copy(int [][] A1, int [][] A2){
			for(int i = 0;i<A1.length;i++){
				for(int j = 0;j<A1[0].length;j++){
					A1[i][j]=A2[i][j];
				}
			}
		}
		
		public static int doubleMinMaxAIMoveChoice(){
			int [][] tempBoard = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
			copy(tempBoard,Board);
			int [][] movetots = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};;
			
			for(int i = 0; i<9; i++){
				for(int j = 0; j<9; j++){
					if(tempBoard[i][j] == 0){
						tempBoard[i][j] = 2;
						movetots[i][j] = runBoardPossibilities(tempBoard);
						tempBoard[i][j] = 0;
						
					}
				}
			}
			
			int max = Integer.MIN_VALUE;
			int place = 0;
			for(int i = 0; i<9; i++){
				for(int j = 0; j<9; j++){
					if(max<movetots[i][j] && tempBoard[i][j] == 0){
					max = movetots[i][j];
					place = i;
					}
				}
			}
			return place;
		}
		
		
		public static void main(String[] args) {
			
			int choice;
			printGrid(CharBoard);
			System.out.println("What mode would you like to play? (0 for 2 player, 1 for person vs Ai, 2 for AI vs AI)");
			choice = kb.nextInt();
			
			if(choice == 0){
				runTwoPlayer();
			}
			if(choice == 1){
				runOnePlayer();
			}
		}
	}
