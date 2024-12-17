package br.com.papait.bruno.spring.com.sql_server.controller;

import br.com.papait.bruno.spring.com.sql_server.model.UserModel;
import br.com.papait.bruno.spring.com.sql_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserModel> create(UserModel userModel) {
    return ResponseEntity.ok(userService.save(userModel));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserModel> update(Long id, UserModel userModel) {
    return ResponseEntity.ok(userService.update(id, userModel));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserModel> findById(Long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(Long id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<UserModel>> findAll() {
    return ResponseEntity.ok(userService.findAll());
  }
}
