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
	String connection = "keep-alive";
	String accept = "*/*";
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
	public void getParameterTest() throws Exception {
		assertEquals(userId, request.getParameter("userId"));
		assertEquals(password, request.getParameter("password"));
		assertEquals(name, request.getParameter("name"));
		assertEquals(email, request.getParameter("email"));
	}
	@Test
	public void getMethodTest() throws Exception {
		assertEquals(method, request.getMethod());
	
	}
	@Test
	public void getURITest() throws Exception {
		assertEquals(URI, request.getURI());
	
	}
	
	@Test
	public void getHeadersTest() throws Exception {
		assertEquals(host, request.getHeader("Host"));
		assertEquals(connection, request.getHeader("Connection"));
		assertEquals(accept, request.getHeader("Accept"));
	}

}
