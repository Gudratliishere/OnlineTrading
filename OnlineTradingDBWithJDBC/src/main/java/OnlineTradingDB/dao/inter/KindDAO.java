package OnlineTradingDB.dao.inter;

import OnlineTradingDB.entity.Kind;
import OnlineTradingDB.entity.Subcategory;

import java.util.List;

public interface KindDAO
{
    Kind add (Kind kind);
    Kind update (Kind kind);
    void remove (Kind kind);
    Kind getById (Long id);
    List<Kind> getAll ();
    List<Kind> getBySubcategory (Subcategory subcategory);
}
