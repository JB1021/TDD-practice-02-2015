package HttpReqeust;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {

	Map headers = new HashMap<>();
	Map parameters = new HashMap<>();
	String URI;
	String method;
	String protocol;
	ArrayConverter arrayConverter;
	RequestLineParser requestLineParser;

	public HttpRequest(String header) {
		arrayConverter = new ArrayConverter();
		
		parseHeader(header);
	}
	
	public String[] parseEnter(String header) {
		return header.split("\n");
	}

	private void parseHeader(String header) {
		ArrayList<String> lines = arrayConverter.toArrayList(parseEnter(header));
		killRequestLine(getRequestLine(lines));
		putValueIntoMap(headers, lines.subList(1, lines.size()),": ");
		
	}

	private String getRequestLine(ArrayList<String> lines) {
		return lines.get(0);
	}

	private void killRequestLine(String requestLine) {
		String[] requestLineResult = requestLine.split(" ");
		requestLineParser.set(requestLine);
		re
		
		method = requestLineResult[0];
		String[] uriResult = requestLineResult[1].split("\\?");		
		protocol = requestLineResult[2];
		URI = uriResult[0];
		ArrayList<String> parameterResult = arrayConverter.toArrayList(uriResult[1].split("&"));
		putValueIntoMap(parameters, parameterResult, "=");
	}

	private void putValueIntoMap(Map map, List keyValue, String token) {
		for (int i=0; i<keyValue.size(); i++) {
			String[] splitResult = (keyValue.get(i).toString()).split(token);
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
