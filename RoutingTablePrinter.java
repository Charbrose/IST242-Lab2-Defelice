import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoutingTablePrinter
{
    public void printRoutingTable()
    {
        try
        {
            //Executes the "route print" command on Windows
            Process process = Runtime.getRuntime().exec("route print");

            //Reads the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }

            //Closes the reader and waits for the process to finish
            reader.close();
            process.waitFor();
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
