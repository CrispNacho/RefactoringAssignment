import javax.swing.RepaintManager;

import DataProcessing.ReadQuestionAndAnswerData;
import DataProcessing.ReadStudentResponseOrStudentData;
import DataProcessing.CleanData;
import DataProcessing.CompareData;
import DataProcessing.SolveData;
import java.util.ArrayList;

class BridgeRefactoring {
    public static void main(String[] args) {
        System.out.println("hillo");
        ReadStudentResponseOrStudentData studentInfo = new ReadStudentResponseOrStudentData("Data/student_data/student_data_2.csv");
        ReadStudentResponseOrStudentData response = new ReadStudentResponseOrStudentData("Data/response_data/student_data_2_q1_response.csv");
        ReadQuestionAndAnswerData answers = new ReadQuestionAndAnswerData("Data/answer_data/sample_a_2.txt");
        ReadQuestionAndAnswerData questions = new ReadQuestionAndAnswerData("Data/question_data/sample_q_2.txt");
        studentInfo.StoreData();     
        response.StoreData();
        answers.StoreData();
        questions.StoreData();
        response.removeHeader();
        studentInfo.removeHeader();
        
        //CompareData comparer = new CompareData(answers.getArray(), response.getArray(), studentInfo.getArray());
        //System.out.println(comparer.generateScoreList());

        SolveData solver = new SolveData();
        ArrayList<ArrayList<String>> list = questions.getArray();
        solver.setEquations(list.get(0));
        solver.createNewMatrix();
    }
}

