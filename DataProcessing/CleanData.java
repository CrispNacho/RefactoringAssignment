package DataProcessing;

public class CleanData {
    public String cleanData(String text) {
        return text.replaceAll("\\s+","").toLowerCase();
    }
}