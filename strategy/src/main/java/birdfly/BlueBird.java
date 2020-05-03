package birdfly;

import java.util.List;

public class BlueBird extends Bird{
    private List<Fly> flyList;


    @Override
    public void fly(){
      if(flyList != null){
          for (Fly fly:
                  flyList) {
              fly.Fly();
          }
      }
    }

    public BlueBird() {
    }

    public BlueBird(Fly fly){
        this(fly, StyleName.BLUEBIRD.getName(), Style.BLUE.getColor());
    }

    public BlueBird(Fly fly, String name, String color) {
        super(fly, name, color);
    }

    public List<Fly> getFlyList() {
        return flyList;
    }

    public void setFlyList(List<Fly> flyList) {
        this.flyList = flyList;
    }
}
