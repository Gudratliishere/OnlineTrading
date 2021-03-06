package OnlineTradingDB.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Subcategory
{
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Category category;
}
