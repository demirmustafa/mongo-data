package io.github.demirmustafa.controller;

import io.github.demirmustafa.model.Blogger;
import io.github.demirmustafa.service.BloggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mustafa on 4/29/17.
 */
@RestController
@Api(basePath = "/", value = "Blogger Api", description = "Blogger Api Description")
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    @ApiOperation(value = "Gets Blogger By Id", httpMethod = "GET")
    @GetMapping(value = "/blogger/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Blogger getBloggerById(@PathVariable("id") String id){
        return bloggerService.findBloggerById(id);
    }

    @GetMapping(value = "/blogger/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Blogger getBloggerByName(@PathVariable("name") String name){
        return bloggerService.findBloggerByName(name);
    }

    @PutMapping(value = "/blogger/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addBlogger(@RequestBody Blogger blogger){
        return bloggerService.addBlogger(blogger);
    }

    @DeleteMapping(value = "/blogger/delete/name/{name}")
    public HttpStatus deleteBloggerById(@PathVariable("name") String name){
        return bloggerService.deleteBloggerByName(name);
    }

    @GetMapping(value = "/bloggers")
    public List<Blogger> getAllBloggers(){
        return bloggerService.findAllBloggers();
    }
    @GetMapping(value = "/bloggersByInterests/{interest}")
    public List<Blogger> getBloggersByInterests(@PathVariable("interest") String interestedIn){
        return bloggerService.findBloggersByInterests(interestedIn);
    }


}
