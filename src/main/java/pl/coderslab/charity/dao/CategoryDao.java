package pl.coderslab.charity.dao;

import pl.coderslab.charity.entity.Category;

public class CategoryDao extends GenericDao<Category> {

    public CategoryDao() {
        super(Category.class);
    }
}
