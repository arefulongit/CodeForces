import java.util.HashMap;

/**
 * В популярных системах электронных таблиц (например, в программе Excel) используется следующая нумерация колонок.
 * Первая колонка имеет номер A, вторая B и т.д. до 26-ой, которая обозначается буквой Z.
 * Затем идут двухбуквенные обозначения: 27-ая обозначается как AA, 28-ая как AB, а 52-я обозначается парой AZ.
 * Аналогично, следом за ZZ следуют трехбуквенные обозначения и т.д.
 * Строки обычно обозначаются целыми числами от 1. Номер ячейки получается конкатенацией обозначений для столбца и строки.
 * Например, BC23 это обозначение для ячейки в столбце 55, строке 23.
 * Иногда используется другая форма записи: RXCY, где X и Y это целые числа, обозначающие номер строки и столбца,
 * соответственно. Например, R23C55 это ячейка из примера выше.
 * Ваша задача написать программу, которая считывает последовательность обозначений ячеек и выводит каждое из обозначений
 * в другой форме записи.
 * Входные данные
 * В первой строке записано целое число n (1 ≤ n ≤ 105), количество обозначений в тесте. Далее идет n строк,
 * каждая из которых содержит обозначение. Известно, что все обозначения корректны, и не содержат ячейки с номерами строк
 * или столбцов больших 106.
 * Выходные данные
 * Выведите n строк — каждая строка должна содержать обозначение ячейки в отличной форме записи.
 * Примеры
 * входные данныеСкопировать
 * 2
 * R23C55
 * BC23
 * выходные данныеСкопировать
 * BC23
 * R23C55
 */
public class cf_00001b {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public HashMap<String,String> generate(){
        return null;
    }



    public String getDecode(String pStr){

    }
}
