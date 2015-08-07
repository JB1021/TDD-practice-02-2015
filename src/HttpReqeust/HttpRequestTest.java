package HttpReqeust;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class HttpRequestTest {
	
	HttpRequest request;
	String header = "GET /create?userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net HTTP/1.1\n"
			+ "Host: localhost:8080\n"
			+ "Connection: keep-alive\n"
			+ "Accept: */*\n";
	String userId = "javajigi";
	String password = "password";
	String name = "%EB%B0%95%EC%9E%AC%EC%84%B1";
	String email = "javajigi%40slipp.net";
	String host = "localhost:8080";
	String url = "/create?userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net";
	String URI = "/create";
	String method = "GET";
	String requestLine = "GET /create?userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net HTTP/1.1";

	@Before
	public void init(){		
		request = new HttpRequest(header);
	}
	
	@Test
	public void parseEnterTest() throws Exception {
		assertEquals(4, request.parseEnter(header).length);
	}
	
	@Test
	public void parseOthersTest() throws Exception {
		Map headerMap = request.getHeaderMap();
		
	}
	
	@Test
	public void parseRequestLineTest() throws Exception {
		
		Map requestLineMap = request.parseRequestLine(requestLine);
		
		// TODO : getParameter로 한 번 감싸기 
		assertEquals(method, requestLineMap.get("method"));
		assertEquals(url, requestLineMap.get("url"));
	}

	@Test
	public void getParameterTest() throws Exception {
	
		//assertEqual(userId, request.getParameter("userId"));
	}

}
