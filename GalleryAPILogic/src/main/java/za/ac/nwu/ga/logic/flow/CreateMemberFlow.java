package za.ac.nwu.ga.logic.flow;

import za.ac.nwu.ga.domain.dto.MemberInfoDto;

public interface CreateMemberFlow
{
    MemberInfoDto create(MemberInfoDto member);

    MemberInfoDto updateMember(Long memberId, String newMemberFName, String newMemberLName, String newMemberEmail);

//    MemberInfoDto updateMember(Long memberID, String newMemberFName, String newMemberLName, String newMemberEmail);
}
