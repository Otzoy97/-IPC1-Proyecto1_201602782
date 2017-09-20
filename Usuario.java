import java.util.Date;

public class Usuario {
    private String nombre;
    private String contrasena;
    private String usuario;
    private int inicial;
    private int maximo;
    private String empresa;
    //
    private String emisor;
    private String receptor;
    //
    private int monto;
    //
    private Date fecha;
    //
    private int denominacion;
    //
    private String transaccion;
    //
    private int actual;
    //

    public Usuario(String nombre, String contrasena, String usuario, int inicial, int maximo, String empresa) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.inicial = inicial;
        this.maximo = maximo;
        this.empresa = empresa;
    }
    
    public Usuario(int actual){
        this.actual =  actual;
    }
    /*
    public Usuario(String usuario, int actual){
        this.usuario = usuario;
        this.actual = actual;
    }
    */
    public Usuario(String emisor, String receptor, int monto, Date fecha, String transaccion) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.monto = monto;
        this.fecha = fecha;
        this.transaccion = transaccion;
    }

    public Usuario(int denominacion, int monto ) {
        this.monto = monto;
        this.denominacion = denominacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getInicial() {
        return inicial;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(int denominacion) {
        this.denominacion = denominacion;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }
    
    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
    
    /*
    public Usuario() {
        this.nombre = "";
        this.contraseña = "";
        this.usuario = "";
        this.inicial = 0;
        this.maximo = 0;
        this.empresa = 0;
        this.emisor = "";
        this.receptor = "";
        this.monto = 0;
        this.fecha = new Date();
        this.denominacion = 0;
        this.transaccion = "";
        this.actual = 0;
    }
    */
}