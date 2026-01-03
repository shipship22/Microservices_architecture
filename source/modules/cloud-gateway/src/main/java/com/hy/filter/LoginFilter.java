package com.hy.filter;

import com.hy.result.ContentResult;
import com.hy.result.Result;
import com.hy.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@Component
@Order(-1)
public class LoginFilter implements GlobalFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Value("#{'${ex.url:}'.empty ? null : '${ex.url:}'.split(',')}")
    private HashSet<String> urls;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst("token");

        AntPathMatcher ant = new AntPathMatcher();
        for (String url : urls) {
            String path = request.getURI().getPath();
            if(ant.match(url, path)){
                return chain.filter(exchange);
            }
        }

        if (token == null) {
            return getMono(exchange);
        }

        try {
            jwtUtil.parseJwt(token);
            return chain.filter(exchange);
        } catch (Exception e) {
            e.printStackTrace();
            return getMono(exchange);
        }
    }

    private static Mono<Void> getMono(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        Result result = new Result(ContentResult.TOKEN_NOT_NULL_CODE, ContentResult.TOKEN_NOT_NULL_MASSAGE);
        return response.writeWith(Mono.just(response.bufferFactory().wrap(result.toString().getBytes())));
    }
}
