import java.util.Date;

public class PedidoClient {

    int id;
    String cliente;
    String praia;
    Date data;
    int hora;
    int nPessoas;

    public PedidoClient() {

    }

    public PedidoClient(int id, String cliente, String praia, Date data, int hora, int nPessoas) {
        this.id = id;
        this.cliente = cliente;
        this.praia = praia;
        this.data = data;
        this.hora = hora;
        this.nPessoas = nPessoas;
    }


}
