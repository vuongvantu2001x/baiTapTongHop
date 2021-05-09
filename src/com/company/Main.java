package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int choice;
        int arr[] = new int[100];
        int size = 0;
        Scanner sc = new Scanner(System.in);
        do {
            menu();
            System.out.print("Nhập lựa chọn : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    size = inputSize();
                    inputArr(arr, size);
                    break;
                case 2:
                    displayArr(arr, size);
                    break;
                case 3:
                    findMaxEven(arr, size);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
            }
        } while (choice >= 1 && choice <= 11);
    }

    static void menu() {
        System.out.println("\n========MENU========");
        System.out.println("1. Nhập kích thước của mảng (0<N<100):");
        System.out.println("2. Hiển thị mảng vừa nhập");
        System.out.println("3. Tìm số chẵn lớn nhất trong mảng");
        System.out.println("4. Liệt kê danh sách các số chẵn trong mảng");
//        System.out.println("5. Tổng các số chẵn trong mảng");
//        System.out.println("6. Nhập giá trị và vị trí cần chèn vào mảng");
//        System.out.println("7. Xóa các phần tử có giá trị bằng X (nhập X từ bàn phím)");
//        System.out.println("8. Đảo ngược mảng ban đầu");
//        System.out.println("9. Hiển thị danh sách các số nguyên trong mảng");
//        System.out.println("10. Sắp xếp mảng theo thứ tự giảm dần");
        System.out.println("11. Thoát");
    }

    static int inputSize() {
        int N;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập kích thước mảng (0<N<100) :");
            N = sc.nextInt();
        } while (N <= 0 || N >= 100);
        return N;
    }

    static void inputArr(int[] arr, int N) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập phần tử của mảng :");
        for (int i = 0; i < N; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }
    }

    static void displayArr(int[] arr, int N) {
        System.out.print("Mảng vừa nhập :");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int findMaxEven(int[] arr, int N) {
        System.out.print("Số chẵn lớn nhất trong mảng là :");
        int max = arr[0];
        for (int i = 1; i < N; i++) {
            if (i % 2 == 0 && arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


}
