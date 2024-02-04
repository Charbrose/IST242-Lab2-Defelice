import java.net.Socket;
import java.io.IOException;

public class PortScanner
{
    private String targetHost;

    //Constructor to initialize the target host
    public PortScanner(String targetHost)
    {
        this.targetHost = targetHost;
    }

    // Method to scan ports within a specified range
    public void scanPorts()
    {
        String targetHost = this.targetHost;
        int minPort = 1;
        int maxPort = 65535;

        System.out.println("Scanning ports on " + targetHost + "...");

        for (int port = minPort; port <= maxPort; port++)
        {
            try
            {
                Socket socket = new Socket(targetHost, port);
                System.out.println("Port " + port + " is open");
                socket.close();
            }
            catch (IOException e)
            {
                //Port is likely closed or unreachable
            }
        }

        System.out.println("Port scanning finished.");
    }
}
