package com.gudratli.onlinetradingdb.service;

import com.gudratli.onlinetradingdb.entity.Advert;
import com.gudratli.onlinetradingdb.entity.Image;
import com.gudratli.onlinetradingdb.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService
{
    private final ImageRepository imageRepository;

    public List<Image> getAll ()
    {
        return imageRepository.findAll();
    }

    public List<Image> getByAdvert (Advert advert)
    {
        return imageRepository.findByAdvert(advert);
    }

    public Image getById (Long id)
    {
        return imageRepository.findById(id).orElse(null);
    }

    public Image update (Image image)
    {
        return imageRepository.save(image);
    }

    public Image add (Image image)
    {
        return imageRepository.save(image);
    }

    public void remove (Image image)
    {
        imageRepository.delete(image);
    }
}
