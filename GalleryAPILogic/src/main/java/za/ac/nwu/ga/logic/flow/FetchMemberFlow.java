package za.ac.nwu.ga.logic.flow;

import za.ac.nwu.ga.domain.dto.MemberInfoDto;

import java.util.List;

public interface FetchMemberFlow
{
    List<MemberInfoDto> getAllMembers();

    MemberInfoDto getMemberById(Long id);

    MemberInfoDto deleteMember(Long memberId);
}
