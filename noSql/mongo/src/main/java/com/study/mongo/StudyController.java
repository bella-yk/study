package com.study.mongo;

import com.mongodb.client.result.DeleteResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class StudyController {
    private final UserService userService;

    @GetMapping(value = "users")
    public List<Users> getUsers() {
        return userService.getUserList();
    }

    @GetMapping(value = "userById")
    public Users getUsrById(String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(value = "insertUser")
    public Users saveUsers(Users users) {
        return userService.saveUsers(users);
    }

    @PutMapping(value = "updateUser")
    public void updateUser(Users users) {
        Optional.ofNullable(userService.getUserById(users.getUser_id())).ifPresent(user -> {
            users.set_id(user.get_id());
            userService.saveUsers(users);
        });
    }

    @DeleteMapping(value = "deleteUser")
    public DeleteResult deleteUser(String userId) {
        return Optional.ofNullable(userService.getUserById(userId)).map(
                users -> userService.deleteUser(users)
        ).orElse(DeleteResult.acknowledged(0));
    }
}
