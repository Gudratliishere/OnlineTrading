package OnlineTradingDB.dao.impl;

import OnlineTradingDB.configuration.Context;
import OnlineTradingDB.dao.inter.AdvertDAO;
import OnlineTradingDB.dao.inter.ImageDAO;
import OnlineTradingDB.entity.Advert;
import OnlineTradingDB.entity.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static OnlineTradingDB.configuration.Config.connect;
import static OnlineTradingDB.configuration.LoggerUtil.addFileWriter;

public class ImageDAOImpl implements ImageDAO
{
    private static final Logger LOG = addFileWriter(Logger.getLogger(ImageDAOImpl.class.getName()));
    private final AdvertDAO advertDAO = Context.getAdvertDAO();

    @Override
    public Image add (Image image)
    {
        String query = "insert into image (image, advert) values (?, ?);";
        String queryForId = "select LAST_INSERT_ID();";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBytes(1, image.getImage());
            preparedStatement.setLong(2, image.getAdvert().getId());
            preparedStatement.execute();

            PreparedStatement preparedStatementForId = connection.prepareStatement(queryForId);
            preparedStatementForId.execute();

            ResultSet resultSet = preparedStatementForId.getResultSet();
            if (resultSet.next())
                image.setId(resultSet.getLong(1));
            return image;
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while inserting new data to image.", ex);
            return null;
        }
    }

    @Override
    public Image update (Image image)
    {
        String query = "update image set image = ?, advert = ? where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBytes(1, image.getImage());
            preparedStatement.setLong(2, image.getAdvert().getId());
            preparedStatement.setLong(3, image.getId());
            if (!preparedStatement.execute())
                return image;
            else
                throw new Exception("Can not update image.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while updating image with '" + image.getId() + "' id.", ex);
            return null;
        }
    }

    @Override
    public void remove (Image image)
    {
        String query = "delete from image where id = ?";

        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, image.getId());
            if (preparedStatement.execute())
                throw new Exception("Can not delete data.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while deleting data from image with '" + image.getId() + "' id.0, ex");
        }
    }

    @Override
    public Image getById (Long id)
    {
        String query = "select * from image where id = ?";

        Image image = null;
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next())
            {
                image = new Image();
                fillImageWithRS(image, resultSet);
            }
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from image with '" + id + "' id.", ex);
        }

        return image;
    }

    @Override
    public List<Image> getAll ()
    {
        String query = "select * from image";

        List<Image> images = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            readResultSet(preparedStatement.getResultSet(), images);
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching all data from image.", ex);
        }

        return images;
    }

    @Override
    public List<Image> getByAdvert (Advert advert)
    {
        String query = "select * from image where advert = ?";

        List<Image> images = new ArrayList<>();
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, advert.getId());
            preparedStatement.execute();

            readResultSet(preparedStatement.getResultSet(), images);
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while fetching data from image with '" + advert.getId() + "' id.", ex);
        }

        return images;
    }

    private void readResultSet (ResultSet resultSet, List<Image> images) throws SQLException
    {
        while (resultSet.next())
        {
            Image image = new Image();
            fillImageWithRS(image, resultSet);
            images.add(image);
        }
    }

    private void fillImageWithRS (Image image, ResultSet resultSet) throws SQLException
    {
        image.setId(resultSet.getLong("id"));
        image.setImage(resultSet.getBytes("image"));
        image.setAdvert(advertDAO.getById(resultSet.getLong("advert")));
    }
}
