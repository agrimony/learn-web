package novel.dao;

import novel.model.CrawelArticle;

import java.util.List;

public interface CrawelArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawelArticle record);

    int insertSelective(CrawelArticle record);

    CrawelArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawelArticle record);

    int updateByPrimaryKey(CrawelArticle record);

    List<CrawelArticle> selectArticlesByBookId(Integer bookId);
    int updateStatusByPrimaryKey(Integer id);
    int updateCrawelArticleStatus(CrawelArticle record);
}