package br.com.papait.bruno.spring.com.sql_server.repository;

import br.com.papait.bruno.spring.com.sql_server.model.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoModel, Long> {
}
