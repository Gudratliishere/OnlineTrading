package OnlineTradingDB.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static OnlineTradingDB.configuration.Config.connect;
import static OnlineTradingDB.configuration.LoggerUtil.addFileWriter;

public class DatabaseInitializer
{
    private static final Logger LOG = addFileWriter(Logger.getLogger(DatabaseInitializer.class.getName()));

    public static void initDatabase ()
    {
        createCityTable();
        createUserTable();
        createCategoryTable();
        createSubcategoryTable();
        createKindTable();
        createAdvertTable();
        createImageTable();
    }

    private static void runQuery (String query)
    {
        try (Connection connection = connect())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (preparedStatement.execute())
                throw new Exception("Can not create table.");
        } catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error occurred while creating table. Query is *** \n" +
                    query, ex);
        }
    }

    private static void createCityTable ()
    {
        String query = "CREATE TABLE IF NOT EXISTS `city` (\n" +
                "  `id` bigint NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "SET FOREIGN_KEY_CHECKS = 1;\n";

        runQuery(query);
    }

    private static void createUserTable ()
    {
        String query = "CREATE TABLE IF NOT EXISTS `user` IF NOT EXISTS (\n" +
                "  `id` bigint NOT NULL AUTO_INCREMENT,\n" +
                "  `mail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  `phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  `surname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  `city` bigint NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `FKeal5g2o4amn2om6d2t00o9nqb`(`city`) USING BTREE,\n" +
                "  CONSTRAINT `FKeal5g2o4amn2om6d2t00o9nqb` FOREIGN KEY (`city`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON " +
                "  UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "SET FOREIGN_KEY_CHECKS = 1;\n";

        runQuery(query);
    }

    private static void createCategoryTable ()
    {
        String query = "CREATE TABLE IF NOT EXISTS `category`  (\n" +
                "  `id` bigint NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "SET FOREIGN_KEY_CHECKS = 1;\n";

        runQuery(query);
    }

    private static void createSubcategoryTable ()
    {
        String query = "CREATE TABLE IF NOT EXISTS `subcategory`  (\n" +
                "  `id` bigint NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  `category` bigint NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `FKdsi5hyx3uwi4cupffyc57i9d2`(`category`) USING BTREE,\n" +
                "  CONSTRAINT `FKdsi5hyx3uwi4cupffyc57i9d2` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON " +
                "  UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "SET FOREIGN_KEY_CHECKS = 1;\n";

        runQuery(query);
    }

    private static void createKindTable ()
    {
        String query = "CREATE TABLE IF NOT EXISTS `kind`  (\n" +
                "  `id` bigint NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  `subcategory` bigint NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `FKtmeet4ut6bub19089cvp4kx4`(`subcategory`) USING BTREE,\n" +
                "  CONSTRAINT `FKtmeet4ut6bub19089cvp4kx4` FOREIGN KEY (`subcategory`) REFERENCES `subcategory` (`id`) ON " +
                "  DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "SET FOREIGN_KEY_CHECKS = 1;\n";

        runQuery(query);
    }

    private static void createAdvertTable ()
    {
        String query = "CREATE TABLE IF NOT EXISTS `advert`  (\n" +
                "  `id` bigint NOT NULL AUTO_INCREMENT,\n" +
                "  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,\n" +
                "  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,\n" +
                "  `price` int NULL DEFAULT NULL,\n" +
                "  `category` bigint NULL DEFAULT NULL,\n" +
                "  `city` bigint NULL DEFAULT NULL,\n" +
                "  `kind` bigint NULL DEFAULT NULL,\n" +
                "  `subcategory` bigint NULL DEFAULT NULL,\n" +
                "  `user` bigint NULL DEFAULT NULL,\n" +
                "  `used` int NULL DEFAULT NULL,\n" +
                "  `publish_date` datetime(6) NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `FKr7k2lqr8jhl9s8buc0qr55b8f`(`category`) USING BTREE,\n" +
                "  INDEX `FK3i80prjlp3kqw09nip1t58325`(`city`) USING BTREE,\n" +
                "  INDEX `FK9qm5kjgljljtnsl20ivgnvrrm`(`kind`) USING BTREE,\n" +
                "  INDEX `FKcgsrqglq5ootb9o99smgn45dr`(`subcategory`) USING BTREE,\n" +
                "  INDEX `FKtnp6q0091c7rp5o7dtyixjvay`(`user`) USING BTREE,\n" +
                "  CONSTRAINT `FK3i80prjlp3kqw09nip1t58325` FOREIGN KEY (`city`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON " +
                "  UPDATE RESTRICT,\n" +
                "  CONSTRAINT `FK9qm5kjgljljtnsl20ivgnvrrm` FOREIGN KEY (`kind`) REFERENCES `kind` (`id`) ON DELETE RESTRICT ON " +
                "  UPDATE RESTRICT,\n" +
                "  CONSTRAINT `FKcgsrqglq5ootb9o99smgn45dr` FOREIGN KEY (`subcategory`) REFERENCES `subcategory` (`id`) ON DELETE " +
                "  RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `FKr7k2lqr8jhl9s8buc0qr55b8f` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE RESTRICT " +
                "  ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `FKtnp6q0091c7rp5o7dtyixjvay` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE " +
                "  RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "SET FOREIGN_KEY_CHECKS = 1;\n";

        runQuery(query);
    }

    private static void createImageTable ()
    {
        String query = "CREATE TABLE IF NOT EXISTS `image`  (\n" +
                "  `id` bigint NOT NULL AUTO_INCREMENT,\n" +
                "  `image` blob NULL,\n" +
                "  `advert` bigint NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `FKhycrjy05dpuyxrdfqrcvunwp9`(`advert`) USING BTREE,\n" +
                "  CONSTRAINT `FKhycrjy05dpuyxrdfqrcvunwp9` FOREIGN KEY (`advert`) REFERENCES `advert` (`id`) ON DELETE RESTRICT ON " +
                "  UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "SET FOREIGN_KEY_CHECKS = 1;\n";

        runQuery(query);
    }
}
