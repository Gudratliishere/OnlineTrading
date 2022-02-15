package OnlineTradingDB.configuration;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config
{
    private final static Logger LOG = Logger.getLogger(Config.class.getName());
    private static Config config = null;
    private final String connectionConfigFilePath = "src\\main\\resources\\database_configuration.xml";
    private Connection connection = null;

    private Config ()
    {
        initDatabase();
    }

    public static Config getConfig ()
    {
        if (config == null)
            config = new Config();
        return config;
    }

    public static java.sql.Connection connect () throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = Config.getConfig().getConnection();
        return DriverManager.getConnection(connection.getUrl(), connection.Decrypt(connection.getUsername()),
                connection.Decrypt(connection.getPassword()));
    }

    public void initDatabase ()
    {
        DatabaseInitializer.initDatabase();
    }

    public Connection getConnection ()
    {
        if (connection != null)
            return connection;

        connection = new Connection();
        File file = new File(connectionConfigFilePath);
        if (file.exists() && !file.isDirectory())
            readXML(file, connection);
        else
            fillConnectionWithDefault(connection);

        return connection;
    }

    private void readXML (File file, Connection connection)
    {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("details");

            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                    readElements(node, connection);
            }
        } catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Exception occurred while reading 'database_configuration.xml' file.\n", e);
        }
    }

    private void readElements (Node node, Connection connection)
    {
        Element element = (Element) node;
        connection.setUrl(element.getElementsByTagName("url")
                .item(0).getTextContent());
        connection.setUsername(element.getElementsByTagName("username")
                .item(0).getTextContent());
        connection.setPassword(element.getElementsByTagName("password")
                .item(0).getTextContent());
        connection.setCryptPower(Integer.parseInt(element.getElementsByTagName("crypt_power")
                .item(0).getTextContent()));
    }

    private void fillConnectionWithDefault (Connection connection)
    {
        connection.setUrl("jdbc:mysql://localhost:3306/online_trading");
        connection.setUsername("root");
        connection.setPassword("2002");
        connection.setCryptPower(4);
    }
}
