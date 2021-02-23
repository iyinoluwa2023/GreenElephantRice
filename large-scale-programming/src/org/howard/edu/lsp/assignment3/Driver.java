package org.howard.edu.lsp.assignment3;

public class Driver {


    public static void print_test(String test_string){
        System.out.println("------------------------------------------------" + "\n" + test_string + "\n");
    }

    public static void test_clear(IntegerSet test_set){
        // clear test
        test_set.add(5);
        print_test("Clear Method");
        System.out.println("Before: \n" + test_set.toString());
        test_set.clear();
        System.out.println("After: \n" + test_set.toString());
    }

    public static void test_length(IntegerSet test_set, int n) {
        for (int i = 0; i < n; i++) {
            test_set.add(i);
        }
        print_test("Length Method");
        System.out.println("Expected: " + n);
        System.out.println(test_set.toString() + "\n");
        System.out.println("test_set.length(): " + test_set.length());
    }

    public static void main(String[] args) {
        IntegerSet test_set = new IntegerSet();

        test_clear(test_set);
        test_length(test_set, 5);
    }
}
