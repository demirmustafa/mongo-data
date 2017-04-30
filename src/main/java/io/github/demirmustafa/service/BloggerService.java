package io.github.demirmustafa.service;

import io.github.demirmustafa.model.Blogger;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by mustafa on 4/29/17.
 */
public interface BloggerService {

    Blogger findBloggerByName(String name);
    Blogger findBloggerById(String id);
    List<Blogger> findAllBloggers();
    List<Blogger> findBloggersByInterests(String interests);
    HttpStatus addBlogger(Blogger blogger);
    HttpStatus deleteBloggerByName(String name);
    Blogger findBloggerByUsername(String username);
    List<Blogger> getBloggersByInterests(String interest);
}
