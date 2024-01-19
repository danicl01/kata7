package software.ulpgc.bouncingball;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        BallPresenter.with(
                new Ball(5, 0, 0.4, 0.5),
                frame.getDisplay()
        );
        frame.setVisible(true);
    }

}
