package za.ac.nwu.ga.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ga.domain.dto.PhotoDto;
import za.ac.nwu.ga.domain.persistence.MemberInfo;
import za.ac.nwu.ga.domain.persistence.Photo;
import za.ac.nwu.ga.logic.flow.CreatePhotoFlow;
import za.ac.nwu.ga.translator.impl.PhotoTranslatorImpl;

import java.time.LocalDate;

@Transactional
@Component
public class CreatePhotoFlowImpl implements CreatePhotoFlow
{

    private final FetchMemberFlowImpl fetchMemberFlow;
    private final PhotoTranslatorImpl photoTranslator;

    @Autowired
    public CreatePhotoFlowImpl(FetchMemberFlowImpl fetchMemberFlow, PhotoTranslatorImpl photoTranslator) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.photoTranslator = photoTranslator;
    }

    @Override
    public PhotoDto create(PhotoDto photoDto) {

        MemberInfo memberInfo = fetchMemberFlow.getMemberdbEntityById(photoDto.getId());
        Photo photo = photoDto.buildPhotoDto(memberInfo);
        if(null == photo.getDateStored())
        {
            photo.setDateStored(LocalDate.now());
        }

        Photo createdPhoto = photoTranslator.save(photo);
        return new PhotoDto(createdPhoto);

    }
}
