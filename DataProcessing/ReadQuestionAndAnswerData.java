package DataProcessing;
import java.util.ArrayList;

public class ReadQuestionAndAnswerData extends ReadData{
    private int questionCount = -1;

    /**
   * * Determines if the content line is a equation line or
   * the start of a new question or answer and adds it in if its an equation
   * *@param contentLine the content of each line
   * */
    protected void addContentLine(String contentLine){
        contentLine = contentLine.toLowerCase();
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

    //Constructor Method
    public ReadQuestionAndAnswerData(String fileName){
        super(fileName);
    }
}