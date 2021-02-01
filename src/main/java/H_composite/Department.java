package H_composite;

public class Department extends OrganizationComponent {
    public Department(String name, String des) {
        super(name, des);
    }

    public String getName() {
        return super.getName();
    }

    public String getDes() {
        return super.getDes();
    }

    protected void print() {
        System.out.println(getName());
    }
}
