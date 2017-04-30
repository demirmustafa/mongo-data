package io.github.demirmustafa.dao;

import io.github.demirmustafa.model.Blogger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by mustafa on 4/29/17.
 */
public interface BloggerRepository extends MongoRepository<Blogger,String>, BloggerDAO {

    Blogger findBloggerByName(String name);
    @Query(value = "{$text: {$search: ?0}}")
    List<Blogger> findBloggersByInterestsIn(String interests);
    boolean deleteBloggerByName(String name);
    Blogger findByUsername(String username);
    List<Blogger> getByInterests(String interests);
}
