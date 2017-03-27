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
    private double damping = 5;
    private double timestep = 0.05;
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
        double mass, length, angle;
        while (true)
        {
            mass = pendulum.getMass();
            length = pendulum.getLength();
            angle = pendulum.getAngle();

            angleAcceleration = gravity / length * Math.sin(angle)
                                - (damping / (mass * length * length)) * angleVelocity;
            angleVelocity += angleAcceleration * timestep;
            pendulum.setAngle(angle + angleVelocity * timestep);
            repaint();
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
        }
    }
}
