package Data;
import DataProcessing.ValidateFile;
import DataProcessing.ExportData;
import java.util.ArrayList;

abstract class Data {
    protected ValidateFile validater = new ValidateFile();
    protected ExportData exporter = new ExportData();
}