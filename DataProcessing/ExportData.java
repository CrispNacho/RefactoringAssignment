package DataProcessing;
import java.io.File;
import java.io.Writer;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class ExportData {

   /**
   * *Takes the score ArrayList anf prints it in a seperate file
   * *@param scoreArrayList is an ArrayList that has score data to be written to a file
   * *@param fileName is the name of the file that is desired to be written to
   * *@param heading is the variable used for the for loop that outputs to the file
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