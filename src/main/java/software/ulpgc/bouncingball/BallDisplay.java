package software.ulpgc.bouncingball;

public interface BallDisplay {
    int getHeight();
    void drawBall(int y, int r);
    void on(Grabbed grabbed);

    interface Grabbed {
        void at(int y);
    }

}
