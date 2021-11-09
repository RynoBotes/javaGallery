package za.ac.nwu.ga.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.logic.flow.CreateMemberFlow;

@Transactional
@Component
public class CreateMemberFlowImpl implements CreateMemberFlow
{

    @Override
    public MemberInfoDto create(MemberInfoDto member) {
        return null;
    }
}
