/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compressordecompressor;
import java.io.*;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author 91887
 */
public class CompressorDecompressor {
    public static void method(File f) throws IOException{
        String FileDiractory=f.getParent();
        System.out.println(FileDiractory);
        FileInputStream fis=new FileInputStream(f);
        FileOutputStream fos=new FileOutputStream(FileDiractory+"/compressed.gz");
        GZIPOutputStream gzip=new GZIPOutputStream(fos);
        System.out.print(gzip);
        byte[] buffer=new byte[10000000];
        int len;
        while((len=fis.read(buffer))!=-1){
        gzip.write(buffer, 0, len);
    }
        gzip.close();
        fis.close();
        fos.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File path=new File("C:\\Users\\91887\\Desktop\\project java 1st\\ayush.txt");
       // File path2=new File("C:\\Users\\91887\\Desktop\\project java 1st\\my resume.pdf");
        method(path);
        //method(path2);
    }
    
}
