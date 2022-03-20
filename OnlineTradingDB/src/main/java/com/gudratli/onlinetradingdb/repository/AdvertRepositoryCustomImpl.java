package com.gudratli.onlinetradingdb.repository;

import com.gudratli.onlinetradingdb.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AdvertRepositoryCustomImpl implements AdvertRepositoryCustom
{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Advert> findByCityAndCategoryAndSubcategoryAndKindAndUsedAndPriceBetween (City city,
            Category category, Subcategory subcategory, Kind kind, Boolean used, Integer minPrice,
            Integer maxPrice, Integer minVote)
    {
        StringBuilder query =
                new StringBuilder("select a from Advert a order by publish_date desc where 1 = 1");

        if (city != null)
            query.append(" and a.city = :city");
        if (category != null)
            query.append(" and a.category = :category");
        if (subcategory != null)
            query.append(" and a.subcategory = :subcategory");
        if (kind != null)
            query.append(" and a.kind = :kind");
        if (used != null)
            query.append(" and a.used = :used");
        if (minPrice != null)
            query.append(" and a.price >= :minPrice");
        if (maxPrice != null)
            query.append(" and a.price <= :maxPrice");
        if (minVote != null)
            query.append(" and a.vote >= :minVote");

        Query resultQuery = em.createQuery(query.toString(), Advert.class);

        if (city != null)
            resultQuery.setParameter("city", city);
        if (category != null)
            resultQuery.setParameter("category", category);
        if (subcategory != null)
            resultQuery.setParameter("subcategory", subcategory);
        if (kind != null)
            resultQuery.setParameter("kind", kind);
        if (used != null)
            resultQuery.setParameter("used", used);
        if (minPrice != null)
            resultQuery.setParameter("minPrice", minPrice);
        if (maxPrice != null)
            resultQuery.setParameter("maxPrice", maxPrice);
        if (minVote != null)
            resultQuery.setParameter("minVote", minVote);

        return resultQuery.getResultList();
    }
}
