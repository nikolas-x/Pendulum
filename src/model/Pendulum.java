package model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nxex3708 on 3/20/2017.
 */
public class Pendulum extends JPanel
{
    private double mass; // kg
    private double length; // m
    private double angle; // rad

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
        setDoubleBuffered(true);
    }

    @Override
    public void paint(Graphics g)
    {
        int pivotX = getWidth() / 2;
        int pivotY = getHeight() / 2;
        int weightX = pivotX + (int) (Math.sin(angle) * getScaledLength());
        int weightY = pivotY + (int) (Math.cos(angle) * getScaledLength());

        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw pivot base
        g2D.setColor(Color.GRAY);
        g2D.fillRect(pivotX - 50, pivotY - 20, 100, 40);

        // Draw rope
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(pivotX,
                pivotY,
                weightX,
                weightY);
        g2D.setStroke(new BasicStroke());

        // Draw pivot
        g2D.fillOval(pivotX - 10, pivotY - 10, 20, 20);

        // Draw
        g2D.setColor(Color.GREEN);
        g2D.fillOval((int)(weightX - getScaledMass()),
                (int)(weightY - getScaledMass()),
                (int)(getScaledMass() * 2),
                (int)(getScaledMass() * 2));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(1000, 1000);
    }

    public double getScaledLength()
    {
        return length * 100;
    }

    public double getScaledMass()
    {
        return mass * 25;
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
