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

    public void calculateScores() {
        createScoreArray();
    }

    private void createScoreArray() {
        scores = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> row: studentInfo) {
            // Set empty score for each student
            row.add("0");
            scores.add(row);
        }
    }

    private void compare() {
        for (int student = 0; student < studentResponses.size(); student++) {
            // Starting score of 0
			int score = 0;
            int infoIndex = studentInfo.size();

			for (int q = infoIndex; q < studentResponses.get(student).size(); q++) {
				// Add 1 score for each question they get correct
				if (studentResponses.get(student).get(q).toLowerCase().equals(solutions.get(q-infoIndex).toLowerCase())) {
					score++;
				}
			}

            int lastIndex = scores.get(student).size() - 1;
			scores.get(student).set(lastIndex, String.valueOf(score));
        }
    }
}
