package model;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 28.11.12
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */

public class Types {
    private int id;
    private String types;



    public Types(){

    }

    public Types( int id, String types) {
        this.id = id;
        this.types = types;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
