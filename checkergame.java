import java.util.Scanner;
public class checkergame {
	

		public static void main(String[] args) {
			Scanner input = new Scanner(System.in); 
	        

			
			char board[][] =  board();       
			         while ( true ) {
					  displayBoard(board); 
					  playerXmove(board);
					  displayBoard(board);

					  playerOmove(board);
					   }
		
	}   
		
		//===================================================================
		
		
		
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
		
		
		public static void playerXmove( char board[][]){
			Scanner input = new Scanner(System.in); 
			
		int	x , xRow , xColumn;	
		int moveXrow , moveXcolumn; 
		System.out.println("           [PlayeX's turn]");
		System.out.print("move X from ");
	    x = checkInput();
	    xColumn = x %10;
	    xRow = x / 10;
	    System.out.print("         to ");
	    x = checkInput();
	    moveXcolumn = x % 10;
	    moveXrow = x / 10;

//	     check x's queen move
	    if ( board[xRow][xColumn] == 'K') {
	    	
	    	checkXorKmove( board , xRow , xColumn , moveXrow , moveXcolumn , 'K' );
	    
	    }
	 // check X move 
	    else checkXorKmove( board , xRow , xColumn , moveXrow , moveXcolumn);
	   
			}
	   
		
		
		public static void playerOmove( char board[][]){	
		int	o, oRow , oColumn;	
		int moveOrow , moveOcolumn; 
		System.out.println("           [PlayerO's turn]");
		System.out.print("move O from ");
	    o = checkInput();
	    oColumn = o %10;
	    oRow = o / 10;
	    System.out.print("         to ");
	    o = checkInput();
	    moveOcolumn = o % 10;
	    moveOrow = o / 10;
	    
	       
	    
	    // check x's queen move
	    if ( board[oRow][oColumn] == 'Q') {
	    	
	  	checkOorQmove( board , oRow , oColumn , moveOrow , moveOcolumn , 'Q' );
	   }
	   // check O move 
	    else checkOorQmove( board , oRow , oColumn , moveOrow , moveOcolumn);
	    
	   
	   }
	   

		
		public static int checkInput() {
		Scanner input = new Scanner(System.in);
		String oString;
		boolean wrong;
	    int oOrx;
		do {
	    wrong = false;
	    oString = input.nextLine();
	    if ( oString.length() == 2 ) {
	    	for ( int x = 0 ; x < oString.length() ; x++) {
	    		if ( Character.isLetter(oString.charAt(x))) {
	    			wrong = true;
	    		}
	    	}
	    }
	    else if ( oString.length() > 2) {
	    	wrong = true;}
	    
	    if(wrong == true) {
	    	System.out.println("          |Input is invalid.|");
	        System.out.println("         |2 digits input only|");
	        System.out.println("         |Please enter agian!|");
	    }
	    } while(wrong);
		
		oOrx = Integer.parseInt(oString);
		return oOrx;
		}
		
		
		 public static void checkXorKmove(char[][] board, int xRow , int xColumn , int moveXrow , int moveXcolumn ) {
			 
			        if (board[xRow][xColumn] != 'X' || board[moveXrow][moveXcolumn] == 'X' || board[moveXrow][moveXcolumn] == 'O' ) {
				        System.out.println("         |Wrong X coordinate|\n         |Please enter again|\n"); 
				   	    playerXmove(board);}
				    // right
				    else if ( (xColumn + xRow) == ( moveXrow + moveXcolumn) &&  moveXrow+1 == xRow ) {
				        board[xRow][xColumn] = ' ';
				        board[moveXrow][moveXcolumn] = 'X';
				        if ( moveXrow == 0 ) 
					       {board[moveXrow][moveXcolumn] = 'K';}
				    return;}
				    //left
				    else if ((xColumn + xRow) == (moveXrow + moveXcolumn + 2) && moveXrow +1 == xRow) {
				    	board[xRow][xColumn] = ' ';
				        board[moveXrow][moveXcolumn] = 'X';
				        if ( moveXrow == 0 ) 
					       {board[moveXrow][moveXcolumn] = 'K';}
				     return;}
				    
				    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn) && ( moveXrow + 2 == xRow) 
				    		&& board[moveXrow+1][moveXcolumn-1] == 'O' ) {
				       	 board[moveXrow+1][moveXcolumn -1] = ' ';
				    	 board[moveXrow][moveXcolumn] = 'X';
				    	 board[xRow][xColumn] = ' ';
				    	 if ( moveXrow == 0 ) 
					       {board[moveXrow][moveXcolumn] = 'K';}
				    return;
				    }
				    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn + 4) &&  moveXrow  + 2 == xRow
				    	  && board[moveXrow+1][moveXcolumn+1] == 'O' ) {
				       	 board[moveXrow+1][moveXcolumn+1] = ' ';
				    	 board[moveXrow][moveXcolumn] = 'X';
				    	 board[xRow][xColumn] = ' ';
				    	 if ( moveXrow == 0 ) 
					       {board[moveXrow][moveXcolumn] = 'K';}
				    return;		    
				    }
				    else {System.out.println("           |Invalid Move.|\n         |Please enter again|\n");
				      playerXmove(board);}
			        
			      
		}
			       
		 public static void checkXorKmove(char[][] board, int xRow , int xColumn , int moveXrow , int moveXcolumn, char K ) {
			        if (board[xRow][xColumn] != 'K' || board[moveXrow][moveXcolumn] == 'X' || board[moveXrow][moveXcolumn] == 'O' ) {
				   	 System.out.println("         |Wrong X coordinate|\n         |Please enter again|\n"); 
				   	playerXmove(board);}
				    
				    // right
				    else if ( (xColumn + xRow) == ( moveXrow + moveXcolumn) &&  moveXrow+1 == xRow ) {
				        board[xRow][xColumn] = ' ';
				        board[moveXrow][moveXcolumn] = K;
				    return;}
				    //left
				    else if ((xColumn + xRow) == (moveXrow + moveXcolumn + 2) && moveXrow +1 == xRow) {
				    	board[xRow][xColumn] = ' ';
				        board[moveXrow][moveXcolumn] = K;
				     return;}
				    
				    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn) && ( moveXrow + 2 == xRow) 
				    		&& board[moveXrow+1][moveXcolumn-1] == 'O' ) {
				       	 board[moveXrow+1][moveXcolumn -1] = ' ';
				    	 board[moveXrow][moveXcolumn] = K;
				    	 board[xRow][xColumn] = ' ';
				    return;
				    }
				    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn + 4) &&  moveXrow  + 2 == xRow
				    	  && board[moveXrow+1][moveXcolumn+1] == 'O' ) {
				       	 board[moveXrow+1][moveXcolumn+1] = ' ';
				    	 board[moveXrow][moveXcolumn] = K;
				    	 board[xRow][xColumn] = ' ';
				    return;
				    }
				    else if ( (xColumn + xRow) == ( moveXrow + moveXcolumn) &&  moveXrow - 1 == xRow ) {
				         board[xRow][xColumn] = ' ';
				         board[moveXrow][moveXcolumn] = K; 
				    return;}
				    
				    else if ((xColumn + xRow) == (moveXrow + moveXcolumn - 2) && moveXrow - 1 == xRow) {
				    	 board[xRow][xColumn] = ' ';
				         board[moveXrow][moveXcolumn] = K;
				        
				    return;}
				    
				    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn) && moveXrow -2 == xRow
				    		&&  board[moveXrow-1][moveXcolumn+1] == 'O') {
				       	 board[moveXrow-1][moveXcolumn+1] = ' ';
				    	 board[moveXrow][moveXcolumn] = K;
				    	 board[xRow][xColumn] = ' ';
				    return;
				    }
				    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn - 4) && moveXrow -2 == xRow 
				    		&& ( board[moveXrow-1][moveXcolumn-1] == 'O'|| board[moveXrow-1][moveXcolumn-1] == 'Q') ) {
				       	 board[moveXrow-1][moveXcolumn-1] = ' ';
				    	 board[moveXrow][moveXcolumn] = K;
				    	 board[xRow][xColumn] = ' ';
				    return;
				    }
				    else {System.out.println("           |Invalid Move.|\n         |Please enter again|\n");
				    playerXmove(board);
				    }  
		    }
		
		 public static void checkOorQmove(char[][] board, int oRow , int oColumn , int moveOrow , int moveOcolumn ) {
			 
			 if(board[oRow][oColumn] != 'O' || board[moveOrow][moveOcolumn] == 'O' || board[moveOrow][moveOcolumn] == 'X' ) {
			    	
		   	     System.out.println("         |Wrong O coordinate|\n         |Please enter again|\n"); 
		    	 playerOmove(board);
		    	 }
		    else if ( (oColumn + oRow) == ( moveOrow + moveOcolumn) &&  moveOrow - 1 == oRow ) {
		         board[oRow][oColumn] = ' ';
		         board[moveOrow][moveOcolumn] = 'O'; 
		         if ( moveOrow == 7) 
		 		{ board[moveOrow][moveOcolumn] = 'Q'; }
		    return;}
		    
		    else if ((oColumn + oRow) == (moveOrow + moveOcolumn - 2) && moveOrow - 1 == oRow) {
		    	 board[oRow][oColumn] = ' ';
		         board[moveOrow][moveOcolumn] = 'O';
		         if ( moveOrow == 7) 
		 		{ board[moveOrow][moveOcolumn] = 'Q'; }
		    return;}
		    
		    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn) && moveOrow -2 == oRow
		    		&&  board[moveOrow-1][moveOcolumn+1] == 'X') {
		       	 board[moveOrow-1][moveOcolumn+1] = ' ';
		    	 board[moveOrow][moveOcolumn] = 'O';
		    	 board[oRow][oColumn] = ' ';
		    	 if ( moveOrow == 7) 
		 		{ board[moveOrow][moveOcolumn] = 'Q'; }
		    return;
		    }
		    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn - 4) && moveOrow -2 == oRow 
		    		&& board[moveOrow-1][moveOcolumn-1] == 'X') {
		       	 board[moveOrow-1][moveOcolumn-1] = ' ';
		    	 board[moveOrow][moveOcolumn] = 'O';
		    	 board[oRow][oColumn] = ' ';
		    	 if ( moveOrow == 7) 
		 		{ board[moveOrow][moveOcolumn] = 'Q'; }
		    return;
		    }
		   
		    else {System.out.println("           |Invalid Move.|\n         |Please enter again|\n");
		         playerOmove(board);}
			 
			
		
		 }
		
		 public static void checkOorQmove(char[][] board, int oRow , int oColumn , int moveOrow , int moveOcolumn , char Q) {
			 
			if(board[oRow][oColumn] != Q || board[moveOrow][moveOcolumn] == 'O' || board[moveOrow][moveOcolumn] == 'X' ) {
		   	     System.out.println("         |Wrong O coordinate|\n         |Please enter again|\n"); 
		    	 playerOmove(board );
		    	 }
		    else if ( (oColumn + oRow) == ( moveOrow + moveOcolumn) &&  moveOrow - 1 == oRow ) {
		         board[oRow][oColumn] = ' ';
		         board[moveOrow][moveOcolumn] = Q; 
		    return;}
		    
		    else if ((oColumn + oRow) == (moveOrow + moveOcolumn - 2) && moveOrow - 1 == oRow) {
		    	 board[oRow][oColumn] = ' ';
		         board[moveOrow][moveOcolumn] = Q;
		        
		    return;}
		    
		    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn) && moveOrow -2 == oRow
		    		&&  board[moveOrow-1][moveOcolumn+1] == 'X') {
		       	 board[moveOrow-1][moveOcolumn+1] = ' ';
		    	 board[moveOrow][moveOcolumn] = Q;
		    	 board[oRow][oColumn] = ' ';
		    return;
		    }
		    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn - 4) && moveOrow -2 == oRow 
		    		&& board[moveOrow-1][moveOcolumn-1] == 'X') {
		       	 board[moveOrow-1][moveOcolumn-1] = ' ';
		    	 board[moveOrow][moveOcolumn] = Q;
		    	 board[oRow][oColumn] = ' ';
		    return;
		    }
		    else if ( (oColumn + oRow) == ( moveOrow + moveOcolumn) &&  moveOrow + 1 == oRow ) {
		         board[oRow][oColumn] = ' ';
		         board[moveOrow][moveOcolumn] = Q; 
		    return;}
		    
		    else if ((oColumn + oRow) == (moveOrow + moveOcolumn - 2) && moveOrow + 1 == oRow) {
		    	 board[oRow][oColumn] = ' ';
		         board[moveOrow][moveOcolumn] = Q;
		        
		    return;}
		    
		    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn) && moveOrow +2 == oRow
		    		&&  board[moveOrow-1][moveOcolumn+1] == 'X') {
		       	 board[moveOrow-1][moveOcolumn+1] = ' ';
		    	 board[moveOrow][moveOcolumn] = Q;
		    	 board[oRow][oColumn] = ' ';
		    return;
		    }
		    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn - 4) && moveOrow +2 == oRow 
		    		&& ((board[moveOrow-1][moveOcolumn-1] == 'X') || (board[moveOrow-1][moveOcolumn-1] == 'K'))){
		       	 board[moveOrow-1][moveOcolumn-1] = ' ';
		    	 board[moveOrow][moveOcolumn] = Q;
		    	 board[oRow][oColumn] = ' ';
		    return;
		    }
		    else {System.out.println("           |Invalid Move.|\n         |Please enter again|\n");
		         playerOmove(board);}
		 }
	}

