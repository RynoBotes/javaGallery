package za.ac.nwu.ga.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.domain.persistence.MemberInfo;
import za.ac.nwu.ga.repo.persistence.MemberInfoRepository;
import za.ac.nwu.ga.translator.MemberInfoTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberInfoTranslatorImpl implements MemberInfoTranslator
{
    MemberInfoRepository memberInfoRepository;

    @Autowired
    public MemberInfoTranslatorImpl(MemberInfoRepository memberInfoRepository)
    {
        this.memberInfoRepository = memberInfoRepository;
    }

    @Override
    public List<MemberInfoDto> getAllMembers()
    {
        List<MemberInfoDto> memberInfoDtos = new ArrayList<>();
        try{
            for(MemberInfo memberInfo : memberInfoRepository.findAll())
            {
                memberInfoDtos.add(new MemberInfoDto(memberInfo));
            }

        }catch (Exception e)
        {
            throw new RuntimeException("Unable tp read from DB", e);
        }
        return memberInfoDtos;
    }

    @Override
    public MemberInfoDto create(MemberInfoDto memberInfoDto) {
        try
        {
            MemberInfo memberInfo = memberInfoRepository.save(memberInfoDto.getMemberInfo());
            return new MemberInfoDto(memberInfo);
        }catch(Exception e)
        {
            throw new RuntimeException("Unable to save to the DB",e);
        }
    }

    @Override
    public MemberInfoDto getMemberById(Long id) {
        try {
            MemberInfo memberInfo = memberInfoRepository.getMemberById(id);
            return new MemberInfoDto(memberInfo);

        }catch (Exception e)
        {
            throw new RuntimeException("Member fetch failed",e);
        }
    }

    @Override
    public MemberInfoDto updateMember(Long memberId, String newMemberFName, String newMemberLName, String newMemberEmail) {
        try {
            MemberInfo memberInfo = memberInfoRepository.updateMember(memberId, newMemberFName, newMemberLName, newMemberEmail);
            return new MemberInfoDto(memberInfo);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to update record", e);
        }
    }

    @Override
    public MemberInfoDto deleteMember(Long memberId) {
        try {
            MemberInfo memberInfo = memberInfoRepository.getMemberById(memberId);
            memberInfoRepository.delete(memberInfo);
            return new MemberInfoDto(memberInfo);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public MemberInfo getMemberdbEntityById(Long id) {
        try{
            return memberInfoRepository.getOne(id);

        }catch (Exception e)
        {
            throw new RuntimeException("Member not fetched from DB",e);
        }
    }


}
