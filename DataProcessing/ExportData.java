package DataProcessing;
import java.io.IOException;
import java.io.File;
import java.io.Writer;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class ExportData {

   /**
   * *Prints the 2D array with the student data and student scores to a seperate file
   * *@param scoreArray is a two dimentional array that has student data but, with the student scores (adding the student score to the end of the array)
   * */
	//Takes the score array where the student data is with the score and prints the array in a seperate file
    public static void writingToScoreFile(ArrayList<ArrayList<String>> scoreArrayList) throws IOException{
		//Establishes the file name
		File file = new File("score.txt");
		try{
			FileWriter fw = new FileWriter(file);
			Writer output = new BufferedWriter(fw);
			int size = scoreArrayList.size();  
			for(int i = 0; i < size; i++){
				output.write(scoreArrayList.get(i).toString() + "\n");  
			}
			output.close();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error. Unable To Create That File. Try Again!");
		}
	}
}