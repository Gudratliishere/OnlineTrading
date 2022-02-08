package OnlineTradingDB.entity;

import java.util.Date;

public class Advert
{
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Boolean used;
    private Date publishDate;
    private Category category;
    private Subcategory subcategory;
    private Kind kind;
    private User user;
}
