class Is
{
    public static void main (String [] args)
    {
        Boolean X1 = true,
                X2 = true,
                X3 = true, 
                X4 = true,
                Fim = false,
                Numero = false;
        do
        {
            String Entrada = MyIO.readLine();
            int Contador = Entrada.length(),
                i = 0,
                j = 0;
            //Verifica se é fim.
            if (Contador == 3 && Entrada.charAt(0) == 'F' && Entrada.charAt(1) == 'I' && Entrada.charAt(2) == 'M')
                Fim=true;
            else
            {
                //Verifica se é letra.
                if (('A' >= Entrada.charAt(i) && Entrada.charAt(i) <= 'Z') || ('a' >= Entrada.charAt(i) && Entrada.charAt(i) <= 'z'))
                {
                    //Anda por cada caracter.
                    for (i=0; i<Contador; i++)
                    {
                        //Verifica se é vogal.
                        Boolean Vogal = Entrada.charAt(i) == 'A' || Entrada.charAt(i) == 'a' || Entrada.charAt(i) == 'E' || Entrada.charAt(i) == 'e' || Entrada.charAt(i) == 'I' || Entrada.charAt(i) == 'i' || Entrada.charAt(i) == 'O' || Entrada.charAt(i) == 'o' || Entrada.charAt(i) == 'U' || Entrada.charAt(i) == 'u';
                        X3 = false;
                        X4 = false;
                        //Enquanto X1 for verdadeiro.
                        if (X1)
                        {
                            if (!Vogal)
                                X1 = false;
                        } 
                        //Enquanto X2 for verdadeiro.
                        if (X2)
                        {
                            if (Vogal)
                            {
                                X2= false;
                            }
                        }
                    }
                }
                else
                {
                    X1 = false;
                    X2 = false;
                    for (i=0; i<Contador; i++)
                    {
                        if (!(('A' >= Entrada.charAt(i) && Entrada.charAt(i) <= 'Z') || ('a' >= Entrada.charAt(i) && Entrada.charAt(i) <= 'z')))
                            Numero = true;
                    }
                    if (Numero)
                    {
                        //Variavel float de acesso para verificação.
                        float RealAlgarismo = Float.valueOf(Entrada).floatValue();
                        int InteiroAlgarismo = Integer.valueOf(Entrada).intValue();;
                        //Se X3 for verdadeiro.
                        if (!(RealAlgarismo == InteiroAlgarismo))
                        {
                            X3 = false;
                        }
                        //Se X4 for verdadeiro.
                        else 
                        {
                            X4 = false;
                        }
                    }
                    else
                    {
                        X3 = false;
                        X4 = false;
                    }
                }
                if (X1)
                {
                    MyIO.println("SIM");
                }
                else
                {
                    MyIO.println("NAO");
                }
                if (X2)
                {    
                    MyIO.println("SIM");
                }
                else
                {
                    MyIO.println("NAO");
                }
                if (X3)
                {
                    MyIO.println("SIM");
                }
                else
                {
                    MyIO.println("NAO");
                }
                if (X4)
                {
                    MyIO.println("SIM");
                }
                else
                {
                    MyIO.println("NAO");
                }
            }
        }
        while (Fim == false);
    }
}