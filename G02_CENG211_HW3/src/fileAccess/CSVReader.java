package fileAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader implements IFileIO {
	private String line;
	private String fileName;
	
	public CSVReader(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
    public ArrayList<String> getLines(){
        ArrayList<String> cargosArray= null;
        int count = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName+".csv"));
            cargosArray = new ArrayList<String>();

            while((line = br.readLine())!= null) {
                cargosArray.add(line);
            }
            br.close();
            


        }catch(FileNotFoundException exception){
            System.out.println("Packages file not found");
        }catch(IOException exception) {
            System.out.println(exception);
        }



        return cargosArray;
	}

}
