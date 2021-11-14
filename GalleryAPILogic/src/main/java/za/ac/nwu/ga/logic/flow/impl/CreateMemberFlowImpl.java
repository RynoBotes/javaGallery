package za.ac.nwu.ga.logic.flow.impl;

import com.azure.core.http.HttpResponse;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobStorageException;
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

    String blobConnectionString = "DefaultEndpointsProtocol=https;AccountName=photogalleryrynobotes;AccountKey=rnfX8iDa9ZmHnRNR/1V+Aoq7o3ReWjXCmeQS/FqCynKWdDSReJbSJTL9je/gu+AlO46ZKStC+WQPzGugra2Biw==;EndpointSuffix=core.windows.net";

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
