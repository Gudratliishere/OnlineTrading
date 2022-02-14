package OnlineTradingDB.dao.inter;

import OnlineTradingDB.entity.Advert;
import OnlineTradingDB.entity.Image;

import java.util.List;

public interface ImageDAO
{
    Image add (Image image);
    Image update (Image image);
    void remove (Image image);
    Image getById (Long id);
    List<Image> getAll ();
    List<Image> getByAdvert(Advert advert);
}
