package DataProcessing;
import java.util.ArrayList;
import java.util.Arrays;    
import java.util.Collections;

public class SolveData {
    private ArrayList<String> equationsList = new ArrayList<String>();

    public void setEquations(ArrayList<String> equationsList) {
        this.equationsList = equationsList;
    }

    public ArrayList<String> createSolutionList() {
        ArrayList<String> varList = getVariables();
        
        ArrayList<ArrayList<Double>> matrix = equationToMatrix(varList);

        return getSolutions(matrix, varList);
    }

    public ArrayList<String> getSolutions(ArrayList<ArrayList<Double>> matrix, ArrayList<String> varList) {
        // Size of matrix without constants
        int matrixSize = varList.size();
        ArrayList<Double> answers = new ArrayList<Double>(Collections.nCopies(matrixSize, 0.0));
		ArrayList<String> polishedAnswers = new ArrayList<String>(Collections.nCopies(matrixSize, ""));

        // Forward Elimination
		for(int i = 0; i < matrixSize-1; i++) {
			for(int j = i + 1; j < matrixSize; j++) {
			  Double factorRatio  = matrix.get(j).get(i) / matrix.get(i).get(i);
			  for(int k=i; k<matrixSize+1; k++) {
				matrix.get(j).set(k, matrix.get(j).get(k) - factorRatio * matrix.get(i).get(k));
			  }
			}
		  }

          System.out.println(matrix);
		 
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
            polishedAnswers.set(row, varList.get(row) + "=" + answers.get(row));
		}
        
        return polishedAnswers;
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

    private ArrayList<ArrayList<Integer>> equationToMatrix(ArrayList<String> varList) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

    for(int i = 0; i < equationsList.size(); i++){ // iterate through every equation
        matrix.add(new ArrayList<>());
        for(int j = 0; j < varList.size(); j++){
            matrix.get(i).add(0);
        }
        int partOfConstant;
        int constant = 0;
        int coefficient = 1;
        boolean passedEqualSign = false;
        String[] splitByOperatorRaw =  equationsList.get(i).toLowerCase().split(String.format("((?<=%1$s)|(?=%1$s))", "[-+=]"));
            for(int j = 0; j < splitByOperatorRaw.length; j++){
                if(splitByOperatorRaw[j].matches("[0-9]+")){
                    partOfConstant = Integer.parseInt(splitByOperatorRaw[j]);
                    try{
                        if(splitByOperatorRaw[j - 1].contains("-")){
                           partOfConstant = partOfConstant * -1;
                        }
                     }catch(Exception e){}

                     if(!passedEqualSign){
                        partOfConstant = partOfConstant * -1;
                     }
                     constant += partOfConstant;
                }
                else if (Character.isLetter(splitByOperatorRaw[j].charAt(splitByOperatorRaw[j].length() - 1))){
                    if (splitByOperatorRaw[j].length() > 1){
                        coefficient = Integer.parseInt(splitByOperatorRaw[j].substring(0,(splitByOperatorRaw[j].length() - 1)));
                    }
                    if(passedEqualSign){
                        coefficient = coefficient * -1;
                    }
                    try{
                        if(splitByOperatorRaw[j - 1].contains("-")){
                           coefficient = coefficient * -1;
                        }
                     }catch(Exception e){}

                    for(int k = 0; k < varList.size(); k++){
                        if(varList.get(k).charAt(0) == splitByOperatorRaw[j].charAt(splitByOperatorRaw[j].length() - 1)){
                            matrix.get(i).set(k,coefficient);
                        }
                    }
                }
                else if(splitByOperatorRaw[j].contains("=")){
                    passedEqualSign = true;
                 }
                if (j == splitByOperatorRaw.length - 1){
                    matrix.get(i).add(constant);
                }
        
            }

    }
    return matrix;
    }
}
