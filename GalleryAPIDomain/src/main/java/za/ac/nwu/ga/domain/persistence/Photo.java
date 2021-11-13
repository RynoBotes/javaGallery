package za.ac.nwu.ga.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PHOTO",schema = "dbo")
public class Photo implements Serializable
{

    private static final long serialVersionUID = 2753154375623651886L;
    private Long photoId;
    private MemberInfo memberInfo;
    private String blobLocation;
    private LocalDate dateStored;
    private String photoName;
    private String photoDiscription;

    public Photo(Long photoId, MemberInfo memberInfo, String blobLocation, LocalDate dateStored, String photoName, String photoDiscription) {
        this.photoId = photoId;
        this.memberInfo = memberInfo;
        this.blobLocation = blobLocation;
        this.dateStored = dateStored;
        this.photoName = photoName;
        this.photoDiscription = photoDiscription;
    }

    public Photo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "Photo_id_generator")
    @Column(name = "PHOTOID")
    public Long getPhotoId() {
        return photoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBERID")
    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    @Column(name = "BLOBLOCATION")
    public String getBlobLocation() {
        return blobLocation;
    }

    @Column(name = "DATESTORED")
    public LocalDate getDateStored() {
        return dateStored;
    }

    @Column(name = "PHOTONAME")
    public String getPhotoName() {
        return photoName;
    }

    @Column(name = "PHOTODISCRIPTION")
    public String getPhotoDiscription() {
        return photoDiscription;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public void setBlobLocation(String blobLocation) {
        this.blobLocation = blobLocation;
    }

    public void setDateStored(LocalDate dateStored) {
        this.dateStored = dateStored;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public void setPhotoDiscription(String photoDiscription) {
        this.photoDiscription = photoDiscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(photoId, photo.photoId) && Objects.equals(memberInfo, photo.memberInfo) && Objects.equals(blobLocation, photo.blobLocation) && Objects.equals(dateStored, photo.dateStored) && Objects.equals(photoName, photo.photoName) && Objects.equals(photoDiscription, photo.photoDiscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, memberInfo, blobLocation, dateStored, photoName, photoDiscription);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", memberInfo=" + memberInfo +
                ", blobLocation='" + blobLocation + '\'' +
                ", dateStored=" + dateStored +
                ", photoName='" + photoName + '\'' +
                ", photoDiscription='" + photoDiscription + '\'' +
                '}';
    }
}
