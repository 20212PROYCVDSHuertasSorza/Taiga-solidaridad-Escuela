package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.InvalidCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface InvalidCategoryMapper {
    List<InvalidCategory> searchInvalidCategories();

    InvalidCategory searchInvalidCategory(@Param("word") String word);

}