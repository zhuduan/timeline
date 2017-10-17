package  com.team.timeline.service;

import com.team.timeline.model.Item;
import com.team.timeline.repository.FirstDemoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FirstDemoService {
	
    @Autowired
    private FirstDemoRepository firstDemoRepository;

    public List<Item> findByTitle(String title) {
        return firstDemoRepository.findByTitle(title);
    }
}
