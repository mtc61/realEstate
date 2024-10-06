package com.talhacelik;

import com.talhacelik.dao.AgentDAO;
import com.talhacelik.dao.BuyerDAO;
import com.talhacelik.dao.PropertyDAO;
import com.talhacelik.dao.SellerDAO;
import com.talhacelik.model.Agent;
import com.talhacelik.model.Buyer;
import com.talhacelik.model.Property;
import com.talhacelik.model.Seller;

import java.math.BigDecimal;

public class AppMain {
    public static void main(String[] args) {

        AgentDAO agentDAO = new AgentDAO();
        BuyerDAO buyerDAO = new BuyerDAO();
        PropertyDAO propertyDAO = new PropertyDAO();
        SellerDAO sellerDAO = new SellerDAO();

        Agent agent = new Agent();
        agent.setAgentName("MTC EMLAK");
        agent.setPhone("5336161");
        agent.setEmail("mtc61@gmail.com");
        agent.setOfficeAddress("Trabzon-Ortahisar");
        agentDAO.saveOrUpdate(agent);

        Agent agent2 = new Agent();
        agent2.setAgentName("REIS EMLAK");
        agent2.setPhone("5336100");
        agent2.setEmail("clk61@gmail.com");
        agent2.setOfficeAddress("Trabzon-Arsin");
        agentDAO.saveOrUpdate(agent2);

        Buyer buyer = new Buyer();
        buyer.setFirstName("Mustafa");
        buyer.setLastName("Bey");
        buyer.setEmail("61@gmail.com");
        buyer.setPhone("5006161");
        buyerDAO.saveOrUpdate(buyer);

        Buyer buyer2 = new Buyer();
        buyer2.setFirstName("Talha");
        buyer2.setLastName("Bey");
        buyer2.setEmail("0061@gmail.com");
        buyer2.setPhone("616161");
        buyerDAO.saveOrUpdate(buyer2);

        Seller seller = new Seller();
        seller.setFirstName("Hatice");
        seller.setLastName("Hanım");
        seller.setEmail("7661@gmail.com");
        seller.setPhone("767676");
        sellerDAO.saveOrUpdate(seller);

        Seller seller2 = new Seller();
        seller2.setFirstName("Ömer");
        seller2.setLastName("Bey");
        seller2.setEmail("6961@gmail.com");
        seller2.setPhone("696969");
        sellerDAO.saveOrUpdate(seller2);

        Property property = new Property();
        property.setTitle("Dublex");
        property.setDescription("Nezih bir ortam");
        property.setType("Satılık Ev");
        property.setBathroom(3);
        property.setPrice(BigDecimal.valueOf(25_000_000));
        property.setBedroom(4);
        property.setArea(450.50F);
        property.setLocation("Ortahisar");

        //ilişki

        property.setSeller(seller);
        property.getBuyers().add(buyer);
        property.getBuyers().add(buyer2);

        propertyDAO.saveOrUpdate(property);


    }

}
