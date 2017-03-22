package novel.service;

import novel.model.CrawelBook;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hou on 12/20/16.
 */
@Service
public interface CrawelBookService {
    boolean addCrawelBook(CrawelBook book);

    void updateCrawelBook(CrawelBook book);

    void addCrawelBookBatch(List<CrawelBook> books);

    List<CrawelBook> selectCrawelBooksByName(String name);

    CrawelBook selectByPrimaryKey(int id);

    List<CrawelBook> list(int startIndex, int endIndex);

    List<CrawelBook> list();

    int getCrawelBookCount();
}
