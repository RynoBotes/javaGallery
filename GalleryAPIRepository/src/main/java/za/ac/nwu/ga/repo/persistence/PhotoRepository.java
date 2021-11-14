package za.ac.nwu.ga.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ga.domain.persistence.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long>
{
    @Query(value = " SELECT " +
            "           * " +
            "          FROM " +
            "          dbo.PHOTO " +
            "          WHERE photoId = :photoId ",nativeQuery = true)
    Photo getPhotoById(Long photoId);
}
