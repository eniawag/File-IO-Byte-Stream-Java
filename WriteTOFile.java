import java.io.File; 
import java.io.FileOutputStream; 
import java.io.OutputStream;
import java.io.IOException; 
  
public class WriteTOFile {

    static File file;
    OutputStream outStream;
    public WriteTOFile(String filePath)throws IOException{
        file = new File(filePath);
        outStream = new FileOutputStream(file); 
    }    
    public void writeBytes(byte[] bytes)throws IOException
    { 
        outStream.write(bytes);
    }
    public void close()throws IOException 
    { 
        outStream.close(); 
    }
} 

