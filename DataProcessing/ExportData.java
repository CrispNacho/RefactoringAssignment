package DataProcessing;
import java.io.File;
import java.io.Writer;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class ExportData {

   /**
   * *Takes the score array where the student data is with the score and prints the array in a seperate file
   * *@param scoreArray is a two dimentional array that has student data but, with the student scores (adding the student score to the end of the array)
   * */
    public void writingToScoreFile(ArrayList<ArrayList<String>> scoreArrayList, String fileName, String heading) {
		//Establishes the file name
		File file = new File(fileName);
		try{
			FileWriter fw = new FileWriter(file);
			Writer output = new BufferedWriter(fw);
			int size = scoreArrayList.size();
			
			output.write(heading);
			for(int i = 0; i < size; i++){
				for (int j = 0; j < scoreArrayList.get(i).size(); j++) {
					output.write(scoreArrayList.get(i).get(j) + ",");
				}
				output.write("\n");  
			}
			output.close();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error. Unable To Create That File. Try Again!");
		}
	}
}