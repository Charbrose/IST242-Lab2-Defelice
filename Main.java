/**
 * Project: Solo Lab2 Assignment Networking
 * Purpose Details: Network analysis app with options for network ping,
                    NIC details, port scanning, and viewing the routing table
 * Course: IST 242
 * Author: Charlie Defelice
 * Date Developed: 2/3/24
 * Last Date Changed: 2/4/24
 * Rev: 2.3
 */

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        //Interaction and menu functionality
        do
        {
            displayMenu();
            System.out.print("Enter your choice (1-4, 0 to exit): ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    performNetworkPing();
                    break;
                case 2:
                    showNICDetails();
                    break;
                case 3:
                    performPortScan();
                    break;
                case 4:
                    showRoutingTable();
                    break;
                case 0:
                    System.out.println("Exiting System Network Analyzer. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        }
        while (choice != 0);
    }

    //Displays the user menu options
    private static void displayMenu()
    {
        System.out.println("User Menu for System Network Analyzer:");
        System.out.println("1. Perform a network ping");
        System.out.println("2. Show NIC Network Interface card details");
        System.out.println("3. Perform a port scan on your local computer and show ports");
        System.out.println("4. Show the routing table");
        System.out.println("0. Exit");
    }

    //Pings using the PingExample class
    private static void performNetworkPing()
    {
        PingExample pingExample = new PingExample("www.google.com");
        pingExample.performPing();
    }

    //Show's NIC details using the NetworkInfo class
    private static void showNICDetails()
    {
        NetworkInfo networkInfo = new NetworkInfo();
        networkInfo.showNICDetails();
    }

    //Performs a port scan on the local computer using the PortScanner class
    private static void performPortScan()
    {
        PortScanner portScanner = new PortScanner("localhost");
        portScanner.scanPorts();
    }

    //Shows the routing table using the RoutingTablePrinter class
    private static void showRoutingTable()
    {
        RoutingTablePrinter routingTablePrinter = new RoutingTablePrinter();
        routingTablePrinter.printRoutingTable();
    }
}