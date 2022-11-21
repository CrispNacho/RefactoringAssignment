package DataProcessing;
import java.util.Scanner;
import java.io.File;


public class ValidateFile {
    public static void fileValidation(String userInput){
        File file = new File(userInput);
        if(file.exists()){
            return;
        }
        else{
            Scanner reader = new Scanner(System.in);
            File fileCheckAgain = new File(userInput);
            while(!fileCheckAgain.exists()){
                System.out.println("Try Again: ");
                userInput = reader.nextLine();
                fileCheckAgain = new File(userInput);
            }
            reader.close();
            return;
        }
    }
}