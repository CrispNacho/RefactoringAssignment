package DataProcessing;
import java.util.Arrays;
import java.util.ArrayList;
public class ReadStudentResponseOrStudentData extends ReadData{
    /**
   * *Adds the content line divides based off of the comma
   * *@param contentLine is the data that will be divided based off of the comma
   * */
    public void addContentLine(String contentLine){
        //Divides based off of the coma
        String regex = ",";
        ArrayList<String> contentRow = new ArrayList<String>(Arrays.asList(contentLine.split(regex)));
        data.add(contentRow);
    }

    //Removes the header by removing the first index
    public void removeHeader(){
        data.remove(0);
    }

    /**
   * *Reads the student response or student data
   * *@param contentLine is the data that will be read
   * */
    public ReadStudentResponseOrStudentData(String fileName){
        super(fileName);
    }
}