package future.demo;

public class Response {


    private String id;
    private String mes;

    public Response(String id, String mes) {
        this.id = id;
        this.mes = mes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' +
                ", mes='" + mes + '\'' +
                '}';
    }
}
