import java.net.*;
import java.io.*;

class ClientA {
    private Socket socket = null;
    private DataOutputStream out = null;
    private BufferedReader in = null;

    ClientA (String address, int port) {

        try {

            socket = new Socket (address, port);
            System.out.println("Connection established to server");

            in = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        } 

        String line = "";

        while (!line.equals("Over")) {

            try {
                line = in.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            socket.close();
            in.close();
            out.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ClientA clientA = new ClientA("10.163.57.152", 5050);
    }
}jkhds