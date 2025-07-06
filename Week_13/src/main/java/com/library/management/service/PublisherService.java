package com.library.management.service;

import com.library.management.entity.Publisher;
import com.library.management.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService {
    
    private final PublisherRepository publisherRepository;
    
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
    
    public Optional<Publisher> getPublisherById(Long id) {
        return publisherRepository.findById(id);
    }
    
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
    
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
    
    public Publisher updatePublisher(Long id, Publisher publisherDetails) {
        Optional<Publisher> publisher = publisherRepository.findById(id);
        if (publisher.isPresent()) {
            Publisher existingPublisher = publisher.get();
            existingPublisher.setName(publisherDetails.getName());
            existingPublisher.setEstablishmentYear(publisherDetails.getEstablishmentYear());
            existingPublisher.setAddress(publisherDetails.getAddress());
            return publisherRepository.save(existingPublisher);
        }
        return null;
    }
} 