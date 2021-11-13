package za.ac.nwu.ga.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.logic.flow.CreateMemberFlow;
import za.ac.nwu.ga.translator.MemberInfoTranslator;

@Transactional
@Component
public class CreateMemberFlowImpl implements CreateMemberFlow
{

    private final MemberInfoTranslator memberInfoTranslator;

    @Autowired
    public CreateMemberFlowImpl(MemberInfoTranslator memberInfoTranslator) {
        this.memberInfoTranslator = memberInfoTranslator;
    }

    @Override
    public MemberInfoDto create(MemberInfoDto member) {
        return memberInfoTranslator.create(member);
    }

    @Override
    public MemberInfoDto updateMember(Long memberId, String newMemberFName, String newMemberLName, String newMemberEmail) {
        return memberInfoTranslator.updateMember(memberId, newMemberFName, newMemberLName, newMemberEmail);
    }

}
