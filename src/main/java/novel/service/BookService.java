package novel.service;

import novel.model.Book;

import java.util.List;

/**
 * Created by hou on 12/20/16.
 */
public interface BookService {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}
