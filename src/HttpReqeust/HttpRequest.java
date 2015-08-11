package HttpReqeust;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

	Map headers = new HashMap<>();
	Map parameters = new HashMap<>();
	String URI;
	String method;
	String protocol;
	

	public HttpRequest(String header) {
		parseHeader(header);	
	}
	
	public String[] parseEnter(String header) {
		return header.split("\n");
	}

	private void parseHeader(String header) {
		String[] result = parseEnter(header);
		String[] requestLineResult = result[0].split(" ");
		method = requestLineResult[0];
		String[] uriResult = requestLineResult[1].split("\\?");
		
		String[] headerResult = new String[result.length-1];
		for(int i=1; i<result.length; i++){
			headerResult[i-1] = result[i];
		}
		
		URI = uriResult[0];
		String[] parameterResult = uriResult[1].split("&");
		putValueIntoMap(parameters, parameterResult, "=");
		putValueIntoMap(headers, headerResult,": ");
		
		protocol = requestLineResult[2];
	}

	private void putValueIntoMap(Map map, String[] keyValue, String token) {
		for (int i=0; i<keyValue.length; i++) {
			String[] splitResult = keyValue[i].split(token);
			map.put(splitResult[0], splitResult[1]);
		}
	}

	public Map parseRequestLine(String requestLine) {
		Map requestLineMap = new HashMap<>();
		String[] headers = requestLine.split(" ");	
		return requestLineMap;
	}

	public String getParameter(String parameter) {
		return parameters.get(parameter).toString();
	}

	public String getHeader(String header) {
		System.out.println(headers.get(header));
		return headers.get(header).toString();
	}
	
	public String getURI() {
		return URI;
	}
	
	public String getMethod() {
		return method;
	}
	
	public String getProtocol() {
		return protocol;
	}
}
