

public class Department {   //01 criar class department

    private String name;

    public Department() { //02 name e criar construtor vazio
    }

    public Department(String name) {  //03 criar construtor argumentos
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}