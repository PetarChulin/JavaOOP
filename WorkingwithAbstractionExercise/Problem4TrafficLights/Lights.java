package WorkingwithAbstractionExercise.Problem4TrafficLights;

enum Colors {

    RED, GREEN, YELLOW

}
public class Lights {

    public Lights(Colors color) {
        this.color = color;
    }
    public Colors color;

    public void changeColor(){

        if (this.color == Colors.RED) {
            this.color = Colors.GREEN;
        } else if (this.color == Colors.GREEN) {
            this.color = Colors.YELLOW;
        } else if (this.color == Colors.YELLOW) {
            this.color = Colors.RED;
        }
    }

    public String toString() {
        return this.color.toString();
    }
}
