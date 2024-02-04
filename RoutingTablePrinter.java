import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoutingTablePrinter
{
    public void printRoutingTable()
    {
        try
        {
            //Execute the "route print" command on Windows
            Process process = Runtime.getRuntime().exec("route print");

            //Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }

            // Close the reader and wait for the process to exit
            reader.close();
            process.waitFor();
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
