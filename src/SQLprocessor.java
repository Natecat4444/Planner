import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nathankaufman on 9/13/19.
 */
public class SQLprocessor {
    public ArrayList<String> parseSQL(String Filename){
        String filepath = String.format("Database/%s.txt", Filename);
        File file = new File(filepath);
        if (file.exists()){
            System.out.println("Found source material");
        }
        else {
            System.out.println("Could not find file");
        }
        ArrayList<String> commands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

        }catch (IOException e){
            System.out.println("Error importing sql");
            return null;
        }
        return commands;
    }
    public SQLprocessor(){

    }
}
