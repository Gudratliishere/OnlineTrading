package OnlineTradingDB.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Subcategory
{
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Category category;
}
