package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
            .forEach(queryString -> {
                String[] values = queryString.split("=");
                if(values.length != 2){
                    throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열입니다.");
                }

                queryStrings.add(new QueryString(values[0], values[1]));
            });
    }

    public String getValue(String key) {
        return this.queryStrings.stream()
                .filter(queryString -> queryString.exists(key))//해당 값에 키값이 존재하는지 확인
                .map(QueryString :: getValue)//존재할 경우 값을 가져온다.
                .findFirst()
                .orElse(null);//값이 없을 경우 null
    }
}
