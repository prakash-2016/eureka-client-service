package com.services.stock;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;


//@RequestMapping("/rest/stock")
@RestController
public class StockResource {

	@Autowired
    RestTemplate restTemplate;

    @GetMapping("name/{username}")
    public List<String> getStock(@PathVariable("username") final String userName) {
        System.out.println("In get stock"+userName);
       /* ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://localhost:8300/rest/db/" + userName, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });*/
        
        ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://db-service/rest/db/" + userName, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });
        
        List<String> quotes = quoteResponse.getBody();
        return quotes;
        
        /*return quotes
                .stream()
                .map(this::getStockPrice)
                .collect(Collectors.toList());*/
    }
	
    private Stock getStockPrice(String quote) {
        try {
            return YahooFinance.get(quote);
        } catch (IOException e) {
            e.printStackTrace();
            return new Stock(quote);
        }
    }
    
    
}