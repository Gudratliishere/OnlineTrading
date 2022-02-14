package OnlineTradingDB.main;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.*;

public class Main
{
    private static final CategoryDAO categoryDAO = Context.getCategoryDAO();
    private static final SubcategoryDAO subcategoryDAO = Context.getSubcategoryDAO();
    private static final KindDAO kindDAO = Context.getKindDAO();
    private static final UserDAO userDAO = Context.getUserDAO();
    private static final CityDAO cityDAO = Context.getCityDAO();
    private static final AdvertDAO advertDAO = Context.getAdvertDAO();

    public static void main (String[] args)
    {

    }
}
