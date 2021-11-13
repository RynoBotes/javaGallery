package za.ac.nwu.ga.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ga.domain.persistence.MemberInfo;
import za.ac.nwu.ga.domain.persistence.Photo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Photo",
description = "A dto that represents a photo")
public class PhotoDto implements Serializable
{
    private static final long serialVersionUID = 2838658629784498688L;
    private Long photoId;
    private Long memberId;
    private String blobLocation;
    private LocalDate dateStored;
    private String photoName;
    private String photoDiscription;

    public PhotoDto(Long photoId, String blobLocation, LocalDate dateStored, String photoName, String photoDiscription) {
        this.photoId = photoId;
        this.blobLocation = blobLocation;
        this.dateStored = dateStored;
        this.photoName = photoName;
        this.photoDiscription = photoDiscription;
    }

    public PhotoDto(Long photoId, Long memberId, String blobLocation, LocalDate dateStored, String photoName, String photoDiscription) {
        this.photoId = photoId;
        this.memberId = memberId;
        this.blobLocation = blobLocation;
        this.dateStored = dateStored;
        this.photoName = photoName;
        this.photoDiscription = photoDiscription;
    }

    public PhotoDto(Photo photo)
    {
        this.photoId = photo.getPhotoId();
        this.memberId = photo.getMemberInfo().getMemberId();
        this.blobLocation = photo.getBlobLocation();
        this.dateStored = photo.getDateStored();
        this.photoDiscription = photo.getPhotoDiscription();
    }

    public PhotoDto() {
    }

    @ApiModelProperty(position = 1,
            value = "Photo ID",
            name = "Photo ID",
            notes = "The ID of the Photo",
            dataType = "java.lang.Long",
            example = "125684",
            required = true)
    public Long getPhotoId() {
        return photoId;
    }

    @ApiModelProperty(position = 2,
            value = "blob storage location",
            name = "Location",
            notes = "location of the file needed for retrieval",
            dataType = "java.lang.String",
            example = "https://Blobstorage.co.za",
            required = true)
    public String getBlobLocation() {
        return blobLocation;
    }

    @ApiModelProperty(position = 3,
            value = "Photo uploadDate",
            name = "upload Date",
            notes = "The upload date of the photo",
            dataType = "java.lang.String",
            example = "2020-01-12")
    public LocalDate getDateStored() {
        return dateStored;
    }

    @ApiModelProperty(position = 5,
            value = "Photo name",
            name = "Photo name",
            notes = "The name of the photo",
            dataType = "java.lang.String",
            example = "golden cliffs")
    public String getPhotoName() {
        return photoName;
    }

    @ApiModelProperty(position = 6,
            value = "Photo Description",
            name = "Photo Description",
            notes = "The description of the photo",
            dataType = "java.lang.String",
            example = "golden cliffs in the makiki mountain range")
    public String getPhotoDiscription() {
        return photoDiscription;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
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

    @JsonIgnore
    public Photo buildPhotoDto(MemberInfo memberInfo)
    {
        return new Photo(this.getPhotoId(), memberInfo,this.getBlobLocation(),this.getDateStored(),this.getPhotoName(),this.getPhotoDiscription()) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoDto photoDto = (PhotoDto) o;
        return Objects.equals(photoId, photoDto.photoId) && Objects.equals(blobLocation, photoDto.blobLocation) && Objects.equals(dateStored, photoDto.dateStored) && Objects.equals(photoName, photoDto.photoName) && Objects.equals(photoDiscription, photoDto.photoDiscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, blobLocation, dateStored, photoName, photoDiscription);
    }

    @Override
    public String toString() {
        return "PhotoDto{" +
                "photoId=" + photoId +
                ", blobLocation='" + blobLocation + '\'' +
                ", dateStored=" + dateStored +
                ", photoName='" + photoName + '\'' +
                ", photoDescription='" + photoDiscription + '\'' +
                '}';
    }
}
