/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises2.task1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OPinator
 */
public class ByteArray extends Thread {

    long count = 0;
    int i = 0;
    int index;
    private int sum = 0;

    public int getSum() {
        System.out.println(sum);
        return sum;
    }
   


    public synchronized void run(String url) {

        index = 0;
        
        byte[] bs = null;
        try {
            bs = getBytesFromUrl(url);
        } catch (IOException ex) {
            System.out.println("IO exception");
        }
        
        

        for (byte b : bs) {
            int i = bs[index];            
            System.out.println(i);
            count += Math.abs(i);
            index++;
        }

    }
//Both sum of one, but total if all threads are run (sum)
    public long getCount() {
        System.out.println(count);
        sum += count;
        return count;
    }

    public static byte[] getBytesFromUrl(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.connect();
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = connection.getInputStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return bis.toByteArray();

    }
   
    
}
