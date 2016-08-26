/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises3.taskSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *
 * @author OPinator
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(8080));

        Runnable ssRunnable = () -> {
            try (Socket newConnection = ss.accept();
                    OutputStream outputStream = newConnection.getOutputStream()) {
                outputStream.write("Hello world\n".getBytes());
            } catch (Exception ex) {
                System.out.println("Exception");
            }
        };
    
    new Thread(ssRunnable).start();

    Socket socket = new Socket();
    SocketAddress address = new InetSocketAddress("localhost", 8080);

    socket.connect(address);
    BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    String line;
    while((line  = inputStream.readLine()) != null) {
    System.out.println(line);
    }
}
