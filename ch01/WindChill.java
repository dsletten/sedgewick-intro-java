//////////////////////////////////////////////////////////////////////////////
//
//   WindChill.java
//
//   Description
//
//   Started:           Sat Nov 24 19:57:10 2012
//   Modifications:
//
//   Purpose:
//
//   Calling Sequence:
//
//
//   Inputs:
//
//
//   Outputs:
//
//
//   Example:
//
//   Notes:
//
//////////////////////////////////////////////////////////////////////////////
import utils.CommandLine;

public class WindChill {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 2) ) {
            try {
                double temperature = Double.parseDouble(args[0]);
                double windSpeed = Double.parseDouble(args[1]);

                if ( !isValidTemperature(temperature)  ||  !isValidWindSpeed(windSpeed) ) {
                    throw new IllegalArgumentException("Invalid input for formula.");
                } else {
                    System.out.println(computeWindChill(temperature, windSpeed));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(WindChill.class, "t", "v");
        }
    }

    public static boolean isValidTemperature(double temperature) {
        return Math.abs(temperature) <= 50;
    }

    public static boolean isValidWindSpeed(double windSpeed) {
        return windSpeed >= 3  &&  windSpeed <= 120;
    }

    public static double computeWindChill(double temperature, double windSpeed) {
        if ( !isValidTemperature(temperature)  ||  !isValidWindSpeed(windSpeed) ) {
            throw new IllegalArgumentException("Invalid input for formula.");
        } else {
            return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        }
    }        
}
