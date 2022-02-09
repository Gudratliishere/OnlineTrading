package OnlineTradingDB.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Advert
{
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Integer price;
    @NonNull
    private Boolean used;
    @NonNull
    private Date publishDate;
    @NonNull
    private Category category;
    @NonNull
    private Subcategory subcategory;
    @NonNull
    private Kind kind;
    @NonNull
    private User user;
}
