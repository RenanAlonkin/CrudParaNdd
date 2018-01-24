/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;

import java.sql.Date;

/**
 *
 * @author Renan Nunes Steinck <renan.alonkin@gmail.com>
 */
public class GenericDateVO {

    private int id;
    private String name;
    private Date date;

    public GenericDateVO() {
    }

    public GenericDateVO(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public GenericDateVO(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GenericDateVO{" + "id=" + id + ", name=" + name + ", date=" + date + '}';
    }

}
