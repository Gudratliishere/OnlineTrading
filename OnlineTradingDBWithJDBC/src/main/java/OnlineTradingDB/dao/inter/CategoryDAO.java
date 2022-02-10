package OnlineTradingDB.dao.inter;

import OnlineTradingDB.entity.Category;

import java.util.List;

public interface CategoryDAO
{
    Category add (Category category);
    Category update (Category category);
    void remove (Category category);
    Category getById (Long id);
    List<Category> getAll ();
}
