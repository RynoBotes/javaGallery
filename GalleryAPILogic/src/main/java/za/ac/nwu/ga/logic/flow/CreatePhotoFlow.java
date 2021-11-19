package za.ac.nwu.ga.logic.flow;

import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ga.domain.dto.PhotoDto;

import java.io.IOException;

public interface CreatePhotoFlow
{
    PhotoDto create(PhotoDto photoDto);

    void saveImage(MultipartFile imageFile) throws IOException;
}
