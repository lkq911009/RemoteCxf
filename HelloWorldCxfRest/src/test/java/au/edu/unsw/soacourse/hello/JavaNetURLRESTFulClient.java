package au.edu.unsw.soacourse.hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;


public class JavaNetURLRESTFulClient {
	private static final String targetURL = "http://localhost:8080/RestfulFoundITService/wlr/userProfiles/all";

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(targetURL, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",detail="+map.get("detail")+",skill="+map.get("skill"));;
		}
	}

//		try {
//
//			URL restServiceURL = new URL(targetURL);
//
//			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL
//					.openConnection();
//			httpConnection.setRequestMethod("GET");
//			httpConnection.setRequestProperty("Accept", "application/json");
//
//			if (httpConnection.getResponseCode() != 200) {
//				throw new RuntimeException(
//						"HTTP GET Request Failed with Error code : "
//								+ httpConnection.getResponseCode());
//			}
//
//			BufferedReader responseBuffer = new BufferedReader(
//					new InputStreamReader((httpConnection.getInputStream())));
//
//			String output;
//			System.out.println("Output from Server:  \n");
//
//			while ((output = responseBuffer.readLine()) != null) {
//				System.out.println(output);
//			}
//
//			httpConnection.disconnect();
//
//		} catch (MalformedURLException e) {
//
//			e.printStackTrace();
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//
//		}
//
//	}

}
