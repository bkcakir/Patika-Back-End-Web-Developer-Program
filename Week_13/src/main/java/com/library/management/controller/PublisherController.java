package com.library.management.controller;

import com.library.management.dto.PublisherRequestDto;
import com.library.management.dto.PublisherResponseDto;
import com.library.management.entity.Publisher;
import com.library.management.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {
    
    private final PublisherService publisherService;
    
    @GetMapping
    public ResponseEntity<List<PublisherResponseDto>> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAllPublishers();
        List<PublisherResponseDto> responseDtos = publishers.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> getPublisherById(@PathVariable Long id) {
        Optional<Publisher> publisher = publisherService.getPublisherById(id);
        return publisher.map(p -> ResponseEntity.ok(convertToResponseDto(p)))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<PublisherResponseDto> createPublisher(@RequestBody PublisherRequestDto requestDto) {
        Publisher publisher = convertToEntity(requestDto);
        Publisher savedPublisher = publisherService.savePublisher(publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToResponseDto(savedPublisher));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> updatePublisher(@PathVariable Long id, @RequestBody PublisherRequestDto requestDto) {
        Publisher publisher = convertToEntity(requestDto);
        Publisher updatedPublisher = publisherService.updatePublisher(id, publisher);
        if (updatedPublisher != null) {
            return ResponseEntity.ok(convertToResponseDto(updatedPublisher));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
    
    private PublisherResponseDto convertToResponseDto(Publisher publisher) {
        return new PublisherResponseDto(
                publisher.getId(),
                publisher.getName(),
                publisher.getEstablishmentYear()
        );
    }
    
    private Publisher convertToEntity(PublisherRequestDto requestDto) {
        Publisher publisher = new Publisher();
        publisher.setName(requestDto.getName());
        publisher.setEstablishmentYear(requestDto.getEstablishmentYear());
        return publisher;
    }
} 