public class Main {
 
    public static void main(String[] args) throws Exception {
 
        java.io.Console console = System.console();
        String username = console.readLine("Username: ");
        String password = new String(console.readPassword("Password: "));
        System.out.println(username+"/"+password);
    }
}
