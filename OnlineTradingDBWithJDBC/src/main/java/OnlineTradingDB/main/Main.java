package OnlineTradingDB.main;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.CategoryDAO;
import OnlineTradingDB.entity.Category;

public class Main
{
    public static void main (String[] args)
    {
        CategoryDAO categoryDAO = Context.getCategoryDAO();

        Category category = categoryDAO.getById(8L);
        categoryDAO.remove(category);
    }
}
