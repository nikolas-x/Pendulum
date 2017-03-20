import model.Pendulum;
import simulation.PendulumSimulation;

import java.awt.*;
import javax.swing.*;

/**
 * Created by nxex3708 on 3/20/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Pendulum p = new Pendulum();
        PendulumSimulation simulation = new PendulumSimulation("Pendulum", p);
        simulation.run();
    }
}
