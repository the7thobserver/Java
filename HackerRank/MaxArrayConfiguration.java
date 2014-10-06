public class MaxArrayConfiguration {
    public static void main(String[] args) {
        int[] array = { 20, 30, 10 };

        System.out.println("The maximum configuration value for the array is: " + maxValue(array));
    }

    public static int maxValue(int[] array) {
        if (array == null || array.length == 0) {
            // You can return whatever you want here or throw an exception...
            return 0;
        }

        int n = array.length;
        int sum = sum(array);
        int previousValue = value(array);
        int maxValue = previousValue;

        for (int i = 0; i < n - 1; i++) {
            int nextValue = previousValue + (n-1)*array[i] - (sum - array[i]);
            previousValue = nextValue;

            if (nextValue > maxValue) {
                maxValue = nextValue;
            }
        }

        return maxValue;
    }

    public static int sum(int[] array) {
        int n = array.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += array[i];
        }

        return sum;
    }

    public static int value(int[] array) {
        int n = array.length;
        int value = 0;

        for (int i = 0; i < n; i++) {
            value += (i+1) * array[i];
        }

        return value;
    }
}