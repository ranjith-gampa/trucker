package com.rg.egen.service;

import com.rg.egen.entity.Reading;
import com.rg.egen.exception.BadRequestException;
import com.rg.egen.exception.ReadingNotFoundException;
import com.rg.egen.repository.ReadingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {

    private final ReadingsRepository repository;

    @Autowired
    public ReadingServiceImpl(ReadingsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Reading> findAll() {
        return (List<Reading>) repository.findAll();
    }

    @Override
    public Reading findOne(String id) {
        Optional<Reading> existing = repository.findById(id);
        if(!existing.isPresent()) {
            throw new ReadingNotFoundException("Reading with id:- "+id+" Not Found");
        }
        return existing.get();
    }

    @Override
    public Reading create(Reading reading) {
        return repository.save(reading);
    }

    @Override
    public Reading update(Reading reading) {
        Optional<Reading> existing = repository.findById(reading.getId());
        if(!existing.isPresent()) {
            throw new BadRequestException("Reading with id:- "+reading.getId()+" Does not exist");
        }
        return repository.save(reading);
    }

    @Override
    public void delete(String id) {
        Optional<Reading> existing = repository.findById(id);
        if(!existing.isPresent()) {
            throw new ReadingNotFoundException("Reading with id:- "+id+" Not Found");
        }
        repository.delete(existing.get());
    }
}
