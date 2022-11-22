package DataProcessing;
import java.util.ArrayList;

public class ReadQuestionAndAnswerData extends ReadData{
    private int questionCount = -1;

    /**
   * *Used for adding the content line
   * *@param contentLine is the term used to decribe the data
   * */
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

    /**
   * *Used for reading and answering the data
   * *@param fileName is the name of the file
   * */
    public ReadQuestionAndAnswerData(String fileName){
        super(fileName);
    }
}