import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComunicacaoServidor extends UnicastRemoteObject implements IComunicacaoServidor {

    IComunicacaoCliente c;
    ServidorFrame s;
    private List<ClienteConectado> clientes = new ArrayList<>();

    public ComunicacaoServidor(ServidorFrame s) throws RemoteException {
        this.s = s;
    }

    @Override
    public void receberCliente(IComunicacaoCliente c) throws RemoteException {
        try {
            String ip = RemoteServer.getClientHost();
            clientes.add(new ClienteConectado(c, ip));
            s.adicionaMsg("Cliente conectado: " + ip);
        } catch (ServerNotActiveException ex) {
            clientes.add(new ClienteConectado(c, "desconhecido"));
            s.adicionaMsg("Cliente conectado (IP desconhecido)");
        }
    }

    @Override
    public void receberMensagemDoCliente(String msg) throws RemoteException {
        try {
            // Pega o IP do cliente
            String ipCliente = RemoteServer.getClientHost();

            // Pega data e hora atual
            String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

            s.adicionaMsg(dataHora + " " + ipCliente + " " + msg);
        } catch (ServerNotActiveException ex) {
            ex.printStackTrace();
        }
    }

    public void enviaMsgProCliente(String msg) {
        for (ClienteConectado cli : clientes) {
            try {
                cli.cliente.receberMensagemDoServidor(msg);
            } catch (RemoteException ex) {
                s.adicionaMsg("Erro ao enviar mensagem para " + cli.ip);
            }
        }
    }
    
    @Override
    public List<String> getListaClientes() throws RemoteException {
        List<String> lista = new ArrayList<>();
        for (ClienteConectado cli : clientes) {
            lista.add("Cliente IP: " + cli.ip);
        }
        return lista;
    }
    
}
