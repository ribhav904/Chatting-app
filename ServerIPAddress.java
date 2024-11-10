import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerIPAddress {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Server IP Address: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unable to determine IP address.");
            e.printStackTrace();
        }
    }
}
