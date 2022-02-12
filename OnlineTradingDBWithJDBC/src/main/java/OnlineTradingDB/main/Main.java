package OnlineTradingDB.main;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.KindDAO;
import OnlineTradingDB.dao.inter.SubcategoryDAO;
import OnlineTradingDB.entity.Kind;
import OnlineTradingDB.entity.Subcategory;

public class Main
{
    public static void main (String[] args)
    {
        SubcategoryDAO subcategoryDAO = Context.getSubcategoryDAO();
        Subcategory subcategory = subcategoryDAO.getById(3L);

        KindDAO kindDAO = Context.getKindDAO();

        Kind kind = kindDAO.getById(4L);
        kindDAO.remove(kind);
    }
}
