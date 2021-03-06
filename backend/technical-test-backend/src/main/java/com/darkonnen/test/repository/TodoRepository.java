package com.darkonnen.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.darkonnen.test.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	// Select the user with less tasks. Removes an empty value by default -> '' and limits the query.
    @Query(value="SELECT todo.asigned_user FROM Todo WHERE todo.asigned_user !='' GROUP BY asigned_user ORDER BY COUNT(*) ASC LIMIT 1", nativeQuery=true)
    String query_asigned_user();

}
