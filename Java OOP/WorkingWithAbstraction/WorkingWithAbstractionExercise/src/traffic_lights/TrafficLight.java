package traffic_lights;

public class TrafficLight {

    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public void changeColor()   {
        switch (color)  {
            case RED:
                color = Color.GREEN;
                break;
            case GREEN:
                color = Color.YELLOW;
                break;
            case YELLOW:
                color = Color.RED;
                break;
        }
    }

    @Override
    public String toString()    {
        return color.name();
    }
}
