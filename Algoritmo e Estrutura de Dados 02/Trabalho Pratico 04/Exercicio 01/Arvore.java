import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
//Nó
class No
{
    String elemento;
    No esquerdo;
    No direito;
    
    No(String elemento)
    {
        this.elemento = elemento;
        this.esquerdo = null;
        this.direito = null;
    }
    No(String elemento, No esquerdo, No direito)
    {
        this.elemento = elemento;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }
}
//Árvore Binária
class ArvoreBinaria
{
    private No raiz;

    public ArvoreBinaria()
    {
        raiz = null;
    }
    public void inserir(String x)
    {
        raiz = inserir(x, raiz);
    }
    public No inserir (String x, No i)
    {
        try
        {
            if(i==null)
            {
                i = new No(x);
                Arvore.NCompare++;
            }
            else if(x.compareTo(i.elemento)<0)
            {
                Arvore.NCompare++;
                i.esquerdo = inserir(x, i.esquerdo);
            }
            else if(x.compareTo(i.elemento)>0)
            {
                Arvore.NCompare++;
                i.direito = inserir(x, i.direito);
            }
        }
        catch(Exception erro)
        {
            erro.printStackTrace();
        }
        return i;
    }
    public void inserirPai(String x)
    {
        try
        {
            if(raiz==null)
            {
                Arvore.NCompare++;
                raiz = new No(x);
            }
            else if(x.compareTo(raiz.elemento)<0)
            {
                Arvore.NCompare++;
                inserirPai(x, raiz.esquerdo, raiz);
            }
            else if(x.compareTo(raiz.elemento)>0)
            {
                Arvore.NCompare++;
                inserirPai(x, raiz.direito, raiz);
            }
        }
        catch(Exception erro)
        {
            erro.printStackTrace();
        }
    }
    public void inserirPai(String x, No i, No pai)
    {
        try
        {
            if(i==null)
            {
                Arvore.NCompare++;
                if(x.compareTo(pai.elemento)<0)
                {
                    Arvore.NCompare++;
                    pai.esquerdo = new No(x);
                }
                else
                {
                    Arvore.NCompare++;
                    pai.direito = new No(x);
                }
            }
            else if(x.compareTo(i.elemento)<0)
            {
                Arvore.NCompare++;
                inserirPai(x, i.esquerdo, i);
            }
            else if(x.compareTo(i.elemento)>0)
            {
                Arvore.NCompare++;
                inserirPai(x, i.direito, i);
            }
        }
        catch(Exception erro)
        {
            erro.printStackTrace();
        }
    }
    public boolean pesquisar(String x)
    {
        return pesquisar(x, raiz);
    }
    public boolean pesquisar(String x, No i)
    {
        boolean resp;
        if(i==null)
        {
            Arvore.NCompare++;
            resp = false;
            MyIO.println("NAO");
        }
        else if(x.equals(i.elemento))
        {
            Arvore.NCompare++;
            resp = true;
            MyIO.println("SIM");
        }
        else if(x.compareTo(i.elemento)<0)
        {
            Arvore.NCompare++;
            MyIO.print("esq ");
            resp = pesquisar(x, i.esquerdo);
        }
        else
        {
            MyIO.print("dir ");
            resp = pesquisar(x, i.direito);
        }
        return resp;
    }
}
//Jogador
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
public class Arvore
{
    static int Contador;
    static int NCompare;
    //Abrir, Ler e Passar arquivo players para a classe
    public static Jogador [] LeituraArquivo()
    {
        Jogador [] Atleta = new Jogador [4000];
        try
        {
            FileReader Arquivo = new FileReader("/tmp/players.csv");
            BufferedReader LinhaArquivo = new BufferedReader(Arquivo);
            String Linha = LinhaArquivo.readLine();
            Linha=LinhaArquivo.readLine();
            String [] Tmp = new String[8];
            String Excecao;
            int j=0;
            int Posicao=0;
            int Inicio=0;
            int i=0;
            while(Linha != null)
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
                    if (!Tmp[i].isEmpty() && Tmp[i].charAt(0) == '\"')
                    {  
                        Posicao=Linha.indexOf(",", Posicao+1);
                        Inicio=Posicao+1;
                        Excecao = Linha.substring(Inicio,Posicao);
                        Tmp[i] = Tmp[i] +","+ Excecao;
                        i--;
                    }
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
                Linha=LinhaArquivo.readLine();
                j++; 
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
    //Criação da Função Log
    public static void CriaLog(int Matricula, long Tempo) throws IOException
    {
        File Dados = new File("arvoreBinaria.txt");
        Dados.createNewFile();
        FileWriter ArquivoDados = new FileWriter(Dados);
        BufferedWriter EscreverDados = new BufferedWriter(ArquivoDados);
        EscreverDados.write(Integer.toString(Matricula)+"\t"+Integer.toString(NCompare)+"\t"+"\t"+Long.toString(Tempo));
        EscreverDados.close();
        ArquivoDados.close();
    }
    public static void main (String [] args)
    {
        long TempUm = System.currentTimeMillis();
        NCompare = 0;
        Jogador [] atleta = LeituraArquivo();
        String entrada = MyIO.readLine();
        ArvoreBinaria No = new ArvoreBinaria();
        while(!entrada.contains("FIM"))
        {
            No.inserir(atleta[Integer.parseInt(entrada)].getnome());
            entrada=MyIO.readLine();
        }
        String nomes = MyIO.readLine();
        while(!nomes.contains("FIM"))
        {
            MyIO.print(nomes+" raiz ");
            No.pesquisar(nomes);
            nomes = MyIO.readLine();
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
