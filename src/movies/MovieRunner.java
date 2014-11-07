
package movies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import movies.Deque.DequeIterator;
import org.json.*;

/**
 * The MovieRunner class contains a deque which prints the movie data from the
 * OMDb API
 * 
 * @author sarahford
 * 
 * @since October 4, 2014
 * @staus working properly 
 */
public class MovieRunner {
	/**
	 * 
	 the readfromjson method taks a url and converts it to JSON data
	 * 
	 * @param URL
	 *            http
	 * @return JSONObject representing movie data
	 * 
	 */
	private JSONObject readFromURL(URL http) throws JSONException, IOException {
		HttpURLConnection socket = (HttpURLConnection) http.openConnection();
		socket.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		String movieInfo = br.readLine();
		JSONObject js = new JSONObject(movieInfo);
		return js;

	}

	/**
	 * 
	 The movieRunner main method reads the titles from a text file and then
	 * calls the tojsono bject method in orer to store them in a json deque. It
	 * then iterates through and displays the deque
	 * 
	 * @param String
	 *            [] args an empty array of type string
	 * @return void
	 * 
	 */
	public static void main(String args[]) throws IOException, JSONException {
		MovieRunner movieClass = new MovieRunner();
		BufferedReader input = new BufferedReader(new FileReader(
				"MovieTitles.txt"));
		String title = input.readLine();
		Deque<JSONObject> movieDeque = new Deque<JSONObject>();
		// makes a call to each URL with the title read from the file
		while (title != null) {
			// parse the title into a readable format for the REST call
			String[] titles = title.split(" ");
			for (int i = 0; i < titles.length; i++) {
				if (titles.length == 1) {
					break;
				}
				if (i != 0) {
					title += "+" + titles[i];
				} else {
					title = titles[i];
				}
			}
			String urlString = "http://www.omdbapi.com/?t=" + title;
			URL url = new URL(urlString);
			movieDeque.addFirst(movieClass.readFromURL(url));
			title = input.readLine();
		}
		input.close();
		DequeIterator dequeIterator = movieDeque.iterate();
		while (dequeIterator.hasNext()) {
			System.out.println(dequeIterator.next().toString());
		}

	}

}
