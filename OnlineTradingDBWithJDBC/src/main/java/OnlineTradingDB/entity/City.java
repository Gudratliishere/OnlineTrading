package OnlineTradingDB.entity;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class City
{
    private Long id;
    @NonNull
    private String name;
}
