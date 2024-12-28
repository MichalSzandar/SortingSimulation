package michal.projects;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Rectangle;

public abstract class SortingAlgorithm implements Runnable {
    protected List<Rectangle> list;
    protected int speed;

    public SortingAlgorithm(){
        this.list = new ArrayList<>();
    }

    @SuppressWarnings("exports")
    public void setList(List<Rectangle> list){
        this.list = list;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    protected void swap(int i, int j){
        double temp = list.get(i).getHeight();
        list.get(i).setHeight(list.get(j).getHeight());
        list.get(j).setHeight(temp);
        list.get(i).setY(Utils.getMaxHeight() - list.get(i).getHeight());
        list.get(j).setY(Utils.getMaxHeight() - list.get(j).getHeight());
        list.get(i).setFill(Utils.getColorForHeight(list.get(i).getHeight()));
        list.get(j).setFill(Utils.getColorForHeight(list.get(j).getHeight()));
    }
}
