
public class ClienteConectado {
    
    public IComunicacaoCliente cliente;
    public String ip;

    public ClienteConectado(IComunicacaoCliente cliente, String ip) {
        this.cliente = cliente;
        this.ip = ip;
    }
    
}
