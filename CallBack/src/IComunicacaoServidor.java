
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface IComunicacaoServidor extends Remote {
    
    public void receberCliente(IComunicacaoCliente c) throws RemoteException;
    public void receberMensagemDoCliente(String msg) throws RemoteException;
    List<String> getListaClientes() throws RemoteException;
}
