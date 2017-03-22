package novel.service.Impl;

import novel.dao.BookInfoMapper;
import novel.model.BookInfo;
import novel.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hou on 12/25/16.
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Resource
    private BookInfoMapper bookInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bookInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BookInfo record) {
        return bookInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(BookInfo record) {
        return bookInfoMapper.insertSelective(record);
    }

    @Override
    public BookInfo selectByPrimaryKey(Integer id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BookInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(BookInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(BookInfo record) {
        return 0;
    }
}
