package com.example.apis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.apis.entity.CatFact;
import com.example.apis.entity.Countries;
import com.example.apis.entity.DataResponse;
import com.example.apis.entity.Users;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.apis.entity.RandomResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.apis.entity.Posts;




@RestController
public class ApiController {
    List<Countries> countries = new ArrayList<>();
    List <Users> users = new ArrayList<>();
    CatFact catFact;
    String cats;
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    private final RestTemplate restTemplate = new RestTemplate();
    
    @GetMapping("/country")
    public List<Countries> getCountry() {
    String uri = "https://countriesnow.space/api/v0.1/countries";


    DataResponse response = restTemplate.getForObject(uri, DataResponse.class);

    if (response != null && response.getData() != null) {
        countries = response.getData();
    } else {
        countries = new ArrayList<>();
    }

    return countries;
}


    // @GetMapping("/cities")
    // public List<Countries> getCities() {
    //     return countries.stream().filter(e->e.getCountry().equals("Nigeria")).collect(Collectors.toList());
    // }

    @GetMapping("/cat")
    public String getCatFacts() {
        String uri = "https://catfact.ninja/fact";

        CatFact response = restTemplate.getForObject(uri, CatFact.class);

        if(response != null) {
            cats = response.getFact();
        }
        return cats;
    }

    @GetMapping("/randomusers")
    public List<Users> getUsers() {

        String uri = "https://randomuser.me/api/";
        RandomResponse response = restTemplate.getForObject(uri, RandomResponse.class);

        if(response != null && response.getResults() != null){
            users = response.getResults();
        } else {
        users = new ArrayList<>();
    }
        return users;
    }

    @GetMapping("/posts")
    public List<Posts> getPosts() {
        String uri = "https://jsonplaceholder.typicode.com/posts";

        Posts[] response = restTemplate.getForObject(uri, Posts[].class);

        if (response != null) {
        return Arrays.asList(response); 
    } else {
        return new ArrayList<>();
    }

    }
    
    //Create new post with body
    @PostMapping("/createpost")
    public Posts createPost(@RequestBody Posts post) {
        String uri = "https://jsonplaceholder.typicode.com/posts";
        return restTemplate.postForObject(uri, post, Posts.class);
    }

    //Delete post with param id
    @DeleteMapping("/deletepost")
    public String deletePost(@RequestParam int id) {
    String uri = "https://jsonplaceholder.typicode.com/posts/" + id;

    restTemplate.delete(uri);

    return "Post with ID " + id + " deleted.";
}

    //Update post with body and id
    @PutMapping("/updatepost")
    public ResponseEntity<Posts> updatePost(@RequestParam int id, @RequestBody Posts post) {
        String uri = "https://jsonplaceholder.typicode.com/posts/" + id;
        logger.info("PUT to {} with data: {}", uri, post);

        HttpEntity<Posts> entity = new HttpEntity<>(post);
        ResponseEntity<Posts> response = restTemplate.exchange(uri, HttpMethod.PUT, entity, Posts.class);

        logger.info("Updated post: {}", response.getBody());

        return response;
    }
    
    
    @GetMapping("/info")
    public List<String> getMyName(@RequestParam String name, @RequestParam int age, @RequestParam int height) {
        return Arrays.asList("Name: " + name, "Age: " + age, "Height: " + height);
    }
    
    
}
