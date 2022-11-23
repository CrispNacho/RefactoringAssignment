package DataProcessing;
import java.util.ArrayList;   
import java.util.Collections;

public class SolveData {

    private ArrayList<String> equationsList = new ArrayList<String>();

    /**
   * *Sets the equations needed for solving
   * *@param equationsList is the list of equations used
   * */
    public void setEquations(ArrayList<String> equationsList) {
        this.equationsList = equationsList;
    }


    /**
     * Establishes and creates the solution list to get needed solutions
     * @return the created solution list
     */
    public ArrayList<String> createSolutionList() {
        ArrayList<String> varList = getVariables();
        
        ArrayList<ArrayList<Double>> matrix = equationToMatrix(varList);

        return getSolutions(matrix, varList);
    }

    /**
   * *Sets the equations needed for solving
   * *@param matrix is the way in which we solve the questions
   * *@param varList is the list of variables used in the data
   * */
    public ArrayList<String> getSolutions(ArrayList<ArrayList<Double>> matrix, ArrayList<String> varList) {
        // Size of matrix without constants
        int matrixSize = varList.size();
        ArrayList<Double> answers = new ArrayList<Double>(Collections.nCopies(matrixSize, 0.0));
		ArrayList<String> polishedAnswers = new ArrayList<String>();

        // Forward Elimination
		for(int i = 0; i < matrixSize-1; i++) {
			for(int j = i + 1; j < matrixSize; j++) {
			  Double factorRatio  = matrix.get(j).get(i) / matrix.get(i).get(i);
			  for(int k=i; k<matrixSize+1; k++) {
                matrix.get(j).set(k, matrix.get(j).get(k) - factorRatio * matrix.get(i).get(k));
            }
          }
        }
		 
		// Backward Elimination
		// matrix[][matrixLen] use matrixLen value 
		// to get the index of the last column (where the constants are stored)
        answers.set(matrixSize-1, matrix.get(matrixSize-1).get(matrixSize) / matrix.get(matrixSize-1).get(matrixSize-1));

		for(int i = matrixSize - 2; i > -1; i--) {
			Double sum = matrix.get(i).get(matrixSize);
			for(int j=i+1; j<matrixSize; j++) {
				sum = sum - matrix.get(i).get(j) * answers.get(j);
			}
            answers.set(i, sum / matrix.get(i).get(i));
		}
	
		// Add variables to the answers 
		// x=3, y=5, etc...
		for (int row = 0; row < matrixSize; row++) {
            if (Double.isInfinite(answers.get(row))) {
                polishedAnswers.add("n/a");
                break;
            }
            polishedAnswers.add(varList.get(row) + "=" + answers.get(row));
		}
        
        return polishedAnswers;
    }

    /**
     * Obtains the different variables needed for solving
     * @return the list of the shown variables
     */
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

   /**
   * *Gives the equation to the matrix for solving
   * *@param varList is the list of variables in the data that is used
   * */
    private ArrayList<ArrayList<Double>> equationToMatrix(ArrayList<String> varList) {
        ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();

    for(int i = 0; i < equationsList.size(); i++){ // iterate through every equation
        matrix.add(new ArrayList<>());
        for(int j = 0; j < varList.size(); j++){// populates the arraylist with empty values 
            matrix.get(i).add(0.0);
        }
        int partOfConstant;
        double constant = 0;
        double coefficient = 1;
        boolean passedEqualSign = false;
        String[] equationLine =  equationsList.get(i).toLowerCase().split(String.format("((?<=%1$s)|(?=%1$s))", "[-+=]"));
            for(int j = 0; j < equationLine.length; j++){
                if(equationLine[j].matches("[0-9]+")){
                    partOfConstant = getCoefficient(equationLine, passedEqualSign, j);
                     constant += partOfConstant;
                }
                else if (Character.isLetter(equationLine[j].charAt(equationLine[j].length() - 1))){
                    coefficient = 1.0; 
                    if (equationLine[j].length() > 1){
                        coefficient = Double.parseDouble(equationLine[j].substring(0,(equationLine[j].length() - 1)));
                    }
                    if(passedEqualSign){
                        coefficient = coefficient * -1;
                    }
                    try{
                        if(equationLine[j - 1].contains("-")){
                           coefficient = coefficient * -1;
                        }
                     }catch(Exception e){}

                    for(int k = 0; k < varList.size(); k++){
                        if(varList.get(k).charAt(0) == equationLine[j].charAt(equationLine[j].length() - 1)){
                            matrix.get(i).set(k,coefficient); //inserts the value of the variable coefficient at the specfic index that its in the variable list
                        }
                    }
                }
                else if(equationLine[j].contains("=")){
                    passedEqualSign = true;
                 }
                if (j == equationLine.length - 1){
                    matrix.get(i).add(constant);
                }
        
            }

    }
    return matrix;
    }
    /**
     * 
     * @param splitByOperatorRaw the initial array it is pulling from
     * @param passedEqualSign if the equal sign has been seen yet
     * @param j the index of the current part of the array that is being delt with
     * @return
     */
    private int getCoefficient(String[] equationLine, boolean passedEqualSign, int j){
        int partOfConstant = Integer.parseInt(equationLine[j]);
        try{
            if(equationLine[j - 1].contains("-")){
               partOfConstant = partOfConstant * -1;
            }
         }catch(Exception e){}

         if(!passedEqualSign){
            partOfConstant = partOfConstant * -1;
         }
         return partOfConstant;
    }
}
