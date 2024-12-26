package test241209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
	private static final String serviceKey = "fwuANnkYHIMUUiJkTbvoUJSKDMj6B0R3ADnOpkgXEypda8Gfx%2FVbqLlkCQiG1%2F0QTVWLlcLE98IoCn9bpCPyiQ%3D%3D";
	
	public static void main(String[] args) {
		
		System.out.println(airPollution);
	}
	
	public String airPollution(String location) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		
		// 파라미터
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseText = "";
		String line;
		while((line = br.readLine()) != null) {
			responseText += line;
		}
		br.close();
		urlConnection.disconnect();
		
		return responseText;
	}
}