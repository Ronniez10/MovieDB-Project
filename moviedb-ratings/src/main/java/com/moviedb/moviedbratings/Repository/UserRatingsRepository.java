package com.moviedb.moviedbratings.Repository;

import com.moviedb.moviedbratings.models.UserRating;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface UserRatingsRepository extends JpaRepository<UserRating,Integer> {




        /*@Query(value = "SELECT * FROM ratings a INNER JOIN user_rating b ON a.user_id= b.user_id WHERE a.user_id=10",nativeQuery = true)
        Optional<UserRating>  searchByUserId(int id);*/


       /* Optional<UserRating> findByIdRatingId(int id) ;*/
}
