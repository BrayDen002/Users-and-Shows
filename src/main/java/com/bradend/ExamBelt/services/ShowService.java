package com.bradend.ExamBelt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bradend.ExamBelt.models.Show;
import com.bradend.ExamBelt.repositories.ShowRepository;

@Service
public class ShowService {
	@Autowired
	private ShowRepository showRepo;
	
	
//	IDEAS CRUD
//	FINDS  IDEAS
	public List<Show> allShows(){
		return showRepo.findAll();
	}
//	CREATES IDEAS
	public Show saveIdeas(Show i) {
		return showRepo.save(i);
	}
//	GET IDEAS BY ID
	public Show findShows(Long id) {
		return showRepo.findById(id).orElse(null);
	}
//	DELETE IDEA BY ID
	public void deleteIdeas(Long ideas_id) {
		showRepo.deleteById(ideas_id);
	}
}
