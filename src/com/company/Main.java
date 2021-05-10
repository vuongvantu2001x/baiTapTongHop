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
                    System.out.print("Mảng vừa nhập :");
                    displayArr(arr, size);
                    break;
                case 3:
                    System.out.print("Số chẵn lớn nhất trong mảng là :" + findMaxEven(arr, size));
                    break;
                case 4:
                    System.out.println("Các phần tử chẵn trong mảng là :");
                    arrayEven(arr, size);
                    break;
                case 5:
                    System.out.println("Tổng các số chẵn trong mảng là : " + sumEven(arr, size));
                    break;
                case 6:
                    addElement(arr, size);
                    break;
                case 7:
                    deleteElement(arr, size);
                    break;
                case 8:
                    reverseArray(arr, size);
                    break;
                case 9:
                    System.out.println("Các số nguyên tố có trong mảng là :");
                    arrayPrime(arr, size);
                    break;
                case 10:
                case 11:
                    System.exit(0);
                    break;
            }
        } while (choice >= 1 && choice <= 11);
    }

    static void menu() {
        System.out.println("\n========MENU========");
        System.out.println("1. Nhập kích thước của mảng (0<N<100):");
        System.out.println("2. Hiển thị mảng vừa nhập");
        System.out.println("3. Tìm số chẵn lớn nhất trong mảng");
        System.out.println("4. Liệt kê danh sách các số chẵn trong mảng");
        System.out.println("5. Tổng các số chẵn trong mảng");
        System.out.println("6. Nhập giá trị và vị trí cần chèn vào mảng");
        System.out.println("7. Xóa các phần tử có giá trị bằng X (nhập X từ bàn phím)");
        System.out.println("8. Đảo ngược mảng ban đầu");
        System.out.println("9. Hiển thị danh sách các số nguyên trong mảng");
        System.out.println("10. Sắp xếp mảng theo thứ tự giảm dần");
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
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int findMaxEven(int[] arr, int N) {
        int max = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] % 2 == 0 && arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int arrayEven(int[] arr, int N) {
        int[] arrNew = new int[N];
        int x = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                arrNew[x] = arr[i];
                x++;
            }
        }
        for (int i = 0; i < x; i++) {
            System.out.print(arrNew[i] + " ");
        }
        return arrNew[x];
    }

    static int sumEven(int[] arr, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    static int addElement(int[] arr, int N) {
        int arrNew[] = new int[N + 1];
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập giá trị cần thêm : ");
        int input = sc.nextInt();
        System.out.println("Nhập vị trí cần thêm vào : ");
        int index = sc.nextInt();

        if (index <= 1 || index >= arr.length - 1) {
            System.out.println("Mảng không thêm được");
        } else {
            for (int i = index; i < N + 1; i++) {
                int temp = arr[index];
                arr[index] = arr[i + 1];
                arr[i + 1] = temp;
            }
            arr[index] = input;
        }
        System.out.print("Mảng sau khi thêm :");
        for (int i = 0; i < N + 1; i++) {
            System.out.print(arr[i] + " ");
        }
        return arrNew[N];
    }

    static int seachElement(int[] arr, int N, int X) {
        for (int i = 0; i < N; i++) {
            if (arr[i] == X) {
                return i;
            }
        }

        return -1;
    }

    static void deleteElement(int[] arr, int N) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập X cần xóa : ");
        int X = sc.nextInt();
        int pos = seachElement(arr, N, X);
        int count = 0;
            while (pos!=-1){
                for (int i = 0; i < N-count; i++) {
                    arr[i]=arr[i+1];
                }
                count++;
                pos = seachElement(arr, N, X);
            }
        System.out.print("Mảng sau khi xóa : ");
        for (int i = 0; i < N-count; i++) {
            System.out.print(arr[i]+" ");
        }

    }

    static void reverseArray(int[] arr, int N) {
        for (int i = 0; i < N / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[N - i - 1];
            arr[N - i - 1] = temp;
        }
        System.out.println("Mảng sau khi đảo là : ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void arrayPrime(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            boolean checkPrime = true;
            if (arr[i] < 2) {
                checkPrime = false;
            } else {
                for (int j = 2; j < arr[i]; j++) {
                    if (arr[i]%j==0){
                        checkPrime=false;
                        break;
                    }
                }
            }
            if (checkPrime) {
                System.out.print(arr[i] + " ");
            }

        }
    }


}
