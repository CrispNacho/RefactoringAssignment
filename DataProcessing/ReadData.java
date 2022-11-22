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

    public ReadData(String filename){
        this.fileName = filename;   
    }
    
}
