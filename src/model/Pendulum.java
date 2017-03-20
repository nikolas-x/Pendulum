package model;

/**
 * Created by nxex3708 on 3/20/2017.
 */
public class Pendulum
{
    private double mass;
    private double length;
    private double angle;

    public Pendulum(double mass,
                    double length,
                    double angle)
    {
        this.mass = mass;
        this.length = length;
        this.angle = angle;
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