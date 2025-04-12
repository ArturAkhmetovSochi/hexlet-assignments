package exercise.controller.users;

import exercise.Data;
import exercise.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> index(@PathVariable int id) {
        List<Post> result = posts.stream()
                .filter(p -> p.getUserId() == id)
                .toList();

        return ResponseEntity.ok()
                .body(result);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable int id, @RequestBody Post data) {
        data.setUserId(id);
        posts.add(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }






}

