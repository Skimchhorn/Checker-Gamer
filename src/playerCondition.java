import java.util.Scanner;

public class playerCondition {
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

//     check x's queen move
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
		      //jump over 0 or Q
			    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn) && ( moveXrow + 2 == xRow) 
			    		&& (board[moveXrow+1][moveXcolumn-1] == 'O' || board[moveXrow+1][moveXcolumn-1] == 'Q')) {
			       	 board[moveXrow+1][moveXcolumn -1] = ' ';
			    	 board[moveXrow][moveXcolumn] = 'X';
			    	 board[xRow][xColumn] = ' ';
			    	 if ( moveXrow == 0 ) 
				       {board[moveXrow][moveXcolumn] = 'K';}
			    return;
			    }
		        //jump over 0 or Q
			    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn + 4) &&  moveXrow  + 2 == xRow
			    	  && (board[moveXrow+1][moveXcolumn+1] == 'O' || board[moveXrow+1][moveXcolumn+1] == 'Q')) {
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
		        if (board[xRow][xColumn] != 'K' || board[moveXrow][moveXcolumn] == 'X' || board[moveXrow][moveXcolumn] == 'O'|| board[moveXrow][moveXcolumn] == 'Q') {
			   	 System.out.println("         |Wrong X coordinate|\n         |Please enter again|\n"); 
			   	playerXmove(board);}
			    
			    // up right
			    else if ( (xColumn + xRow) == ( moveXrow + moveXcolumn) &&  moveXrow+1 == xRow ) {
			        board[xRow][xColumn] = ' ';
			        board[moveXrow][moveXcolumn] = K;
			    return;}
			    // up left
			    else if ((xColumn + xRow) == (moveXrow + moveXcolumn + 2) && moveXrow +1 == xRow) {
			    	board[xRow][xColumn] = ' ';
			        board[moveXrow][moveXcolumn] = K;
			     return;}
			    // up 2 row and right
			    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn) && ( moveXrow + 2 == xRow) 
			    		&& (board[moveXrow+1][moveXcolumn-1] == 'O' || board[moveXrow-1][moveXcolumn-1] == 'Q')) {
			       	 board[moveXrow+1][moveXcolumn -1] = ' ';
			    	 board[moveXrow][moveXcolumn] = K;
			    	 board[xRow][xColumn] = ' ';
			    return;
			    }
		        // up 2 row and left
			    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn + 4) &&  moveXrow  + 2 == xRow
			    	  &&( board[moveXrow+1][moveXcolumn+1] == 'O'|| board[moveXrow-1][moveXcolumn-1] == 'Q')) {
			       	 board[moveXrow+1][moveXcolumn+1] = ' ';
			    	 board[moveXrow][moveXcolumn] = K;
			    	 board[xRow][xColumn] = ' ';
			    return;
			    }
		        // down 1 row and left
			    else if ( (xColumn + xRow) == ( moveXrow + moveXcolumn) &&  moveXrow - 1 == xRow ) {
			         board[xRow][xColumn] = ' ';
			         board[moveXrow][moveXcolumn] = K; 
			    return;}
		     // down 1 row and right
			    else if ((xColumn + xRow) == (moveXrow + moveXcolumn - 2) && moveXrow - 1 == xRow) {
			    	 board[xRow][xColumn] = ' ';
			         board[moveXrow][moveXcolumn] = K;
			        
			    return;}
		     // down 2 row and left
			    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn) && moveXrow -2 == xRow
			    		&&  (board[moveXrow-1][moveXcolumn+1] == 'O' || board[moveXrow-1][moveXcolumn+1] == 'Q')) {
			       	 board[moveXrow-1][moveXcolumn+1] = ' ';
			    	 board[moveXrow][moveXcolumn] = K;
			    	 board[xRow][xColumn] = ' ';
			    return;
			    }
		     // down 2 row and right
			    else if ((xColumn + xRow) == ( moveXrow + moveXcolumn - 4) && moveXrow -2 == xRow 
			    		&& (board[moveXrow-1][moveXcolumn-1] == 'O'|| board[moveXrow-1][moveXcolumn-1] == 'Q') ) {
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
		 // jump over X or K
	    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn) && moveOrow -2 == oRow
	    		&&  (board[moveOrow-1][moveOcolumn+1] == 'X'|| board[moveOrow-1][moveOcolumn+1] == 'K')) {
	       	 board[moveOrow-1][moveOcolumn+1] = ' ';
	    	 board[moveOrow][moveOcolumn] = 'O';
	    	 board[oRow][oColumn] = ' ';
	    	 if ( moveOrow == 7) 
	 		{ board[moveOrow][moveOcolumn] = 'Q'; }
	    return;
	    }
		 //jump over X or K
	    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn - 4) && moveOrow -2 == oRow 
	    		&& (board[moveOrow-1][moveOcolumn-1] == 'X'|| board[moveOrow-1][moveOcolumn-1] == 'K')) {
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
		 
		if(board[oRow][oColumn] != Q || board[moveOrow][moveOcolumn] == 'O' || board[moveOrow][moveOcolumn] == 'X' || board[moveOrow][moveOcolumn] == 'K')  {
	   	     System.out.println("         |Wrong O coordinate|\n         |Please enter again|\n"); 
	    	 playerOmove(board );
	    	 }
		// move down and left
	    else if ( (oColumn + oRow) == ( moveOrow + moveOcolumn) &&  moveOrow - 1 == oRow ) {
	         board[oRow][oColumn] = ' ';
	         board[moveOrow][moveOcolumn] = Q; 
	    return;}
	    // move down and right
	    else if ((oColumn + oRow) == (moveOrow + moveOcolumn - 2) && moveOrow - 1 == oRow) {
	    	 board[oRow][oColumn] = ' ';
	         board[moveOrow][moveOcolumn] = Q;
	        
	    return;}
	    // move down 2 row and left
	    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn) && moveOrow -2 == oRow
	    		&& ( board[moveOrow-1][moveOcolumn+1] == 'X' || board[moveOrow-1][moveOcolumn+1] == 'K')) {
	       	 board[moveOrow-1][moveOcolumn+1] = ' ';
	    	 board[moveOrow][moveOcolumn] = Q;
	    	 board[oRow][oColumn] = ' ';
	    return;
	   } 
		//move down 2 row and right
	    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn - 4) && moveOrow -2 == oRow 
	    		&& (board[moveOrow-1][moveOcolumn-1] == 'X' || (board[moveOrow-1][moveOcolumn-1] == 'K'))) {
	       	 board[moveOrow-1][moveOcolumn-1] = ' ';
	    	 board[moveOrow][moveOcolumn] = Q;
	    	 board[oRow][oColumn] = ' ';
	    return;
	    }
		// move up 1 row and right
	    else if ( (oColumn + oRow) == ( moveOrow + moveOcolumn) &&  moveOrow + 1 == oRow ) {
	         board[oRow][oColumn] = ' ';
	         board[moveOrow][moveOcolumn] = Q; 
	    return;}
	   // move up 1 row and left
	    else if ((oColumn + oRow) == (moveOrow + moveOcolumn - 2) && moveOrow + 1 == oRow) {
	    	 board[oRow][oColumn] = ' ';
	         board[moveOrow][moveOcolumn] = Q;
	        
	    return;}
	    //move up 2 row and right
	    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn) && moveOrow +2 == oRow
	    		&& (board[moveOrow+1][moveOcolumn-1] == 'X'|| (board[moveOrow+1][moveOcolumn-1] == 'K'))) {
	       	 board[moveOrow+1][moveOcolumn-1] = ' ';
	    	 board[moveOrow][moveOcolumn] = Q;
	    	 board[oRow][oColumn] = ' ';
	    return;
	    }
		// move up 2 row and left
	    else if ((oColumn + oRow) == ( moveOrow + moveOcolumn + 4) && moveOrow +2 == oRow 
	    		&& ((board[moveOrow+1][moveOcolumn+1] == 'X') || (board[moveOrow-1][moveOcolumn-1] == 'K'))){
	       	 board[moveOrow+1][moveOcolumn+1] = ' ';
	    	 board[moveOrow][moveOcolumn] = Q;
	    	 board[oRow][oColumn] = ' ';
	    return;
	    }
	    else {System.out.println("           |Invalid Move.|\n         |Please enter again|\n");
	         playerOmove(board);}
	 }
	 
		public static boolean checkXwinner(char board[][]) {
			// set X is a winner as a default
		 boolean Xwinner = true;
		 int row;
		 for( row = 0 ; row < board.length ; row++) {
			 for( int column = 0 ; column < board[row].length ; column++) {
				 // if there has O on board , X is  not a winner.
				 if(board[row][column] == 'O') {
					 // check from row 0 to row 5
					 if(row <= 5) {
						// check if O in column 7, cannot check something on the 1 row right ahead, it will out of bounds.
						    if ( column != 7) {
							  //right and row 1 ahead
						       if(board[row+1][column+1] ==' ' ) {
					            Xwinner = false; } }
						// check if O in column 7 and 6, cannot check something on the 2 row right head , it will out of bounds.
						    if ( column != 6 && column != 7) {
							 //right and row 2 ahead
					       	    if(board[row+2][column+2] ==' ' ) {
            		 	        Xwinner = false; } }
						  //avoid out of bound
						    if ( column != 0 ) {
							 //left and row 1 ahead
						         if(board[row+1][column-1] ==' ') {
         			          Xwinner = false; } }
						  //avoid out of bound
						    if (column != 1 && column !=0) {
							 //left and row 2 ahead
						          if(board[row+2][column-2] ==' ') {
         			        Xwinner = false; } } 
						  }
					 // check row 6
					 else if( row == 6) {
						 //avoid out of bound
						   if ( column != 7) {
							  //right and row 1 ahead
						         if(board[row+1][column+1] ==' ' ) {
					                 Xwinner = false; } }
						  //avoid out of bound
						  if ( column != 0 ) {
								 //left and row 1 ahead
						     	 if(board[row+1][column-1] ==' ') {
	         			              Xwinner = false; } }
						        }
				             }
				// if there has Queen on board , X is  not a winner.
				 // easy to understand , Queen can move backward or forward so just combine X(forward)and O(backward) checking program to check Queen.
				 else if ( board[row][column] == 'Q' ) {
					 if(row >= 2) {
						    if ( column != 7) {
							  //right and row 1 ahead
						         if(board[row-1][column+1] ==' ') {
					                   Xwinner = false; }}
						  
						    if ( column != 6 && column != 7) {
							 //right and row 2 ahead
						         if(board[row-2][column+2] ==' ') {
		 			                  Xwinner = false; }}
						    
						    if (  column != 0 ) {
						 	 //left and row 1 ahead
						         if(board[row-1][column-1] ==' ' ) {
					                  Xwinner = false; }}
						  
						    if (column != 1 && column !=0) {
							 //left and row 2 ahead
						          if(board[row-2][column-2] ==' '	) {
					                   Xwinner = false; } } }
					 // check row 1
					 else if( row == 1) {
						     if ( column != 7) {
							  //right and row 1 ahead
						          if(board[row-1][column+1] ==' ' ) {
					                  Xwinner = false; }}
						     if ( column != 0 ) {
								 //left and row 1 ahead
							      if(board[row-1][column-1] ==' ') {
		  			                  Xwinner = false; }}
						        }
					 // check from row 0 to row 5
					 if(row <= 5) { 
						  // check if K in column 7, cannot check something on the right, it will out of bounds.
						     if ( column != 7) {
							  //right and row 1 ahead
						          if(board[row+1][column+1] ==' ' ) {
					                   Xwinner = false; } }
						  // check if K in column 7 and 6, cannot check something on the 2 row right head , it will out of bounds.
						     if ( column != 6 && column != 7) {
							 //right and row 2 ahead
						           if(board[row+2][column+2] ==' ') {
           			                     Xwinner = false; } }
						// check if K in column 0, cannot check something on the left , it will out of bounds.
						    if ( column != 0 ) {
							 //left and row 1 ahead
						           if(board[row+1][column-1] ==' '   ) {
        			                     Xwinner = false; } }
						// check if K in column 0 and 1 , cannot check something on the 2 row left ahead, it will out of bounds.
						    if (column != 1 && column !=0) {
							 //left and row 2 ahead
						           if(board[row+2][column-2] ==' ' ) {
        			                     Xwinner = false; } } 
						  }
					 // check row 6 because row 6 check only 1 row ahead.
					 else if( row == 6) {
						  
						  if ( column != 7) {
							  //right and row 1 ahead
						         if((board[row+1][column+1] ==' ' ) ) {
					                    Xwinner = false; } }
						  if ( column != 0 ) {
							  //left and row 1 ahead
							     if(board[row+1][column-1] ==' ' ) {
	         			                Xwinner = false; } }
						        }
				            }  
				  }}
		  
		 return Xwinner;
		}
		
		public static boolean checkOwinner(char board[][]) {
			boolean Owinner = true;
			 int row;
			 for( row = 0 ; row < board.length ; row++) {
				 for( int column = 0 ; column < board[row].length ; column++) {
					 // if there has X on board , O is  not a winner.
					 if(board[row][column] == 'X') {
						// check from row 2 to row 7
						  if(row >= 2) {
							      //avoid out of bound
								if ( column != 7) {
									  //right and row 1 ahead
								     if(board[row-1][column+1] ==' ') {
							             Owinner = false; }}
								  //avoid out of bound
							    if ( column != 6 && column != 7) {
									 //right and row 2 ahead
								      if(board[row-2][column+2] ==' ') {
				 			              Owinner = false; }}
								  //avoid out of bound
								if (  column != 0 ) {
									 //left and row 1 ahead
								      if(board[row-1][column-1] ==' ') {
							               Owinner = false; }}
								  //avoid out of bound
								if (column != 1 && column !=0) {
									 //left and row 2 ahead
								      if(board[row-2][column-2] ==' ' ) {
							              Owinner = false; } } }
							 // check row 1
						 else if( row == 1) {
								 //avoid out of bound 
								 if ( column != 7) {
									  //right and row 1 ahead
								      if(board[row-1][column+1] ==' ' ) {
							                Owinner = false; }}
								  //avoid out of bound
								 if ( column != 0 ) {
										 //left and row 1 ahead
								      if(board[row-1][column-1] ==' ') {
				  			                Owinner = false; }}
								        }
					             }
					// if there has Queen on board , O is  not a winner.
					 // easy to understand , Queen can move backward or forward so just combine X(forward)and O(backward) checking program to check Queen.
					   if ( board[row][column] == 'K' ) {
						// check from row 2 to row 7 because it can be out of bound if X is row 1 or 0
						    if(row >= 2) {
							      if ( column != 7) {
								  //right and row 1 ahead
							           if(board[row-1][column+1] ==' ') {
						                      Owinner = false; }}
							  
							     if ( column != 6 && column != 7) {
								 //right and row 2 ahead
							           if(board[row-2][column+2] ==' ') {
			 			                       Owinner = false; }}
							  
							     if (  column != 0 ) {
								 //left and row 1 ahead
							            if(board[row-1][column-1] ==' ') {
						                       Owinner = false; }}
							  
							    if (column != 1 && column !=0) {
								 //left and row 2 ahead
							           if(board[row-2][column-2] ==' ') {
						                       Owinner = false; } } }
						 // check row 1
						   else if( row == 1) {
							      if ( column != 7) {
								  //right and row 1 ahead
							           if(board[row-1][column+1] ==' ') {
						                      Owinner = false; }}
							      if ( column != 0 ) {
									 //left and row 1 ahead
								        if(board[row-1][column-1] ==' ') {
			  			                      Owinner = false; }}
							        }
						 // check from row 0 to row 5
						   if(row <= 5) { 
							  // check if K in column 7, cannot check something on the right, it will out of bounds.
							       if ( column != 7) {
								  //right and row 1 ahead
							           if(board[row+1][column+1] ==' '  ) {
						                     Owinner = false; } }
							  // check if K in column 7 and 6, cannot check something on the 2 row right head , it will out of bounds.
							       if ( column != 6 && column != 7) {
								 //right and row 2 ahead
							           if(board[row+2][column+2] ==' ') {
	            			                 Owinner = false; } }
							// check if K in column 0, cannot check something on the left , it will out of bounds.
							      if ( column != 0 ) {
								 //left and row 1 ahead
							           if(board[row+1][column-1] ==' ' ) {
	         			                     Owinner = false; } }
							// check if K in column 0 and 1 , cannot check something on the 2 row left ahead, it will out of bounds.
							      if (column != 1 && column !=0) {
								 //left and row 2 ahead
							            if(board[row+2][column-2] ==' ') {
	         			                      Owinner = false; } } 
							  }
						 // check row 6 because row 6 check only 1 row ahead.
						  else if( row == 6) {
							  
							       if ( column != 7) {
								  //right and row 1 ahead
							              if((board[row+1][column+1] ==' ' ) ) {
						                       Owinner = false; } }
						      	  if ( column != 0 ) {
								  //left and row 1 ahead
							         	 if(board[row+1][column-1] ==' ') {
		         			                   Owinner = false; } }
							        }
					 }}}
			
			return Owinner ;
		}
}
