package za.ac.nwu.ga.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ga.domain.dto.MemberInfoDto;
import za.ac.nwu.ga.domain.persistence.MemberInfo;

@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo,Long>
{

    @Query(value = "SELECT "+
            "       * "+
            "       FROM "+
            "       MEMBERINFO  "+
            "   WHERE memberId = :id ",nativeQuery = true)
    MemberInfo getMemberById(Long id);

    @Query(value = "UPDATE " +
            "   MEMBERINFO "+
            "   SET memberFName = :newMemberFName, memberLName = :newMemberLName, memberEmail = :newMemberEmail "+
            "   WHERE memberId = :memberId ",nativeQuery = true)
    MemberInfo updateMember(Long memberId, String newMemberFName, String newMemberLName, String newMemberEmail);


}
