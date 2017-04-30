package io.github.demirmustafa.service;

import io.github.demirmustafa.dao.BloggerRepository;
import io.github.demirmustafa.model.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Created by mustafa on 4/29/17.
 */
@Service
public class BloggerServiceImpl implements BloggerService{

    @Autowired
    private BloggerRepository bloggerRepository;

    @Override
    public Blogger findBloggerByName(String name) {
        return bloggerRepository.findBloggerByName(name);
    }

    @Override
    public Blogger findBloggerById(String id) {
        return bloggerRepository.findOne(id);
    }

    @Override
    public List<Blogger> findAllBloggers() {
        return bloggerRepository.findAll();
    }

    @Override
    public List<Blogger> findBloggersByInterests(String interests) {
        return bloggerRepository.findBloggersByInterestsIn(interests);
    }

    @Override
    public HttpStatus addBlogger(Blogger blogger) {
        Blogger insertedBlogger = bloggerRepository.insert(blogger);
        if(ObjectUtils.nullSafeEquals(blogger,insertedBlogger))
            return HttpStatus.OK;
        return HttpStatus.EXPECTATION_FAILED;
    }

    @Override
    public HttpStatus deleteBloggerByName(String name) {
        return bloggerRepository.deleteBloggerByName(name) ? HttpStatus.OK: HttpStatus.EXPECTATION_FAILED;
    }

    @Override
    public Blogger findBloggerByUsername(String username) {
        return bloggerRepository.findByUsername(username);
    }

    @Override
    public List<Blogger> getBloggersByInterests(String interest) {
        return bloggerRepository.getByInterests(interest);
    }
}
