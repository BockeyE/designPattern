package D_builder;

public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
// TODO Auto-generated method stub
        System.out.println(" 普通房子打地基 5 米 ");
    }


    @Override
    public void buildWalls() {
// TODO Auto-generated method stub
        System.out.println(" 普通房子砌墙 10cm ");
    }


    @Override
    public void roofed() {
// TODO Auto-generated method stub
        System.out.println(" 普通房子屋顶 ");
    }
}
