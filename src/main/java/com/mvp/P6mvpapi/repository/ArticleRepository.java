package com.mvp.P6mvpapi.repository;

import com.mvp.P6mvpapi.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}