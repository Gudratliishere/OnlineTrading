package OnlineTradingDB.dao.inter;

import OnlineTradingDB.entity.Category;
import OnlineTradingDB.entity.Subcategory;

import java.util.List;

public interface SubcategoryDAO
{
    Subcategory add (Subcategory subcategory);
    Subcategory update (Subcategory subcategory);
    void remove (Subcategory subcategory);
    Subcategory getById (Long id);
    List<Subcategory> getAll ();
    List<Subcategory> getByCategory (Category category);
}
