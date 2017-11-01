package  com.timeline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timeline.model.PO.Item;
import com.timeline.repository.FirstDemoRepository;

@Service
@Transactional
public class FirstDemoService {
	
    @Autowired
    private FirstDemoRepository firstDemoRepository;

    public List<Item> findByTitle(String title) {
        return firstDemoRepository.findByTitle(title);
    }
}
