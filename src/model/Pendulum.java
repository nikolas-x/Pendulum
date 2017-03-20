package model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nxex3708 on 3/20/2017.
 */
public class Pendulum extends JPanel
{
    private double mass;
    private double length;
    private double angle;

    public Pendulum()
    {
        this(1,1,0);
    }

    public Pendulum(double mass,
                    double length,
                    double angle)
    {
        this.mass = mass;
        this.length = length;
        this.angle = angle;
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawLine(0, 0, 10, 10);
    }

    public double getMass()
    {
        return mass;
    }

    public double getLength()
    {
        return length;
    }

    public double getAngle()
    {
        return angle;
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
    }
}
