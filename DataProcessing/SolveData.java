package DataProcessing;
import java.util.ArrayList;

public class SolveData {
    private ArrayList<String> equationsList = new ArrayList<String>();

    
    public void setEquations(ArrayList<String> equationsList) {
        this.equationsList = equationsList;
    }

    public void createNewMatrix() {
        ArrayList<String> varList = getVariables();
        equationToMatrix(varList);
    }

    public void getAnswers() {

    }

    private ArrayList<String> getVariables() {   
        String equation = equationsList.get(0);
        ArrayList<String> varList = new ArrayList<String>();

		// Add each variable found into the array
		for (int index=0; index<equation.length(); index++) {
			if (Character.isLetter(equation.charAt(index))) {
				varList.add(equation.substring(index, index+1));
			}
		}

		return varList;
	}

    private void equationToMatrix(ArrayList<String> varList) {
        
    }
}