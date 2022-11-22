package DataProcessing;
import java.util.Scanner;
import java.io.File;


public class ValidateFile {
    Scanner reader = new Scanner(System.in);
    
    /**
   * *Validates the user input of the file and is repeatedly asked until the file is valid
   * *@param question the question that is asked to the user
   * */
    public String fileValidation(String question){
        System.out.println(question);
        String userInput = reader.nextLine();

        File fileChecker = new File(userInput);
        while(!fileChecker.exists()){
            System.out.println("Try Again: ");
            userInput = reader.nextLine();
            fileChecker = new File(userInput);
        }

        return userInput;
    }

    public String responseValidation() {
        System.out.println("Do you want to get question or answer (Q/A)?: ");
        String userInput = reader.nextLine();

        while (!userInput.toLowerCase().equals("q") && !userInput.toLowerCase().equals("a")) {
            System.out.println("Try Again...");
            userInput = reader.nextLine();
        }

        return userInput;
    }
}