package com.cronjob;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by: tnthien
 * $Revision: 1.0 $Date: 2018/09/27 5:15 PM
 * $Log: RestTemplateTest.java
 */
public class RestTemplateTest {

  private RestTemplate restTemplate = new RestTemplate();

  @Test
  public void testGetAll() {
    String response = restTemplate.getForObject("https://restcountries.eu/rest/v2/all", String.class);
    System.out.println("Response from all: \n" + response);
  }

  @Test
  public void testGetAllMapToCountry() {
    /*ResponseEntity<Country[]> responseEntity = restTemplate.getForEntity("https://restcountries.eu/rest/v2/all", Country[].class);
    Country[] countries = responseEntity.getBody();
    MediaType contentType = responseEntity.getHeaders().getContentType();
    HttpStatus statusCode = responseEntity.getStatusCode();*/
  }
}
