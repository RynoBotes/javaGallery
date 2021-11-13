package za.ac.nwu.ga.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ga.domain.dto.PhotoDto;
import za.ac.nwu.ga.logic.flow.FetchPhotoFlow;
import za.ac.nwu.ga.translator.PhotoTranslator;

import java.util.List;

@Component
public class FetchPhotoFlowImpl implements FetchPhotoFlow
{

    private final PhotoTranslator photoTranslator;

    @Autowired
    public FetchPhotoFlowImpl(PhotoTranslator photoTranslator) {
        this.photoTranslator = photoTranslator;
    }

    @Override
    public List<PhotoDto> getAllPhotos() {
        return photoTranslator.getAllPhotos();
    }

    @Override
    public PhotoDto deletePhoto(Long photoId) {
        return null;
    }
}
