package DataProcessing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

abstract class ReadData {
    private String fileName;
    protected ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    //Stores the data into teh data structure
    public void StoreData(){
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

    abstract protected void addContentLine(String contentLine);

    /**
   * *Reads the data from the file
   * *@param fileName the name of the desired file entered by the user
   * */
    public ReadData(String filename){
        this.fileName = filename;   
    }
}