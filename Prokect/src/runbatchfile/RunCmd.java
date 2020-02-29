package runbatchfile;
import java.nio.file.Path;
import java.nio.file.Paths;

 

public class RunCmd {
    public static void main(String[] args) 
    { 
        try
        { 
            String userDir = System.getProperty("user.dir");
            Path path = Paths.get(userDir);
            String project = path.getFileName().toString();
            
            
           Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"p1.bat "+project); 
  
        } 
        catch (Exception e) 
        { 
            System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
            e.printStackTrace(); 
        } 
    } 

 

}