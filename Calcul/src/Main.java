import java.util.Scanner;                       // библиотеки ввода
public class Main {
    public static void main(String[] args) throws Exception {// МЕТОД

        String input;
        Scanner INPUT = new Scanner(System.in);
        System.out.println("Введите пример:");
        input = INPUT.nextLine();            // Вводим наш пример
        input = input.trim();                // Убираем пробелы
        System.out.print(calc(input));       // Вызываем метод calc для решение и выводим результат
    }
    public static String calc(String input) throws Exception {

        int result=0,operation=0,k=0;
        int [] arabicRim = new int[2];       // массив для определение римское число =1; арабское =2
        boolean trueVal=false;
        char [] trueValue= {'0','1','2','3','4','5','6','7','8','9','+','-','*','/','I','V','X'};     // массив правильных значений
        String[] rimskValue = {"I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};
        char [] symb2= input.toCharArray();
        String str="";
        for (char x2: symb2){if (x2!=' ') str=str+x2;}  // убираем пробелы внутри строки
        input=str;
        int longInput=input.length();
        char [] symb= input.toCharArray();
        for (char x: symb){
            if(x=='+') {
                operation=1;k++;
            }
            if(x=='-') {
                operation=2;k++;
            }
            if(x=='*') {
                operation=3;k++;
            }
            if(x=='/') {
                operation=4;k++;}
        }
        if (k>1) throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)"); //символов больше одного
        if (k<1) throw new Exception("т.к. строка не является математической операцией"); //нет (+, -, /, *)
        //проверяем первый сиввол на +, -, /, *
        if (symb[0]=='+' || symb[0]=='-' || symb[0]=='*' || symb[0]=='/') throw new Exception("т.к. строка не является математической операцией");
        //проверяем последний сиввол на +, -, /, *
        if (symb[longInput-1]=='+' || symb[longInput-1]=='-' || symb[longInput-1]=='*' || symb[longInput-1]=='/') throw new Exception("т.к. строка не является математической операцией");

        for(int i=0; i<longInput; i++) {     // проверка на лишнии буквы или символы в водимой строке
            trueVal=false;
            for(int j=0; j<17; j++) {
                if (symb[i] == trueValue[j]) {trueVal = true; break;}
                //   if (symb[i] == ' ') throw new Exception("т.к. Вы ввели пробел внутри математической операции, что противоречит условиям ввода");
            }
            if (!trueVal) throw new Exception("т.к. Вы ввели символы или буквы несоответствующие параметрам условия ввода");
        }
        // ---------------------------получаем 2 числа между знаком---------------------------------------------------------
        String [] mas= input.split("[+/*-]");int n=0; // делим нашу строку на два элемента массива mas до и после знака
        for (String x: mas) {    // запускаем цикл для сравнения наших двух элементов строк с нужными арабск. числами и римскими
            // присваиваем элементам массива mas[] наши вводимые числа до и после знака если они соответствуют параметрам ввода
            if (x.equals("I")) {mas[n] = "1"; arabicRim[n]=1;}   if (x.equals("II")) {mas[n] = "2";arabicRim[n]=1;}
            if (x.equals("III")) {mas[n] = "3"; arabicRim[n]=1;} if (x.equals("IV")) {mas[n] = "4";arabicRim[n]=1;}
            if (x.equals("V")) {mas[n] = "5"; arabicRim[n]=1;}   if (x.equals("VI")) {mas[n] = "6";arabicRim[n]=1;}
            if (x.equals("VII")) {mas[n] = "7"; arabicRim[n]=1;} if (x.equals("VIII")) {mas[n] = "8";arabicRim[n]=1;}
            if (x.equals("IX")) {mas[n] = "9"; arabicRim[n]=1;}  if (x.equals("X")) {mas[n] = "10";arabicRim[n]=1;}
            if (x.equals("1")) {mas[n] = "1"; arabicRim[n]=2;}   if (x.equals("2")) {mas[n] = "2";arabicRim[n]=2;}
            if (x.equals("3")) {mas[n] = "3"; arabicRim[n]=2;}   if (x.equals("4")) {mas[n] = "4";arabicRim[n]=2;}
            if (x.equals("5")) {mas[n] = "5"; arabicRim[n]=2;}   if (x.equals("6")) {mas[n] = "6";arabicRim[n]=2;}
            if (x.equals("7")) {mas[n] = "7"; arabicRim[n]=2;}   if (x.equals("8")) {mas[n] = "8";arabicRim[n]=2;}
            if (x.equals("9")) {mas[n] = "9"; arabicRim[n]=2;}   if (x.equals("10")) {mas[n] = "10";arabicRim[n]=2;}
            if (x.equals("0")) {mas[n] = "0"; arabicRim[n]=2;}
            // если не соответствуют ни один параметр ввода
            if (arabicRim[n]==0) throw new Exception("т.к. Вы ввели числа несоответствующие условию параметрам ввода");
            n++;          // дополнительный счетчик для массива mas[]
        }
        int a=Integer.parseInt(mas[0]); int b=Integer.parseInt(mas[1]);  //переводим строкоые элементы массива в целые значения
        if (arabicRim[0]!=arabicRim[1]) throw new Exception("т.к. используются одновременно разные системы счисления");
        if (operation==4 && b==0) throw new Exception("т.к. на 0 делить нельзя");
        if (a<b && arabicRim[0]==1 && operation==2) throw  new Exception("т.к. в римской системе нет отрицательных чисел");
        if (a==b && arabicRim[0]==1 && operation==2) throw  new Exception("т.к. в римской системе нет нуля");
        if (a<b && arabicRim[0]==1 && operation==4) throw  new Exception("т.к. первое римское число должно быть не больше второго при делении");
        if (operation==1) result=a+b;
        if (operation==2) result=a-b;
        if (operation==3) result=a*b;
        if (operation==4) result=a/b;

        if (arabicRim[0]==1) {input="="+rimskValue[result-1];
        }
        else { input="="+result; // переводим обратно число полученное арабским вычислением в строку
        }
        return input;
    }
}