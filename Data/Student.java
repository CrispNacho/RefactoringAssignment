package Data;
import DataProcessing.CompareData;
import DataProcessing.ExportData;
import DataProcessing.ReadStudentResponseOrStudentData;
import java.util.ArrayList;

public class Student extends Data{
    private String studentFilePath;
    private ArrayList<ArrayList<String>> studentInfoList;
    private String responseFilePath;
    private ArrayList<ArrayList<String>> studentResponseList;

    public Student() {
        getStudentInfo();

        getQuestionOrAnswer();   
    }

    public void checkAnswer() {
        if (fileType.equals("a")) {
            checkStudentResponse();
        }
    }

    private void getStudentInfo() {
        studentFilePath = validater.fileValidation("Please enter the file path to the student file: ");

        ReadStudentResponseOrStudentData studentInfo = new ReadStudentResponseOrStudentData(studentFilePath);
        studentInfo.storeData();
        studentInfo.removeHeader();
        studentInfoList = studentInfo.getArray();
    }

    private void checkStudentResponse() {
        responseFilePath = validater.fileValidation("Please enter the file path to the student response file: ");

        ReadStudentResponseOrStudentData responseData = new ReadStudentResponseOrStudentData(responseFilePath);
        responseData.storeData();
        responseData.removeHeader();
        studentResponseList = responseData.getArray();
        
        compareResponses();
    }

    private void compareResponses() {
        CompareData comparer = new CompareData(answerList, studentResponseList, studentInfoList);
        ArrayList<ArrayList<String>> scoreList = comparer.generateScoreList();

        exporter.writingToScoreFile(scoreList, "score.csv", "Student Number,First Name,Last Name,Email,Score\n");
    }
}
