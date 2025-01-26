import java.io.*;
import java.io.File;
import java.util.Scanner;
public class filehandler {


	
	public static void writeRecord (String record)  {
		final String FILENAME = "./src/playerRecord.csv";
		PrintWriter print = null;
		try {
			FileWriter eachPlayerRecord = new FileWriter(FILENAME, true);
			print = new PrintWriter(eachPlayerRecord);
			print.printf("%-40s\n" , record);
			
			print.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void readRecord () {
		final String FILENAME = "./src/playerRecord.csv";
		File playerRecord = new File(FILENAME);
		String eachRecord;
		int num = 0;
		System.out.println("List of All Last Matches");
		
		try {
			Scanner input = new Scanner(playerRecord);
			
			while(input.hasNext()) {
				num++;
				eachRecord = input.nextLine();

				System.out.printf("%2d. %-40s\n",num, eachRecord);
			}
		

			input.close();
			
		}catch(Exception u) {
			System.out.println(u.getMessage());
		}
		
	}  
	
}
