package OnlineTradingDB.configuration;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LoggerUtil
{
    private static String logPath = "src\\main\\resources\\app.log";

    public static Logger addFileWriter (Logger log)
    {
        initFileWriter(log);
        return log;
    }

    private static void initFileWriter (Logger log)
    {
        try
        {
            FileHandler fileHandler = new FileHandler(logPath, true);
            log.addHandler(fileHandler);
        } catch (IOException e)
        {
            createLogFile();
        }
    }

    private static void createLogFile ()
    {
        File file = new File(logPath);
        try
        {
            file.createNewFile();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
