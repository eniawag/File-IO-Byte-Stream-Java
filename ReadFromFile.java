import java.io.FileInputStream;
import java.io.IOException;

public class ReadFromFile 
{
    FileInputStream input = null;
    int chunkSize;
    boolean eof = false;
    
    public ReadFromFile(String filePath,int chunksize)throws IOException{
        input = new FileInputStream(filePath);
        chunkSize = chunksize;
    }

    public byte[] getBytes()throws IOException
    {
        int byteIn=0;
        byte[]buffer = new byte[chunkSize];
        int counter =0;
        while ((counter < buffer.length) 
                && ((byteIn= input.read()) != -1)) 
        {                  
            buffer[counter] = (byte)byteIn;
            counter++;
        }

        if (byteIn==-1&&input != null) 
        {
            input.close();
        }

        if (counter==chunkSize)
        {
            if  (byteIn==-1){
                eof=true;
            }
            return buffer;
        }else{
            byte[]bufferUnderSize = new byte[counter];
            for(int i=0;i<counter;i++){
                bufferUnderSize[i]=buffer[i];
            }
            eof = true;
            return bufferUnderSize;
        }       
    }
    
    public boolean notEndOfFile(){
        
        return !(eof);
    }
}
