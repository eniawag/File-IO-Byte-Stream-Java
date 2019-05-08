public class test {
     
    public static void main(String[] args) 
    {   
        try{ 
            ReadFromFile f = new ReadFromFile(args[0], 1024);
            WriteTOFile out = new WriteTOFile(args[1]) ;   
            while (f.notEndOfFile()){
                out.writeBytes(f.getBytes());
            }
            out.close();
        }catch(Exception e){
            System.out.println("Most likely it failed to get a file lock, if not I hope you enjoy debugging as much as I do");
        }

    }    
}
