import model.user.Host;
import model.user.User;
import view.ViewHost;

public class Main {
    public static void main(String[] args) {
          User host = new Host("12", "Trung","Trung","Nd", 234, 23452345, 6);
          new ViewHost(host).viewHost();

    }

}
