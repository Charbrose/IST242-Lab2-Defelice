import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.net.UnknownHostException;

public class NetworkInfo
{
    public void showNICDetails()
    {
        try
        {
            //Gets local host information
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Local Hostname: " + localhost.getHostName());
            System.out.println("Local IP Address: " + localhost.getHostAddress());

            //Gets information about network interfaces
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements())
            {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Interface Name: " + networkInterface.getDisplayName());
                if (networkInterface.getHardwareAddress() != null)
                {
                    System.out.println("Interface Hardware Address: " + formatMACAddress(networkInterface.getHardwareAddress()));
                }
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements())
                {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("IP Address: " + inetAddress.getHostAddress());
                }
                System.out.println();
            }
        }
        catch (SocketException | UnknownHostException e)
        {
            e.printStackTrace();
        }
    }

    //Helper method to format the MAC address as a string
    private static String formatMACAddress(byte[] mac)
    {
        StringBuilder formattedMAC = new StringBuilder();
        for (byte b : mac)
        {
            formattedMAC.append(String.format("%02X:", b));
        }
        if (formattedMAC.length() > 0)
        {
            formattedMAC.deleteCharAt(formattedMAC.length() - 1); //Remove the trailing ':'
        }
        return formattedMAC.toString();
    }
}
