package za.ac.nwu.ga.translator;

import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.domain.persistence.MemberInfo;

import java.util.List;

public interface MemberInfoTranslator
{
    List<MemberInfoDto> getAllMembers();

    MemberInfoDto create(MemberInfoDto memberInfoDto);

    MemberInfoDto getMemberById(Long id);

    MemberInfoDto updateMember(Long memberId, String newMemberFName, String newMemberLName, String newMemberEmail);

    MemberInfoDto deleteMember(Long memberId);

    MemberInfo getMemberdbEntityById(Long id);


}
