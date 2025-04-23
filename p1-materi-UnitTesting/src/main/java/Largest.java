public class Largest {

    public static int largestNumberInArray(int[] numbers) {
        // Inisiasi nilai max dengan nilai terbesar
        int largest = Integer.MIN_VALUE;

        // Looping untuk mencari nilai max
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        // Mengembalikan nilai max
        return largest;
    }
}
