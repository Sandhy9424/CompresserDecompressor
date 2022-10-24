/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import java.io.*;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author 91887
 */
public class Decompress {
    public static void method(File f) throws IOException {
        String filediractory=f.getParent();
        System.out.println(filediractory);
        FileInputStream fis=new FileInputStream(f);
        FileOutputStream fos=new FileOutputStream(filediractory+"\\decompressed.txt");
        GZIPInputStream gzip=new GZIPInputStream(fis);
        byte[]buffer=new byte[1000000];
        int len;
        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer, 0, len);
        }
        fis.close();
        fos.close();
        gzip.close();
        
        
    }
    public static void main(String[] args) throws IOException {
       File path =new File("C:\\Users\\91887\\Desktop\\project java 1st\\compressed.gz");
       //File path2=new File("C:\\Users\\91887\\Desktop\\project java 1st\\compressed.gz");
       method(path);
    }
    
}
