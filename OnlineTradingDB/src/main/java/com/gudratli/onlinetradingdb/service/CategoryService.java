package com.gudratli.onlinetradingdb.service;

import com.gudratli.onlinetradingdb.entity.Category;
import com.gudratli.onlinetradingdb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    public List<Category> getAll ()
    {
        return categoryRepository.findAll();
    }

    public Category getById (Long id)
    {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category update (Category category)
    {
        return categoryRepository.save(category);
    }

    public Category add (Category category)
    {
        return categoryRepository.save(category);
    }

    public void remove (Category category)
    {
        categoryRepository.delete(category);
    }
}
