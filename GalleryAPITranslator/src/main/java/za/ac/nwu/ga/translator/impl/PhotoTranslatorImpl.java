package za.ac.nwu.ga.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.domain.dto.PhotoDto;
import za.ac.nwu.ga.domain.persistence.MemberInfo;
import za.ac.nwu.ga.domain.persistence.Photo;
import za.ac.nwu.ga.repo.persistence.PhotoRepository;
import za.ac.nwu.ga.translator.PhotoTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhotoTranslatorImpl implements PhotoTranslator
{

    PhotoRepository photoRepository;

    @Autowired
    public PhotoTranslatorImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    @Override
    public Photo save(Photo photo)
    {
        try{
            return photoRepository.save(photo);
        }catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db",e);
        }

    }

    @Override
    public List<PhotoDto> getAllPhotos() {
        List<PhotoDto> photoDtos = new ArrayList<>();
        try{
            for(Photo photo : photoRepository.findAll())
            {
                photoDtos.add(new PhotoDto(photo));
            }

        }catch (Exception e)
        {
            throw new RuntimeException("Unable tp read from DB", e);
        }
        return photoDtos;
    }
}
