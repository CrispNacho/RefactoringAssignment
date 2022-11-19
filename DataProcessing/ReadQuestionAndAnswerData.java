package DataProcessing;
import java.util.ArrayList;

public class ReadQuestionAndAnswerData extends ReadData{
    ArrayList<String> contentRow = new ArrayList<String>();
    public void addContentLine(String contentLine){
        if(!contentLine.isEmpty()){
        if(Character.isLetter(contentLine.charAt(0)) && Character.isDigit(contentLine.charAt(1))){
            data.add(contentRow);
            contentRow.clear();
            
        }
        else{
            contentRow.add(contentLine);
        }
    }
    }
    public ReadQuestionAndAnswerData(String fileName){
        super(fileName);
    
}
}



