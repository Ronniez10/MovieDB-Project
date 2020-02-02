package com.moviedb.moviedbratings.Repository;

import com.moviedb.moviedbratings.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingsRepository extends JpaRepository<Rating,Integer> {

    List<Rating> findByUserRatingUserId (int userId);
    Optional<Rating> findByIdAndUserRatingUserId(int id, int userId);


}
