package simulation;

import model.Pendulum;

import java.awt.*;
import javax.swing.*;

/**
 * Created by nxex3708 on 3/20/2017.
 */
public class PendulumSimulation extends JFrame implements Runnable
{
    private double gravity = 9.81;
    private double damping = 1.0;
    private Pendulum pendulum;

    public PendulumSimulation(String name, Pendulum pendulum)
    {
        super(name);
        this.pendulum = pendulum;
        this.add(pendulum);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    @Override
    public void run()
    {
        this.setVisible(true);
    }
}
