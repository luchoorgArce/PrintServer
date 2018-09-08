/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lavu;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ControladorERPConector {
    
    private static final String USER_AGENT = "Mozilla/5.0";
    String api_url = "https://admin.poslavu.com/cp/reqserv/";
    String api_dataname = "ag_tech";
    String api_key = "ATlLPspZg3XqMnBzfGBM";
    String api_token = "AIGKcr5ChOZmQlo0o2Mh";  
    
    public void PostData(String postData)
    {
        try
        {
            URL obj = new URL(api_url);
            HttpURLConnection request = (HttpURLConnection) obj.openConnection();
            
            request.setRequestMethod("POST");
            request.setRequestProperty("User-Agent", USER_AGENT);
            
            request.setDoOutput(true);
            OutputStream os = request.getOutputStream();
            
            String postvars = "dataname=" + api_dataname + "&key=" + api_key + "&token=" + api_token;
            postvars += postData;
            os.write(postvars.getBytes());
            os.flush();
            os.close();
            
            int responseCode = request.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("POST request not worked");
            }
        }
        catch(Exception ex){
            Logger.getLogger(ControladorERPConector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
