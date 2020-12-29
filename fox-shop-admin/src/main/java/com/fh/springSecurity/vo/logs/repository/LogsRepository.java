package com.fh.springSecurity.vo.logs.repository;

import com.fh.springSecurity.vo.logs.entity.Logs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends MongoRepository<Logs,String> {
}
