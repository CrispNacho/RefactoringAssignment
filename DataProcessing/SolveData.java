package DataProcessing;
import java.util.ArrayList;
import java.util.Arrays;    

public class SolveData {
    private ArrayList<String> equationsList = new ArrayList<String>();
    protected ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

    public void setEquations(ArrayList<String> equationsList) {
        this.equationsList = equationsList;
    }

    public void createNewMatrix() {
        ArrayList<String> varList = getVariables();
        System.out.println(varList);
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
                System.out.println(splitByOperatorRaw[j]);
                if(splitByOperatorRaw[j].matches("[0-9]+")){
                    partOfConstant = Integer.parseInt(splitByOperatorRaw[j]);
                    try{
                        if(splitByOperatorRaw[j - 1].contains("-")){
                           partOfConstant = partOfConstant * -1;
                           System.out.println(partOfConstant + "has negatvie before it");
                        }
                     }catch(Exception e){}

                     if(!passedEqualSign){
                        partOfConstant = partOfConstant * -1;
                     }
                     System.out.println(splitByOperatorRaw[j] + " " + i);
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
    System.out.println(matrix);
    System.out.println(varList);
    }
}
