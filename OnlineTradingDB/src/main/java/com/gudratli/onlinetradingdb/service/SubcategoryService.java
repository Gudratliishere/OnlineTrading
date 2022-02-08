package com.gudratli.onlinetradingdb.service;

import com.gudratli.onlinetradingdb.entity.Subcategory;
import com.gudratli.onlinetradingdb.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryService
{
    private final SubcategoryRepository subcategoryRepository;

    public List<Subcategory> getAll ()
    {
        return subcategoryRepository.findAll();
    }

    public Subcategory getById (Long id)
    {
        return subcategoryRepository.findById(id).orElse(null);
    }

    public Subcategory update (Subcategory subcategory)
    {
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory add (Subcategory subcategory)
    {
        return subcategoryRepository.save(subcategory);
    }

    public void remove (Subcategory subcategory)
    {
        subcategoryRepository.delete(subcategory);
    }
}
