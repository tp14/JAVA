import java.util.Scanner;

public class RemocaoConsoanteVogal{
public static void main(String [] args) {
    Scanner in = new Scanner(System.in);
  
   System.out.println("Digite uma palavra ou frase:");
   String str, rem;
   str = in.nextLine();
   int tama = str.length();
   System.out.println("Digite 'c' para remover consoantes e 'v' para vogais:");
   rem = in.nextLine();
   
   if (rem.equals("v")){
     for(int i=0;i < tama; i++){
        if ((str.charAt(i) != 'A') && (str.charAt(i) != 'a')&&(str.charAt(i) != 'E')&&(str.charAt(i) != 'e')&&(str.charAt(i) != 'I')&&(str.charAt(i) != 'i')&&(str.charAt(i) != 'O')&&(str.charAt(i) != 'o')&&(str.charAt(i) != 'U')&&(str.charAt(i) != 'u'))
        System.out.printf("%s", str.charAt(i));                        
    }
   }else {
    for(int i=0;i<tama; i++){
        if ((str.charAt(i) == 'A') || (str.charAt(i) == 'a')||(str.charAt(i) == 'E')||(str.charAt(i) == 'e')||(str.charAt(i) == 'I')||(str.charAt(i) == 'i')||(str.charAt(i) == 'O')||(str.charAt(i) == 'o')||(str.charAt(i) == 'U')||(str.charAt(i) == 'u')||(str.charAt(i) == ' '))
        System.out.printf("%s", str.charAt(i));
    }
   }  
}
}
