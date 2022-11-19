package DataProcessing;
import java.util.ArrayList;

public class CompareData {
    private ArrayList<String> solutions;
    private ArrayList<ArrayList<String>> studentResponses;
    private ArrayList<ArrayList<String>> scores;
    private ArrayList<ArrayList<String>> studentInfo;

    public CompareData(ArrayList<String> solutions, ArrayList<ArrayList<String>> studentResponses, ArrayList<ArrayList<String>> studentInfo) {
        this.solutions = solutions;
        this.studentResponses = studentResponses;
        this.studentInfo = studentInfo;
    }

    public void generateScoreList() {
        createEmptyScoreList();
        compareStudents();
    }

    private void createEmptyScoreList() {
        scores = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> row: studentInfo) {
            // Set empty score for each student
            row.add("0");
            scores.add(row);
        }
    }

    private void compareStudents() {
        for (int i = 0; i < studentResponses.size(); i++) {
            // Starting score of 0
			int score = calculateScore(i);

            // Write down the score onto the main score list
            ArrayList<String> scoreRow = scores.get(i);
            scoreRow.set(scoreRow.size() - 1, String.valueOf(score));
        }
    }

    private int calculateScore(int i) {
        int score = 0;
        // Get the index when the student info (email, number) ends
        // In order to know when the student answer responses start.
        int infoIndex = studentInfo.size();

        for (int q = infoIndex; q < studentResponses.get(i).size(); q++) {
            // Add 1 score for each question they get correct
            String response = studentResponses.get(i).get(q);
            String solution = solutions.get(q-infoIndex);

            if (response.toLowerCase().equals(solution.toLowerCase())) {
                score++;
            }
        }

        return score;
    }
}
