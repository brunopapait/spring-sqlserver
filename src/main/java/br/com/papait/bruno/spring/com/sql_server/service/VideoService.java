package br.com.papait.bruno.spring.com.sql_server.service;

import br.com.papait.bruno.spring.com.sql_server.model.VideoModel;
import br.com.papait.bruno.spring.com.sql_server.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VideoService {

  private final VideoRepository videoRepository;

  public VideoModel save(VideoModel videoModel) {
    return videoRepository.save(videoModel);
  }

  public List<VideoModel> findAll() {
    return videoRepository.findAll();
  }

  public VideoModel findById(Long id) {
    return videoRepository.findById(id).orElseThrow(() -> new RuntimeException("Video not found"));
  }

  public void delete(Long id) {
    var video = this.findById(id);
    videoRepository.delete(video);
  }

  public VideoModel update(Long id, VideoModel videoModel) {
    var video = this.findById(id);
    video.setTitle(videoModel.getTitle());
    video.setUrl(videoModel.getUrl());
    video.setUser(videoModel.getUser());
    video.setDescription(videoModel.getDescription());
    return videoRepository.save(video);
  }

}
