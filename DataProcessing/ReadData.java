package DataProcessing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

abstract class ReadData {
    private String fileName;
    protected ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    //Stores the data into teh data structure
    public void storeData(){
        BufferedReader br = null;
            try{
            br = new BufferedReader(new FileReader(fileName));
            String contentLine = br.readLine();
            while (contentLine != null){
                addContentLine(contentLine);
                
                contentLine = br.readLine();
            }
        }
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
        finally{
            try{
                if (br!= null){
                    br.close();
                }
            }
            catch (IOException ioe){
                System.out.println("error in closing the buffered reader");
            }
        }
    }

    //Gets the array
    public ArrayList<ArrayList<String>> getArray(){
        return data;
    }

    /**
   * *Adds the contentline to the data
   * *@param contentLine looks at the data of each individual line
   * */
    abstract protected void addContentLine(String contentLine);

    /**
   * *Cleans the desired data
   * *@param text the data that is to be cleaned by removing whitespaces and changing to lowercase
   * */
    public String cleanData(String text) {
        //Replaces whitespace characters and changes the data to lower case, cleans the data as a whole
        return text.replaceAll("\\s+","");
    }

    /**
   * *Reads the data from the file
   * *@param fileName the name of the desired file entered by the user
   * */
    public ReadData(String filename){
        this.fileName = filename;   
    }
}