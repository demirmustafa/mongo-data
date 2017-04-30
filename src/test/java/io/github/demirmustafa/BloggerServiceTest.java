package io.github.demirmustafa;

import io.github.demirmustafa.dao.BloggerRepository;
import io.github.demirmustafa.model.Blogger;
import io.github.demirmustafa.service.BloggerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by mustafa on 4/29/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BloggerServiceTest {

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private BloggerRepository bloggerRepository;

    @Test
    public void addBloggerTest(){
        HttpStatus status = HttpStatus.OK;
        Blogger blogger = new Blogger();
        blogger.setName("İlkay");
        blogger.setSurname("Günel");
        blogger.setUsername("Üstad");
        blogger.setBlogAddress("ilkaygunel.com");
        blogger.setBlogHostedOn("github");
        blogger.setInterests("JSF, TDD, Spring, Rest");

        HttpStatus response = bloggerService.addBlogger(blogger);
        Assert.assertEquals(status, response);
    }

    @Test
    public void hostTest(){
        List<Blogger> bloggers = bloggerRepository.getBloggersByBlogHostedOn("github");
        Assert.assertNotNull(bloggers);
    }
}
