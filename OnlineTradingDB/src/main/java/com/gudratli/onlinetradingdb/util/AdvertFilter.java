package com.gudratli.onlinetradingdb.util;

import com.gudratli.onlinetradingdb.entity.Category;
import com.gudratli.onlinetradingdb.entity.City;
import com.gudratli.onlinetradingdb.entity.Kind;
import com.gudratli.onlinetradingdb.entity.Subcategory;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AdvertFilter
{
    private City city = null;
    private Category category = null;
    private Subcategory subcategory = null;
    private Kind kind = null;
    private Boolean used = null;
    private Integer minPrice = null;
    private Integer maxPrice = null;
    private Integer minVote;

    private AdvertFilter () {}

    public static AdvertFilter create ()
    {
        return new AdvertFilter();
    }

    public AdvertFilter addCity (City city)
    {
        this.city = city;
        return this;
    }

    public AdvertFilter addCategory (Category category)
    {
        this.category = category;
        return this;
    }

    public AdvertFilter addSubcategory (Subcategory subcategory)
    {
        this.subcategory = subcategory;
        return this;
    }

    public AdvertFilter addKind (Kind kind)
    {
        this.kind = kind;
        return this;
    }

    public AdvertFilter addUsed (boolean used)
    {
        this.used = used;
        return this;
    }

    public AdvertFilter addMinPrice (Integer minPrice)
    {
        this.minPrice = minPrice;
        return this;
    }

    public AdvertFilter addMaxPrice (Integer maxPrice)
    {
        this.maxPrice = maxPrice;
        return this;
    }

    public AdvertFilter addMinVote (Integer minVote)
    {
        this.minVote = minVote;
        return this;
    }
}
