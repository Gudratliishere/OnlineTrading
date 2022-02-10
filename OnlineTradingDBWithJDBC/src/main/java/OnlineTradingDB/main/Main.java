package OnlineTradingDB.main;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.CategoryDAO;
import OnlineTradingDB.dao.inter.SubcategoryDAO;
import OnlineTradingDB.entity.Category;
import OnlineTradingDB.entity.Subcategory;

public class Main
{
    public static void main (String[] args)
    {
        CategoryDAO categoryDAO = Context.getCategoryDAO();

        Category category = categoryDAO.getById(9L);


        SubcategoryDAO subcategoryDAO = Context.getSubcategoryDAO();

        Subcategory subcategory = subcategoryDAO.getById(4L);
        subcategoryDAO.remove(subcategory);
    }
}
