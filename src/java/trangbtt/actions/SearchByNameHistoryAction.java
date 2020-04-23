/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangbtt.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import trangbtt.daos.CartDAO;
import trangbtt.dtos.CartDTO;

/**
 *
 * @author trang
 */
public class SearchByNameHistoryAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private List<CartDTO> result = null;
    private String user, name, price, quantity, date, searchName;

    public List<CartDTO> getResult() {
        return result;
    }

   
    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SearchByNameHistoryAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        CartDAO dao = new CartDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        result = dao.searchByNameHistory(user, searchName);

        if (result != null) {
            url = SUCCESS;
        } else {
            request.setAttribute("ERROR", "Insert fail");
        }

        return url;
    }

}
