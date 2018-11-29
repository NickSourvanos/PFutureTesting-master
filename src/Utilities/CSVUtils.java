package Utilities;
import DAOs.VehicleImpl;
import Entities.Vehicle;
import DAOs.VehicleDAO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CSVUtils{
    private static final char DEFAULT_SEPARATOR = ',';

    public static String fileName(){
        String fileName = new SimpleDateFormat("yyyyMMddHHmm'.csv'").format(new Date());
        fileName = "plate_" + fileName;
        return fileName;
    }

    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }


    private static String followCVSformat(String value) {

       String result = value;
       if (result.contains("\"")) {
           result = result.replace("\"", "\"\"");
       }
       return result;
    }

    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

       boolean first = true;


       if (separators == ' ') {
           separators = DEFAULT_SEPARATOR;
       }

       StringBuilder sb = new StringBuilder();
       for (String value : values) {
           if (!first) {
               sb.append(separators);
           }
           if (customQuote == ' ') { sb.append(followCVSformat(value)); }
           else { sb.append(customQuote).append(followCVSformat(value)).append(customQuote); }

           first = false;
       }

       sb.append("\n");
       w.append(sb.toString());
    }

    public static void createCSVFile(int nextDays) throws IOException{
        String PATH = "C://";
        String directoryName = PATH.concat("ProjectFutureFolder");
        FileWriter writer = null;
        try{
            File directory = new File(directoryName);
            if (! directory.exists()){
                directory.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            }
            writer = new FileWriter(directoryName + "/" + CSVUtils.fileName());

            CSVUtils.writeLine(writer, Arrays.asList("Plate"));
            VehicleDAO vehicle = new VehicleImpl();
            for(Vehicle v : vehicle.getListOfVehiclesExp(nextDays)){
                List<String> plates = new ArrayList<>();
                plates.add(v.getPlate());

                CSVUtils.writeLine(writer, plates);
            }

        }catch(SQLException e){}
        finally{
            writer.flush();
            writer.close();
        }
    }


}
