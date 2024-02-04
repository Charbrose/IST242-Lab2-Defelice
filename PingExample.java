import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingExample
{
    private String hostName;

    //Constructor to set the hostName for the ping
    public PingExample(String hostName)
    {
        this.hostName = hostName;
    }
    //Method to perform a network ping
    public void performPing()
    {
        try
        {
            InetAddress inetAddress = InetAddress.getByName(hostName);
            if (inetAddress.isReachable(5000))
            {
                System.out.println(hostName + " is reachable");
            }
            else
            {
                System.out.println(hostName + " is not reachable");
            }
        }
        catch (UnknownHostException e)
        {
            //Handles the unknown host exception
            System.err.println("Unknown host: " + hostName);
        }
        catch (Exception e)
        {
            //Handles the general exception during ping
            System.err.println("Error while pinging " + hostName + ": " + e.getMessage());
        }
    }
}
