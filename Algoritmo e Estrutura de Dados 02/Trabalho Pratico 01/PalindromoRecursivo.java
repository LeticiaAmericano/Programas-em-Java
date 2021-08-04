public class PalindromoRecursivo
{
    public static Boolean Palindromo (String Entrada)
    {
        return PalindromoR(Entrada, Entrada.length(), 0);
    }
    public static Boolean PalindromoR (String Entrada, int Contador, int i)
    {
        Boolean Palindromo = true;
        Boolean Resposta = true;
        if ( i<Contador )
        {
            if(Entrada.charAt(i)!=Entrada.charAt(Contador-1-i))
            {
                Palindromo = false;
                Resposta = false;
            }
            Palindromo = PalindromoR (Entrada, Contador, ++i);
        }
        if (Resposta == false)
            Palindromo = Resposta;
        return Palindromo;
    }
    public static void main (String[] args)
    {
        Boolean Fim = false;
        do
        {
            String Entrada = MyIO.readLine();
            if (Entrada.length() == 3 && Entrada.charAt(0) == 'F' && Entrada.charAt(1) == 'I' && Entrada.charAt(2) == 'M')
                Fim=true;
            else 
            {
                Boolean Resposta = Palindromo (Entrada);
                if (Resposta == true)
                {
                    MyIO.println("SIM");
                }
                else 
                {
                    MyIO.println("NAO");
                }
            }
        }
        while (Fim==false);
        //Faça ... enquanto fim não aparecer
    }
}