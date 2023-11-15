import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpVsHttpsExample {

    public static void main(String[] args) {
        try {
            // HTTP example
            String httpUrl = "http://www.elibrary.ru";
            sendRequest(httpUrl);

            System.out.println("-----------");

            // HTTPS example
            String httpsUrl = "https://www.elibrary.ru";
            sendRequest(httpsUrl);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void sendRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Get response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read and print the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        System.out.println("Response Content: " + response.toString());
    }
}
