package za.ac.nwu.ga.logic.flow;

import za.ac.nwu.ga.domain.dto.MemberInfoDto;

import java.util.List;

public interface FetchMemberFlow
{
    List<MemberInfoDto> getAllMembers();
}
