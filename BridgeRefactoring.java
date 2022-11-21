import DataProcessing.ReadQuestionAndAnswerData;
import DataProcessing.ReadStudentResponseOrStudentData;

class BridgeRefactoring {
    public static void main(String[] args) {
        System.out.println("hillo");
        ReadStudentResponseOrStudentData test1 = new ReadStudentResponseOrStudentData("Data/response_data/student_data_q1_response.csv");
        ReadQuestionAndAnswerData test2 = new ReadQuestionAndAnswerData("Data/answer_data/sample_a_2.txt");
        test1.StoreData();     
        test2.StoreData();
        
        //test1.removeHeader();
        System.out.println(test1.getArray());
        System.out.println(test2.getArray());


    }
}

