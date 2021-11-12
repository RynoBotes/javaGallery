package za.ac.nwu.ga.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.logic.flow.FetchMemberFlow;
import za.ac.nwu.ga.translator.MemberInfoTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
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
