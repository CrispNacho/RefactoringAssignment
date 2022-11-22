package Data;
import DataProcessing.ValidateFile;
import DataProcessing.ExportData;
import java.util.ArrayList;

abstract class Data {
    protected ValidateFile validater = new ValidateFile();
    protected ExportData exporter = new ExportData();
    protected ArrayList<ArrayList<String>> questionList;
    protected ArrayList<ArrayList<String>> answerList;

    protected String fileType;

    protected void getQuestionOrAnswer() {
        fileType = validater.responseValidation();
    }
}