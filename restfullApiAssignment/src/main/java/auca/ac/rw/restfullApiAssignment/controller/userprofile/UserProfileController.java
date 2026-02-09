package auca.ac.rw.restfullApiAssignment.controller.userprofile;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class UserProfileController {

    public static class UserProfile {
        public Long userId;
        public String username;
        public String email;
        public String fullName;
        public Integer age;
        public String country;
        public String bio;
        public Boolean active;

        public UserProfile(Long userId, String username, String email, String fullName, Integer age, String country, String bio, Boolean active) {
            this.userId = userId;
            this.username = username;
            this.email = email;
            this.fullName = fullName;
            this.age = age;
            this.country = country;
            this.bio = bio;
            this.active = active;
        }
    }

    public static class ApiResponse<T> {
        public boolean success;
        public String message;
        public T data;

        public ApiResponse(boolean success, String message, T data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }
    }

    public List<Long> userId = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L));
    public List<String> username = new ArrayList<>(Arrays.asList("john_doe", "jane_smith", "bob_wilson", "alice_brown"));
    public List<String> email = new ArrayList<>(Arrays.asList("john@example.com", "jane@example.com", "bob@example.com", "alice@example.com"));
    public List<String> fullName = new ArrayList<>(Arrays.asList("John Doe", "Jane Smith", "Bob Wilson", "Alice Brown"));
    public List<Integer> age = new ArrayList<>(Arrays.asList(25, 30, 22, 28));
    public List<String> country = new ArrayList<>(Arrays.asList("USA", "Canada", "USA", "UK"));
    public List<String> bio = new ArrayList<>(Arrays.asList("Software developer", "Designer", "Student", "Marketing manager"));
    public List<Boolean> active = new ArrayList<>(Arrays.asList(true, true, false, true));

    @GetMapping("/users")
    public ApiResponse<List<UserProfile>> getAllUsers() {
        List<UserProfile> users = new ArrayList<>();
        for (int i = 0; i < username.size(); i++) {
            users.add(new UserProfile(userId.get(i), username.get(i), email.get(i), fullName.get(i), age.get(i), country.get(i), bio.get(i), active.get(i)));
        }
        return new ApiResponse<>(true, "Users retrieved successfully", users);
    }

    @GetMapping("/users/{id}")
    public ApiResponse<UserProfile> getUserById(@PathVariable Long id) {
        for (int i = 0; i < userId.size(); i++) {
            if (userId.get(i).equals(id)) {
                UserProfile user = new UserProfile(userId.get(i), username.get(i), email.get(i), fullName.get(i), age.get(i), country.get(i), bio.get(i), active.get(i));
                return new ApiResponse<>(true, "User found", user);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @GetMapping("/users/search/username/{username}")
    public ApiResponse<UserProfile> getUserByUsername(@PathVariable String username) {
        for (int i = 0; i < this.username.size(); i++) {
            if (this.username.get(i).equalsIgnoreCase(username)) {
                UserProfile user = new UserProfile(userId.get(i), this.username.get(i), email.get(i), fullName.get(i), age.get(i), country.get(i), bio.get(i), active.get(i));
                return new ApiResponse<>(true, "User found", user);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @GetMapping("/users/country/{country}")
    public ApiResponse<List<UserProfile>> getUsersByCountry(@PathVariable String country) {
        List<UserProfile> users = new ArrayList<>();
        for (int i = 0; i < this.country.size(); i++) {
            if (this.country.get(i).equalsIgnoreCase(country)) {
                users.add(new UserProfile(userId.get(i), username.get(i), email.get(i), fullName.get(i), age.get(i), this.country.get(i), bio.get(i), active.get(i)));
            }
        }
        return new ApiResponse<>(true, "Users retrieved successfully", users);
    }

    @GetMapping("/users/age-range")
    public ApiResponse<List<UserProfile>> getUsersByAgeRange(@RequestParam int min, @RequestParam int max) {
        List<UserProfile> users = new ArrayList<>();
        for (int i = 0; i < age.size(); i++) {
            if (age.get(i) >= min && age.get(i) <= max) {
                users.add(new UserProfile(userId.get(i), username.get(i), email.get(i), fullName.get(i), age.get(i), country.get(i), bio.get(i), active.get(i)));
            }
        }
        return new ApiResponse<>(true, "Users retrieved successfully", users);
    }

    @PostMapping("/users")
    public ApiResponse<UserProfile> addUser(@RequestParam String username, @RequestParam String email, @RequestParam String fullName, @RequestParam int age, @RequestParam String country, @RequestParam String bio) {
        Long newId = (long) (this.userId.size() + 1);
        this.userId.add(newId);
        this.username.add(username);
        this.email.add(email);
        this.fullName.add(fullName);
        this.age.add(age);
        this.country.add(country);
        this.bio.add(bio);
        this.active.add(true);
        UserProfile user = new UserProfile(newId, username, email, fullName, age, country, bio, true);
        return new ApiResponse<>(true, "User profile created successfully", user);
    }

    @PutMapping("/users/{id}")
    public ApiResponse<UserProfile> updateUser(@PathVariable Long id, @RequestParam String username, @RequestParam String email, @RequestParam String fullName, @RequestParam int age, @RequestParam String country, @RequestParam String bio) {
        for (int i = 0; i < userId.size(); i++) {
            if (userId.get(i).equals(id)) {
                this.username.set(i, username);
                this.email.set(i, email);
                this.fullName.set(i, fullName);
                this.age.set(i, age);
                this.country.set(i, country);
                this.bio.set(i, bio);
                UserProfile user = new UserProfile(userId.get(i), username, email, fullName, age, country, bio, active.get(i));
                return new ApiResponse<>(true, "User profile updated successfully", user);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @PatchMapping("/users/{id}/activate")
    public ApiResponse<String> activateUser(@PathVariable Long id) {
        for (int i = 0; i < userId.size(); i++) {
            if (userId.get(i).equals(id)) {
                this.active.set(i, true);
                return new ApiResponse<>(true, "User activated successfully", "User ID: " + id);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @PatchMapping("/users/{id}/deactivate")
    public ApiResponse<String> deactivateUser(@PathVariable Long id) {
        for (int i = 0; i < userId.size(); i++) {
            if (userId.get(i).equals(id)) {
                this.active.set(i, false);
                return new ApiResponse<>(true, "User deactivated successfully", "User ID: " + id);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }

    @DeleteMapping("/users/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {
        for (int i = 0; i < userId.size(); i++) {
            if (userId.get(i).equals(id)) {
                this.userId.remove(i);
                this.username.remove(i);
                this.email.remove(i);
                this.fullName.remove(i);
                this.age.remove(i);
                this.country.remove(i);
                this.bio.remove(i);
                this.active.remove(i);
                return new ApiResponse<>(true, "User deleted successfully", "User ID: " + id);
            }
        }
        return new ApiResponse<>(false, "User not found", null);
    }
}
