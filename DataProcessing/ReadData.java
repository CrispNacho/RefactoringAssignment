package DataProcessing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadData {
    private String fileName;
    protected ArrayList<String> data = new ArrayList<String>();

    public void StoreData(){

    }
    public void addContentLine(String contentLine){
        data.add(contentLine);
    }

    

    public ReadData(String filename){
        this.fileName = filename;   
    }
    
}
