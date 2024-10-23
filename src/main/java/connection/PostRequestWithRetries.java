package connection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestWithRetries {

    public static void main(String[] args) {
        String urlString = "http://test.ok.com/go?t1=111&t2=abc&t3=xyz";

        int maxRetries = 5;
        int attempt = 0;
        boolean success = false;

        while (attempt < maxRetries && !success) {
            attempt++;
            System.out.println("Attempt " + attempt);
            try {
                // Create a URL object
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Set the request method to POST
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Accept", "application/json");

                // Enable output for the connection (to send the body)
                connection.setDoOutput(true);

                // Get the response code
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Success, read the response
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    // Close the connections
                    in.close();
                    connection.disconnect();

                    // Output the JSON response
                    System.out.println("Response: " + content.toString());
                    success = true; // Mark the operation as successful
                } else {
                    System.out.println("Failed: HTTP error code: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Connection failed: " + e.getMessage());
                if (attempt == maxRetries) {
                    System.out.println("Max retries reached. Aborting.");
                } else {
                    try {
                        // Wait for a second before retrying
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
