package io.github.demirmustafa.dao;

import io.github.demirmustafa.model.Blogger;

import java.util.List;

/**
 * Created by mustafa on 4/29/17.
 */
public interface BloggerDAO {

    List<Blogger> getBloggersByBlogHostedOn(String host);
}
