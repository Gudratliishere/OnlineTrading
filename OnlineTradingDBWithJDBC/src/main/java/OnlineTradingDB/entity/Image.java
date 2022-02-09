package OnlineTradingDB.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Image
{
    private Long id;
    @NonNull
    private byte[] image;
    @NonNull
    private Advert advert;
}
