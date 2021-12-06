package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import java.util.List;
import edu.eci.cvds.samples.entities.Category;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    void pushCategory(@Param("category") Category category);

    void popCategory(@Param("name") String name,@Param("idCategory") int idCategory);

    List<Category> searchCategories();

    Category searchCategory(@Param("name") String name);

    List<Category> searchNumberCategory(@Param("category") String category);

    void update(@Param("category") Category category, @Param("aName") String aName);
}