package novel.service.Impl;

import novel.dao.CrawelBookMapper;
import novel.model.CrawelBook;
import novel.service.CrawelBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hou on 12/20/16.
 */
@Service
public class CrawelBookServiceImpl implements CrawelBookService {
    @Resource
    private CrawelBookMapper crawelBookMapper;

    @Override
    public boolean addCrawelBook(CrawelBook book) {
        List<CrawelBook> crawelBooks=crawelBookMapper.selectCrawelBooksByName(book.getBookName());
        if(crawelBooks.size()>0) {
            return false;
        }else{
            crawelBookMapper.insert(book);
            return  true;
        }
    }

    @Override
    public void updateCrawelBook(CrawelBook book) {
        crawelBookMapper.updateByPrimaryKey(book);
    }

    @Override
    public void addCrawelBookBatch(List<CrawelBook> books) {
        crawelBookMapper.addCrawelBookBatch(books);
    }

    @Override
    public List<CrawelBook> selectCrawelBooksByName(String name) {
        return crawelBookMapper.selectCrawelBooksByName(name);
    }

    @Override
    public CrawelBook selectByPrimaryKey(int id) {
        return crawelBookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CrawelBook> list(int startIndex, int endIndex) {
        return crawelBookMapper.list(startIndex, endIndex);
    }
    @Override
    public List<CrawelBook> list() {
        return crawelBookMapper.list();
    }
    @Override
    public int getCrawelBookCount() {
        return crawelBookMapper.getCrawelBookCount();
    }
}
