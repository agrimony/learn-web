package novel.dao;

import novel.model.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Byte id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}