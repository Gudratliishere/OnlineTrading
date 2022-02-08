package OnlineTradingDB.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Image
{
    private Long id;
    @NonNull
    private byte[] image;
    @NonNull
    private Advert advert;
}
