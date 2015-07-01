package employee.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class LoadEmployees {



	public  String loadInfo() {

		try {

			File file = new File("employee.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			String aLine = "";
			String[] names = new String[3];
			String rootO = "<employees>";
			String rootC = "</employees>";
			line += rootO + "\n";

			while ((aLine = br.readLine()) != null) {

				names = aLine.split(";");
				// System.out.println("Name: " + names[0]);
				// System.out.println("Email: " + names[1]);
				// System.out.println("Department: " + names[2]);

				line += "\t" + "<employee>" + "\n";
				line += "\t" + "<name> " + names[0] + " </name>" + "\n";
				line += "\t" + "<email> " + names[1] + " </email>" + "\n";
				line += "\t" + "<dept-name> " + names[2] + " </dept-name>"
						+ "\n";
				line += "</employee>" + "\n";

			}
			line += "\n" + rootC;
			br.close();
			return line;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
