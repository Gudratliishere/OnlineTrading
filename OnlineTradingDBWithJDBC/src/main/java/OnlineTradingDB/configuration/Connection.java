package OnlineTradingDB.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Connection
{
    private String url;
    private String username;
    private String password;
    private int cryptPower;

    public String Encrypt (String data)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++)
            sb.append((char) (data.charAt(i) + cryptPower));

        return sb.toString();
    }

    public String Decrypt (String data)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++)
            sb.append((char) (data.charAt(i) - cryptPower));

        return sb.toString();
    }
}
