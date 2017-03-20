package simulation;

import model.Pendulum;

import java.awt.*;
import javax.swing.*;

/**
 * Created by nxex3708 on 3/20/2017.
 */
public class PendulumSimulation extends JFrame implements Runnable
{
    // Physical variables
    private double gravity = -9.81;
    private double damping = 1.0;
    private Pendulum pendulum;

    public PendulumSimulation(String name, Pendulum pendulum)
    {
        super(name);
        this.pendulum = pendulum;
        this.add(pendulum);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    // Basic pendulum as described by RosettaCode
    // https://rosettacode.org/wiki/Animate_a_pendulum#Java
    @Override
    public void run()
    {
        double angleAcceleration = 0;
        double angleVelocity = 0;
        double deltaT = 0.01;
        while (true)
        {
            angleAcceleration = gravity / pendulum.getLength() * Math.sin(pendulum.getAngle());
            angleVelocity += angleAcceleration * deltaT;
            pendulum.setAngle(pendulum.getAngle() + angleVelocity * deltaT);
            repaint();
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
        }
    }
}
