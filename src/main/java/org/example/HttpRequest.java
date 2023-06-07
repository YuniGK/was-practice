package org.example;

import org.example.QueryStrings;
import org.example.RequestLine;

import java.io.BufferedReader;
import java.io.IOException;

/* HttpRequset
    - RequestLine (GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1)
        → HttpMethod
        → path
        → queryString
    - Header
    - Body
*/
public class HttpRequest {
    private final RequestLine requestLine;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryString();
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String path) {
        return requestLine.matchPath(path);
    }
}
