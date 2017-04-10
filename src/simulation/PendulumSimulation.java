package simulation;

import model.Pendulum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PendulumSimulation extends JFrame implements Runnable
{
    //
    // Defaults
    private static final double DEFAULT_GRAVITY = -9.81;
    private static final double DEFAULT_TIMESTEP = 0.05;

    // Physical variables
    private double gravity = DEFAULT_GRAVITY;
    private double damping = 1;
    private double timestep = DEFAULT_TIMESTEP;
    private Pendulum pendulum;

    public PendulumSimulation(String name, Pendulum pendulum)
    {
        super(name);
        this.pendulum = pendulum;
        this.add(pendulum);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        // Update the pendulum's position when the screen is clicked
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent me)
            {
                pendulum.setAngle((Math.PI / 2) - getAngleFromCentre(me.getPoint()));
                pendulum.reset();
                repaint();
            }
        });
    }

    // Adapted from RosettaCode and Matthew Pete Kelly's Pendulum tutorial
    // https://rosettacode.org/wiki/Animate_a_pendulum#Java
    // http://www.matthewpeterkelly.com/tutorials/simplePendulum/index.html
    @Override
    public void run()
    {
        // TODO: set up game loop
        while (true)
        {
            pendulum.update(gravity, damping, timestep);
            repaint();
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
        }
    }

    // Returns the angle between the given point and the center
    // (Note: This is NOT the same as the angle between the pendulum and its axis)
    private double getAngleFromCentre(Point target)
    {
        return Math.atan2(target.y - (getHeight() / 2),
                target.x - (getHeight() / 2));
    }

    @Override
    public Dimension getPreferredSize()
    {
        int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int preferredHeight = (int)(screenHeight * 0.95);
        return new Dimension(preferredHeight, preferredHeight);
    }

    // Getters and Setters

    public double getGravity()
    {
        return gravity;
    }

    public void setGravity(double gravity)
    {
        this.gravity = gravity;
    }

    public double getDamping()
    {
        return damping;
    }

    public void setDamping(double damping)
    {
        this.damping = damping;
    }

    public double getTimestep()
    {
        return timestep;
    }

    public void setTimestep(double timestep)
    {
        this.timestep = timestep;
    }

    public Pendulum getPendulum()
    {
        return pendulum;
    }

    public void setPendulum(Pendulum pendulum)
    {
        this.pendulum = pendulum;
    }
}
