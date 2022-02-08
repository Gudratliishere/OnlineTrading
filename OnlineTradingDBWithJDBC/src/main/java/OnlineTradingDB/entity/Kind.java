package OnlineTradingDB.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Kind
{
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Subcategory subcategory;
}
