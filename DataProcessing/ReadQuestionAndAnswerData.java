package DataProcessing;
import java.util.ArrayList;

public class ReadQuestionAndAnswerData extends ReadData{
    private int questionCount = -1;
    protected void addContentLine(String contentLine){
        if(!contentLine.isEmpty()){
            if(contentLine.contains("=") || contentLine.contains("/")){
                data.get(questionCount).add(contentLine);

            }
            else{
                data.add(new ArrayList<>());
                questionCount++;
                
            }
        }   
    }
    public ReadQuestionAndAnswerData(String fileName){
        super(fileName);
    
}
}


