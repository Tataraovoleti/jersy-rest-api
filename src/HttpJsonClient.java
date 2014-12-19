import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import com.jersy.demo.DemoBean;

/**
 * The Class HttpJsonClient.
 *
 * @author Tatarao voleti
 * @date   Dec 19, 2014
 */
public class HttpJsonClient {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		BufferedReader br=null;
		try {
			
			URL url= new URL("http://localhost:9999/JavaRestWithJersy/rest/u/json-response");
			URLConnection connection = (URLConnection)url.openConnection();
			connection.connect();
			
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			StringBuffer sb=new StringBuffer();
			String line="";
			
			while((line=br.readLine())!=null){
			   sb.append(line);	
			}
			
			System.out.println(sb.toString());
			
			String json = sb.toString();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);
			DemoBean db = mapper.readValue(json,DemoBean.class);
			
			System.out.println(db.getEid()+"  "+db.getEname());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						
					}
				}
			}
	}
}
