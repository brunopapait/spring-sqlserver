package br.com.papait.bruno.spring.com.sql_server.controller;

import br.com.papait.bruno.spring.com.sql_server.model.VideoModel;
import br.com.papait.bruno.spring.com.sql_server.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoController {

  private final VideoService videoService;

  @PostMapping
  public ResponseEntity<VideoModel> create(VideoModel videoModel) {
    return ResponseEntity.ok(this.videoService.save(videoModel));
  }

  @PutMapping("/{id}")
  public ResponseEntity<VideoModel> update(Long id, VideoModel videoModel) {
    return ResponseEntity.ok(this.videoService.update(id, videoModel));
  }

  @GetMapping("/{id}")
  public ResponseEntity<VideoModel> findById(Long id) {
    return ResponseEntity.ok(this.videoService.findById(id));
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(Long id) {
    this.videoService.delete(id);
    return ResponseEntity.noContent().build();
  }


  @GetMapping
  public ResponseEntity<List<VideoModel>> findAll() {
    return ResponseEntity.ok(this.videoService.findAll());
  }
}
