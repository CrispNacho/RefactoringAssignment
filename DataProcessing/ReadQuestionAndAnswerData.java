package DataProcessing;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadQuestionAndAnswerData extends ReadData{
    private int questionCount = -1;
    protected void addContentLine(String contentLine){
        if(!contentLine.isEmpty()){
            if(contentLine.contains("=") || contentLine.contains("/")){
                data.get(questionCount).add(cleanData(contentLine));

            }
            else{
                data.add(new ArrayList<>());
                questionCount++;
                
            }
        }   
    }
    private String cleanData(String text) {
        return text.replaceAll("\\s+","").toLowerCase();
    }
    public ReadQuestionAndAnswerData(String fileName){
        super(fileName);
    
}
}



