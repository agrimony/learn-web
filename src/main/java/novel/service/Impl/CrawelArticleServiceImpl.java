package novel.service.Impl;

import novel.dao.CrawelArticleMapper;
import novel.model.CrawelArticle;
import novel.service.CrawelArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hou on 12/25/16.
 */
@Service
public class CrawelArticleServiceImpl implements CrawelArticleService {
    @Resource
    private CrawelArticleMapper crawelArticleMapper;
    @Override
    public CrawelArticle selectCrawelArticleById(int id) {
        return crawelArticleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CrawelArticle> selectCrawelArticlesByBookId(int bookid) {
        return  crawelArticleMapper.selectArticlesByBookId(bookid);
    }

    @Override
    public int updateCrawelArticleStatus(CrawelArticle record) {
        return crawelArticleMapper.updateCrawelArticleStatus(record);
    }

    @Override
    public int insertCrawelArticle(CrawelArticle article) {
        return crawelArticleMapper.insert(article);
    }
}
