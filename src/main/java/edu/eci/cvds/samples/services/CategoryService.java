package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Category;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface CategoryService {
    public abstract void pushCategory(Category category) throws SolidaridadException;

    public abstract List<Category> searchCategories() throws SolidaridadException;

    public abstract void updateCategory(String categoryName, String name, String description, String state) throws SolidaridadException, PSQLException;
    public abstract void deleteCategory(String name, int idCategory) throws SolidaridadException;

    Category searchCategory(String name) throws SolidaridadException;
    int searchNumberCategory(String category);
    
}