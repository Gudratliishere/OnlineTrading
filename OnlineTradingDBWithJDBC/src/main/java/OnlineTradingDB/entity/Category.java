package OnlineTradingDB.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Category
{
    private Long id;
    @NonNull
    private String name;
}
