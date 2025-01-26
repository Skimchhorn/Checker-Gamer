import java.util.Scanner;
import java.time.format.*;
import java.time.*;
public class checkergame {
	   
	 String record = "";
		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in); 
	        LocalDateTime date = LocalDateTime.now();
	        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String playerWinDate = date.format(formatDate);
            String record = "";
            int opt;
            
			do {
				System.out.printf( "%10s\n","[MENU]");
				System.out.println("1. Start Game");
				System.out.println("2. Rule of Checker Game");
				System.out.println("3. List of All Last Match Player ");
				System.out.println("4. exit");
				System.out.print("Enter a number of option: ");	
				 opt = input.nextInt();
				 input.nextLine();
				 if (opt == 1) {
					 
						System.out.print("Enter playerX's name: ");	
						String playerXname = input.nextLine();
						System.out.print("Enter playerO's name: ");	
						String playerOname = input.nextLine();
						
							char board[][] =  board();       
							         while ( true ) {
									  displayBoard(board); 
									  playerCondition.playerXmove(board);
									  if(playerCondition.checkXwinner(board)) {
										  record = playerXname + " won " + playerOname + " on " + playerWinDate + ".";
										  System.out.println(record);
										  filehandler.writeRecord(record);
										  break;
									  }
									  displayBoard(board);
									  playerCondition.playerOmove(board);
									  if(playerCondition.checkOwinner(board)) {
										  record = playerOname + "won" + playerXname + "on " + playerWinDate + ".";
										  System.out.println(record);
										  filehandler.writeRecord(record);
										  break;
									  }
									  
									   }
				 }
				 else if (opt == 2) {
					System.out.println("Checkers game rules");
					System.out.println("1.The format of the coordinate for inputting to the program is RowColoum.\n  For example, 12 is equivalent to row 1 and column 2. Note: Do not make a space betwees these two intergers.");
					System.out.println("2.A player X and O can only move diagonally upwards but just one step.\n  This move is only applicable if the destination is empty.");
					System.out.println("3.A player can eliminate another player only if that player is exactly diagonally next to that another player and the next diagonal place to opponent which is that another player is vacant.");
				    System.out.println("  In short, jump over that piece and eliminate that piece.");
					System.out.println("4.A player can only move one step diagonally.");
					System.out.println("5.A players X or O becomes queen if it reaches the other side.");
					System.out.println("6.queen pieces can move in both directions, forward and backward. \n  Note: the symbol of queen of X is K and the symbol of queen of O is Q.");
					System.out.println("7.You win the game when the opponent has no more pieces or can't move (even if he/she still has pieces). \n  If neither player can move then it is a draw or a tie.");
					System.out.println();		
				
				 }
				 else if (opt == 3) {
						System.out.println();
						filehandler.readRecord();
						System.out.println();
				 }
				 
			}while(opt != 4);
			System.out.print("play me please!");	
            

		
	}   
		
		

		public static void displayBoard( char board[][] ) {
			System.out.println("    0   1   2   3   4   5   6   7 ");	
			
		 for(int x = 0 ; x < board.length ; x++) {
			 System.out.println("  --------------------------------- ");
			 System.out.print(x + " ");
	    	 for( int y = 0 ; y <  board[x].length; y++) {
	    		 System.out.print( "| " + board[x][y] + " ");
	     }
	    System.out.println("|");
	     }
		 System.out.println("  --------------------------------- ");
		}
		
		
		public static char[][] board(){
			char board[][] = {
					{' ','O',' ','O',' ','O',' ','O'},
					{'O',' ','O',' ','O',' ','O',' '},
					{' ','O',' ','O',' ','O',' ','O'},
					{' ',' ',' ',' ',' ',' ',' ',' '},
					{' ',' ',' ',' ',' ',' ',' ',' '},
					{'X',' ','X',' ','X',' ','X',' '},
					{' ','X',' ','X',' ','X',' ','X'},
					{'X',' ','X',' ','X',' ','X',' '}
			};
			return board;
		}
		
		
	
		
	
}


