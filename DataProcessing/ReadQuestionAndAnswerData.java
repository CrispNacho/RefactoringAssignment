package DataProcessing;
import java.util.ArrayList;

public class ReadQuestionAndAnswerData extends ReadData{
    ArrayList<String> contentRow = new ArrayList<String>();
    public void addContentLine(String contentLine){

        if(!contentLine.isEmpty()){
        if(Character.isLetter(contentLine.charAt(0)) && Character.isDigit(contentLine.charAt(1))){
            if(Character.toLowerCase(contentLine.charAt(0)) == 'q' || Character.toLowerCase(contentLine.charAt(0)) == 'a'){

            data.add(contentRow);
            contentRow.clear();
        }else {
            contentRow.add(contentLine);
        } 
            
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



