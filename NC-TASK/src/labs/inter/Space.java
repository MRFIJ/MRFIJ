package labs.inter;


public interface Space extends Comparable<Space> {

    double getArea();

    void setArea(double area);

    int getRoom();

    void setRoom(int room);

    Object clone();

    int compareTo (Space o);
}
