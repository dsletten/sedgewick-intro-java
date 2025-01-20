//////////////////////////////////////////////////////////////////////////////
//
//   UniformRandom.java
//
//   Description
//
//   Started:           Sat Dec  1 16:08:50 2012
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
import java.util.*;

public class UniformRandom {
    private static final int COUNT = 5;
    public static void main(String[] args) {
        int size = COUNT;
        if ( args.length == 1 ) {
            try {
                int n = Integer.parseInt(args[0]);
                if ( n > 0 ) {
                    size = n;
                }
            } catch (NumberFormatException e) {
            }
        }

        List<Double> nums = getRandomNumbers(size);

        System.out.println("Random numbers: " + nums);
        System.out.println("Average value: " + average(nums));
        System.out.println("Minimum value: " + min(nums));
        System.out.println("Maximum value: " + max(nums));
    }

    private static List<Double> getRandomNumbers(int count) {
        List<Double> result = new ArrayList<Double>();

        for (int i = 0; i < count; i++) {
            result.add(Math.random());
        }
        
        Collections.sort(result);
        return result;
    }

    public static double average(List<? extends Number> nums) {
        if ( nums == null  ||  nums.isEmpty() ) {
            return 0;
        } else {
            double sum = 0;
            for (Number n : nums) {
                sum += n.doubleValue();
            }

            return sum / nums.size();
        }
    }

//     public static <T extends Number> T min(List<T> nums) {
//         return Collections.min(nums);
//     }
    
//     public static <T extends Number> T max(List<T> nums) {
//         return Collections.max(nums);
//     }
    
    private static <T extends Number> T extremum(List<T> nums, Comparator<T> comp) {
        if ( nums == null  ||  nums.isEmpty() ) {
            return null;
        } else {
            T extremum = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                if ( comp.compare(nums.get(i), extremum) < 0 ) {
                    extremum = nums.get(i);
                }
            }

            return extremum;
        }
    }

    public static <T extends Number> T min(List<T> nums) {
        return extremum(nums, new Comparator<T>() {
                public int compare(T o1, T o2) {
                    if ( o1.doubleValue() < o2.doubleValue() ) {
                        return -1;
                    } else if ( o1.doubleValue() > o2.doubleValue() ) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
    }

    public static <T extends Number> T max(List<T> nums) {
        return extremum(nums, new Comparator<T>() {
                public int compare(T o1, T o2) {
                    if ( o1.doubleValue() > o2.doubleValue() ) {
                        return -1;
                    } else if ( o1.doubleValue() < o2.doubleValue() ) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
    }
}
