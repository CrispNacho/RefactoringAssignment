package DataProcessing;

public class CleanData {
    /**
   * *Cleans the data
   * *@param text the data to be cleaned
   * */
    public String cleanData(String text) {
        //Replaces whitespace characters and changes the data to lower case, cleans the data as a whole
        return text.replaceAll("\\s+","").toLowerCase();
    }
}