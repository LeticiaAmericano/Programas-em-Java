import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
class Jogador
{
    private int id = -1;
    private int altura = -1;
    private int peso = -1;
    private int anoNascimento = -1;
    private String nome = "-1";
    private String universidade = "-1";
    private String cidadeNascimento = "-1";
    private String estadoNascimento = "-1";        
    //Construtores
    public  Jogador () 
    {

    }
    public  Jogador (int id, int altura, int peso, int anoNascimento, String nome, String universidade, String cidadeNascimento, String estadoNascimento)
    {
        setid(id);
        setaltura(altura);
        setpeso(peso);
        setanoNascimento(anoNascimento);
        setnome(nome);
        setuniversidade(universidade);
        setcidadeNascimento(cidadeNascimento);
        setestadoNascimento(estadoNascimento);
    }
    //Sets
    public void setid(int id)
    {
        this.id = id;
    }
    public void setaltura(int altura)
    {
        this.altura = altura;
    }
    public void setpeso(int peso)
    {
        this.peso = peso;
    }
    public void setanoNascimento(int anoNascimento)
    {
        this.anoNascimento = anoNascimento;
    }
    public void setnome(String nome)
    {
        this.nome = nome;
    }
    public void setuniversidade(String universidade)
    {
        this.universidade = universidade;
    }
    public void setcidadeNascimento(String cidadeNascimento)
    {
        this.cidadeNascimento = cidadeNascimento;
    }
    public void setestadoNascimento(String estadoNascimento)
    {
        this.estadoNascimento = estadoNascimento;
    }
    //Gets
    public int getid()
    {
        return this.id;
    }
    public int getaltura()
    {
        return this.altura;
    }
    public int getpeso()
    {
        return this.peso;
    }
    public int getanoNascimento()
    {
        return this.anoNascimento;
    }
    public String getnome()
    {
        return this.nome;
    }
    public String getuniversidade()
    {
        return this.universidade;
    }
    public String getcidadeNascimento()
    {
        return this.cidadeNascimento;
    }
    public String getestadoNascimento()
    {
        return this.estadoNascimento;
    }
    //imprimir
    public void imprimir()
    {
        System.out.printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", id, nome, altura, peso, anoNascimento, universidade, cidadeNascimento, estadoNascimento);
    }
    //clone
    public Jogador clone()
    {
        Jogador Atleta = new Jogador();
        setid(id);
        setnome(nome);
        setaltura(altura);
        setpeso(peso);
        setuniversidade(universidade);
        setanoNascimento(anoNascimento);
        setcidadeNascimento(cidadeNascimento);
        setestadoNascimento(estadoNascimento);
        return Atleta;
    }
}
class Pesquisa_Sequencial
{
    static int NCompare;
    //Abrir, Ler e Passar arquivo players para a classe
    public static Jogador [] LeituraArquivo(String[] Entrada)
    {
        Jogador [] Atleta = new Jogador [4000];
        try
        {
            FileReader Arquivo = new FileReader("players.csv");
            BufferedReader LinhaArquivo = new BufferedReader(Arquivo);
            String Linha = LinhaArquivo.readLine();
            String [] Tmp = new String[8];
            int j=0,
            Posicao,
            Inicio,
            i=0,
            a=0;
            while (Linha != null && Entrada[a]!=null)
            {
                Linha = LinhaArquivo.readLine();
                if (Entrada[a].equals(Linha.substring(0,Linha.indexOf(","))))
                {
                    Posicao=0;
                    Inicio=0;
                    for (i=0;i<8;i++)
                    {
                        if (i!=7)
                            Posicao=Linha.indexOf(",", Posicao+1);
                        else
                            Posicao=Linha.length();
                        Tmp[i] = Linha.substring(Inicio,Posicao);
                        if (i!=7)
                            Inicio=Posicao+1;
                    }
                    Atleta[j] = new Jogador();
                    Atleta[j].setid(Integer.parseInt(Tmp[0]));
                    if (!Tmp[1].isEmpty())
                        Atleta[j].setnome(Tmp[1]);
                    else
                        Atleta[j].setnome("nao informado");
                    Atleta[j].setaltura(Integer.parseInt(Tmp[2]));
                    Atleta[j].setpeso(Integer.parseInt(Tmp[3]));
                    if (!Tmp[4].isEmpty())
                        Atleta[j].setuniversidade(Tmp[4]);
                    else
                        Atleta[j].setuniversidade("nao informado");
                    Atleta[j].setanoNascimento(Integer.parseInt(Tmp[5]));
                    if (!Tmp[6].isEmpty())
                        Atleta[j].setcidadeNascimento(Tmp[6]);
                    else
                        Atleta[j].setcidadeNascimento("nao informado");
                    if (!Tmp[7].isEmpty())
                            Atleta[j].setestadoNascimento(Tmp[7]);
                    else
                        Atleta[j].setestadoNascimento("nao informado");
                    j++; 
                    a++;
                }
            }
            LinhaArquivo.close();
            Arquivo.close();
        }
        catch(IOException Erro)
        {
            System.err.printf("Nao foi possivel continuar essa acao");
                Erro.getMessage();
        }
        return Atleta;
    }
    //Ordenacao do vetor por id de Entrada
    public static void Ordenacao (String[] Entrada, int Contador)
    {
        String Tmp;
        int j;
        for (int i=1; i<Contador; i++) 
        {           
            Tmp = Entrada[i];
            j=i-1;
            while ((j>=0) && (Integer.parseInt(Entrada[j])>Integer.parseInt(Tmp)))
            {
                Entrada[j+1] = Entrada[j];
                j--;
            }
            Entrada[j+1] = Tmp;
        }
    }
    //Cria????o da Fun????o Log
    public static void CriaLog(int Matricula, long Tempo) throws IOException
    {
        File Dados = new File("matricula_sequencial.txt");
        Dados.createNewFile();
        FileWriter ArquivoDados = new FileWriter(Dados);
        BufferedWriter EscreverDados = new BufferedWriter(ArquivoDados);
        EscreverDados.write(Integer.toString(Matricula)+"\t"+Long.toString(Tempo)+"\t"+Integer.toString(NCompare));
        EscreverDados.close();
        ArquivoDados.close();
    }
    //Main
    public static void main (String [] args)
    {
        long TempUm = System.currentTimeMillis();
        int i=0,
            Contador = 0;
        String Recepcao;
        String [] Id = new String [4000];
        do
        {
            Recepcao = MyIO.readLine();
            if (!Recepcao.contains("FIM"))
            {
                Id[i] = Recepcao;
                Contador++;
                i++;
            }
        }
        while (!Recepcao.contains("FIM"));
        Ordenacao (Id,Contador);
        Jogador [] Atleta = LeituraArquivo(Id);
        String Entrada = MyIO.readLine();
        Boolean Afirmativa=false;
        while (!Entrada.contains("FIM"))
        {
            Afirmativa=false;
            for(i=0;i!=Contador;i++)
            {
                if (Entrada.contains(Atleta[i].getnome()))
                    Afirmativa=true;
                NCompare++;
            }
            if (Afirmativa)
                MyIO.println("SIM");
            else
                MyIO.println("NAO");
            Entrada = MyIO.readLine();
        }
        try
        {
            CriaLog (691290, System.currentTimeMillis() - TempUm);
        }
        catch (IOException Erro)
        {
            System.err.printf("Nao foi possivel continuar");
            Erro.getMessage();
        }
    }
}
