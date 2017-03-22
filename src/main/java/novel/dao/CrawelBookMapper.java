package novel.dao;

import novel.model.CrawelBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrawelBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawelBook record);

    int insertSelective(CrawelBook record);

    CrawelBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawelBook record);

    int updateByPrimaryKey(CrawelBook record);

    int addCrawelBookBatch(List<CrawelBook> books);
    List<CrawelBook> selectCrawelBooksByName(String name);
    List<CrawelBook> list(@Param("startIndex")int startIndex,@Param("endIndex") int endIndex);
    List<CrawelBook> list();
    int getCrawelBookCount();
}