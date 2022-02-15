package OnlineTradingDB.service;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.ImageDAO;
import OnlineTradingDB.entity.Advert;
import OnlineTradingDB.entity.Image;

import java.util.List;

public class ImageService
{
    private final ImageDAO imageDAO = Context.getImageDAO();

    public Image add (Image image)
    {
        return imageDAO.add(image);
    }

    public Image update (Image image)
    {
        return imageDAO.update(image);
    }

    public void remove (Image image)
    {
        imageDAO.remove(image);
    }

    public Image getById (Long id)
    {
        return imageDAO.getById(id);
    }

    public List<Image> getAll ()
    {
        return imageDAO.getAll();
    }

    public List<Image> getByAdvert (Advert advert)
    {
        return imageDAO.getByAdvert(advert);
    }
}
