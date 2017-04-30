package io.github.demirmustafa.init;

import io.github.demirmustafa.dao.BloggerRepository;
import io.github.demirmustafa.model.Blogger;
import io.github.demirmustafa.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 4/29/17.
 */
@Service
public class DataInitializerServiceImpl implements DataInitializerService{

    @Autowired
    private BloggerService bloggerService;
    @Autowired
    private BloggerRepository bloggerRepository;
    private static List<Blogger> bloggers;

    static {
        bloggers = new ArrayList<>();
        Blogger alicanAkkus = new Blogger();
        alicanAkkus.setName("Alican");
        alicanAkkus.setSurname("Akkus");
        alicanAkkus.setUsername("caysever");
        alicanAkkus.setBlogAddress("https://alicanakkus.github.io");
        alicanAkkus.setInterests("JEE, Spring, Hibernate, JPA, SpringBoot");

        Blogger ali = new Blogger();
        ali.setName("Ali Can");
        ali.setSurname("Kuştemur");
        ali.setUsername("kaybeden");
        ali.setInterests("SpringBoot, JSF, MongoDB, SpringData");
        ali.setBlogAddress("http://alicankustemur.github.io");

        Blogger musty = new Blogger();
        musty.setName("Mustafa");
        musty.setSurname("Demir");
        musty.setBlogAddress("https://demirmustafa.github.io");
        musty.setUsername("javalog");
        musty.setInterests("Spring, SpringBoot, Spring Cloud, Microservices, Elasticsearch, Docker");

        bloggers.add(ali);
        bloggers.add(alicanAkkus);
        bloggers.add(musty);
    }

    @PostConstruct
    private void init() {
        String initCheck = System.getProperty("data-initializer");
        if (!CollectionUtils.isEmpty(bloggers) && !StringUtils.isEmpty(initCheck) && initCheck.equals("true"))
            bloggers.forEach(blogger -> bloggerService.addBlogger(blogger));

        bloggerRepository.getBloggersByBlogHostedOn("github");
    }
}

