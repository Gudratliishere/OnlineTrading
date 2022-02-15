package OnlineTradingDB.service;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.SubcategoryDAO;
import OnlineTradingDB.entity.Category;
import OnlineTradingDB.entity.Subcategory;

import java.util.List;

public class SubcategoryService
{
    private final SubcategoryDAO subcategoryDAO = Context.getSubcategoryDAO();

    public Subcategory add (Subcategory subcategory)
    {
        return subcategoryDAO.add(subcategory);
    }

    public Subcategory update (Subcategory subcategory)
    {
        return subcategoryDAO.update(subcategory);
    }

    public void remove (Subcategory subcategory)
    {
        subcategoryDAO.remove(subcategory);
    }

    public Subcategory getById (Long id)
    {
        return subcategoryDAO.getById(id);
    }

    public List<Subcategory> getAll ()
    {
        return subcategoryDAO.getAll();
    }

    public List<Subcategory> getByCategory (Category category)
    {
        return subcategoryDAO.getByCategory(category);
    }
}
