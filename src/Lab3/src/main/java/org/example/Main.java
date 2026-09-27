package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество векторов m: ");
        int m = scanner.nextInt();

        if (m < 3) {
            System.out.println("Для проверки компланарности нужно минимум 3 вектора!");
            return;
        }

        VectorR3[] vectors = new VectorR3[m];

        vectors[0] = new VectorR3(1, 0, 0);
        vectors[1] = new VectorR3(0, 1, 0);
        vectors[2] = new VectorR3(1, 1, 0);

        for (int i = 3; i < m; i++) {
            vectors[i] = new VectorR3(i, i * 2.0, i * 3.0);
        }

        System.out.println("\nСписок векторов:");
        for (int i = 0; i < vectors.length; i++) {
            System.out.printf("v[%d] = %s%n", i, vectors[i]);
        }

        System.out.println("\n--- Проверка ортогональности ---");
        boolean ortho = VectorR3.areOrthogonal(vectors[0], vectors[1]);
        System.out.printf("v[0] и v[1] ортогональны: %b%n", ortho);

        System.out.println("\n--- Проверка пересечения неортогональных векторов ---");
        boolean intersects = vectors[0].intersectsNonOrthogonal(vectors[2]);
        System.out.printf("v[0] пересекает неортогональный v[2]: %b%n", intersects);

        System.out.println("\n--- Сравнение векторов ---");
        boolean equals = vectors[0].areVectorsEqual(vectors[0], vectors[1]);
        System.out.printf("v[0] равен v[1]: %b%n", equals);

        System.out.println("\n--- Поиск компланарных векторов ---");
        boolean foundCoplanar = false;

        for (int i = 0; i < vectors.length; i++) {
            for (int j = i + 1; j < vectors.length; j++) {
                for (int k = j + 1; k < vectors.length; k++) {
                    if (VectorR3.areCoplanar(vectors[i], vectors[j], vectors[k])) {
                        System.out.printf("Компланарны: v[%d], v[%d], v[%d]%n", i, j, k);
                        foundCoplanar = true;
                    }
                }
            }
        }

        if (!foundCoplanar) {
            System.out.println("Компланарных троек векторов не найдено.");
        }
    }
}