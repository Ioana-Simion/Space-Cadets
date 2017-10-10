import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

	static String id = null;
	static final String link = "http://www.ecs.soton.ac.uk/people/";
	static String name ="";

	public static void main(String[] args) throws MalformedURLException
	{
		//create and initialise the GUI
		GUI gui = new GUI();
		gui.init();
	}

	public static void fetch() throws MalformedURLException {

		//use this if you want to read from the console
//		InputStreamReader reader = new InputStreamReader(System.in);
//		BufferedReader in = new BufferedReader(reader);
//		id = in.readLine();
		
		//create a person's link by adding the ID to the default link
		String personalLink = link + id;

		//transform the string into an URL
		URL url = new URL(personalLink);
		URLConnection con;
		try {
			con = url.openConnection();
			
			//read the lines from the page accessed with the URL
			InputStream is =con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = br.readLine()) != null) {

				//check for the <title> tag
				if (line.contains("<title>")) {
					//take the name between the > and the | symbols
					for (int i =0; i< line.indexOf("|") - line.indexOf(">")-2;i++) {
						name = name + line.charAt(line.indexOf(">")+i+1);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
