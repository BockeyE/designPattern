package H_composite;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationComponent {


    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    // 构造器
    public University(String name, String des) {
        super(name, des);
    }


    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }


    public String getName() {
        return super.getName();
    }

    public String getDes() {
        return super.getDes();


    }


    protected void print() {
        System.out.println("--------------" + getName() + "--------------");
//遍历 organizationComponents
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}
