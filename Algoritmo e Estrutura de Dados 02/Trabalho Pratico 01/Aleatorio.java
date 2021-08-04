import java.util.Random;

class Aleatorio
{
    public static void main (String[] args)
    {
        Boolean Fim = false;
        do
        {
            String Entrada = MyIO.readLine();
            int Contador = Entrada.length();
            if (Contador == 3 && Entrada.charAt(0) == 'F' && Entrada.charAt(1) == 'I' && Entrada.charAt(2) == 'M')
                Fim=true;
            else
            {
                char[] Saida = new char [100000];
                Random Gerador = new Random(4);
                char LetraSubstituida = ((char)('a'+(Math.abs(Gerador.nextInt( ))%26)));
                char LetraSubstituta = ((char)('a'+(Math.abs(Gerador.nextInt( ))%26)));
                for (int i=0; i<Contador; i++)
                {
                    Saida[i] = Entrada.charAt(i);
                    if (Entrada.charAt(i)==LetraSubstituida)
                        Saida[i] = LetraSubstituta;
                }
                for (int i=0; i<Contador; i++)
                {
                    MyIO.print(Saida[i]);
                }
                MyIO.println("");
            }
        } 
        while (Fim == false);
    }
}