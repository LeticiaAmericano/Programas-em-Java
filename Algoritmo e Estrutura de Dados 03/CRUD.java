import java.io.*;
import java.lang.reflect.Constructor;

class CRUD <T extends Registro>
{
    RandomAccessFile arquivo;
    Constructor<T> construtor;
    String nomeArquivo;

    public CRUD(Constructor<t> construtor, String nome) throws IOException
    {
        this.nomeArquivo = nome;
        this.construtor = construtor;
        arquivo = new RandomAccessFile(this.nomeArquivo, "rw");
        if (arquivo.length() == 0)
            arquivo.writeInt(0);
    }

    public int create(T objeto) throws IOException
    {
        arquivo.seek(0);
        int ultimoId = arquivo.readInt();
        if(ultimoId == -1)
            arquivo.writeInt(ultimoId);
        objeto.setID(ultimoId + 1);
        arquivo.seek(0);
        arquivo.writeInt(objeto.getID());
        arquivo.seek(arquivo.length());
        byte [] registro = objeto.toByteArray();
        arquivo.writeByte(" ");
        arquivo.writeInt(registro.length());
        arquivo.write(registro);
        return objeto.getID();
    }
    public T read(int id) throws Exception
    {
        arquivo.seek(4);
        byte [] registro;
        int tamanhoRegistro;
        byte lapide;
        T objeto; 
        while(arquivo.getFilePointer() < arquivo.length())
        {   
            lapide = arquivo.readByte();
            tamanhoRegistro = arquivo.readInt();
            registro - new byte [tamanhoRegistro];
            arquivo.read(registro);
            if (lapide == ' ')
            {
                objeto = this.construtor.newInstance();
                objeto.fromByteArray(registro);
                if(objeto.getID() = id)
                {
                    return objeto;
                }
            }
        }
        return null;
    }
    public boolean update(novoObjeto) throws Exception
    {
        arquivo.seek(4);
        long ponteiro;
        byte [] registroAtual;
        byte [] registroNovo;
        int tamanhoRegistroAtual;
        byte lapide;
        T objetoAtual;
        while(arquivo.getFilePointer() < arquivo.length())
        {
            ponteiro = arquivo.getFilePointer();
            lapide = arquivo.readByte();
            tamanhoRegistroAtual = arquivo.readInt();
            registroAtual = new byte [tamanhoRegistroAtual];
            arquivo.read(requistroAtual);
            if(lapide == ' ')
            {
                objetoAtual = this.construtor.newInstance();
                objetoAtual.fromByteArray(registroAtual);
                if(objetoAtual.getID() == objetoNovo.getID())
                {
                    registroNovo = objetoNovo.toByteArray();
                    if(registroNovo.length() < tamanhoRegistroAtual)
                    {
                        arquivo.seek(ponteiro + 5);
                        arquivo.write(registroNovo);
                    }
                    else
                    {
                        arquivo.seek(ponteiro);
                        arquivo.writeByte('*');
                        arquivo.seek(arquivo.length());
                        arquivo.writeByte(' ');
                        arquivo.writeInt(registroNovo.length());
                        arquivo.write(registroNovo);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(int id) throws Exception 
    {
        arquivo.seek(4);
        long ponteiro;
        byte[] registro;
        int tamanhoRegistro;
        byte lapide;
        T objeto;
        while (arquivo.getFilePointer() < arquivo.length()) 
        {
            ponteiro = arquivo.getFilePointer();
            lapide = arquivo.readByte();
            tamanhoRegistro = arquivo.readInt();
            registro = new byte[tamanhoRegistro];
            arquivo.read(registro);
            if (lapide == ' ') 
            {
                objeto = this.construtor.newInstance();
                objeto.fromByteArray(registro);
                if (objeto.getID() == id) 
                {
                    arquivo.seek(ponteiro);
                    arquivo.writeByte('*');
                    return true;
                }
            }
        }
        return false;
    }
}
