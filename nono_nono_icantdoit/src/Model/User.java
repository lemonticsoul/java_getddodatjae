package Model;



public  class User {

    private int id;
    private String username;

    private String password;

    private String name;

    public User(int id,String username,String password,String name){
        this.id=id;
        this.username=username;
        this.password=password;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
