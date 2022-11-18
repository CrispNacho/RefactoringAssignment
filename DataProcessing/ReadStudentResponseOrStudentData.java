package DataProcessing;

public class ReadStudentResponseOrStudentData extends ReadData{

    public void addContentLine(String contentLine){
        data.add(contentLine + "5");
    }
    public ReadStudentResponseOrStudentData(String fileName){
        super(fileName);
    }
}

