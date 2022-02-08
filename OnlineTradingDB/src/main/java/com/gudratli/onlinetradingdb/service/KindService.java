package com.gudratli.onlinetradingdb.service;

import com.gudratli.onlinetradingdb.entity.Kind;
import com.gudratli.onlinetradingdb.repository.KindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KindService
{
    private final KindRepository kindRepository;

    public List<Kind> getAll ()
    {
        return kindRepository.findAll();
    }

    public Kind getById (Long id)
    {
        return kindRepository.findById(id).orElse(null);
    }

    public Kind update (Kind kind)
    {
        return kindRepository.save(kind);
    }

    public Kind add (Kind kind)
    {
        return kindRepository.save(kind);
    }

    public void remove (Kind kind)
    {
        kindRepository.delete(kind);
    }
}
