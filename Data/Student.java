package Data;
import DataProcessing.CompareData;
import DataProcessing.ExportData;
import DataProcessing.ValidateFile;
import DataProcessing.ReadStudentResponseOrStudentData;
import DataProcessing.ReadQuestionAndAnswerData;
import DataProcessing.SolveData;
import java.util.ArrayList;

public class Student {
    protected ValidateFile validater = new ValidateFile();
    protected ExportData exporter = new ExportData();
    private String studentFilePath;
    private ArrayList<ArrayList<String>> studentInfoList;
    private String responseFilePath;
    private ArrayList<ArrayList<String>> studentResponseList;

    private String answerFilePath;
    private String questionFilePath;
    protected ArrayList<ArrayList<String>> questionList;
    protected ArrayList<ArrayList<String>> answerList;

    private String fileType;

    public Student() {
        getStudentInfo();

        getQuestionOrAnswer();

        if (fileType.equals("q")) {
            getQuestions();
            solveQuestion();
        }
        if (fileType.equals("a")) {
            getAnswers();
            checkStudentResponse();
        } 
    }

    public void getQuestionOrAnswer() {
        fileType = validater.responseValidation();
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

    private void getQuestions() {
        questionFilePath = validater.fileValidation("Please enter the file path to the question file: ");
        ReadQuestionAndAnswerData questionData = new ReadQuestionAndAnswerData(questionFilePath);
        questionData.storeData();

        questionList = questionData.getArray();
    }

    private void solveQuestion() {
        SolveData solver = new SolveData();
        ArrayList<ArrayList<String>> solutionList = new ArrayList<ArrayList<String>>();

        for (ArrayList<String> equation: questionList) {
            solver.setEquations(equation);
            solutionList.add(solver.createSolutionList());
        } 

        exporter.writingToScoreFile(solutionList, "solutions.csv", "");
    }

    private void getAnswers() {
        answerFilePath = validater.fileValidation("Please enter the file path to the answer file: ");
        ReadQuestionAndAnswerData answerData = new ReadQuestionAndAnswerData(answerFilePath);
        answerData.storeData();   

        answerList = answerData.getArray();
     }
}
