package software.ulpgc.bouncingball;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Ball {
    private static final double g = -9.81; /* m/s2 */
    private static final double dt = 0.001; /* s */
    private List<Observer> observers;
    private double h;
    private double v;
    private double r;
    private final double e;

    public Ball(double h, double v, double r, double e) {
        this.h = h;
        this.v = v;
        this.r = r;
        this.e = e;
        this.observers = new ArrayList<>();
        this.updatePeriodically();
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getV() {
        return v;
    }

    public double getR() {
        return r;
    }

    public void add(Observer observer) {
        this.observers.add(observer);
    }

    private void updatePeriodically() {
        int period = (int) (dt * 1000);
        System.out.println(period);
        new Timer().schedule(updateTask(), 1, period);
    }

    private TimerTask updateTask() {
        return new TimerTask() {
            @Override
            public void run() {
                update();
            }
        };
    }

    private void update() {
        if (h - r + v * dt < 0) {
            double tt = (h - r) / v;
            v = - v * e;
            h = r + v * (dt -tt);
        }
        else {
            h += v * dt;
            v += g * dt;
        }
        notifyChanges();
    }

    private void notifyChanges() {
        observers.forEach(Observer::changed);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "h=" + h +
                ", v=" + v +
                '}';
    }
}
