package TrafficLights2;

public enum Color {

    RED("GREEN"), GREEN("YELLOW") , YELLOW("RED");

    final String nextColor;

    Color(String nextColor) {
        this.nextColor = nextColor;
    }

}
