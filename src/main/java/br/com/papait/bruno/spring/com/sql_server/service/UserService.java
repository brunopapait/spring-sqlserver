package br.com.papait.bruno.spring.com.sql_server.service;

import br.com.papait.bruno.spring.com.sql_server.model.UserModel;
import br.com.papait.bruno.spring.com.sql_server.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {

  private final UsersRepository userRepository;

  public UserModel save(UserModel userModel) {
    return userRepository.save(userModel);
  }

  public List<UserModel> findAll() {
    return userRepository.findAll();
  }

  public UserModel findById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  public UserModel update(Long id, UserModel userModel) {
    UserModel user = findById(id);
    user.setName(userModel.getName());
    user.setEmail(userModel.getEmail());
    return userRepository.save(user);
  }
}
