package za.ac.nwu.ga.translator;

import za.ac.nwu.ga.domain.dto.MemberInfoDto;

import java.util.List;

public interface MemberInfoTranslator
{
    List<MemberInfoDto> getAllMembers();

    MemberInfoDto create(MemberInfoDto memberInfoDto);

    MemberInfoDto getMemberById(Long id);
}
