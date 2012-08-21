import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class FileReaderFileToList {


    public static void main(String arg[]){
        List list = getList();

    }

    public static List getList(){
        List ret = new LinkedList<String>();
        try{

            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("src/main/laboratorios.csv");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                strLine = strLine.trim();
                if(strLine.contains(" ")){
                    int spacePos = strLine.indexOf(" ");
                    strLine = strLine.substring(0,spacePos);
                }

                ret.add(strLine);

            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return ret;
    }
}