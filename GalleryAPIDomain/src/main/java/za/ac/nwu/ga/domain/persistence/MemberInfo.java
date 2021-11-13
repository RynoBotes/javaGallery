package za.ac.nwu.ga.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBERINFO", schema = "dbo")
public class MemberInfo implements Serializable
{
    private static final long serialVersionUID = 7383951001328901769L;
    private Long id;
    private Long memberId;
    private String memberFName;
    private String memberLName;
    private String memberEmail;
    List<Photo> photoSet;

    public MemberInfo(Long id, Long memberId, String memberFName, String memberLName, String memberEmail) {
        this.id = id;
        this.memberId = memberId;
        this.memberFName = memberFName;
        this.memberLName = memberLName;
        this.memberEmail = memberEmail;
    }

    public MemberInfo() {
    }

    public MemberInfo(Long memberId, String memberFName, String memberLName, String memberEmail) {
        this.memberId = memberId;
        this.memberFName = memberFName;
        this.memberLName = memberLName;
        this.memberEmail = memberEmail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "member_id")
//    @SequenceGenerator(name = "member_id", sequenceName = "member_id_sequence", allocationSize = 1)
    @Column(name = "Id")
    public Long getId() {
        return id;
    }

    @Column(name = "MEMBERID")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "MEMBERFNAME")
    public String getMemberFName() {
        return memberFName;
    }

    @Column(name = "MEMBERLNAME")
    public String getMemberLName() {
        return memberLName;
    }

    @Column(name = "MEMBEREMAIL")
    public String getMemberEmail() {
        return memberEmail;
    }

    @OneToMany(targetEntity = Photo.class,fetch = FetchType.LAZY, mappedBy = "memberInfo")
    public List<Photo> getPhotoSet() {
        return photoSet;
    }

    public void setPhotoSet(List<Photo> photoSet) {
        this.photoSet = photoSet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setMemberFName(String memberFName) {
        this.memberFName = memberFName;
    }

    public void setMemberLName(String memberLName) {
        this.memberLName = memberLName;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberInfo that = (MemberInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(memberId, that.memberId) && Objects.equals(memberFName, that.memberFName) && Objects.equals(memberLName, that.memberLName) && Objects.equals(memberEmail, that.memberEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, memberId, memberFName, memberLName, memberEmail);
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "Id=" + id +
                ", memberId=" + memberId +
                ", memberFName='" + memberFName + '\'' +
                ", memberLName='" + memberLName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                '}';
    }
}
