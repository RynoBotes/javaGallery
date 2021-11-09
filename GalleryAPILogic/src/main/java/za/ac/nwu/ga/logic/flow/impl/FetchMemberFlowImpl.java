package za.ac.nwu.ga.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.logic.flow.FetchMemberFlow;
import za.ac.nwu.ga.translator.MemberInfoTranslator;

import java.util.List;

public class FetchMemberFlowImpl implements FetchMemberFlow
{

    private final MemberInfoTranslator memberInfoTranslator;

    @Autowired
    public FetchMemberFlowImpl(MemberInfoTranslator memberInfoTranslator) {
        this.memberInfoTranslator = memberInfoTranslator;
    }


    @Override
    public List<MemberInfoDto> getAllMembers() {
        return memberInfoTranslator.getAllMembers();
    }
}
