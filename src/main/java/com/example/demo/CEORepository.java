package com.example.demo;

import java.util.List;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;


public interface CEORepository extends DatastoreRepository<CEO, Long> {

  List<CEO> findByIndustry(String industry);

}