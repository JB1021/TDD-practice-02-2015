package HttpReqeust;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

	Map headerMap = new HashMap<>();
	
	public HttpRequest(String header) {
		parseHeader(header);
		
	}
	
	public String[] parseEnter(String header) {
		return header.split("\n");
	}

	private void parseHeader(String header) {
		String[] result = parseEnter(header);
	
	}

	public Map getHeaderMap() {
		return headerMap;
	}

	public Map parseRequestLine(String requestLine) {
		Map requestLineMap = new HashMap<>();
		String[] headers = requestLine.split(" ");
		
		
		return requestLineMap;
	}
}
