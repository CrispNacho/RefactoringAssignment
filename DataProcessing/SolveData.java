package DataProcessing;
import java.util.ArrayList;

public class SolveData {
    /**
     * 1. Receive (Constructor)
     * 2. Create list for all variables present (Note: maybe some seperate methods)
     * 3. Convert the equations into matrix form (Note: Probably many mini methods here too)
     * 4. Set it through the Guassian equation
     * 5. Export an answer list
     */
    private ArrayList<String> equations;
    private ArrayList<String> varList = new ArrayList<String>();

    public SolveData() {
    }

    public void setEquations(ArrayList<String> equations) {
        this.equations = equations;
    }

    public void createMatrix() {
        getVariables(equations);
    }

    private ArrayList<String> getVariables(ArrayList<String> equations) {
        String equation = equations.get(0);

		// Add each variable found into the array
		for (int index=0; index<equation.length(); index++) {
			if (Character.isLetter(equation.charAt(index))) {
				varList.add(equation.substring(index, index+1));
			}
		}

		return varList;
	}
}