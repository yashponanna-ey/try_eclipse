package runbatchfile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFileToString 
{
	//to modify it in file
    static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
        
        String oldContent = "";
        
        BufferedReader reader = null;
        
        FileWriter writer = null;
        
        try 
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            
            //Reading all the lines of input text file into oldContent
            
            String line = reader.readLine();
            
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                
                line = reader.readLine();
            }
            
            //Replacing oldString with newString in the oldContent
            
            String newContent = oldContent.replaceAll(oldString, newString);
            
            //Rewriting the input text file with newContent
            
            writer = new FileWriter(fileToBeModified);
            
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                //Closing the resources
                
                reader.close();
                
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
	public static void main(String[] args) throws FileNotFoundException 
    {
        String trystr="";
        String tempstr="";
        String finalstr="";


       // try
       // { 
            String userDir = System.getProperty("user.dir");
            Path path = Paths.get(userDir);
            String project = path.getFileName().toString();
            

        
        try {
			Scanner dscanner = new Scanner(new File("C:\\Users\\Yash.Ponanna\\eclipse-workspace\\Prokect\\src\\runbatchfile\\azure-pipelines.yml"));
			while (dscanner.hasNextLine()) {
				//System.out.println(dscanner.nextLine());
				trystr=dscanner.nextLine();

				    Pattern p = Pattern.compile("ACR.Name: '");   // the pattern to search for
				    Matcher m = p.matcher(trystr);
				    
				    // now try to find at least one match
				    if (m.find()) {
				      System.out.println("Found a match");
				      char[] charArray = trystr.toCharArray();
				        for(char i : charArray) {
				        	System.out.println(i);
				        	tempstr=tempstr+i;
				        	Pattern pat = Pattern.compile("ACR.Name: '");   // the pattern to search for
						    Matcher mat= pat.matcher(tempstr);
						    if(mat.find()) {
						    	if(i!='\'') {
						    	finalstr=finalstr+i;}
						    }
				        }
				    }
				
			}
			dscanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        System.out.println(finalstr+""+project);
        modifyFile("C:\\Users\\Yash.Ponanna\\eclipse-workspace\\Prokect\\src\\runbatchfile\\azure-pipelines.yml", finalstr, project);        

    }
}
