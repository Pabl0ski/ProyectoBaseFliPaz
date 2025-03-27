package model;

public class Cliente {
    private int idCliente;
    private String nombreEmpresa;
    private String email;
    private String paginaWeb;
    private String telefono;
    private String nombreContacto;
    private String instagram;
    private String facebook;
    private String canalYoutube;
    private int sectorId;
    private int localidadId;

    public Cliente(int idCliente, String nombreEmpresa, String email, String paginaWeb,
                   String telefono, String nombreContacto, String instagram,
                   String facebook, String canalYoutube, int sectorId, int localidadId) {
        this.idCliente = idCliente;
        this.nombreEmpresa = nombreEmpresa;
        this.email = email;
        this.paginaWeb = paginaWeb;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        this.instagram = instagram;
        this.facebook = facebook;
        this.canalYoutube = canalYoutube;
        this.sectorId = sectorId;
        this.localidadId = localidadId;
    }

    // Getters y setters...

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getCanalYoutube() {
        return canalYoutube;
    }

    public void setCanalYoutube(String canalYoutube) {
        this.canalYoutube = canalYoutube;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public int getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(int localidadId) {
        this.localidadId = localidadId;
    }
}
