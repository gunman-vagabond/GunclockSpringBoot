package com.gunman.Gunclock;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GunclockService {

    @Autowired
    private GunclockRepository gunclockRepository;

    public List<Gunclock> findAll() {
        return gunclockRepository.findAll();
    }

    public Gunclock findOne(Long id) {
//        return gunclockRepository.findOne(id);

//        Gunclock gunclock = null;
        Optional<Gunclock> gunclockOpt = gunclockRepository.findById(id);
        if ( gunclockOpt.isPresent() ) {
            return gunclockOpt.get();
        } else {
            return null;
        }
//        gunclockOpt.ifPresent(gunclock -> {return (Gunclock)gunclock;});
    }

    public Gunclock save(Gunclock gunclock) {
        return gunclockRepository.save(gunclock);
    }

    public void delete(Long id) {
//        gunclockRepository.delete(id);
//        Gunclock gunclock = null;
        Optional<Gunclock> gunclockOpt = gunclockRepository.findById(id);
        gunclockOpt.ifPresent(gunclock -> gunclockRepository.delete(gunclock));
//        gunclockRepository.delete(gunclock);
    }
}