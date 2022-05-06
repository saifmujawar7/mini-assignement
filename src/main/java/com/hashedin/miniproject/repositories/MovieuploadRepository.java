package com.hashedin.miniproject.repositories;

import com.hashedin.miniproject.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieuploadRepository extends JpaRepository<MovieDetails, String> {
}
