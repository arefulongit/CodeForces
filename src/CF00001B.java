import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;

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


public class CF00001B {

    static final char[] CHARS1 = new char[]{
            'Z', 'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'L', 'M','N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y'
    };

    static final int BASE1 = CHARS1.length;

    static final char[] CHARS2 = new char[]{
            '@','A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'L', 'M','N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y','Z'
    };

    static final int BASE2 = CHARS2.length;

    static final int[] ASC_N = {
            1,
            BASE1,
            BASE1 * BASE1,
            BASE1 * BASE1 * BASE1,
            BASE1 * BASE1 * BASE1 * BASE1,
            BASE1 * BASE1 * BASE1 * BASE1 * BASE1
    };

    public static void main(String[] args) throws IOException {
        String[] strs = null;
        CF00001B cf = new CF00001B();
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        strs = new String[times];
        for (int c = 0; c < times; c++) {
            strs[c] = sc.next();
        }
        for (int c = 0; c < times; c++) {
            System.out.println(cf.sort(strs[c]));
        }
    }

    public String sort(String pStr) {
        Function<String, String> converterFunction = null;
        Pattern rcPattern = Pattern.compile("^R[0-9]{1,10}C[0-9]{1,10}$");
        Pattern a1Pattern = Pattern.compile("^[A-Z]{1,10}[0-9]{1,10}$");
        if (a1Pattern.matcher(pStr).find()) {
            converterFunction = convertA1ToRC;
        } else if (rcPattern.matcher(pStr).find()) {
            converterFunction = convertRCToA1;
        }
        return converterFunction.apply(pStr);
    }

    public Function<String, String> convertRCToA1 = pStringForConversion -> {
        String[] strs = pStringForConversion
                .replace("R", "")
                .split("C");
        String rowNumber = strs[0];
        String columnNumber = strs[1];
        String columnName = getColumnNameByColumnNumber(columnNumber);
        return columnName + rowNumber;
    };

    public Function<String, String> convertA1ToRC = pStringForConversion -> {
        String letters = new StringBuilder(
                pStringForConversion
                        .replaceAll("[0-9]", "")
        ).reverse().toString();
        String digits = pStringForConversion.replaceAll("[A-Z]", "");
        int indexInN = 0;
        int columnNumber = 0;
        for (char letter : letters.toCharArray()) {
            int letterIndexInChars = Arrays.binarySearch(CHARS2, letter);
            columnNumber = columnNumber + ASC_N[indexInN] * letterIndexInChars;
            indexInN++;
        }
        return "R" + digits + "C" + columnNumber;
    };

    public String getColumnNameByColumnNumber(String pColumnNumber) {
        int columnNumber = Integer.parseInt(pColumnNumber);
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (columnNumber < BASE1) {
                sb.append(CHARS1[columnNumber]);
                break;
            }
            int frequent = columnNumber / BASE1;
            int remainder = columnNumber % BASE1;
            if (remainder == 0) {
                if (columnNumber >= BASE1) {
                    columnNumber = frequent - 1;
                    if (columnNumber == 0) {
                        sb.append(CHARS1[remainder]);
                        break;
                    }
                } else {
                    columnNumber = frequent;
                }
            } else {
                columnNumber = frequent;
            }
            sb.append(CHARS1[remainder]);
        }
        return sb.reverse().toString();
    }
}
