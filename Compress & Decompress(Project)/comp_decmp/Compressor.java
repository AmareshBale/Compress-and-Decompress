package comp_decmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);  //Input for the compression
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);   //Output
        byte[] buffer = new byte[1024];
        int len;
        
        //Reading and Compressing the File
        while ((len=fis.read(buffer))!=-1) {
            gzip.write(buffer, 0, len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException {
        File path=new File("amar/Downloads");
        method(path);
    }
}
