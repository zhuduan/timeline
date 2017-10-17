package  com.timeline.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.timeline.model.Item;

@Transactional
public interface FirstDemoRepository extends JpaRepository<Item, String> {
    
	@Query("SELECT b FROM Item b WHERE b.name like %?1%")
    List<Item> findByTitle(String name);
	
	
}
