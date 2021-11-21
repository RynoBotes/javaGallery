package za.ac.nwu.ga.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ga.domain.dto.PhotoDto;
import za.ac.nwu.ga.domain.persistence.MemberInfo;
import za.ac.nwu.ga.domain.persistence.Photo;
import za.ac.nwu.ga.logic.flow.CreatePhotoFlow;
import za.ac.nwu.ga.translator.impl.PhotoTranslatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@Transactional
@Component
public class CreatePhotoFlowImpl implements CreatePhotoFlow
{
    private String imagePath;

    private final FetchMemberFlowImpl fetchMemberFlow;
    private final PhotoTranslatorImpl photoTranslator;

    @Autowired
    public CreatePhotoFlowImpl(FetchMemberFlowImpl fetchMemberFlow, PhotoTranslatorImpl photoTranslator) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.photoTranslator = photoTranslator;
    }

    @Override
    public PhotoDto create(PhotoDto photoDto)  {

        MemberInfo memberInfo = fetchMemberFlow.getMemberdbEntityById(photoDto.getId());
        Photo photo = photoDto.buildPhotoDto(memberInfo);
//        String folder = "C:/Users/User/IdeaProjects/GalleryAPI/frontend/galleryProj/src/assets/images/";
//        byte[] bytes = multipartFile.getBytes();
//        Path path = Paths.get(folder + multipartFile.getOriginalFilename());
//        Files.write(path,bytes);
        if(null == photo.getDateStored())
        {
            photo.setDateStored(LocalDate.now());
        }
        if( true)
        {
            photo.setBlobLocation(imagePath.replace("\\","/"));
        }

        Photo createdPhoto = photoTranslator.save(photo);
        return new PhotoDto(createdPhoto);

    }

    @Override
    public void saveImage(MultipartFile multipartFile) throws IOException {
        String folder = "C:/Users/User/IdeaProjects/GalleryAPI/frontend/galleryProj/src/assets/images/";
        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get(folder + multipartFile.getOriginalFilename());
        Files.write(path,bytes);
        imagePath = path.toString();
    }


}
