package com.cjava.example.contacts;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by junior on 30/11/17.
 */

public class ContacsEntity implements Serializable {

    private String first_name;
    private String last_name;
    private String company_name;
    private String phone;
    private String url_picture;


    public ContacsEntity(String first_name, String last_name, String company_name, String phone, String url_picture) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_name = company_name;
        this.phone = phone;
        this.url_picture = url_picture;
    }

    public static ArrayList<ContacsEntity> contacsEntities(){
        ArrayList<ContacsEntity> contacsEntities =  new ArrayList<>();

        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://top43dprinting.com/wp-content/uploads/2014/07/Picture-of-person.png"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Red-shouldered_Hawk_%28Buteo_lineatus%29_-_Blue_Cypress_Lake%2C_Florida.jpg/1200px-Red-shouldered_Hawk_%28Buteo_lineatus%29_-_Blue_Cypress_Lake%2C_Florida.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        contacsEntities.add(new ContacsEntity("Juan","Perez","Proinversion","987654321","http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg"));
        return contacsEntities;

    }



    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl_picture() {
        return url_picture;
    }

    public void setUrl_picture(String url_picture) {
        this.url_picture = url_picture;
    }

    public String getFullName() {
        return first_name + " " + last_name;
    }
}