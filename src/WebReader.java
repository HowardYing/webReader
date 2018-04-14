import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebReader {

	public static void main(String[] args) throws MalformedURLException {
		Scanner in = new Scanner(System.in);
		File inputFile = new File("data.txt");
		System.out.println("Please enter the target URL:");
		String address = in.nextLine();
		Scanner urlin = null;
		URL pageLocation = new URL(address);
		try {
			urlin = new Scanner(pageLocation.openStream());
		} catch (IOException e) {
			System.out.println("Sorry, this is not a valid URL");
		}
		try {
			PrintWriter out = new PrintWriter("data.txt");
			while(urlin.hasNextLine())	out.println(urlin.nextLine());
			System.out.println("WebReader was successful - Check output file.");
			out.close();
			urlin.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Internal Error: Output file was not found");
			e1.printStackTrace();
		}
	}

}
