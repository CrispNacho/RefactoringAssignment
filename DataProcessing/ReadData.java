package DataProcessing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

abstract class ReadData {
    private String fileName;
    protected ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
    public void StoreData(){
        BufferedReader br = null;
            try{
            br = new BufferedReader(new FileReader(fileName));
            String contentLine = br.readLine();
            while (contentLine != null){
                contentLine = cleanData(contentLine);
                contentLine = contentLine.replaceAll("\\s+","").toLowerCase();
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

    public ArrayList<ArrayList<String>> getArray(){
        return data;
    }

    abstract protected void addContentLine(String contentLine);

    public String cleanData(String text) {
        //Replaces whitespace characters and changes the data to lower case, cleans the data as a whole
        return text.replaceAll("\\s+","").toLowerCase();
    }

    public ReadData(String filename){
        this.fileName = filename;   
    }
    
}
