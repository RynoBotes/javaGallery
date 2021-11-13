package za.ac.nwu.ga.translator;

import za.ac.nwu.ga.domain.dto.PhotoDto;
import za.ac.nwu.ga.domain.persistence.Photo;

import java.util.List;

public interface PhotoTranslator
{
    Photo save(Photo photo);

    List<PhotoDto> getAllPhotos();
}
