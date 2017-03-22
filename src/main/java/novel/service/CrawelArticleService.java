package novel.service;

import novel.model.CrawelArticle;

import java.util.List;

/**
 * Created by hou on 12/25/16.
 */
public interface CrawelArticleService {
CrawelArticle selectCrawelArticleById(int id);
    List<CrawelArticle> selectCrawelArticlesByBookId(int bookid);
    int updateCrawelArticleStatus(CrawelArticle record);
    int insertCrawelArticle(CrawelArticle article);
}
