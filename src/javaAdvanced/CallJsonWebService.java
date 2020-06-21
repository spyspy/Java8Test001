

package javaAdvanced;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallJsonWebService {
    public static void main(String[] args) {

        //Call json web service via java code

        String input01 = "test01parameter";
        String input02 = "test02parameter";

        //JSON web service request
        String jsonRequest = "{\"test01\":\"" + input01 + "\",\"test02\":\"" + input02 + "\"}";

        try {
            URL urlForGetRequest = new URL("http://127.0.0.1:80/test/test/test");
            String readLine = null;
            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            //  you can add on second parameter: "application/json;charset=utf-8"

            //First way to get OutputStream
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            //Second way to get OutputStream
            OutputStream outputStream2 = connection.getOutputStream();

            outputStream.write(jsonRequest.toString().getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();
//
//		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
//		BufferedReader br = new BufferedReader(isr);
//		String line = "";
//		while ((line = br.readLine()) != null) {
//			System.out.println(line);
//		}

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                    response.append('\r');
                }
                in.close();

                // print result
                System.out.println("JSON String Result " + response.toString());
            } else {

                //NOT OK
                System.out.println("GET NOT WORKED");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
