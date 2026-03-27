import java.util.*;

// Post Class
class Post {
    String username;
    String content;
    int likes;

    public Post(String username, String content) {
        this.username = username;
        this.content = content;
        this.likes = 0;
    }

    public void likePost() {
        likes++;
    }

    public void displayPost() {
        System.out.println("User: " + username);
        System.out.println("Post: " + content);
        System.out.println("Likes: " + likes);
        System.out.println("----------------------");
    }
}

// Main App Class
public class MiniInstagram {

    static List<Post> posts = new ArrayList<>();
    static Set<String> users = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Mini Instagram ---");
            System.out.println("1. Create User");
            System.out.println("2. Create Post");
            System.out.println("3. View Posts");
            System.out.println("4. Like Post");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createUser(sc);
                    break;
                case 2:
                    createPost(sc);
                    break;
                case 3:
                    viewPosts();
                    break;
                case 4:
                    likePost(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Create User
    static void createUser(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        if (users.contains(username)) {
            System.out.println("User already exists!");
        } else {
            users.add(username);
            System.out.println("User created successfully!");
        }
    }

    // Create Post
    static void createPost(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        if (!users.contains(username)) {
            System.out.println("User not found! Create user first.");
            return;
        }

        System.out.print("Enter post content: ");
        String content = sc.nextLine();

        posts.add(new Post(username, content));
        System.out.println("Post added!");
    }

    // View Posts
    static void viewPosts() {
        if (posts.isEmpty()) {
            System.out.println("No posts yet!");
            return;
        }

        for (int i = 0; i < posts.size(); i++) {
            System.out.println("Post ID: " + i);
            posts.get(i).displayPost();
        }
    }

    // Like Post
    static void likePost(Scanner sc) {
        viewPosts();
        if (posts.isEmpty()) return;

        System.out.print("Enter Post ID to like: ");
        int id = sc.nextInt();

        if (id >= 0 && id < posts.size()) {
            posts.get(id).likePost();
            System.out.println("Liked!");
        } else {
            System.out.println("Invalid Post ID!");
        }
    }
}