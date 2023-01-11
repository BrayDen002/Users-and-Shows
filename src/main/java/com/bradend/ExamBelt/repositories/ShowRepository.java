package com.bradend.ExamBelt.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bradend.ExamBelt.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
	List<Show> findAll();
	Optional<Show> findById(Long id);
	void deleteById(Long id);

}
