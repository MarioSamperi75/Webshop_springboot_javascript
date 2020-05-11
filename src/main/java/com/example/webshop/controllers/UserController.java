package com.example.webshop.controllers;

import com.example.webshop.domain.User;
import com.example.webshop.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    List<User> userList = new ArrayList<>();

    public UserController() {
    }


    //----------------Visa alla Pidunas från DB Json och XML
    @RequestMapping(value = "/userListJSON", produces = "application/json")
    public List<User> userListJson() {
        return userList;
    }

    //    http://localhost:8080//userListXml  funziona solo con dubbel// !!!!!

    @RequestMapping(value = "/userListXML", produces = "application/xml")
    public List<User> userListXml() {
        return userList;
    }


/*
//----------------Visa en Pidun med en path parameter(ID)

    @RequestMapping(value = "/pidunJSON/{id}", produces = "application/json")
    public Pidun getPidunById(@PathVariable int id) {  //@PathVariable ("id") int id
        Pidun result = null;
        for (Pidun p : pidunList)
            if (p.getId() == id) {
                result = p;
                break;
            }
        return result;
    }

    @RequestMapping(value = "/PidunBetween/{idFrom}/{idTo}", produces = "application/json")
    public List<Pidun> getBooksBetween(@PathVariable int idFrom, @PathVariable int idTo){
        List<Pidun> result = new ArrayList();
        for (Pidun b : pidunList){
            int id = b.getId();
            if (id >= idFrom && id <= idTo){
                result.add(b);
            }
        }
        return result;
    }



    @RequestMapping(value = "/pidunJSON/{id}/delete",produces = "application/json")
    public Response deleteByID(@PathVariable int id)
    {
        Response response=new Response("Pidun deleted",false);
        int indexToRemove=-1;
        for (int i = 0; i < pidunList.size(); i++) {
            if(pidunList.get(i).getId()==id)
                indexToRemove=i;

        }
        if(indexToRemove!=-1)
        {
            pidunList.remove(indexToRemove);
            response.setStatus(true);
        }
        else
            response.setMessage("Not found");

        return response;
    }

    @PostMapping("/Pidun/add")
    public Response addBook(@RequestBody Pidun pidun)
    {
        Response response=new Response("Pidun added",false);
        if((pidun.getId()!=0) &&(pidun.getName()!=null) && pidun.getCost()!=0 && pidun.getPrice()!=0 ) {
            pidunList.add(pidun);
            response.setStatus(true);
        }
        else
            response.setMessage("failed to add");
        return response;

    }

*/



}
