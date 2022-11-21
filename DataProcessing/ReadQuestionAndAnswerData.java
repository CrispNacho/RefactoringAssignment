package DataProcessing;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadQuestionAndAnswerData extends ReadData{
    private ArrayList<String> contentRow = new ArrayList<String>();
    private int count = 0;
    protected void addContentLine(String contentLine){
        if (contentLine == null){
            data.add((ArrayList)contentRow.clone());
        }
        
        else if(!contentLine.isEmpty()){
            if(contentLine.contains("=") || contentLine.contains("/")){
                contentRow.add(contentLine);

            }
            else{
                
                if(count > 0){
                data.add((ArrayList)contentRow.clone());
                contentRow.clear();
                }
                count++;
                
            }
        }
        
    }
    public ReadQuestionAndAnswerData(String fileName){
        super(fileName);
    
}
public ArrayList<ArrayList<String>> getArray(){

    return data;
    
}
}



