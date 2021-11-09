package za.ac.nwu.ga.logic.flow;

import za.ac.nwu.ga.domain.dto.MemberInfoDto;

public interface CreateMemberFlow
{
    MemberInfoDto create(MemberInfoDto member);
}
