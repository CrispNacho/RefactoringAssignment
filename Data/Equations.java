package Data;

import DataProcessing.ReadQuestionAndAnswerData;
import DataProcessing.SolveData;
import java.util.ArrayList;

public class Equations extends Data{
    private String answerFilePath;
    private String questionFilePath;

    public Equations() {
        if (fileType.equals("q")) {
            getQuestions();
        }
        if (fileType.equals("a")) {
            getAnswers();
        }     
    }

    private void getQuestions() {
        questionFilePath = validater.fileValidation("Please enter the file path to the question file: ");
        ReadQuestionAndAnswerData questionData = new ReadQuestionAndAnswerData(questionFilePath);
        questionData.storeData();

        questionList = questionData.getArray();

        SolveData solver = new SolveData();
        ArrayList<ArrayList<String>> solutionList = new ArrayList<ArrayList<String>>();

        for (ArrayList<String> list: questionList) {
            
        }
        
    }

    private void getAnswers() {
        answerFilePath = validater.fileValidation("Please enter the file path to the answer file: ");
        ReadQuestionAndAnswerData answerData = new ReadQuestionAndAnswerData(answerFilePath);
        answerData.storeData();   

        answerList = answerData.getArray();
     }
}
