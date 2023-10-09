package org.example;

public class HeapSort {

    public void heapSort(int[] array) {
        int n = array.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Извлечение элементов из кучи по одному
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    void heapify(int[] array, int n, int i) {
        int largest = i; // Инициализируем largest как корень
        int left = 2 * i + 1; // Левый дочерний элемент
        int right = 2 * i + 2; // Правый дочерний элемент

        // Если левый дочерний элемент больше корня
        if (left < n && array[left] > array[largest])
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && array[right] > array[largest])
            largest = right;

        // Если самый большой элемент не является корнем
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Рекурсивная процедура heapify для поддерева
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);

        System.out.println("Отсортированный массив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

