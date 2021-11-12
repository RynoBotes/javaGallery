package za.ac.nwu.ga.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ga.domain.persistence.MemberInfo;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "MemberInfo",
            description = "A dto that represents the Member")
public class MemberInfoDto implements Serializable
{

    private static final long serialVersionUID = -5500633616423574128L;
    private Long memberId;
    private String memberFName;
    private String memberLName;
    private String memberEmail;

    public MemberInfoDto() {
    }

    public MemberInfoDto(Long memberId, String memberFName, String memberLName, String memberEmail) {
        this.memberId = memberId;
        this.memberFName = memberFName;
        this.memberLName = memberLName;
        this.memberEmail = memberEmail;
    }



    public MemberInfoDto(MemberInfo memberInfo)
    {
        this.setMemberId(memberInfo.getMemberId());
        this.setMemberFName(memberInfo.getMemberFName());
        this.setMemberLName(memberInfo.getMemberLName());
        this.setMemberEmail(memberInfo.getMemberEmail());
    }

    @ApiModelProperty(position = 1,
            value = "MemberInfo ID",
            name = "Member ID",
            notes = "The ID of the Member",
            dataType = "java.lang.Long",
            example = "125684",
            required = true)
    public Long getMemberId() {
        return memberId;
    }

    @ApiModelProperty(position = 2,
            value = "Member Name",
            name = "Name",
            notes = "The name of the Member",
            dataType = "java.lang.String",
            example = "Chavonne",
            required = true)
    public String getMemberFName() {
        return memberFName;
    }

    @ApiModelProperty(position = 3,
            value = "Member surname",
            name = "surname",
            notes = "The surname of the member",
            dataType = "java.lang.String",
            example = "Jackson",
            required = true)
    public String getMemberLName() {
        return memberLName;
    }

    @ApiModelProperty(position = 3,
            value = "Member email",
            name = "email",
            notes = "The email of the member",
            dataType = "java.lang.String",
            example = "Jackson@yanee.co.za",
            required = true)
    public String getMemberEmail() {
        return memberEmail;
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
        MemberInfoDto that = (MemberInfoDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(memberFName, that.memberFName) && Objects.equals(memberLName, that.memberLName) && Objects.equals(memberEmail, that.memberEmail);
    }

    @JsonIgnore
    public MemberInfo getMemberInfo()
    {
        return new MemberInfo(getMemberId(),getMemberFName(),getMemberLName(),getMemberEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberFName, memberLName, memberEmail);
    }

    @Override
    public String toString() {
        return "MemberInfoDto{" +
                "memberId=" + memberId +
                ", memberFName='" + memberFName + '\'' +
                ", memberLName='" + memberLName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                '}';
    }
}
