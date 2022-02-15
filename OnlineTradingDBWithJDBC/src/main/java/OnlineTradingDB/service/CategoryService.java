package OnlineTradingDB.service;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.CategoryDAO;
import OnlineTradingDB.entity.Category;

import java.util.List;

public class CategoryService
{
    private final CategoryDAO categoryDAO = Context.getCategoryDAO();

    public Category add (Category category)
    {
        return categoryDAO.add(category);
    }

    public Category update (Category category)
    {
        return categoryDAO.update(category);
    }

    public void remove (Category category)
    {
        categoryDAO.remove(category);
    }

    public Category getById (Long id)
    {
        return categoryDAO.getById(id);
    }

    public List<Category> getAll ()
    {
        return categoryDAO.getAll();
    }
}
