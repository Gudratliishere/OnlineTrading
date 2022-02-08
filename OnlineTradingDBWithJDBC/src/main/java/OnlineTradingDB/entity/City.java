package OnlineTradingDB.entity;

import lombok.*;

@Data
public class City
{
    private Long id;
    @NonNull
    private String name;
}
