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
        String filepath = String.format("Database/%s.sql", Filename);
        File file = new File(filepath);
        if (file.exists()){
            System.out.println("Found source material");
        }
        else {
            System.out.println("Could not find file");
        }
        ArrayList<String> commands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            String command = "";
            while (line != null){
                if(line.contains(";")){
                    if (command.equals("")){
                        command = line;
                        commands.add(command);
                        command = "";
                    }
                    else {
                        command = command + line;
                        commands.add(command);
                        command = "";
                    }
                }
                else{
                    if(command.equals("")){
                        command = line;
                    }
                    else {
                        command = command +line;
                    }
                }

                line= reader.readLine();
            }
        }catch (IOException e){
            System.out.println("Error importing sql");
            return commands;
        }
        return commands;
    }
    public SQLprocessor(){

    }
}
