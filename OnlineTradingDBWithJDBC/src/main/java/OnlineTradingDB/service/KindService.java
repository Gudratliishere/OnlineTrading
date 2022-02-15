package OnlineTradingDB.service;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.KindDAO;
import OnlineTradingDB.entity.Kind;
import OnlineTradingDB.entity.Subcategory;

import java.util.List;

public class KindService
{
    private final KindDAO kindDAO = Context.getKindDAO();

    public Kind add (Kind kind)
    {
        return kindDAO.add(kind);
    }

    public Kind update (Kind kind)
    {
        return kindDAO.update(kind);
    }

    public void remove (Kind kind)
    {
        kindDAO.remove(kind);
    }

    public Kind getById (Long id)
    {
        return kindDAO.getById(id);
    }

    public List<Kind> getAll ()
    {
        return kindDAO.getAll();
    }

    public List<Kind> getBySubcategory (Subcategory subcategory)
    {
        return kindDAO.getBySubcategory(subcategory);
    }
}
