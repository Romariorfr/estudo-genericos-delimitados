package program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entitie.Product;
import service.CalculationService;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		List<Product> lista = new ArrayList<>();
		
		String path = "C:\\teste\\arquivo\\database.txt";
		
		try(BufferedReader buffer = new BufferedReader(new FileReader(path))){
			
			String line = buffer.readLine();
			
			while(line != null) {
				String [] fields = line.split(",");
				lista.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = buffer.readLine();
			}
			
			System.out.println("Most expansive: "+CalculationService.max(lista));
			
		}catch(IOException e){
			
			System.out.println("Error: "+ e.getLocalizedMessage());
			
		}

	}

}
