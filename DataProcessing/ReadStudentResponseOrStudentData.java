package DataProcessing;
import java.util.Arrays;
import java.util.ArrayList;
public class ReadStudentResponseOrStudentData extends ReadData{
    public void addContentLine(String contentLine){
        String regex = ",";
        ArrayList<String> contentRow = new ArrayList<String>(Arrays.asList(contentLine.split(regex)));
        data.add(contentRow);
    }
    public void removeHeader(){
        data.remove(0);
    }
    public ReadStudentResponseOrStudentData(String fileName){
        super(fileName);
    }
}

