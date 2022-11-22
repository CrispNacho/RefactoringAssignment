package DataProcessing;
import java.util.ArrayList;

public class CompareData {
    private ArrayList<ArrayList<String>> solutions;
    private ArrayList<ArrayList<String>> studentResponses;
    private ArrayList<ArrayList<String>> scores;
    private ArrayList<ArrayList<String>> studentInfo;

     /**
   * *Compares all data entered
   * *@param solutions refers to the solutions of each question
   *  @param studentResponses refers to the response of each student for each question
   *  @param studentInfo refers to the information of each student such as name, email, and etc.
   * */
    public CompareData(ArrayList<ArrayList<String>> solutions, ArrayList<ArrayList<String>> studentResponses, ArrayList<ArrayList<String>> studentInfo) {
        this.solutions = solutions;
        this.studentResponses = studentResponses;
        this.studentInfo = studentInfo;
    }

    //Generates the score for the user
    public ArrayList<ArrayList<String>> generateScoreList() {
        createEmptyScoreList();
        compareStudents();

        return scores;
    }

    //Establishes an empty score list
    private void createEmptyScoreList() {
        scores = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> row: studentInfo) {
            // Set empty score for each student
            row.add("0");
            scores.add(row);
        }
    }

    //Compares the student data
    private void compareStudents() {
        for (int i = 0; i < studentResponses.size(); i++) {
            // Starting score of 0
			int score = calculateScore(i);

            // Write down the score onto the main score list
            ArrayList<String> scoreRow = scores.get(i);
            scoreRow.set(scoreRow.size() - 1, String.valueOf(score));
        }
    }


    /**
   * *Calculates the score through comparisons
   * *@param i reference variable
   * */
    private int calculateScore(int i) {
        int score = 0;
        // Get the index of when the student info column ends
        int infoIndex = studentInfo.get(i).size() - 1;

        for (int q = infoIndex; q < studentResponses.get(i).size(); q++) {
            String response = studentResponses.get(i).get(q);
            String solution = solutions.get(q-infoIndex).get(0);

            if (response.toLowerCase().equals(solution.toLowerCase())) {
                // Add 1 score for each question they get correct
                score++;
            }
        }

        return score;
    }
}
