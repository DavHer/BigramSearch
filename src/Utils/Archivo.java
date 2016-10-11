/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Main.Main;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author david
 */
public class Archivo {
    public static String leerArchivoPorLinea(String archivo) {
        String ret = "";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line = br.readLine();

            while (line != null) {
                ret += line;
                ret += " ";
                line = br.readLine();
            }
        } catch (FileNotFoundException  ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public static MappedByteBuffer leerByChunks(String archivo) throws FileNotFoundException, IOException{
        //Create file object
        File file = new File(archivo);

        //Get file channel in readonly mode
        FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel();
        System.out.println(fileChannel.size());
        //Get direct byte buffer access using channel.map() operation
        long size = fileChannel.size()% Integer.MAX_VALUE;
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);

        // the buffer now reads the file as if it were loaded in memory.
        System.out.println(buffer.isLoaded());  //prints false
        System.out.println(buffer.capacity());  //Get the size based on content size of file
        System.out.println(buffer.limit());

        return buffer;
    }
}
