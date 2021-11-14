package za.ac.nwu.ga.logic.flow;

import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.domain.dto.PhotoDto;
import za.ac.nwu.ga.domain.persistence.MemberInfo;

import java.util.List;

public interface FetchPhotoFlow
{
    List<PhotoDto> getAllPhotos();

    PhotoDto getPhotoById(Long photoId);

    PhotoDto deletePhoto(Long photoId);

//    MemberInfo getMemberdbEntityById(Long memberId);
}
